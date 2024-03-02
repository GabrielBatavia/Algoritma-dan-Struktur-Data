public class latihan1_kerucut{
    private double r;
    private double smiring;

    public latihan1_kerucut(double r, double smiring) {
        this.r = r;
        this.smiring = smiring;
    }

    public double cariLuas() {
        return Math.PI * r * (r + smiring);
    }

    public double cariVolume() {
        return (1.0/3) * Math.PI * r * r * smiring;
    }
}
