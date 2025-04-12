class Pasien {
    private String nama;
    private int umur;
    private String keluhan;

    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }

    public Pasien(String nama, int umur) { 
        this.nama = nama;
        this.umur = umur;
        this.keluhan = "Tidak ada keluhan";
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

    public void setKeluhan(String keluhan, boolean penting) {
        if (penting) {
            this.keluhan = "[PENTING] " + keluhan;
        } else {
            this.keluhan = keluhan;
        }
    }

    public String toString() {
        return "Nama: " + nama + ", Umur: " + umur + ", Keluhan: " + keluhan;
    }
}
