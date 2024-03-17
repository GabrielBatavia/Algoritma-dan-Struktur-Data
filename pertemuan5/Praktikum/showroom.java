public class showroom {
    
    car13[] carArray13 = new car13[7]; 

    carArray13[0] = new Car13("BMW", "M2 Coupe", 2016, 6816, 728);
    carArray13[1] = new Car13("Ford", "Fiesta ST", 2014, 3921, 575);
    carArray13[2] = new Car13("Nissan", "370Z", 2009, 4360, 657);
    carArray13[3] = new Car13("Subaru", "BRZ", 2014, 4058, 609);
    carArray13[4] = new Car13("Subaru", "Impreza WRX STI", 2013, 6255, 703);
    carArray13[5] = new Car13("Toyota", "AE86 Trueno", 1986, 3700, 553);
    carArray13[6] = new Car13("Toyota", "86/GT86", 2014, 4180, 609);
    carArray13[7] = new Car13("Toyota", "Golf GTI", 2014, 4180, 631);


    // Menemukan mobil dengan top acc
    int maxIndex = 0;
    for (int i = 1; i < carArray.length; i++) {
        if (carArray13[i].top_acceleration > carArray13[maxIndex].top_acceleration) {
            maxIndex = i;
        }
    }
    System.out.println("Mobil tercepat adalah : " + carArray13[maxIndex].merk + " " + carArray13[maxIndex].tipe);

     // Menghitung rata-rata kecepatan
     int totalPower = 0;
     for (car13 car : carArray) {
         totalPower += car.top_power;
     }
     double averagePower = (double) totalPower / carArray13.length;
     System.out.println("Rata-rata kecepatan : " + averagePower);
 

    
}
