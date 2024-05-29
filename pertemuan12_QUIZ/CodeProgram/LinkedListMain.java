import java.util.Scanner;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedListPemain pemainList = new LinkedListPemain();
        LinkedListTim timList = new LinkedListTim();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan tim
        timList.add(new Tim("Repsol Honda Team"));
        timList.add(new Tim("Monster Energy Yamaha MotoGP"));
        timList.add(new Tim("Ducati Lenovo Team"));
        timList.add(new Tim("Aprilia Racing Team Gresini"));
        timList.add(new Tim("Red Bull KTM Factory Racing"));
        timList.add(new Tim("Pramac Racing"));
        timList.add(new Tim("Gresini Racing MotoGP"));
        timList.add(new Tim("LCR Honda"));
        timList.add(new Tim("Mooney VR46 Racing Team"));
        timList.add(new Tim("RNF MotoGP Team"));
        timList.add(new Tim("Tech3 GASGAS Factory Racing"));

        // Menambahkan pembalap untuk masing-masing tim
        pemainList.add(new Pemain("Marc Marquez", getTimByName(timList, "Repsol Honda Team")));
        pemainList.add(new Pemain("Joan Mir", getTimByName(timList, "Repsol Honda Team")));
        pemainList.add(new Pemain("Fabio Quartararo", getTimByName(timList, "Monster Energy Yamaha MotoGP")));
        pemainList.add(new Pemain("Franco Morbidelli", getTimByName(timList, "Monster Energy Yamaha MotoGP")));
        pemainList.add(new Pemain("Francesco Bagnaia", getTimByName(timList, "Ducati Lenovo Team")));
        pemainList.add(new Pemain("Enea Bastianini", getTimByName(timList, "Ducati Lenovo Team")));
        pemainList.add(new Pemain("Aleix Espargaro", getTimByName(timList, "Aprilia Racing Team Gresini")));
        pemainList.add(new Pemain("Maverick Vinales", getTimByName(timList, "Aprilia Racing Team Gresini")));
        pemainList.add(new Pemain("Brad Binder", getTimByName(timList, "Red Bull KTM Factory Racing")));
        pemainList.add(new Pemain("Jack Miller", getTimByName(timList, "Red Bull KTM Factory Racing")));
        pemainList.add(new Pemain("Jorge Martin", getTimByName(timList, "Pramac Racing")));
        pemainList.add(new Pemain("Johann Zarco", getTimByName(timList, "Pramac Racing")));
        pemainList.add(new Pemain("Alex Marquez", getTimByName(timList, "Gresini Racing MotoGP")));
        pemainList.add(new Pemain("Fabio Di Giannantonio", getTimByName(timList, "Gresini Racing MotoGP")));
        pemainList.add(new Pemain("Takaaki Nakagami", getTimByName(timList, "LCR Honda")));
        pemainList.add(new Pemain("Alex Rins", getTimByName(timList, "LCR Honda")));
        pemainList.add(new Pemain("Luca Marini", getTimByName(timList, "Mooney VR46 Racing Team")));
        pemainList.add(new Pemain("Marco Bezzecchi", getTimByName(timList, "Mooney VR46 Racing Team")));
        pemainList.add(new Pemain("Raul Fernandez", getTimByName(timList, "RNF MotoGP Team")));
        pemainList.add(new Pemain("Miguel Oliveira", getTimByName(timList, "RNF MotoGP Team")));
        pemainList.add(new Pemain("Pol Espargaro", getTimByName(timList, "Tech3 GASGAS Factory Racing")));
        pemainList.add(new Pemain("Augusto Fernandez", getTimByName(timList, "Tech3 GASGAS Factory Racing")));

        int jumlahBalapan = 20;

        for (int i = 0; i < jumlahBalapan; i++) {
            tampilkanBalapan(i + 1);

            pemainList.shuffle();

            // Simulasi Balapan Utama
            int[] poinBerdasarkanPosisiUtama = {25, 20, 16, 13, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            System.out.println("Posisi pemain di Balapan Utama:");
            NodePemain tmp = pemainList.head;
            int posisi = 0;
            while (tmp != null) {
                int poin = posisi < poinBerdasarkanPosisiUtama.length ? poinBerdasarkanPosisiUtama[posisi] : 0;
                pemainList.updatePoin(tmp.data.getNama(), poin);
                System.out.printf("%2d. %-20s (Poin: %d)%n", (posisi + 1), tmp.data.getNama(), poin);
                posisi++;
                tmp = tmp.next;
            }

            // Simulasi Sprint Race
            int[] poinBerdasarkanPosisiSprint = {12, 9, 7, 6, 5, 4, 3, 2, 1};
            System.out.println("Posisi pemain di Sprint Race:");
            pemainList.shuffle(); // Mengacak posisi pemain untuk Sprint Race
            tmp = pemainList.head;
            posisi = 0;
            while (tmp != null && posisi < poinBerdasarkanPosisiSprint.length) {
                int poin = poinBerdasarkanPosisiSprint[posisi];
                pemainList.updatePoin(tmp.data.getNama(), poin);
                System.out.printf("%2d. %-20s (Poin: %d)%n", (posisi + 1), tmp.data.getNama(), poin);
                posisi++;
                tmp = tmp.next;
            }

            System.out.println("\nKlasemen sementara Pembalap:");
            pemainList.display();

            System.out.println("\nKlasemen sementara Tim:");
            timList.display();

            try {
                Thread.sleep(10000); // Jeda waktu 10 detik
            } catch (InterruptedException e) {
                System.out.println("Balapan terganggu: " + e.getMessage());
            }
        }

        System.out.println("\n========== Klasemen Akhir Musim ==========");
        System.out.println("Klasemen Pembalap:");
        pemainList.display();

        System.out.println("Klasemen Tim:");
        timList.display();

        scanner.close();
    }

    public static Tim getTimByName(LinkedListTim timList, String namaTim) {
        return timList.getByName(namaTim);
    }

    public static void tampilkanBalapan(int nomorBalapan) {
        System.out.println("\n========== MotoGP Balapan " + nomorBalapan + " ==========");
        System.out.println("                             ___");
        System.out.println("                          /~   ~\\");
        System.out.println("                         |_      |");
        System.out.println("                         |/     __-__");
        System.out.println("                          \\   /~     ~~-_");
        System.out.println("                           ~~ -~~\\       ~\\");
        System.out.println("                            /     |        \\");
        System.out.println("               ,           /     /          \\");
        System.out.println("             //   _ _---~~~    //-_          \\");
        System.out.println("           /  (/~~ )    _____/-__  ~-_       _-\\             _________");
        System.out.println("         /  _-~\\\\0) ~~~~         ~~-_ \\__--~~   `\\  ___---~~~        /'");
        System.out.println("        /_-~                       _-/'          )~/               /'");
        System.out.println("        (___________/           _-~/'         _-~~/             _-~");
        System.out.println("     _ ----- _~-_\\\\        _-~ /'      __--~   (_ ______---~~~--_");
        System.out.println("  _-~         ~-_~\\\\      (   (     -_~          ~-_  |          ~-_");
        System.out.println(" /~~~~\\          \\ \\~~       ~-_ ~-_    ~\\            ~~--__-----_    \\");
        System.out.println(";    / \\ ______-----\\           ~-__~-~~~~~~--_             ~~--_ \\    .");
        System.out.println("|   | \\((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |");
        System.out.println("|    \\  |~|~---------)__--~~                      \\_____________/ /    ,");
        System.out.println(" \\    ~-----~    /  /~                             )  \\    ~-----~    /");
        System.out.println("  ~-_         _-~ /_______________________________/    `-_         _-~");
        System.out.println("     ~ ----- ~                                            ~ ----- ~  -TX");
        
        System.out.println("\nSTART\n");
    }
}
