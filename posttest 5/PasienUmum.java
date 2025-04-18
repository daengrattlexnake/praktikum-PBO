class PasienUmum extends Pasien {
    public PasienUmum(String nama, int umur, String keluhan) {
        super(nama, umur, keluhan);
    }

    @Override
    public void infoTambahan() {
        System.out.println("Pasien umum tidak memiliki asuransi khusus.");
    }
}
