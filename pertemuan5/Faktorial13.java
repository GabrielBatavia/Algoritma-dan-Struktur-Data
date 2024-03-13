import java.util.Scanner;

public class Faktorial13 {

    public int nilai;
 
    int faktorialBF(int n){
        int fakto = 1;
        for (int i = 1; i <= n; i++) {
            fakto = fakto * 1;
        }
        return fakto;
    }

    int faktorialDC(int n) {
        if(n==1) {
            return 1;
        } else {
            int fakto = n * faktorialDC(n-1);
            return fakto;
        }
    }

    public static void main(String[] args) {
        
        Scanner sc13 = new Scanner(System.in);
        System.out.println("----------------");
        System.out.println("Masukkan Jumlah Elemen : ");
        int iJml = sc13.nextInt();

        Faktorial13[] fk13 = new Faktorial13[10];
        for (int i = 0; i < iJml; i++) {
            fk13[i] = new Faktorial13();
            System.out.println("Masukkan nilai dara ke-" + (i+1)+ ":");
            int iNilai = sc13.nextInt();
        }

        System.out.println("Hasil - Brute Force");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitunagn faktorial menggunakan Brute Forze adalah " + fk13[i].faktorialBF(fk13[i].nilai));
        }
        System.out.println("Hasil - Divide and Conquer");
        for (int i = 0; i < iJml; i++) {
            System.out.println("Hasil perhitunagn faktorial menggunakan Divide and Conquer adlaah" + fk13[i].faktorialDC(fk13[i].nilai));
        }

    }
    
}