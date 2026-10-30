package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KendaraanFormFrame extends javax.swing.JFrame {
    private Kendaraan original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public KendaraanFormFrame() {
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
        lblJenis = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        lblPolisi = new javax.swing.JLabel();
        txtPolisi = new javax.swing.JTextField();
        lblKapasitas = new javax.swing.JLabel();
        txtKapasitas = new javax.swing.JTextField();
        lblTahun = new javax.swing.JLabel();
        txtTahun = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM KENDARAAN");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblJenis.setForeground(new java.awt.Color(26, 43, 66));
        lblJenis.setText("Jenis Kendaraan");
        txtJenis.setBackground(new java.awt.Color(255, 255, 255));
        lblPolisi.setForeground(new java.awt.Color(26, 43, 66));
        lblPolisi.setText("Nomor Polisi");
        txtPolisi.setBackground(new java.awt.Color(255, 255, 255));
        lblKapasitas.setForeground(new java.awt.Color(26, 43, 66));
        lblKapasitas.setText("Kapasitas (ton)");
        txtKapasitas.setBackground(new java.awt.Color(255, 255, 255));
        lblTahun.setForeground(new java.awt.Color(26, 43, 66));
        lblTahun.setText("Tahun");
        txtTahun.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setForeground(new java.awt.Color(26, 43, 66));
        lblStatus.setText("Status Kendaraan");
        cmbStatus.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblJenis, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtJenis, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblPolisi, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtPolisi, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblKapasitas, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtKapasitas, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTahun, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtTahun, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblStatus, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbStatus, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(txtJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblPolisi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtPolisi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblKapasitas, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtKapasitas, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(lblTahun, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(txtTahun, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(lblStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(cmbStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(365).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(365).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        cmbStatus.setModel(new DefaultComboBoxModel<>(new String[]{"TERSEDIA","DIGUNAKAN","NONAKTIF"}));
    }
    public KendaraanFormFrame(Kendaraan original) {
        this();
        this.original=original;
        if(original!=null) {
        txtJenis.setText(original.getJenisKendaraan());
        txtPolisi.setText(original.getNomorPolisi());
        txtKapasitas.setText(String.valueOf(original.getKapasitas()));
        txtTahun.setText(String.valueOf(original.getTahunKendaraan()));
        cmbStatus.setSelectedItem(String.valueOf(original.getStatusKendaraan()));
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        FormUtil.require(FormUtil.text(txtJenis),"Jenis kendaraan");FormUtil.require(FormUtil.text(txtPolisi),"Nomor polisi");
        Kendaraan k=new Kendaraan(original==null?0:original.getIdKendaraan(),FormUtil.text(txtJenis),FormUtil.text(txtPolisi),Double.parseDouble(FormUtil.text(txtKapasitas)),Integer.parseInt(FormUtil.text(txtTahun)),StatusKendaraan.valueOf(String.valueOf(cmbStatus.getSelectedItem())));
        if(original==null)AppConfig.getMasterDataController().tambahKendaraan(k);
        else AppConfig.getMasterDataController().ubahKendaraan(k);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JLabel lblPolisi;
    private javax.swing.JTextField txtPolisi;
    private javax.swing.JLabel lblKapasitas;
    private javax.swing.JTextField txtKapasitas;
    private javax.swing.JLabel lblTahun;
    private javax.swing.JTextField txtTahun;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
