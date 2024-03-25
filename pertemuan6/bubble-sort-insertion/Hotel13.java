public class Hotel13 {
    String nama;
    String kota;
    int harga;
    byte bintang;

    // Konstruktor
    public Hotel13(String n, String k, int h, byte b) {
        nama = n;
        kota = k;
        harga = h;
        bintang = b;
    }

    // hotel detail
    public void tampilkanInfo() {
        System.out.println(nama + ", " + kota + " - Harga: " + harga + ", Rating: " + bintang + " bintang");
    }
}