### 5.2.1 Program

```java

public class Mahasiswa13 {
    String nama;
    int thnMasuk, umur;
    double ipk;

    Mahasiswa13(String n, int t, int u, double i) {
        nama = n;
        thnMasuk = t;
        umur = u;
        ipk = i;
    }

    void tampil() {
        System.out.println("Nama = " + nama);
        System.out.println("Tahun Masuk = " + thnMasuk);
        System.out.println("Umur = " + umur);
        System.out.println("IPK = " + ipk);
    }


}


```

<br>

```java

public class DaftarMahasiswaBerprestasi13 {
    Mahasiswa13 listMhs[] = new Mahasiswa13[5];
    int idx;

    void tambah(Mahasiswa13 m) {
        if(idx<listMhs.length){
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data sudah penuh!!");
        }
    }

    void tampil(){
        for(Mahasiswa13 m : listMhs){
            m.tampil();
            System.out.println("================================================================");
        }
    }

    void bubbleSort(){
        for(int i=0; i<listMhs.length-1; i++){
            for(int j=1; j<listMhs.length-i; j++){
                if(listMhs[j].ipk > listMhs[j-1].ipk){
                    Mahasiswa13 tmp = listMhs[j];
                    listMhs[j] = listMhs[j-1];
                    listMhs[j-1] = tmp;
                }
            }
        }
    }
}


```

<br>

```java

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
    }
}


```

<br>

### 5.2.2 Hasil