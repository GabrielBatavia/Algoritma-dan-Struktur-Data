public class Tim {
    private String nama;
    private int totalPoin;

    public Tim(String nama) {
        this.nama = nama;
        this.totalPoin = 0;
    }

    public String getNama() {
        return nama;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public void tambahPoin(int poin) {
        this.totalPoin += poin;
    }

    @Override
    public String toString() {
        return String.format("Tim{nama='%s', totalPoin=%d}", nama, totalPoin);
    }
}
