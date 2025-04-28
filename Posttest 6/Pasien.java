public abstract class Pasien implements Pendaftaran {
    private final String tipePasien = "Umum";
    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        try {
            if (nama == null || nama.trim().isEmpty()) {
                throw new IllegalArgumentException("Nama pasien tidak boleh kosong!");
            }
            this.nama = nama;
            setUmur(umur);
            this.keluhan = keluhan;
            KlinikAntrian.totalPasien++; // static variable increment
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            System.out.println("Umur harus lebih dari 0!");
        }
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    @Override
    public void daftar() {
        System.out.println(nama + " berhasil mendaftar sebagai " + tipePasien + ".");
    }

    @Override
    public void batalDaftar() {
        System.out.println(nama + " membatalkan pendaftaran.");
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
