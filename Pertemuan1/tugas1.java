import java.util.Scanner;

public class tugas1 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final char[] KODE_PLAT = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
    private static final char[][] NAMA_KOTA = new char[10][12];

    public static void main(String[] args) {
        inisialisasiKota();
        prosesInputPlatNomor();
    }

    private static void inisialisasiKota() {
        // Isi nama-nama kota sesuai dengan kode plat
        String[] namaKota = {
            "BANTEN", "JAKARTA", "BANDUNG", "CIREBON", "BOGOR", 
            "PEKALONGAN", "SEMARANG", "SURABAYA", "MALANG", "TEGAL"
        };

        for (int i = 0; i < namaKota.length; i++) {
            for (int j = 0; j < namaKota[i].length(); j++) {
                NAMA_KOTA[i][j] = namaKota[i].charAt(j);
            }
        }
    }

    private static void prosesInputPlatNomor() {
        int ulangi = 1;
        do {
            System.out.print("Masukkan kode plat nomor: ");
            String input = scanner.next().toUpperCase();

            if (input.length() > 0 && new String(KODE_PLAT).indexOf(input.charAt(0)) != -1) {
                tampilkanNamaKota(input.charAt(0));
            } else {
                System.out.println("====================\n INPUT TIDAK VALID!\n====================");
            }

            System.out.print("\nInput ulang?\n1. YA\n2. TIDAK\nPilihan: ");
            if (scanner.hasNextInt()) {
                ulangi = scanner.nextInt();
            } else {
                scanner.next(); // Mengonsumsi input yang tidak valid
                ulangi = 0; // Menghentikan loop
            }
        } while (ulangi == 1);
    }

    private static void tampilkanNamaKota(char kodePlat) {
        int index = new String(KODE_PLAT).indexOf(kodePlat);
        if (index != -1) {
            System.out.print(" - ");
            for (char huruf : NAMA_KOTA[index]) {
                System.out.print(huruf);
            }
            System.out.println("\n");
        }
    }
}
