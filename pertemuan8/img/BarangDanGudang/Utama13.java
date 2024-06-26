import java.util.Scanner;

public class Utama13 {

    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);
    
        Gudang13 gudang = new Gudang13(7);
    
    
        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Tambah barang");
            System.out.println("2. Ambil barang");
            System.out.println("3. Tampilkan tumpukan barang");
            System.out.println("4. Tampilkan barang teratas");
            System.out.println("5. Tampilkan barang terbwah");
            System.out.println("6. Cari Barang");
            System.out.println("7. Keluar");
            System.out.print("Pilih operasi : ");
            int pilihan = sc13.nextInt();
            sc13.nextLine();
    
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = sc13.nextInt();
                    sc13.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = sc13.nextLine();
                    System.out.print("Masukkan nama kategori: ");
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
                    gudang.lihatBarangTeratas();
                    break;
                
                case 5:
                    gudang.lihatBarangTerbawah();
                    break;
                
                case 6:
                    System.out.println("Masukkan kata kunci:");
                    String kataKunci = sc13.nextLine(); 
                    gudang.cariBarang(kataKunci);
                    break;

                case 7:
                    sc13.close(); 
                    return; // keluar dari program
                
                default :
                System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    
    }

}


