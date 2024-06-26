
import java.util.Scanner;

public class QueueMain13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc13.nextInt();
        Nasabah13.Queue13 antri = new Nasabah13.Queue13(jumlah);  // Correct instantiation

        int pilih;
        do {
            menu();
            pilih = sc13.nextInt();  // Corrected variable name
            sc13.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("No rekening: ");
                    String norek = sc13.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc13.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc13.nextLine();
                    System.out.print("Umur: ");
                    int umur = sc13.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = sc13.nextDouble();
                    sc13.nextLine();
                    Nasabah13 nb = new Nasabah13(nama, norek, alamat, umur, saldo);
                    antri.enqueue(nb);
                    break;
                case 2:
                    Nasabah13 data = antri.dequeue();
                    if (data != null && !"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat) &&
                        data.umur != 0 && data.saldo != 0) {
                        System.out.println("Antrian terakhir: " + data.norek + " " + data.nama + " "
                            + data.alamat + " " + data.umur + " " + data.saldo);
                    }
                    break;
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
                default:
                    System.out.println("Masukkan nomor pilihan yang sudah tersedia di menu!");
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }

    public static void menu() {
        System.out.print(
            "\n\nPilihan menu: \n" +
            "   1. Antrian baru\n" +
            "   2. Antrian keluar\n" +
            "   3. Cek antrian terdepan\n" +
            "   4. Cek semua antrian\n" +
            "5. Peek Rear (Cek antrian paling belakang\n" +
            "=====================================\n" +
            "Pilihan : "
        );
    }
}
