package Tugas1;

public class LinkedListMain13 {
    public static void main(String[] args) {
        LinkedList13 list13 = new LinkedList13();
        

        list13.print();
        list13.addFirst(new Mahasiswa13(111, "Anton"));
        list13.print();

        list13.addLast(new Mahasiswa13(112, "Prita"));
        list13.print();

        list13.insertAfter(112, new Mahasiswa13(113, "Yusuf"));
        list13.print();

        list13.insertAfter(113, new Mahasiswa13(114, "Doni"));
        list13.print();

        list13.insertAt(4, new Mahasiswa13(115, "Sari"));
        list13.print();
    }
}
