package Esercizi;

public class main {
    public static void main(String[] args) {
        String names[] = {"rosso", "blu","verde","grigio","arancione","bianco","nero"};
        String stringToFind = "nero";
        boolean p = false;

        for (String i : names) {
            if (i.equals(stringToFind)) {
                p = true;
            }
        }
        if (p == true){
            System.out.println("nero e presente nella lista");
        }
        else{
            System.out.println("nero non e presente nella lista");
        }


        System.out.println("--- esercizzio 2 ---");
        int interi[]= {9,8,4,2,7,5,8,10};
        double sum =0;
        for (int i = 0; i < interi.length; i++) {
            sum += Double.valueOf(interi[i]);
        }
        double average = sum/ interi.length;
        System.out.println("la media e: "+average);


        System.out.println("--- esercizzio 3 ---");
        // non fatto
        System.out.println("--- esercizzio 4 ---");


        Mesi mese = Mesi.NOVEMBRE;
        switch (mese.ordinal()+1){
            case 1:
                System.out.println("il mese e gennaio");
            case 2:
                System.out.println("il mese e febbraio");
            case 11:
                System.out.println("il mese e"+Mesi.NOVEMBRE);
        }

    }
    public enum Mesi{
        GENNAIO,FEBBRAIO,MARZO,APRILE,MAGGIO,GIOGNO,LUGLIO,AGOSTO,SETTEMBRE,OTTOBRE,NOVEMBRE,DICEMBRE
    }
}