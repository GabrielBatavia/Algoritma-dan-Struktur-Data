public class latihan1_limasSegiEmpatSamaSisi {
    private double alas;
    private double tinggi;

    public latihan1_limasSegiEmpatSamaSisi(double alas, double height) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getSurfaceArea() {
        double luasAlas = alas * alas;
        double smiring = Math.sqrt((alas / 2) * (alas / 2) + (tinggi * tinggi));
        return luasAlas + (alas * smiring) * 2;
    }

    public double cariVolume() {
        return (alas * alas * tinggi) / 3;
    }
}
