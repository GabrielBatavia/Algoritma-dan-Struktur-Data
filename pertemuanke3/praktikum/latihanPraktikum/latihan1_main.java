import java.util.Scanner;

public class latihan1_main {
    static Scanner sc13 = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bangun Ruang apa yang ingin Anda hitung?");
        System.out.println("1. Kerucut");
        System.out.println("2. Limas Segi Empat Sama Sisi");
        System.out.println("3. Bola");
        System.out.print("Masukkan Pilihan Anda : ");
        int Menu = sc13.nextInt();

        switch (Menu) {
            case 1 -> perhitunganKerucut();
            case 2 -> perhitunganLimasSegiEmpat();
            case 3 -> perhitunganBola();
            default -> System.out.println("Input yang anda masukkan tidak valid!!");
        }
    }

    private static void perhitunganKerucut() {
        System.out.print("Masukkan jumlah kerucut yang ingin Anda hitung: ");
        int jmlKerucut = sc13.nextInt();

        latihan1_kerucut[] kerucut13 = new latihan1_kerucut[jmlKerucut];
        for (int i = 0; i < kerucut13.length; i++) {
            System.out.printf("Kerucut ke-%d\n", i + 1);
            System.out.print("Masukkan panjang jari-jari: ");
            double r = sc13.nextDouble();
            System.out.print("Masukkan panjang sisi-miring: ");
            int sisiMiring = sc13.nextInt();
            kerucut13[i] = new latihan1_kerucut(r, sisiMiring);

            System.out.printf("Luas permukaan kerucut ke-%d: %.2f\n", i + 1, kerucut13[i].hitungLuasPermukaan());
            System.out.printf("Volume kerucut ke-%d: %.2f\n", i + 1, kerucut13[i].hitungVolume());
        }
    }

    private static void perhitunganLimasSegiEmpat() {
        System.out.print("Masukkan jumlah limas segi empat yang ingin Anda hitung: ");
        int jmlLimas = sc13.nextInt();

        latihan1_limasSegiEmpatSamaSisi[] limas13 = new latihan1_limasSegiEmpatSamaSisi[jmlLimas];
        for (int i = 0; i < limas13.length; i++) {
            System.out.printf("\nLimas segi empat ke-%d\n", i + 1);
            System.out.print("Masukkan panjang sisi alas: ");
            int panjangSisiAlas = sc13.nextInt();
            System.out.print("Masukkan tinggi limas: ");
            int tinggi = sc13.nextInt();
            limas13[i] = new latihan1_limasSegiEmpatSamaSisi(panjangSisiAlas, tinggi);

            System.out.printf("Luas permukaan limas ke-%d: %.2f\n", i + 1, limas13[i].hitungLuasPermukaan());
            System.out.printf("Volume limas ke-%d: %.2f\n", i + 1, limas13[i].hitungVolume());
        }
    }

    private static void perhitunganBola() {
        System.out.print("Masukkan jumlah bola yang ingin Anda hitung: ");
        int jmlBola = sc13.nextInt();

        latihan1_bola[] bola13 = new latihan1_bola[jmlBola];
        for (int i = 0; i < bola13.length; i++) {
            System.out.printf("\nBola ke-%d\n", i + 1);
            System.out.print("Masukkan panjang jari-jari: ");
            double r = sc13.nextDouble();
            bola13[i] = new latihan1_bola(r);

            System.out.printf("Luas permukaan bola ke-%d: %.2f\n", i + 1, bola13[i].hitungLuasPermukaan());
            System.out.printf("Volume bola ke-%d: %.2f\n", i + 1, bola13[i].hitungVolume());
        }
    }
}
