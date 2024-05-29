package Tugas.Tugas2;
import java.util.Scanner;

public class DaftarFilm13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);
        DoubleLinkedList13 dll = new DoubleLinkedList13();

        while (true) {
            System.out.println("====================================");
            System.out.println("DATA FILM LAYAR LEBAR");
            System.out.println("====================================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Indeks Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film-DESC");
            System.out.println("10. Keluar");
            System.out.println("====================================");
            System.out.print("Pilih: ");
            int choice = sc13.nextInt();
            sc13.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Data Film Posisi Awal\n");
                    System.out.print("ID Film: ");
                    int id1 = sc13.nextInt();
                    sc13.nextLine();  // Consume newline
                    System.out.print("Judul Film: ");
                    String title1 = sc13.nextLine();
                    System.out.print("Rating Film: ");
                    double rating1 = sc13.nextDouble();
                    dll.addFirst(id1, title1, rating1);
                    break;

                case 2:
                    System.out.print("Masukkan Data Film Posisi Akhir\n");
                    System.out.print("ID Film: ");
                    int id2 = sc13.nextInt();
                    sc13.nextLine();  // Consume newline
                    System.out.print("Judul Film: ");
                    String title2 = sc13.nextLine();
                    System.out.print("Rating Film: ");
                    double rating2 = sc13.nextDouble();
                    dll.addLast(id2, title2, rating2);
                    break;

                case 3:
                    System.out.print("Masukkan Data Film\n");
                    System.out.print("Urutan ke: ");
                    int index = sc13.nextInt();
                    sc13.nextLine();  
                    System.out.print("ID Film: ");
                    int id3 = sc13.nextInt();
                    sc13.nextLine();  
                    System.out.print("Judul Film: ");
                    String title3 = sc13.nextLine();
                    System.out.print("Rating Film: ");
                    double rating3 = sc13.nextDouble();
                    dll.add(id3, title3, rating3, index - 1);
                    break;

                case 4:
                    dll.removeFirst();
                    break;

                case 5:
                    dll.removeLast();
                    break;

                case 6:
                    System.out.print("Masukkan indeks data yang ingin dihapus: ");
                    int removeIndex = sc13.nextInt();
                    dll.remove(removeIndex - 1);
                    break;

                case 7:
                    dll.print();
                    break;

                case 8:
                    System.out.print("Masukkan ID Film yang dicari: ");
                    int searchId = sc13.nextInt();
                    Node13 found = dll.searchById(searchId);
                    if (found != null) {
                        System.out.println("ID Film: " + found.id);
                        System.out.println("Judul Film: " + found.title);
                        System.out.println("Rating Film: " + found.rating);
                    } else {
                        System.out.println("Film tidak ditemukan.");
                    }
                    break;

                case 9:
                    dll.sortDescendingByRating();
                    dll.print();
                    break;

                case 10:
                    System.out.println("Terima kasih telah menggunakan layanan ini.");
                    System.exit(0);

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}
