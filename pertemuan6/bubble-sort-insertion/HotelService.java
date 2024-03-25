import java.util.Locale;
import java.text.NumberFormat;

public class HotelService {
    private Hotel13[] semuaHotel = new Hotel13[13];
    private static NumberFormat formatMataUang = NumberFormat.getCurrencyInstance();

    // Menambahkan hotel ke dalam array
    public void tambahHotel(Hotel13 h) {
        for (int i = 0; i < semuaHotel.length; i++) {
            if (semuaHotel[i] == null) {
                semuaHotel[i] = h;
                return; // Keluar dari metode setelah menambahkan hotel
            }
        }
        System.out.println("Data sudah penuh!");
    }

    // Pengurutan berdasarkan harga dengan bubble sort
    public void bubbleSort() {
        for (int i = 0; i < semuaHotel.length - 1; i++) {
            for (int j = 0; j < semuaHotel.length - i - 1; j++) {
                if (semuaHotel[j] != null && semuaHotel[j + 1] != null && semuaHotel[j].harga > semuaHotel[j + 1].harga) {
                    // Tukar hotel
                    Hotel13 sementara = semuaHotel[j];
                    semuaHotel[j] = semuaHotel[j + 1];
                    semuaHotel[j + 1] = sementara;
                }
            }
        }
    }

    // Pengurutan berdasarkan bintang dengan selection sort
    public void selectionSort() {
        for (int i = 0; i < semuaHotel.length; i++) {
            int indeksTerbesar = i;
            for (int j = i + 1; j < semuaHotel.length; j++) {
                if (semuaHotel[j] != null && semuaHotel[j].bintang > semuaHotel[indeksTerbesar].bintang) {
                    indeksTerbesar = j;
                }
            }
            // Tukar hotel
            Hotel13 sementara = semuaHotel[indeksTerbesar];
            semuaHotel[indeksTerbesar] = semuaHotel[i];
            semuaHotel[i] = sementara;
        }
    }

    // Menampilkan hotel yang sudah diurutkan
    public void tampilkanHotelUrut() {
        for (Hotel13 hotel : semuaHotel) {
            if (hotel != null) {
                hotel.tampilkanInfo();
            }
        }
    }
}