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
            
        }
    

}
