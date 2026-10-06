public class PembayaranTunai extends Pembayaran {
    private double uangDibayar;
    private double kembalian;

    // Constructor #1 - dengan parameter
    public PembayaranTunai(double jumlah, String tanggal, String waktu,
                           double uangDibayar) {

        super(jumlah, tanggal, waktu);
        this.uangDibayar = uangDibayar;
        this.kembalian = 0;
    }

    // Constructor #2 - kosong
    public PembayaranTunai() {
        super();
        this.uangDibayar = 0;
        this.kembalian = 0;
    }

    // Getter
    public double getUangDibayar() {
        return uangDibayar;
    }

    public double getKembalian() {
        return kembalian;
    }

    // Setter
    public void setUangDibayar(double uangDibayar) {
        this.uangDibayar = uangDibayar;
    }

    public void setKembalian(double kembalian) {
        this.kembalian = kembalian;
    }

    // Menghitung kembalian
    public double hitungKembalian() {
        kembalian = uangDibayar - getJumlah();
        return kembalian;
    }

    // Override abstract method dari Pembayaran
    @Override
    public void prosesPembayaran() {
        hitungKembalian();
        System.out.println("Pembayaran tunai berhasil.");
    }
}