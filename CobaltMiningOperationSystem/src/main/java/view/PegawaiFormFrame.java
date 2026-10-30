package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PegawaiFormFrame extends javax.swing.JFrame {
    private Pegawai original;
    private boolean saved;
    public boolean isSaved(){return saved;}

    public PegawaiFormFrame() {
        initComponents();
        setSize(720, 610);
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
        cmbJenis = new javax.swing.JComboBox();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        lblHp = new javax.swing.JLabel();
        txtHp = new javax.swing.JTextField();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        lblKhusus1 = new javax.swing.JLabel();
        txtKhusus1 = new javax.swing.JTextField();
        lblKhusus2 = new javax.swing.JLabel();
        txtKhusus2 = new javax.swing.JTextField();
        lblDriverstatus = new javax.swing.JLabel();
        cmbDriverStatus = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("FORM PEGAWAI");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblJenis.setForeground(new java.awt.Color(26, 43, 66));
        lblJenis.setText("Jenis Pegawai");
        cmbJenis.setBackground(new java.awt.Color(255, 255, 255));
        lblNama.setForeground(new java.awt.Color(26, 43, 66));
        lblNama.setText("Nama Pegawai");
        txtNama.setBackground(new java.awt.Color(255, 255, 255));
        lblHp.setForeground(new java.awt.Color(26, 43, 66));
        lblHp.setText("Nomor HP");
        txtHp.setBackground(new java.awt.Color(255, 255, 255));
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));
        lblTanggal.setText("Tanggal Masuk (yyyy-MM-dd)");
        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setForeground(new java.awt.Color(26, 43, 66));
        lblStatus.setText("Status Pegawai");
        cmbStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblKhusus1.setForeground(new java.awt.Color(26, 43, 66));
        lblKhusus1.setText("Data Khusus 1");
        txtKhusus1.setBackground(new java.awt.Color(255, 255, 255));
        lblKhusus2.setForeground(new java.awt.Color(26, 43, 66));
        lblKhusus2.setText("Data Khusus 2 (tanggal)");
        txtKhusus2.setBackground(new java.awt.Color(255, 255, 255));
        lblDriverstatus.setForeground(new java.awt.Color(26, 43, 66));
        lblDriverstatus.setText("Status Driver");
        cmbDriverStatus.setBackground(new java.awt.Color(255, 255, 255));
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
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbJenis, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblNama, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtNama, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblHp, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtHp, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblTanggal, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtTanggal, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblStatus, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbStatus, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblKhusus1, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtKhusus1, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblKhusus2, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(txtKhusus2, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(35).addComponent(lblDriverstatus, 260, 260, 260))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(cmbDriverStatus, 365, 365, 365))
                .addGroup(layout.createSequentialGroup().addGap(310).addComponent(btnSimpan, 173, 173, 173))
                .addGroup(layout.createSequentialGroup().addGap(501).addComponent(btnBatal, 174, 174, 174))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(24).addComponent(lblTitle, 43, 43, 43))
                .addGroup(layout.createSequentialGroup().addGap(69).addComponent(lblHint, 25, 25, 25))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(lblJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(115).addComponent(cmbJenis, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(lblNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(162).addComponent(txtNama, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(lblHp, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(209).addComponent(txtHp, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(lblTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(256).addComponent(txtTanggal, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(lblStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(303).addComponent(cmbStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(350).addComponent(lblKhusus1, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(350).addComponent(txtKhusus1, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(397).addComponent(lblKhusus2, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(397).addComponent(txtKhusus2, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(444).addComponent(lblDriverstatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(444).addComponent(cmbDriverStatus, 32, 32, 32))
                .addGroup(layout.createSequentialGroup().addGap(506).addComponent(btnSimpan, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(506).addComponent(btnBatal, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void loadOptions() {
        cmbJenis.setModel(new DefaultComboBoxModel<>(new String[]{"ADMIN","OPERASIONAL","HSE","MANAGER","DRIVER"}));
        cmbStatus.setModel(new DefaultComboBoxModel<>(new String[]{"AKTIF","NONAKTIF"}));
        cmbDriverStatus.setModel(new DefaultComboBoxModel<>(new String[]{"TERSEDIA","BERTUGAS","NONAKTIF"}));
    }
    
    public PegawaiFormFrame(Pegawai original) {
        this();
        this.original=original;
        if(original!=null) {
        cmbJenis.setSelectedItem(original.getJenisPegawai().replace("PETUGAS", ""));
        txtNama.setText(original.getNamaPegawai());
        txtHp.setText(original.getNoHp());
        txtTanggal.setText(String.valueOf(original.getTanggalMasuk()));
        cmbStatus.setSelectedItem(String.valueOf(original.getStatusPegawai()));
        if(original instanceof Admin){txtKhusus1.setText(((Admin)original).getKodeAdmin());txtKhusus2.setText(String.valueOf(((Admin)original).getTanggalMulaiAkses()));}
        if(original instanceof PetugasOperasional){txtKhusus1.setText(String.valueOf(((PetugasOperasional)original).getShiftKerja()));}
        if(original instanceof PetugasHSE){txtKhusus1.setText(((PetugasHSE)original).getNoSertifikasiHSE());txtKhusus2.setText(String.valueOf(((PetugasHSE)original).getMasaBerlakuSertifikasi()));}
        if(original instanceof Manager){txtKhusus1.setText(((Manager)original).getDivisiTanggungJawab());}
        if(original instanceof Driver){txtKhusus1.setText(((Driver)original).getNoSim());txtKhusus2.setText(String.valueOf(((Driver)original).getMasaBerlakuSim()));cmbDriverStatus.setSelectedItem(String.valueOf(((Driver)original).getStatusDriver()));}
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {

        String kind=String.valueOf(cmbJenis.getSelectedItem()).toUpperCase().replace("PETUGAS", "");
        String nama=FormUtil.text(txtNama), hp=FormUtil.text(txtHp), khusus=FormUtil.text(txtKhusus1), k2=FormUtil.text(txtKhusus2);
        FormUtil.require(nama,"Nama pegawai");FormUtil.require(hp,"Nomor HP");
        int id=original==null?0:original.getIdPegawai();
        LocalDate tanggal=LocalDate.parse(FormUtil.text(txtTanggal));
        StatusPegawai status=StatusPegawai.valueOf(String.valueOf(cmbStatus.getSelectedItem()));
        Pegawai p;
        switch(kind){
          case "ADMIN":p=new Admin(id,nama,hp,tanggal,status,khusus,LocalDate.parse(k2));break;
          case "OPERASIONAL":p=new PetugasOperasional(id,nama,hp,tanggal,status,ShiftKerja.valueOf(khusus.toUpperCase()));break;
          case "HSE":p=new PetugasHSE(id,nama,hp,tanggal,status,khusus,LocalDate.parse(k2));break;
          case "MANAGER":p=new Manager(id,nama,hp,tanggal,status,khusus);break;
          case "DRIVER":p=new Driver(id,nama,hp,tanggal,status,khusus,LocalDate.parse(k2),StatusDriver.valueOf(String.valueOf(cmbDriverStatus.getSelectedItem())));break;
          default:throw new IllegalArgumentException("Jenis pegawai tidak dikenal.");
        }
        if(original==null) AppConfig.getMasterDataController().tambahPegawai(p);
        else AppConfig.getMasterDataController().ubahPegawai(p);

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
    private javax.swing.JComboBox cmbJenis;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTextField txtNama;
    private javax.swing.JLabel lblHp;
    private javax.swing.JTextField txtHp;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel lblKhusus1;
    private javax.swing.JTextField txtKhusus1;
    private javax.swing.JLabel lblKhusus2;
    private javax.swing.JTextField txtKhusus2;
    private javax.swing.JLabel lblDriverstatus;
    private javax.swing.JComboBox cmbDriverStatus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBatal;
    // End of variables declaration//GEN-END:variables
}
