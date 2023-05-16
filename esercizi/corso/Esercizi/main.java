package Esercizi;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        int[] numeri = {9, 15, 2, 36, 27, 45, 60, 6, 18};

        ArrayList<Integer> numeriList = new ArrayList<>();
        for (int num : numeri) {
            numeriList.add(num);
        }

        for (int i=0; i<numeriList.size(); i++) {
            if (numeriList.get(i) % 2 !=0 ) {
                numeriList.remove(i);
                i--;
            }
        }

        numeri = new int[numeriList.size()];
        for(int j=0;j<numeri.length;j++){
            numeri[j]=numeriList.get(j);
        }

        System.out.println(Arrays.toString(numeri));
    }
}