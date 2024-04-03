import java.util.Scanner;

public class Utama13 {

    Gudang13 gudang = new Gudang13(7);

    Scanner sc13 = new Scanner(System.in);

    while (true) {
        System.out.println("\nMenu");
        System.out.println("1. Tambah barang");
        System.out.println("2. Ambil barang");
        System.out.println("3. Tampilkan tumpukan barang");
        System.out.println("4. Keluar");
        System.out.println("Pilih operasi : ");
        int pilihan = sc13.nextInt();
        sc13.nextLine();

        switch (pilihan) {
            case 1:
                System.out.println("Masukkan kode barang: ");
                int kode = sc13.nextInt();
                sc13.nextLine();
                System.out.println("Masukkan nama barang: ");
                String nama = sc13.nextLine();
                System.out.println("Masukkan nama kategori: ");
                String kategori = sc13.nextLine();
                Barang13 barangBaru = new Barang13(kode, nama, kategori);
                gudang.tambahBarang(barangBaru);
                break;

            case 2:
                gudang.ambilBarang();
                break;
            
            case 3:
            gudang.tampilkanBarang();
            break;

            case 4:
                break;
            
            default :
            System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
        }
    }
}
