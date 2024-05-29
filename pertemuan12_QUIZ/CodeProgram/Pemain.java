public class Pemain {
    private String nama;
    private int poin;
    private Tim tim;

    public Pemain(String nama, Tim tim) {
        this.nama = nama;
        this.poin = 0;
        this.tim = tim;
    }

    public String getNama() {
        return nama;
    }

    public int getPoin() {
        return poin;
    }

    public Tim getTim() {
        return tim;
    }

    public void tambahPoin(int poin) {
        this.poin += poin;
        if (tim != null) {
            tim.tambahPoin(poin);
        }
    }

    @Override
    public String toString() {
        return String.format("Pemain{nama='%s', poin=%d, tim=%s}", nama, poin, tim.getNama());
    }
}
