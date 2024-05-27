package doublelinkedlists;
public class DoubleLinkedListsMain {
    public static void main(String[] args){
        DoubleLinkedLists dll = new DoubleLinkedLists();
        
        // Print empty list
        System.out.println("================================");
        dll.print();
        System.out.println("Size: " + dll.size());
        
        // Tambah elemen
        dll.addFirst(3);
        dll.addLast(4);
        try {
            dll.add(7, 1);
        } catch (Exception e) {
            System.out.println("Pesan Error: " + e.getMessage());
        }
        
        // Print list setelah menambah elemen
        System.out.println("================================");
        dll.print(); 
        System.out.println("Size: " + dll.size()); 
        
        try {
            dll.add(40, 1);
        } catch (Exception e) {
            System.out.println("Pesan Error: " + e.getMessage());
        }
        

        System.out.println("================================");
        dll.print(); 
        System.out.println("Size: " + dll.size()); 
        
        // Clear
        dll.clear();
        
        System.out.println("================================");
        dll.print(); 
        System.out.println("Size: " + dll.size()); 
        System.out.println("================================");
        System.out.println("BUILD SUCCESS");
        System.out.println("================================");
    }
}