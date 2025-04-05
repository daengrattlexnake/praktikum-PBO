public class PasienUmum extends Pasien {
    private double biaya;

    public PasienUmum(String nama, int umur, String keluhan, double biaya) {
        super(nama, umur, keluhan);
        this.biaya = biaya;
    }

    public double getBiaya() {
        return biaya;
    }

    public void setBiaya(double biaya) {
        this.biaya = biaya;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipe: Umum, Biaya: Rp" + biaya;
    }
}