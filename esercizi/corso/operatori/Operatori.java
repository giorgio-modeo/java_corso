package operatori;

public class Operatori {
    public static void main(String args[]){
        String nome = "mario";
        String cognome ="rossi";

        String nomeEcognome = nome+" "+cognome;
        System.out.println(nomeEcognome);
        String nomeEcognome2 = nome.concat(" ").concat(cognome);
        System.out.println(nomeEcognome2);


    }

}
