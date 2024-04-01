        System.out.println(
            "=========================================================\n" +
            "Sequential search ke 2"
        );
        
        //Buku13 dataBuku = data.findBuku(cari);
        //dataBuku.tampilDataBuku();

        int left = 0;
        int right = jumBuku;

        System.out.println("_______________________________");
        System.out.println("_______________________________");
        System.out.println("Pencarian Judul Buku: ");
        System.out.println("Masukkan kode buku yang dicari");
        System.out.print("Judul Buku: ");
        String cariJudul = s1.nextLine();

        System.out.println("Menggunakan sequential search");
        int posisiJudulSeq = data.FindSeqSearchJudul(cariJudul);
        System.out.println("seq: " + posisiJudulSeq);
        data.Tampilposisi(cariJudul, posisiJudulSeq);

        System.out.println("Menggunakan binary search");
        int posisiJudulBin = data.FindBinarySearchJudul(cariJudul, left, right);
        System.out.println("binary: " + posisiJudulBin);
        data.Tampilposisi(cariJudul, posisiJudulBin);

        data.TampilDataJudul(cariJudul, posisiJudulSeq);
