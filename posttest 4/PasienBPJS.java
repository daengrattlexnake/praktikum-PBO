class PasienBPJS extends Pasien {
    public PasienBPJS(String nama, int umur, String keluhan) {
        super(nama, umur, keluhan);
    }

    @Override
    public String toString() {
        return "[BPJS] " + super.toString();
    }
}