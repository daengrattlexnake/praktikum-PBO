import java.util.ArrayList;
import java.util.Scanner;

public class KlinikPasien {
    private static Scanner scanner = new Scanner(System.in);

    public static void menuPasien(ArrayList<Pasien> daftarPasien) {
        while (true) {
            System.out.println("\n=== Menu Pasien Klinik ===");
            System.out.println("1. Daftar Sebagai Pasien Baru");
            System.out.println("2. Lihat Antrian Anda");
            System.out.println("3. Informasi Klinik");
            System.out.println("4. Batal Antrian");
            System.out.println("5. Kembali ke Menu Utama");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    daftarPasienBaru(daftarPasien);
                    break;
                case 2:
                    lihatAntrian(daftarPasien);
                    break;
                case 3:
                    informasiKlinik();
                    break;
                case 4:
                    batalAntrian(daftarPasien);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void daftarPasienBaru(ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan keluhan pasien: ");
        String keluhan = scanner.nextLine();

        daftarPasien.add(new Pasien(nama, umur, keluhan));
        System.out.println("Pasien berhasil didaftarkan!");
    }

    private static void lihatAntrian(ArrayList<Pasien> daftarPasien) {
        System.out.println("\nDaftar Pasien di Antrian:");
        if (daftarPasien.isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
        } else {
            for (int i = 0; i < daftarPasien.size(); i++) {
                System.out.println((i + 1) + ". " + daftarPasien.get(i));
            }
        }
    }

    private static void informasiKlinik() {
        System.out.println("\nInformasi Klinik:");
        System.out.println("Jam buka: 08:00 - 17:00");
        System.out.println("Dokter: Dr. John, Dr. Maria, Dr. Alan");
        System.out.println("Hari pelayanan: Senin - Jumat");
    }

    private static void batalAntrian(ArrayList<Pasien> daftarPasien) {
        System.out.print("Masukkan nama pasien yang ingin membatalkan antrian: ");
        String nama = scanner.nextLine();
        boolean found = false;
        
        for (Pasien pasien : daftarPasien) {
            if (pasien.getNama().equalsIgnoreCase(nama)) {
                daftarPasien.remove(pasien);
                System.out.println("Antrian pasien " + nama + " berhasil dibatalkan.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Pasien dengan nama tersebut tidak ditemukan.");
        }
    }
}
