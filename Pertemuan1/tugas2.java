import java.util.Scanner;

public class tugas2 {
    private static final Scanner input = new Scanner(System.in);
    private static float kecepatan, jarak, waktu;
    private static int pilihanUlang;

    public static void main(String[] args) {
        tampilkanMenuPerhitungan();
    }

    private static void tampilkanMenuPerhitungan() {
        do {
            System.out.println("\nApa yang ingin Anda hitung?");
            System.out.println("   1. Kecepatan");
            System.out.println("   2. Jarak");
            System.out.println("   3. Waktu");
            System.out.print("Masukkan pilihan: ");

            int pilihanMenu = input.nextInt();
    
            switch (pilihanMenu) {
                case 1:
                    hitungKecepatan();
                    break;
                case 2:
                    hitungJarak();
                    break;
                case 3:
                    hitungWaktu();
                    break;
                default:
                    tampilkanPesanInputTidakValid();
                    break;
            }

            System.out.println("\nApakah Anda ingin menghitung lagi?");
            System.out.println("   1. YA");
            System.out.println("   2. TIDAK");
            System.out.print("Masukkan pilihan: ");
            pilihanUlang = input.nextInt();
        } while (pilihanUlang == 1);
    }

    private static void hitungKecepatan() {
        System.out.print("Masukkan jarak (dalam km): ");
        jarak = input.nextFloat();
        System.out.print("Masukkan waktu (dalam jam): ");
        waktu = input.nextFloat();

        kecepatan = jarak / waktu;
        System.out.printf("Kecepatan yang dihitung adalah: %.2f km/jam%n", kecepatan);
    }

    private static void hitungJarak() {
        System.out.print("Masukkan kecepatan (dalam km/jam): ");
        kecepatan = input.nextFloat();
        System.out.print("Masukkan waktu (dalam jam): ");
        waktu = input.nextFloat();

        jarak = kecepatan * waktu;
        System.out.printf("Jarak yang ditempuh adalah: %.2f km%n", jarak);
    }

    private static void hitungWaktu() {
        System.out.print("Masukkan jarak (dalam km): ");
        jarak = input.nextFloat();
        System.out.print("Masukkan kecepatan (dalam km/jam): ");
        kecepatan = input.nextFloat();

        waktu = jarak / kecepatan;
        System.out.printf("Waktu yang dibutuhkan adalah: %.2f jam%n", waktu);
    }

    private static void tampilkanPesanInputTidakValid() {
        System.out.println("Input tidak valid!");
    }
}
