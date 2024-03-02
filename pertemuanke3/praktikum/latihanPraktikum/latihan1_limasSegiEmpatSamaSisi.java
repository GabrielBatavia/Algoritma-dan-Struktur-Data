public class latihan1_limasSegiEmpatSamaSisi {
    private double salas;
    private double tinggi;

    public latihan1_limasSegiEmpatSamaSisi(double salas, double height) {
        this.salas = salas;
        this.tinggi = tinggi;
    }

    public double getSurfaceArea() {
        double luasAlas = salas * salas;
        double smiring = Math.sqrt((salas / 2) * (salas / 2) + (tinggi * tinggi));
        return luasAlas + (salas * smiring) * 2;
    }

    public double cariVolume() {
        return (salas * salas * tinggi) / 3;
    }
}
