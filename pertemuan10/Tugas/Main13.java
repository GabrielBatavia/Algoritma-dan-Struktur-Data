package Tugas;
import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        Scanner scanner13 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas maksimal antrian: ");
        int maxCapacity = scanner13.nextInt();
        Queue13 queue = new Queue13(maxCapacity);  // Kapasitas antrian sesuai input pengguna

        while (true) {

            System.out.println("\n\n==================================================");
            System.out.println("                       MENU                       ");
            System.out.println("==================================================");

            System.out.println("\n\n==========================================");
            System.out.println("   1. Tambahkan antrian");
            System.out.println("   2. Selesaikan antrian");
            System.out.println("   3. Tampilkan keseluruhan antrian");
            System.out.println("   4. Tampilkan antrian terdepan");
            System.out.println("   5. Tampilkan antrian paling belakang");
            System.out.println("   6. Cari data dari antrian");
            System.out.println("   7. KELUAR");
            System.out.print(" >>> ");
            int pilihan = scanner13.nextInt();
            scanner13.nextLine();  // Consume newline left-over

            switch (pilihan) {
                case 1:
                    if (queue.isFull()) {
                        System.out.println("Maaf, antrian sudah penuh!");
                    } else {
                        System.out.print("Masukkan nama: ");
                        String nama = scanner13.nextLine();
                        System.out.print("Masukkan nomor HP: ");
                        String noHP = scanner13.nextLine();
                        Pembeli13 pembeli = new Pembeli13(nama, noHP);
                        queue.enqueue(pembeli);
                    }
                    break;
                case 2:
                    Pembeli13 dihapus = queue.dequeue();
                    if (dihapus != null) {
                        System.out.println(dihapus.getNama() + " telah selesai dilayani.");
                    }
                    break;
                case 3:
                    queue.print();
                    break;
                case 4:
                    queue.peek();
                    break;
                case 5:
                    queue.peekRear();
                    break;
                case 6:
                    System.out.print("Masukkan nama yang dicari: ");
                    String nama = scanner13.nextLine();
                    queue.peekPosition(nama);
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner13.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
