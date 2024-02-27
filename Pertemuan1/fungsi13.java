import java.util.Scanner;

public class fungsi13 {
    static int[] stokBrg1 = new int[4];
    static int[] stokBrg2 = new int[4];
    static int[] stokBrg3 = new int[4];
    static int[] stokBrg4 = new int[4];

    private static int hitungPendapatan() {
        int totalPendapatan = 0;
        for (int i = 0; i < stokBrg1.length; i++) {
            int jumlahStok = stokBrg1[i] + stokBrg2[i] + stokBrg3[i] + stokBrg4[i];
            switch (i) {
                case 0:
                    totalPendapatan += 75_000 * jumlahStok;
                    break;
                case 1:
                    totalPendapatan += 50_000 * jumlahStok;
                    break;
                case 2:
                    totalPendapatan += 60_000 * jumlahStok;
                    break;
                case 3:
                    totalPendapatan += 10_000 * jumlahStok;
                    break;
                default:
            }
        }
        return totalPendapatan;
    }

    private static void tampilStokBunga(int cabang) {
        System.out.println(String.format("Stok Bunga Cabang %d:", cabang));
        int[] stokBrg = switch (cabang) {
            case 1 -> stokBrg1;
            case 2 -> stokBrg2;
            case 3 -> stokBrg3;
            case 4 -> stokBrg4;
            default -> new int[0]; 
        };
        System.out.println("Algonema: " + stokBrg[0]);
        System.out.println("Keladi: " + stokBrg[1]);
        System.out.println("Alocasia: " + stokBrg[2]);
        System.out.println("Mawar: " + stokBrg[3]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi stok bunga di setiap cabang
        stokBrg1[0] = 10; stokBrg1[1] = 5; stokBrg1[2] = 15; stokBrg1[3] = 7;
        stokBrg2[0] = 6;  stokBrg2[1] = 11; stokBrg2[2] = 9;  stokBrg2[3] = 12;
        stokBrg3[0] = 2;  stokBrg3[1] = 10; stokBrg3[2] = 10; stokBrg3[3] = 5;
        stokBrg4[0] = 5;  stokBrg4[1] = 7;  stokBrg4[2] = 12; stokBrg4[3] = 9;

        System.out.println("Total pendapatan seluruh cabang (jika terjual semua): Rp " + hitungPendapatan());
        System.out.println("===================================");

        // Update stok untuk cabang 4
        stokBrg4[0] -= 1;
        stokBrg4[1] -= 2;
        stokBrg4[3] -= 5;

        // Menampilkan stok bunga
        System.out.println(
            "Pilih cabang yang ingin dilihat stoknya:\n" +
            " 1. RoyalGarden1\n" +
            " 2. RoyalGarden2\n" +
            " 3. RoyalGarden3\n" +
            " 4. RoyalGarden4\n" +
            ">>> ");
        int cabangDipilih = scanner.nextInt();

        tampilStokBunga(cabangDipilih);
    }
}
