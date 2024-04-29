package Tugas;
public class Queue13 {
    
    private Pembeli13[] antrian;
    private int front;
    private int rear;
    private int size;
    private int max;

    public Queue13(int max) {
        this.max = max;
        antrian = new Pembeli13[this.max];
        front = 0;
        rear = -1;
        size = 0;
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
    
    public void enqueue(Pembeli13 item) {
        if (!isFull()) {
            rear = (rear + 1) % max;
            antrian[rear] = item;
            size++;
        } else {
            System.out.println("Antrian penuh!");
        }
    }

    public Pembeli13 dequeue() {
        if (!isEmpty()) {
            Pembeli13 item = antrian[front];
            front = (front + 1) % max;
            size--;
            return item;
        } else {
            System.out.println("Antrian kosong!");
            return null;
        }
    }

    public void print() {
        for (int i = front; i != rear + 1; i = (i + 1) % max) {
            if (antrian[i] != null) {
                System.out.println(antrian[i].getNama() + " - " + antrian[i].getNoHP()); 
            }
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println(antrian[front].getNama());
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void peekRear() {
        if (!isEmpty()) {
            System.out.println(antrian[rear].getNama());
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void peekPosition(String nama) {
        for (int i = front; i != rear + 1; i = (i + 1) % max) {
            if (antrian[i] != null && antrian[i].getNama().equalsIgnoreCase(nama)) {
                System.out.println("Posisi " + nama + " adalah: " + ((i - front + max) % max + 1));
                return;
            }
        }
        System.out.println(nama + " tidak ada dalam antrian.");
    }

    public void daftarPembeli() {
        for (int i = front; i != rear + 1; i = (i + 1) % max) {
            if (antrian[i] != null) {
                System.out.println((i - front + max) % max + 1 + ". " + antrian[i].getNama() + " - " + antrian[i].getNoHP());
            }
        }
    }
}


