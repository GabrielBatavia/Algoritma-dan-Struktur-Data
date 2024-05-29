package doublelinkedlists;
public class DoubleLinkedListsMain {
    public static void main(String[] args){
        DoubleLinkedLists dll = new DoubleLinkedLists();

        // Tambah elemen
        try {
            dll.addLast(7);
            dll.addLast(3);
            dll.addLast(4);

            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("================================");

            dll.add(40, 1);

            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("================================");

            System.out.println("Data awal pada Linked Lists adalah: " + dll.getFirst());
            System.out.println("Data akhir pada Linked Lists adalah: " + dll.getLast());
            System.out.println("Data indeks ke-1 pada Linked Lists adalah: " + dll.get(1));
            System.out.println("================================");

            System.out.println("BUILD SUCCESS");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
