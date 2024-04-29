

public class Pembeli13 {
    private String nama;
    private int noHP;

    public Pembeli13(String nama, int noHP) {
        this.nama = nama;
        this.noHP = noHP;
    }

    // Method untuk mendapatkan nama pembeli
    public String getNama() {
        return nama;
    }

    // Method untuk mendapatkan nomor HP pembeli
    public int getNoHP() {
        return noHP;
    }

    // Method untuk mengatur nama pembeli
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method untuk mengatur nomor HP pembeli
    public void setNoHP(int noHP) {
        this.noHP = noHP;
    }

}