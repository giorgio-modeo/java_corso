package operatori;

public class OperatoriAritmetici {
    public static void main(String args[]){
        int x =12;
        int y =13;
        int z =14;
        int risultato;

        risultato = x+y;
        System.out.println(risultato);
        risultato = risultato-z;
        System.out.println(risultato);
        risultato = risultato*z;
        System.out.println(risultato);
        risultato = risultato/z;
        System.out.println(risultato);
        risultato = risultato%z;
        System.out.println(risultato);
        risultato = y%z;
        System.out.println(risultato);

        risultato+=z;
        System.out.println("--operatori matematici di assegniazzione--\r"+risultato);
        risultato-=z;
        System.out.println(risultato);
        risultato*=z;
        System.out.println(risultato);
        risultato/=z;
        System.out.println(risultato);
        risultato%=z;
        System.out.println(risultato);

        int a=1;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);

    }
}
