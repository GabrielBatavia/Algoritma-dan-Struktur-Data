import java.util.Scanner;

//import javax.sound.sampled.SourceDataLine;

public class BukuMain13 {
    
    public static void main(String[] args) {
    

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku13 data = new PencarianBuku13();
        int jumBuku = 5;

        System.out.println("================================================");
        System.out.println("Masukkan data Buku secara Urut dari kodeBuku terkecil : ");
        
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            String kodeBuku = s1.nextLine();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t: ");
            int stock = s.nextInt();

            Buku13 m = new Buku13(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }

        System.out.println("================================================");
        System.out.println("Data keseluruhan Mahasiswa : ");

        System.out.println("----------------------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("________________________________________________________________");
        System.out.println("________________________________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Kode Buku yang dicari: ");
        System.out.print("Kode Buku : ");
        String cari = s1.nextLine();

        System.out.println("Menggunakan Sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);

        data.TampilData(cari, posisi);

        System.out.println("================================================================");
        System.out.println("Menggunakan Binary Search");
        posisi = data.FindBinarySearch(cari, 0, jumBuku -1);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);

        System.out.println(
            "=========================================================\n" +
            "Sequential search ke 2"
        );
        
        //Buku13 dataBuku = data.findBuku(cari);
        //dataBuku.tampilDataBuku();

        int left = 0;
        int right = jumBuku;

        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("Pencarian Judul Buku: ");
        System.out.println("Masukkan Judul buku yang dicari");
        System.out.print("Judul Buku: ");
        String cariJudul = s1.nextLine();

        System.out.println("Menggunakan sequential search");
        int posisiJudulSeq = data.FindSeqSearchJudul(cariJudul);
        System.out.println("seq: " + posisiJudulSeq);
        data.Tampilposisi(cariJudul, posisiJudulSeq);

        System.out.println("Menggunakan binary search");
        int posisiJudulBin = data.FindBinarySearchJudul(cariJudul, left, right);
        System.out.println("binary: " + posisiJudulBin);
        data.Tampilposisi(cariJudul, posisiJudulBin);

        data.TampilDataJudul(cariJudul, posisiJudulSeq);

        
    }

}
