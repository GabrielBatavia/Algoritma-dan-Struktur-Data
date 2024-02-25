public class Buku13 {
    String judul, pengarang;
    int halaman, stock, harga, terjual;
    

    void tampilInformasi () {

        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stock: " + stock);
        System.out.println("Harga: Rp " + harga );
        System.out.println("Terjual: " + terjual);
        System.out.println("Harga Total: Rp " + hitungHargaTotal());
        System.out.println("Diskon: Rp " + hitungDiskon());
        System.out.println("Harga Bayar: Rp " + hitungHargaBayar());
    }

    void terjual(int jml) {
        terjual = jml;
        if (stock > 0 ) {
            stock -= jml;
        }
    }

    void restock(int jml) {
        stock += jml;
    }

    void gantiharga(int hrg) {
        harga = hrg;
    }

    int hitungHargaTotal() {
        return terjual * harga;
    }

    double hitungDiskon() {
        int hargaTotal = hitungHargaTotal(); 
        if (hargaTotal > 150000) {
            return hargaTotal * 0.12;
        } else if (hargaTotal >= 75000 && hargaTotal <= 150000) {
            return hargaTotal * 0.05;
        } else {
            return 0;
        }
    }

    double hitungHargaBayar() {
        int hargaTotal = hitungHargaTotal(); 
        double diskon = hitungDiskon(); 
        return hargaTotal - diskon;
    }


    public Buku13() {
    }

    public Buku13(String jud, String pg, int hal, int stock, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stock = stock;
        harga = har;
    }

}
