package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PengangkutanFormFrame extends javax.swing.JFrame {
    private Pengangkutan original;
    private boolean saved;
    public boolean isSaved(){return saved;}
    private final java.util.List<ProduksiTambang> daftarProduksi = new java.util.ArrayList<>();

    public PengangkutanFormFrame() {
        initComponents();
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        btnBatal.addActionListener(this::btnBatalActionPerformed);
        
        JButton[] navButtons = {btnSimpan, btnBatal};

        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        txtTanggal.setDateFormatString("dd/MM/yyyy");
        txtTanggal.setMinSelectableDate(new Date());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try {
            loadOptions();
            SearchableCombo.install(cmbProduksi); SearchableCombo.install(cmbKendaraan); SearchableCombo.install(cmbDriver); SearchableCombo.install(cmbTujuan); 
            cmbProduksi.addActionListener(this::cmbProduksiActionPerformed);
            terapkanAsalProduksi();
        } catch(Exception ex) { FormUtil.error(this,ex); }

    }

    /** Lokasi asal otomatis mengikuti lokasi produksi yang dipilih (sesuai alur C-MOS). */
    private void cmbProduksiActionPerformed(java.awt.event.ActionEvent evt) {
        terapkanAsalProduksi();
    }

    private void terapkanAsalProduksi() {
        ProduksiTambang p = produksiTerpilih();

        if (p == null) {
            cmbAsal.removeAllItems();
            cmbAsal.setEnabled(false);
            return;
        }
        cmbAsal.setEnabled(false);
        cmbAsal.removeAllItems();
        Lokasi asal = p.getLokasi();
        cmbAsal.addItem(new PilihanData(asal.getIdLokasi(), asal.getNamaLokasi()));
        FormUtil.select(cmbAsal, asal.getIdLokasi());
    }

    private ProduksiTambang produksiTerpilih() {
        PilihanData p = (PilihanData) cmbProduksi.getSelectedItem();
        if (p == null)return null;

        for (ProduksiTambang x : daftarProduksi)if (x.getIdProduksi() == p.id)return x;
        return null;
    }

    private LocalDate getTanggalPengangkutan() {
        Date tanggal = txtTanggal.getDate();

        if (tanggal == null)throw new IllegalArgumentException("Silakan pilih tanggal pengangkutan.");
        return tanggal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        lblProduksi = new javax.swing.JLabel();
        cmbProduksi = new javax.swing.JComboBox();
        lblKendaraan = new javax.swing.JLabel();
        cmbKendaraan = new javax.swing.JComboBox();
        lblDriver = new javax.swing.JLabel();
        cmbDriver = new javax.swing.JComboBox();
        lblAsal = new javax.swing.JLabel();
        cmbAsal = new javax.swing.JComboBox();
        lblTujuan = new javax.swing.JLabel();
        cmbTujuan = new javax.swing.JComboBox();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        lblMuatan = new javax.swing.JLabel();
        txtMuatan = new javax.swing.JTextField();
        pnlCard = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitle.setText("Form Pengangkutan");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));

        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));

        lblProduksi.setText("Produksi Tersedia");
        lblProduksi.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblProduksi.setForeground(new java.awt.Color(26, 43, 66));

        cmbProduksi.setBackground(new java.awt.Color(255, 255, 255));

        lblKendaraan.setText("Kendaraan Tersedia");
        lblKendaraan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblKendaraan.setForeground(new java.awt.Color(26, 43, 66));

        cmbKendaraan.setBackground(new java.awt.Color(255, 255, 255));

        lblDriver.setText("Driver Tersedia");
        lblDriver.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblDriver.setForeground(new java.awt.Color(26, 43, 66));

        cmbDriver.setBackground(new java.awt.Color(255, 255, 255));

        lblAsal.setText("Lokasi Asal (otomatis)");
        lblAsal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblAsal.setForeground(new java.awt.Color(26, 43, 66));

        cmbAsal.setBackground(new java.awt.Color(255, 255, 255));

        lblTujuan.setText("Lokasi Tujuan");
        lblTujuan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTujuan.setForeground(new java.awt.Color(26, 43, 66));

        cmbTujuan.setBackground(new java.awt.Color(255, 255, 255));

        lblTanggal.setText("Tanggal Pengangkutan");
        lblTanggal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));

        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));

        lblMuatan.setText("Muatan (ton)");
        lblMuatan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblMuatan.setForeground(new java.awt.Color(26, 43, 66));

        txtMuatan.setBackground(new java.awt.Color(255, 255, 255));

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        btnSimpan.setText("Simpan");
        btnSimpan.setFocusPainted(false);
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setBackground(new java.awt.Color(43, 106, 230));

        btnBatal.setText("Batal");
        btnBatal.setFocusPainted(false);
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setBackground(new java.awt.Color(26, 43, 66));

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblProduksi, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbProduksi, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblKendaraan, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbKendaraan, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblDriver, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbDriver, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblAsal, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbAsal, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblTujuan, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbTujuan, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblTanggal, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtTanggal, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblMuatan, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtMuatan, 352, 352, 352)
             )
            )
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblProduksi, 20, 20, 20)
                  .addComponent(cmbProduksi, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblKendaraan, 20, 20, 20)
                  .addComponent(cmbKendaraan, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblDriver, 20, 20, 20)
                  .addComponent(cmbDriver, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblAsal, 20, 20, 20)
                  .addComponent(cmbAsal, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblTujuan, 20, 20, 20)
                  .addComponent(cmbTujuan, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblTanggal, 20, 20, 20)
                  .addComponent(txtTanggal, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblMuatan, 20, 20, 20)
                  .addComponent(txtMuatan, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
            )
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(38, 38, 38)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblTitle, 644, 644, 644)
              )
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblHint, 644, 644, 644)
              )
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(pnlCard, 644, 644, 644)
              )
             )
                 .addGap(38, 38, 38)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(0, 0, Short.MAX_VALUE)
                 .addComponent(btnBatal, 120, 120, 120)
                 .addGap(10, 10, 10)
                 .addComponent(btnSimpan, 150, 150, 150)
                 .addGap(38, 38, 38)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(26, 26, 26)
                 .addComponent(lblTitle, 40, 40, 40)
                 .addGap(6, 6, 6)
                 .addComponent(lblHint, 22, 22, 22)
                 .addGap(18, 18, 18)
                 .addComponent(pnlCard, 356, 356, 356)
                 .addGap(22, 22, 22)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(btnSimpan, 42, 42, 42)
                  .addComponent(btnBatal, 42, 42, 42)
             )
                 .addGap(26, 26, 26)
            )
        );
    }// </editor-fold>//GEN-END:initComponents

    /** Format angka tanpa nol berlebih, contoh: 20.00 -> 20. */
    private static String angka(double nilai) {
        return java.math.BigDecimal.valueOf(nilai).stripTrailingZeros().toPlainString();
    }

    private void loadOptions() {
        daftarProduksi.clear();
        daftarProduksi.addAll(AppConfig.getProduksiController().tampilkanProduksiTersedia());

        for (ProduksiTambang v : daftarProduksi) {
            String label = String.format("Produksi #%d - %s (tersedia %s ton)",
                    v.getIdProduksi(), v.getMaterial().getNamaMaterial(), angka(v.getJumlahTersedia()));
            cmbProduksi.addItem(new PilihanData(v.getIdProduksi(), label));
        }

        for (Kendaraan v : AppConfig.getMasterDataController().tampilkanKendaraanTersedia()) {
            cmbKendaraan.addItem(new PilihanData(v.getIdKendaraan(),
                    v.getNomorPolisi() + " - " + v.getJenisKendaraan() + " (maks " + angka(v.getKapasitas()) + " ton)"));
        }

        for (Pegawai v : AppConfig.getMasterDataController().tampilkanDriverTersedia()) {
            cmbDriver.addItem(new PilihanData(v.getIdPegawai(), v.getNamaPegawai()));
        }

        // Tujuan hanya stockpile aktif; asal ditentukan otomatis oleh produksi terpilih.
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiAktif()) {
            if (v.getJenisLokasi() == enums.JenisLokasi.STOCKPILE)cmbTujuan.addItem(new PilihanData(v.getIdLokasi(), v.getNamaLokasi()));
        }
    }
    public PengangkutanFormFrame(Pengangkutan original) {
        this();this.original=original;
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        int asal=FormUtil.id(cmbAsal),tujuan=FormUtil.id(cmbTujuan);
        if(asal==tujuan)throw new IllegalArgumentException("Asal dan tujuan pengangkutan tidak boleh sama.");
        double jumlah;
        try { jumlah=Double.parseDouble(FormUtil.text(txtMuatan).replace(',', '.')); }
        catch(NumberFormatException e){throw new IllegalArgumentException("Muatan harus berupa angka, contoh: 20.5");}
        if(jumlah<=0)throw new IllegalArgumentException("Muatan harus lebih dari nol.");
        AppConfig.getPengangkutanController().buatPengangkutan(FormUtil.id(cmbProduksi),FormUtil.id(cmbKendaraan),FormUtil.id(cmbDriver),asal,tujuan,getTanggalPengangkutan(),jumlah);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbAsal;
    private javax.swing.JComboBox cmbDriver;
    private javax.swing.JComboBox cmbKendaraan;
    private javax.swing.JComboBox cmbProduksi;
    private javax.swing.JComboBox cmbTujuan;
    private javax.swing.JLabel lblAsal;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblKendaraan;
    private javax.swing.JLabel lblMuatan;
    private javax.swing.JLabel lblProduksi;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTujuan;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JTextField txtMuatan;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
