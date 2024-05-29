public class LinkedListTim {
    NodeTim head;

    public void add(Tim data) {
        NodeTim newNode = new NodeTim(data);
        if (head == null) {
            head = newNode;
        } else {
            NodeTim tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    public Tim getByName(String nama) {
        NodeTim tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("Tidak ada tim yang terdaftar.");
            return;
        }

        // Menggunakan bubble sort untuk mengurutkan linked list berdasarkan total poin
        boolean swapped;
        do {
            swapped = false;
            NodeTim tmp = head;
            while (tmp.next != null) {
                if (tmp.data.getTotalPoin() < tmp.next.data.getTotalPoin()) {
                    Tim temp = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = temp;
                    swapped = true;
                }
                tmp = tmp.next;
            }
        } while (swapped);

        System.out.printf("%-30s %-6s%n", "Nama Tim", "Total Poin");
        System.out.println("--------------------------------------");
        NodeTim tmp = head;
        while (tmp != null) {
            System.out.printf("%-30s %-6d%n", tmp.data.getNama(), tmp.data.getTotalPoin());
            tmp = tmp.next;
        }
    }
}
