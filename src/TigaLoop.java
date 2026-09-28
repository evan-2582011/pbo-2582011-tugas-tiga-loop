import java.util.Scanner;

public class TigaLoop {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        // ===== 1. Satu deret, tiga loop (masing-masing punya pencacah sendiri) =====
        System.out.println();
        System.out.println("===== SATU DERET, TIGA LOOP =====");

        // Versi for: pencacah a
        System.out.print("for      : ");
        for (int a = 1; a <= n; a++) {
            System.out.print(a + " ");
        }
        System.out.println();

        // Versi while: pencacah b (jangan lupa dinaikkan, kalau tidak loop tak berhenti)
        System.out.print("while    : ");
        int b = 1;
        while (b <= n) {
            System.out.print(b + " ");
            b++;
        }
        System.out.println();

        // Versi do-while: pencacah c
        System.out.print("do-while : ");
        int c = 1;
        do {
            System.out.print(c + " ");
            c++;
        } while (c <= n);
        System.out.println();

        // ===== 3. Bukti meleset satu (off-by-one) =====
        // i < n berputar n-1 kali, i <= n berputar n kali
        System.out.println();

        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }
        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }
        System.out.println("i <  n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");

        // ===== 4. Saringan 1-10 dengan continue dan break =====
        int tercetak = 0;
        System.out.print("Disaring : ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;   // lewati angka genap
            }
            if (i > 7) {
                break;      // berhenti kalau i > 7
            }
            System.out.print(i + " ");
            tercetak++;     // dihitung hanya kalau println benar-benar tercapai
        }
        System.out.println();
        System.out.println("Sampai println  : " + tercetak + " kali");

        input.close();
    }
}

/*
 * ===================== JAWABAN & KOMENTAR =====================
 *
 * ---- 2. Keluaran dua kali jalan ----
 *
 * Jalankan pertama, n = 5:
 *
 * Batas deret (n) : 5
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      : 1 2 3 4 5
 * while    : 1 2 3 4 5
 * do-while : 1 2 3 4 5
 *
 * i <  n berputar : 4 kali
 * i <= n berputar : 5 kali
 * Disaring : 1 3 5 7
 * Sampai println  : 4 kali
 *
 * Jalankan kedua, n = 0:
 *
 * Batas deret (n) : 0
 *
 * ===== SATU DERET, TIGA LOOP =====
 * for      :
 * while    :
 * do-while : 1
 *
 * ---- Kenapa dua baris pertama kosong, tapi baris ketiga tidak? ----
 * Pada n = 0, for dan while mengecek kondisi (1 <= 0) SEBELUM badan loop
 * dijalankan. Kondisinya langsung false, sehingga badan loop tidak pernah
 * dijalankan dan barisnya kosong. do-while menjalankan badan loop dulu
 * (mencetak 1) baru mengecek kondisinya (2 <= 0 false), sehingga angka 1
 * tetap tercetak.
 *
 * Kesimpulan: do-while mengecek kondisinya sesudah badan loop dijalankan,
 * jadi badannya pasti jalan minimal sekali.
 *
 * ---- 3. Off-by-one ----
 * Dengan n = 5, i < n berputar 4 kali (i = 1..4), sedangkan i <= n berputar
 * 5 kali (i = 1..5). Beda satu hanya karena satu tanda "=".
 *
 * ---- 5. Kenapa loop tidak berhenti di i = 8? ----
 * Karena urutan di dalam badan loop: continue (lewati genap) diperiksa LEBIH
 * DULU daripada break. Saat i = 8, angka genap, sehingga continue langsung
 * melompat ke iterasi berikutnya dan pengecekan "i > 7" tidak pernah
 * tercapai. Loop baru berhenti saat i = 9 (ganjil, lolos continue, lalu
 * 9 > 7 memicu break). Karena itu keluarannya 1 3 5 7 dan println tercapai
 * 4 kali.
 */

