import java.util.Scanner;

public class main_UTS13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        Pengurutan_dan_Pencarian_UTS13 pengurutanPencarian = new Pengurutan_dan_Pencarian_UTS13();

        // sebelum sort
        System.out.println("Array sebelum pengurutan:");
        pengurutanPencarian.CetakArray();

        // sort pada data dari kelas Pengurutan_dan_Pencarian_UTS13
        pengurutanPencarian.selectionSortAsc();

        // setelah sort
        System.out.println("\nArray setelah pengurutan:");
        pengurutanPencarian.CetakArray();

        // Coba pencarian biner
        System.out.print("\nAngka apa yang ingin kamu cari? : ");
        int key = sc13.nextInt();
        // int indexSebelumSort = pengurutanPencarian.SearchBeforeSort(key);
        int indexSetelahSort = pengurutanPencarian.binarySearchAfterSort(key);

        if (indexSetelahSort != -1) {
            System.out.println("Angka " + key + " ditemukan di index (setelah pengurutan) " + indexSetelahSort);
        } else {
            System.out.println("Angka " + key + " tidak ditemukan setelah pengurutan.");
        }
    }


}
