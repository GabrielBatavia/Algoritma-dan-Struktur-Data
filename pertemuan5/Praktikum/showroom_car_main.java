import java.util.Scanner;

public class showroom_car_main {
    public static void main(String[] args) {
        showroom showroomMobil = new showroom();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di program showroom mobil.");
        System.out.println("Pilih operasi yang ingin Anda lakukan:");
        System.out.println("1. Temukan mobil tercepat");
        System.out.println("2. Temukan mobil terlambat");
        System.out.println("3. Hitung rata-rata kecepatan mobil");

        System.out.print("Masukkan pilihan Anda (1/2/3): ");
        int pilihan = scanner.nextInt();

        switch (pilihan) {
            case 1:
                showroomMobil.temukanMobilTercepat();
                break;
            case 2:
                showroomMobil.temukanMobilTerlambat();
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
