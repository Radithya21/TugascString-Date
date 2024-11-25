import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bagian Login
        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("\n+-----------------------------------------------------+");
            System.out.println("\t\t\tLog in");
            System.out.println("+-----------------------------------------------------+");

            System.out.print("Username : ");
            String username = scanner.nextLine().trim(); // Memangkas spasi dari input (Metode String: trim())

            System.out.print("Password : ");
            String password = scanner.nextLine().trim();

            System.out.print("Captcha (Ketik 'AkuManusia') : ");
            String captcha = scanner.nextLine().trim();

            // Validasi input login menggunakan metode String
            if (username.equals("mimin") && password.equals("mautahuya") && captcha.equals("AkuManusia")) { // equals() digunakan untuk membandingkan String
                isLoggedIn = true;
                System.out.println("\nLogin berhasil cuy!");
            } else {
                System.out.println("\nLogin gagal. Coba lagi ya dek.");
            }
        }

        // Tampilkan waktu saat ini
        LocalDateTime now = LocalDateTime.now(); // Mengambil tanggal dan waktu saat ini
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Format tanggal dan waktu
        String formattedDate = now.format(formatter); // Memformat tanggal sesuai pola

        // Setelah login berhasil
        System.out.println("\nSelamat Datang di Supermarket Mimin");
        System.out.println("Tanggal dan Waktu : " + formattedDate);
        System.out.println("+-----------------------------------------------------+");

        // Input Data Transaksi
        try {
            System.out.print("Masukkan No. Faktur\t: ");
            String noFaktur = scanner.nextLine().trim();

            System.out.print("Masukkan Kode Barang\t: ");
            String kodeBarang = scanner.nextLine().trim();

            System.out.print("Masukkan Nama Barang\t: ");
            String namaBarang = scanner.nextLine().trim().toUpperCase(); // Metode String: toUpperCase() untuk mengubah ke huruf besar

            double hargaBarang;
            while (true) {
                System.out.print("Masukkan Harga Barang\t: ");
                hargaBarang = Double.parseDouble(scanner.nextLine().trim()); // Konversi String ke double
                if (hargaBarang > 0) break; // Harga valid jika lebih besar dari 0
                System.out.println("\nHarga barang harus lebih dari 0. Silakan masukkan lagi.");
            }

            int jumlahBeli;
            while (true) {
                System.out.print("Masukkan Jumlah Beli\t: ");
                jumlahBeli = Integer.parseInt(scanner.nextLine().trim()); // Konversi String ke integer
                if (jumlahBeli > 0) break; // Jumlah valid jika lebih besar dari 0
                System.out.println("\nJumlah beli harus lebih dari 0. Silakan masukkan lagi.");
            }

            double total = hargaBarang * jumlahBeli;

            // Tampilkan faktur
            System.out.println("\n\n+-----------------------------------------------------+");
            System.out.println("No. Faktur      : " + noFaktur);
            System.out.println("Kode Barang     : " + kodeBarang);
            System.out.println("Nama Barang     : " + namaBarang);
            System.out.println("Harga Barang    : Rp" + hargaBarang);
            System.out.println("Jumlah Beli     : " + jumlahBeli);
            System.out.println("TOTAL           : Rp" + total);
            System.out.println("+-----------------------------------------------------+");
            System.out.println("Kasir : Otong Surotong");
            System.out.println("+-----------------------------------------------------+");
        } catch (NumberFormatException e) {
            System.out.println("\nTerjadi kesalahan dalam input data angka. " + e.getMessage());
        }

        scanner.close();
    }
}