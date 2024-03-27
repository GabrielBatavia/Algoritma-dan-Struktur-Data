import java.util.Scanner;

//import javax.sound.sampled.SourceDataLine;

public class BukuMain13 {
    
    Scanner s = new Scanner(System.in);
    Scanner s1 = new Scanner(System.in);

    PencarianBuku13 data = new PencarianBuku13();
    int jumBuku = 5;

    System.out.println("================================================");
    System.out.println("Masukkan data Buku secara Urut dari kodeBuku terkecil : ");
    for (int i = 0; i < jumBuku; i++) {
        System.out.println("Kode Buku \t: ");
        int kodeBuku = s.nextInt();
        System.out.println("Judul Buku \t: ");
        String judulBuku = s1.nextLine();
        System.out.println("Tahun terbit \t: ");
        int tahunTerbit = s.nextInt();
        System.out.println("Pengarang \t: ");
        String Pengarang = s1.nextLine();
        System.out.println("Stock \t: ");
        int stock = s.nextInt();

        Buku13 m = new Buku13(kodeBuku, judulBuku, tahunTerbit, stock, Pengarang);
        data.tambah(m);
    }

    System.out.println("================================================");
    System.out.println("Data keseluruhan Mahasiswa : ");
    

}
