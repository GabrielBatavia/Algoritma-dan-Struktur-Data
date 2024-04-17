public class Pengurutan_dan_Pencarian_UTS13 {
    UTS13[] data;

    public Pengurutan_dan_Pencarian_UTS13(UTS13[] initialData) {
        this.data = initialData;  // Correctly initializing the data array with the passed array
    }

    void selectionSortAsc() {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].ambilNilai() < data[minIndex].ambilNilai()) {
                    minIndex = j;
                }
            }
            UTS13 temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }
    }

    void selectionSortDesc() {
        for (int i = 0; i < data.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].ambilNilai() > data[maxIndex].ambilNilai()) {
                    maxIndex = j;
                }
            }
            UTS13 temp = data[maxIndex];
            data[maxIndex] = data[i];
            data[i] = temp;
        }
    }

    int sequentialSearch(int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].ambilNilai() == key) {
                return i;
            }
        }
        return -1;  // key tidak ditemukan
    }

    int binarySearch(int key, boolean ascending) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].ambilNilai() == key) {
                return mid;
            } else if ((data[mid].ambilNilai() < key && ascending) || (data[mid].ambilNilai() > key && !ascending)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;  // key tidak ditemukan
    }

    void CetakArray() {
        for (UTS13 value : data) {
            System.out.print(value.ambilNilai() + " ");
        }
        System.out.println();
    }
}
