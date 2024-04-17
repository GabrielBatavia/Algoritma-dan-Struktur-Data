public class latihan1_kerucut {
    private final double r;
    private final int sisiMiring;

    public latihan1_kerucut(double r, int sisiMiring) {
        this.r = r;
        this.sisiMiring = sisiMiring;
    } 

    public double hitungTinggi() {
        return Math.sqrt(Math.pow(sisiMiring, 2) - Math.pow(r, 2));
    }

    public double hitungLuasPermukaan() {
        return Math.PI * r * (sisiMiring + r);
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(r, 2) * hitungTinggi();
    }
}
