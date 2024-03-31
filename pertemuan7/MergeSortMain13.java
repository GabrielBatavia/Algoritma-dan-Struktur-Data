

public class MergeSortMain13 {
    public static void main(String[] args) {
        int data[] = {10, 40, 30, 50, 70, 20, 100, 90};
        System.out.println("Sorting dengan merge sort: ");
        MergeSorting13 mSort = new MergeSorting13();
        System.out.println("Data awal: ");
        mSort.printArray(data);
        mSort.mergeSort(data);
        System.out.println("Setelah diurutkan: ");
        mSort.printArray(data);
    }
}
