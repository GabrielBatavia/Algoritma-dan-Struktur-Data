package Tugas1;
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

    void addFirst(Mahasiswa13 data) {
        Node13 ndInput = new Node13(data, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(Mahasiswa13 data) {
        Node13 ndInput = new Node13(data, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void insertAfter(int NIMKey, Mahasiswa13 data) {
        Node13 ndInput = new Node13(data, null);
        Node13 temp = head;
        boolean keyFound = false;

        while (temp != null) {
            if (temp.data.nim == NIMKey) {
                keyFound = true;
                ndInput.next = temp.next;
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                break;
            }
            temp = temp.next;
        }

        if (!keyFound) {
            System.out.println("NIM tidak ditemukan");
        }
    }

    void insertAt(int index, Mahasiswa13 data) {
        Node13 ndInput = new Node13(data, null);
        if (index < 0) {
            System.out.println("Index Tidak Valid");
            return;
        } else if (index == 0) {
            addFirst(data);
            return;
        }

        Node13 temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp.next == null) {
                System.out.println("Index di luar batas");
                return;
            }
            temp = temp.next;
        }
        ndInput.next = temp.next;
        temp.next = ndInput;
        if (temp.next.next == null) {
            tail = temp.next;
        }
    }
}
