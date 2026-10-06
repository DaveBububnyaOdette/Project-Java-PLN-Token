public class PembayaranQRIS extends Pembayaran {
    private String nomorReferensi;

    // Constructor #1 - dengan parameter
    public PembayaranQRIS(double jumlah, String tanggal, String waktu,
                          String nomorReferensi) {

        super(jumlah, tanggal, waktu);
        this.nomorReferensi = nomorReferensi;
    }

    // Constructor #2 - kosong
    public PembayaranQRIS() {
        super();
        this.nomorReferensi = "";
    }

    // Getter
    public String getNomorReferensi() {
        return nomorReferensi;
    }

    // Setter
    public void setNomorReferensi(String nomorReferensi) {
        this.nomorReferensi = nomorReferensi;
    }

    // Override abstract method dari Pembayaran
    @Override
    public void prosesPembayaran() {
        System.out.println("Pembayaran QRIS berhasil.");
        System.out.println("Nomor Referensi: " + nomorReferensi);
    }
}