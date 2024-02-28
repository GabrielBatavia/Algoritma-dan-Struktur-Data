public class Balok13 {
    
    public int panjang;
    public int lebar;
    public int tinggi;

    public Balok13(int p, int l, int t) {
        panjang = p;
        lebar = l;
        tinggi = t;
    }

    public int hitungVolume() {
        return panjang * lebar * tinggi;
    }

    public static void main(String[] args) {
        Balok13[] blArray = new Balok13[3];

        blArray[0] = new Balok13(100, 30, 12);
        blArray[1] = new Balok13(120, 40, 15);
        blArray[2] = new Balok13(210, 50, 25);

        for (int i = 0; i < 3; i++) {
            System.out.println("Volume balok ke " + i + ": " + blArray[i].hitungVolume());
        }

    }

    
}
