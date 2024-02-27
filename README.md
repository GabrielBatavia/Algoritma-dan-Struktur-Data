<p align="center">LAPORAN PRAKTIKUM 2</p>
<p align="center">Algoritma dan Struktur Data</p>

<p align="center"> <img src="./img/polinema.png"> </p>


<p align="center"> Nama : Gabriel Batavia Xaverius </p>
<p align="center"> NIM : 2341720184  </p>
<p align="center">Kelas : TI-1B  </p>
<p align="center">Absen : 13  </p>

### 2.1.1 Percobaan 1: Deklarasi Class, Atribut dan Method

```java
public class Buku13 {
    String judul, pengarang;
    int halaman, stock, harga;

    void tampilInformasi () {
        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stock: " + stock);
        System.out.println("Harga: Rp " + harga );
    }

    void terjual(int jml) {
        stock -= jml;
    }

    void restock(int jml) {
        stock += jml;
    }

    void gantiharga(int hrg) {
        harga = hrg;
    }

}
```
<br>

### 2.1.2 Verifikasi Hasil Percobaan
Dari Compline tersebut akan erorr<br>
![imagepercobaan1_praktikum2](https://github.com/GabrielBatavia/Algoritma-dan-Struktur-Data/assets/143175487/e00ca8e2-8b8b-41c3-8470-7a5215723736)


### 2.1.3 Pertanyaan
1. Sebutkan dua karakteristik class atau object!
2. Perhatikan class Buku pada Praktikum 1 tersebut, ada berapa atribut yang dimiliki oleh class 
Buku? Sebutkan apa saja atributnya! 
3. Ada berapa method yang dimiliki oleh class tersebut? Sebutkan apa saja methodnya! 
4. Perhatikan method terjual() yang terdapat di dalam class Buku. Modifikasi isi method tersebut 
sehingga proses pengurangan hanya dapat dilakukan jika stok masih ada (lebih besar dari 0)! 
5. Menurut Anda, mengapa method restock() mempunyai satu parameter berupa bilangan int? 
6. Commit dan push kode program ke Github

Jawaban :
1. Dua Karakteristik Class atau Object: <br>
Encapsulation: Class menyembunyikan detail implementasi dan hanya mengekspos operasi atau metode yang aman kepada dunia luar. Ini memastikan integritas data dengan mencegah pengguna langsung mengakses atau memodifikasi variabel instansi.<br>
Inheritance: Class dapat mewarisi sifat dari class lain (class induk), memungkinkan penggunaan kembali kode. Class turunan mendapat akses ke metode dan variabel dari class induk, memperluas atau menyesuaikan fungsionalitasnya.
<hr>

2. Atribut dalam Class Buku:<br>
Terdapat 5 atribut dalam class Buku:<br>
judul (String)<br>
pengarang (String)<br>
halaman (int)<br>
stock (int)<br>
harga (int)<br>

3. Method dalam Class Buku:<br>
Class tersebut memiliki 4 method:<br>
tampilInformasi(): Menampilkan informasi buku.<br>
terjual(int jml): Mengurangi stock buku berdasarkan jumlah terjual.<br>
restock(int jml): Menambah stock buku berdasarkan jumlah restock.<br>
gantiharga(int hrg): Mengubah harga buku.

4. Untuk memastikan pengurangan stock hanya dilakukan jika stock masih ada, kita perlu menambahkan kondisi yang memeriksa nilai stock sebelum melakukan pengurangan:<br>
void terjual(int jml) { <br>
    if (stock > 0) { // Hanya kurangi jika stock lebih dari 0 <br>
        stock -= jml;
    }<br>
}<br>

5. Mengapa Method restock() Memiliki Satu Parameter Berupa Bilangan int?<br>
Method restock(int jml) memiliki satu parameter berupa bilangan int karena perlu mengetahui jumlah buku yang akan ditambahkan ke dalam stock. Parameter ini menyediakan nilai spesifik yang diperlukan untuk menambah jumlah stock yang ada. Parameter bertipe int karena jumlah stock adalah nilai numerik yang tidak memiliki pecahan.

<br>

### 2.2.1 Percobaan 2: Deklarasi Class, Atribut dan Method

```java
public class BukuMain13 {

    public static void main(String[] args) {
        Buku13 bk1 = new Buku13();
        bk1.judul = "Today Ends Tomorrow Comes";
        bk1.pengarang = "Denanda Praw";
        bk1.halaman = 198;
        bk1.stock = 13;
        bk1.harga = 71000;

        bk1.tampilInformasi();
        bk1.terjual(5);
        bk1.gantiharga(60000);
        bk1.tampilInformasi();

    }

}
```
<br>

### 2.2.2 Verifikasi Hasil Percobaan
![2 2 2](https://github.com/GabrielBatavia/Algoritma-dan-Struktur-Data/assets/143175487/906e9990-6f32-4a3e-8936-1221185485f1)


### 2.1.3 Pertanyaan
1. Pada class BukuMain, tunjukkan baris kode program yang digunakan untuk proses instansiasi! 
Apa nama object yang dihasilkan? 
2. Bagaimana cara mengakses atribut dan method dari suatu objek? 
3. Mengapa hasil output pemanggilan method tampilInformasi() pertama dan kedua berbeda?

Jawaban : 

1. Proses instansiasi dilakukan dengan baris kode <br>Buku13 bk1 = new Buku13();<br> Nama objek yang dihasilkan adalah bk1, yang merupakan sebuah instansi dari class Buku13.

2. Atribut dan method dari suatu objek dapat diakses menggunakan operator titik (.). Setelah membuat objek, kita dapat mengakses atribut objek untuk membaca atau memodifikasinya, dan memanggil method yang ada pada objek tersebut. <br>Contohnya:<br>
Mengakses dan memodifikasi atribut: bk1.judul = "Today Ends Tomorrow Comes";<br>
Memanggil method: bk1.tampilInformasi();

3. Hasil output dari pemanggilan method tampilInformasi() pertama dan kedua berbeda karena terdapat perubahan pada atribut stock dan harga objek bk1 di antara dua pemanggilan tersebut.<br>
Pada pemanggilan pertama, method tampilInformasi() menampilkan informasi berdasarkan nilai atribut awal yang ditetapkan setelah instansiasi objek bk1.<br>
Kemudian, method terjual(5) dipanggil, yang mengurangi nilai stock sebanyak 5 unit, dan method gantiharga(60000) mengubah harga menjadi 60000.<br>
Pada pemanggilan kedua, method tampilInformasi() menampilkan informasi yang sudah diperbarui, mencerminkan perubahan pada stock dan harga. Ini menjelaskan perbedaan antara output pertama dan kedua.

<br>

### 2.3.1 Verifikasi Hasil Percobaan
![2 3 1](https://github.com/GabrielBatavia/Algoritma-dan-Struktur-Data/assets/143175487/413d2543-4d5d-46b8-8f51-70ab088e703d)


<br>

### 2.3.2 Pertanyaan
1. Pada class Buku di Percobaan 3, tunjukkan baris kode program yang digunakan untuk 
mendeklarasikan konstruktor berparameter! 
2. Perhatikan class BukuMain. Apa sebenarnya yang dilakukan pada baris program berikut?  
3. Hapus konstruktor default pada class Buku, kemudian compile dan run program. Bagaimana 
hasilnya? Jelaskan mengapa hasilnya demikian! 
4. Setelah melakukan instansiasi object, apakah method di dalam class Buku harus diakses 
secara berurutan? Jelaskan alasannya! 
5. Buat object baru dengan nama buku <NamaMahasiswa .> menggunakan konstruktor 
berparameter dari class Buku! 
6. Commit dan push kode program ke Github

Jawaban : 

1. Baris kode yang menunjukkan deklarasi konstruktor berparameter adalah <br>
    public Buku13(String jud, String pg, int hal, int stock, int har) {<br>
        judul = jud;<br>
        pengarang = pg;<br>
        halaman = hal;<br>
        this.stock = stock;<br>
        harga = har;<br>
    }

2. Objek kedua, bk2, diinstansiasi dengan menggunakan konstruktor berparameter. Ini menciptakan objek baru dengan langsung memberikan nilai untuk atribut-atributnya.

3. Jika konstruktor default dihapus dari class Buku dan program dikompilasi lalu dijalankan, akan terjadi error pada baris Buku13 bk1 = new Buku13(); di class BukuMain13 karena Java tidak lagi menyediakan konstruktor default secara otomatis ketika sudah ada konstruktor berparameter yang didefinisikan. Tanpa konstruktor default, kita tidak bisa menginstansiasi objek tanpa menyediakan argumen sesuai dengan konstruktor berparameter.

4. Setelah melakukan instansiasi objek, method-method dalam class tidak harus diakses secara berurutan. Urutan pemanggilan method tergantung pada logika atau kebutuhan program. Misalnya, bisa jadi kita ingin menampilkan informasi buku sebelum dan sesudah melakukan operasi seperti menjual (mengurangi stock) atau mengubah harga. Urutan pemanggilan method ditentukan oleh bagaimana objek tersebut ingin dimanipulasi dalam konteks program.

5. Judul: Akuh Mahasiswa<br>
Pengarang: Gabriel Batavia<br>
Jumlah halaman: 0<br>
Sisa stock: 0<br>
Harga: Rp 0<br>

<br>
### 2.4 Latihan Praktikum
<br>
1. Pada class Buku, tambahkan tiga method, yaitu hitungHargaTotal(), hitungDiskon(), dan hitungHargaBayar()

Class diagram dari nomor 1:

| Buku                 |
|----------------------|
| + judul: String      |
| + pengarang: String  |
| + halaman: int       |
| + stok: int          |
| + harga: int         |
| + tampilInformasi(): void |
| + terjual(jml: int): void |
| + restock(n: int): void   |
| + gantiHarga(hrg: int): int |
| + hitungHargaTotal(): void  |
| + hitungDiskon(): int       |
| + hitungHargaBayar(): void  |

Jawaban :

```java
public class Buku13 {
    String judul, pengarang;
    int halaman, stock, harga, terjual;
    

    void tampilInformasi () {

        System.out.println("Judul: " + judul);
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa stock: " + stock);
        System.out.println("Harga: Rp " + harga );
        System.out.println("Terjual: " + terjual);
        System.out.println("Harga Total: Rp " + hitungHargaTotal());
        System.out.println("Diskon: Rp " + hitungDiskon());
        System.out.println("Harga Bayar: Rp " + hitungHargaBayar());
    }

    void terjual(int jml) {
        terjual = jml;
        if (stock > 0 ) {
            stock -= jml;
        }
    }

    void restock(int jml) {
        stock += jml;
    }

    void gantiharga(int hrg) {
        harga = hrg;
    }

    int hitungHargaTotal() {
        return terjual * harga;
    }

    double hitungDiskon() {
        int hargaTotal = hitungHargaTotal(); 
        if (hargaTotal > 150000) {
            return hargaTotal * 0.12;
        } else if (hargaTotal >= 75000 && hargaTotal <= 150000) {
            return hargaTotal * 0.05;
        } else {
            return 0;
        }
    }

    double hitungHargaBayar() {
        int hargaTotal = hitungHargaTotal(); 
        double diskon = hitungDiskon(); 
        return hargaTotal - diskon;
    }


    public Buku13() {
    }

    public Buku13(String jud, String pg, int hal, int stock, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stock = stock;
        harga = har;
    }

}

```
<br>
<br>
2. Membuat program berdasarkan class diagram berikut!
<br>

| Dragon                  |
|-------------------------|
| - x: int                |
| - y: int                |
| - width: int            |
| - height: int           |
|-------------------------|
| + moveLeft(): void      |
| + moveRight(): void     |
| + moveUp(): void        |
| + moveDown(): void      |
| + printPosition(): void |
| + detectCollision(x: int, y: int): void |

<br>
Jawaban:

```java
public class Dragon {
    int x, y, width, height;

    void moveLeft() {
        x--;

        if (x < 0) {
            detectCollision(x, y);
        }
    }

    void moveRight() {
        x++;

        if (x > width) {
            detectCollision(x, y);
        }
    }

    void moveUp() {
        y++;

        if (y > height) {
            detectCollision(x, y);
        }
    }

    void moveDown() {
        y--;

        if (y < 0) {
            detectCollision(x, y);
        }
    }

    void detectCollision(int x, int y) {
        System.out.println("Game Over");
    }
}
```
