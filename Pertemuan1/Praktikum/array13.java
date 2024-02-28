import java.util.Scanner;

public class array13 {
    public static void main(String[] args) {
        Scanner scan13 = new Scanner(System.in);
        // Deklarasi variabel
        double[] nilaiAngka = new double[8];
        String[] nilaiHuruf = new String[nilaiAngka.length];
        double[] nilaiSetara = new double[nilaiAngka.length];

        // Pengguna input nilai
        System.out.println("==============================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("==============================");
        System.out.print("Masukkan nilai angka untuk MK Pancasila : ");
        nilaiAngka[0] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Konsep Teknologi Informasi : ");
        nilaiAngka[1] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Critical Thinking dan Problem Solving : ");
        nilaiAngka[2] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Matematika Dasar : ");
        nilaiAngka[3] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Bahasa Inggris : ");
        nilaiAngka[4] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Dasar Pemrograman : ");
        nilaiAngka[5] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Praktikum Dasar Pemrograman : ");
        nilaiAngka[6] = scan13.nextInt();
        System.out.print("Masukkan nilai angka untuk MK Keselamatan dan Kesehatan Kerja : ");
        nilaiAngka[7] = scan13.nextInt();


        // Proses konversi nilai
        for (int i = 0; i < nilaiAngka.length; i++) {
            if (nilaiAngka[i] > 80) {
                nilaiHuruf[i] = "A";
                nilaiSetara[i] = 4;
            } else if (nilaiAngka[i] > 73) {
                nilaiHuruf[i] = "B+";
                nilaiSetara[i] = 3.5;
            } else if (nilaiAngka[i] > 65) {
                nilaiHuruf[i] = "B";
                nilaiSetara[i] = 3;
            } else if (nilaiAngka[i] > 60) {
                nilaiHuruf[i] = "C+";
                nilaiSetara[i] = 2.5;
            } else if (nilaiAngka[i] > 50) {
                nilaiHuruf[i] = "C";
                nilaiSetara[i] = 2;
            } else if (nilaiAngka[i] > 39) {
                nilaiHuruf[i] = "D";
                nilaiSetara[i] = 1;
            } else {
                nilaiHuruf[i] = "E";
                nilaiSetara[i] = 0;
            }
        }


        System.out.println("==============================");
        System.out.println("Hasil Konversi Nilai");
        System.out.println("==============================");
        System.out.println("MK\t\t\t\t\tNilai Angka\t\tNilai Huruf\t\tBobot Nilai");
        System.out.println("Pancasila\t\t\t\t"+nilaiAngka[0]+"\t\t\t"+nilaiHuruf[0]+"\t\t\t"+nilaiSetara[0]);
        System.out.println("Konsep Teknologi Informasi\t\t"+nilaiAngka[1]+"\t\t\t"+nilaiHuruf[1]+"\t\t\t"+nilaiSetara[1]);
        System.out.println("Critical Thinking dan Problem Solving\t"+nilaiAngka[2]+"\t\t\t"+nilaiHuruf[2]+"\t\t\t"+nilaiSetara[2]);
        System.out.println("Matematika Dasar\t\t\t"+nilaiAngka[3]+"\t\t\t"+nilaiHuruf[3]+"\t\t\t"+nilaiSetara[3]);
        System.out.println("Bahasa Inggris\t\t\t\t"+nilaiAngka[4]+"\t\t\t"+nilaiHuruf[4]+"\t\t\t"+nilaiSetara[4]);
        System.out.println("Dasar Pemrograman\t\t\t"+nilaiAngka[5]+"\t\t\t"+nilaiHuruf[5]+"\t\t\t"+nilaiSetara[5]);
        System.out.println("Praktikum Dasar Pemrograman\t\t"+nilaiAngka[6]+"\t\t\t"+nilaiHuruf[6]+"\t\t\t"+nilaiSetara[6]);
        System.out.println("Keselamatan dan Kesehatan Kerja\t\t"+nilaiAngka[7]+"\t\t\t"+nilaiHuruf[7]+"\t\t\t"+nilaiSetara[7]);
    }

}