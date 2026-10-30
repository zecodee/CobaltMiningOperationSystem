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
        setSize(720, 525);
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
        lblMaterial = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox();
        lblLokasi = new javax.swing.JLabel();
        cmbLokasi = new javax.swing.JComboBox();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblJumlah = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM PRODUKSI");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblMaterial.setForeground(new java.awt.Color(26, 43, 66));
        lblMaterial.setText("Material");
        cmbMaterial.setBackground(new java.awt.Color(255, 255, 255));
        lblLokasi.setForeground(new java.awt.Color(26, 43, 66));
        lblLokasi.setText("Lokasi PIT Aktif");
        cmbLokasi.setBackground(new java.awt.Color(255, 255, 255));
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));
        lblTanggal.setText("Tanggal (yyyy-MM-dd)");
        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));
        lblJumlah.setForeground(new java.awt.Color(26, 43, 66));
        lblJumlah.setText("Jumlah Produksi (ton)");
        txtJumlah.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblMaterial, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbMaterial, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblLokasi, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbLokasi, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTanggal, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtTanggal, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblJumlah, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtJumlah, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblMaterial, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbMaterial, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblLokasi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(cmbLokasi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(lblJumlah, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(txtJumlah, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(318).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(318).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        for (JenisMaterial v : AppConfig.getMasterDataController().tampilkanSemuaMaterial()) { cmbMaterial.addItem(new PilihanData(v.getIdMaterial(), String.valueOf(v.getNamaMaterial()))); }
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiPitAktif()) { cmbLokasi.addItem(new PilihanData(v.getIdLokasi(), String.valueOf(v.getNamaLokasi()))); }
    }
    public ProduksiFormFrame(ProduksiTambang original) {
        this();
        this.original=original;
        if(original!=null) {
        FormUtil.select(cmbMaterial,original.getMaterial().getIdMaterial());
        FormUtil.select(cmbLokasi,original.getLokasi().getIdLokasi());
        txtTanggal.setText(String.valueOf(original.getTanggalProduksi()));
        txtJumlah.setText(String.valueOf(original.getJumlahProduksi()));
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        int mat=FormUtil.id(cmbMaterial),lok=FormUtil.id(cmbLokasi);
        LocalDate t=LocalDate.parse(FormUtil.text(txtTanggal));double jumlah=Double.parseDouble(FormUtil.text(txtJumlah));
        if(jumlah<=0)throw new IllegalArgumentException("Jumlah produksi harus positif.");
        if(original==null)AppConfig.getProduksiController().tambahProduksi(mat,lok,t,jumlah);
        else AppConfig.getProduksiController().ubahProduksi(original.getIdProduksi(),mat,lok,t,jumlah);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblMaterial;
    private javax.swing.JComboBox cmbMaterial;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JComboBox cmbLokasi;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JLabel lblJumlah;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
