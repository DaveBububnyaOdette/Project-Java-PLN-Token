import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class App {

    public static void main(String[] args) {

        // Tempat menyimpan seluruh transaksi
        ArrayList<Struk> strukList = new ArrayList<>();

        // Nama file untuk menyimpan data transaksi
        String fileName = "transaksi.txt";

        Scanner inputUser = new Scanner(System.in);


        // ==========================================
        // MENGAMBIL TANGGAL DAN WAKTU TRANSAKSI
        // ==========================================

        LocalDate tanggalSekarang = LocalDate.now();
        LocalTime waktuSekarang = LocalTime.now();

        DateTimeFormatter formatTanggal =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DateTimeFormatter formatWaktu =
            DateTimeFormatter.ofPattern("HH:mm:ss");

        String tanggal =
            tanggalSekarang.format(formatTanggal);

        String waktu =
            waktuSekarang.format(formatWaktu);


        // ==========================================
        // 1. MEMBACA DATA DARI FILE
        // ==========================================

System.out.println("=== MEMBACA DATA TRANSAKSI ===");

try {

    File myObj = new File(fileName);

    if (myObj.exists()) {

        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();

            String[] str = data.split(",");

            if (str.length >= 17) {

                // ==============================
                // DATA KASIR
                // ==============================

                Kasir kasirFile = new Kasir(
                    str[1].trim(),
                    str[2].trim(),
                    "",
                    ""
                );


                // ==============================
                // DATA PEMBAYARAN
                // ==============================

                String jenisPembayaran =
                    str[14].trim();

                double jumlahPembayaran =
                    Double.parseDouble(str[15].trim());


                Pembayaran pembayaranFile;


                if (jenisPembayaran.equals("Tunai")) {

                    double uangDibayar =
                        Double.parseDouble(str[16].trim());

                    pembayaranFile =
                        new PembayaranTunai(
                            jumlahPembayaran,
                            str[3].trim(),
                            str[4].trim(),
                            uangDibayar
                        );

                } else {

                    String nomorReferensiQRIS =
                        str[16].trim();

                    pembayaranFile =
                        new PembayaranQRIS(
                            jumlahPembayaran,
                            str[3].trim(),
                            str[4].trim(),
                            nomorReferensiQRIS
                        );
                }


                // ==============================
                // DATA PLN PRABAYAR
                // ==============================

                PLNPraBayar plnFile =
                    new PLNPraBayar(
                        str[5].trim(),
                        str[6].trim(),
                        str[7].trim(),
                        str[8].trim(),
                        str[9].trim(),
                        str[10].trim(),
                        Double.parseDouble(str[11].trim()),
                        Double.parseDouble(str[12].trim()),
                        Double.parseDouble(str[13].trim())
                    );


                // ==============================
                // DATA STRUK
                // ==============================

                Struk strukFile =
                    new Struk(
                        str[0].trim(),
                        kasirFile,
                        plnFile,
                        pembayaranFile
                    );


                // Masukkan objek ke ArrayList
                strukList.add(strukFile);
            }
        }

        myReader.close();

        System.out.println(
            "Berhasil membaca "
            + strukList.size()
            + " transaksi dari file."
        );

    } else {

        System.out.println(
            "File " + fileName
            + " belum ada. Memulai dengan daftar transaksi kosong."
        );
    }

} catch (FileNotFoundException e) {

    System.out.println(
        "File tidak ditemukan."
    );

} catch (Exception e) {

    System.out.println(
        "Gagal membaca file: "
        + e.getMessage()
    );
}


        // ==========================================
        // 2. DATA KASIR
        // ==========================================

        Kasir kasir = new Kasir(
            "KSR001",
            "Kasir Indomaret",
            "kasir",
            "12345"
        );


        // ==========================================
        // 3. INPUT DATA PELANGGAN
        // ==========================================

        System.out.println("\n=== DATA PELANGGAN ===");

        System.out.print("ID Pelanggan : ");
        String idPelanggan = inputUser.nextLine();

        System.out.print("Nama Pelanggan : ");
        String namaPelanggan = inputUser.nextLine();

        Pelanggan pelanggan = new Pelanggan(
            idPelanggan,
            namaPelanggan
        );


        // ==========================================
        // 4. INPUT DATA PLN
        // ==========================================

        System.out.println("\n=== DATA PLN PRABAYAR ===");

        System.out.print("Nomor Meter : ");
        String noMeter = inputUser.nextLine();

        System.out.print("Tarif/Daya : ");
        String tarifDaya = inputUser.nextLine();


        // ==========================================
        // 5. PILIH NOMINAL TOKEN
        // ==========================================

        double nominalToken = 0;
        double jumlahKwh = 0;

        while (nominalToken == 0) {

            System.out.println("\n=== PILIH NOMINAL TOKEN ===");
            System.out.println("1. Rp20.000");
            System.out.println("2. Rp50.000");
            System.out.println("3. Rp100.000");

            System.out.print("Pilihan : ");
            int pilihanNominal = inputUser.nextInt();
            inputUser.nextLine();

            if (pilihanNominal == 1) {
                nominalToken = 20000;
                jumlahKwh = 13.1;

            } else if (pilihanNominal == 2) {
                nominalToken = 50000;
                jumlahKwh = 32.75;
            
            } else if (pilihanNominal == 3) {
                nominalToken = 100000;
                jumlahKwh = 65.5;
            
            } else {
                System.out.println("Pilihan tidak valid!");
                System.out.println("Silakan pilih kembali.");
            }
        }


        // ==========================================
        // 6. BIAYA ADMIN
        // ==========================================

        double biayaAdmin = 3500;


        // ==========================================
        // 7. GENERATE NOMOR REFERENSI
        // ==========================================

        String noRef = "REF" + System.currentTimeMillis();


        // ==========================================
        // 8. GENERATE TOKEN 20 DIGIT
        // ==========================================

        String token = generateToken();


        // ==========================================
        // 9. MEMBUAT OBJEK PLN PRABAYAR
        // ==========================================

        PLNPraBayar plnPraBayar = new PLNPraBayar(
            noMeter,
            pelanggan.getIdPelanggan(),
            pelanggan.getNama(),
            tarifDaya,
            noRef,
            token,
            nominalToken,
            biayaAdmin,
            jumlahKwh
        );


        // ==========================================
        // 10. HITUNG TOTAL BAYAR
        // ==========================================

        double totalBayar =
            nominalToken + biayaAdmin;

            System.out.println("\n=== RINCIAN PEMBAYARAN ===");
            System.out.println("Nominal Token : Rp" + nominalToken);
            System.out.println("Biaya Admin   : Rp" + biayaAdmin);
            System.out.println("Total Bayar   : Rp" + totalBayar);


        // ==========================================
        // 11. PILIH METODE PEMBAYARAN
        // ==========================================

        Pembayaran pembayaran = null;

        while (pembayaran == null) {

            System.out.println("\n=== METODE PEMBAYARAN ===");
            System.out.println("1. Tunai");
            System.out.println("2. QRIS");

            System.out.print("Pilihan : ");
            int pilihanPembayaran = inputUser.nextInt();
            inputUser.nextLine();
    
            if (pilihanPembayaran == 1) {
                
                double uangDibayar = 0;

                while (uangDibayar < totalBayar) {

                System.out.print("Uang Dibayar : Rp");
                uangDibayar = inputUser.nextDouble();
                inputUser.nextLine();

                if (uangDibayar < totalBayar) {
                    System.out.println("Uang yang dibayarkan kurang!");
                }
            }

            pembayaran = new PembayaranTunai(
                    totalBayar,
                    tanggal,
                    waktu,
                    uangDibayar
                );

            } else if (pilihanPembayaran == 2) {

                String nomorReferensiQRIS =
                "QRIS" + System.currentTimeMillis();
                
                pembayaran = new PembayaranQRIS(
                totalBayar,
                tanggal,
                waktu,
                nomorReferensiQRIS
            );
        
        } else {
            System.out.println("Pilihan pembayaran tidak valid!");
        }
    }


        // ==========================================
        // 12. MEMBUAT NOMOR STRUK
        // ==========================================

        String nomorStruk =
            "STR" + (strukList.size() + 1);


        // ==========================================
        // 13. MEMBUAT OBJEK STRUK
        // ==========================================

        Struk struk = new Struk(
            nomorStruk,
            kasir,
            plnPraBayar,
            pembayaran
        );

        strukList.add(struk);


        // ==========================================
        // 14. PROSES PEMBAYARAN
        // ==========================================

        pembayaran.prosesPembayaran();


        // ==========================================
        // 15. TAMPILKAN HASIL TRANSAKSI
        // ==========================================

        System.out.println("\n========================================");
        System.out.println("          TRANSAKSI BERHASIL");
        System.out.println("========================================");

        System.out.println("Nomor Struk    : "
        + struk.getNomorStruk());

        System.out.println("Tanggal        : "
        + pembayaran.getTanggal());

        System.out.println("Waktu          : "
        + pembayaran.getWaktu());

        System.out.println("Kasir          : "
        + kasir.getNama());

        System.out.println("Nama Pelanggan : "
        + plnPraBayar.getNama());

        System.out.println("ID Pelanggan   : "
        + plnPraBayar.getIdPel());

        System.out.println("Nomor Meter    : "
        + plnPraBayar.getNoMeter());

        System.out.println("Tarif/Daya     : "
        + plnPraBayar.getTarifDaya());

        System.out.println("Nominal Token  : Rp"
        + plnPraBayar.getNominalToken());

        System.out.println("Biaya Admin    : Rp"
        + plnPraBayar.getBiayaAdmin());

        System.out.println("Total Bayar    : Rp"
        + struk.hitungTotalBayar());

        System.out.println("Jumlah kWh     : "
        + plnPraBayar.getJumlahKwh()
        + " kWh");

        System.out.println("No. Ref        : "
        + plnPraBayar.getNoRef());

        System.out.println("Token          : "
        + formatToken(plnPraBayar.getToken()));

        System.out.println("========================================");


        // ==========================================
        // 16. MENYIMPAN DATA KE FILE
        // ==========================================

        simpanKeFile(strukList, fileName);


        inputUser.close();
    }


    // ==================================================
    // METHOD GENERATE TOKEN
    // ==================================================

    public static String generateToken() {

        String token = "";

        for (int i = 0; i < 20; i++) {

            int angka = (int) (Math.random() * 10);

            token += angka;
        }

        return token;
    }


    // ==================================================
    // METHOD FORMAT TOKEN
    // ==================================================

    public static String formatToken(String token) {

        return token.substring(0, 4) + " "
             + token.substring(4, 8) + " "
             + token.substring(8, 12) + " "
             + token.substring(12, 16) + " "
             + token.substring(16, 20);
    }


    // ==================================================
    // METHOD SIMPAN DATA KE FILE
    // ==================================================

    public static void simpanKeFile(
            ArrayList<Struk> strukList,
            String fileName) {

        try {

            FileWriter fw = new FileWriter(fileName);

            for (Struk struk : strukList) {

                Kasir kasir = struk.getKasir();
                PLNPraBayar pln = struk.getPlnPraBayar();
                Pembayaran pembayaran = struk.getPembayaran();

                String jenisPembayaran = "";
                String infoPembayaran = "";

                if (pembayaran instanceof PembayaranTunai) {

                    jenisPembayaran = "Tunai";

                    PembayaranTunai tunai =
                    (PembayaranTunai) pembayaran;

                    infoPembayaran =
                    String.valueOf(tunai.getUangDibayar());

                } else if (pembayaran instanceof PembayaranQRIS) {

                    jenisPembayaran = "QRIS";

                    PembayaranQRIS qris =
                    (PembayaranQRIS) pembayaran;

                    infoPembayaran =
                    qris.getNomorReferensi();
                }

                fw.write(
                    struk.getNomorStruk() + ","
                    + kasir.getIdKasir() + ","
                    + kasir.getNama() + ","
                    + pembayaran.getTanggal() + ","
                    + pembayaran.getWaktu() + ","
                    + pln.getNoMeter() + ","
                    + pln.getIdPel() + ","
                    + pln.getNama() + ","
                    + pln.getTarifDaya() + ","
                    + pln.getNoRef() + ","
                    + pln.getToken() + ","
                    + pln.getNominalToken() + ","
                    + pln.getBiayaAdmin() + ","
                    + pln.getJumlahKwh() + ","
                    + jenisPembayaran + ","
                    + pembayaran.getJumlah() + ","
                    + infoPembayaran
                );

                fw.write(System.lineSeparator());
            }
            fw.close();

            System.out.println(
                "\nData transaksi berhasil disimpan ke "
                + fileName
            );

        } catch (IOException e) {

            System.out.println(
                "Terjadi kesalahan saat menulis file."
            );

            e.printStackTrace();
        }
    }
}