public class PasienBPJS extends Pasien {
    private String noBPJS;

    public PasienBPJS(String nama, int umur, String keluhan, String noBPJS) {
        super(nama, umur, keluhan);
        this.noBPJS = noBPJS;
    }

    public String getNoBPJS() {
        return noBPJS;
    }

    public void setNoBPJS(String noBPJS) {
        this.noBPJS = noBPJS;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipe: BPJS, No BPJS: " + noBPJS;
    }
}