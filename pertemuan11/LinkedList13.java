

public class LinkedList13 {
    Node13 head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    void print() {
        if (!isEmpty()) {
            Node13 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                System.out.println("NIM: " + tmp.data.nim + " Nama: " + tmp.data.nama);
                tmp = tmp.next;
            }
        } else {
            System.out.println("Linked List Kosong");
        }
    }

    void enqueue(Mahasiswa13 data) {
        Node13 ndInput = new Node13(data, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    Mahasiswa13 dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong, tidak bisa dequeue");
            return null;
        }
        Mahasiswa13 data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
