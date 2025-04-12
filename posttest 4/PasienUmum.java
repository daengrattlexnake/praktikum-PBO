class PasienUmum extends Pasien {
    public PasienUmum(String nama, int umur, String keluhan) {
        super(nama, umur, keluhan);
    }

    @Override
    public String toString() {
        return "[Umum] " + super.toString();
    }
}