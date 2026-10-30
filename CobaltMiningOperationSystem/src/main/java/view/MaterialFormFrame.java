package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MaterialFormFrame extends javax.swing.JFrame {
    private JenisMaterial original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public MaterialFormFrame() {
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
        lblSatuan = new javax.swing.JLabel();
        txtSatuan = new javax.swing.JTextField();
        lblDeskripsi = new javax.swing.JLabel();
        txtDeskripsi = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM MATERIAL");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblNama.setForeground(new java.awt.Color(26, 43, 66));
        lblNama.setText("Nama Material");
        txtNama.setBackground(new java.awt.Color(255, 255, 255));
        lblSatuan.setForeground(new java.awt.Color(26, 43, 66));
        lblSatuan.setText("Satuan");
        txtSatuan.setBackground(new java.awt.Color(255, 255, 255));
        lblDeskripsi.setForeground(new java.awt.Color(26, 43, 66));
        lblDeskripsi.setText("Deskripsi");
        txtDeskripsi.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblSatuan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtSatuan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblDeskripsi, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtDeskripsi, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(txtNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblSatuan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtSatuan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblDeskripsi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtDeskripsi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {

    }
    public MaterialFormFrame(JenisMaterial original) {
        this();
        this.original=original;
        if(original!=null) {
        txtNama.setText(original.getNamaMaterial());
        txtSatuan.setText(original.getSatuan());
        txtDeskripsi.setText(original.getDeskripsi());
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        FormUtil.require(FormUtil.text(txtNama),"Nama material");FormUtil.require(FormUtil.text(txtSatuan),"Satuan");
        JenisMaterial m=new JenisMaterial(original==null?0:original.getIdMaterial(),FormUtil.text(txtNama),FormUtil.text(txtSatuan),FormUtil.text(txtDeskripsi));
        if(original==null)AppConfig.getMasterDataController().tambahMaterial(m);
        else AppConfig.getMasterDataController().ubahMaterial(m);

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
    private javax.swing.JLabel lblSatuan;
    private javax.swing.JTextField txtSatuan;
    private javax.swing.JLabel lblDeskripsi;
    private javax.swing.JTextField txtDeskripsi;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
