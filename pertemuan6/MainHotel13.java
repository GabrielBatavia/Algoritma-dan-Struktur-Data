public class MainHotel13 {
    public static void main(String[] args) {
        HotelService layananHotel = new HotelService();

        // Menambahkan beberapa hotel
        layananHotel.tambahHotel(new Hotel13("Hotel A", "Jakarta", 500000, (byte) 4));
        layananHotel.tambahHotel(new Hotel13("Hotel B", "Bandung", 750000, (byte) 5));
        // ... tambahkan lebih banyak hotel sesuai kebutuhan

        // Urutkan berdasarkan harga dan tampilkan
        System.out.println("Mengurutkan hotel berdasarkan harga (termurah ke termahal):");
        layananHotel.bubbleSort();
        layananHotel.tampilkanHotelUrut();

        // Urutkan berdasarkan rating dan tampilkan
        System.out.println("\nMengurutkan hotel berdasarkan bintang (tertinggi ke terendah):");
        layananHotel.selectionSort();
        layananHotel.tampilkanHotelUrut();
    }
}