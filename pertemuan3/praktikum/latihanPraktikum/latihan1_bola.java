public class latihan1_bola {
    private final double r;

    public latihan1_bola(double r) {
        this.r = r;
    }

    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
    }

    public double hitungLuasPermukaan() {
        return 4 * Math.PI * Math.pow(r, 2);
    }
}
