package doublelinkedlists;
public class DoubleLinkedListsMain {
    public static void main(String[] args){
        DoubleLinkedLists dll = new DoubleLinkedLists();
        dll.addFirst(3);
        dll.addLast(4);
        try {
            dll.add(7, 1);
        } catch (Exception e) {
            System.out.println("Pesan Error: " + e.getMessage());
        }
        dll.print(); // Output: 3 7 4
        System.out.println("Size: " + dll.size()); // Output: Size: 3
        dll.clear();
        dll.print(); // Output: Linked list is empty
    }
}
