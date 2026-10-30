package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LokasiFormFrame extends javax.swing.JFrame {
    private Lokasi original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public LokasiFormFrame() {
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
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblJenis = new javax.swing.JLabel();
        cmbJenis = new javax.swing.JComboBox();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        lblKet = new javax.swing.JLabel();
        txtKet = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM LOKASI");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblNama.setForeground(new java.awt.Color(26, 43, 66));
        lblNama.setText("Nama Lokasi");
        txtNama.setBackground(new java.awt.Color(255, 255, 255));
        lblJenis.setForeground(new java.awt.Color(26, 43, 66));
        lblJenis.setText("Jenis Lokasi");
        cmbJenis.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setForeground(new java.awt.Color(26, 43, 66));
        lblStatus.setText("Status Lokasi");
        cmbStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblKet.setForeground(new java.awt.Color(26, 43, 66));
        lblKet.setText("Keterangan");
        txtKet.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblNama, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtNama, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblJenis, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbJenis, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblStatus, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbStatus, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblKet, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtKet, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(txtNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(cmbJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(cmbStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(lblKet, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(txtKet, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(318).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(318).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        cmbJenis.setModel(new DefaultComboBoxModel<>(new String[]{"PIT","STOCKPILE"}));
        cmbStatus.setModel(new DefaultComboBoxModel<>(new String[]{"AKTIF","DIBATASI","DITUTUP_SEMENTARA"}));
    }
    public LokasiFormFrame(Lokasi original) {
        this();
        this.original=original;
        if(original!=null) {
        txtNama.setText(original.getNamaLokasi());
        cmbJenis.setSelectedItem(String.valueOf(original.getJenisLokasi()));
        cmbStatus.setSelectedItem(String.valueOf(original.getStatusOperasional()));
        txtKet.setText(original.getKeterangan());
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        FormUtil.require(FormUtil.text(txtNama),"Nama lokasi");
        Lokasi l=new Lokasi(original==null?0:original.getIdLokasi(),FormUtil.text(txtNama),JenisLokasi.valueOf(String.valueOf(cmbJenis.getSelectedItem())),StatusLokasi.valueOf(String.valueOf(cmbStatus.getSelectedItem())),FormUtil.text(txtKet));
        if(original==null)AppConfig.getMasterDataController().tambahLokasi(l);
        else AppConfig.getMasterDataController().ubahLokasi(l);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTextField txtNama;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel lblKet;
    private javax.swing.JTextField txtKet;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
