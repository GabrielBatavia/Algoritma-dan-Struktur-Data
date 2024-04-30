public class SLLmain {
    
        public static void main(String[] args) {
            SingleLinkedList13 singLL = new SingleLinkedList13();
            singLL.print();
            
            singLL.addFirst(890);
            singLL.print();

            singLL.addLast(760);
            singLL.print();

            singLL.addFirst(700);
            singLL.print();

            singLL.insertAfter(700, 999);
            singLL.print();

            singLL.insertAt(3, 833);
            singLL.print();

            System.out.println();
            System.out.println("Data padaa indeks ke-i = " + singLL.getData(1));
            System.out.println("Data 3 berada pada indeks ke- " + singLL.indexOf(760));

            singLL.remove(999);
            singLL.print();
            singLL.removeAt(0);
            singLL.print();
            singLL.removeFirst();
            singLL.print();
            singLL.removeLast();
            singLL.print();
            
        }
    

}
