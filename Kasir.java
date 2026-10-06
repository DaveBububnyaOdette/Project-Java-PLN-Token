public class Kasir {
    private String idKasir;
    private String nama;
    private String username;
    private String password;

    // Constructor #1 - dengan parameter
    public Kasir(String idKasir, String nama, String username, String password) {
        this.idKasir = idKasir;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    // Constructor #2 - kosong
    public Kasir() {
        this.idKasir = "";
        this.nama = "";
        this.username = "";
        this.password = "";
    }

    // Getter
    public String getIdKasir() {
        return idKasir;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}