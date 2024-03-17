public class showroom {
    
    private car13[] cars;
    private int count;

    public showroom(int capacity) {
        cars = new car13[capacity];
        count = 0;
    }

    public void addCar(car13 car) {
        if (count < cars.length) {
            cars[count] = car;
            count++;
        } else {
            System.out.println("Showroom Sudah Full, tidak bisa menambahkan modil lagi");
        }
    }

}
