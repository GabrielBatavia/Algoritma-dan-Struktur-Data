package pertemuanke3;

public class Segitiga {
    public int alas;
    public int tinggi;

    // Konstruktor
    public Segitiga(int a, int t) {
        alas = a;
        tinggi = t;
    }

    // Metode untuk menghitung luas segitiga siku-siku
    public double hitungLuas() {
        return (alas * tinggi) / 2.0;
    }

    // Metode untuk menghitung keliling segitiga siku-siku
    public double hitungKeliling() {
        // Menggunakan teorema Pythagoras untuk menghitung sisi miring
        double sisiMiring = Math.sqrt((alas * alas) + (tinggi * tinggi));
        return alas + tinggi + sisiMiring;
    }

    public static void main(String[] args) {
        // Membuat array dari objek Segitiga
        Segitiga[] sgArray = new Segitiga[4];
        sgArray[0] = new Segitiga(10, 4);
        sgArray[1] = new Segitiga(20, 10);
        sgArray[2] = new Segitiga(15, 6);
        sgArray[3] = new Segitiga(25, 10);

        // Looping untuk mencetak luas dan keliling setiap segitiga
        for (int i = 0; i < sgArray.length; i++) {
            System.out.println("Segitiga ke-" + i);
            System.out.println("Luas: " + sgArray[i].hitungLuas());
            System.out.println("Keliling: " + sgArray[i].hitungKeliling());
            System.out.println();
        }
    }
}
