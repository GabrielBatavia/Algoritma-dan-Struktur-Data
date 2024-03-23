import java.util.Scanner;

public class Mahasiswa_main {
    public static void main(String[] args) {
        
        DaftarMahasiswaBerprestasi13 list = new DaftarMahasiswaBerprestasi13();
        Mahasiswa13 mhs1 = new Mahasiswa13("Nusa", 2017, 25, 3);
        Mahasiswa13 mhs2 = new Mahasiswa13("Rara", 2012, 19, 4);
        Mahasiswa13 mhs3 = new Mahasiswa13("Dompu", 2018, 19, 3.5);
        Mahasiswa13 mhs4 = new Mahasiswa13("Abdul", 2017, 23, 2);
        Mahasiswa13 mhs5 = new Mahasiswa13("Ummi", 2019, 21, 3.75);

        
        list.tambah(mhs1);
        list.tambah(mhs2);
        list.tambah(mhs3);
        list.tambah(mhs4);
        list.tambah(mhs5);

        System.out.println("Data mahasiswa sebelum sorting = ");
        list.tampil();

        System.out.println("Data mahasiswa setelah sorting desc berdasarkan IPK (BUBBLE SORT)");
        list.bubbleSort();
        list.tampil();

        System.out.println("Data Mahasiswa setelah sorting asc berdasarkan ipk");
        list.selectionSort();
        list.tampil();

        System.out.println("Data Mahasiswa setelah sorting asc berdasarkan ipk");
        list.selectionSort();
        list.tampil();
    }
}
