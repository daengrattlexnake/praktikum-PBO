abstract class Pasien {
    private final String tipePasien = "Umum"; 
    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    public String getTipePasien() {
        return tipePasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur harus lebih dari 0!");
        }
    }

    public int getUmur() {
        return umur;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public abstract void infoTambahan(); 

    public final void tampilkanIdentitas() { 
        System.out.println("Pasien Klinik - Tipe: " + tipePasien);
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Umur: " + umur + ", Keluhan: " + keluhan;
    }
}
