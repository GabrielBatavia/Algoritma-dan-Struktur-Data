package doublelinkedlists;

public class DoubleLinkedLists {
    Node head;
    int size;

    // Constructor untuk inisialisasi list
    public DoubleLinkedLists() {
        head = null;
        size = 0;
    }

    // Memeriksa apakah list kosong
    public boolean isEmpty() {
        return head == null;
    }

    // Menambahkan elemen di awal list
    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node(null, item, null);
        } else {
            Node newNode = new Node(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Menambahkan elemen di akhir list
    public void addLast(int item) {
        if (isEmpty()) {
            addFirst(item);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
        }
    }

    // Menambahkan elemen pada posisi tertentu
    public void add(int item, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (isEmpty() || index == 0) {
            addFirst(item);
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current == null) {
                addLast(item);
            } else {
                Node newNode = new Node(current.prev, item, current);
                if (current.prev != null) {
                    current.prev.next = newNode;
                }
                current.prev = newNode;
                if (index == 0) {
                    head = newNode;
                }
                size++;
            }
        }
    }

    // Mengembalikan ukuran list
    public int size() {
        return size;
    }

    // Menghapus semua elemen dalam list
    public void clear() {
        head = null;
        size = 0;
    }

    // Mencetak elemen-elemen dalam list
    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }
}
