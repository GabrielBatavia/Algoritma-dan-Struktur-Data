### Praktikum 1

Code :

```java

package Praktikum1;
/**
 * Queue13
 */
public class Queue13 {

    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue13(int n) {
        max = n;
        data = new int [max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.println(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queu sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max -1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;

            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max -1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

}

```

<br>

```java

package Praktikum1;
import java.util.Scanner;

public class QueueMain13 {

    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Engueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("-----------------");
    }

    public static void main(String[] args) {

        Scanner sc13 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n = sc13.nextInt();

        Queue13 Q = new Queue13(n);
        int pilih;

        do {
            menu();
            pilih = sc13.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc13.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int datakeluar = Q.Dequeue();
                    if (datakeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + datakeluar);
                    }
                    break;
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);


    }

}


```

<br>

### Praktikum 2

```java

public class Nasabah13 {
    String nama, norek, alamat;
    int umur;
    double saldo;

    public Nasabah13() {

    }

    public Nasabah13(String nama, String norek, String alamat, int umur, double saldo) {
        this.nama = nama;
        this.norek = norek;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }

    public static class Queue13 {
        Nasabah13[] data;
        int front;
        int rear;
        int size;
        int max;

        public Queue13(int n) {
            max = n;
            data = new Nasabah13[max];
            size = 0;
            front = rear = -1;
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFull() {
            if (size == max) {
                return true;
            } else {
                return false;
            }
        }

        public void peek() {
            if (!isEmpty()) {
                System.out.println("Elemen terdepan : " + data[front].norek + " " + data[front].nama + " "
                        + data[front].alamat + " " + data[front].umur + data[front].saldo);
            } else {
                System.out.println("Queue masih kosong");
            }
        }

        public void print() {
            if (isEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                int i = front;
                while (i != rear) {
                    System.out
                            .println(data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur
                                    + data[i].saldo);
                    i = (i + 1) % max;
                }
                System.out.println(
                        data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur
                                + data[i].saldo);
                System.out.println("Jumlah elemen = " + size);
            }
        }

        public void clear() {
            if (!isEmpty()) {
                front = rear = -1;
                size = 0;
                System.out.println("Queue berhasil dikosongkan");
            } else {
                System.out.println("Queue masih kosong");
            }
        }

        public void enqueue(Nasabah13 dt) {
            if (isFull()) {
                System.out.println("Queue sudah penuh");
                System.exit(0);
            } else {
                if (isEmpty()) {
                    front = rear = 0;
                } else {
                    if (rear == max - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                }
                data[rear] = dt;
                size++;
            }
        }

        public Nasabah13 dequeue() {
            Nasabah13 dt = new Nasabah13();
            if (isEmpty()) {
                System.out.println("Queue masih kosong");
                System.exit(0);
            } else {
                dt = data[front];
                size--;
                if (isEmpty()) {
                    front = rear = -1;
                } else {
                    if (front == max - 1) {
                        front = 0;
                    } else {
                        front++;
                    }
                }
            }
            return dt;
        }
    }

}


```

```java

import java.util.Scanner;

public class QueueMain13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc13.nextInt();
        Nasabah13.Queue13 antri = new Nasabah13.Queue13(jumlah);  // Correct instantiation

        int pilih;
        do {
            menu();
            pilih = sc13.nextInt();  // Corrected variable name
            sc13.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("No rekening: ");
                    String norek = sc13.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc13.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc13.nextLine();
                    System.out.print("Umur: ");
                    int umur = sc13.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = sc13.nextDouble();
                    sc13.nextLine();
                    Nasabah13 nb = new Nasabah13(nama, norek, alamat, umur, saldo);
                    antri.enqueue(nb);
                    break;
                case 2:
                    Nasabah13 data = antri.dequeue();
                    if (data != null && !"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat) &&
                        data.umur != 0 && data.saldo != 0) {
                        System.out.println("Antrian terakhir: " + data.norek + " " + data.nama + " "
                            + data.alamat + " " + data.umur + " " + data.saldo);
                    }
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                default:
                    System.out.println("Masukkan nomor pilihan yang sudah tersedia di menu!");
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }

    public static void menu() {
        System.out.print(
            "\n\nPilihan menu: \n" +
            "   1. Antrian baru\n" +
            "   2. Antrian keluar\n" +
            "   3. Cek antrian terdepan\n" +
            "   4. Cek semua antrian\n" +
            "=====================================\n" +
            "Pilihan : "
        );
    }
}



```

<br>

### Verifikasi Hasil

<img src="./img/image.png">

<br>

<img src="./img/image_2.png">

<br>