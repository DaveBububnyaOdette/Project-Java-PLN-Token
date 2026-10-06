public class PLNPraBayar {
    private String noMeter;
    private String idPel;
    private String nama;
    private String tarifDaya;
    private String noRef;
    private String token;
    private double nominalToken;
    private double biayaAdmin;
    private double jumlahKwh;

    // Constructor #1 - dengan parameter
    public PLNPraBayar(String noMeter, String idPel, String nama,
                       String tarifDaya, String noRef, String token,
                       double nominalToken, double biayaAdmin,
                       double jumlahKwh) {

        this.noMeter = noMeter;
        this.idPel = idPel;
        this.nama = nama;
        this.tarifDaya = tarifDaya;
        this.noRef = noRef;
        this.token = token;
        this.nominalToken = nominalToken;
        this.biayaAdmin = biayaAdmin;
        this.jumlahKwh = jumlahKwh;
    }

    // Constructor #2 - kosong
    public PLNPraBayar() {
        this.noMeter = "";
        this.idPel = "";
        this.nama = "";
        this.tarifDaya = "";
        this.noRef = "";
        this.token = "";
        this.nominalToken = 0;
        this.biayaAdmin = 3500;
        this.jumlahKwh = 0;
    }

    // Getter
    public String getNoMeter() {
        return noMeter;
    }

    public String getIdPel() {
        return idPel;
    }

    public String getNama() {
        return nama;
    }

    public String getTarifDaya() {
        return tarifDaya;
    }

    public String getNoRef() {
        return noRef;
    }

    public String getToken() {
        return token;
    }

    public double getNominalToken() {
        return nominalToken;
    }

    public double getBiayaAdmin() {
        return biayaAdmin;
    }

    public double getJumlahKwh() {
        return jumlahKwh;
    }

    // Setter
    public void setNoMeter(String noMeter) {
        this.noMeter = noMeter;
    }

    public void setIdPel(String idPel) {
        this.idPel = idPel;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setTarifDaya(String tarifDaya) {
        this.tarifDaya = tarifDaya;
    }

    public void setNoRef(String noRef) {
        this.noRef = noRef;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setNominalToken(double nominalToken) {
        this.nominalToken = nominalToken;
    }

    public void setBiayaAdmin(double biayaAdmin) {
        this.biayaAdmin = biayaAdmin;
    }

    public void setJumlahKwh(double jumlahKwh) {
        this.jumlahKwh = jumlahKwh;
    }
}