public class PencarianBuku13 {
    Buku13 listBk[] = new Buku13[5];
    int idx;

    void tambah(Buku13 m) {
        if (idx < listBk.length) {
            listBk[idx] = m;
            idx++;
        } else{
        System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        for (Buku13 m : listBk) {
            m.tampilDataBuku();
        }
    }

    public int FindSeqSearch(String cari) {
        int posisi = -1;
        for (int j  = 0; j < listBk.length; j++) {
            if (listBk[j].kodeBuku.equals(cari)) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }

    public int FindSeqSearchJudul(String cariJudul) {
        int count = 0;
        for (int i = 0; i < idx; i++) {
            if (listBk[i].judulBuku.equalsIgnoreCase(cariJudul)) {
                count++;
            }
        }
        if (count > 1) {
            System.out.println("Peringatan: Lebih dari satu hasil ditemukan untuk judul buku '" + cariJudul + "'.");
        }
        return count;
    }


    public void Tampilposisi(String x, int pos)
    {
        if (pos != -1) {
            System.out.println("data : " + x + " ditemukan pada indeks " + pos);
        } else {
            System.out.println("data " + x + " tidak ditemukan");
        }
    }

    public void TampilData(String x, int pos)
    {
        if (pos != -1) {
            System.out.println("Kode Buku \t: " + x );
            System.out.println("Judul \t : " + listBk[pos].judulBuku);
            System.out.println("Tahun Terbit \t: " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang \t: " + listBk[pos].pengarang);
            System.out.println("Stock \t: " + listBk[pos].stock);
        } else {
            System.err.println("data " + x + "tidak ditemukan");
        }
    }

    public void TampilDataJudul(String x, int pos) {
        if (pos != -1) {
            System.out.println("Kode Buku \t : " + listBk[pos].kodeBuku);
            System.out.println("Judul \t \t : " + x);
            System.out.println("Tahun Terbit \t : " + listBk[pos].tahunTerbit);
            System.out.println("Pengarang \t : " + listBk[pos].pengarang);
            System.out.println("Stok \t \t : " + listBk[pos].stock);
        } else {
            System.out.println("Data " + x + " tidak ditemukan!");
        }
    }

    public int FindBinarySearch(String cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (right + left) / 2;
            if (cari.equals(listBk[mid].kodeBuku)) {
                return mid;
            } else {
                int posisiKiri = FindBinarySearch(cari, left, mid - 1);
                int posisiKanan = FindBinarySearch(cari, mid + 1, right);
                if (posisiKanan != -1) {
                    return posisiKanan;
                } else if (posisiKiri != -1) {
                    return posisiKiri;
                }
            }
        }
        return -1;
    }

    public Buku13 findBuku(String cari) {
        int posisi = -1;
        for (int i = 0; i < listBk.length; i++) {
            if (listBk[i].kodeBuku.equals(cari)) {
                posisi = i;
                break;
            }
        }
    
        return listBk[posisi];
    }

    public int FindBinarySearchJudul(String cariJudul, int left, int right) {
        bubbleSort();

        int mid;
        if (right >= left) {
            mid = (right + left) / 2;
            if (cariJudul.equals(listBk[mid].judulBuku)) {
                int start = mid;
                int end = mid;
                while (start > 0 && listBk[start - 1].judulBuku.equalsIgnoreCase(cariJudul)) {
                    start--;
                }
                while (end < idx - 1 && listBk[end + 1].judulBuku.equalsIgnoreCase(cariJudul)) {
                    end++;
                }
                int count = end - start + 1;
                if (count > 1) {
                    System.out.println(
                            "Peringatan: Lebih dari satu hasil ditemukan untuk judul buku '" + cariJudul + "'.");
                }
                return start;
            } else if (listBk[mid].judulBuku.compareToIgnoreCase(cariJudul) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private void bubbleSort() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (listBk[j].judulBuku.compareToIgnoreCase(listBk[j + 1].judulBuku) > 0) {
                    Buku13 temp = listBk[j];
                    listBk[j] = listBk[j + 1];
                    listBk[j + 1] = temp;
                }
            }
        }
    }
}


