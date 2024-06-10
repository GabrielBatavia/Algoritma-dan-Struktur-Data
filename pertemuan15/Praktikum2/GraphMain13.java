import java.util.Scanner;

public class GraphMain13 {
    public static void main(String[] args) throws Exception {
        Scanner sc13= new Scanner(System.in);
        GraphMatriks13 gedung = new GraphMatriks13(6);
        gedung.makeEdge(0, 1, 50);
        gedung.makeEdge(0, 2, 100);
        gedung.makeEdge(1, 3, 70);
        gedung.makeEdge(2, 3, 40);
        gedung.makeEdge(3, 4, 60);
        gedung.makeEdge(4, 5, 80);

        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Edge");
            System.out.println("2. Remove Edge");
            System.out.println("3. Degree");
            System.out.println("4. Print Graph");
            System.out.println("5. Cek Edge");
            System.out.println("6. Exit");
            System.out.print("Pilih menu: ");
            int menu = sc13.nextInt();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan gedung asal: ");
                    int asal = sc13.nextInt();
                    System.out.print("Masukkan gedung tujuan: ");
                    int tujuan = sc13.nextInt();
                    System.out.print("Masukkan jarak: ");
                    int jarak = sc13.nextInt();
                    gedung.makeEdge(asal, tujuan, jarak);
                    break;
                case 2:
                    System.out.print("Masukkan gedung asal: ");
                    asal = sc13.nextInt();
                    System.out.print("Masukkan gedung tujuan: ");
                    tujuan = sc13.nextInt();
                    gedung.removeEdge(asal, tujuan);
                    break;
                case 3:
                    System.out.print("Masukkan gedung yang ingin dicek derajatnya: ");
                    asal = sc13.nextInt();
                    gedung.degree(asal);
                    break;
                case 4:
                    gedung.printGraph();
                    break;
                case 5:
                    System.out.print("Masukkan gedung asal: ");
                    asal = sc13.nextInt();
                    System.out.print("Masukkan gedung tujuan: ");
                    tujuan = sc13.nextInt();
                    if (gedung.isConnected(asal, tujuan)) {
                        System.out.println("Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " bertetangga");
                    } else {
                        System.out.println("Gedung " + (char) ('A' + asal) + " dan " + (char) ('A' + tujuan) + " tidak bertetangga");
                    }
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Menu tidak valid!");
                    break;
            }
        }
        sc13.close();
    }
}
