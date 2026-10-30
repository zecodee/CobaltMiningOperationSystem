package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DetailMonitoringFormFrame extends javax.swing.JFrame {
    private DetailMonitoring original;
    private boolean saved;
    public boolean isSaved(){return saved;}
    private int monitoringId;

    public DetailMonitoringFormFrame() {
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
        lblParameter = new javax.swing.JLabel();
        cmbParameter = new javax.swing.JComboBox();
        lblNilai = new javax.swing.JLabel();
        txtNilai = new javax.swing.JTextField();
        lblCatatan = new javax.swing.JLabel();
        txtCatatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM DETAILMONITORING");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblParameter.setForeground(new java.awt.Color(26, 43, 66));
        lblParameter.setText("Parameter Lingkungan");
        cmbParameter.setBackground(new java.awt.Color(255, 255, 255));
        lblNilai.setForeground(new java.awt.Color(26, 43, 66));
        lblNilai.setText("Nilai Pengukuran");
        txtNilai.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblParameter, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbParameter, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblNilai, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtNilai, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblCatatan, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtCatatan, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblParameter, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbParameter, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblNilai, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtNilai, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblCatatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtCatatan, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        for (ParameterLingkungan v : AppConfig.getMasterDataController().tampilkanSemuaParameter()) { cmbParameter.addItem(new PilihanData(v.getIdParameter(), String.valueOf(v.getNamaParameter()))); }
    }
    public DetailMonitoringFormFrame(int monitoringId) {
        this();this.monitoringId=monitoringId;
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        double nilai=Double.parseDouble(FormUtil.text(txtNilai));
        AppConfig.getMonitoringController().tambahDetail(monitoringId,FormUtil.id(cmbParameter),nilai,FormUtil.text(txtCatatan));

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblParameter;
    private javax.swing.JComboBox cmbParameter;
    private javax.swing.JLabel lblNilai;
    private javax.swing.JTextField txtNilai;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JTextField txtCatatan;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
