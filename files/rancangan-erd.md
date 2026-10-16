# Rancangan Final Entity Relationship Diagram (ERD)
## Cobalt Mining Operation System (C-MOS)

## 1. Gambaran Umum

**Cobalt Mining Operation System (C-MOS)** merupakan aplikasi desktop yang digunakan untuk membantu pengelolaan kegiatan operasional pertambangan Cobalt.

Sistem berfokus pada beberapa proses utama, yaitu:

- Pengelolaan data pegawai berdasarkan jenis dan tanggung jawab pekerjaannya.
- Pengelolaan akun pengguna aplikasi.
- Pengelolaan data Driver.
- Pencatatan produksi tambang oleh Petugas Operasional.
- Pengelolaan kegiatan pengangkutan material oleh Petugas Operasional.
- Pengelolaan kendaraan pengangkutan.
- Pengelolaan lokasi operasional berupa Pit dan Stockpile.
- Monitoring kondisi lingkungan oleh Petugas HSE.
- Pencatatan detail hasil pengukuran parameter lingkungan.
- Penyediaan data Dashboard, histori, dan laporan untuk Manager.

Pada rancangan terbaru, `PEGAWAI` digunakan sebagai **Supertype** yang memiliki lima Subtype, yaitu:

1. `ADMIN`
2. `PETUGAS_OPERASIONAL`
3. `PETUGAS_HSE`
4. `MANAGER`
5. `DRIVER`

Setiap Subtype memiliki atribut khusus yang membedakannya dari Subtype lain dan seluruh Subtype mewarisi atribut umum dari `PEGAWAI`.

Konsep spesialisasi yang digunakan adalah:

- **Total Specialization**, artinya setiap Pegawai harus termasuk ke salah satu Subtype.
- **Disjoint Specialization**, artinya satu Pegawai hanya dapat berada pada satu Subtype.

Konsep tersebut nantinya juga mendukung penerapan PBO pada Java, dengan `Pegawai` sebagai **abstract class** dan kelima jenis Pegawai sebagai class turunannya.

---

# 2. Struktur Supertype dan Subtype

Entitas `PEGAWAI` merupakan **Supertype**, sedangkan `ADMIN`, `PETUGAS_OPERASIONAL`, `PETUGAS_HSE`, `MANAGER`, dan `DRIVER` merupakan **Subtype**.

Struktur sederhananya:

```text
                              PEGAWAI
                             (Supertype)
                                  |
                                 ISA
                                  |
          ________________________|________________________
         |              |              |          |        |
         v              v              v          v        v
       ADMIN         PETUGAS         PETUGAS    MANAGER  DRIVER
                   OPERASIONAL         HSE
     (Subtype)      (Subtype)        (Subtype)  (Subtype) (Subtype)
```

`PEGAWAI` menyimpan atribut yang dimiliki oleh seluruh pegawai.

Sedangkan masing-masing Subtype menyimpan atribut khusus sesuai karakteristik pekerjaannya.

Contohnya:

```text
PEGAWAI
- nama_pegawai
- no_hp
- tanggal_masuk
- status_pegawai

        ↓ diwariskan

DRIVER
- no_sim
- masa_berlaku_sim
- status_driver
```

Dengan demikian atribut umum tidak perlu ditulis ulang pada setiap Subtype.

---

# 3. Aturan Specialization

Specialization pada `PEGAWAI` menggunakan konsep:

```text
TOTAL + DISJOINT
```

## 3.1 Total Specialization

Setiap data `PEGAWAI` wajib mempunyai salah satu jenis Pegawai.

Artinya tidak diperbolehkan terdapat Pegawai yang tidak termasuk ke dalam salah satu:

```text
ADMIN
PETUGAS_OPERASIONAL
PETUGAS_HSE
MANAGER
DRIVER
```

Contoh:

```text
Budi  → ADMIN
Rina  → PETUGAS_OPERASIONAL
Andi  → PETUGAS_HSE
Dwi   → MANAGER
Joko  → DRIVER
```

---

## 3.2 Disjoint Specialization

Satu Pegawai hanya boleh mempunyai satu Subtype.

Contoh yang diperbolehkan:

```text
Andi
PEGAWAI
   |
   v
PETUGAS_HSE
```

Contoh yang tidak diperbolehkan:

```text
Andi
   |
   +--> PETUGAS_HSE
   |
   +--> MANAGER
```

Dengan demikian identitas dan tanggung jawab setiap Pegawai menjadi jelas.

---

# 4. Daftar Entitas

Rancangan terbaru database C-MOS terdiri dari **15 entitas**, yaitu:

1. `PEGAWAI`
2. `ADMIN`
3. `PETUGAS_OPERASIONAL`
4. `PETUGAS_HSE`
5. `MANAGER`
6. `DRIVER`
7. `USER`
8. `LOKASI`
9. `JENIS_MATERIAL`
10. `KENDARAAN`
11. `PRODUKSI_TAMBANG`
12. `PENGANGKUTAN`
13. `PARAMETER_LINGKUNGAN`
14. `MONITORING_LINGKUNGAN`
15. `DETAIL_MONITORING`

Entitas dapat dikelompokkan menjadi:

```text
SUPER/SUBTYPE
├── PEGAWAI
├── ADMIN
├── PETUGAS_OPERASIONAL
├── PETUGAS_HSE
├── MANAGER
└── DRIVER

AKSES
└── USER

MASTER DATA
├── LOKASI
├── JENIS_MATERIAL
├── KENDARAAN
└── PARAMETER_LINGKUNGAN

TRANSAKSI
├── PRODUKSI_TAMBANG
├── PENGANGKUTAN
└── MONITORING_LINGKUNGAN

DETAIL TRANSAKSI
└── DETAIL_MONITORING
```

---

# 5. Entitas dan Atribut

## 5.1 PEGAWAI

### Fungsi

Entitas `PEGAWAI` digunakan untuk menyimpan data umum seluruh pegawai perusahaan.

Entitas ini merupakan **Supertype** dari:

- `ADMIN`
- `PETUGAS_OPERASIONAL`
- `PETUGAS_HSE`
- `MANAGER`
- `DRIVER`

Atribut yang bersifat khusus tidak diletakkan pada `PEGAWAI`, tetapi pada masing-masing Subtype.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT AUTO_INCREMENT | PK | ID unik Pegawai |
| `nama_pegawai` | VARCHAR(100) | - | Nama lengkap Pegawai |
| `no_hp` | VARCHAR(20) | - | Nomor HP Pegawai |
| `tanggal_masuk` | DATE | - | Tanggal mulai bekerja |
| `status_pegawai` | ENUM('AKTIF','NONAKTIF') | - | Status keaktifan Pegawai |

Atribut `jabatan` tidak lagi digunakan karena jenis pekerjaan Pegawai sudah ditentukan melalui Subtype.

### Relasi

- `PEGAWAI` merupakan Supertype dari `ADMIN`.
- `PEGAWAI` merupakan Supertype dari `PETUGAS_OPERASIONAL`.
- `PEGAWAI` merupakan Supertype dari `PETUGAS_HSE`.
- `PEGAWAI` merupakan Supertype dari `MANAGER`.
- `PEGAWAI` merupakan Supertype dari `DRIVER`.
- `PEGAWAI 1 : 0..1 USER` dengan kata kerja **memiliki akun**.

---

# 5.2 ADMIN

### Fungsi

Entitas `ADMIN` merupakan **Subtype dari PEGAWAI**.

Admin bertanggung jawab terhadap pengelolaan data master dan akun pengguna pada aplikasi C-MOS.

Admin dapat mengelola:

- Data Pegawai.
- Data akun User.
- Data Lokasi.
- Data Jenis Material.
- Data Kendaraan.
- Data Parameter Lingkungan.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK | ID Pegawai sekaligus identitas Admin |
| `kode_admin` | VARCHAR(20) | UNIQUE | Kode khusus Admin |
| `tanggal_mulai_akses` | DATE | - | Tanggal mulai mendapatkan kewenangan sebagai Admin C-MOS |

`tanggal_mulai_akses` berbeda dengan `tanggal_masuk`.

```text
tanggal_masuk
→ kapan Pegawai mulai bekerja di perusahaan.

tanggal_mulai_akses
→ kapan Pegawai mulai memperoleh kewenangan sebagai Admin C-MOS.
```

### Foreign Key

```text
ADMIN.id_pegawai
        |
        v
PEGAWAI.id_pegawai
```

### Relasi

- `ADMIN` merupakan Subtype dari `PEGAWAI`.
- Admin memiliki hak untuk mengelola master data melalui proses aplikasi.

Admin tidak perlu memiliki Foreign Key pada setiap tabel master karena aktivitas pengelolaan master tidak menjadi transaksi utama yang perlu dicatat pada rancangan saat ini.

---

# 5.3 PETUGAS_OPERASIONAL

### Fungsi

Entitas `PETUGAS_OPERASIONAL` merupakan **Subtype dari PEGAWAI**.

Petugas Operasional bertanggung jawab terhadap kegiatan operasional utama, yaitu:

- Mencatat Produksi Tambang.
- Membuat kegiatan Pengangkutan.
- Menentukan Driver.
- Menentukan Kendaraan.
- Menentukan lokasi asal dan tujuan.
- Memulai dan menyelesaikan proses Pengangkutan.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK | ID Pegawai sekaligus identitas Petugas Operasional |
| `kode_petugas_operasional` | VARCHAR(20) | UNIQUE | Kode khusus Petugas Operasional |
| `area_tugas` | VARCHAR(100) | - | Area penugasan operasional |
| `shift_kerja` | ENUM('PAGI','SIANG','MALAM') | - | Shift kerja Petugas Operasional |

Contoh:

```text
Kode Petugas : OPS-001
Area Tugas   : Pit A
Shift Kerja  : PAGI
```

### Foreign Key

```text
PETUGAS_OPERASIONAL.id_pegawai
        |
        v
PEGAWAI.id_pegawai
```

### Relasi

- `PETUGAS_OPERASIONAL` merupakan Subtype dari `PEGAWAI`.
- `PETUGAS_OPERASIONAL 1 : M PRODUKSI_TAMBANG` dengan kata kerja **mencatat produksi**.
- `PETUGAS_OPERASIONAL 1 : M PENGANGKUTAN` dengan kata kerja **mengelola pengangkutan**.

```text
PETUGAS_OPERASIONAL
       1
       |
       | mencatat
       |
       M
PRODUKSI_TAMBANG
```

dan:

```text
PETUGAS_OPERASIONAL
       1
       |
       | mengelola
       |
       M
PENGANGKUTAN
```

---

# 5.4 PETUGAS_HSE

### Fungsi

Entitas `PETUGAS_HSE` merupakan **Subtype dari PEGAWAI**.

Petugas HSE pada scope C-MOS bertanggung jawab terhadap kegiatan monitoring kondisi lingkungan pada lokasi pertambangan.

Petugas HSE dapat:

- Melakukan Monitoring Lingkungan.
- Memasukkan hasil pengukuran parameter.
- Melihat hasil NORMAL atau PERINGATAN.
- Memberikan tindak lanjut.
- Mengelola status penanganan.
- Melakukan monitoring ulang.
- Mengevaluasi kondisi operasional lokasi.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK | ID Pegawai sekaligus identitas Petugas HSE |
| `no_sertifikasi_hse` | VARCHAR(50) | UNIQUE | Nomor sertifikasi HSE |
| `masa_berlaku_sertifikasi` | DATE | - | Masa berlaku sertifikasi HSE |

Atribut sertifikasi dapat digunakan dalam validasi sistem.

Contoh:

```text
Petugas HSE
      |
      v
Melakukan Monitoring
      |
      v
Cek Sertifikasi
    /     \
Valid   Kedaluwarsa
  |          |
  v          v
Boleh      Ditolak
```

### Foreign Key

```text
PETUGAS_HSE.id_pegawai
        |
        v
PEGAWAI.id_pegawai
```

### Relasi

- `PETUGAS_HSE` merupakan Subtype dari `PEGAWAI`.
- `PETUGAS_HSE 1 : M MONITORING_LINGKUNGAN` dengan kata kerja **melakukan monitoring**.

```text
PETUGAS_HSE
      1
      |
      | melakukan
      |
      M
MONITORING_LINGKUNGAN
```

---

# 5.5 MANAGER

### Fungsi

Entitas `MANAGER` merupakan **Subtype dari PEGAWAI**.

Manager menggunakan aplikasi untuk memantau kegiatan operasional melalui Dashboard, histori, dan laporan.

Manager bersifat **read-only** terhadap transaksi utama.

Manager dapat melihat:

- Data Produksi Tambang.
- Data Pengangkutan.
- Aktivitas Driver dan Kendaraan.
- Monitoring Lingkungan.
- Status Lokasi.
- Dashboard operasional.
- Laporan.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK | ID Pegawai sekaligus identitas Manager |
| `kode_manager` | VARCHAR(20) | UNIQUE | Kode khusus Manager |
| `divisi_tanggung_jawab` | VARCHAR(100) | - | Divisi/bagian yang menjadi tanggung jawab Manager |

Contoh:

```text
Kode Manager           : MGR-001
Divisi Tanggung Jawab  : Operasional Pertambangan
```

### Foreign Key

```text
MANAGER.id_pegawai
        |
        v
PEGAWAI.id_pegawai
```

### Relasi

- `MANAGER` merupakan Subtype dari `PEGAWAI`.
- Manager tidak perlu mempunyai relasi Foreign Key langsung ke Dashboard atau Laporan.

Dashboard dan laporan merupakan hasil pengolahan data dari transaksi yang sudah tersedia.

---

# 5.6 DRIVER

### Fungsi

Entitas `DRIVER` merupakan **Subtype dari PEGAWAI**.

Driver merupakan Pegawai yang terlibat langsung dalam proses Pengangkutan dan bertanggung jawab mengemudikan kendaraan.

Driver tidak menggunakan aplikasi secara langsung dan tidak memiliki akun `USER`.

Driver dipilih oleh Petugas Operasional ketika membuat kegiatan `PENGANGKUTAN`.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pegawai` | INT | PK, FK | ID Pegawai sekaligus identitas Driver |
| `no_sim` | VARCHAR(30) | UNIQUE | Nomor SIM Driver |
| `masa_berlaku_sim` | DATE | - | Masa berlaku SIM |
| `status_driver` | ENUM('TERSEDIA','BERTUGAS','NONAKTIF') | - | Status ketersediaan Driver |

`status_driver` berbeda dengan `status_pegawai`.

```text
status_pegawai
→ AKTIF / NONAKTIF sebagai pegawai perusahaan.

status_driver
→ TERSEDIA / BERTUGAS / NONAKTIF dalam aktivitas pengangkutan.
```

### Foreign Key

```text
DRIVER.id_pegawai
        |
        v
PEGAWAI.id_pegawai
```

### Relasi

- `DRIVER` merupakan Subtype dari `PEGAWAI`.
- `DRIVER 1 : M PENGANGKUTAN` dengan kata kerja **mengemudikan**.

```text
DRIVER
   1
   |
   | mengemudikan
   |
   M
PENGANGKUTAN
```

Driver tidak memiliki relasi langsung dengan `PRODUKSI_TAMBANG`.

---

# 5.7 USER

### Fungsi

Entitas `USER` digunakan untuk menyimpan akun autentikasi yang digunakan Pegawai untuk login ke aplikasi C-MOS.

Pada rancangan terbaru, `USER` **tidak lagi menyimpan atribut role**.

Jenis Pegawai dan hak akses ditentukan berdasarkan Subtype dari Pegawai pemilik akun.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_user` | INT AUTO_INCREMENT | PK | ID akun |
| `id_pegawai` | INT | FK, UNIQUE | Pegawai pemilik akun |
| `username` | VARCHAR(50) | UNIQUE | Username login |
| `password` | VARCHAR(255) | - | Password pengguna |

### Foreign Key

```text
USER.id_pegawai
       |
       v
PEGAWAI.id_pegawai
```

### Relasi

```text
PEGAWAI 1 -------- 0..1 USER
           memiliki akun
```

Aturan akun:

```text
ADMIN                 → dapat memiliki USER
PETUGAS_OPERASIONAL   → dapat memiliki USER
PETUGAS_HSE           → dapat memiliki USER
MANAGER               → dapat memiliki USER
DRIVER                 → tidak memiliki USER
```

Dengan demikian tidak terjadi duplikasi antara jenis Pegawai dengan `USER.role`.

Contoh:

```text
USER
username = andi.hse
        |
        v
PEGAWAI
Andi Pratama
        |
        v
PETUGAS_HSE
```

Sistem dapat mengetahui bahwa Andi merupakan Petugas HSE berdasarkan Subtype Pegawainya.

---

# 5.8 LOKASI

### Fungsi

Entitas `LOKASI` digunakan untuk menyimpan lokasi operasional pertambangan.

Jenis lokasi terdiri dari:

- `PIT`
- `STOCKPILE`

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_lokasi` | INT AUTO_INCREMENT | PK | ID lokasi |
| `nama_lokasi` | VARCHAR(100) | - | Nama lokasi |
| `jenis_lokasi` | ENUM('PIT','STOCKPILE') | - | Jenis lokasi |
| `status_operasional` | ENUM('AKTIF','DIBATASI','DITUTUP_SEMENTARA') | - | Status operasional |
| `keterangan` | TEXT NULL | - | Keterangan tambahan |

### Relasi

- `LOKASI 1 : M PRODUKSI_TAMBANG` = **menjadi tempat produksi**.
- `LOKASI 1 : M PENGANGKUTAN` = **menjadi lokasi asal**.
- `LOKASI 1 : M PENGANGKUTAN` = **menjadi lokasi tujuan**.
- `LOKASI 1 : M MONITORING_LINGKUNGAN` = **dimonitor melalui**.

Tetap hanya terdapat satu tabel `LOKASI`.

Pada `PENGANGKUTAN`, lokasi dibedakan menggunakan:

```text
id_lokasi_asal
id_lokasi_tujuan
```

---

# 5.9 JENIS_MATERIAL

### Fungsi

Entitas `JENIS_MATERIAL` digunakan sebagai master data material yang dihasilkan dari kegiatan pertambangan.

Contohnya dapat berupa:

- Bijih Cobalt.
- Material Cobalt kadar tertentu.
- Material lain yang digunakan pada simulasi proyek.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_material` | INT AUTO_INCREMENT | PK | ID material |
| `nama_material` | VARCHAR(100) | - | Nama material |
| `satuan` | VARCHAR(20) | - | Satuan material |
| `deskripsi` | TEXT NULL | - | Deskripsi material |

### Relasi

```text
JENIS_MATERIAL 1 -------- M PRODUKSI_TAMBANG
                    digunakan pada
```

---

# 5.10 KENDARAAN

### Fungsi

Entitas `KENDARAAN` digunakan untuk menyimpan kendaraan yang digunakan dalam kegiatan Pengangkutan.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_kendaraan` | INT AUTO_INCREMENT | PK | ID kendaraan |
| `jenis_kendaraan` | VARCHAR(50) | - | Jenis kendaraan |
| `nomor_polisi` | VARCHAR(15) | UNIQUE | Nomor polisi |
| `kapasitas` | DECIMAL(10,2) | - | Kapasitas maksimal kendaraan |
| `tahun_kendaraan` | YEAR | - | Tahun kendaraan |
| `status_kendaraan` | ENUM('TERSEDIA','DIGUNAKAN','NONAKTIF') | - | Status kendaraan |

### Relasi

```text
KENDARAAN 1 -------- M PENGANGKUTAN
               digunakan pada
```

Satu Kendaraan dapat digunakan pada banyak Pengangkutan pada waktu yang berbeda.

---

# 5.11 PRODUKSI_TAMBANG

### Fungsi

Entitas `PRODUKSI_TAMBANG` digunakan untuk mencatat hasil produksi material pada lokasi Pit.

Pada rancangan terbaru, produksi tidak lagi menggunakan `OPERATOR`.

Produksi dicatat oleh `PETUGAS_OPERASIONAL` yang sedang menggunakan aplikasi.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_produksi` | INT AUTO_INCREMENT | PK | ID produksi |
| `id_material` | INT | FK | Material yang diproduksi |
| `id_lokasi` | INT | FK | Lokasi produksi |
| `id_petugas_operasional` | INT | FK | Petugas yang mencatat produksi |
| `tanggal_produksi` | DATE | - | Tanggal produksi |
| `jumlah_produksi` | DECIMAL(12,2) | - | Jumlah awal produksi |
| `jumlah_tersedia` | DECIMAL(12,2) | - | Material yang masih tersedia |
| `status_produksi` | ENUM('TERSEDIA','SEBAGIAN_DIANGKUT','HABIS') | - | Status produksi |

### Foreign Key

```text
PRODUKSI_TAMBANG.id_material
        |
        v
JENIS_MATERIAL.id_material
```

```text
PRODUKSI_TAMBANG.id_lokasi
        |
        v
LOKASI.id_lokasi
```

```text
PRODUKSI_TAMBANG.id_petugas_operasional
        |
        v
PETUGAS_OPERASIONAL.id_pegawai
```

### Relasi

- `PETUGAS_OPERASIONAL 1 : M PRODUKSI_TAMBANG` = **mencatat produksi**.
- `LOKASI 1 : M PRODUKSI_TAMBANG` = **menjadi tempat produksi**.
- `JENIS_MATERIAL 1 : M PRODUKSI_TAMBANG` = **digunakan pada**.
- `PRODUKSI_TAMBANG 1 : M PENGANGKUTAN` = **menjadi sumber material**.

Contoh:

```text
Produksi #001

Petugas Operasional : Rina Putri
Lokasi               : Pit A
Material             : Bijih Cobalt
Jumlah Produksi      : 500 ton
Jumlah Tersedia      : 500 ton
Status               : TERSEDIA
```

Jika 28 ton selesai diangkut:

```text
jumlah_produksi = 500
jumlah_tersedia = 472
status_produksi = SEBAGIAN_DIANGKUT
```

`jumlah_produksi` tidak berubah karena menunjukkan jumlah awal produksi.

---

# 5.12 PENGANGKUTAN

### Fungsi

Entitas `PENGANGKUTAN` digunakan untuk mencatat proses pemindahan material hasil produksi dari Pit menuju Stockpile.

Pengangkutan dikelola oleh Petugas Operasional dan melibatkan:

- Satu Produksi Tambang.
- Satu Petugas Operasional.
- Satu Driver.
- Satu Kendaraan.
- Satu lokasi asal.
- Satu lokasi tujuan.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_pengangkutan` | INT AUTO_INCREMENT | PK | ID pengangkutan |
| `id_produksi` | INT | FK | Produksi sumber material |
| `id_petugas_operasional` | INT | FK | Petugas yang mengelola Pengangkutan |
| `id_kendaraan` | INT | FK | Kendaraan yang digunakan |
| `id_driver` | INT | FK | Driver yang mengemudikan |
| `id_lokasi_asal` | INT | FK | Lokasi asal |
| `id_lokasi_tujuan` | INT | FK | Lokasi tujuan |
| `tanggal_pengangkutan` | DATE | - | Tanggal Pengangkutan |
| `waktu_mulai` | DATETIME NULL | - | Waktu mulai |
| `waktu_selesai` | DATETIME NULL | - | Waktu selesai |
| `jumlah_muatan` | DECIMAL(10,2) | - | Jumlah material yang diangkut |
| `status_pengangkutan` | ENUM('DIJADWALKAN','DALAM_PERJALANAN','SELESAI','DIBATALKAN') | - | Status Pengangkutan |

### Foreign Key

```text
PENGANGKUTAN.id_produksi
        |
        v
PRODUKSI_TAMBANG.id_produksi
```

```text
PENGANGKUTAN.id_petugas_operasional
        |
        v
PETUGAS_OPERASIONAL.id_pegawai
```

```text
PENGANGKUTAN.id_kendaraan
        |
        v
KENDARAAN.id_kendaraan
```

```text
PENGANGKUTAN.id_driver
        |
        v
DRIVER.id_pegawai
```

```text
PENGANGKUTAN.id_lokasi_asal
        |
        v
LOKASI.id_lokasi
```

```text
PENGANGKUTAN.id_lokasi_tujuan
        |
        v
LOKASI.id_lokasi
```

### Relasi

- `PETUGAS_OPERASIONAL 1 : M PENGANGKUTAN` = **mengelola**.
- `PRODUKSI_TAMBANG 1 : M PENGANGKUTAN` = **menjadi sumber material**.
- `DRIVER 1 : M PENGANGKUTAN` = **mengemudikan**.
- `KENDARAAN 1 : M PENGANGKUTAN` = **digunakan pada**.
- `LOKASI 1 : M PENGANGKUTAN` = **menjadi lokasi asal**.
- `LOKASI 1 : M PENGANGKUTAN` = **menjadi lokasi tujuan**.

Contoh:

```text
Pengangkutan #001

Dikelola oleh  : Rina Putri
Produksi       : Produksi #001
Driver         : Joko Santoso
Kendaraan      : Dump Truck 01
Asal           : Pit A
Tujuan         : Stockpile A
Jumlah Muatan  : 28 ton
Status         : DIJADWALKAN
```

---

# 5.13 PARAMETER_LINGKUNGAN

### Fungsi

Entitas `PARAMETER_LINGKUNGAN` digunakan sebagai master data parameter yang diperiksa pada kegiatan Monitoring Lingkungan.

Contohnya:

- pH Air.
- Debu.
- Kebisingan.
- TSS.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_parameter` | INT AUTO_INCREMENT | PK | ID parameter |
| `nama_parameter` | VARCHAR(100) | - | Nama parameter |
| `satuan` | VARCHAR(30) | - | Satuan pengukuran |
| `batas_minimum` | DECIMAL(10,2) NULL | - | Batas minimum |
| `batas_maksimum` | DECIMAL(10,2) NULL | - | Batas maksimum |
| `keterangan` | TEXT NULL | - | Keterangan parameter |

### Relasi

```text
PARAMETER_LINGKUNGAN 1 -------- M DETAIL_MONITORING
                           digunakan pada
```

---

# 5.14 MONITORING_LINGKUNGAN

### Fungsi

Entitas `MONITORING_LINGKUNGAN` digunakan untuk mencatat satu kegiatan Monitoring Lingkungan pada lokasi tertentu.

Pada rancangan terbaru, Monitoring secara khusus dilakukan oleh `PETUGAS_HSE`.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_monitoring` | INT AUTO_INCREMENT | PK | ID monitoring |
| `id_lokasi` | INT | FK | Lokasi yang dimonitor |
| `id_petugas_hse` | INT | FK | Petugas HSE yang melakukan monitoring |
| `tanggal_monitoring` | DATETIME | - | Waktu monitoring |
| `status_monitoring` | ENUM('NORMAL','PERINGATAN') | - | Status keseluruhan monitoring |
| `tindak_lanjut` | VARCHAR(255) NULL | - | Tindak lanjut |
| `status_penanganan` | ENUM('TIDAK_DIPERLUKAN','BELUM_DITANGANI','DALAM_PENANGANAN','SELESAI') | - | Status penanganan |
| `catatan` | TEXT NULL | - | Catatan tambahan |

### Foreign Key

```text
MONITORING_LINGKUNGAN.id_lokasi
        |
        v
LOKASI.id_lokasi
```

```text
MONITORING_LINGKUNGAN.id_petugas_hse
        |
        v
PETUGAS_HSE.id_pegawai
```

### Relasi

- `PETUGAS_HSE 1 : M MONITORING_LINGKUNGAN` = **melakukan monitoring**.
- `LOKASI 1 : M MONITORING_LINGKUNGAN` = **dimonitor melalui**.
- `MONITORING_LINGKUNGAN 1 : M DETAIL_MONITORING` = **memiliki detail**.

Monitoring dengan status `PERINGATAN` tidak otomatis menutup lokasi.

Petugas HSE melakukan evaluasi terlebih dahulu sebelum status operasional lokasi diubah apabila diperlukan.

Monitoring ulang dibuat sebagai record Monitoring baru sehingga histori tetap tersimpan.

---

# 5.15 DETAIL_MONITORING

### Fungsi

Entitas `DETAIL_MONITORING` digunakan untuk menyimpan hasil pengukuran setiap Parameter Lingkungan pada satu kegiatan Monitoring.

Satu Monitoring dapat memiliki banyak Detail Monitoring.

### Atribut

| Atribut | Tipe Data | Key | Keterangan |
|---|---|---|---|
| `id_detail` | INT AUTO_INCREMENT | PK | ID detail |
| `id_monitoring` | INT | FK | Monitoring induk |
| `id_parameter` | INT | FK | Parameter yang diperiksa |
| `nilai_pengukuran` | DECIMAL(10,2) | - | Nilai hasil pengukuran |
| `status_detail` | ENUM('NORMAL','PERINGATAN') | - | Status hasil |
| `catatan` | TEXT NULL | - | Catatan hasil |

### Foreign Key

```text
DETAIL_MONITORING.id_monitoring
        |
        v
MONITORING_LINGKUNGAN.id_monitoring
```

```text
DETAIL_MONITORING.id_parameter
        |
        v
PARAMETER_LINGKUNGAN.id_parameter
```

### Relasi

- `MONITORING_LINGKUNGAN 1 : M DETAIL_MONITORING` = **memiliki**.
- `PARAMETER_LINGKUNGAN 1 : M DETAIL_MONITORING` = **digunakan pada**.

Contoh:

```text
Monitoring #001
|
+-- pH Air       = 5.20 -> PERINGATAN
+-- Debu         = 80   -> NORMAL
+-- Kebisingan   = 70   -> NORMAL
+-- TSS          = 40   -> NORMAL
```

Jika minimal satu Detail Monitoring berstatus `PERINGATAN`, maka status keseluruhan Monitoring menjadi `PERINGATAN`.

---

# 6. Ringkasan Entitas Final

| No. | Entitas | Jenis | Fungsi |
|---:|---|---|---|
| 1 | `PEGAWAI` | Supertype | Menyimpan data umum seluruh Pegawai |
| 2 | `ADMIN` | Subtype | Menyimpan data khusus Administrator |
| 3 | `PETUGAS_OPERASIONAL` | Subtype | Menyimpan data khusus Petugas Operasional |
| 4 | `PETUGAS_HSE` | Subtype | Menyimpan data dan sertifikasi Petugas HSE |
| 5 | `MANAGER` | Subtype | Menyimpan data khusus Manager |
| 6 | `DRIVER` | Subtype | Menyimpan data SIM dan status Driver |
| 7 | `USER` | Akses | Menyimpan akun login |
| 8 | `LOKASI` | Master | Menyimpan Pit dan Stockpile |
| 9 | `JENIS_MATERIAL` | Master | Menyimpan jenis material |
| 10 | `KENDARAAN` | Master | Menyimpan kendaraan Pengangkutan |
| 11 | `PRODUKSI_TAMBANG` | Transaksi | Mencatat hasil produksi |
| 12 | `PENGANGKUTAN` | Transaksi | Mencatat pemindahan material |
| 13 | `PARAMETER_LINGKUNGAN` | Master | Menyimpan parameter monitoring |
| 14 | `MONITORING_LINGKUNGAN` | Transaksi | Mencatat kegiatan monitoring |
| 15 | `DETAIL_MONITORING` | Detail Transaksi | Menyimpan hasil setiap parameter |

---

# 7. Ringkasan Relasi Final

| No. | Entitas 1 | Kata Kerja | Entitas 2 | Kardinalitas |
|---:|---|---|---|---|
| 1 | `PEGAWAI` | memiliki akun | `USER` | 1 : 0..1 |
| 2 | `PEGAWAI` | Supertype dari | `ADMIN` | ISA |
| 3 | `PEGAWAI` | Supertype dari | `PETUGAS_OPERASIONAL` | ISA |
| 4 | `PEGAWAI` | Supertype dari | `PETUGAS_HSE` | ISA |
| 5 | `PEGAWAI` | Supertype dari | `MANAGER` | ISA |
| 6 | `PEGAWAI` | Supertype dari | `DRIVER` | ISA |
| 7 | `PETUGAS_OPERASIONAL` | mencatat | `PRODUKSI_TAMBANG` | 1 : M |
| 8 | `PETUGAS_OPERASIONAL` | mengelola | `PENGANGKUTAN` | 1 : M |
| 9 | `DRIVER` | mengemudikan | `PENGANGKUTAN` | 1 : M |
| 10 | `LOKASI` | menjadi tempat produksi | `PRODUKSI_TAMBANG` | 1 : M |
| 11 | `JENIS_MATERIAL` | digunakan pada | `PRODUKSI_TAMBANG` | 1 : M |
| 12 | `PRODUKSI_TAMBANG` | menjadi sumber material | `PENGANGKUTAN` | 1 : M |
| 13 | `KENDARAAN` | digunakan pada | `PENGANGKUTAN` | 1 : M |
| 14 | `LOKASI` | menjadi lokasi asal | `PENGANGKUTAN` | 1 : M |
| 15 | `LOKASI` | menjadi lokasi tujuan | `PENGANGKUTAN` | 1 : M |
| 16 | `PETUGAS_HSE` | melakukan | `MONITORING_LINGKUNGAN` | 1 : M |
| 17 | `LOKASI` | dimonitor melalui | `MONITORING_LINGKUNGAN` | 1 : M |
| 18 | `MONITORING_LINGKUNGAN` | memiliki | `DETAIL_MONITORING` | 1 : M |
| 19 | `PARAMETER_LINGKUNGAN` | digunakan pada | `DETAIL_MONITORING` | 1 : M |

---

# 8. Gambaran Relasi Utama

```text
                               PEGAWAI
                              (Supertype)
                                   |
                                  ISA
        ___________________________|____________________________
       |              |              |             |            |
       v              v              v             v            v
     ADMIN          PETUGAS        PETUGAS       MANAGER      DRIVER
                  OPERASIONAL        HSE
                       |              |                          |
                       |              |                          |
              _________|_____         |                          |
             |               |        |                          |
             v               v        v                          |
      PRODUKSI_TAMBANG  PENGANGKUTAN MONITORING_LINGKUNGAN     |
             |               ^        |                          |
             |               |        v                          |
             |               |   DETAIL_MONITORING              |
             |               |                                   |
             +---------------+-----------------------------------+
                    sumber          Driver mengemudikan
                    material
```

Relasi proses utama:

```text
PETUGAS_OPERASIONAL
        |
        | mencatat
        | 1:M
        v
PRODUKSI_TAMBANG
```

```text
PETUGAS_OPERASIONAL
        |
        | mengelola
        | 1:M
        v
PENGANGKUTAN
```

```text
DRIVER
   |
   | mengemudikan
   | 1:M
   v
PENGANGKUTAN
```

```text
PETUGAS_HSE
   |
   | melakukan
   | 1:M
   v
MONITORING_LINGKUNGAN
```

---

# 9. Relasi Lokasi

Satu entitas `LOKASI` tetap digunakan untuk beberapa proses.

```text
                         LOKASI
                            |
             _______________|_______________
            |               |               |
            v               v               v
    PRODUKSI_TAMBANG   PENGANGKUTAN   MONITORING_LINGKUNGAN
                         /      \
                        /        \
                     ASAL        TUJUAN
```

Relasinya:

```text
LOKASI 1:M PRODUKSI_TAMBANG
```

```text
LOKASI 1:M PENGANGKUTAN
sebagai lokasi asal
```

```text
LOKASI 1:M PENGANGKUTAN
sebagai lokasi tujuan
```

```text
LOKASI 1:M MONITORING_LINGKUNGAN
```

Tidak diperlukan tabel:

```text
LOKASI_ASAL
LOKASI_TUJUAN
PIT
STOCKPILE
```

karena fungsi tersebut sudah direpresentasikan melalui `LOKASI.jenis_lokasi` dan Foreign Key pada transaksi.

---

# 10. Relasi Monitoring Lingkungan

Struktur Monitoring Lingkungan menjadi lebih spesifik:

```text
PETUGAS_HSE
     |
     | melakukan
     | 1:M
     v
MONITORING_LINGKUNGAN
     |
     | memiliki
     | 1:M
     v
DETAIL_MONITORING
     ^
     |
     | digunakan pada
     | 1:M
     |
PARAMETER_LINGKUNGAN
```

Selain itu:

```text
LOKASI
   |
   | dimonitor melalui
   | 1:M
   v
MONITORING_LINGKUNGAN
```

Dengan demikian satu Monitoring memiliki:

- Satu Petugas HSE.
- Satu Lokasi.
- Banyak Detail Monitoring.

Sedangkan setiap Detail Monitoring menggunakan satu Parameter Lingkungan.

---

# 11. Konsep Akun dan Hak Akses

Pada rancangan terbaru, hak akses tidak lagi disimpan sebagai `USER.role`.

Hak akses mengikuti jenis Pegawai.

```text
USER
 |
 v
PEGAWAI
 |
 +-- ADMIN
 |     └── Master Data & User
 |
 +-- PETUGAS_OPERASIONAL
 |     └── Produksi & Pengangkutan
 |
 +-- PETUGAS_HSE
 |     └── Monitoring Lingkungan
 |
 +-- MANAGER
 |     └── Dashboard & Laporan
 |
 +-- DRIVER
       └── Tidak memiliki akun
```

Dengan konsep tersebut tidak terjadi kondisi kontradiktif seperti:

```text
Pegawai = PETUGAS_HSE
USER.role = ADMIN
```

karena hanya terdapat satu sumber identitas jenis Pegawai.

---

# 12. Alur Data Utama Sistem

## 12.1 Admin

```text
ADMIN LOGIN
    |
    v
Mengelola Master Data
    |
    +-- Pegawai
    |    |
    |    +-- Admin
    |    +-- Petugas Operasional
    |    +-- Petugas HSE
    |    +-- Manager
    |    +-- Driver
    |
    +-- User
    +-- Lokasi
    +-- Jenis Material
    +-- Kendaraan
    +-- Parameter Lingkungan
```

---

## 12.2 Produksi Tambang

```text
PETUGAS OPERASIONAL LOGIN
        |
        v
Mencatat Produksi Tambang
        |
        +-- Petugas otomatis dari pengguna login
        +-- Pilih Lokasi Pit
        +-- Pilih Jenis Material
        +-- Input Jumlah Produksi
        |
        v
PRODUKSI_TAMBANG
```

Petugas Operasional tidak perlu memilih dirinya sendiri dari daftar karena identitas petugas dapat diperoleh dari akun yang sedang login.

---

## 12.3 Pengangkutan

```text
PETUGAS OPERASIONAL
        |
        v
Membuat Pengangkutan
        |
        +-- Pilih Produksi
        +-- Pilih Driver
        +-- Pilih Kendaraan
        +-- Pilih Lokasi Asal
        +-- Pilih Lokasi Tujuan
        +-- Input Jumlah Muatan
        |
        v
PENGANGKUTAN
```

Ketika Pengangkutan dimulai:

```text
status_pengangkutan
DIJADWALKAN
      |
      v
DALAM_PERJALANAN

status_driver
TERSEDIA
      |
      v
BERTUGAS

status_kendaraan
TERSEDIA
      |
      v
DIGUNAKAN
```

Ketika selesai:

```text
PENGANGKUTAN = SELESAI
DRIVER       = TERSEDIA
KENDARAAN    = TERSEDIA
```

Jumlah material tersedia pada Produksi kemudian dikurangi sesuai jumlah muatan.

Contoh:

```text
Produksi Awal     = 500 ton
Pengangkutan      = 28 ton

jumlah_produksi   = 500 ton
jumlah_tersedia   = 472 ton
status_produksi   = SEBAGIAN_DIANGKUT
```

---

# 12.4 Monitoring Lingkungan

```text
PETUGAS HSE LOGIN
        |
        v
Pilih Lokasi
        |
        v
MONITORING_LINGKUNGAN
        |
        v
Input Parameter
        |
        v
DETAIL_MONITORING
        |
      __|__
     |     |
     v     v
  NORMAL PERINGATAN
```

Jika seluruh Detail Monitoring normal:

```text
status_monitoring = NORMAL
status_penanganan = TIDAK_DIPERLUKAN
```

Jika minimal satu Detail Monitoring mengalami peringatan:

```text
status_monitoring = PERINGATAN
status_penanganan = BELUM_DITANGANI
```

Petugas HSE kemudian dapat melakukan tindak lanjut dan memperbarui status penanganan.

---

# 12.5 Manager

```text
MANAGER LOGIN
      |
      v
   DASHBOARD
      |
      +-- Produksi
      +-- Pengangkutan
      +-- Driver
      +-- Kendaraan
      +-- Monitoring
      +-- Status Lokasi
      |
      v
    LAPORAN
```

Manager bersifat read-only dan tidak melakukan perubahan terhadap transaksi operasional.

Dashboard dan Laporan tidak menjadi entitas tersendiri karena data dapat dihasilkan dari query terhadap tabel transaksi dan master yang sudah tersedia.

---

# 13. Penerapan Konsep PBO

Rancangan ERD dibuat agar dapat diterapkan secara konsisten pada aplikasi Java.

Struktur inheritance Java mengikuti struktur Supertype dan Subtype pada ERD:

```text
ERD                              JAVA

PEGAWAI                          Pegawai
Supertype                        abstract class
   |                                  |
   +-- ADMIN                          +-- Admin
   +-- PETUGAS_OPERASIONAL            +-- PetugasOperasional
   +-- PETUGAS_HSE                    +-- PetugasHSE
   +-- MANAGER                        +-- Manager
   +-- DRIVER                         +-- Driver
```

Penerapan empat pilar PBO:

### Abstraction

```text
Pegawai
→ abstract class
→ memiliki abstract method
```

### Inheritance

```text
Admin extends Pegawai
PetugasOperasional extends Pegawai
PetugasHSE extends Pegawai
Manager extends Pegawai
Driver extends Pegawai
```

### Polymorphism

Seluruh Subtype dapat direferensikan sebagai `Pegawai`, tetapi memiliki behavior yang berbeda sesuai jenisnya.

### Encapsulation

Atribut setiap class dibuat `private` dan diakses melalui method yang sesuai.

Selain itu, interface Repository tetap digunakan sebagai abstraction pada akses data.

```text
Service
   |
   v
Repository Interface
   |
   +------ MemoryRepository
   |         |
   |         v
   |      ArrayList
   |
   +------ DAO
             |
             v
            JDBC
             |
             v
          Database
```

Dengan demikian perubahan penyimpanan dari ArrayList menuju database tidak mengharuskan perubahan besar pada business logic.

---

# 14. Kesimpulan Rancangan ERD Terbaru

Rancangan terbaru **Cobalt Mining Operation System (C-MOS)** menggunakan **15 entitas** dengan `PEGAWAI` sebagai Supertype dan lima Subtype:

```text
PEGAWAI
   |
   +-- ADMIN
   |
   +-- PETUGAS_OPERASIONAL
   |
   +-- PETUGAS_HSE
   |
   +-- MANAGER
   |
   +-- DRIVER
```

Specialization menggunakan:

```text
TOTAL + DISJOINT
```

sehingga setiap Pegawai wajib mempunyai tepat satu jenis Pegawai.

Peran utama setiap Subtype adalah:

```text
ADMIN
→ Master Data & User

PETUGAS_OPERASIONAL
→ Produksi Tambang
→ Pengangkutan

PETUGAS_HSE
→ Monitoring Lingkungan

MANAGER
→ Dashboard & Laporan

DRIVER
→ Pengangkutan
→ Tidak Login
```

Hubungan proses operasional utama menjadi:

```text
PETUGAS_OPERASIONAL
        |
        v
PRODUKSI_TAMBANG
        |
        v
PENGANGKUTAN
        ^
        |
      DRIVER
```

Sedangkan monitoring:

```text
PETUGAS_HSE
     |
     v
MONITORING_LINGKUNGAN
     |
     v
DETAIL_MONITORING
     ^
     |
PARAMETER_LINGKUNGAN
```

Rancangan ini menjadi dasar konsisten untuk:

- ERD final.
- Database SQL.
- Primary Key dan Foreign Key.
- Constraint database.
- Class Java.
- Abstract Class dan Abstract Method.
- Inheritance.
- Polymorphism.
- Encapsulation.
- Interface.
- Repository.
- ArrayList sementara.
- DAO dan JDBC.
- ORM.
- MVC.
- GUI.
- CRUD.
- Dashboard.
- Laporan.
- Pengujian sistem C-MOS.

---

# 15. Perbaikan dan Perubahan dari Rancangan Sebelumnya

Bagian ini menjelaskan perubahan yang dilakukan dari rancangan C-MOS sebelumnya menuju rancangan terbaru.

## 15.1 Perubahan Struktur Supertype dan Subtype

### Sebelumnya

Struktur Supertype dan Subtype hanya terdiri dari:

```text
PEGAWAI
   |
   +-- DRIVER
   |
   +-- OPERATOR
```

`ADMIN`, `OPERASIONAL`, `HSE`, dan `MANAGER` hanya direpresentasikan melalui:

```text
USER.role
```

### Sekarang

Struktur diubah menjadi:

```text
PEGAWAI
   |
   +-- ADMIN
   +-- PETUGAS_OPERASIONAL
   +-- PETUGAS_HSE
   +-- MANAGER
   +-- DRIVER
```

Perubahan ini dilakukan agar jenis Pegawai memiliki representasi yang lebih jelas baik pada ERD maupun implementasi PBO.

Setiap Subtype sekarang memiliki atribut khusus yang membedakannya.

---

## 15.2 Perubahan Specialization

### Sebelumnya

Specialization `PEGAWAI` bersifat **Partial**, karena Pegawai dapat berdiri sendiri tanpa menjadi Driver atau Operator.

### Sekarang

Specialization menggunakan:

```text
TOTAL + DISJOINT
```

Artinya:

- Setiap Pegawai wajib memiliki satu Subtype.
- Satu Pegawai hanya boleh mempunyai satu Subtype.

Perubahan ini juga membuat implementasi:

```text
Pegawai = abstract class
```

menjadi konsisten dengan rancangan database.

---

## 15.3 Penghapusan OPERATOR

### Sebelumnya

`OPERATOR` merupakan Subtype dari `PEGAWAI`.

Operator mempunyai:

```text
no_sertifikasi
masa_berlaku_sertifikasi
status_operator
```

dan berelasi dengan:

```text
OPERATOR
   |
   v
PRODUKSI_TAMBANG
```

### Sekarang

Entitas `OPERATOR` dihapus.

Alasannya, pada scope aplikasi sebelumnya Operator hanya digunakan sebagai pilihan ketika mencatat Produksi dan tidak mempunyai lifecycle operasional yang cukup kuat.

Sebagai gantinya:

```text
PETUGAS_OPERASIONAL
        |
        | mencatat
        v
PRODUKSI_TAMBANG
```

Petugas Operasional yang sedang login menjadi pencatat Produksi.

Hal ini membuat proses lebih sederhana dan jelas.

---

## 15.4 Penambahan ADMIN sebagai Subtype

Sebelumnya Admin hanya merupakan nilai:

```text
USER.role = ADMIN
```

Sekarang Admin menjadi Subtype dari Pegawai.

Atribut khusus:

```text
kode_admin
tanggal_mulai_akses
```

`tanggal_mulai_akses` menunjukkan kapan Pegawai mulai mendapatkan kewenangan sebagai administrator aplikasi dan berbeda dari `tanggal_masuk` sebagai Pegawai perusahaan.

---

## 15.5 Penambahan PETUGAS_OPERASIONAL sebagai Subtype

Sebelumnya Petugas Operasional hanya merupakan:

```text
USER.role = OPERASIONAL
```

Sekarang menjadi Subtype dengan atribut:

```text
kode_petugas_operasional
area_tugas
shift_kerja
```

Petugas Operasional juga mempunyai keterlibatan langsung pada transaksi:

```text
PETUGAS_OPERASIONAL
       |
       +--> PRODUKSI_TAMBANG
       |
       +--> PENGANGKUTAN
```

Dengan demikian Petugas Operasional bukan hanya pembeda hak akses.

---

## 15.6 Penambahan PETUGAS_HSE sebagai Subtype

Sebelumnya HSE hanya merupakan:

```text
USER.role = HSE
```

dan `MONITORING_LINGKUNGAN` berelasi langsung dengan `PEGAWAI`.

Sekarang `PETUGAS_HSE` menjadi Subtype dengan atribut khusus:

```text
no_sertifikasi_hse
masa_berlaku_sertifikasi
```

Relasi Monitoring berubah dari:

```text
PEGAWAI
   |
   v
MONITORING_LINGKUNGAN
```

menjadi:

```text
PETUGAS_HSE
     |
     v
MONITORING_LINGKUNGAN
```

Perubahan ini memastikan hanya Petugas HSE yang menjadi pelaku Monitoring Lingkungan.

---

## 15.7 Penambahan MANAGER sebagai Subtype

Sebelumnya Manager hanya direpresentasikan melalui:

```text
USER.role = MANAGER
```

Sekarang Manager merupakan Subtype dengan:

```text
kode_manager
divisi_tanggung_jawab
```

Manager tetap tidak mempunyai transaksi khusus karena fungsi utamanya adalah:

```text
Dashboard
Histori
Laporan
Monitoring keseluruhan sistem
```

Manager bersifat read-only.

---

## 15.8 DRIVER Tetap Dipertahankan

Driver tetap menjadi Subtype karena mempunyai karakteristik dan keterlibatan proses yang jelas.

Atribut:

```text
no_sim
masa_berlaku_sim
status_driver
```

Relasi:

```text
DRIVER
   |
   | mengemudikan
   v
PENGANGKUTAN
```

Perubahan pentingnya adalah Driver sekarang secara eksplisit menjadi satu-satunya jenis Pegawai yang **tidak memiliki akun login**.

---

## 15.9 Penghapusan role dari USER

### Sebelumnya

```text
USER
├── username
├── password
└── role
```

dengan:

```text
ADMIN
OPERASIONAL
HSE
MANAGER
```

### Sekarang

```text
USER
├── id_user
├── id_pegawai
├── username
└── password
```

`role` dihapus karena jenis Pegawai sudah ditentukan melalui Subtype.

Perubahan ini mencegah data kontradiktif seperti:

```text
Pegawai = PETUGAS_HSE
USER.role = ADMIN
```

Jenis Pegawai menjadi satu sumber kebenaran untuk menentukan hak akses.

---

## 15.10 Perubahan Relasi PRODUKSI_TAMBANG

### Sebelumnya

```text
PRODUKSI_TAMBANG
└── id_operator
        |
        v
    OPERATOR
```

### Sekarang

```text
PRODUKSI_TAMBANG
└── id_petugas_operasional
        |
        v
PETUGAS_OPERASIONAL
```

Artinya Produksi sekarang mencatat siapa Petugas Operasional yang melakukan pencatatan.

---

## 15.11 Perubahan Relasi PENGANGKUTAN

Sebelumnya Pengangkutan mencatat:

```text
Produksi
Kendaraan
Driver
Lokasi Asal
Lokasi Tujuan
```

Sekarang ditambahkan:

```text
id_petugas_operasional
```

sehingga dapat diketahui siapa Petugas Operasional yang membuat/mengelola kegiatan Pengangkutan.

Strukturnya menjadi:

```text
PETUGAS_OPERASIONAL
        |
        v
PENGANGKUTAN
        |
        +-- Produksi
        +-- Driver
        +-- Kendaraan
        +-- Lokasi Asal
        +-- Lokasi Tujuan
```

---

## 15.12 Perubahan Relasi MONITORING_LINGKUNGAN

### Sebelumnya

```text
id_pegawai
    |
    v
PEGAWAI
```

### Sekarang

```text
id_petugas_hse
    |
    v
PETUGAS_HSE
```

Dengan demikian database secara struktural membatasi pelaku Monitoring pada Petugas HSE.

---

## 15.13 Perubahan Atribut PEGAWAI

Atribut:

```text
jabatan
```

dihapus.

Sebelumnya:

```text
PEGAWAI
├── nama
├── no_hp
├── jabatan
├── tanggal_masuk
└── status
```

Sekarang:

```text
PEGAWAI
├── nama
├── no_hp
├── tanggal_masuk
└── status
```

Alasannya, jenis pekerjaan Pegawai sudah direpresentasikan oleh Subtype sehingga `jabatan` berpotensi menduplikasi informasi.

---

## 15.14 Perbaikan Atribut KENDARAAN

Atribut:

```text
kapasitas
```

yang sebelumnya menggunakan:

```text
INT
```

diubah menjadi:

```text
DECIMAL(10,2)
```

agar dapat menyimpan kapasitas pecahan.

Atribut:

```text
tahun_kendaraan
```

yang sebelumnya menggunakan:

```text
DATE
```

diubah menjadi:

```text
YEAR
```

karena informasi yang dibutuhkan hanya tahun kendaraan.

---

## 15.15 Perubahan Jumlah Entitas

### Sebelumnya

Terdapat **12 entitas**:

```text
PEGAWAI
DRIVER
OPERATOR
USER
LOKASI
JENIS_MATERIAL
KENDARAAN
PRODUKSI_TAMBANG
PENGANGKUTAN
PARAMETER_LINGKUNGAN
MONITORING_LINGKUNGAN
DETAIL_MONITORING
```

### Sekarang

Terdapat **15 entitas**:

```text
PEGAWAI
ADMIN
PETUGAS_OPERASIONAL
PETUGAS_HSE
MANAGER
DRIVER
USER
LOKASI
JENIS_MATERIAL
KENDARAAN
PRODUKSI_TAMBANG
PENGANGKUTAN
PARAMETER_LINGKUNGAN
MONITORING_LINGKUNGAN
DETAIL_MONITORING
```

`OPERATOR` dihapus, sedangkan `ADMIN`, `PETUGAS_OPERASIONAL`, `PETUGAS_HSE`, dan `MANAGER` ditambahkan sebagai Subtype.

---

## 15.16 Dampak terhadap Implementasi PBO

Perubahan ERD juga memperjelas penerapan PBO.

Sebelumnya terdapat masalah ketika `Pegawai` ingin dijadikan abstract class tetapi masih terdapat Pegawai biasa yang bukan Driver atau Operator.

Dengan rancangan baru:

```text
PEGAWAI
<<abstract>>
      |
      +-- Admin
      +-- PetugasOperasional
      +-- PetugasHSE
      +-- Manager
      +-- Driver
```

tidak diperlukan object `Pegawai` secara langsung.

Setiap object Pegawai selalu merupakan salah satu class turunannya.

Hal ini membuat penerapan:

```text
Abstraction
Inheritance
Polymorphism
Encapsulation
```

lebih jelas dan sesuai dengan kebutuhan proyek.

---

## 15.17 Dampak terhadap Program C-MOS

Perubahan rancangan tidak hanya memengaruhi ERD, tetapi juga struktur program.

Class yang sebelumnya digunakan:

```text
Pegawai
Driver
Operator
```

akan diperbarui menjadi:

```text
Pegawai <<abstract>>
Admin
PetugasOperasional
PetugasHSE
Manager
Driver
```

Class:

```text
Operator
```

akan dihapus.

`User` juga tidak lagi mempunyai:

```text
Role role
```

Identitas pengguna diperoleh dari Subtype Pegawai yang terhubung dengan User.

Produksi tidak lagi memilih Operator.

Sebaliknya, Petugas Operasional yang sedang login otomatis menjadi pencatat Produksi.

Monitoring tidak lagi menerima Pegawai umum.

Petugas HSE yang sedang login otomatis menjadi pelaksana Monitoring.

Pengangkutan tetap memilih Driver karena Driver tidak login dan merupakan pihak yang menjalankan kendaraan.

Dengan demikian alur program menjadi:

```text
LOGIN
  |
  v
USER
  |
  v
PEGAWAI
  |
  +-- ADMIN
  |     └── Master Data
  |
  +-- PETUGAS_OPERASIONAL
  |     ├── Produksi
  |     └── Pengangkutan
  |
  +-- PETUGAS_HSE
  |     └── Monitoring
  |
  +-- MANAGER
  |     └── Dashboard & Laporan
  |
  +-- DRIVER
        └── Tidak Login
```

---

## 15.18 Kesimpulan Perbaikan

Perbaikan utama dilakukan untuk membuat rancangan database, proses bisnis, dan implementasi PBO mempunyai konsep yang sama.

Konsep akhirnya adalah:

```text
PEGAWAI
= identitas umum seluruh pekerja

SUBTYPE
= jenis Pegawai berdasarkan fungsi pekerjaannya

USER
= akun autentikasi, bukan penentu role

PETUGAS_OPERASIONAL
= pelaku pencatatan Produksi dan pengelola Pengangkutan

PETUGAS_HSE
= pelaku Monitoring Lingkungan

DRIVER
= pelaku Pengangkutan tetapi tidak login

ADMIN
= pengelola master data dan akun

MANAGER
= pemantau Dashboard dan Laporan
```

Dengan perubahan tersebut, rancangan tidak lagi memisahkan jenis Pegawai hanya sebagai `USER.role`.

Jenis Pegawai sekarang mempunyai:

- Identitas Subtype yang jelas.
- Atribut khusus yang sesuai.
- Behavior yang berbeda.
- Relasi proses yang sesuai jika memang diperlukan.
- Hubungan langsung dengan penerapan inheritance Java.

Rancangan ini selanjutnya menjadi **acuan utama C-MOS** untuk pengerjaan ERD, database, class Java, ArrayList, Service, Repository, Controller, GUI, DAO/JDBC, ORM, Dashboard, Laporan, dan pengujian sistem.