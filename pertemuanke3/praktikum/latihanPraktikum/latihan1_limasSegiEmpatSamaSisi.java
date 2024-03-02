public class latihan1_limasSegiEmpatSamaSisi {
    private final int panjangSisiAlas;
    private final int tinggi;

    public latihan1_limasSegiEmpatSamaSisi(int panjangSisiAlas, int tinggi) {
        this.panjangSisiAlas = panjangSisiAlas;
        this.tinggi = tinggi;
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * luasAlas() * tinggi;
    }

    public double hitungLuasPermukaan() {
        return luasAlas() + hitungLuasSisiTegak();
    }

    private int luasAlas() {
        return panjangSisiAlas * panjangSisiAlas;
    }

    private double hitungLuasSisiTegak() {
        double panjangSisiMiring = Math.sqrt(Math.pow(0.5 * panjangSisiAlas, 2) + Math.pow(tinggi, 2));
        return 4 * panjangSisiAlas * panjangSisiMiring / 2;
    }
}
