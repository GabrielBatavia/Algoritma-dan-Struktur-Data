import java.util.Scanner;

public class Sum13_main {
    
    public static void main(String[] args) {
        
        Scanner sc13 = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta, Misal 5.9)");
        System.out.print("Masukkan jumlah bulan : ");
        int elm = sc13.nextInt();

        Sum13 sm = new Sum13(elm);
        System.out.println("============================================");
        for (int i = 0; i < sm.elemen; i++) {
            System.out.print("Masukkan untuk bulan ke - "+(i+1)+" = ");
            sm.keuntungan[i] = sc13.nextDouble();
        }

        System.out.println("============================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + sm.totalBF(sm.keuntungan));
        System.out.println("============================================");
        System.out.println("Algoritma Divide Conquer");
        System.out.println("Total keuntungan perusahaan selama " + sm.elemen + " bulan adalah = " + String.format("%.2f", sm.totalDC(sm.keuntungan, 0, sm.elemen-1)));
        

    }
    
}
