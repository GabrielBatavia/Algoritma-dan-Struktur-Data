public class latihan1_bola {
    private double r;

    public latihan1_bola(double r) {
        this.r = r;
    }

    public double getSurfaceArea() {
        return 4 * Math.PI * r * r;
    }

    public double cariVolume() {
        return (4.0/3) * Math.PI * Math.pow(r, 3);
    }
}
