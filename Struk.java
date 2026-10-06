public class Struk {
    private String nomorStruk;
    private Kasir kasir;
    private PLNPraBayar plnPraBayar;
    private Pembayaran pembayaran;

    public Struk(String nomorStruk, Kasir kasir,
                 PLNPraBayar plnPraBayar,
                 Pembayaran pembayaran) {
        this.nomorStruk = nomorStruk;
        this.kasir = kasir;
        this.plnPraBayar = plnPraBayar;
        this.pembayaran = pembayaran;
    }

    public Struk() {
        this.nomorStruk = "";
        this.kasir = null;
        this.plnPraBayar = null;
        this.pembayaran = null;
    }

    public String getNomorStruk() {
        return nomorStruk;
    }

    public Kasir getKasir() {
        return kasir;
    }

    public PLNPraBayar getPlnPraBayar() {
        return plnPraBayar;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setNomorStruk(String nomorStruk) {
        this.nomorStruk = nomorStruk;
    }

    public void setKasir(Kasir kasir) {
        this.kasir = kasir;
    }

    public void setPlnPraBayar(PLNPraBayar plnPraBayar) {
        this.plnPraBayar = plnPraBayar;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public double hitungTotalBayar() {
        return plnPraBayar.getNominalToken()
                + plnPraBayar.getBiayaAdmin();
    }
}