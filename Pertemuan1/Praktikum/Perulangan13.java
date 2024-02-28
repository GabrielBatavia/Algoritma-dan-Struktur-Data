import java.util.Scanner;

public class Perulangan13 {
    public static void main(String[] args) {
        Scanner scan13 = new Scanner(System.in);

        System.out.print("Masukkan NIM Anda: ");
        long nimPengguna = scan13.nextLong();

        long duaDigitTerakhirNim = nimPengguna % 100; // Slight change in variable name for readability

        duaDigitTerakhirNim += duaDigitTerakhirNim < 10 ? 10 : 0; // Simplified if statement

        for (int i = 1; i <= duaDigitTerakhirNim; i++) {
            if (i != 6 && i != 10) {
                System.out.print(i % 2 == 1 ? " * " : i); // Simplified if-else inside loop
            }
        }
    }
}
