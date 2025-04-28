public class PasienBPJS extends Pasien {
    private String nomorBPJS;

    public PasienBPJS(String nama, int umur, String keluhan, String nomorBPJS) {
        super(nama, umur, keluhan);
        this.nomorBPJS = nomorBPJS;
    }

    public void setNomorBPJS(String nomorBPJS) {
        this.nomorBPJS = nomorBPJS;
    }

    public String getNomorBPJS() {
        return nomorBPJS;
    }

    @Override
    public void infoTambahan() {
        System.out.println("Jenis Pasien: BPJS. Nomor: " + nomorBPJS);
    }
}
