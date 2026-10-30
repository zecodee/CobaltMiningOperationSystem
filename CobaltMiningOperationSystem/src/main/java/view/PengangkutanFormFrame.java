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

    public PengangkutanFormFrame() {
        initComponents();
        setSize(720, 559);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try { loadOptions(); } catch(Exception ex) { FormUtil.error(this,ex); }

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
        txtTanggal = new javax.swing.JTextField();
        lblMuatan = new javax.swing.JLabel();
        txtMuatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM PENGANGKUTAN");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblProduksi.setForeground(new java.awt.Color(26, 43, 66));
        lblProduksi.setText("Produksi Tersedia");
        cmbProduksi.setBackground(new java.awt.Color(255, 255, 255));
        lblKendaraan.setForeground(new java.awt.Color(26, 43, 66));
        lblKendaraan.setText("Kendaraan Tersedia");
        cmbKendaraan.setBackground(new java.awt.Color(255, 255, 255));
        lblDriver.setForeground(new java.awt.Color(26, 43, 66));
        lblDriver.setText("Driver Tersedia");
        cmbDriver.setBackground(new java.awt.Color(255, 255, 255));
        lblAsal.setForeground(new java.awt.Color(26, 43, 66));
        lblAsal.setText("Lokasi Asal");
        cmbAsal.setBackground(new java.awt.Color(255, 255, 255));
        lblTujuan.setForeground(new java.awt.Color(26, 43, 66));
        lblTujuan.setText("Lokasi Tujuan");
        cmbTujuan.setBackground(new java.awt.Color(255, 255, 255));
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));
        lblTanggal.setText("Tanggal (yyyy-MM-dd)");
        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));
        lblMuatan.setForeground(new java.awt.Color(26, 43, 66));
        lblMuatan.setText("Muatan (ton)");
        txtMuatan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setBackground(new java.awt.Color(43, 106, 230));
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 13));
        btnSimpan.setFocusPainted(false);
        btnBatal.setBackground(new java.awt.Color(26, 43, 66));
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 13));
        btnBatal.setFocusPainted(false);
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        btnBatal.addActionListener(this::btnBatalActionPerformed);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(34).addComponent(lblTitle, 650, 650, 650))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblHint, 650, 650, 650))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblProduksi, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbProduksi, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblKendaraan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbKendaraan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblDriver, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbDriver, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblAsal, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbAsal, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTujuan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbTujuan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTanggal, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtTanggal, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblMuatan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtMuatan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblProduksi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbProduksi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblKendaraan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(cmbKendaraan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblDriver, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(cmbDriver, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(lblAsal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(cmbAsal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(lblTujuan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(cmbTujuan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(350).addComponent(lblTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(350).addComponent(txtTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(397).addComponent(lblMuatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(397).addComponent(txtMuatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(459).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(459).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        for (ProduksiTambang v : AppConfig.getProduksiController().tampilkanProduksiTersedia()) { cmbProduksi.addItem(new PilihanData(v.getIdProduksi(), String.valueOf(v.getIdProduksi()))); }
        for (Kendaraan v : AppConfig.getMasterDataController().tampilkanKendaraanTersedia()) { cmbKendaraan.addItem(new PilihanData(v.getIdKendaraan(), String.valueOf(v.getNomorPolisi()))); }
        for (Pegawai v : AppConfig.getMasterDataController().tampilkanSemuaPegawai()) { if (v instanceof Driver && ((Driver)v).getStatusDriver()==StatusDriver.TERSEDIA) cmbDriver.addItem(new PilihanData(v.getIdPegawai(), String.valueOf(v.getNamaPegawai()))); }
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiAktif()) { cmbAsal.addItem(new PilihanData(v.getIdLokasi(), String.valueOf(v.getNamaLokasi()))); }
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiAktif()) { cmbTujuan.addItem(new PilihanData(v.getIdLokasi(), String.valueOf(v.getNamaLokasi()))); }
    }
    public PengangkutanFormFrame(Pengangkutan original) {
        this();this.original=original;
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        int asal=FormUtil.id(cmbAsal),tujuan=FormUtil.id(cmbTujuan);
        if(asal==tujuan)throw new IllegalArgumentException("Asal dan tujuan pengangkutan tidak boleh sama.");
        double jumlah=Double.parseDouble(FormUtil.text(txtMuatan));
        if(jumlah<=0)throw new IllegalArgumentException("Muatan harus lebih dari nol.");
        AppConfig.getPengangkutanController().buatPengangkutan(FormUtil.id(cmbProduksi),FormUtil.id(cmbKendaraan),FormUtil.id(cmbDriver),asal,tujuan,LocalDate.parse(FormUtil.text(txtTanggal)),jumlah);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblProduksi;
    private javax.swing.JComboBox cmbProduksi;
    private javax.swing.JLabel lblKendaraan;
    private javax.swing.JComboBox cmbKendaraan;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JComboBox cmbDriver;
    private javax.swing.JLabel lblAsal;
    private javax.swing.JComboBox cmbAsal;
    private javax.swing.JLabel lblTujuan;
    private javax.swing.JComboBox cmbTujuan;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JLabel lblMuatan;
    private javax.swing.JTextField txtMuatan;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
