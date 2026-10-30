package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MonitoringFormFrame extends javax.swing.JFrame {
    private MonitoringLingkungan original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public MonitoringFormFrame() {
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
        lblLokasi = new javax.swing.JLabel();
        cmbLokasi = new javax.swing.JComboBox();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblCatatan = new javax.swing.JLabel();
        txtCatatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM MONITORING");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblLokasi.setForeground(new java.awt.Color(26, 43, 66));
        lblLokasi.setText("Lokasi");
        cmbLokasi.setBackground(new java.awt.Color(255, 255, 255));
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));
        lblTanggal.setText("Tanggal Waktu (yyyy-MM-ddTHH:mm)");
        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));
        lblCatatan.setForeground(new java.awt.Color(26, 43, 66));
        lblCatatan.setText("Catatan");
        txtCatatan.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblLokasi, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbLokasi, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTanggal, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtTanggal, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblCatatan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtCatatan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblLokasi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbLokasi, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblCatatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtCatatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiAktif()) { cmbLokasi.addItem(new PilihanData(v.getIdLokasi(), String.valueOf(v.getNamaLokasi()))); }
    }
    public MonitoringFormFrame(MonitoringLingkungan original) {
        this();this.original=original;
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        FormUtil.require(FormUtil.text(txtTanggal),"Tanggal monitoring");
        AppConfig.getMonitoringController().buatMonitoring(FormUtil.id(cmbLokasi),LocalDateTime.parse(FormUtil.text(txtTanggal)),FormUtil.text(txtCatatan));

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JComboBox cmbLokasi;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JTextField txtCatatan;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
