public abstract class Pembayaran { //berfungsi sebagai template
    private double jumlah;
    private String tanggal;
    private String waktu;

    // Constructor #1 - dengan parameter
    public Pembayaran(double jumlah, String tanggal, String waktu) {
        this.jumlah = jumlah;
        this.tanggal = tanggal;
        this.waktu = waktu;
    }

    // Constructor #2 - kosong
    public Pembayaran() {
        this.jumlah = 0;
        this.tanggal = "";
        this.waktu = "";
    }

    // Getter
    public double getJumlah() {
        return jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    // Setter
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    // Abstract method
    public abstract void prosesPembayaran();
}