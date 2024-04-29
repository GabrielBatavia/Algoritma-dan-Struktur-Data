package Tugas;


public class Pembeli13 {
    private String nama;
    private String noHP;

    public Pembeli13(String nama, String noHP) {
        this.nama = nama;
        this.noHP = noHP;
    }

    // Method untuk mendapatkan nama pembeli
    public String getNama() {
        return nama;
    }

    // Method untuk mendapatkan nomor HP pembeli
    public String getNoHP() {
        return noHP;
    }

    // Method untuk mengatur nama pembeli
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method untuk mengatur nomor HP pembeli
    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

}