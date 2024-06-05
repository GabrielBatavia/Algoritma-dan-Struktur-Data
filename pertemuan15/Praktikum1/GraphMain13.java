package Praktikum1;
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

        System.out.println("Masukkan gedung asal: ");
        int asal = scanner.nextInt();
        System.out.println("Masukkan gedung tujuan: ");
        int tujuan = scanner.nextInt();
        if (gedung.isConnected(asal, tujuan)) {
            System.out.println("Gedung " + (char)('A' + asal) + " dan " + (char)('A' + tujuan) + " bertetangga");
        } else {
            System.out.println("Gedung " + (char)('A' + asal) + " dan " + (char)('A' + tujuan) + " tidak bertetangga");
        }
        scanner.close();
    }
}
