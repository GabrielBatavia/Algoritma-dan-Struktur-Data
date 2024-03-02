import java.util.Scanner;

public class latihan1_main {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        // Input for Cone
        System.out.println("Masukkan jari-jari dan sisi miring untuk Kerucut: ");
        double rKerucut = sc13.nextDouble();
        double smiringKerucut = sc13.nextDouble();
        latihan1_kerucut kerucut = new latihan1_kerucut(rKerucut, smiringKerucut);
        System.out.println("Luas Permukaan Kerucut: " + cone.getSurfaceArea() + ", Volume: " + cone.getVolume());

        // Input for Square Pyramid
        System.out.println("Enter the base side length and height for the Square Pyramid: ");
        double pyramidBaseSide = sc13.nextDouble();
        double pyramidHeight = sc13.nextDouble();
        SquarePyramid pyramid = new SquarePyramid(pyramidBaseSide, pyramidHeight);
        System.out.println("Square Pyramid Surface Area: " + pyramid.getSurfaceArea() + ", Volume: " + pyramid.getVolume());

        // Input for Sphere
        System.out.println("Enter the radius for the Sphere: ");
        double sphereRadius = scanner.nextDouble();
        Sphere sphere = new Sphere(sphereRadius);
        System.out.println("Sphere Surface Area: " + sphere.getSurfaceArea() + ", Volume: " + sphere.getVolume());

        scanner.close();
    }
}
