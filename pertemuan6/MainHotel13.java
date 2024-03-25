import java.util.Scanner;

public class MainHotel13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelService layananHotel = new HotelService();

        // Menambahkan beberapa hotel
        layananHotel.tambahHotel(new Hotel13("Hotel A", "Jakarta", 500000, (byte) 4));
        layananHotel.tambahHotel(new Hotel13("Hotel B", "Bandung", 750000, (byte) 5));
        // ... tambahkan lebih banyak hotel sesuai kebutuhan

        // Sambutan kepada pengguna
        System.out.println("Selamat datang di layanan pemesanan hotel!");
        System.out.print("Apakah Anda ingin melihat daftar hotel dengan filter? (ya/tidak): ");
        String jawaban = scanner.nextLine();

        if (jawaban.equalsIgnoreCase("ya")) {
            System.out.print("Pilih filter berdasarkan:\n1. Harga (termurah ke termahal)\n2. Rating (tertinggi ke terendah)\nPilihan Anda: ");
            int pilihanFilter = scanner.nextInt();
            
            switch (pilihanFilter) {
                case 1:
                    System.out.println("Mengurutkan hotel berdasarkan harga:");
                    layananHotel.bubbleSort();
                    break;
                case 2:
                    System.out.println("Mengurutkan hotel berdasarkan rating:");
                    layananHotel.selectionSort();
                    break;
                default:
                    System.out.println("Pilihan tidak valid, menampilkan daftar hotel tanpa filter.");
                    break;
            }
        } else {
            System.out.println("Menampilkan daftar hotel tanpa filter:");
        }

        layananHotel.tampilkanHotelUrut();
        
        scanner.close();
    }
}