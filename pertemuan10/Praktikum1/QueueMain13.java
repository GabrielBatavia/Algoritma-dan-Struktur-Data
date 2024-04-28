package Praktikum1;
import java.util.Scanner;

public class QueueMain13 {
    
    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Engueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("-----------------");
    }

    public static void main(String[] args) {
        
        Scanner sc13 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int n = sc13.nextInt();

        Queue13 Q = new Queue13(n);
        int pilih;

        do {
            menu();
            pilih = sc13.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc13.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int datakeluar = Q.Dequeue();
                    if (datakeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + datakeluar);
                    }
                    break;
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    

    }

}
