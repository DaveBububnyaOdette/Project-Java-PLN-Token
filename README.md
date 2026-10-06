# Project Java OOP - Sistem Pembelian Token PLN

Anggota Kelompok:\
Samuel Lie - 825250102\
Benz Christian Immanuel - 825250104\
Dave Joseph Immanuel Tanuwidjaja - 825250150

Kelas SI/C 25

Project ini merupakan program Java OOP untuk simulasi pembelian
token PLN prabayar di Indomaret.

## Deskripsi

Program digunakan untuk melakukan simulasi transaksi pembelian
token PLN prabayar, mulai dari input data pelanggan, pemilihan
nominal token, pemilihan metode pembayaran, hingga penyimpanan
data transaksi ke dalam file TXT.

## Fitur

- Input data pelanggan
- Input nomor meter dan tarif/daya
- Pilihan nominal token Rp20.000, Rp50.000, dan Rp100.000
- Generate token PLN 20 digit
- Pembayaran tunai
- Pembayaran QRIS
- Perhitungan biaya administrasi
- Pembuatan struk transaksi
- Penyimpanan data transaksi menggunakan file TXT

## Konsep OOP

Project ini menerapkan beberapa konsep Object-Oriented Programming:

- Encapsulation
- Inheritance
- Abstraction
- Polymorphism
- Association

## Class

- `App`
- `Kasir`
- `Pelanggan`
- `PLNPraBayar`
- `Pembayaran`
- `PembayaranTunai`
- `PembayaranQRIS`
- `Struk`

## File

- `App.java` - Program utama
- `Kasir.java` - Data kasir
- `Pelanggan.java` - Data pelanggan
- `PLNPraBayar.java` - Data pembelian token PLN
- `Pembayaran.java` - Abstract class pembayaran
- `PembayaranTunai.java` - Pembayaran tunai
- `PembayaranQRIS.java` - Pembayaran QRIS
- `Struk.java` - Data dan proses struk transaksi
- `transaksi.txt` - Penyimpanan data transaksi
