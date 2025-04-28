import java.util.ArrayList;
import java.util.Scanner;

public final class KlinikAntrian {
    private static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static int totalPasien = 0;  // static variable

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n=== Sistem Klinik ===");
                System.out.println("1. Masuk sebagai Admin");
                System.out.println("2. Masuk sebagai Pasien");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        menuAdmin();
                        break;
                    case 2:
                        KlinikPasien.menuPasien(daftarPasien);
                        break;
                    case 3:
                        System.out.println("Terima kasih! Program selesai.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void menuAdmin() {
        while (true) {
            try {
                System.out.println("\n=== Menu Admin Klinik ===");
                System.out.println("1. Tambah Pasien Umum");
                System.out.println("2. Tambah Pasien BPJS");
                System.out.println("3. Lihat Daftar Pasien");
                System.out.println("4. Ubah Data Pasien");
                System.out.println("5. Hapus Pasien");
                System.out.println("6. Tampilkan Total Pasien");
                System.out.println("7. Kembali ke Menu Utama");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahPasienUmum();
                        break;
                    case 2:
                        tambahPasienBPJS();
                        break;
                    case 3:
                        lihatPasien();
                        break;
                    case 4:
                        ubahPasien();
                        break;
                    case 5:
                        hapusPasien();
                        break;
                    case 6:
                        tampilkanTotalPasien();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void tambahPasienUmum() {
        try {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien: ");
            int umur = scanner.nextInt(); scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();

            Pasien pasien = new PasienUmum(nama, umur, keluhan);
            daftarPasien.add(pasien);
            pasien.daftar();
            System.out.println("Pasien umum berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan pasien: " + e.getMessage());
        }
    }

    private static void tambahPasienBPJS() {
        try {
            System.out.print("Masukkan nama pasien: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan umur pasien: ");
            int umur = scanner.nextInt(); scanner.nextLine();
            System.out.print("Masukkan keluhan pasien: ");
            String keluhan = scanner.nextLine();
            System.out.print("Masukkan nomor BPJS: ");
            String nomorBPJS = scanner.nextLine();

            Pasien pasien = new PasienBPJS(nama, umur, keluhan, nomorBPJS);
            daftarPasien.add(pasien);
            pasien.daftar();
            System.out.println("Pasien BPJS berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambahkan pasien BPJS: " + e.getMessage());
        }
    }

    private static void lihatPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Tidak ada pasien dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Pasien:");
        for (int i = 0; i < daftarPasien.size(); i++) {
            Pasien p = daftarPasien.get(i);
            System.out.println((i + 1) + ". " + p);
            p.infoTambahan();
        }
    }

    private static void ubahPasien() {
        lihatPasien();
        if (daftarPasien.isEmpty()) return;
        try {
            System.out.print("Pilih nomor pasien yang ingin diubah: ");
            int index = scanner.nextInt() - 1; scanner.nextLine();
            if (index < 0 || index >= daftarPasien.size()) {
                System.out.println("Nomor pasien tidak valid.");
                return;
            }
            Pasien pasien = daftarPasien.get(index);
            System.out.print("Masukkan nama baru: ");
            pasien.setNama(scanner.nextLine());
            System.out.print("Masukkan umur baru: ");
            pasien.setUmur(scanner.nextInt()); scanner.nextLine();
            System.out.print("Masukkan keluhan baru: ");
            pasien.setKeluhan(scanner.nextLine());
            if (pasien instanceof PasienBPJS) {
                System.out.print("Masukkan nomor BPJS baru: ");
                ((PasienBPJS) pasien).setNomorBPJS(scanner.nextLine());
            }
            System.out.println("Data pasien berhasil diubah!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat mengubah data pasien: " + e.getMessage());
        }
    }

    private static void hapusPasien() {
        lihatPasien();
        if (daftarPasien.isEmpty()) return;
        try {
            System.out.print("Pilih nomor pasien yang ingin dihapus: ");
            int index = scanner.nextInt() - 1; scanner.nextLine();
            if (index < 0 || index >= daftarPasien.size()) {
                System.out.println("Nomor pasien tidak valid.");
                return;
            }
            Pasien pasien = daftarPasien.get(index);
            pasien.batalDaftar();
            daftarPasien.remove(index);
            totalPasien--;  // static decrement
            System.out.println("Pasien berhasil dihapus!");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menghapus pasien: " + e.getMessage());
        }
    }

    public static void tampilkanTotalPasien() {
        System.out.println("Total pasien terdaftar: " + totalPasien);
    }
}
