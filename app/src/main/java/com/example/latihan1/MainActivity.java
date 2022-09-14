package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainAct";

    // Deklarasi Variabel -> spesifikasi tipe data
    String namaBidang;
    int panjang, lebar, jariJari;
    double luas, keliling;
    byte angka;

    // Deklarasi Array harus menggunakan kurung siku di belakang nama variable
    // Inisialisasi Array dengan langsung mengisikan value-nya
    String dataBidang[] = {"Lingkaran", "Persegi", "Segitiga", "Lingkaran"}; // Array Dinamic
    // Inisialisasi Array dengan definisi ukuran Array
    int dataPanjang[] = new int[4]; // Array Static
    int dataLebar[] = new int[4];

    @Override // Sama Halnya seperti int main() -> Program akan dieksekusi pertama kali adalah int main()
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Array Dinamic => Data Array yang dimasukkan tidak terbatas pada suatu ukuran array yang telah ditentukan
        ArrayList<String> dataBidang = new ArrayList<>();
        ArrayList<Integer> dataPanjang = new ArrayList<>();
        ArrayList<Integer> dataLebar = new ArrayList<>();

        // Menambahkan suatu value pada ArrayList bisa menggunakan .add() contoh => dataBidang.add(Masukkan Value nya sesuai dengan tipe data yang dibuat)
        dataBidang.add("Lingkaran");
        dataBidang.add("Persegi Panjang");
        dataBidang.add("Segitiga");
        dataBidang.add("Persegi Panjang");
        dataBidang.add("Jajaran Genjang");
        dataBidang.add("Lingkaran");

        // Menambahkan suatu value pada ArrayList menggunakan looping
        for (int i = 0; i < dataBidang.size(); i++){
            dataPanjang.add((i + 5) * 2);
            dataLebar.add(i * 3 + 9);
        }
        // Output
        // Looping Foreach
        int i = 0;
        for (String bidang: dataBidang){
            Log.i(TAG,"Perhitungan ke-"+ (i+1));
            // .get() => berfungsi untuk mendapatkan suatu value dari ArrayList
            namaBidang = bidang;
            // ' -> Petik satu digunakan untuk tipe data char
            // "-> Petik dua digunakan untuk tipe data string
            panjang = dataPanjang.get(i); // Bisa diibaratkan sebagai diameter
            lebar = dataLebar.get(i);

            if(namaBidang.equalsIgnoreCase("Persegi Panjang")){
                hitungPersegi();
            } else if (namaBidang.equalsIgnoreCase("Lingkaran")){
                hitungLingkaran();
            } else {
                Log.w(TAG, "Bidang "+namaBidang+ " tidak dikenali");
            }
            i++;
        }


        // Mengkonversi suatu bilangan angka
        // byte ukuran 8 bits -> int ukuran 32 bits (BISA) Karena logika nya sebuah tandon air yang kosong diisi dengan sebuah botol air mineral
            //angka = 10;
            //panjang = angka;
        // int ukuran 32 bits -> byte ukuran 8 bits (TIDAK BISA) Karena logika nya air tandon dipaksa masuk ke dalam cangkir pasti akan tumpah semua airnya
        // Karena terjadi error maka -> kita harus melakukan Casting
        /* Casting -> Merubah dari satu tipe data ke tipe data lainnya yang sejenis misal : byte -> int atau short -> long atau float -> double bahkan double -> int
            angka = (byte)lebar;
            Log.i(TAG, "Konversi 32 bits ke 8 bits : "+angka);

            luas = 75.56;
            // Wadah penampung lebih kecil daripada value yang ingin kita masukkan maka akan terjadi error -> Maka harus dilakukan casting
            panjang = (int) luas;

            Log.i(TAG, "Konversi double(64 bits) ke int(32 bits) : "+panjang); */

        //hello();

    }

    public void hello(){
        System.out.println("Selamat Datang di Pemrograman Java Menggunakan Android Studio");

        Log.d(TAG, "Selamat Datang di Pemrograman Java Menggunakan Android Studio");
        Log.i(TAG, "Ini berupa info untuk pemrograman Android");
        Log.w(TAG, "Barangkali untuk peringatan khusus bisa ditampilkan disini");
        Log.e(TAG, "Ini jelas untuk menampilkan pesan error");
    }

    public void konversi(){
        String strPanjang = "75";
        String strLuas = "78.95";

        /*
            Catatan Penting :
            Value tipe data String dikonversi -> tipe data lain
            Contoh Syntax :
            String -> Int
            Integer.parseInt(variable yang value nya String)
            String -> Double
            Double.parseDouble(variable yang value nya String)

         */
        panjang = Integer.parseInt(strPanjang); // Untuk mengkonversi suatu value tipe data String -> Integer
        luas = Double.parseDouble(strLuas) * 78; // Untuk mengkonversi suatu value tipe data String -> Double


        /*
            Catatan Penting :
            Value dengan tipe data apapun jika dikonversi -> ke tipe data string
            Contoh Syntax :
            Double -> String
            Double.toString(variable yang value nya Double)
            Integer -> String
            Integer.toString(variable yang value nya Integer)
         */

        Log.i(TAG, Double.toString(luas)); // Perlu mengkoversi suatu tipe data double -> string dengan cara pakai Func Double.toString()
        Log.i(TAG, Integer.toString(panjang)); // Perlu mengkonversi suatu tipe data int -> string dengan cara Pakai Func Integer.toString()
    }

    public void hitungPersegi(){
        namaBidang = "Persegi Panjang";
        luas = panjang * lebar;
        keliling = (2 * panjang) + (2 * lebar);

        Log.i(TAG, "Bidang : " + namaBidang);
        Log.i(TAG, "Dengan panjang : " + panjang + " dan lebar : " + lebar);
        Log.i(TAG, "Luasnya adalah : " + luas);
        Log.i(TAG, "Kelilingnya adalah : " + keliling);
    }

    public void hitungLingkaran(){
        namaBidang = "Lingkaran";
        jariJari = panjang/2;
        luas = Math.PI * Math.pow(jariJari,2);
        keliling = 2 * Math.PI * jariJari;

        Log.i(TAG, "Bidang : " + namaBidang);
        Log.i(TAG, "Dengan Jari-Jari : " +jariJari);
        Log.i(TAG, "Luasnya adalah : " + luas);
        Log.i(TAG, "Kelilingnya adalah : " + keliling);
    }

    public void arrayPersegi(){
        dataPanjang[0] = 15;
        dataPanjang[1] = 20;
        dataPanjang[2] = 4;
        dataPanjang[3] = 24;

        for (int i = 0; i < 4; i++){
            // Inisialisasi value data array menggunakan looping
            dataPanjang[i] = (i + 5) * 2; // Bisa diibaratkan sebagai diameter
            dataLebar[i] = i * 3 + 9;
        }
        // Looping For
        for (int i = 0; i < 4; i++){
            Log.i(TAG,"Perhitungan ke-"+ (i+1));
            namaBidang = dataBidang[i];
            // ' -> Petik satu digunakan untuk tipe data char
            // "-> Petik dua digunakan untuk tipe data string
            panjang = dataPanjang[i]; // Bisa diibaratkan sebagai diameter
            lebar = dataLebar[i];

            if(namaBidang.equalsIgnoreCase("Persegi Panjang")){
                hitungPersegi();
            } else if (namaBidang.equalsIgnoreCase("Lingkaran")){
                hitungLingkaran();
            } else {
                Log.w(TAG, "Bidang "+namaBidang+ " tidak dikenali");
            }
        }
        //int i = 0;
        // Looping While
        /*while(i < 4){
            Log.i(TAG,"Perhitungan ke-"+ (i+1));
            namaBidang = "lInGkArAn";
            // ' -> Petik satu digunakan untuk tipe data char
            // "-> Petik dua digunakan untuk tipe data string
            panjang = (i + 5) * 2; // Bisa diibaratkan sebagai diameter
            lebar = i * 3 + 9;

            if(namaBidang.equalsIgnoreCase("Persegi Panjang")){
                hitungPersegi();
                hitung();
            } else if (namaBidang.equalsIgnoreCase("Lingkaran")){
                hitungLingkaran();
                hitung();
            } else {
                Log.w(TAG, "Bidang "+namaBidang+ " tidak dikenali");
            }
            i++;
        } */
    }
}