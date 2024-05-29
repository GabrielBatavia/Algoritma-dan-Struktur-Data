package Tugas.Tugas1;
public class DoubleLinkedLists13 {
    Node13 head;
    int size;

    public DoubleLinkedLists13() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(int data, String name) {
        if (isEmpty()) {
            head = new Node13(null, data, name, null);
        } else {
            Node13 current = head;
            while (current.next != null) {
                current = current.next;
            }
            Node13 newNode = new Node13(current, data, name, null);
            current.next = newNode;
        }
        size++;
    }

    public void removeFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (size == 1) {
            System.out.println(head.name + " telah selesai divaksinasi.");
            head = null;
            size--;
        } else {
            System.out.println(head.name + " telah selesai divaksinasi.");
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void print() {
        if (!isEmpty()) {
            Node13 tmp = head;
            System.out.println("+----------------------+");
            System.out.println("Daftar Pengganti Vaksin");
            System.out.println("+----------------------+");
            System.out.println("|No.\t|Nama");
            System.out.println("+----------------------+");
            while (tmp != null) {
                System.out.println("|" + tmp.data + "\t|" + tmp.name);
                tmp = tmp.next;
            }
            System.out.println("+----------------------+");
            System.out.println("Sisa Antrian: " + size);
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }
}
