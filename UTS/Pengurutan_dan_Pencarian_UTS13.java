public class Pengurutan_dan_Pencarian_UTS13 {
    int[] data = {20, 19, 0, 33, 48, 16, 12, 35, 44, 9, 47, 34, 25, 37, 26, 47, 36};

    void selectionSortAsc() {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    
    //int SearchBeforeSort(int key) {
    //    for (int i = 0; i < data.length; i++) {
    //        if (data[i] == key) {
    //            return i;
    //        }
    //    }
    //    return -1;  // key tidak ditemukan
    //}
    

    int binarySearchAfterSort(int key) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // key tidak ditemukan
    }

    void CetakArray() {
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}