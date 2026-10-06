public class Pelanggan {
    private String idPelanggan;
    private String nama;

    // Constructor #1 - dengan parameter
    public Pelanggan(String idPelanggan, String nama) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
    }

    // Constructor #2 - kosong
    public Pelanggan() {
        this.idPelanggan = "";
        this.nama = "";
    }

    // Getter
    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }
}