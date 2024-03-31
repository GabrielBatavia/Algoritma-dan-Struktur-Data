### 6.2.1 Program

```java

public class Buku13 {
    int kodeBuku;
    String judulBuku;
    int tahunTerbit;
    String pengarang;
    int stock;

    public Buku13(int kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku() {
        System.out.println("================================");
        System.out.println("Kode Buku: " + kodeBuku);
        System.out.println("Judul Buku: " +judulBuku);
        System.out.println("Tahun Terbit: " + tahunTerbit);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Stock: " + stock);
    }
}

```

<br>

```java

public class PencarianBuku13 {
    Buku13 listBk[] = new Buku13[5];
    int idx;

    void tambah(Buku13 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else{
        System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (Buku13 m : listBk) {
            m.tampilDataBuku();
        }
    }

    public int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int j  = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public void Tampilposisi(int x, int pos)
    {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void TampilData(int x, int pos)
    {
        if (pos != -1) {
            System.out.println("Kode Buku \t: " + x );
            System.out.println("Judul \t : " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit \t: " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang \t: " + listBk[pos].pengarang);
            System.out.println("Stock \t: " + listBk[pos].stock);
        } else {
            System.err.println("data " + x + "tidak ditemukan");
        }
    }
}


```

<br>

```java

import java.util.Scanner;

public class BukuMain13 {
    
    public static void main(String[] args) {
    

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        PencarianBuku13 data = new PencarianBuku13();
        int jumBuku = 5;

        System.out.println("================================================");
        System.out.println("Masukkan data Buku secara Urut dari kodeBuku terkecil : ");
        
        for (int i = 0; i < jumBuku; i++) {
            System.out.print("Kode Buku \t: ");
            int kodeBuku = s.nextInt();
            System.out.print("Judul Buku \t: ");
            String judulBuku = s1.nextLine();
            System.out.print("Tahun terbit \t: ");
            int tahunTerbit = s.nextInt();
            System.out.print("Pengarang \t: ");
            String pengarang = s1.nextLine();
            System.out.print("Stock \t: ");
            int stock = s.nextInt();

            Buku13 m = new Buku13(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
            data.tambah(m);
        }

        System.out.println("================================================");
        System.out.println("Data keseluruhan Mahasiswa : ");

        System.out.println("----------------------------------------------------------------");
        System.out.println("Data keseluruhan Buku : ");
        data.tampil();

        System.out.println("________________________________________________________________");
        System.out.println("________________________________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan Kode Buku yang dicari: ");
        System.out.print("Kode Buku : ");
        int cari = s.nextInt();
        System.out.println("Menggunakan Sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.Tampilposisi(cari, posisi);

        data.TampilData(cari, posisi);
        
    }

}


```

<br>

### 6.2.2 Hasil

<br>

<img src="./img/image.png">

<br>

<img src="./img/image_1.png">

<br>

<img src="./img/image_2.png">

<br>

### 6.2.3 Pertanyaan

1. Jelaskan fungsi break yang ada pada method FindSeqSearch! <br>

Jawab : Fungsi break pada FindSeqSearch ataupun pada gerenal kode adalah untuk menghentikan perulangan, dalam hal ini digunakan untuk menghentikan perulangan pencarian ketika index dari nilai yang kita cari sudah ditemukan.

2. Jika Data Kode Buku yang dimasukkan tidak terurut dari kecil ke besar. Apakah program masih 
dapat berjalan? Apakah hasil yang dikeluarkan benar? Tunjukkan hasil screenshoot untuk bukti 
dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?  <br>

Jawab : Meski data kita adalah data acak, program tetap bisa mencari data yang diinginkan. Ini adalah buktinya:

<img src="./img/image_1.png">

<img src="./img/image_2.png">

Hal ini terjadi karena proses pencarian menggunakan sequential search yang mana program akan mengecek satu persatu nilai yang ada dari setiap elemen array. Jadi, meski data yang ada acak, tidak akan berpengaruh pada proses pencarian data.

3. Buat method baru dengan nama FindBuku menggunakan konsep sequential search dengan tipe 
method dari FindBuku adalah BukuNoAbsen.  Sehingga Anda bisa memanggil method 
tersebut pada class BukuMain seperti gambar berikut : <br>

```java
Buku dataBuku = data.findBuku(cari);
dataBuku.tampilDataBuku();
```







### 6.3.1 Program

```java

    public int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (right) / 2;
            if (cari == listBk[mid].kodeBuku) {
                return(mid);
            } else if (listBk[mid].kodeBuku > cari) {
                return FindBinarySearch(cari, left, mid);
            } else {
                return FindBinarySearch(cari, left, right);
            }
        }
        return -1;
    }


```

<br>

```java

        System.out.println("================================================================");
        System.out.println("Menggunakan Binary Search");
        posisi = data.FindBinarySearch(cari, 0, jumBuku -1);
        data.Tampilposisi(cari, posisi);
        data.TampilData(cari, posisi);       

```

### 6.3.2 Hasil

<br>

<img src="./img/image_3.png">

<br>

<img src="./img/image_4.png">

<br>


### 6.4.1 Program

```java

package Tugas.P5_MergeSortTest;

public class MergeSorting13 {
    
    public void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public void merge(int data[], int left, int middle, int right) {
        int[] temp = new int[data.length];
        for (int i = left; i <= right; i++) {
            temp[i] = data[i];
        }
        int a = left;
        int b = middle + 1;
        int c = left;

        while (a <= middle && b <= right) {
            if (temp[a] <= temp[b]) {
                data[c] = temp[a];
                a++;
            } else {
                data[c] = temp[b];
                b++;
            }
            c++;
        }
        int s = middle -a;
        for (int i = 0; i <= s; i++) {
            data[c + i] = temp[a + i];
        }
    }

    public void sort(int data[], int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(data, left, middle);
            sort(data, middle + 1, right);
            merge(data, left, middle, right);
        }
    }

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }


}


```

<br>

```java

package Tugas.P5_MergeSortTest;

public class MergeSortMain13 {
    public static void main(String[] args) {
        int data[] = {10, 40, 30, 50, 70, 20, 100, 90};
        System.out.println("Sorting dengan merge sort: ");
        MergeSorting13 mSort = new MergeSorting13();
        System.out.println("Data awal: ");
        mSort.printArray(data);
        mSort.mergeSort(data);
        System.out.println("Setelah diurutkan: ");
        mSort.printArray(data);
    }
}


```

<br>

### 6.4.2 Hasil

<img src="./img/image_5.png">

<br>

