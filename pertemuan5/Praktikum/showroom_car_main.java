import java.util.Scanner;

public class showroom_car_main {
    public static void main(String[] args) {
        showroom showroomMobil = new showroom();
        Scanner sc13 = new Scanner(System.in);

        System.out.println("================================================================");
        System.out.println("Selamat datang di program showroom mobil.");
        System.out.println("================================================================");
        System.out.println("Pilih operasi yang ingin Anda lakukan:");
        System.out.println("1. Temukan mobil tercepat dengan DC");
        System.out.println("2. Temukan mobil terlambat dengan DC");
        System.out.println("3. Hitung rata-rata kecepatan mobil");
        System.out.println("================================================================");

        System.out.print("Masukkan pilihan Anda (1/2/3): ");
        int pilihan = sc13.nextInt();

        switch (pilihan) {
            case 1:
                car13 mobilTercepatDC = showroomMobil.temukanMobilTercepatDC(0, showroomMobil.carArray13.length - 1);
                System.out.println("Mobil tercepat dengan DC adalah: " + mobilTercepatDC.merk + " " + mobilTercepatDC.tipe);
                break;
            case 2:
                car13 mobilTerlambatDC = showroomMobil.temukanMobilTerlambatDC(0, showroomMobil.carArray13.length - 1);
                System.out.println("Mobil terlambat dengan DC adalah: " + mobilTerlambatDC.merk + " " + mobilTerlambatDC.tipe);
                break;
            case 3:
                showroomMobil.hitungRataRataKecepatan();
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1, 2, atau 3.");
                break;
        }
    }
}