public class Pangkat13 {
    
    public int nilai, pangkat;

    int pangkatBF(int a, int n) {
        int hasil = 0;
        for (int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }


}
