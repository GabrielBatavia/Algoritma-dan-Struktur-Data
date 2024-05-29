<p align="center">LAPORAN QUIZ PERTEMUAN 13</p>
<p align="center">Algoritma dan Struktur Data</p>

<p align="center"> <img src="./img/polinema.png"> </p>

<p align="center"> Nama : Gabriel Batavia Xaverius </p>
<p align="center"> NIM : 2341720184  </p>
<p align="center">Kelas : TI-1B  </p>
<p align="center">Absen : 13  </p>

### QuickOverView

Program ini mengambil latar belakang Kejuaraan Dunia FIM MotoGP 2023 dimana kejuaraan ini diikuti oleh 11 Tim dan 22 Pemain. Program ini melakukan simulasi musim MotoGP dengan 20 balapan utama dan juga sprint. Program akan memilih secara acak menggunakan modul Random dan akan menempatkan setiap pembalap diposisi nya masing masing dalam balapan. poin yang diperoleh pembalap dalam setiap balapan utama dan juga balapan sprint akan diakumulasi diakhir klasemen dan menentukan juara podium nya.

Berikut adalah list Pemain beserta Tim yang mengikuti kejuaraan MotoGP 2023 :

Repsol Honda Team : Marc Márquez, Joan Mir
Monster Energy Yamaha MotoGP : Fabio Quartararo, Franco Morbidelli
Ducati Lenovo Team : Francesco Bagnaia, Enea Bastianini
Red Bull KTM Factory Racing : Brad Binder, Jack Miller
Aprilia Racing : Aleix Espargaró, Maverick Viñales
LCR Honda : Álex Rins, Takaaki Nakagami
Pramac Racing : Jorge Martín, Johann Zarco
Mooney VR46 Racing Team : Luca Marini, Marco Bezzecchi
Gresini Racing MotoGP : Fabio Di Giannantonio, Álex Márquez
Tech3 GASGAS Factory Racing : Pol Espargaró, Augusto Fernández
RNF MotoGP Team : Miguel Oliveira, Raúl Fernández

Berikut adalah list poin untuk posisi dalam MotoGP :

Poin untuk Balapan Utama
1st place: 25 points
2nd place: 20 points
3rd place: 16 points
4th place: 13 points
5th place: 11 points
6th place: 10 points
7th place: 9 points
8th place: 8 points
9th place: 7 points
10th place: 6 points
11th place: 5 points
12th place: 4 points
13th place: 3 points
14th place: 2 points
15th place: 1 point
Poin untuk Balapan Sprint
1st place: 12 points
2nd place: 9 points
3rd place: 7 points
4th place: 6 points
5th place: 5 points
6th place: 4 points
7th place: 3 points
8th place: 2 points
9th place: 1 point

### File Kode

NodePemain :

```java

public class NodePemain {
    Pemain data;
    NodePemain next;

    NodePemain(Pemain data) {
        this.data = data;
        this.next = null;
    }
}


```

<br>

NodeTim :

```java

public class NodeTim {
    Tim data;
    NodeTim next;

    NodeTim(Tim data) {
        this.data = data;
        this.next = null;
    }
}


```

<br>

Pemain :

```java

public class Pemain {
    private String nama;
    private int poin;
    private Tim tim;

    public Pemain(String nama, Tim tim) {
        this.nama = nama;
        this.poin = 0;
        this.tim = tim;
    }

    public String getNama() {
        return nama;
    }

    public int getPoin() {
        return poin;
    }

    public Tim getTim() {
        return tim;
    }

    public void tambahPoin(int poin) {
        this.poin += poin;
        if (tim != null) {
            tim.tambahPoin(poin);
        }
    }

    public String toString() {
        return String.format("Pemain{nama='%s', poin=%d, tim=%s}", nama, poin, tim.getNama());
    }
}


```

<br>

Tim :

```java

public class Tim {
    private String nama;
    private int totalPoin;

    public Tim(String nama) {
        this.nama = nama;
        this.totalPoin = 0;
    }

    public String getNama() {
        return nama;
    }

    public int getTotalPoin() {
        return totalPoin;
    }

    public void tambahPoin(int poin) {
        this.totalPoin += poin;
    }

    public String toString() {
        return String.format("Tim{nama='%s', totalPoin=%d}", nama, totalPoin);
    }
}


```

<br>

LinkedListPemain :

```java

import java.util.Random;

public class LinkedListPemain {
    NodePemain head;

    public void add(Pemain data) {
        NodePemain newNode = new NodePemain(data);
        if (head == null) {
            head = newNode;
        } else {
            NodePemain tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    public Pemain getByName(String nama) {
        NodePemain tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void updatePoin(String nama, int poin) {
        NodePemain tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                tmp.data.tambahPoin(poin);
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Pemain dengan nama " + nama + " tidak ditemukan.");
    }

    public void display() {
        if (head == null) {
            System.out.println("Tidak ada pemain yang terdaftar.");
            return;
        }

        // Menggunakan bubble sort untuk mengurutkan linked list berdasarkan poin
        boolean swapped;
        do {
            swapped = false;
            NodePemain tmp = head;
            while (tmp.next != null) {
                if (tmp.data.getPoin() < tmp.next.data.getPoin()) {
                    Pemain temp = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = temp;
                    swapped = true;
                }
                tmp = tmp.next;
            }
        } while (swapped);

        System.out.printf("%-25s %-6s %-30s%n", "Nama", "Poin", "Tim");
        System.out.println("-------------------------------------------------------------");
        NodePemain tmp = head;
        while (tmp != null) {
            System.out.printf("%-25s %-6d %-30s%n", tmp.data.getNama(), tmp.data.getPoin(), tmp.data.getTim().getNama());
            tmp = tmp.next;
        }
    }

    public void shuffle() {
        if (head == null || head.next == null) {
            return;
        }

        // Menghitung jumlah elemen dalam linked list
        int size = 0;
        NodePemain tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }

        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            // Menukar data antara node pada indeks i dan j
            NodePemain nodeI = getNodeAtIndex(i);
            NodePemain nodeJ = getNodeAtIndex(j);

            Pemain temp = nodeI.data;
            nodeI.data = nodeJ.data;
            nodeJ.data = temp;
        }
    }

    private NodePemain getNodeAtIndex(int index) {
        int count = 0;
        NodePemain tmp = head;
        while (tmp != null) {
            if (count == index) {
                return tmp;
            }
            count++;
            tmp = tmp.next;
        }
        return null;
    }
}


```

<br>

LinkedListTim :

```java

public class LinkedListTim {
    NodeTim head;

    public void add(Tim data) {
        NodeTim newNode = new NodeTim(data);
        if (head == null) {
            head = newNode;
        } else {
            NodeTim tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = newNode;
        }
    }

    public Tim getByName(String nama) {
        NodeTim tmp = head;
        while (tmp != null) {
            if (tmp.data.getNama().equals(nama)) {
                return tmp.data;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("Tidak ada tim yang terdaftar.");
            return;
        }

        // Menggunakan bubble sort untuk mengurutkan linked list berdasarkan total poin
        boolean swapped;
        do {
            swapped = false;
            NodeTim tmp = head;
            while (tmp.next != null) {
                if (tmp.data.getTotalPoin() < tmp.next.data.getTotalPoin()) {
                    Tim temp = tmp.data;
                    tmp.data = tmp.next.data;
                    tmp.next.data = temp;
                    swapped = true;
                }
                tmp = tmp.next;
            }
        } while (swapped);

        System.out.printf("%-30s %-6s%n", "Nama Tim", "Total Poin");
        System.out.println("--------------------------------------");
        NodeTim tmp = head;
        while (tmp != null) {
            System.out.printf("%-30s %-6d%n", tmp.data.getNama(), tmp.data.getTotalPoin());
            tmp = tmp.next;
        }
    }
}



```

<br>

LinkedListMain :

```java

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


```

### Hasil Program

```

========== MotoGP Balapan 1 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Luca Marini          (Poin: 25)
 2. Alex Rins            (Poin: 20)
 3. Fabio Quartararo     (Poin: 16)
 4. Marc Marquez         (Poin: 13)
 5. Aleix Espargaro      (Poin: 11)
 6. Enea Bastianini      (Poin: 10)
 7. Jorge Martin         (Poin: 9)
 8. Pol Espargaro        (Poin: 8)
 9. Fabio Di Giannantonio (Poin: 7)
10. Brad Binder          (Poin: 6)
11. Marco Bezzecchi      (Poin: 5)
12. Augusto Fernandez    (Poin: 4)
13. Jack Miller          (Poin: 3)
14. Francesco Bagnaia    (Poin: 2)
15. Miguel Oliveira      (Poin: 1)
16. Franco Morbidelli    (Poin: 0)
17. Johann Zarco         (Poin: 0)
18. Joan Mir             (Poin: 0)
19. Maverick Vinales     (Poin: 0)
20. Alex Marquez         (Poin: 0)
21. Takaaki Nakagami     (Poin: 0)
22. Raul Fernandez       (Poin: 0)
Posisi pemain di Sprint Race:
 1. Maverick Vinales     (Poin: 12)
 2. Marc Marquez         (Poin: 9)
 3. Marco Bezzecchi      (Poin: 7)
 4. Miguel Oliveira      (Poin: 6)
 5. Luca Marini          (Poin: 5)
 6. Joan Mir             (Poin: 4)
 7. Enea Bastianini      (Poin: 3)
 8. Jorge Martin         (Poin: 2)
 9. Brad Binder          (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               30     Mooney VR46 Racing Team
Marc Marquez              22     Repsol Honda Team
Alex Rins                 20     LCR Honda
Fabio Quartararo          16     Monster Energy Yamaha MotoGP
Enea Bastianini           13     Ducati Lenovo Team
Maverick Vinales          12     Aprilia Racing Team Gresini
Marco Bezzecchi           12     Mooney VR46 Racing Team
Jorge Martin              11     Pramac Racing
Aleix Espargaro           11     Aprilia Racing Team Gresini
Pol Espargaro             8      Tech3 GASGAS Factory Racing
Miguel Oliveira           7      RNF MotoGP Team
Brad Binder               7      Red Bull KTM Factory Racing
Fabio Di Giannantonio     7      Gresini Racing MotoGP
Joan Mir                  4      Repsol Honda Team
Augusto Fernandez         4      Tech3 GASGAS Factory Racing
Jack Miller               3      Red Bull KTM Factory Racing
Francesco Bagnaia         2      Ducati Lenovo Team
Takaaki Nakagami          0      LCR Honda
Johann Zarco              0      Pramac Racing
Alex Marquez              0      Gresini Racing MotoGP
Franco Morbidelli         0      Monster Energy Yamaha MotoGP
Raul Fernandez            0      RNF MotoGP Team

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        42
Repsol Honda Team              26
Aprilia Racing Team Gresini    23
LCR Honda                      20
Monster Energy Yamaha MotoGP   16
Ducati Lenovo Team             15
Tech3 GASGAS Factory Racing    12
Pramac Racing                  11
Red Bull KTM Factory Racing    10
Gresini Racing MotoGP          7
RNF MotoGP Team                7

========== MotoGP Balapan 2 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Enea Bastianini      (Poin: 25)
 2. Augusto Fernandez    (Poin: 20)
 3. Johann Zarco         (Poin: 16)
 4. Joan Mir             (Poin: 13)
 5. Luca Marini          (Poin: 11)
 6. Marco Bezzecchi      (Poin: 10)
 7. Marc Marquez         (Poin: 9)
 8. Jorge Martin         (Poin: 8)
 9. Jack Miller          (Poin: 7)
10. Pol Espargaro        (Poin: 6)
11. Maverick Vinales     (Poin: 5)
12. Miguel Oliveira      (Poin: 4)
13. Raul Fernandez       (Poin: 3)
14. Brad Binder          (Poin: 2)
15. Takaaki Nakagami     (Poin: 1)
16. Francesco Bagnaia    (Poin: 0)
17. Fabio Quartararo     (Poin: 0)
18. Franco Morbidelli    (Poin: 0)
19. Alex Rins            (Poin: 0)
20. Aleix Espargaro      (Poin: 0)
21. Fabio Di Giannantonio (Poin: 0)
22. Alex Marquez         (Poin: 0)
Posisi pemain di Sprint Race:
 1. Johann Zarco         (Poin: 12)
 2. Franco Morbidelli    (Poin: 9)
 3. Augusto Fernandez    (Poin: 7)
 4. Luca Marini          (Poin: 6)
 5. Brad Binder          (Poin: 5)
 6. Pol Espargaro        (Poin: 4)
 7. Enea Bastianini      (Poin: 3)
 8. Joan Mir             (Poin: 2)
 9. Alex Rins            (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               47     Mooney VR46 Racing Team
Enea Bastianini           41     Ducati Lenovo Team
Augusto Fernandez         31     Tech3 GASGAS Factory Racing
Marc Marquez              31     Repsol Honda Team
Johann Zarco              28     Pramac Racing
Marco Bezzecchi           22     Mooney VR46 Racing Team
Alex Rins                 21     LCR Honda
Joan Mir                  19     Repsol Honda Team
Jorge Martin              19     Pramac Racing
Pol Espargaro             18     Tech3 GASGAS Factory Racing
Maverick Vinales          17     Aprilia Racing Team Gresini
Fabio Quartararo          16     Monster Energy Yamaha MotoGP
Brad Binder               14     Red Bull KTM Factory Racing
Miguel Oliveira           11     RNF MotoGP Team
Aleix Espargaro           11     Aprilia Racing Team Gresini
Jack Miller               10     Red Bull KTM Factory Racing
Franco Morbidelli         9      Monster Energy Yamaha MotoGP
Fabio Di Giannantonio     7      Gresini Racing MotoGP
Raul Fernandez            3      RNF MotoGP Team
Francesco Bagnaia         2      Ducati Lenovo Team
Takaaki Nakagami          1      LCR Honda
Alex Marquez              0      Gresini Racing MotoGP

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        69
Repsol Honda Team              50
Tech3 GASGAS Factory Racing    49
Pramac Racing                  47
Ducati Lenovo Team             43
Aprilia Racing Team Gresini    28
Monster Energy Yamaha MotoGP   25
Red Bull KTM Factory Racing    24
LCR Honda                      22
RNF MotoGP Team                14
Gresini Racing MotoGP          7


========== MotoGP Balapan 3 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Miguel Oliveira      (Poin: 25)
 2. Augusto Fernandez    (Poin: 20)
 3. Joan Mir             (Poin: 16)
 4. Jack Miller          (Poin: 13)
 5. Alex Rins            (Poin: 11)
 6. Luca Marini          (Poin: 10)
 7. Johann Zarco         (Poin: 9)
 8. Jorge Martin         (Poin: 8)
 9. Aleix Espargaro      (Poin: 7)
10. Alex Marquez         (Poin: 6)
11. Fabio Quartararo     (Poin: 5)
12. Brad Binder          (Poin: 4)
13. Fabio Di Giannantonio (Poin: 3)
14. Maverick Vinales     (Poin: 2)
15. Pol Espargaro        (Poin: 1)
16. Francesco Bagnaia    (Poin: 0)
17. Enea Bastianini      (Poin: 0)
18. Franco Morbidelli    (Poin: 0)
19. Raul Fernandez       (Poin: 0)
20. Marco Bezzecchi      (Poin: 0)
21. Takaaki Nakagami     (Poin: 0)
22. Marc Marquez         (Poin: 0)
Posisi pemain di Sprint Race:
 1. Francesco Bagnaia    (Poin: 12)
 2. Pol Espargaro        (Poin: 9)
 3. Alex Marquez         (Poin: 7)
 4. Johann Zarco         (Poin: 6)
 5. Luca Marini          (Poin: 5)
 6. Aleix Espargaro      (Poin: 4)
 7. Alex Rins            (Poin: 3)
 8. Brad Binder          (Poin: 2)
 9. Enea Bastianini      (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               62     Mooney VR46 Racing Team
Augusto Fernandez         51     Tech3 GASGAS Factory Racing
Johann Zarco              43     Pramac Racing
Enea Bastianini           42     Ducati Lenovo Team
Miguel Oliveira           36     RNF MotoGP Team
Alex Rins                 35     LCR Honda
Joan Mir                  35     Repsol Honda Team
Marc Marquez              31     Repsol Honda Team
Pol Espargaro             28     Tech3 GASGAS Factory Racing
Jorge Martin              27     Pramac Racing
Jack Miller               23     Red Bull KTM Factory Racing
Aleix Espargaro           22     Aprilia Racing Team Gresini
Marco Bezzecchi           22     Mooney VR46 Racing Team
Fabio Quartararo          21     Monster Energy Yamaha MotoGP
Brad Binder               20     Red Bull KTM Factory Racing
Maverick Vinales          19     Aprilia Racing Team Gresini
Francesco Bagnaia         14     Ducati Lenovo Team
Alex Marquez              13     Gresini Racing MotoGP
Fabio Di Giannantonio     10     Gresini Racing MotoGP
Franco Morbidelli         9      Monster Energy Yamaha MotoGP
Raul Fernandez            3      RNF MotoGP Team
Takaaki Nakagami          1      LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        84
Tech3 GASGAS Factory Racing    79
Pramac Racing                  70
Repsol Honda Team              66
Ducati Lenovo Team             56
Red Bull KTM Factory Racing    43
Aprilia Racing Team Gresini    41
RNF MotoGP Team                39
LCR Honda                      36
Monster Energy Yamaha MotoGP   30
Gresini Racing MotoGP          23

========== MotoGP Balapan 4 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Fabio Di Giannantonio (Poin: 25)
 2. Enea Bastianini      (Poin: 20)
 3. Jorge Martin         (Poin: 16)
 4. Brad Binder          (Poin: 13)
 5. Alex Marquez         (Poin: 11)
 6. Luca Marini          (Poin: 10)
 7. Aleix Espargaro      (Poin: 9)
 8. Alex Rins            (Poin: 8)
 9. Raul Fernandez       (Poin: 7)
10. Marco Bezzecchi      (Poin: 6)
11. Takaaki Nakagami     (Poin: 5)
12. Miguel Oliveira      (Poin: 4)
13. Marc Marquez         (Poin: 3)
14. Joan Mir             (Poin: 2)
15. Jack Miller          (Poin: 1)
16. Franco Morbidelli    (Poin: 0)
17. Pol Espargaro        (Poin: 0)
18. Augusto Fernandez    (Poin: 0)
19. Maverick Vinales     (Poin: 0)
20. Johann Zarco         (Poin: 0)
21. Fabio Quartararo     (Poin: 0)
22. Francesco Bagnaia    (Poin: 0)
Posisi pemain di Sprint Race:
 1. Miguel Oliveira      (Poin: 12)
 2. Marc Marquez         (Poin: 9)
 3. Jack Miller          (Poin: 7)
 4. Raul Fernandez       (Poin: 6)
 5. Luca Marini          (Poin: 5)
 6. Jorge Martin         (Poin: 4)
 7. Fabio Quartararo     (Poin: 3)
 8. Enea Bastianini      (Poin: 2)
 9. Francesco Bagnaia    (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               77     Mooney VR46 Racing Team
Enea Bastianini           64     Ducati Lenovo Team
Miguel Oliveira           52     RNF MotoGP Team
Augusto Fernandez         51     Tech3 GASGAS Factory Racing
Jorge Martin              47     Pramac Racing
Marc Marquez              43     Repsol Honda Team
Alex Rins                 43     LCR Honda
Johann Zarco              43     Pramac Racing
Joan Mir                  37     Repsol Honda Team
Fabio Di Giannantonio     35     Gresini Racing MotoGP
Brad Binder               33     Red Bull KTM Factory Racing
Jack Miller               31     Red Bull KTM Factory Racing
Aleix Espargaro           31     Aprilia Racing Team Gresini
Marco Bezzecchi           28     Mooney VR46 Racing Team
Pol Espargaro             28     Tech3 GASGAS Factory Racing
Fabio Quartararo          24     Monster Energy Yamaha MotoGP
Alex Marquez              24     Gresini Racing MotoGP
Maverick Vinales          19     Aprilia Racing Team Gresini
Raul Fernandez            16     RNF MotoGP Team
Francesco Bagnaia         15     Ducati Lenovo Team
Franco Morbidelli         9      Monster Energy Yamaha MotoGP
Takaaki Nakagami          6      LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        105
Pramac Racing                  90
Repsol Honda Team              80
Tech3 GASGAS Factory Racing    79
Ducati Lenovo Team             79
RNF MotoGP Team                68
Red Bull KTM Factory Racing    64
Gresini Racing MotoGP          59
Aprilia Racing Team Gresini    50
LCR Honda                      49
Monster Energy Yamaha MotoGP   33

========== MotoGP Balapan 5 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Enea Bastianini      (Poin: 25)
 2. Johann Zarco         (Poin: 20)
 3. Pol Espargaro        (Poin: 16)
 4. Alex Marquez         (Poin: 13)
 5. Francesco Bagnaia    (Poin: 11)
 6. Brad Binder          (Poin: 10)
 7. Aleix Espargaro      (Poin: 9)
 8. Takaaki Nakagami     (Poin: 8)
 9. Joan Mir             (Poin: 7)
10. Fabio Quartararo     (Poin: 6)
11. Alex Rins            (Poin: 5)
12. Miguel Oliveira      (Poin: 4)
13. Maverick Vinales     (Poin: 3)
14. Marc Marquez         (Poin: 2)
15. Jorge Martin         (Poin: 1)
16. Fabio Di Giannantonio (Poin: 0)
17. Jack Miller          (Poin: 0)
18. Augusto Fernandez    (Poin: 0)
19. Raul Fernandez       (Poin: 0)
20. Marco Bezzecchi      (Poin: 0)
21. Luca Marini          (Poin: 0)
22. Franco Morbidelli    (Poin: 0)
Posisi pemain di Sprint Race:
 1. Luca Marini          (Poin: 12)
 2. Jorge Martin         (Poin: 9)
 3. Miguel Oliveira      (Poin: 7)
 4. Alex Marquez         (Poin: 6)
 5. Fabio Di Giannantonio (Poin: 5)
 6. Enea Bastianini      (Poin: 4)
 7. Jack Miller          (Poin: 3)
 8. Maverick Vinales     (Poin: 2)
 9. Johann Zarco         (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Enea Bastianini           93     Ducati Lenovo Team
Luca Marini               89     Mooney VR46 Racing Team
Johann Zarco              64     Pramac Racing
Miguel Oliveira           63     RNF MotoGP Team
Jorge Martin              57     Pramac Racing
Augusto Fernandez         51     Tech3 GASGAS Factory Racing
Alex Rins                 48     LCR Honda
Marc Marquez              45     Repsol Honda Team
Joan Mir                  44     Repsol Honda Team
Pol Espargaro             44     Tech3 GASGAS Factory Racing
Alex Marquez              43     Gresini Racing MotoGP
Brad Binder               43     Red Bull KTM Factory Racing
Fabio Di Giannantonio     40     Gresini Racing MotoGP
Aleix Espargaro           40     Aprilia Racing Team Gresini
Jack Miller               34     Red Bull KTM Factory Racing
Fabio Quartararo          30     Monster Energy Yamaha MotoGP
Marco Bezzecchi           28     Mooney VR46 Racing Team
Francesco Bagnaia         26     Ducati Lenovo Team
Maverick Vinales          24     Aprilia Racing Team Gresini
Raul Fernandez            16     RNF MotoGP Team
Takaaki Nakagami          14     LCR Honda
Franco Morbidelli         9      Monster Energy Yamaha MotoGP

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Pramac Racing                  121
Ducati Lenovo Team             119
Mooney VR46 Racing Team        117
Tech3 GASGAS Factory Racing    95
Repsol Honda Team              89
Gresini Racing MotoGP          83
RNF MotoGP Team                79
Red Bull KTM Factory Racing    77
Aprilia Racing Team Gresini    64
LCR Honda                      62
Monster Energy Yamaha MotoGP   39

========== MotoGP Balapan 6 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Augusto Fernandez    (Poin: 25)
 2. Raul Fernandez       (Poin: 20)
 3. Alex Marquez         (Poin: 16)
 4. Fabio Quartararo     (Poin: 13)
 5. Johann Zarco         (Poin: 11)
 6. Franco Morbidelli    (Poin: 10)
 7. Marco Bezzecchi      (Poin: 9)
 8. Alex Rins            (Poin: 8)
 9. Miguel Oliveira      (Poin: 7)
10. Jack Miller          (Poin: 6)
11. Marc Marquez         (Poin: 5)
12. Jorge Martin         (Poin: 4)
13. Maverick Vinales     (Poin: 3)
14. Fabio Di Giannantonio (Poin: 2)
15. Joan Mir             (Poin: 1)
16. Luca Marini          (Poin: 0)
17. Francesco Bagnaia    (Poin: 0)
18. Takaaki Nakagami     (Poin: 0)
19. Aleix Espargaro      (Poin: 0)
20. Enea Bastianini      (Poin: 0)
21. Brad Binder          (Poin: 0)
22. Pol Espargaro        (Poin: 0)
Posisi pemain di Sprint Race:
 1. Jorge Martin         (Poin: 12)
 2. Enea Bastianini      (Poin: 9)
 3. Jack Miller          (Poin: 7)
 4. Aleix Espargaro      (Poin: 6)
 5. Alex Rins            (Poin: 5)
 6. Marc Marquez         (Poin: 4)
 7. Franco Morbidelli    (Poin: 3)
 8. Luca Marini          (Poin: 2)
 9. Augusto Fernandez    (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Enea Bastianini           102    Ducati Lenovo Team
Luca Marini               91     Mooney VR46 Racing Team
Augusto Fernandez         77     Tech3 GASGAS Factory Racing
Johann Zarco              75     Pramac Racing
Jorge Martin              73     Pramac Racing
Miguel Oliveira           70     RNF MotoGP Team
Alex Rins                 61     LCR Honda
Alex Marquez              59     Gresini Racing MotoGP
Marc Marquez              54     Repsol Honda Team
Jack Miller               47     Red Bull KTM Factory Racing
Aleix Espargaro           46     Aprilia Racing Team Gresini
Joan Mir                  45     Repsol Honda Team
Pol Espargaro             44     Tech3 GASGAS Factory Racing
Fabio Quartararo          43     Monster Energy Yamaha MotoGP
Brad Binder               43     Red Bull KTM Factory Racing
Fabio Di Giannantonio     42     Gresini Racing MotoGP
Marco Bezzecchi           37     Mooney VR46 Racing Team
Raul Fernandez            36     RNF MotoGP Team
Maverick Vinales          27     Aprilia Racing Team Gresini
Francesco Bagnaia         26     Ducati Lenovo Team
Franco Morbidelli         22     Monster Energy Yamaha MotoGP
Takaaki Nakagami          14     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Pramac Racing                  148
Ducati Lenovo Team             128
Mooney VR46 Racing Team        128
Tech3 GASGAS Factory Racing    121
RNF MotoGP Team                106
Gresini Racing MotoGP          101
Repsol Honda Team              99
Red Bull KTM Factory Racing    90
LCR Honda                      75
Aprilia Racing Team Gresini    73
Monster Energy Yamaha MotoGP   65

========== MotoGP Balapan 7 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Brad Binder          (Poin: 25)
 2. Luca Marini          (Poin: 20)
 3. Marc Marquez         (Poin: 16)
 4. Franco Morbidelli    (Poin: 13)
 5. Alex Marquez         (Poin: 11)
 6. Alex Rins            (Poin: 10)
 7. Francesco Bagnaia    (Poin: 9)
 8. Jorge Martin         (Poin: 8)
 9. Miguel Oliveira      (Poin: 7)
10. Aleix Espargaro      (Poin: 6)
11. Enea Bastianini      (Poin: 5)
12. Johann Zarco         (Poin: 4)
13. Fabio Quartararo     (Poin: 3)
14. Joan Mir             (Poin: 2)
15. Takaaki Nakagami     (Poin: 1)
16. Pol Espargaro        (Poin: 0)
17. Maverick Vinales     (Poin: 0)
18. Raul Fernandez       (Poin: 0)
19. Jack Miller          (Poin: 0)
20. Fabio Di Giannantonio (Poin: 0)
21. Marco Bezzecchi      (Poin: 0)
22. Augusto Fernandez    (Poin: 0)
Posisi pemain di Sprint Race:
 1. Luca Marini          (Poin: 12)
 2. Marc Marquez         (Poin: 9)
 3. Fabio Di Giannantonio (Poin: 7)
 4. Fabio Quartararo     (Poin: 6)
 5. Johann Zarco         (Poin: 5)
 6. Raul Fernandez       (Poin: 4)
 7. Alex Rins            (Poin: 3)
 8. Maverick Vinales     (Poin: 2)
 9. Takaaki Nakagami     (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               123    Mooney VR46 Racing Team
Enea Bastianini           107    Ducati Lenovo Team
Johann Zarco              84     Pramac Racing
Jorge Martin              81     Pramac Racing
Marc Marquez              79     Repsol Honda Team
Miguel Oliveira           77     RNF MotoGP Team
Augusto Fernandez         77     Tech3 GASGAS Factory Racing
Alex Rins                 74     LCR Honda
Alex Marquez              70     Gresini Racing MotoGP
Brad Binder               68     Red Bull KTM Factory Racing
Fabio Quartararo          52     Monster Energy Yamaha MotoGP
Aleix Espargaro           52     Aprilia Racing Team Gresini
Fabio Di Giannantonio     49     Gresini Racing MotoGP
Joan Mir                  47     Repsol Honda Team
Jack Miller               47     Red Bull KTM Factory Racing
Pol Espargaro             44     Tech3 GASGAS Factory Racing
Raul Fernandez            40     RNF MotoGP Team
Marco Bezzecchi           37     Mooney VR46 Racing Team
Franco Morbidelli         35     Monster Energy Yamaha MotoGP
Francesco Bagnaia         35     Ducati Lenovo Team
Maverick Vinales          29     Aprilia Racing Team Gresini
Takaaki Nakagami          16     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Pramac Racing                  165
Mooney VR46 Racing Team        160
Ducati Lenovo Team             142
Repsol Honda Team              126
Tech3 GASGAS Factory Racing    121
Gresini Racing MotoGP          119
RNF MotoGP Team                117
Red Bull KTM Factory Racing    115
LCR Honda                      90
Monster Energy Yamaha MotoGP   87
Aprilia Racing Team Gresini    81


========== MotoGP Balapan 8 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Maverick Vinales     (Poin: 25)
 2. Pol Espargaro        (Poin: 20)
 3. Franco Morbidelli    (Poin: 16)
 4. Augusto Fernandez    (Poin: 13)
 5. Brad Binder          (Poin: 11)
 6. Luca Marini          (Poin: 10)
 7. Fabio Quartararo     (Poin: 9)
 8. Jorge Martin         (Poin: 8)
 9. Alex Marquez         (Poin: 7)
10. Miguel Oliveira      (Poin: 6)
11. Joan Mir             (Poin: 5)
12. Raul Fernandez       (Poin: 4)
13. Aleix Espargaro      (Poin: 3)
14. Francesco Bagnaia    (Poin: 2)
15. Marc Marquez         (Poin: 1)
16. Jack Miller          (Poin: 0)
17. Johann Zarco         (Poin: 0)
18. Fabio Di Giannantonio (Poin: 0)
19. Marco Bezzecchi      (Poin: 0)
20. Enea Bastianini      (Poin: 0)
21. Alex Rins            (Poin: 0)
22. Takaaki Nakagami     (Poin: 0)
Posisi pemain di Sprint Race:
 1. Marc Marquez         (Poin: 12)
 2. Jack Miller          (Poin: 9)
 3. Franco Morbidelli    (Poin: 7)
 4. Alex Rins            (Poin: 6)
 5. Fabio Di Giannantonio (Poin: 5)
 6. Alex Marquez         (Poin: 4)
 7. Pol Espargaro        (Poin: 3)
 8. Luca Marini          (Poin: 2)
 9. Francesco Bagnaia    (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               135    Mooney VR46 Racing Team
Enea Bastianini           107    Ducati Lenovo Team
Marc Marquez              92     Repsol Honda Team
Augusto Fernandez         90     Tech3 GASGAS Factory Racing
Jorge Martin              89     Pramac Racing
Johann Zarco              84     Pramac Racing
Miguel Oliveira           83     RNF MotoGP Team
Alex Marquez              81     Gresini Racing MotoGP
Alex Rins                 80     LCR Honda
Brad Binder               79     Red Bull KTM Factory Racing
Pol Espargaro             67     Tech3 GASGAS Factory Racing
Fabio Quartararo          61     Monster Energy Yamaha MotoGP
Franco Morbidelli         58     Monster Energy Yamaha MotoGP
Jack Miller               56     Red Bull KTM Factory Racing
Aleix Espargaro           55     Aprilia Racing Team Gresini
Fabio Di Giannantonio     54     Gresini Racing MotoGP
Maverick Vinales          54     Aprilia Racing Team Gresini
Joan Mir                  52     Repsol Honda Team
Raul Fernandez            44     RNF MotoGP Team
Francesco Bagnaia         38     Ducati Lenovo Team
Marco Bezzecchi           37     Mooney VR46 Racing Team
Takaaki Nakagami          16     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Pramac Racing                  173
Mooney VR46 Racing Team        172
Tech3 GASGAS Factory Racing    157
Ducati Lenovo Team             145
Repsol Honda Team              144
Gresini Racing MotoGP          135
Red Bull KTM Factory Racing    135
RNF MotoGP Team                127
Monster Energy Yamaha MotoGP   119
Aprilia Racing Team Gresini    109
LCR Honda                      96

========== MotoGP Balapan 9 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Maverick Vinales     (Poin: 25)
 2. Aleix Espargaro      (Poin: 20)
 3. Takaaki Nakagami     (Poin: 16)
 4. Pol Espargaro        (Poin: 13)
 5. Jack Miller          (Poin: 11)
 6. Luca Marini          (Poin: 10)
 7. Alex Marquez         (Poin: 9)
 8. Marc Marquez         (Poin: 8)
 9. Jorge Martin         (Poin: 7)
10. Marco Bezzecchi      (Poin: 6)
11. Raul Fernandez       (Poin: 5)
12. Miguel Oliveira      (Poin: 4)
13. Joan Mir             (Poin: 3)
14. Augusto Fernandez    (Poin: 2)
15. Alex Rins            (Poin: 1)
16. Fabio Quartararo     (Poin: 0)
17. Brad Binder          (Poin: 0)
18. Enea Bastianini      (Poin: 0)
19. Francesco Bagnaia    (Poin: 0)
20. Franco Morbidelli    (Poin: 0)
21. Johann Zarco         (Poin: 0)
22. Fabio Di Giannantonio (Poin: 0)
Posisi pemain di Sprint Race:
 1. Marco Bezzecchi      (Poin: 12)
 2. Jack Miller          (Poin: 9)
 3. Brad Binder          (Poin: 7)
 4. Joan Mir             (Poin: 6)
 5. Enea Bastianini      (Poin: 5)
 6. Fabio Quartararo     (Poin: 4)
 7. Fabio Di Giannantonio (Poin: 3)
 8. Luca Marini          (Poin: 2)
 9. Franco Morbidelli    (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               147    Mooney VR46 Racing Team
Enea Bastianini           112    Ducati Lenovo Team
Marc Marquez              100    Repsol Honda Team
Jorge Martin              96     Pramac Racing
Augusto Fernandez         92     Tech3 GASGAS Factory Racing
Alex Marquez              90     Gresini Racing MotoGP
Miguel Oliveira           87     RNF MotoGP Team
Brad Binder               86     Red Bull KTM Factory Racing
Johann Zarco              84     Pramac Racing
Alex Rins                 81     LCR Honda
Pol Espargaro             80     Tech3 GASGAS Factory Racing
Maverick Vinales          79     Aprilia Racing Team Gresini
Jack Miller               76     Red Bull KTM Factory Racing
Aleix Espargaro           75     Aprilia Racing Team Gresini
Fabio Quartararo          65     Monster Energy Yamaha MotoGP
Joan Mir                  61     Repsol Honda Team
Franco Morbidelli         59     Monster Energy Yamaha MotoGP
Fabio Di Giannantonio     57     Gresini Racing MotoGP
Marco Bezzecchi           55     Mooney VR46 Racing Team
Raul Fernandez            49     RNF MotoGP Team
Francesco Bagnaia         38     Ducati Lenovo Team
Takaaki Nakagami          32     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        202
Pramac Racing                  180
Tech3 GASGAS Factory Racing    172
Red Bull KTM Factory Racing    162
Repsol Honda Team              161
Aprilia Racing Team Gresini    154
Ducati Lenovo Team             150
Gresini Racing MotoGP          147
RNF MotoGP Team                136
Monster Energy Yamaha MotoGP   124
LCR Honda                      113

========== MotoGP Balapan 10 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Luca Marini          (Poin: 25)
 2. Marc Marquez         (Poin: 20)
 3. Francesco Bagnaia    (Poin: 16)
 4. Fabio Di Giannantonio (Poin: 13)
 5. Raul Fernandez       (Poin: 11)
 6. Jack Miller          (Poin: 10)
 7. Fabio Quartararo     (Poin: 9)
 8. Alex Marquez         (Poin: 8)
 9. Jorge Martin         (Poin: 7)
10. Marco Bezzecchi      (Poin: 6)
11. Pol Espargaro        (Poin: 5)
12. Takaaki Nakagami     (Poin: 4)
13. Alex Rins            (Poin: 3)
14. Maverick Vinales     (Poin: 2)
15. Johann Zarco         (Poin: 1)
16. Miguel Oliveira      (Poin: 0)
17. Joan Mir             (Poin: 0)
18. Augusto Fernandez    (Poin: 0)
19. Franco Morbidelli    (Poin: 0)
20. Aleix Espargaro      (Poin: 0)
21. Enea Bastianini      (Poin: 0)
22. Brad Binder          (Poin: 0)
Posisi pemain di Sprint Race:
 1. Marco Bezzecchi      (Poin: 12)
 2. Takaaki Nakagami     (Poin: 9)
 3. Augusto Fernandez    (Poin: 7)
 4. Alex Marquez         (Poin: 6)
 5. Miguel Oliveira      (Poin: 5)
 6. Pol Espargaro        (Poin: 4)
 7. Fabio Di Giannantonio (Poin: 3)
 8. Raul Fernandez       (Poin: 2)
 9. Joan Mir             (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               172    Mooney VR46 Racing Team
Marc Marquez              120    Repsol Honda Team
Enea Bastianini           112    Ducati Lenovo Team
Alex Marquez              104    Gresini Racing MotoGP
Jorge Martin              103    Pramac Racing
Augusto Fernandez         99     Tech3 GASGAS Factory Racing
Miguel Oliveira           92     RNF MotoGP Team
Pol Espargaro             89     Tech3 GASGAS Factory Racing
Brad Binder               86     Red Bull KTM Factory Racing
Jack Miller               86     Red Bull KTM Factory Racing
Johann Zarco              85     Pramac Racing
Alex Rins                 84     LCR Honda
Maverick Vinales          81     Aprilia Racing Team Gresini
Aleix Espargaro           75     Aprilia Racing Team Gresini
Fabio Quartararo          74     Monster Energy Yamaha MotoGP
Marco Bezzecchi           73     Mooney VR46 Racing Team
Fabio Di Giannantonio     73     Gresini Racing MotoGP
Raul Fernandez            62     RNF MotoGP Team
Joan Mir                  62     Repsol Honda Team
Franco Morbidelli         59     Monster Energy Yamaha MotoGP
Francesco Bagnaia         54     Ducati Lenovo Team
Takaaki Nakagami          45     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        245
Pramac Racing                  188
Tech3 GASGAS Factory Racing    188
Repsol Honda Team              182
Gresini Racing MotoGP          177
Red Bull KTM Factory Racing    172
Ducati Lenovo Team             166
Aprilia Racing Team Gresini    156
RNF MotoGP Team                154
Monster Energy Yamaha MotoGP   133
LCR Honda                      129

========== MotoGP Balapan 11 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Maverick Vinales     (Poin: 25)
 2. Fabio Quartararo     (Poin: 20)
 3. Aleix Espargaro      (Poin: 16)
 4. Takaaki Nakagami     (Poin: 13)
 5. Franco Morbidelli    (Poin: 11)
 6. Augusto Fernandez    (Poin: 10)
 7. Pol Espargaro        (Poin: 9)
 8. Enea Bastianini      (Poin: 8)
 9. Jack Miller          (Poin: 7)
10. Raul Fernandez       (Poin: 6)
11. Fabio Di Giannantonio (Poin: 5)
12. Alex Rins            (Poin: 4)
13. Joan Mir             (Poin: 3)
14. Marco Bezzecchi      (Poin: 2)
15. Johann Zarco         (Poin: 1)
16. Miguel Oliveira      (Poin: 0)
17. Luca Marini          (Poin: 0)
18. Jorge Martin         (Poin: 0)
19. Francesco Bagnaia    (Poin: 0)
20. Marc Marquez         (Poin: 0)
21. Brad Binder          (Poin: 0)
22. Alex Marquez         (Poin: 0)
Posisi pemain di Sprint Race:
 1. Pol Espargaro        (Poin: 12)
 2. Luca Marini          (Poin: 9)
 3. Fabio Di Giannantonio (Poin: 7)
 4. Aleix Espargaro      (Poin: 6)
 5. Brad Binder          (Poin: 5)
 6. Augusto Fernandez    (Poin: 4)
 7. Francesco Bagnaia    (Poin: 3)
 8. Alex Rins            (Poin: 2)
 9. Jorge Martin         (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               181    Mooney VR46 Racing Team
Enea Bastianini           120    Ducati Lenovo Team
Marc Marquez              120    Repsol Honda Team
Augusto Fernandez         113    Tech3 GASGAS Factory Racing
Pol Espargaro             110    Tech3 GASGAS Factory Racing
Maverick Vinales          106    Aprilia Racing Team Gresini
Jorge Martin              104    Pramac Racing
Alex Marquez              104    Gresini Racing MotoGP
Aleix Espargaro           97     Aprilia Racing Team Gresini
Fabio Quartararo          94     Monster Energy Yamaha MotoGP
Jack Miller               93     Red Bull KTM Factory Racing
Miguel Oliveira           92     RNF MotoGP Team
Brad Binder               91     Red Bull KTM Factory Racing
Alex Rins                 90     LCR Honda
Johann Zarco              86     Pramac Racing
Fabio Di Giannantonio     85     Gresini Racing MotoGP
Marco Bezzecchi           75     Mooney VR46 Racing Team
Franco Morbidelli         70     Monster Energy Yamaha MotoGP
Raul Fernandez            68     RNF MotoGP Team
Joan Mir                  65     Repsol Honda Team
Takaaki Nakagami          58     LCR Honda
Francesco Bagnaia         57     Ducati Lenovo Team

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        256
Tech3 GASGAS Factory Racing    223
Aprilia Racing Team Gresini    203
Pramac Racing                  190
Gresini Racing MotoGP          189
Repsol Honda Team              185
Red Bull KTM Factory Racing    184
Ducati Lenovo Team             177
Monster Energy Yamaha MotoGP   164
RNF MotoGP Team                160
LCR Honda                      148


========== MotoGP Balapan 12 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Pol Espargaro        (Poin: 25)
 2. Aleix Espargaro      (Poin: 20)
 3. Marco Bezzecchi      (Poin: 16)
 4. Fabio Quartararo     (Poin: 13)
 5. Joan Mir             (Poin: 11)
 6. Alex Marquez         (Poin: 10)
 7. Jorge Martin         (Poin: 9)
 8. Francesco Bagnaia    (Poin: 8)
 9. Takaaki Nakagami     (Poin: 7)
10. Fabio Di Giannantonio (Poin: 6)
11. Enea Bastianini      (Poin: 5)
12. Maverick Vinales     (Poin: 4)
13. Marc Marquez         (Poin: 3)
14. Franco Morbidelli    (Poin: 2)
15. Johann Zarco         (Poin: 1)
16. Augusto Fernandez    (Poin: 0)
17. Alex Rins            (Poin: 0)
18. Brad Binder          (Poin: 0)
19. Miguel Oliveira      (Poin: 0)
20. Luca Marini          (Poin: 0)
21. Jack Miller          (Poin: 0)
22. Raul Fernandez       (Poin: 0)
Posisi pemain di Sprint Race:
 1. Maverick Vinales     (Poin: 12)
 2. Alex Marquez         (Poin: 9)
 3. Aleix Espargaro      (Poin: 7)
 4. Fabio Di Giannantonio (Poin: 6)
 5. Jorge Martin         (Poin: 5)
 6. Enea Bastianini      (Poin: 4)
 7. Francesco Bagnaia    (Poin: 3)
 8. Jack Miller          (Poin: 2)
 9. Pol Espargaro        (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               181    Mooney VR46 Racing Team
Pol Espargaro             136    Tech3 GASGAS Factory Racing
Enea Bastianini           129    Ducati Lenovo Team
Aleix Espargaro           124    Aprilia Racing Team Gresini
Alex Marquez              123    Gresini Racing MotoGP
Marc Marquez              123    Repsol Honda Team
Maverick Vinales          122    Aprilia Racing Team Gresini
Jorge Martin              118    Pramac Racing
Augusto Fernandez         113    Tech3 GASGAS Factory Racing
Fabio Quartararo          107    Monster Energy Yamaha MotoGP
Fabio Di Giannantonio     97     Gresini Racing MotoGP
Jack Miller               95     Red Bull KTM Factory Racing
Miguel Oliveira           92     RNF MotoGP Team
Marco Bezzecchi           91     Mooney VR46 Racing Team
Brad Binder               91     Red Bull KTM Factory Racing
Alex Rins                 90     LCR Honda
Johann Zarco              87     Pramac Racing
Joan Mir                  76     Repsol Honda Team
Franco Morbidelli         72     Monster Energy Yamaha MotoGP
Francesco Bagnaia         68     Ducati Lenovo Team
Raul Fernandez            68     RNF MotoGP Team
Takaaki Nakagami          65     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        272
Tech3 GASGAS Factory Racing    249
Aprilia Racing Team Gresini    246
Gresini Racing MotoGP          220
Pramac Racing                  205
Repsol Honda Team              199
Red Bull KTM Factory Racing    186
Monster Energy Yamaha MotoGP   179
RNF MotoGP Team                160
LCR Honda                      155

========== MotoGP Balapan 13 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Johann Zarco         (Poin: 25)
 2. Jack Miller          (Poin: 20)
 3. Franco Morbidelli    (Poin: 16)
 4. Marco Bezzecchi      (Poin: 13)
 5. Joan Mir             (Poin: 11)
 6. Pol Espargaro        (Poin: 10)
 7. Raul Fernandez       (Poin: 9)
 8. Alex Rins            (Poin: 8)
 9. Fabio Quartararo     (Poin: 7)
10. Jorge Martin         (Poin: 6)
11. Augusto Fernandez    (Poin: 5)
12. Miguel Oliveira      (Poin: 4)
13. Brad Binder          (Poin: 3)
14. Takaaki Nakagami     (Poin: 2)
15. Marc Marquez         (Poin: 1)
16. Alex Marquez         (Poin: 0)
17. Francesco Bagnaia    (Poin: 0)
18. Maverick Vinales     (Poin: 0)
19. Luca Marini          (Poin: 0)
20. Enea Bastianini      (Poin: 0)
21. Aleix Espargaro      (Poin: 0)
22. Fabio Di Giannantonio (Poin: 0)
Posisi pemain di Sprint Race:
 1. Francesco Bagnaia    (Poin: 12)
 2. Marco Bezzecchi      (Poin: 9)
 3. Raul Fernandez       (Poin: 7)
 4. Aleix Espargaro      (Poin: 6)
 5. Brad Binder          (Poin: 5)
 6. Luca Marini          (Poin: 4)
 7. Johann Zarco         (Poin: 3)
 8. Marc Marquez         (Poin: 2)
 9. Franco Morbidelli    (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               185    Mooney VR46 Racing Team
Pol Espargaro             146    Tech3 GASGAS Factory Racing
Aleix Espargaro           130    Aprilia Racing Team Gresini
Enea Bastianini           129    Ducati Lenovo Team
Marc Marquez              126    Repsol Honda Team
Jorge Martin              124    Pramac Racing
Alex Marquez              123    Gresini Racing MotoGP
Maverick Vinales          122    Aprilia Racing Team Gresini
Augusto Fernandez         118    Tech3 GASGAS Factory Racing
Johann Zarco              115    Pramac Racing
Jack Miller               115    Red Bull KTM Factory Racing
Fabio Quartararo          114    Monster Energy Yamaha MotoGP
Marco Bezzecchi           113    Mooney VR46 Racing Team
Brad Binder               99     Red Bull KTM Factory Racing
Alex Rins                 98     LCR Honda
Fabio Di Giannantonio     97     Gresini Racing MotoGP
Miguel Oliveira           96     RNF MotoGP Team
Franco Morbidelli         89     Monster Energy Yamaha MotoGP
Joan Mir                  87     Repsol Honda Team
Raul Fernandez            84     RNF MotoGP Team
Francesco Bagnaia         80     Ducati Lenovo Team
Takaaki Nakagami          67     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Mooney VR46 Racing Team        298
Tech3 GASGAS Factory Racing    264
Aprilia Racing Team Gresini    252
Pramac Racing                  239
Gresini Racing MotoGP          220
Red Bull KTM Factory Racing    214
Repsol Honda Team              213
Ducati Lenovo Team             209
Monster Energy Yamaha MotoGP   203
RNF MotoGP Team                180
LCR Honda                      165

========== MotoGP Balapan 14 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Pol Espargaro        (Poin: 25)
 2. Raul Fernandez       (Poin: 20)
 3. Augusto Fernandez    (Poin: 16)
 4. Brad Binder          (Poin: 13)
 5. Alex Rins            (Poin: 11)
 6. Francesco Bagnaia    (Poin: 10)
 7. Maverick Vinales     (Poin: 9)
 8. Marco Bezzecchi      (Poin: 8)
 9. Alex Marquez         (Poin: 7)
10. Franco Morbidelli    (Poin: 6)
11. Joan Mir             (Poin: 5)
12. Jorge Martin         (Poin: 4)
13. Johann Zarco         (Poin: 3)
14. Fabio Di Giannantonio (Poin: 2)
15. Fabio Quartararo     (Poin: 1)
16. Luca Marini          (Poin: 0)
17. Jack Miller          (Poin: 0)
18. Enea Bastianini      (Poin: 0)
19. Aleix Espargaro      (Poin: 0)
20. Miguel Oliveira      (Poin: 0)
21. Marc Marquez         (Poin: 0)
22. Takaaki Nakagami     (Poin: 0)
Posisi pemain di Sprint Race:
 1. Brad Binder          (Poin: 12)
 2. Fabio Quartararo     (Poin: 9)
 3. Joan Mir             (Poin: 7)
 4. Enea Bastianini      (Poin: 6)
 5. Augusto Fernandez    (Poin: 5)
 6. Maverick Vinales     (Poin: 4)
 7. Jack Miller          (Poin: 3)
 8. Jorge Martin         (Poin: 2)
 9. Miguel Oliveira      (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               185    Mooney VR46 Racing Team
Pol Espargaro             171    Tech3 GASGAS Factory Racing
Augusto Fernandez         139    Tech3 GASGAS Factory Racing
Enea Bastianini           135    Ducati Lenovo Team
Maverick Vinales          135    Aprilia Racing Team Gresini
Jorge Martin              130    Pramac Racing
Alex Marquez              130    Gresini Racing MotoGP
Aleix Espargaro           130    Aprilia Racing Team Gresini
Marc Marquez              126    Repsol Honda Team
Brad Binder               124    Red Bull KTM Factory Racing
Fabio Quartararo          124    Monster Energy Yamaha MotoGP
Marco Bezzecchi           121    Mooney VR46 Racing Team
Jack Miller               118    Red Bull KTM Factory Racing
Johann Zarco              118    Pramac Racing
Alex Rins                 109    LCR Honda
Raul Fernandez            104    RNF MotoGP Team
Joan Mir                  99     Repsol Honda Team
Fabio Di Giannantonio     99     Gresini Racing MotoGP
Miguel Oliveira           97     RNF MotoGP Team
Franco Morbidelli         95     Monster Energy Yamaha MotoGP
Francesco Bagnaia         90     Ducati Lenovo Team
Takaaki Nakagami          67     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    310
Mooney VR46 Racing Team        306
Aprilia Racing Team Gresini    265
Pramac Racing                  248
Red Bull KTM Factory Racing    242
Gresini Racing MotoGP          229
Repsol Honda Team              225
Ducati Lenovo Team             225
Monster Energy Yamaha MotoGP   219
RNF MotoGP Team                201
LCR Honda                      176

========== MotoGP Balapan 15 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Brad Binder          (Poin: 25)
 2. Alex Marquez         (Poin: 20)
 3. Jorge Martin         (Poin: 16)
 4. Franco Morbidelli    (Poin: 13)
 5. Augusto Fernandez    (Poin: 11)
 6. Takaaki Nakagami     (Poin: 10)
 7. Francesco Bagnaia    (Poin: 9)
 8. Joan Mir             (Poin: 8)
 9. Maverick Vinales     (Poin: 7)
10. Fabio Quartararo     (Poin: 6)
11. Luca Marini          (Poin: 5)
12. Alex Rins            (Poin: 4)
13. Johann Zarco         (Poin: 3)
14. Fabio Di Giannantonio (Poin: 2)
15. Raul Fernandez       (Poin: 1)
16. Marco Bezzecchi      (Poin: 0)
17. Enea Bastianini      (Poin: 0)
18. Jack Miller          (Poin: 0)
19. Pol Espargaro        (Poin: 0)
20. Marc Marquez         (Poin: 0)
21. Aleix Espargaro      (Poin: 0)
22. Miguel Oliveira      (Poin: 0)
Posisi pemain di Sprint Race:
 1. Enea Bastianini      (Poin: 12)
 2. Jorge Martin         (Poin: 9)
 3. Augusto Fernandez    (Poin: 7)
 4. Fabio Di Giannantonio (Poin: 6)
 5. Marc Marquez         (Poin: 5)
 6. Francesco Bagnaia    (Poin: 4)
 7. Brad Binder          (Poin: 3)
 8. Luca Marini          (Poin: 2)
 9. Jack Miller          (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Luca Marini               192    Mooney VR46 Racing Team
Pol Espargaro             171    Tech3 GASGAS Factory Racing
Augusto Fernandez         157    Tech3 GASGAS Factory Racing
Jorge Martin              155    Pramac Racing
Brad Binder               152    Red Bull KTM Factory Racing
Alex Marquez              150    Gresini Racing MotoGP
Enea Bastianini           147    Ducati Lenovo Team
Maverick Vinales          142    Aprilia Racing Team Gresini
Marc Marquez              131    Repsol Honda Team
Fabio Quartararo          130    Monster Energy Yamaha MotoGP
Aleix Espargaro           130    Aprilia Racing Team Gresini
Marco Bezzecchi           121    Mooney VR46 Racing Team
Johann Zarco              121    Pramac Racing
Jack Miller               119    Red Bull KTM Factory Racing
Alex Rins                 113    LCR Honda
Franco Morbidelli         108    Monster Energy Yamaha MotoGP
Fabio Di Giannantonio     107    Gresini Racing MotoGP
Joan Mir                  107    Repsol Honda Team
Raul Fernandez            105    RNF MotoGP Team
Francesco Bagnaia         103    Ducati Lenovo Team
Miguel Oliveira           97     RNF MotoGP Team
Takaaki Nakagami          77     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    328
Mooney VR46 Racing Team        313
Pramac Racing                  276
Aprilia Racing Team Gresini    272
Red Bull KTM Factory Racing    271
Gresini Racing MotoGP          257
Ducati Lenovo Team             250
Repsol Honda Team              238
Monster Energy Yamaha MotoGP   238
RNF MotoGP Team                202
LCR Honda                      190

========== MotoGP Balapan 16 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Raul Fernandez       (Poin: 25)
 2. Pol Espargaro        (Poin: 20)
 3. Aleix Espargaro      (Poin: 16)
 4. Augusto Fernandez    (Poin: 13)
 5. Miguel Oliveira      (Poin: 11)
 6. Francesco Bagnaia    (Poin: 10)
 7. Alex Marquez         (Poin: 9)
 8. Marc Marquez         (Poin: 8)
 9. Franco Morbidelli    (Poin: 7)
10. Enea Bastianini      (Poin: 6)
11. Fabio Di Giannantonio (Poin: 5)
12. Jorge Martin         (Poin: 4)
13. Luca Marini          (Poin: 3)
14. Johann Zarco         (Poin: 2)
15. Marco Bezzecchi      (Poin: 1)
16. Jack Miller          (Poin: 0)
17. Maverick Vinales     (Poin: 0)
18. Fabio Quartararo     (Poin: 0)
19. Joan Mir             (Poin: 0)
20. Alex Rins            (Poin: 0)
21. Brad Binder          (Poin: 0)
22. Takaaki Nakagami     (Poin: 0)
Posisi pemain di Sprint Race:
 1. Alex Rins            (Poin: 12)
 2. Brad Binder          (Poin: 9)
 3. Aleix Espargaro      (Poin: 7)
 4. Jack Miller          (Poin: 6)
 5. Pol Espargaro        (Poin: 5)
 6. Augusto Fernandez    (Poin: 4)
 7. Johann Zarco         (Poin: 3)
 8. Marco Bezzecchi      (Poin: 2)
 9. Enea Bastianini      (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             196    Tech3 GASGAS Factory Racing
Luca Marini               195    Mooney VR46 Racing Team
Augusto Fernandez         174    Tech3 GASGAS Factory Racing
Brad Binder               161    Red Bull KTM Factory Racing
Alex Marquez              159    Gresini Racing MotoGP
Jorge Martin              159    Pramac Racing
Enea Bastianini           154    Ducati Lenovo Team
Aleix Espargaro           153    Aprilia Racing Team Gresini
Maverick Vinales          142    Aprilia Racing Team Gresini
Marc Marquez              139    Repsol Honda Team
Raul Fernandez            130    RNF MotoGP Team
Fabio Quartararo          130    Monster Energy Yamaha MotoGP
Johann Zarco              126    Pramac Racing
Alex Rins                 125    LCR Honda
Jack Miller               125    Red Bull KTM Factory Racing
Marco Bezzecchi           124    Mooney VR46 Racing Team
Franco Morbidelli         115    Monster Energy Yamaha MotoGP
Francesco Bagnaia         113    Ducati Lenovo Team
Fabio Di Giannantonio     112    Gresini Racing MotoGP
Miguel Oliveira           108    RNF MotoGP Team
Joan Mir                  107    Repsol Honda Team
Takaaki Nakagami          77     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    370
Mooney VR46 Racing Team        319
Aprilia Racing Team Gresini    295
Red Bull KTM Factory Racing    286
Pramac Racing                  285
Gresini Racing MotoGP          271
Ducati Lenovo Team             267
Repsol Honda Team              246
Monster Energy Yamaha MotoGP   245
RNF MotoGP Team                238
LCR Honda                      202

========== MotoGP Balapan 17 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Enea Bastianini      (Poin: 25)
 2. Fabio Quartararo     (Poin: 20)
 3. Brad Binder          (Poin: 16)
 4. Johann Zarco         (Poin: 13)
 5. Joan Mir             (Poin: 11)
 6. Miguel Oliveira      (Poin: 10)
 7. Fabio Di Giannantonio (Poin: 9)
 8. Pol Espargaro        (Poin: 8)
 9. Takaaki Nakagami     (Poin: 7)
10. Jorge Martin         (Poin: 6)
11. Marc Marquez         (Poin: 5)
12. Marco Bezzecchi      (Poin: 4)
13. Jack Miller          (Poin: 3)
14. Luca Marini          (Poin: 2)
15. Alex Rins            (Poin: 1)
16. Alex Marquez         (Poin: 0)
17. Franco Morbidelli    (Poin: 0)
18. Augusto Fernandez    (Poin: 0)
19. Francesco Bagnaia    (Poin: 0)
20. Maverick Vinales     (Poin: 0)
21. Aleix Espargaro      (Poin: 0)
22. Raul Fernandez       (Poin: 0)
Posisi pemain di Sprint Race:
 1. Miguel Oliveira      (Poin: 12)
 2. Takaaki Nakagami     (Poin: 9)
 3. Luca Marini          (Poin: 7)
 4. Joan Mir             (Poin: 6)
 5. Alex Marquez         (Poin: 5)
 6. Pol Espargaro        (Poin: 4)
 7. Aleix Espargaro      (Poin: 3)
 8. Maverick Vinales     (Poin: 2)
 9. Raul Fernandez       (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             208    Tech3 GASGAS Factory Racing
Luca Marini               204    Mooney VR46 Racing Team
Enea Bastianini           179    Ducati Lenovo Team
Brad Binder               177    Red Bull KTM Factory Racing
Augusto Fernandez         174    Tech3 GASGAS Factory Racing
Jorge Martin              165    Pramac Racing
Alex Marquez              164    Gresini Racing MotoGP
Aleix Espargaro           156    Aprilia Racing Team Gresini
Fabio Quartararo          150    Monster Energy Yamaha MotoGP
Maverick Vinales          144    Aprilia Racing Team Gresini
Marc Marquez              144    Repsol Honda Team
Johann Zarco              139    Pramac Racing
Raul Fernandez            131    RNF MotoGP Team
Miguel Oliveira           130    RNF MotoGP Team
Marco Bezzecchi           128    Mooney VR46 Racing Team
Jack Miller               128    Red Bull KTM Factory Racing
Alex Rins                 126    LCR Honda
Joan Mir                  124    Repsol Honda Team
Fabio Di Giannantonio     121    Gresini Racing MotoGP
Franco Morbidelli         115    Monster Energy Yamaha MotoGP
Francesco Bagnaia         113    Ducati Lenovo Team
Takaaki Nakagami          93     LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    382
Mooney VR46 Racing Team        332
Red Bull KTM Factory Racing    305
Pramac Racing                  304
Aprilia Racing Team Gresini    300
Ducati Lenovo Team             292
Gresini Racing MotoGP          285
Repsol Honda Team              268
Monster Energy Yamaha MotoGP   265
RNF MotoGP Team                261
LCR Honda                      219

========== MotoGP Balapan 18 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Johann Zarco         (Poin: 25)
 2. Fabio Quartararo     (Poin: 20)
 3. Augusto Fernandez    (Poin: 16)
 4. Alex Rins            (Poin: 13)
 5. Takaaki Nakagami     (Poin: 11)
 6. Enea Bastianini      (Poin: 10)
 7. Maverick Vinales     (Poin: 9)
 8. Fabio Di Giannantonio (Poin: 8)
 9. Alex Marquez         (Poin: 7)
10. Marco Bezzecchi      (Poin: 6)
11. Marc Marquez         (Poin: 5)
12. Francesco Bagnaia    (Poin: 4)
13. Joan Mir             (Poin: 3)
14. Brad Binder          (Poin: 2)
15. Pol Espargaro        (Poin: 1)
16. Aleix Espargaro      (Poin: 0)
17. Jorge Martin         (Poin: 0)
18. Franco Morbidelli    (Poin: 0)
19. Raul Fernandez       (Poin: 0)
20. Miguel Oliveira      (Poin: 0)
21. Jack Miller          (Poin: 0)
22. Luca Marini          (Poin: 0)
Posisi pemain di Sprint Race:
 1. Francesco Bagnaia    (Poin: 12)
 2. Alex Rins            (Poin: 9)
 3. Pol Espargaro        (Poin: 7)
 4. Luca Marini          (Poin: 6)
 5. Raul Fernandez       (Poin: 5)
 6. Miguel Oliveira      (Poin: 4)
 7. Jack Miller          (Poin: 3)
 8. Marc Marquez         (Poin: 2)
 9. Alex Marquez         (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             216    Tech3 GASGAS Factory Racing
Luca Marini               210    Mooney VR46 Racing Team
Augusto Fernandez         190    Tech3 GASGAS Factory Racing
Enea Bastianini           189    Ducati Lenovo Team
Brad Binder               179    Red Bull KTM Factory Racing
Alex Marquez              172    Gresini Racing MotoGP
Fabio Quartararo          170    Monster Energy Yamaha MotoGP
Jorge Martin              165    Pramac Racing
Johann Zarco              164    Pramac Racing
Aleix Espargaro           156    Aprilia Racing Team Gresini
Maverick Vinales          153    Aprilia Racing Team Gresini
Marc Marquez              151    Repsol Honda Team
Alex Rins                 148    LCR Honda
Raul Fernandez            136    RNF MotoGP Team
Miguel Oliveira           134    RNF MotoGP Team
Marco Bezzecchi           134    Mooney VR46 Racing Team
Jack Miller               131    Red Bull KTM Factory Racing
Francesco Bagnaia         129    Ducati Lenovo Team
Fabio Di Giannantonio     129    Gresini Racing MotoGP
Joan Mir                  127    Repsol Honda Team
Franco Morbidelli         115    Monster Energy Yamaha MotoGP
Takaaki Nakagami          104    LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    406
Mooney VR46 Racing Team        344
Pramac Racing                  329
Ducati Lenovo Team             318
Red Bull KTM Factory Racing    310
Aprilia Racing Team Gresini    309
Gresini Racing MotoGP          301
Monster Energy Yamaha MotoGP   285
Repsol Honda Team              278
RNF MotoGP Team                270
LCR Honda                      252

========== MotoGP Balapan 19 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Joan Mir             (Poin: 25)
 2. Jorge Martin         (Poin: 20)
 3. Enea Bastianini      (Poin: 16)
 4. Aleix Espargaro      (Poin: 13)
 5. Takaaki Nakagami     (Poin: 11)
 6. Maverick Vinales     (Poin: 10)
 7. Marc Marquez         (Poin: 9)
 8. Luca Marini          (Poin: 8)
 9. Johann Zarco         (Poin: 7)
10. Fabio Quartararo     (Poin: 6)
11. Miguel Oliveira      (Poin: 5)
12. Raul Fernandez       (Poin: 4)
13. Jack Miller          (Poin: 3)
14. Franco Morbidelli    (Poin: 2)
15. Francesco Bagnaia    (Poin: 1)
16. Pol Espargaro        (Poin: 0)
17. Augusto Fernandez    (Poin: 0)
18. Alex Rins            (Poin: 0)
19. Brad Binder          (Poin: 0)
20. Alex Marquez         (Poin: 0)
21. Marco Bezzecchi      (Poin: 0)
22. Fabio Di Giannantonio (Poin: 0)
Posisi pemain di Sprint Race:
 1. Johann Zarco         (Poin: 12)
 2. Enea Bastianini      (Poin: 9)
 3. Raul Fernandez       (Poin: 7)
 4. Miguel Oliveira      (Poin: 6)
 5. Brad Binder          (Poin: 5)
 6. Augusto Fernandez    (Poin: 4)
 7. Francesco Bagnaia    (Poin: 3)
 8. Pol Espargaro        (Poin: 2)
 9. Aleix Espargaro      (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             218    Tech3 GASGAS Factory Racing
Luca Marini               218    Mooney VR46 Racing Team
Enea Bastianini           214    Ducati Lenovo Team
Augusto Fernandez         194    Tech3 GASGAS Factory Racing
Jorge Martin              185    Pramac Racing
Brad Binder               184    Red Bull KTM Factory Racing
Johann Zarco              183    Pramac Racing
Fabio Quartararo          176    Monster Energy Yamaha MotoGP
Alex Marquez              172    Gresini Racing MotoGP
Aleix Espargaro           170    Aprilia Racing Team Gresini
Maverick Vinales          163    Aprilia Racing Team Gresini
Marc Marquez              160    Repsol Honda Team
Joan Mir                  152    Repsol Honda Team
Alex Rins                 148    LCR Honda
Raul Fernandez            147    RNF MotoGP Team
Miguel Oliveira           145    RNF MotoGP Team
Jack Miller               134    Red Bull KTM Factory Racing
Marco Bezzecchi           134    Mooney VR46 Racing Team
Francesco Bagnaia         133    Ducati Lenovo Team
Fabio Di Giannantonio     129    Gresini Racing MotoGP
Franco Morbidelli         117    Monster Energy Yamaha MotoGP
Takaaki Nakagami          115    LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    412
Pramac Racing                  368
Mooney VR46 Racing Team        352
Ducati Lenovo Team             347
Aprilia Racing Team Gresini    333
Red Bull KTM Factory Racing    318
Repsol Honda Team              312
Gresini Racing MotoGP          301
Monster Energy Yamaha MotoGP   293
RNF MotoGP Team                292
LCR Honda                      263

========== MotoGP Balapan 20 ==========
                             ___
                          /~   ~\
                         |_      |
                         |/     __-__
                          \   /~     ~~-_
                           ~~ -~~\       ~\
                            /     |        \
               ,           /     /          \
             //   _ _---~~~    //-_          \
           /  (/~~ )    _____/-__  ~-_       _-\             _________
         /  _-~\\0) ~~~~         ~~-_ \__--~~   `\  ___---~~~        /'
        /_-~                       _-/'          )~/               /'
        (___________/           _-~/'         _-~~/             _-~
     _ ----- _~-_\\        _-~ /'      __--~   (_ ______---~~~--_
  _-~         ~-_~\\      (   (     -_~          ~-_  |          ~-_
 /~~~~\          \ \~~       ~-_ ~-_    ~\            ~~--__-----_    \
;    / \ ______-----\           ~-__~-~~~~~~--_             ~~--_ \    .
|   | \((*)~~~~~~~~~~|      __--~~             ~-_               ) |   |
|    \  |~|~---------)__--~~                      \_____________/ /    ,
 \    ~-----~    /  /~                             )  \    ~-----~    /
  ~-_         _-~ /_______________________________/    `-_         _-~
     ~ ----- ~                                            ~ ----- ~  -TX

START

Posisi pemain di Balapan Utama:
 1. Marco Bezzecchi      (Poin: 25)
 2. Augusto Fernandez    (Poin: 20)
 3. Maverick Vinales     (Poin: 16)
 4. Joan Mir             (Poin: 13)
 5. Francesco Bagnaia    (Poin: 11)
 6. Raul Fernandez       (Poin: 10)
 7. Miguel Oliveira      (Poin: 9)
 8. Luca Marini          (Poin: 8)
 9. Brad Binder          (Poin: 7)
10. Alex Rins            (Poin: 6)
11. Fabio Di Giannantonio (Poin: 5)
12. Enea Bastianini      (Poin: 4)
13. Fabio Quartararo     (Poin: 3)
14. Aleix Espargaro      (Poin: 2)
15. Jack Miller          (Poin: 1)
16. Marc Marquez         (Poin: 0)
17. Jorge Martin         (Poin: 0)
18. Takaaki Nakagami     (Poin: 0)
19. Pol Espargaro        (Poin: 0)
20. Alex Marquez         (Poin: 0)
21. Johann Zarco         (Poin: 0)
22. Franco Morbidelli    (Poin: 0)
Posisi pemain di Sprint Race:
 1. Pol Espargaro        (Poin: 12)
 2. Aleix Espargaro      (Poin: 9)
 3. Enea Bastianini      (Poin: 7)
 4. Francesco Bagnaia    (Poin: 6)
 5. Jack Miller          (Poin: 5)
 6. Johann Zarco         (Poin: 4)
 7. Jorge Martin         (Poin: 3)
 8. Alex Marquez         (Poin: 2)
 9. Maverick Vinales     (Poin: 1)

Klasemen sementara Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             230    Tech3 GASGAS Factory Racing
Luca Marini               226    Mooney VR46 Racing Team
Enea Bastianini           225    Ducati Lenovo Team
Augusto Fernandez         214    Tech3 GASGAS Factory Racing
Brad Binder               191    Red Bull KTM Factory Racing
Jorge Martin              188    Pramac Racing
Johann Zarco              187    Pramac Racing
Aleix Espargaro           181    Aprilia Racing Team Gresini
Maverick Vinales          180    Aprilia Racing Team Gresini
Fabio Quartararo          179    Monster Energy Yamaha MotoGP
Alex Marquez              174    Gresini Racing MotoGP
Joan Mir                  165    Repsol Honda Team
Marc Marquez              160    Repsol Honda Team
Marco Bezzecchi           159    Mooney VR46 Racing Team
Raul Fernandez            157    RNF MotoGP Team
Miguel Oliveira           154    RNF MotoGP Team
Alex Rins                 154    LCR Honda
Francesco Bagnaia         150    Ducati Lenovo Team
Jack Miller               140    Red Bull KTM Factory Racing
Fabio Di Giannantonio     134    Gresini Racing MotoGP
Franco Morbidelli         117    Monster Energy Yamaha MotoGP
Takaaki Nakagami          115    LCR Honda

Klasemen sementara Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    444
Mooney VR46 Racing Team        385
Pramac Racing                  375
Ducati Lenovo Team             375
Aprilia Racing Team Gresini    361
Red Bull KTM Factory Racing    331
Repsol Honda Team              325
RNF MotoGP Team                311
Gresini Racing MotoGP          308
Monster Energy Yamaha MotoGP   296
LCR Honda                      269




========== Klasemen Akhir Musim ==========
Klasemen Pembalap:
Nama                      Poin   Tim
-------------------------------------------------------------
Pol Espargaro             230    Tech3 GASGAS Factory Racing
Luca Marini               226    Mooney VR46 Racing Team
Enea Bastianini           225    Ducati Lenovo Team
Augusto Fernandez         214    Tech3 GASGAS Factory Racing
Brad Binder               191    Red Bull KTM Factory Racing
Jorge Martin              188    Pramac Racing
Johann Zarco              187    Pramac Racing
Aleix Espargaro           181    Aprilia Racing Team Gresini
Maverick Vinales          180    Aprilia Racing Team Gresini
Fabio Quartararo          179    Monster Energy Yamaha MotoGP
Alex Marquez              174    Gresini Racing MotoGP
Joan Mir                  165    Repsol Honda Team
Marc Marquez              160    Repsol Honda Team
Marco Bezzecchi           159    Mooney VR46 Racing Team
Raul Fernandez            157    RNF MotoGP Team
Miguel Oliveira           154    RNF MotoGP Team
Alex Rins                 154    LCR Honda
Francesco Bagnaia         150    Ducati Lenovo Team
Jack Miller               140    Red Bull KTM Factory Racing
Fabio Di Giannantonio     134    Gresini Racing MotoGP
Franco Morbidelli         117    Monster Energy Yamaha MotoGP
Takaaki Nakagami          115    LCR Honda
Klasemen Tim:
Nama Tim                       Total Poin
--------------------------------------
Tech3 GASGAS Factory Racing    444
Mooney VR46 Racing Team        385
Pramac Racing                  375
Ducati Lenovo Team             375
Aprilia Racing Team Gresini    361
Red Bull KTM Factory Racing    331
Repsol Honda Team              325
RNF MotoGP Team                311
Gresini Racing MotoGP          308
Monster Energy Yamaha MotoGP   296
LCR Honda                      269



```
