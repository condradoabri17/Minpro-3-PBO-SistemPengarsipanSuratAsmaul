# Sistem Pengarsipan Surat Asrama Putra Universitas Mulawarman

## 1. Deskripsi Program

Sistem Pengarsipan Surat Asrama Putra Universitas Mulawarman merupakan program yang dirancang untuk membantu sekretaris asrama dalam mengelola arsip surat masuk dan surat keluar.

Sebelumnya, proses pengarsipan dilakukan menggunakan Excel dan menyimpan file surat ke dalam gdrive. Kondisi tersebut dapat menyebabkan pekerjaan yang berulang serta menyulitkan ketika sekretaris perlu mencari kembali data surat tertentu.

Sistem ini dibuat sebagai solusi untuk memusatkan pencatatan informasi arsip surat dalam satu sistem, sekaligus melakukan digitalisasi pada pengarsipan surat Asrama Putra Unmul. Sistem ini berfokus pada pengelolaan informasi arsip yang meliputi pencatatan, pencarian, perubahan, dan penghapusan data surat.

Selain arsip surat, sistem ini juga menyediakan data penghuni asrama untuk mendukung pembuatan surat keluar dan pengarsipan database penghuni. Data tersebut dapat digunakan sebagai referensi ketika sekretaris membutuhkan informasi penghuni dalam proses administrasi surat.

## 2. Kebutuhan Sistem

### Surat Masuk

Sekretaris dapat:

- Melihat arsip surat masuk.
- Menambahkan surat masuk.
- Mengubah data surat masuk.
- Menghapus surat masuk.
- Mencari surat berdasarkan pihak pengirim.

Informasi yang dikelola:

- Nomor surat
- Perihal
- Tanggal surat masuk
- Pengirim

### Surat Keluar

Sekretaris dapat:

- Melihat arsip surat keluar.
- Menambahkan surat keluar.
- Mengubah data surat keluar.
- Menghapus surat keluar.
- Mencari surat berdasarkan pihak penerima.
- Mencari surat berdasarkan kategori.

Informasi yang dikelola:

- Nomor surat
- Perihal
- Kategori
- Tanggal keluar
- Penerima

### Data Penghuni

Sistem menyediakan data penghuni yang meliputi:

- Nama
- NIM
- Asal daerah
- Fakultas
- Jurusan
- Status
- Keterangan

Keterangan bersifat opsional karena tidak semua penghuni membutuhkan informasi tambahan.

## 3. Struktur Package

main:
Main.java

model:
- ArsipSurat.java
- Surat.java
- SuratMasuk.java
- SuratKeluar.java
- Penghuni.java

controller:
ArsipController.java

view:
View.java

## 4. Alur Program

Program dimulai dari Main.java, kemudian sistem menampilkan menu melalui View. Pengguna kemudian memilih ingin melakukan proses pengelolaan surat atau data penghuni. Setelah menginput pilihan, input tersebut diteruskan ke ArsipController yang kemudian diteruskan lagi dan diproses menggunakan objek pada Model, kemudian hasil proses ditampilkan kembali melalui View.

## 5. Penerapan MVC

### Model

Model digunakan untuk merepresentasikan data dan objek yang digunakan, yaitu:

- ArsipSurat
- Surat
- SuratMasuk
- SuratKeluar
- Penghuni

Model menangani struktur data dan objek dalam sistem.

### View

View.java adalah program yang nantinya akan berinteraksi dengan pengguna.

View berfungsi untuk:

- Menampilkan menu.
- Menerima input pengguna.
- Menampilkan hasil proses.

### Controller

ArsipController.java digunakan sebagai penghubung antara View dan Model.

Controller menangani:

- Menambahkan data.
- Mengubah data.
- Menghapus data.
- Mengambil data.
- Mencari data.

## 6. Encapsulation

Encapsulation digunakan untuk menjaga agar data pada objek tidak dapat diakses dan diubah secara bebas dari luar class.

Data surat dan penghuni dikelola melalui getter dan setter yang merupakan metode akses terhadap data.

Penerapan ini penting karena data administrasi perlu mmerupakan data sensitif, sehingga perlu dibatasi. Setter juga dapat digunakan untuk melakukan validasi terhadap data yang diberikan.

Pada data keterangan penghuni, sistem memperbolehkan nilai null karena keterangan merupakan informasi yang bersifat opsional.

## 7. Inheritance

Surat masuk dan surat keluar memiliki beberapa karakteristik umum, seperti nomor surat dan perihal, tetapi juga memiliki karakteristik khusus masing-masing.

Karena keduanya merupakan jenis dari surat, digunakan inheritance dengan Surat yang memiliki informasi yang dipakai di kedua jenis surat, yaitu:

- Urutan surat
- Nomor surat
- Perihal

SuratMasuk:
- Tanggal surat masuk
- Pengirim
SuratKeluar:
- Kategori surat
- Tanggal keluar surat
- Penerima

Penerapan inheritance digunakan agar karakteristik yang sama dapat dikelola pada satu struktur dasar dan tidak perlu dibuat berulang pada setiap jenis surat.

## 8. Abstraction

Sistem memiliki konsep umum mengenai sebuah surat, tetapi surat masuk dan surat keluar memiliki informasi serta kebutuhan yang berbeda.

Oleh karena itu, Surat digunakan sebagai abstract class yang menjadi dasar bagi SuratMasuk dan SuratKeluar.

Abstraction digunakan untuk menentukan karakteristik dan perilaku umum yang harus dimiliki oleh setiap jenis surat, sementara detail yang berbeda dapat ditentukan oleh masing-masing jenis surat.

Salah satu perilaku yang harus dimiliki setiap jenis surat adalah kemampuan untuk menampilkan informasi surat melalui tampilkanDaftarSurat().

Method tersebut dibuat sebagai abstract method agar setiap jenis surat dapat menentukan cara menampilkan informasinya sesuai karakteristik masing-masing.

## 9. Polymorphism

Polymorphism digunakan agar suatu konsep atau operasi dapat memiliki perilaku yang berbeda sesuai dengan kebutuhan sistem.

Pada sistem ini polymorphism diterapkan melalui **overriding** dan **overloading**.

### 9.1 Overriding

Surat masuk dan surat keluar memiliki informasi yang berbeda sehingga cara menampilkan informasinya juga berbeda.

Method tampilkanDaftarSurat() pada struktur dasar surat diterapkan kembali pada:

- SuratMasuk
- SuratKeluar

Overriding digunakan agar setiap jenis surat dapat menampilkan informasi sesuai dengan karakteristiknya masing-masing.

Dengan demikian, satu perilaku umum dapat diimplementasi berbeda berdasarkan jenis surat.

### 9.2 Overloading

Dalam proses pengarsipan, sekretaris memiliki dua kebutuhan pencarian yang berbeda.

Pertama, sekretaris dapat mencari surat berdasarkan pihak yang terlibat, yaitu pengirim pada surat masuk atau penerima pada surat keluar.

Kedua, sekretaris dapat mencari surat keluar berdasarkan kategori.

Kedua kebutuhan tersebut tetap merupakan aktivitas pencarian surat, sehingga digunakan satu nama operasi dengan parameter yang berbeda, yaitu:

cariSurat(String pihak)
cariSurat(int kategori)

Dengan demikian, overloading digunakan untuk menangani kebutuhan pencarian yang berbeda dalam satu method cariSurat(), dengan membedakan parameter yang diberikan sesuai dengan jenis pencarian yang dilakukan.

## 10. Nilai Tambah (Interface)

Sistem menggunakan **interface ArsipSurat** untuk memastikan bahwa setiap jenis surat harus memiliki kemampuan untuk menampilkan daftar surat melalui method void tampilkanDaftarSurat();

Interface tersebut kemudian diimplementasikan oleh abstract class Surat, sehingga SuratMasuk dan SuratKeluar yang merupakan turunan dari Surat juga memiliki kewajiban untuk menerapkan method tersebut.

Penerapan interface digunakan untuk memberikan aturan umum mengenai perilaku yang harus tersedia pada objek surat, tanpa menentukan bagaimana perilaku tersebut dilakukan. Detail cara menampilkan informasi kemudian disesuaikan oleh masing-masing jenis surat melalui overriding.

## 11. Kesimpulan

Sistem Pengarsipan Surat Asrama Putra Universitas Mulawarman dirancang untuk membantu sekretaris dalam mengelola arsip surat masuk, surat keluar, serta data penghuni secara lebih terstruktur.

Sistem menerapkan konsep **MVC** untuk memisahkan pengelolaan data, tampilan, dan proses sistem. Konsep **encapsulation** digunakan untuk menjaga dan memvalidasi data, sedangkan **inheritance** dan **abstraction** digunakan untuk mengelola karakteristik umum serta perbedaan antara surat masuk dan surat keluar. **Polymorphism** diterapkan melalui overriding dan overloading untuk menyesuaikan perilaku sistem dengan kebutuhan pengelolaan dan pencarian surat.

Selain konsep wajib tersebut, sistem juga menerapkan **interface `ArsipSurat`** untuk memberikan method wajib bagi objek surat.

Dengan penerapan konsep tersebut, sistem tidak hanya memenuhi kebutuhan pengarsipan surat, tetapi juga memiliki struktur program yang lebih terorganisir.
