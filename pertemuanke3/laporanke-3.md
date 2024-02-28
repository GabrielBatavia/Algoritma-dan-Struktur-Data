<p align="center">LAPORAN PRAKTIKUM 3</p>
<p align="center">Algoritma dan Struktur Data</p>

<p align="center"> <img src="./img/polinema.png"> </p>


<p align="center"> Nama : Gabriel Batavia Xaverius </p>
<p align="center"> NIM : 2341720184  </p>
<p align="center">Kelas : TI-1B  </p>
<p align="center">Absen : 13  </p>

<br>

### 3.2.1 : Membuat Array dari Object, Mengisi dan Menampilkan 

```java

package pertemuanke3.praktikum;

public class persegiPanjang13 {
    public int panjang;
    public int lebar;

    public static void main(String[] args) {
        
        persegiPanjang13[] ppArray = new persegiPanjang13[3];

        ppArray[0] = new persegiPanjang13();
        ppArray[0].panjang = 110;
        ppArray [0].lebar = 30;

        ppArray [1] = new persegiPanjang13();
        ppArray [1].panjang = 80;
        ppArray [1].lebar = 40;

        ppArray [2] = new persegiPanjang13();
        ppArray [2].panjang = 100;
        ppArray [2].lebar = 20;

        System.out.println("Persegi Panjang ke-0, panjang : " + ppArray[0].panjang + ", lebar : " + ppArray[0].lebar);
        System.out.println("Persegi Panjang ke-0, panjang : " + ppArray[1].panjang + ", lebar : " + ppArray[1].lebar);
        System.out.println("Persegi Panjang ke-0, panjang : " + ppArray[2].panjang + ", lebar : " + ppArray[2].lebar);


    }
}


```

<br>

### 3.2.2 : Verifikasi Hasil Percobaan 

Output :<br>

![alt text](image.png)

<br>

### 3.2.3 : Pertanyaan

1. Berdasarkan uji coba 3.2, apakah class yang akan dibuat array of object harus selalu memiliki 
atribut dan sekaligus method?Jelaskan!<br> 
2. Apakah class PersegiPanjang memiliki konstruktor?Jika tidak, kenapa dilakukan pemanggilan konstruktur pada baris program berikut : <br>
```java
ppArray[1] = new PersegiPanjang();
```
3. Apa yang dimaksud dengan kode berikut ini:<br>
```java
PersegiPanjang[] ppArray = new PersegiPanjang[3];
```
4. Apa yang dimaksud dengan kode berikut ini: <br>
```java
ppArray[1] = new PersegiPanjang();
ppArray[1].panjang = 80;
ppArray[1].lebar = 40;
```
5. Mengapa class main dan juga class PersegiPanjang dipisahkan pada uji coba 3.2? <br>

Jawaban :

1. 



<br>


### 3.3.1

```java

package pertemuanke3.praktikum;

import java.util.Scanner;

public class persegiPanjang13 {
    public int panjang;
    public int lebar;

    public static void main(String[] args) {
        
        persegiPanjang13[] ppArray = new persegiPanjang13[3];

        Scanner sc13 = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
    
            ppArray[i] = new persegiPanjang13();
            System.out.println("Persegi panjang ke-" + i);
            System.out.println("Masukkan panjang: ");
            ppArray[i].panjang = sc13.nextInt();
            System.out.println("Masukkan lebar: ");
            ppArray[i].lebar = sc13.nextInt();
    
        }


        for (int i = 0; i < 3; i++) {
            System.out.println("Persegi Panjang ke-" + i);
            System.out.println("Panjang: " + ppArray[i].panjang + ", lebar: " + ppArray[i].lebar);
        }

    }
}


```

Output :

![alt text](image-1.png)

<br>

###3.4

```java

public class Balok13 {
    
    public int panjang;
    public int lebar;
    public int tinggi;

    public Balok13(int p, int l, int t) {
        panjang = p;
        lebar = l;
        tinggi = t;
    }

    public int hitungVolume() {
        return panjang * lebar * tinggi;
    }

    public static void main(String[] args) {
        Balok13[] blArray = new Balok13[3];

        blArray[0] = new Balok13(100, 30, 12);
        blArray[1] = new Balok13(120, 40, 15);
        blArray[2] = new Balok13(210, 50, 25);

        for (int i = 0; i < 3; i++) {
            System.out.println("Volume balok ke " + i + ": " + blArray[i].hitungVolume());
        }

    }

    
}


```

Output :

![alt text](image-2.png)