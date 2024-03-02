import java.util.Scanner;

public class latihan1_main {
    public static void main(String[] args) {
        Scanner sc13 = new Scanner(System.in);

        // Input for Cone
        System.out.println("Enter the radius and slant height for the Cone: ");
        double coneRadius = sc13.nextDouble();
        double coneSlantHeight = sc13.nextDouble();
        Cone cone = new Cone(coneRadius, coneSlantHeight);
        System.out.println("Cone Surface Area: " + cone.getSurfaceArea() + ", Volume: " + cone.getVolume());

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
