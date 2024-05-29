package Tugas.Tugas1;
import java.util.Scanner;

public class AntrianVaksin13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);
        DoubleLinkedLists13 dll = new DoubleLinkedLists13();

        while (true) {
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.println("1. Tambah Data Penerima Vaksin");
            System.out.println("2. Hapus Data Pengganti Vaksin");
            System.out.println("3. Daftar Penerima Vaksin");
            System.out.println("4. Keluar");
            System.out.println("+++++++++++++++++++++++++++++++");
            System.out.print("Pilih: ");
            int choice = sc13.nextInt();
            sc13.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Data Penerima Vaksin\n");
                    System.out.print("Nomor Antrian: ");
                    int number = sc13.nextInt();
                    sc13.nextLine();  
                    System.out.print("Nama Penerima: ");
                    String name = sc13.nextLine();
                    dll.addLast(number, name);
                    break;

                case 2:
                    try {
                        dll.removeFirst();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    dll.print();
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan ini.");
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
