import java.util.Scanner;

public class main_UTS13 {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        // Pengisian data ke dalam array of objek
        UTS13[] arrayData = new UTS13[17];
        arrayData[0] = new UTS13(20);
        arrayData[1] = new UTS13(19);
        arrayData[2] = new UTS13(0);
        arrayData[3] = new UTS13(33);
        arrayData[4] = new UTS13(48);
        arrayData[5] = new UTS13(16);
        arrayData[6] = new UTS13(12);
        arrayData[7] = new UTS13(35);
        arrayData[8] = new UTS13(44);
        arrayData[9] = new UTS13(9);
        arrayData[10] = new UTS13(47);
        arrayData[11] = new UTS13(34);
        arrayData[12] = new UTS13(25);
        arrayData[13] = new UTS13(37);
        arrayData[14] = new UTS13(26);
        arrayData[15] = new UTS13(47);
        arrayData[16] = new UTS13(36);

        Pengurutan_dan_Pencarian_UTS13 sortingSearching = new Pengurutan_dan_Pencarian_UTS13(arrayData);

        System.out.println("========= Program Pencarian dan Pengurutan =========");
        System.out.println("Program ini akan mencari sebuah nilai yang Anda masukkan dalam array tersembunyi.");

        System.out.print("Masukkan angka yang ingin Anda cari: ");
        int key = sc13.nextInt();

        int indexBeforeSort = sortingSearching.sequentialSearch(key);
        String resultBeforeSort = (indexBeforeSort != -1) ? "ditemukan pada index " + indexBeforeSort : "tidak ditemukan";

        sortingSearching.selectionSortAsc();
        int indexAfterSortAsc = sortingSearching.binarySearch(key, true);
        String resultAfterSortAsc = (indexAfterSortAsc != -1) ? "ditemukan pada index " + indexAfterSortAsc : "tidak ditemukan";

        sortingSearching.selectionSortDesc();
        int indexAfterSortDesc = sortingSearching.binarySearch(key, false);
        String resultAfterSortDesc = (indexAfterSortDesc != -1) ? "ditemukan pada index " + indexAfterSortDesc : "tidak ditemukan";
        
        System.out.println("\n======== Nilai dalam Array ========");
        sortingSearching.selectionSortAsc(); 
        System.out.print("Data Setelah pengurutan Ascending: ");
        sortingSearching.CetakArray(); 
        sortingSearching.selectionSortDesc(); 
        System.out.print("Data Setelah pengurutan Descending: ");
        sortingSearching.CetakArray(); 

        System.out.println("\n========= Hasil Pencarian =========");
        System.out.println("Sebelum pengurutan: " + resultBeforeSort);
        System.out.println("Setelah pengurutan Ascending: " + resultAfterSortAsc);
        System.out.println("Setelah pengurutan Descending: " + resultAfterSortDesc);

        System.out.println("\nTerima kasih telah menggunakan program ini!");
    }
}
