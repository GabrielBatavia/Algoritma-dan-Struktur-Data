package pertemuanke3.praktikum;

import java.util.Scanner;

public class persegiPanjang13 {
    public int panjang;
    public int lebar;

    public static void main(String[] args) {
        
        persegiPanjang13[] ppArray = new persegiPanjang13[3];

        Scanner sc13 = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
    
            ppArray[i] = new persegiPanjang13();
            System.out.println("Persegi panjang ke-" + i);
            System.out.println("Masukkan panjang: ");
            ppArray[i].panjang = sc13.nextInt();
            System.out.println("Masukkan lebar: ");
            ppArray[i].lebar = sc13.nextInt();
    
        }


        for (int i = 0; i < 3; i++) {
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Panjang: " + ppArray[i].panjang + ", lebar: " + ppArray[i].lebar);
        }

    }
}
