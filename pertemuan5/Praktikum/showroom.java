public class showroom {

    car13[] carArray13 = new car13[8];

    public showroom() {
        carArray13[0] = new car13("BMW", "M2 Coupe", 2016, 6816, 728);
        carArray13[1] = new car13("Ford", "Fiesta ST", 2014, 3921, 575);
        carArray13[2] = new car13("Nissan", "370Z", 2009, 4360, 657);
        carArray13[3] = new car13("Subaru", "BRZ", 2014, 4058, 609);
        carArray13[4] = new car13("Subaru", "Impreza WRX STI", 2013, 6255, 703);
        carArray13[5] = new car13("Toyota", "AE86 Trueno", 1986, 3700, 553);
        carArray13[6] = new car13("Toyota", "86/GT86", 2014, 4180, 609);
        carArray13[7] = new car13("Toyota", "Golf GTI", 2014, 4180, 631);

        
        //hitungRataRataTopPowerBF();
        //car13 mobilTercepatDC = temukanMobilTercepatDC(0, carArray13.length - 1);
        //System.out.println("Mobil tercepat dengan DC adalah: " + mobilTercepatDC.merk + " " + mobilTercepatDC.tipe);

        //car13 mobilTerlambatDC = temukanMobilTerlambatDC(0, carArray13.length - 1);
        //System.out.println("Mobil terlambat dengan DC adalah: " + mobilTerlambatDC.merk + " " + mobilTerlambatDC.tipe);
    }


    public car13 temukanMobilTercepatDC(int awal, int akhir) {
        if (awal == akhir) {
            return carArray13[awal];
        } else {
            int tengah = (awal + akhir) / 2;
            car13 kiri = temukanMobilTercepatDC(awal, tengah);
            car13 kanan = temukanMobilTercepatDC(tengah + 1, akhir);
            
            if (kiri.top_acceleration > kanan.top_acceleration) {
                return kiri;
            } else {
                return kanan;
            }
        }
    }
    
    public car13 temukanMobilTerlambatDC(int awal, int akhir) {
        if (awal == akhir) {
            return carArray13[awal];
        } else {
            int tengah = (awal + akhir) / 2;
            car13 kiri = temukanMobilTerlambatDC(awal, tengah);
            car13 kanan = temukanMobilTerlambatDC(tengah + 1, akhir);
            
            if (kiri.top_acceleration < kanan.top_acceleration) {
                return kiri;
            } else {
                return kanan;
            }
        }
    }

    public void hitungRataRataTopPowerBF() {
        int totalKecepatan = 0;
        for (car13 mobil : carArray13) {
            totalKecepatan += mobil.top_power;
        }
        double rataRataKecepatan = (double) totalKecepatan / carArray13.length;
        System.out.println("Rata-rata Top Power Dengan BF: " + rataRataKecepatan);
    }
}
