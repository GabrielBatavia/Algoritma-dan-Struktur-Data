
import java.util.Scanner;


public class GraphMain13 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Graph13 gedung = new Graph13(6);
        gedung.addEdge(0, 1, 50);
        gedung.addEdge(0, 2, 100);
        gedung.addEdge(1, 3, 70);
        gedung.addEdge(2, 3, 40);
        gedung.addEdge(3, 4, 60);
        gedung.addEdge(4, 5, 80);

        gedung.degree(0);
        gedung.printGraph();

        gedung.removeEdge(1, 3);
        gedung.printGraph();

        System.out.println("Masukkan gedung asal untuk update jarak: ");
        int asal = scanner.nextInt();
        System.out.println("Masukkan gedung tujuan untuk update jarak: ");
        int tujuan = scanner.nextInt();
        System.out.println("Masukkan jarak baru: ");
        int jarakBaru = scanner.nextInt();
        gedung.updateJarak(asal, tujuan, jarakBaru);
        gedung.printGraph();
        
        int totalEdges = gedung.hitungEdge();
        System.out.println("Total edges dalam graf: " + totalEdges);

        scanner.close();
    }
}
