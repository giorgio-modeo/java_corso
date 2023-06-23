package it.ictpiemonte.immobiliare.service;

import it.ictpiemonte.immobiliare.entity.Annuncio;
import it.ictpiemonte.immobiliare.entity.AnnuncioId;
import it.ictpiemonte.immobiliare.entity.Immobile;
import it.ictpiemonte.immobiliare.payload.request.AnnuncioRequest;
import it.ictpiemonte.immobiliare.payload.response.AnnuncioHomeResponse;
import it.ictpiemonte.immobiliare.repository.AnnuncioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AnnuncioService {

    private final AnnuncioRepository annuncioRepository;
    private final ImmobileService immobileService;
    public AnnuncioService(AnnuncioRepository annuncioRepository, ImmobileService immobileService) {
        this.annuncioRepository = annuncioRepository;
        this.immobileService = immobileService;
    }

    public ResponseEntity<?> saveAnnuncio(AnnuncioRequest request){
        // generare l'entità Annuncio partendo dalla request
        // ma per far ciò devo verificare che l'immobile esista
        Annuncio a = fromRequestToEntity(request);
        if(a.getTestoAnnuncio() != null) {
            // se sì, salvo l'entità
            annuncioRepository.save(a);
            return new ResponseEntity(a, HttpStatus.CREATED);
        } else
            return new ResponseEntity("Immobile no trovato", HttpStatus.BAD_REQUEST);
    }

    public Annuncio fromRequestToEntity(AnnuncioRequest request){
        Immobile i = immobileService.findById(request.getImmobileId());
        Annuncio a = new Annuncio();
        if(i != null){
            a.setAnnuncioId(new AnnuncioId(i));
            a.setTestoAnnuncio(request.getAnnuncio());
            a.setTitoloAnnuncio(request.getTitle());
        }
        return a;
    }

    public ResponseEntity<?> getAnnunciHomePage(String provinciaId,
            int pageNumber, //numero della pagina da cui partire
            int pageSize, // numero di elementi per pagina
            String direction, // ordinamento ASC o DESC
            String sortBy // la colonna su cui effettuare l'ordinamento
     ){
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.valueOf(direction.toUpperCase()), sortBy);
        Page<AnnuncioHomeResponse> pageResult = annuncioRepository.getAnnunciHomePage(pageable, provinciaId);
        List<AnnuncioHomeResponse> list = new ArrayList<>();
        if(pageResult.hasContent())
            list = pageResult.getContent();

        return new ResponseEntity(list, HttpStatus.OK);
    }

    public ResponseEntity<?> getAnnuncioDetail(int id){
        return new ResponseEntity(annuncioRepository.getAnnuncioDetail(id), HttpStatus.OK);
    }

    /* ************ UPLOAD IMAGE ************ */

    private boolean checkSize(MultipartFile file, long imageSize){
        if(!file.isEmpty() && file.getSize() <=  imageSize)
            return true;
        return false;
    }

    public BufferedImage fromMultipartFileToBufferedImage(MultipartFile file){
        BufferedImage bf = null;
        try{
            bf = ImageIO.read(file.getInputStream());
        } catch(IOException e){
            log.error("Trasformazione inn BufferedImage non riuscita");
        }
        return bf;
    }

    private boolean checkDimension(BufferedImage bf, int height, int width){
        if(bf == null)
            return false;
        return bf.getWidth() <= width && bf.getHeight() <= height;
    }

    private boolean checkExtensions(MultipartFile file, String[] extensions){
        String filename = file.getOriginalFilename();
        String ext = filename.substring(filename.lastIndexOf(".")+1);
        for(String extension : extensions){
            if(extension.equals(ext))
                return true;
        }
        return false;
    }

    public ResponseEntity<?> addImage(MultipartFile file, int height, int width, long imageSize, String[] extensions){

        if(!checkExtensions(file, extensions))
            return new ResponseEntity("L'immagine non è del tipo consentito", HttpStatus.BAD_REQUEST);

        if(!checkSize(file, imageSize))
            return new ResponseEntity("L'immagine è troppo grande: maggiore di "+imageSize+" bytes oppure il file è vuoto", HttpStatus.BAD_REQUEST);

        BufferedImage bf = fromMultipartFileToBufferedImage(file);
        if(!checkDimension(bf, height, width))
            return new ResponseEntity("L'immagine ha dimensioni errate", HttpStatus.BAD_REQUEST);

        return new ResponseEntity("Immagine OK", HttpStatus.OK);
    }


}
