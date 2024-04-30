public class LinkedListMain13 {
    public static void main(String[] args) {
        LinkedList13 linkedList = new LinkedList13();
        
        System.out.println("=============================================");
        System.out.println(" Selamat Datang di Aplikasi Unit Kesehatan!");
        System.out.println("=============================================");
        System.out.println("\nMengisi Antrian Awal:");
        
        linkedList.enqueue(new Mahasiswa13(111, "Anton"));
        linkedList.enqueue(new Mahasiswa13(112, "Prita"));
        linkedList.enqueue(new Mahasiswa13(113, "Yusuf"));
        linkedList.enqueue(new Mahasiswa13(114, "Doni"));
        
        System.out.println("\nAntrian saat ini:");
        linkedList.print();

        System.out.println("=============================================");
        System.out.println("Melakukan Operasi Dequeue (Mengurangi Antrian)");
        System.out.println("=============================================");
        linkedList.dequeue();
        System.out.println("\nAntrian setelah satu mahasiswa dilayani:");
        linkedList.print();

        System.out.println("=============================================");
        linkedList.dequeue();
        System.out.println("\nAntrian setelah satu mahasiswa lagi dilayani:");
        linkedList.print();

        System.out.println("=============================================");
        System.out.println("\nMenambahkan Mahasiswa Baru ke Antrian:");
        linkedList.enqueue(new Mahasiswa13(115, "Sari"));
        System.out.println("\nAntrian saat ini:");
        linkedList.print();

        System.out.println("=============================================");
        System.out.println(" Terima Kasih telah menggunakan Aplikasi kami!");
        System.out.println("=============================================");
    }
}
