import java.util.Scanner;

public class latihan2_mahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mahasiswa[] daftarMahasiswa = new Mahasiswa[3]; // kita memiliki 3 mahasiswa
        
        for (int i = 0; i < daftarMahasiswa.length; i++) {
            System.out.println("Masukkan detail untuk mahasiswa ke-" + (i + 1) + ":");
            System.out.print("Masukkan Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Masukkan Jenis kelamin (L/P): ");
            char jenisKelamin = scanner.nextLine().charAt(0);
            System.out.print("Masukkan IPK: ");
            double ipk = scanner.nextDouble();
            scanner.nextLine(); 
            
            daftarMahasiswa[i] = new Mahasiswa(nama, nim, jenisKelamin, ipk);
        }

        // Menampilkan informasi mahasiswa
        System.out.println("\nInformasi Mahasiswa:");
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println(mahasiswa.dapatkanInformasi());
        }
        
        // Menghitung dan menampilkan rata-rata IPK
        double rataRataIPK = Mahasiswa.hitungRataRataIPK(daftarMahasiswa);
        System.out.printf("Rata-rata IPK: %.2f\n", rataRataIPK);
        
        // Menampilkan mahasiswa dengan IPK tertinggi
        Mahasiswa mahasiswaIPKTertinggi = Mahasiswa.cariIPKTertinggi(daftarMahasiswa);
        System.out.println("Mahasiswa dengan IPK tertinggi:");
        System.out.println(mahasiswaIPKTertinggi.dapatkanInformasi());
        
        scanner.close();
    }
}

class Mahasiswa {
    private String nama;
    private String nim;
    private char jenisKelamin;
    private double ipk;

    public Mahasiswa(String nama, String nim, char jenisKelamin, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.ipk = ipk;
    }

    public String dapatkanInformasi() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJenis kelamin: " + (jenisKelamin == 'L' ? "Laki-laki" : "Perempuan") + "\nIPK: " + ipk + "\n";
    }
    
    public static double hitungRataRataIPK(Mahasiswa[] daftarMahasiswa) {
        double total = 0;
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            total += mahasiswa.ipk;
        }
        return total / daftarMahasiswa.length;
    }
    
    public static Mahasiswa cariIPKTertinggi(Mahasiswa[] daftarMahasiswa) {
        Mahasiswa terbesar = daftarMahasiswa[0];
        for (int i = 1; i < daftarMahasiswa.length; i++) {
            if (daftarMahasiswa[i].ipk > terbesar.ipk) {
                terbesar = daftarMahasiswa[i];
            }
        }
        return terbesar;
    }
}
