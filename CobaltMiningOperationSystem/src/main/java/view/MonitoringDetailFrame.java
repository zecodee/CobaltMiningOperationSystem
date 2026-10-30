package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MonitoringDetailFrame extends javax.swing.JFrame {
    private int monitoringId;
    private boolean readOnly;
    private void refreshData(){
        MonitoringLingkungan m=AppConfig.getMonitoringRepository().findById(monitoringId).orElseThrow(()->new IllegalArgumentException("Monitoring tidak ditemukan."));
        lblInfo.setText("Lokasi: "+m.getLokasi().getNamaLokasi()+" | Status: "+m.getStatusMonitoring());
        DefaultTableModel model=new DefaultTableModel(new String[]{"Parameter","Nilai","Satuan","Hasil"},0){
            @Override public boolean isCellEditable(int r,int c){return false;}
        };
        for(DetailMonitoring d:m.getDetailMonitoring())model.addRow(new Object[]{d.getParameter().getNamaParameter(),d.getNilaiPengukuran(),d.getParameter().getSatuan(),d.getStatusDetail()});
        tblDetail.setModel(model);
    }
    public MonitoringDetailFrame(int id,boolean readOnly){
        this();monitoringId=id;this.readOnly=readOnly;
        btnTambah.setVisible(!readOnly);btnTindak.setVisible(!readOnly);
        btnMulai.setVisible(!readOnly);btnSelesai.setVisible(!readOnly);
        try{refreshData();}catch(Exception ex){FormUtil.error(this,ex);}
    }

    public MonitoringDetailFrame() {
        initComponents();
        setSize(735,600);setResizable(false);setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        scrollDetail = new javax.swing.JScrollPane();
        btnTambah = new javax.swing.JButton();
        btnTindak = new javax.swing.JButton();
        btnMulai = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("DETAIL MONITORING");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblInfo.setForeground(new java.awt.Color(103, 121, 143));
        lblInfo.setText("Pilih pengukuran dan tindak lanjut.");
        lblInfo.setFont(new java.awt.Font("SansSerif", 1, 12));
        scrollDetail.setBackground(new java.awt.Color(255, 255, 255));
        btnTambah.setBackground(new java.awt.Color(43, 106, 230));
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah Pengukuran");
        btnTambah.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnTambah.setFocusPainted(false);
        btnTindak.setBackground(new java.awt.Color(26, 43, 66));
        btnTindak.setForeground(new java.awt.Color(255, 255, 255));
        btnTindak.setText("Tindak Lanjut");
        btnTindak.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnTindak.setFocusPainted(false);
        btnMulai.setBackground(new java.awt.Color(26, 43, 66));
        btnMulai.setForeground(new java.awt.Color(255, 255, 255));
        btnMulai.setText("Mulai Penanganan");
        btnMulai.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnMulai.setFocusPainted(false);
        btnSelesai.setBackground(new java.awt.Color(26, 43, 66));
        btnSelesai.setForeground(new java.awt.Color(255, 255, 255));
        btnSelesai.setText("Selesai Penanganan");
        btnSelesai.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnSelesai.setFocusPainted(false);
        btnTutup.setBackground(new java.awt.Color(26, 43, 66));
        btnTutup.setForeground(new java.awt.Color(255, 255, 255));
        btnTutup.setText("Tutup");
        btnTutup.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnTutup.setFocusPainted(false);
        tblDetail=new javax.swing.JTable();
        scrollDetail.setViewportView(tblDetail);
        btnTambah.addActionListener(this::btnTambahActionPerformed);
        btnTindak.addActionListener(this::btnTindakActionPerformed);
        btnMulai.addActionListener(this::btnMulaiActionPerformed);
        btnSelesai.addActionListener(this::btnSelesaiActionPerformed);
        btnTutup.addActionListener(this::btnTutupActionPerformed);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(30).addComponent(lblTitle, 650, 650, 650))
                .addGroup(layout.createSequentialGroup().addGap(30).addComponent(lblInfo, 650, 650, 650))
                .addGroup(layout.createSequentialGroup().addGap(30).addComponent(scrollDetail, 650, 650, 650))
                .addGroup(layout.createSequentialGroup().addGap(30).addComponent(btnTambah, 190, 190, 190))
                .addGroup(layout.createSequentialGroup().addGap(232).addComponent(btnTindak, 190, 190, 190))
                .addGroup(layout.createSequentialGroup().addGap(30).addComponent(btnMulai, 190, 190, 190))
                .addGroup(layout.createSequentialGroup().addGap(232).addComponent(btnSelesai, 190, 190, 190))
                .addGroup(layout.createSequentialGroup().addGap(490).addComponent(btnTutup, 190, 190, 190))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(20).addComponent(lblTitle, 40, 40, 40))
                .addGroup(layout.createSequentialGroup().addGap(68).addComponent(lblInfo, 28, 28, 28))
                .addGroup(layout.createSequentialGroup().addGap(120).addComponent(scrollDetail, 290, 290, 290))
                .addGroup(layout.createSequentialGroup().addGap(432).addComponent(btnTambah, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(432).addComponent(btnTindak, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(488).addComponent(btnMulai, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(488).addComponent(btnSelesai, 42, 42, 42))
                .addGroup(layout.createSequentialGroup().addGap(488).addComponent(btnTutup, 42, 42, 42))
        );

    }//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt){
        DetailMonitoringFormFrame f=new DetailMonitoringFormFrame(monitoringId);f.setVisible(true);
        f.addWindowListener(new java.awt.event.WindowAdapter(){@Override public void windowClosed(java.awt.event.WindowEvent e){refreshData();}});
    }
    private void btnTindakActionPerformed(java.awt.event.ActionEvent evt){
        String s=JOptionPane.showInputDialog(this,"Tindak lanjut:");
        if(s!=null)try{AppConfig.getMonitoringController().aturTindakLanjut(monitoringId,s);refreshData();}catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void btnMulaiActionPerformed(java.awt.event.ActionEvent evt){try{AppConfig.getMonitoringController().mulaiPenanganan(monitoringId);refreshData();}catch(Exception ex){FormUtil.error(this,ex);}}
    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt){try{AppConfig.getMonitoringController().selesaikanPenanganan(monitoringId);refreshData();}catch(Exception ex){FormUtil.error(this,ex);}}
    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt){dispose();}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JScrollPane scrollDetail;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTindak;
    private javax.swing.JButton btnMulai;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnTutup;
    private javax.swing.JTable tblDetail;
    // End of variables declaration//GEN-END:variables
}
