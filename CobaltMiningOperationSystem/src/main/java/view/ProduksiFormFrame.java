package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProduksiFormFrame extends javax.swing.JFrame {
    private ProduksiTambang original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public ProduksiFormFrame() {
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
        txtTanggal.setMaxSelectableDate(new Date());
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try { loadOptions(); SearchableCombo.install(cmbMaterial); SearchableCombo.install(cmbLokasi); } catch(Exception ex) { FormUtil.error(this,ex); }

    }

    private LocalDate getTanggalProduksi() {
        Date tanggal = txtTanggal.getDate();

        if (tanggal == null)throw new IllegalArgumentException("Silakan pilih tanggal produksi.");
        return tanggal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private void setTanggalProduksi(LocalDate tanggal) {
        txtTanggal.setDate(tanggal == null ? null : Date.from(tanggal.atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        lblMaterial = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox();
        lblLokasi = new javax.swing.JLabel();
        cmbLokasi = new javax.swing.JComboBox();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        lblJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        pnlCard = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitle.setText("Form Produksi Tambang");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));

        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));

        lblMaterial.setText("Material");
        lblMaterial.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblMaterial.setForeground(new java.awt.Color(26, 43, 66));

        cmbMaterial.setBackground(new java.awt.Color(255, 255, 255));

        lblLokasi.setText("Lokasi PIT Aktif");
        lblLokasi.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(26, 43, 66));

        cmbLokasi.setBackground(new java.awt.Color(255, 255, 255));

        lblTanggal.setText("Tanggal Produksi");
        lblTanggal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));

        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));

        lblJumlah.setText("Jumlah Produksi (ton)");
        lblJumlah.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblJumlah.setForeground(new java.awt.Color(26, 43, 66));

        txtJumlah.setBackground(new java.awt.Color(255, 255, 255));

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
                 .addComponent(lblMaterial, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbMaterial, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblLokasi, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbLokasi, 352, 352, 352)
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
                 .addComponent(lblJumlah, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtJumlah, 352, 352, 352)
             )
            )
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblMaterial, 20, 20, 20)
                  .addComponent(cmbMaterial, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblLokasi, 20, 20, 20)
                  .addComponent(cmbLokasi, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblTanggal, 20, 20, 20)
                  .addComponent(txtTanggal, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblJumlah, 20, 20, 20)
                  .addComponent(txtJumlah, 32, 32, 32)
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
                 .addComponent(pnlCard, 218, 218, 218)
                 .addGap(22, 22, 22)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(btnSimpan, 42, 42, 42)
                  .addComponent(btnBatal, 42, 42, 42)
             )
                 .addGap(26, 26, 26)
            )
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadOptions() {
        for (JenisMaterial v : AppConfig.getMasterDataController().tampilkanSemuaMaterial()) { cmbMaterial.addItem(new PilihanData(v.getIdMaterial(), v.getNamaMaterial())); }
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiPitAktif()) { cmbLokasi.addItem(new PilihanData(v.getIdLokasi(), v.getNamaLokasi())); }
    }
    public ProduksiFormFrame(ProduksiTambang original) {
        this();
        this.original=original;
        if(original!=null) {
        setTitle("Ubah Produksi #" + original.getIdProduksi());
        lblTitle.setText("Form Produksi Tambang (Ubah)");
        FormUtil.select(cmbMaterial,original.getMaterial().getIdMaterial());
        FormUtil.select(cmbLokasi,original.getLokasi().getIdLokasi());
        setTanggalProduksi(original.getTanggalProduksi());
        txtJumlah.setText(String.valueOf(original.getJumlahProduksi()));
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        int mat=FormUtil.id(cmbMaterial),lok=FormUtil.id(cmbLokasi);
        LocalDate t=getTanggalProduksi();
        double jumlah;
        try { jumlah=Double.parseDouble(FormUtil.text(txtJumlah).replace(',', '.')); }
        catch(NumberFormatException e){throw new IllegalArgumentException("Jumlah produksi harus berupa angka, contoh: 120.5");}
        if(jumlah<=0)throw new IllegalArgumentException("Jumlah produksi harus lebih besar dari nol.");
        if(original==null)AppConfig.getProduksiController().tambahProduksi(mat,lok,t,jumlah);
        else AppConfig.getProduksiController().ubahProduksi(original.getIdProduksi(),mat,lok,t,jumlah);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbLokasi;
    private javax.swing.JComboBox cmbMaterial;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JTextField txtJumlah;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
