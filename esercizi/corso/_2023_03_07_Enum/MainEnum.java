package _2023_03_07_Enum;

public class MainEnum {
    public static void main(String args[]){
        System.out.println(Settimana.MARTEDI.toString());

        for (Settimana s : Settimana.values()) {
            System.out.println(s);
        }
            //Settimana s = Settimana.valueOf("AGOSTO");
            //"AGOSTO " non e presente nell'enum e quindi viene sollevata un eccezzione di tipo illegalargument
            System.out.println("-- ordinalita di enum --");
            System.out.println(Settimana.MARTEDI + "ha ordinata " + Settimana.MARTEDI.ordinal());

            System.out.println("-- utilizzo avanzato di enum --");
            System.out.println(RosaDeiVenti.SUD + "viene abbreviato in "+RosaDeiVenti.SUD.getAbbreviazzione());

            for (RosaDeiVenti r : RosaDeiVenti.values()) {
                System.out.println(r.ordinal() + " " +r+" "+r.getAbbreviazzione());
            }

    }
    public enum Settimana{
        LUNEDI,MARTEDI,MERCOLEDI,GIOVEDI,VENERDI,SABATO,DOMENICA
    }
    public enum RosaDeiVenti{
        NORD('N'), EST('E'), SUD('S'), OVEST('O');

        private char abbreviazzione;

        public char getAbbreviazzione() {
            return abbreviazzione;
        }
        RosaDeiVenti(char abbreviazzione) {
            this.abbreviazzione = abbreviazzione;
        }
    }
}
