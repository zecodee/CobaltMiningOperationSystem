# RANCANGAN ERD C-MOS
## Cobalt Mining Operation System

C-MOS merupakan sistem informasi yang digunakan untuk mendukung pengelolaan kegiatan operasional pertambangan Cobalt. Sistem mencakup pengelolaan pegawai dan akun pengguna, data master, produksi tambang, pengangkutan material, monitoring lingkungan, serta penyajian informasi kepada Manager.

---

# 1. Keterangan Notasi

| Notasi | Keterangan |
|---|---|
| **PK** | Primary Key, atribut yang menjadi identitas unik setiap data |
| **FK** | Foreign Key, atribut yang digunakan untuk menghubungkan satu entitas dengan entitas lain |
| **UQ** | Unique, nilai atribut tidak boleh sama dengan data lainnya |
| **M** | Mandatory, atribut wajib memiliki nilai dan tidak boleh `NULL` |
| **O** | Optional, atribut boleh tidak memiliki nilai atau `NULL` |
| **AUTO** | Nilai atribut ditentukan secara otomatis oleh sistem |
| **SUPERTYPE** | Entitas induk yang menyimpan atribut umum |
| **SUBTYPE** | Entitas turunan yang mewarisi data dari Supertype dan memiliki atribut khusus |
| **1** | Tepat satu |
| **0..1** | Nol atau satu |
| **0..\*** | Nol atau banyak |
| **1..\*** | Satu atau banyak |

---

# 2. PEGAWAI

**Jenis Entitas: SUPERTYPE**

## Penjelasan dan Fungsi

`PEGAWAI` merupakan Supertype yang digunakan untuk menyimpan data umum seluruh pegawai yang terlibat dalam C-MOS.

Setiap Pegawai wajib menjadi salah satu dari lima Subtype berikut:

- `ADMIN`
- `PETUGAS_OPERASIONAL`
- `PETUGAS_HSE`
- `MANAGER`
- `DRIVER`

Specialization yang digunakan adalah **TOTAL dan DISJOINT**.

- **TOTAL** berarti setiap data `PEGAWAI` wajib menjadi salah satu Subtype.
- **DISJOINT** berarti satu Pegawai hanya boleh menjadi satu Subtype.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK | **M / AUTO** |
| `nama_pegawai` | VARCHAR(100) | - | **M** |
| `no_hp` | VARCHAR(20) | - | **M** |
| `tanggal_masuk` | DATE | - | **M** |
| `status_pegawai` | ENUM('AKTIF','NONAKTIF') | - | **M / AUTO** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan sebagai identitas unik setiap Pegawai. Nilainya dibuat otomatis oleh sistem sehingga Admin tidak perlu memasukkan ID secara manual. Atribut ini juga digunakan sebagai penghubung antara `PEGAWAI` dengan masing-masing Subtype.

### `nama_pegawai`

Digunakan untuk menyimpan nama lengkap Pegawai. Nama digunakan untuk mengenali Pegawai pada berbagai proses dan tampilan aplikasi.

### `no_hp`

Digunakan untuk menyimpan nomor telepon Pegawai. Tipe data `VARCHAR` digunakan karena nomor telepon bukan angka yang digunakan untuk perhitungan serta dapat memiliki angka `0` pada bagian awal.

### `tanggal_masuk`

Digunakan untuk mencatat tanggal ketika Pegawai mulai bekerja.

### `status_pegawai`

Digunakan untuk menunjukkan apakah Pegawai masih aktif atau sudah nonaktif. Ketika Pegawai baru dibuat, sistem secara otomatis memberikan nilai:

```text
AKTIF
```

## Relasi

`PEGAWAI` memiliki relasi Supertype-Subtype dengan:

```text
PEGAWAI
   │
   ├── ADMIN
   ├── PETUGAS_OPERASIONAL
   ├── PETUGAS_HSE
   ├── MANAGER
   └── DRIVER
```

`PEGAWAI` juga berelasi dengan `USER`.

```text
PEGAWAI 1 ───────── 0..1 USER
```

Satu Pegawai dapat memiliki nol atau satu akun User. Relasi dari Pegawai ke User bersifat **opsional**, karena Driver tidak memiliki akun dan Pegawai yang membutuhkan akun dapat dibuat terlebih dahulu sebelum User dibuat.

Setiap `USER` wajib terhubung dengan tepat satu `PEGAWAI`.

---

# 3. ADMIN

**Jenis Entitas: SUBTYPE dari PEGAWAI**

## Penjelasan dan Fungsi

`ADMIN` merupakan Subtype dari `PEGAWAI` yang digunakan untuk menyimpan data khusus Pegawai dengan jenis Admin.

Admin bertanggung jawab mengelola data master C-MOS, seperti Pegawai, User, Lokasi, Jenis Material, Kendaraan, dan Parameter Lingkungan.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK → PEGAWAI | **M** |
| `kode_admin` | VARCHAR(20) | UQ | **M** |
| `tanggal_mulai_akses` | DATE | - | **M** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan untuk menghubungkan data Admin dengan data umum miliknya pada entitas `PEGAWAI`. Nilainya sama dengan `id_pegawai` pada Supertype.

### `kode_admin`

Digunakan sebagai kode khusus untuk mengidentifikasi Admin. Nilainya dibuat unik agar tidak terdapat dua Admin dengan kode yang sama.

### `tanggal_mulai_akses`

Digunakan untuk mencatat tanggal ketika Pegawai mulai diberikan akses sebagai Admin pada C-MOS.

## Relasi

`ADMIN` merupakan Subtype dari `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 ADMIN
```

Setiap Admin wajib memiliki tepat satu data pada `PEGAWAI`.

Karena specialization bersifat **DISJOINT**, Pegawai yang menjadi Admin tidak dapat sekaligus menjadi Petugas Operasional, Petugas HSE, Manager, atau Driver.

---

# 4. PETUGAS_OPERASIONAL

**Jenis Entitas: SUBTYPE dari PEGAWAI**

## Penjelasan dan Fungsi

`PETUGAS_OPERASIONAL` merupakan Subtype dari `PEGAWAI` yang menyimpan data khusus Petugas Operasional.

Petugas Operasional bertanggung jawab melakukan pencatatan Produksi Tambang dan mengelola kegiatan Pengangkutan material.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK → PEGAWAI | **M** |
| `area_tugas` | VARCHAR(100) | - | **M** |
| `shift_kerja` | ENUM('PAGI','SIANG','MALAM') | - | **M** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan untuk menghubungkan Petugas Operasional dengan data umum miliknya pada `PEGAWAI`.

### `area_tugas`

Digunakan untuk menyimpan informasi area utama tempat Petugas Operasional bertugas, misalnya `Pit A`.

### `shift_kerja`

Digunakan untuk menentukan shift kerja Petugas Operasional.

Nilai yang tersedia:

```text
PAGI
SIANG
MALAM
```

Atribut `kode_petugas_operasional` **tidak digunakan lagi** sesuai revisi rancangan. Petugas Operasional sudah dapat diidentifikasi melalui `id_pegawai`.

## Relasi

`PETUGAS_OPERASIONAL` merupakan Subtype dari `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 PETUGAS_OPERASIONAL
```

Petugas Operasional berelasi dengan `PRODUKSI_TAMBANG`.

```text
PETUGAS_OPERASIONAL 1 ───────── 0..* PRODUKSI_TAMBANG
```

Satu Petugas Operasional dapat mencatat banyak Produksi Tambang. Setiap Produksi Tambang wajib dicatat oleh satu Petugas Operasional.

Petugas Operasional juga berelasi dengan `PENGANGKUTAN`.

```text
PETUGAS_OPERASIONAL 1 ───────── 0..* PENGANGKUTAN
```

Satu Petugas Operasional dapat mengelola banyak kegiatan Pengangkutan. Setiap Pengangkutan wajib dikelola oleh satu Petugas Operasional.

---

# 5. PETUGAS_HSE

**Jenis Entitas: SUBTYPE dari PEGAWAI**

## Penjelasan dan Fungsi

`PETUGAS_HSE` merupakan Subtype dari `PEGAWAI` yang menyimpan data khusus Petugas HSE.

Dalam ruang lingkup C-MOS, Petugas HSE bertanggung jawab melakukan monitoring kondisi lingkungan pada lokasi pertambangan serta melakukan pencatatan tindak lanjut apabila ditemukan kondisi peringatan.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK → PEGAWAI | **M** |
| `no_sertifikasi_hse` | VARCHAR(50) | UQ | **M** |
| `masa_berlaku_sertifikasi` | DATE | - | **M** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan untuk menghubungkan Petugas HSE dengan data umum miliknya pada `PEGAWAI`.

### `no_sertifikasi_hse`

Digunakan untuk menyimpan nomor sertifikasi HSE yang dimiliki Petugas. Nomor sertifikasi dibuat unik agar tidak digunakan oleh lebih dari satu Petugas HSE.

### `masa_berlaku_sertifikasi`

Digunakan untuk mencatat batas waktu berlakunya sertifikasi HSE. Data ini dapat digunakan sistem untuk memastikan sertifikasi Petugas HSE masih berlaku ketika melakukan monitoring.

## Relasi

`PETUGAS_HSE` merupakan Subtype dari `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 PETUGAS_HSE
```

Petugas HSE berelasi dengan `MONITORING_LINGKUNGAN`.

```text
PETUGAS_HSE 1 ───────── 0..* MONITORING_LINGKUNGAN
```

Satu Petugas HSE dapat melakukan banyak kegiatan Monitoring Lingkungan. Setiap Monitoring Lingkungan wajib dilakukan oleh satu Petugas HSE.

---

# 6. MANAGER

**Jenis Entitas: SUBTYPE dari PEGAWAI**

## Penjelasan dan Fungsi

`MANAGER` merupakan Subtype dari `PEGAWAI` yang menyimpan data khusus Pegawai dengan jenis Manager.

Manager menggunakan C-MOS untuk melihat Dashboard dan Laporan sebagai bahan pemantauan serta pengambilan keputusan.

Manager tidak melakukan pencatatan Produksi, Pengangkutan, atau Monitoring Lingkungan secara langsung.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK → PEGAWAI | **M** |
| `divisi_tanggung_jawab` | VARCHAR(100) | - | **M** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan untuk menghubungkan Manager dengan data umum miliknya pada `PEGAWAI`.

### `divisi_tanggung_jawab`

Digunakan untuk menyimpan informasi mengenai divisi yang menjadi tanggung jawab Manager.

Contoh:

```text
Operasional Pertambangan
```

Atribut `kode_manager` **tidak digunakan lagi** sesuai revisi rancangan. Manager sudah dapat diidentifikasi melalui `id_pegawai`.

## Relasi

`MANAGER` merupakan Subtype dari `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 MANAGER
```

Manager tidak memiliki relasi langsung dengan entitas transaksi karena Manager berfungsi sebagai pengguna yang melihat Dashboard dan Laporan dari data yang sudah dihasilkan oleh sistem.

---

# 7. DRIVER

**Jenis Entitas: SUBTYPE dari PEGAWAI**

## Penjelasan dan Fungsi

`DRIVER` merupakan Subtype dari `PEGAWAI` yang menyimpan data khusus Driver.

Driver bertugas mengemudikan Kendaraan dalam kegiatan Pengangkutan material.

Driver **tidak memiliki akun USER dan tidak melakukan login** ke aplikasi C-MOS.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK → PEGAWAI | **M** |
| `no_sim` | VARCHAR(50) | UQ | **M** |
| `masa_berlaku_sim` | DATE | - | **M** |
| `status_driver` | ENUM('TERSEDIA','BERTUGAS','NONAKTIF') | - | **M / AUTO** |

## Penjelasan Atribut

### `id_pegawai`

Digunakan untuk menghubungkan Driver dengan data umum miliknya pada `PEGAWAI`.

### `no_sim`

Digunakan untuk menyimpan nomor SIM Driver. Nilainya dibuat unik agar satu nomor SIM tidak digunakan oleh dua Driver.

### `masa_berlaku_sim`

Digunakan untuk mencatat tanggal berakhirnya masa berlaku SIM. Sistem dapat menggunakan atribut ini untuk memastikan SIM masih berlaku sebelum Driver ditugaskan.

### `status_driver`

Digunakan untuk menunjukkan kondisi operasional Driver.

Ketika Driver baru dibuat:

```text
status_driver = TERSEDIA
```

Ketika Driver mulai melakukan Pengangkutan:

```text
status_driver = BERTUGAS
```

Setelah Pengangkutan selesai:

```text
status_driver = TERSEDIA
```

Status `NONAKTIF` digunakan apabila Driver tidak dapat ditugaskan lagi.

## Relasi

`DRIVER` merupakan Subtype dari `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 DRIVER
```

Driver berelasi dengan `PENGANGKUTAN`.

```text
DRIVER 1 ───────── 0..* PENGANGKUTAN
```

Satu Driver dapat memiliki banyak riwayat Pengangkutan. Setiap Pengangkutan wajib menggunakan satu Driver.

---

# 8. USER

## Penjelasan dan Fungsi

`USER` digunakan untuk menyimpan akun yang digunakan untuk login ke C-MOS.

User hanya dapat dimiliki oleh:

- Admin
- Petugas Operasional
- Petugas HSE
- Manager

Driver tidak memiliki User.

`USER` tidak menggunakan atribut `role` karena hak akses ditentukan berdasarkan Subtype dari Pegawai yang terhubung dengan akun tersebut.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_user` | INT | PK | **M / AUTO** |
| `id_pegawai` | INT | FK → PEGAWAI, UQ | **M** |
| `username` | VARCHAR(50) | UQ | **M** |
| `password` | VARCHAR(255) | - | **M** |

## Penjelasan Atribut

### `id_user`

Digunakan sebagai identitas unik setiap akun User. Nilainya dibuat otomatis oleh sistem.

### `id_pegawai`

Digunakan untuk menentukan Pegawai yang memiliki akun tersebut.

Atribut ini dibuat `UNIQUE` sehingga satu Pegawai hanya dapat memiliki maksimal satu akun User.

### `username`

Digunakan sebagai identitas pengguna ketika melakukan login. Username wajib unik agar tidak terdapat dua akun dengan username yang sama.

### `password`

Digunakan sebagai kredensial keamanan ketika pengguna melakukan login.

Tipe `VARCHAR(255)` digunakan agar dapat menampung password dalam bentuk hash pada implementasi keamanan sistem.

## Relasi

`USER` berelasi dengan `PEGAWAI`.

```text
PEGAWAI 1 ───────── 0..1 USER
```

Dari sisi Pegawai, kepemilikan User bersifat **opsional**.

Dari sisi User, hubungan ke Pegawai bersifat **mandatory**, karena setiap akun User wajib dimiliki oleh satu Pegawai.

---

# 9. LOKASI

## Penjelasan dan Fungsi

`LOKASI` digunakan untuk menyimpan data lokasi yang digunakan dalam kegiatan operasional pertambangan.

Lokasi pada C-MOS dibedakan menjadi:

- `PIT`
- `STOCKPILE`

`PIT` digunakan sebagai lokasi kegiatan produksi tambang, sedangkan `STOCKPILE` digunakan sebagai lokasi penyimpanan atau tujuan Pengangkutan material.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_lokasi` | INT | PK | **M / AUTO** |
| `nama_lokasi` | VARCHAR(100) | - | **M** |
| `jenis_lokasi` | ENUM('PIT','STOCKPILE') | - | **M** |
| `status_operasional` | ENUM('AKTIF','DIBATASI','DITUTUP_SEMENTARA') | - | **M** |
| `keterangan` | VARCHAR(255) | - | **O** |

## Penjelasan Atribut

### `id_lokasi`

Digunakan sebagai identitas unik setiap Lokasi dan dibuat otomatis oleh sistem.

### `nama_lokasi`

Digunakan untuk menyimpan nama lokasi agar mudah dikenali.

Contoh:

```text
Pit A
Pit B
Stockpile Utama
```

### `jenis_lokasi`

Digunakan untuk membedakan fungsi lokasi.

`PIT` digunakan sebagai lokasi Produksi Tambang.

`STOCKPILE` digunakan sebagai lokasi penyimpanan atau tujuan Pengangkutan material.

### `status_operasional`

Digunakan untuk menunjukkan kondisi penggunaan lokasi.

Nilai yang tersedia:

```text
AKTIF
DIBATASI
DITUTUP_SEMENTARA
```

`AKTIF` berarti lokasi dapat digunakan secara normal.

`DIBATASI` berarti penggunaan lokasi sedang dibatasi.

`DITUTUP_SEMENTARA` berarti lokasi untuk sementara tidak digunakan dalam kegiatan operasional.

### `keterangan`

Digunakan untuk menyimpan informasi tambahan mengenai Lokasi.

Atribut ini bersifat **optional** karena tidak semua Lokasi membutuhkan keterangan tambahan.

## Relasi

Lokasi berelasi dengan `PRODUKSI_TAMBANG`.

```text
LOKASI 1 ───────── 0..* PRODUKSI_TAMBANG
```

Satu Lokasi dapat memiliki banyak catatan Produksi Tambang. Setiap Produksi Tambang wajib berada pada satu Lokasi.

Lokasi berelasi dengan `PENGANGKUTAN` sebagai lokasi asal.

```text
LOKASI 1 ───────── 0..* PENGANGKUTAN
        sebagai lokasi asal
```

Lokasi juga berelasi dengan `PENGANGKUTAN` sebagai lokasi tujuan.

```text
LOKASI 1 ───────── 0..* PENGANGKUTAN
        sebagai lokasi tujuan
```

Lokasi juga berelasi dengan `MONITORING_LINGKUNGAN`.

```text
LOKASI 1 ───────── 0..* MONITORING_LINGKUNGAN
```

Satu Lokasi dapat memiliki banyak riwayat Monitoring Lingkungan.

---

# 10. JENIS_MATERIAL

## Penjelasan dan Fungsi

`JENIS_MATERIAL` merupakan data master yang digunakan untuk menyimpan jenis material yang dihasilkan atau ditangani dalam kegiatan pertambangan.

Contoh:

```text
Cobalt Ore
Overburden
```

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_material` | INT | PK | **M / AUTO** |
| `nama_material` | VARCHAR(100) | - | **M** |
| `satuan` | VARCHAR(20) | - | **M** |
| `deskripsi` | VARCHAR(255) | - | **O** |

## Penjelasan Atribut

### `id_material`

Digunakan sebagai identitas unik setiap Jenis Material dan dibuat otomatis oleh sistem.

### `nama_material`

Digunakan untuk menyimpan nama material yang digunakan dalam proses Produksi Tambang.

### `satuan`

Digunakan untuk menentukan satuan pengukuran material.

Contoh:

```text
Ton
```

### `deskripsi`

Digunakan untuk memberikan informasi tambahan mengenai Jenis Material.

Atribut ini bersifat **optional** karena tidak semua material membutuhkan penjelasan tambahan.

## Relasi

`JENIS_MATERIAL` berelasi dengan `PRODUKSI_TAMBANG`.

```text
JENIS_MATERIAL 1 ───────── 0..* PRODUKSI_TAMBANG
```

Satu Jenis Material dapat digunakan pada banyak catatan Produksi Tambang. Setiap Produksi Tambang wajib menggunakan satu Jenis Material.

---

# 11. KENDARAAN

## Penjelasan dan Fungsi

`KENDARAAN` digunakan untuk menyimpan data kendaraan yang digunakan dalam kegiatan Pengangkutan material.

Data Kendaraan digunakan untuk memastikan kendaraan tersedia serta memiliki kapasitas yang cukup untuk membawa jumlah muatan yang direncanakan.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_kendaraan` | INT | PK | **M / AUTO** |
| `jenis_kendaraan` | VARCHAR(50) | - | **M** |
| `nomor_polisi` | VARCHAR(20) | UQ | **M** |
| `kapasitas` | DECIMAL(10,2) | - | **M** |
| `tahun_kendaraan` | YEAR | - | **M** |
| `status_kendaraan` | ENUM('TERSEDIA','DIGUNAKAN','NONAKTIF') | - | **M / AUTO** |

## Penjelasan Atribut

### `id_kendaraan`

Digunakan sebagai identitas unik setiap Kendaraan dan dibuat otomatis oleh sistem.

### `jenis_kendaraan`

Digunakan untuk menyimpan jenis kendaraan.

Contoh:

```text
Dump Truck
```

### `nomor_polisi`

Digunakan sebagai identitas registrasi kendaraan. Nilainya dibuat unik karena satu nomor polisi hanya digunakan oleh satu kendaraan.

### `kapasitas`

Digunakan untuk menyimpan kapasitas maksimum muatan Kendaraan.

Atribut ini digunakan dalam validasi Pengangkutan agar jumlah muatan tidak melebihi kapasitas Kendaraan.

### `tahun_kendaraan`

Digunakan untuk menyimpan tahun Kendaraan sebagai bagian dari data master.

### `status_kendaraan`

Digunakan untuk menunjukkan kondisi operasional Kendaraan.

Ketika Kendaraan baru dibuat:

```text
status_kendaraan = TERSEDIA
```

Ketika Pengangkutan dimulai:

```text
status_kendaraan = DIGUNAKAN
```

Setelah Pengangkutan selesai:

```text
status_kendaraan = TERSEDIA
```

`NONAKTIF` digunakan apabila Kendaraan tidak dapat digunakan dalam kegiatan operasional.

## Relasi

`KENDARAAN` berelasi dengan `PENGANGKUTAN`.

```text
KENDARAAN 1 ───────── 0..* PENGANGKUTAN
```

Satu Kendaraan dapat digunakan pada banyak riwayat Pengangkutan. Setiap Pengangkutan wajib menggunakan satu Kendaraan.

---

# 12. PRODUKSI_TAMBANG

## Penjelasan dan Fungsi

`PRODUKSI_TAMBANG` digunakan untuk mencatat hasil produksi material pada suatu lokasi PIT.

Produksi dicatat oleh Petugas Operasional. Sistem menyimpan jumlah produksi awal dan jumlah material yang masih tersedia untuk diangkut.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_produksi` | INT | PK | **M / AUTO** |
| `id_material` | INT | FK → JENIS_MATERIAL | **M** |
| `id_lokasi` | INT | FK → LOKASI | **M** |
| `id_petugas_operasional` | INT | FK → PETUGAS_OPERASIONAL | **M / AUTO** |
| `tanggal_produksi` | DATE | - | **M** |
| `jumlah_produksi` | DECIMAL(12,2) | - | **M** |
| `jumlah_tersedia` | DECIMAL(12,2) | - | **M / AUTO** |
| `status_produksi` | ENUM('TERSEDIA','SEBAGIAN_DIANGKUT','HABIS') | - | **M / AUTO** |

## Penjelasan Atribut

### `id_produksi`

Digunakan sebagai identitas unik setiap catatan Produksi Tambang dan dibuat otomatis oleh sistem.

### `id_material`

Digunakan untuk menentukan Jenis Material yang dihasilkan pada kegiatan Produksi.

### `id_lokasi`

Digunakan untuk menentukan lokasi PIT tempat Produksi dilakukan.

### `id_petugas_operasional`

Digunakan untuk mencatat Petugas Operasional yang melakukan pencatatan Produksi.

Dalam aplikasi, nilai ini dapat diperoleh otomatis berdasarkan Petugas Operasional yang sedang login.

### `tanggal_produksi`

Digunakan untuk mencatat tanggal ketika kegiatan Produksi dilakukan.

### `jumlah_produksi`

Digunakan untuk menyimpan jumlah awal material yang dihasilkan dari kegiatan Produksi.

Nilai `jumlah_produksi` tidak berkurang ketika material diangkut karena atribut ini menjadi catatan jumlah Produksi awal.

### `jumlah_tersedia`

Digunakan untuk menyimpan jumlah material yang masih tersedia untuk diangkut.

Ketika Produksi baru dibuat:

```text
jumlah_tersedia = jumlah_produksi
```

Contoh:

```text
jumlah_produksi = 500 ton
jumlah_tersedia = 500 ton
```

Jika 30 ton selesai diangkut:

```text
jumlah_produksi = 500 ton
jumlah_tersedia = 470 ton
```

### `status_produksi`

Digunakan untuk menunjukkan kondisi material hasil Produksi.

Nilai yang digunakan:

```text
TERSEDIA
SEBAGIAN_DIANGKUT
HABIS
```

Saat Produksi baru dibuat:

```text
status_produksi = TERSEDIA
```

Jika sebagian material sudah diangkut:

```text
status_produksi = SEBAGIAN_DIANGKUT
```

Jika seluruh material sudah diangkut:

```text
status_produksi = HABIS
```

## Relasi

Produksi berelasi dengan `PETUGAS_OPERASIONAL`.

```text
PETUGAS_OPERASIONAL 1 ───────── 0..* PRODUKSI_TAMBANG
```

Produksi berelasi dengan `JENIS_MATERIAL`.

```text
JENIS_MATERIAL 1 ───────── 0..* PRODUKSI_TAMBANG
```

Produksi berelasi dengan `LOKASI`.

```text
LOKASI 1 ───────── 0..* PRODUKSI_TAMBANG
```

Produksi juga berelasi dengan `PENGANGKUTAN`.

```text
PRODUKSI_TAMBANG 1 ───────── 0..* PENGANGKUTAN
```

Satu Produksi dapat memiliki banyak kegiatan Pengangkutan karena material dapat diangkut secara bertahap dalam beberapa perjalanan.

---

# 13. PENGANGKUTAN

## Penjelasan dan Fungsi

`PENGANGKUTAN` digunakan untuk mencatat proses pemindahan material hasil Produksi dari lokasi asal menuju lokasi tujuan.

Pengangkutan dikelola oleh Petugas Operasional dengan menggunakan satu Kendaraan dan satu Driver.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_pengangkutan` | INT | PK | **M / AUTO** |
| `id_produksi` | INT | FK → PRODUKSI_TAMBANG | **M** |
| `id_petugas_operasional` | INT | FK → PETUGAS_OPERASIONAL | **M / AUTO** |
| `id_kendaraan` | INT | FK → KENDARAAN | **M** |
| `id_driver` | INT | FK → DRIVER | **M** |
| `id_lokasi_asal` | INT | FK → LOKASI | **M** |
| `id_lokasi_tujuan` | INT | FK → LOKASI | **M** |
| `tanggal_pengangkutan` | DATE | - | **M** |
| `waktu_mulai` | DATETIME | - | **O / AUTO** |
| `waktu_selesai` | DATETIME | - | **O / AUTO** |
| `jumlah_muatan` | DECIMAL(12,2) | - | **M** |
| `status_pengangkutan` | ENUM('DIJADWALKAN','DALAM_PERJALANAN','SELESAI','DIBATALKAN') | - | **M / AUTO** |

## Penjelasan Atribut

### `id_pengangkutan`

Digunakan sebagai identitas unik setiap kegiatan Pengangkutan dan dibuat otomatis oleh sistem.

### `id_produksi`

Digunakan untuk menentukan Produksi Tambang yang menjadi sumber material yang akan diangkut.

### `id_petugas_operasional`

Digunakan untuk mencatat Petugas Operasional yang mengelola kegiatan Pengangkutan.

Nilainya dapat diperoleh otomatis berdasarkan Petugas Operasional yang sedang login.

### `id_kendaraan`

Digunakan untuk menentukan Kendaraan yang digunakan dalam Pengangkutan.

### `id_driver`

Digunakan untuk menentukan Driver yang mengemudikan Kendaraan.

### `id_lokasi_asal`

Digunakan untuk menentukan lokasi asal material. Pada alur utama C-MOS, lokasi asal mengikuti lokasi PIT dari Produksi Tambang yang dipilih.

### `id_lokasi_tujuan`

Digunakan untuk menentukan lokasi tujuan Pengangkutan, misalnya `Stockpile Utama`.

### `tanggal_pengangkutan`

Digunakan untuk menentukan tanggal kegiatan Pengangkutan dijadwalkan atau dilaksanakan.

### `waktu_mulai`

Digunakan untuk mencatat waktu aktual ketika kegiatan Pengangkutan dimulai.

Atribut ini bersifat **optional** karena ketika Pengangkutan masih `DIJADWALKAN`, kegiatan belum memiliki waktu mulai.

### `waktu_selesai`

Digunakan untuk mencatat waktu ketika Pengangkutan selesai.

Atribut ini bersifat **optional** karena belum memiliki nilai selama Pengangkutan belum selesai.

### `jumlah_muatan`

Digunakan untuk menyimpan jumlah material yang diangkut.

Nilai ini digunakan untuk memvalidasi:

- Ketersediaan material.
- Kapasitas Kendaraan.
- Pengurangan `jumlah_tersedia` Produksi setelah Pengangkutan selesai.

### `status_pengangkutan`

Digunakan untuk menunjukkan tahap kegiatan Pengangkutan.

Ketika dibuat:

```text
DIJADWALKAN
```

Ketika mulai:

```text
DALAM_PERJALANAN
```

Ketika selesai:

```text
SELESAI
```

Jika Pengangkutan yang masih dijadwalkan dibatalkan:

```text
DIBATALKAN
```

## Relasi

Pengangkutan berelasi dengan `PRODUKSI_TAMBANG`.

```text
PRODUKSI_TAMBANG 1 ───────── 0..* PENGANGKUTAN
```

Pengangkutan berelasi dengan `PETUGAS_OPERASIONAL`.

```text
PETUGAS_OPERASIONAL 1 ───────── 0..* PENGANGKUTAN
```

Pengangkutan berelasi dengan `KENDARAAN`.

```text
KENDARAAN 1 ───────── 0..* PENGANGKUTAN
```

Pengangkutan berelasi dengan `DRIVER`.

```text
DRIVER 1 ───────── 0..* PENGANGKUTAN
```

Pengangkutan memiliki dua relasi dengan `LOKASI`.

```text
LOKASI 1 ───────── 0..* PENGANGKUTAN
        sebagai lokasi asal
```

dan:

```text
LOKASI 1 ───────── 0..* PENGANGKUTAN
        sebagai lokasi tujuan
```

---

# 14. PARAMETER_LINGKUNGAN

## Penjelasan dan Fungsi

`PARAMETER_LINGKUNGAN` merupakan data master yang digunakan untuk menyimpan parameter yang diperiksa dalam kegiatan Monitoring Lingkungan.

Contoh Parameter Lingkungan:

```text
pH Air
Debu
Kebisingan
TSS
```

Setiap Parameter dapat memiliki batas minimum, batas maksimum, atau keduanya.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_parameter` | INT | PK | **M / AUTO** |
| `nama_parameter` | VARCHAR(100) | - | **M** |
| `satuan` | VARCHAR(30) | - | **M** |
| `batas_minimum` | DECIMAL(12,2) | - | **O** |
| `batas_maksimum` | DECIMAL(12,2) | - | **O** |
| `keterangan` | VARCHAR(255) | - | **O** |

## Penjelasan Atribut

### `id_parameter`

Digunakan sebagai identitas unik setiap Parameter Lingkungan dan dibuat otomatis oleh sistem.

### `nama_parameter`

Digunakan untuk menyimpan nama Parameter Lingkungan yang akan diperiksa.

### `satuan`

Digunakan untuk menentukan satuan hasil pengukuran Parameter.

Contoh:

```text
pH
µg/m3
dB
mg/L
```

### `batas_minimum`

Digunakan untuk menyimpan nilai minimum yang masih diperbolehkan.

Atribut ini bersifat **optional** karena tidak semua Parameter membutuhkan batas minimum.

### `batas_maksimum`

Digunakan untuk menyimpan nilai maksimum yang masih diperbolehkan.

Atribut ini bersifat **optional** karena tidak semua Parameter membutuhkan batas maksimum.

Contoh:

```text
Parameter : pH Air
Minimum   : 6
Maksimum  : 9
```

Sedangkan:

```text
Parameter : Debu
Minimum   : NULL
Maksimum  : 230
```

### `keterangan`

Digunakan untuk menyimpan informasi tambahan mengenai Parameter Lingkungan.

Atribut ini bersifat **optional**.

## Relasi

`PARAMETER_LINGKUNGAN` berelasi dengan `DETAIL_MONITORING`.

```text
PARAMETER_LINGKUNGAN 1 ───────── 0..* DETAIL_MONITORING
```

Satu Parameter Lingkungan dapat digunakan pada banyak Detail Monitoring. Setiap Detail Monitoring wajib menggunakan satu Parameter Lingkungan.

---

# 15. MONITORING_LINGKUNGAN

## Penjelasan dan Fungsi

`MONITORING_LINGKUNGAN` digunakan untuk menyimpan data utama atau header kegiatan Monitoring Lingkungan yang dilakukan Petugas HSE pada suatu Lokasi.

Satu kegiatan Monitoring dapat memiliki banyak Detail Monitoring karena dalam satu kegiatan dapat dilakukan pengukuran terhadap beberapa Parameter Lingkungan.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_monitoring` | INT | PK | **M / AUTO** |
| `id_lokasi` | INT | FK → LOKASI | **M** |
| `id_petugas_hse` | INT | FK → PETUGAS_HSE | **M / AUTO** |
| `tanggal_monitoring` | DATETIME | - | **M** |
| `status_monitoring` | ENUM('NORMAL','PERINGATAN') | - | **M / AUTO** |
| `tindak_lanjut` | VARCHAR(255) | - | **O** |
| `status_penanganan` | ENUM('TIDAK_DIPERLUKAN','BELUM_DITANGANI','DALAM_PENANGANAN','SELESAI') | - | **M / AUTO** |
| `catatan` | VARCHAR(255) | - | **O** |

## Penjelasan Atribut

### `id_monitoring`

Digunakan sebagai identitas unik setiap kegiatan Monitoring Lingkungan dan dibuat otomatis oleh sistem.

### `id_lokasi`

Digunakan untuk menentukan Lokasi tempat Monitoring dilakukan.

### `id_petugas_hse`

Digunakan untuk menentukan Petugas HSE yang melakukan Monitoring.

Dalam aplikasi, nilai ini dapat diperoleh otomatis berdasarkan Petugas HSE yang sedang login.

### `tanggal_monitoring`

Digunakan untuk mencatat tanggal dan waktu kegiatan Monitoring dilakukan.

### `status_monitoring`

Digunakan untuk menunjukkan hasil keseluruhan Monitoring.

Jika seluruh Detail Monitoring berstatus `NORMAL`, maka:

```text
status_monitoring = NORMAL
```

Jika minimal satu Detail Monitoring berstatus `PERINGATAN`, maka:

```text
status_monitoring = PERINGATAN
```

Status ini ditentukan oleh sistem berdasarkan hasil Detail Monitoring.

### `tindak_lanjut`

Digunakan untuk mencatat tindakan yang perlu dilakukan ketika hasil Monitoring menunjukkan kondisi `PERINGATAN`.

Atribut ini bersifat **optional** karena Monitoring dengan kondisi `NORMAL` tidak memerlukan tindak lanjut.

### `status_penanganan`

Digunakan untuk menunjukkan progres penanganan kondisi lingkungan.

Nilai yang digunakan:

```text
TIDAK_DIPERLUKAN
BELUM_DITANGANI
DALAM_PENANGANAN
SELESAI
```

Jika Monitoring Normal:

```text
status_penanganan = TIDAK_DIPERLUKAN
```

Jika Monitoring Peringatan:

```text
BELUM_DITANGANI
        ↓
DALAM_PENANGANAN
        ↓
SELESAI
```

### `catatan`

Digunakan untuk menyimpan informasi tambahan mengenai kegiatan Monitoring.

Atribut ini bersifat **optional**.

## Relasi

Monitoring berelasi dengan `PETUGAS_HSE`.

```text
PETUGAS_HSE 1 ───────── 0..* MONITORING_LINGKUNGAN
```

Monitoring berelasi dengan `LOKASI`.

```text
LOKASI 1 ───────── 0..* MONITORING_LINGKUNGAN
```

Monitoring juga berelasi dengan `DETAIL_MONITORING`.

```text
MONITORING_LINGKUNGAN 1 ───────── 1..* DETAIL_MONITORING
```

Satu Monitoring yang sudah lengkap memiliki minimal satu Detail Monitoring. Setiap Detail Monitoring wajib menjadi bagian dari satu Monitoring Lingkungan.

---

# 16. DETAIL_MONITORING

## Penjelasan dan Fungsi

`DETAIL_MONITORING` digunakan untuk menyimpan hasil pengukuran setiap Parameter Lingkungan dalam satu kegiatan Monitoring.

Entitas ini diperlukan karena satu kegiatan Monitoring dapat melakukan pengukuran terhadap banyak Parameter.

## Atribut dan Tipe Data

| Atribut | Tipe Data | Key | Status |
|---|---|---|---|
| `id_detail` | INT | PK | **M / AUTO** |
| `id_monitoring` | INT | FK → MONITORING_LINGKUNGAN | **M** |
| `id_parameter` | INT | FK → PARAMETER_LINGKUNGAN | **M** |
| `nilai_pengukuran` | DECIMAL(12,2) | - | **M** |
| `status_detail` | ENUM('NORMAL','PERINGATAN') | - | **M / AUTO** |
| `catatan` | VARCHAR(255) | - | **O** |

## Penjelasan Atribut

### `id_detail`

Digunakan sebagai identitas unik setiap hasil pengukuran dan dibuat otomatis oleh sistem.

### `id_monitoring`

Digunakan untuk menentukan kegiatan Monitoring Lingkungan yang memiliki hasil pengukuran tersebut.

### `id_parameter`

Digunakan untuk menentukan Parameter Lingkungan yang diukur.

### `nilai_pengukuran`

Digunakan untuk menyimpan nilai aktual hasil pengukuran Parameter Lingkungan.

### `status_detail`

Digunakan untuk menunjukkan apakah hasil pengukuran masih berada pada kondisi Normal atau sudah masuk kondisi Peringatan.

Nilai ini tidak dipilih secara manual oleh Petugas HSE, tetapi dihitung otomatis oleh sistem berdasarkan batas Parameter Lingkungan.

Contoh:

```text
Parameter        : Debu
Batas Maksimum   : 230
Nilai Pengukuran : 180
Status Detail    : NORMAL
```

Jika:

```text
Parameter        : Debu
Batas Maksimum   : 230
Nilai Pengukuran : 260
Status Detail    : PERINGATAN
```

### `catatan`

Digunakan untuk menyimpan informasi tambahan mengenai hasil pengukuran tertentu.

Atribut ini bersifat **optional**.

## Relasi

`DETAIL_MONITORING` berelasi dengan `MONITORING_LINGKUNGAN`.

```text
MONITORING_LINGKUNGAN 1 ───────── 1..* DETAIL_MONITORING
```

Satu Monitoring dapat memiliki banyak Detail Monitoring. Setiap Detail Monitoring wajib dimiliki oleh satu Monitoring.

`DETAIL_MONITORING` juga berelasi dengan `PARAMETER_LINGKUNGAN`.

```text
PARAMETER_LINGKUNGAN 1 ───────── 0..* DETAIL_MONITORING
```

Satu Parameter dapat digunakan dalam banyak Detail Monitoring. Setiap Detail wajib menggunakan satu Parameter.

---

# 17. Struktur Supertype dan Subtype

Struktur Supertype dan Subtype pada C-MOS adalah sebagai berikut:

```text
                         PEGAWAI
                    <<SUPERTYPE>>
                     <<ABSTRACT>>
                           │
                    TOTAL + DISJOINT
                           │
        ┌──────────┬───────┼──────────┬───────────┐
        │          │       │          │           │
        ▼          ▼       ▼          ▼           ▼
      ADMIN     PETUGAS  PETUGAS    MANAGER     DRIVER
              OPERASIONAL   HSE
    <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>>
        │          │       │          │           │
      Login      Login    Login      Login    Tidak Login
```

### TOTAL

Setiap data `PEGAWAI` wajib menjadi salah satu Subtype.

Contoh:

```text
Pegawai #1 → ADMIN
Pegawai #2 → PETUGAS_OPERASIONAL
Pegawai #3 → PETUGAS_HSE
Pegawai #4 → MANAGER
Pegawai #5 → DRIVER
```

### DISJOINT

Satu Pegawai hanya dapat menjadi satu Subtype.

Contoh:

```text
Pegawai #5 = DRIVER
```

Maka Pegawai #5 tidak dapat sekaligus menjadi `ADMIN`, `PETUGAS_OPERASIONAL`, `PETUGAS_HSE`, atau `MANAGER`.

---

# 18. Daftar Keseluruhan Entitas

| No | Entitas | Jenis | Fungsi |
|---|---|---|---|
| 1 | `PEGAWAI` | **SUPERTYPE** | Menyimpan data umum seluruh Pegawai |
| 2 | `ADMIN` | **SUBTYPE** | Menyimpan data khusus Admin |
| 3 | `PETUGAS_OPERASIONAL` | **SUBTYPE** | Menyimpan data khusus Petugas Operasional |
| 4 | `PETUGAS_HSE` | **SUBTYPE** | Menyimpan data khusus Petugas HSE |
| 5 | `MANAGER` | **SUBTYPE** | Menyimpan data khusus Manager |
| 6 | `DRIVER` | **SUBTYPE** | Menyimpan data khusus Driver |
| 7 | `USER` | Akun | Menyimpan akun login pengguna |
| 8 | `LOKASI` | Master | Menyimpan data PIT dan Stockpile |
| 9 | `JENIS_MATERIAL` | Master | Menyimpan jenis material pertambangan |
| 10 | `KENDARAAN` | Master | Menyimpan data kendaraan Pengangkutan |
| 11 | `PRODUKSI_TAMBANG` | Transaksi | Mencatat hasil Produksi Tambang |
| 12 | `PENGANGKUTAN` | Transaksi | Mencatat proses Pengangkutan material |
| 13 | `PARAMETER_LINGKUNGAN` | Master | Menyimpan Parameter dan batas lingkungan |
| 14 | `MONITORING_LINGKUNGAN` | Transaksi/Header | Mencatat kegiatan Monitoring Lingkungan |
| 15 | `DETAIL_MONITORING` | Transaksi/Detail | Menyimpan hasil pengukuran Parameter |

Total rancangan C-MOS terdiri dari **15 entitas**.

---

# 19. Ringkasan Relasi Antar Entitas

| Entitas A | Hubungan | Entitas B | Kardinalitas | Mandatory / Optional |
|---|---|---|---|---|
| `PEGAWAI` | memiliki akun | `USER` | 1 : 0..1 | User opsional bagi Pegawai, Pegawai mandatory bagi User |
| `PEGAWAI` | Supertype dari | `ADMIN` | 1 : 0..1 | Subtype bersifat Total + Disjoint secara keseluruhan |
| `PEGAWAI` | Supertype dari | `PETUGAS_OPERASIONAL` | 1 : 0..1 | Subtype bersifat Total + Disjoint secara keseluruhan |
| `PEGAWAI` | Supertype dari | `PETUGAS_HSE` | 1 : 0..1 | Subtype bersifat Total + Disjoint secara keseluruhan |
| `PEGAWAI` | Supertype dari | `MANAGER` | 1 : 0..1 | Subtype bersifat Total + Disjoint secara keseluruhan |
| `PEGAWAI` | Supertype dari | `DRIVER` | 1 : 0..1 | Subtype bersifat Total + Disjoint secara keseluruhan |
| `PETUGAS_OPERASIONAL` | mencatat | `PRODUKSI_TAMBANG` | 1 : M | Produksi wajib memiliki Petugas Operasional |
| `PETUGAS_OPERASIONAL` | mengelola | `PENGANGKUTAN` | 1 : M | Pengangkutan wajib memiliki Petugas Operasional |
| `JENIS_MATERIAL` | digunakan pada | `PRODUKSI_TAMBANG` | 1 : M | Produksi wajib memiliki Jenis Material |
| `LOKASI` | menjadi lokasi Produksi | `PRODUKSI_TAMBANG` | 1 : M | Produksi wajib memiliki Lokasi |
| `PRODUKSI_TAMBANG` | diangkut melalui | `PENGANGKUTAN` | 1 : M | Produksi dapat belum memiliki Pengangkutan |
| `KENDARAAN` | digunakan pada | `PENGANGKUTAN` | 1 : M | Pengangkutan wajib memiliki Kendaraan |
| `DRIVER` | mengemudikan | `PENGANGKUTAN` | 1 : M | Pengangkutan wajib memiliki Driver |
| `LOKASI` | menjadi lokasi asal | `PENGANGKUTAN` | 1 : M | Pengangkutan wajib memiliki lokasi asal |
| `LOKASI` | menjadi lokasi tujuan | `PENGANGKUTAN` | 1 : M | Pengangkutan wajib memiliki lokasi tujuan |
| `PETUGAS_HSE` | melakukan | `MONITORING_LINGKUNGAN` | 1 : M | Monitoring wajib memiliki Petugas HSE |
| `LOKASI` | dimonitor melalui | `MONITORING_LINGKUNGAN` | 1 : M | Monitoring wajib memiliki Lokasi |
| `MONITORING_LINGKUNGAN` | memiliki | `DETAIL_MONITORING` | 1 : M | Monitoring lengkap minimal memiliki satu Detail |
| `PARAMETER_LINGKUNGAN` | digunakan pada | `DETAIL_MONITORING` | 1 : M | Detail wajib memiliki Parameter |

---

# 20. Gambaran Relasi ERD Keseluruhan

```text
                             PEGAWAI
                         <<SUPERTYPE>>
                          <<ABSTRACT>>
                               │
                        TOTAL + DISJOINT
                               │
        ┌──────────┬───────────┼───────────┬──────────┐
        ▼          ▼           ▼           ▼          ▼
      ADMIN      PETUGAS     PETUGAS     MANAGER    DRIVER
                OPERASIONAL     HSE
     <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>> <<SUBTYPE>>
        │          │           │           │
        └──────────┴───────────┴───────────┘
                         │
                         ▼
                       USER
                 Driver tidak login


PETUGAS_OPERASIONAL
        │
        │ 1:M
        ▼
PRODUKSI_TAMBANG ◄──────── JENIS_MATERIAL
        │                        1:M
        │
        ├────────────────── LOKASI
        │                      1:M
        │
        │ 1:M
        ▼
PENGANGKUTAN
   │      │       │
   │      │       └──────── DRIVER
   │      │                    1:M
   │      │
   │      └─────────────── KENDARAAN
   │                           1:M
   │
   ├────────────────────── LOKASI (ASAL)
   │
   └────────────────────── LOKASI (TUJUAN)


PETUGAS_HSE
     │
     │ 1:M
     ▼
MONITORING_LINGKUNGAN ◄──────── LOKASI
     │
     │ 1:M
     ▼
DETAIL_MONITORING
     │
     │ M:1
     ▼
PARAMETER_LINGKUNGAN
```

---

# 21. Gambaran Singkat Alur Sistem

## 21.1 Alur Admin

Admin bertugas mengelola Pegawai, User, dan data master yang dibutuhkan oleh sistem.

```text
Login Admin
    ↓
Kelola Pegawai
    ↓
Tambah Pegawai
    ↓
Isi Data Umum Pegawai
    ↓
Pilih Jenis Pegawai
    ↓
┌───────────────────────────┐
│ ADMIN                     │
│ PETUGAS_OPERASIONAL       │
│ PETUGAS_HSE               │
│ MANAGER                   │
│ DRIVER                    │
└─────────────┬─────────────┘
              ↓
Tampilkan Data Khusus Subtype
              ↓
Isi Data Khusus
              ↓
Validasi
              ↓
Generate ID Pegawai
              ↓
status_pegawai = AKTIF
              ↓
Jika Driver:
status_driver = TERSEDIA
              ↓
Simpan PEGAWAI + SUBTYPE
```

Jika Pegawai membutuhkan akses aplikasi:

```text
PEGAWAI
   ↓
Buat USER
   ↓
Username + Password
   ↓
Akun terhubung dengan Pegawai
```

Driver tidak dibuatkan User.

Admin juga mengelola:

```text
LOKASI
JENIS_MATERIAL
KENDARAAN
PARAMETER_LINGKUNGAN
```

---

## 21.2 Alur Petugas Operasional

Petugas Operasional mencatat hasil Produksi Tambang.

```text
Login Petugas Operasional
        ↓
Pilih Jenis Material
        ↓
Pilih Lokasi PIT
        ↓
Input Tanggal Produksi
        ↓
Input Jumlah Produksi
        ↓
Simpan PRODUKSI_TAMBANG
        ↓
jumlah_tersedia = jumlah_produksi
        ↓
status_produksi = TERSEDIA
```

Material hasil Produksi kemudian dapat diangkut.

```text
PRODUKSI_TAMBANG
        ↓
Buat PENGANGKUTAN
        ↓
Pilih Produksi
        ↓
Pilih Kendaraan
        ↓
Pilih Driver
        ↓
Tentukan Lokasi Asal
        ↓
Pilih Lokasi Tujuan
        ↓
Input Jumlah Muatan
        ↓
Validasi
        │
        ├── Stok Produksi cukup
        ├── Kapasitas Kendaraan cukup
        ├── Kendaraan tersedia
        ├── Driver tersedia
        ├── SIM Driver masih berlaku
        └── Lokasi dapat digunakan
        ↓
status_pengangkutan = DIJADWALKAN
        ↓
Mulai Pengangkutan
        ↓
status_pengangkutan = DALAM_PERJALANAN
        ↓
status_driver = BERTUGAS
status_kendaraan = DIGUNAKAN
        ↓
Selesaikan Pengangkutan
        ↓
status_pengangkutan = SELESAI
        ↓
status_driver = TERSEDIA
status_kendaraan = TERSEDIA
        ↓
jumlah_tersedia Produksi berkurang
        ↓
Perbarui status Produksi
```

---

## 21.3 Alur Petugas HSE

Petugas HSE melakukan Monitoring Lingkungan pada suatu Lokasi.

```text
Login Petugas HSE
        ↓
Pilih Lokasi
        ↓
Buat MONITORING_LINGKUNGAN
        ↓
Tambah DETAIL_MONITORING
        ↓
Pilih Parameter Lingkungan
        ↓
Input Nilai Pengukuran
        ↓
Bandingkan dengan
Batas Minimum / Maksimum
        ↓
Tentukan Status Detail
        ↓
NORMAL / PERINGATAN
```

Jika seluruh Detail berstatus `NORMAL`:

```text
status_monitoring = NORMAL
        ↓
status_penanganan = TIDAK_DIPERLUKAN
```

Jika minimal satu Detail berstatus `PERINGATAN`:

```text
status_monitoring = PERINGATAN
        ↓
Isi Tindak Lanjut
        ↓
status_penanganan = BELUM_DITANGANI
        ↓
DALAM_PENANGANAN
        ↓
SELESAI
```

Status `PERINGATAN` tidak otomatis menutup Lokasi. Perubahan status operasional Lokasi dilakukan secara terpisah sesuai kondisi dan tindak lanjut HSE.

---

## 21.4 Alur Manager

Manager menggunakan sistem untuk melihat informasi yang sudah dihasilkan dari kegiatan operasional.

```text
Login Manager
      ↓
Dashboard
      ↓
Laporan
      │
      ├── Laporan Produksi
      ├── Laporan Pengangkutan
      └── Laporan Monitoring Lingkungan
      ↓
Informasi Operasional
      ↓
Pemantauan dan Pengambilan Keputusan
```

Manager tidak melakukan CRUD terhadap Produksi, Pengangkutan, maupun Monitoring.

---

# 22. Ringkasan Alur C-MOS

Secara keseluruhan, alur utama C-MOS adalah sebagai berikut:

```text
ADMIN
  ↓
Mengelola Pegawai, User, dan Data Master
  ↓
Data Operasional Tersedia
  ↓
PETUGAS OPERASIONAL
  ↓
PRODUKSI TAMBANG
  ↓
PENGANGKUTAN
  ↓
Material Dipindahkan ke Lokasi Tujuan


PETUGAS HSE
  ↓
MONITORING LINGKUNGAN
  ↓
DETAIL MONITORING
  ↓
NORMAL / PERINGATAN
  ↓
Tindak Lanjut jika Diperlukan


MANAGER
  ↓
DASHBOARD DAN LAPORAN
  ↓
Melihat Informasi Produksi
  ↓
Melihat Informasi Pengangkutan
  ↓
Melihat Informasi Lingkungan
  ↓
Pemantauan dan Pengambilan Keputusan
```

Rancangan ini menggunakan `PEGAWAI` sebagai **Supertype**, sedangkan `ADMIN`, `PETUGAS_OPERASIONAL`, `PETUGAS_HSE`, `MANAGER`, dan `DRIVER` sebagai **Subtype**. Struktur tersebut membuat rancangan basis data selaras dengan penerapan konsep **inheritance, abstraction, encapsulation, dan polymorphism** pada implementasi PBO C-MOS.