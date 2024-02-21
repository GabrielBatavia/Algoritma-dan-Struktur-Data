public class Buku13 {
    String judul, pengarang;
    int halaman, stock, harga;

    void tampilInformasi () {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stock: " + stock);
        System.out.println("Harga: Rp " + harga );
    }

    void terjual(int jml) {
        stock -= jml;
    }

    void restock(int jml) {
        stock += jml;
    }

    void gantiharga(int hrg) {
        harga = hrg;
    }

    public static void main(String[] args) {
        Buku13 myBook = new Buku13();
        
        myBook.tampilInformasi();
        
    }
}
