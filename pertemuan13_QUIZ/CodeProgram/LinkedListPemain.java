import java.util.Random;

public class LinkedListPemain {
    NodePemain head;

    public void add(Pemain data) {
        NodePemain newNode = new NodePemain(data);
        if (head == null) {
            head = newNode;
        } else {
            NodePemain tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    public Pemain getByName(String nama) {
        NodePemain tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void updatePoin(String nama, int poin) {
        NodePemain tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                tmp.data.tambahPoin(poin);
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Pemain dengan nama " + nama + " tidak ditemukan.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Tidak ada pemain yang terdaftar.");
            return;
        }

        // Menggunakan bubble sort untuk mengurutkan linked list berdasarkan poin
        boolean swapped;
        do {
            swapped = false;
            NodePemain tmp = head;
            while (tmp.next != null) {
                if (tmp.data.getPoin() < tmp.next.data.getPoin()) {
                    Pemain temp = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = temp;
                    swapped = true;
                }
                tmp = tmp.next;
            }
        } while (swapped);

        System.out.printf("%-25s %-6s %-30s%n", "Nama", "Poin", "Tim");
        System.out.println("-------------------------------------------------------------");
        NodePemain tmp = head;
        while (tmp != null) {
            System.out.printf("%-25s %-6d %-30s%n", tmp.data.getNama(), tmp.data.getPoin(), tmp.data.getTim().getNama());
            tmp = tmp.next;
        }
    }

    public void shuffle() {
        if (head == null || head.next == null) {
            return;
        }
    
        // Menghitung jumlah elemen dalam linked list
        int size = 0;
        NodePemain tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
    
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
    
            // Menukar data antara node pada indeks i dan j
            NodePemain nodeI = getNodeAtIndex(i);
            NodePemain nodeJ = getNodeAtIndex(j);
    
            Pemain temp = nodeI.data;
            nodeI.data = nodeJ.data;
            nodeJ.data = temp;
        }
    }
    
    private NodePemain getNodeAtIndex(int index) {
        int count = 0;
        NodePemain tmp = head;
        while (tmp != null) {
            if (count == index) {
                return tmp;
            }
            count++;
            tmp = tmp.next;
        }
        return null;
    }
}
