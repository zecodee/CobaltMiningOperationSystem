package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserFormFrame extends javax.swing.JFrame {
    private User original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public UserFormFrame() {
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
        lblPegawai = new javax.swing.JLabel();
        cmbPegawai = new javax.swing.JComboBox();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM USER");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblPegawai.setForeground(new java.awt.Color(26, 43, 66));
        lblPegawai.setText("Pegawai");
        cmbPegawai.setBackground(new java.awt.Color(255, 255, 255));
        lblUsername.setForeground(new java.awt.Color(26, 43, 66));
        lblUsername.setText("Username");
        txtUsername.setBackground(new java.awt.Color(255, 255, 255));
        lblPassword.setForeground(new java.awt.Color(26, 43, 66));
        lblPassword.setText("Password (kosong jika tetap)");
        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblPegawai, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbPegawai, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblUsername, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtUsername, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblPassword, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtPassword, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblPegawai, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbPegawai, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblUsername, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtUsername, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblPassword, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtPassword, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(271).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        for (Pegawai v : AppConfig.getMasterDataController().tampilkanSemuaPegawai()) { cmbPegawai.addItem(new PilihanData(v.getIdPegawai(), String.valueOf(v.getNamaPegawai()))); }
    }
    public UserFormFrame(User original) {
        this();
        this.original=original;
        if(original!=null) {
        FormUtil.select(cmbPegawai,original.getPegawai().getIdPegawai());
        txtUsername.setText(original.getUsername());
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        String username=FormUtil.text(txtUsername), password=new String(txtPassword.getPassword());
        FormUtil.require(username,"Username");
        if(original==null)FormUtil.require(password,"Password");
        Pegawai p=AppConfig.getMasterDataController().cariPegawaiById(FormUtil.id(cmbPegawai));
        User u=new User(original==null?0:original.getIdUser(),p,username,password);
        if(original==null)AppConfig.getMasterDataController().tambahUser(u);
        else AppConfig.getMasterDataController().ubahUser(u);

            saved=true;
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan.");
            dispose();
        } catch(Exception ex) { FormUtil.error(this,ex); }
    }
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblPegawai;
    private javax.swing.JComboBox cmbPegawai;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
