package Praktikum2;

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
