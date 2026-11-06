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
    private MonitoringLingkungan data;

    private void refreshData(){
        data=AppConfig.getMonitoringController().cariMonitoringById(monitoringId);
        lblInfo.setText("Lokasi: "+data.getLokasi().getNamaLokasi()+"  |  Status Monitoring: "+data.getStatusMonitoring()
            +"  |  Status Penanganan: "+data.getStatusPenanganan());
        java.util.List<DetailMonitoring> details=data.getDetailMonitoring();
        DefaultTableModel model=new DefaultTableModel(new String[]{"Parameter","Nilai","Satuan","Hasil"},0){
            @Override public boolean isCellEditable(int r,int c){return false;}
        };
        for(DetailMonitoring d:details)model.addRow(new Object[]{d.getParameter().getNamaParameter(),d.getNilaiPengukuran(),d.getParameter().getSatuan(),d.getStatusDetail()});
        tblDetail.setModel(model);

        btnTambah.setEnabled(!readOnly && AppConfig.getAuthController().isPetugasHSE() && data.getStatusPenanganan()==StatusPenanganan.DALAM_PENANGANAN);
        btnUbah.setEnabled(!readOnly && AppConfig.getAuthController().isPetugasHSE() && !details.isEmpty() && data.getStatusPenanganan()==StatusPenanganan.DALAM_PENANGANAN);
        btnHapus.setEnabled(!readOnly && AppConfig.getAuthController().isPetugasHSE() && !details.isEmpty() && data.getStatusPenanganan()==StatusPenanganan.DALAM_PENANGANAN);
        btnSelesai.setEnabled(AppConfig.getAuthController().isPetugasHSE() && !details.isEmpty() && data.getStatusPenanganan()==StatusPenanganan.DALAM_PENANGANAN);

    }

    private DetailMonitoring detailTerpilih(){
        int row=tblDetail.getSelectedRow();
        if(row<0)throw new IllegalArgumentException("Pilih pengukuran pada tabel terlebih dahulu.");
        int modelRow=tblDetail.convertRowIndexToModel(row);
        return data.getDetailMonitoring().get(modelRow);
    }

    public MonitoringDetailFrame(int id,boolean readOnly){
        this();monitoringId=id;this.readOnly=readOnly;
        try{refreshData();}catch(Exception ex){FormUtil.error(this,ex);}
    }

    public MonitoringDetailFrame() {
        initComponents();

        JButton[] navButtons = {btnTambah, btnUbah, btnHapus, btnSelesai, btnTutup};

        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }

        pack();setResizable(false);setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        scrollDetail = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSelesai = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitle.setText("Detail Monitoring");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));

        lblInfo.setText("Pilih pengukuran dan tindak lanjut.");
        lblInfo.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(103, 121, 143));

        scrollDetail.setBackground(new java.awt.Color(255, 255, 255));

        tblDetail.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblDetail.setRowHeight(28);
        tblDetail.setGridColor(new java.awt.Color(226, 232, 240));

        btnTambah.setText("Tambah Pengukuran");
        btnTambah.setFocusPainted(false);
        btnTambah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setBackground(new java.awt.Color(43, 106, 230));
        btnTambah.addActionListener(this::btnTambahActionPerformed);

        btnUbah.setText("Ubah Pengukuran");
        btnUbah.setFocusPainted(false);
        btnUbah.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setBackground(new java.awt.Color(26, 43, 66));
        btnUbah.addActionListener(this::btnUbahActionPerformed);

        btnHapus.setText("Hapus Pengukuran");
        btnHapus.setFocusPainted(false);
        btnHapus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setBackground(new java.awt.Color(160, 45, 62));
        btnHapus.addActionListener(this::btnHapusActionPerformed);



        btnSelesai.setText("Selesai Penanganan");
        btnSelesai.setFocusPainted(false);
        btnSelesai.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnSelesai.setForeground(new java.awt.Color(255, 255, 255));
        btnSelesai.setBackground(new java.awt.Color(26, 43, 66));
        btnSelesai.addActionListener(this::btnSelesaiActionPerformed);

        btnTutup.setText("Tutup");
        btnTutup.setFocusPainted(false);
        btnTutup.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTutup.setForeground(new java.awt.Color(255, 255, 255));
        btnTutup.setBackground(new java.awt.Color(103, 121, 143));
        btnTutup.addActionListener(this::btnTutupActionPerformed);

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parameter", "Nilai", "Satuan", "Hasil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        scrollDetail.setViewportView(tblDetail);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(32, 32, 32)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblTitle, 656, 656, 656)
              )
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblInfo, 656, 656, 656)
              )
             )
                 .addGap(32, 32, 32)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(32, 32, 32)
                 .addComponent(scrollDetail, 656, 656, 656)
                 .addGap(32, 32, 32)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(32, 32, 32)
                 .addComponent(btnTambah, 210, 210, 210)
                 .addGap(8, 8, 8)
                 .addComponent(btnUbah, 210, 210, 210)
                 .addGap(8, 8, 8)
                 .addComponent(btnHapus, 210, 210, 210)
                 .addGap(32, 32, 32)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(32, 32, 32)
                 .addGap(8, 8, 8)
                 .addComponent(btnSelesai, 210, 210, 210)
                 .addGap(32, 32, 32)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(0, 0, Short.MAX_VALUE)
                 .addComponent(btnTutup, 120, 120, 120)
                 .addGap(32, 32, 32)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblTitle, 40, 40, 40)
                 .addGap(4, 4, 4)
                 .addComponent(lblInfo, 22, 22, 22)
                 .addGap(14, 14, 14)
                 .addComponent(scrollDetail, 240, 296, Short.MAX_VALUE)
                 .addGap(14, 14, 14)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(btnTambah, 42, 42, 42)
                  .addComponent(btnUbah, 42, 42, 42)
                  .addComponent(btnHapus, 42, 42, 42)
             )
                 .addGap(8, 8, 8)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(btnSelesai, 42, 42, 42)
             )
                 .addGap(12, 12, 12)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(btnTutup, 42, 42, 42)
             )
                 .addGap(24, 24, 24)
            )
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt){
        DetailMonitoringFormFrame f=new DetailMonitoringFormFrame(monitoringId);f.setVisible(true);
        f.addWindowListener(new java.awt.event.WindowAdapter(){@Override public void windowClosed(java.awt.event.WindowEvent e){refreshData();}});
    }

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt){
        try{
            DetailMonitoringFormFrame f=new DetailMonitoringFormFrame(detailTerpilih());f.setVisible(true);
            f.addWindowListener(new java.awt.event.WindowAdapter(){@Override public void windowClosed(java.awt.event.WindowEvent e){refreshData();}});
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt){
        try{
            DetailMonitoring d=detailTerpilih();
            if(JOptionPane.showConfirmDialog(this,"Hapus pengukuran "+d.getParameter().getNamaParameter()+"?","Konfirmasi",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;
            AppConfig.getMonitoringController().hapusDetail(d.getIdDetail());
            refreshData();
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt){
        try{
            if(JOptionPane.showConfirmDialog(this,"Selesaikan kegiatan ini? Hasil pengukuran tidak dapat diubah lagi.","Selesaikan Kegiatan",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)!=JOptionPane.YES_OPTION)return;
            AppConfig.getMonitoringController().selesaikanPenanganan(monitoringId);
            JOptionPane.showMessageDialog(this,"Kegiatan selesai. Hasil pengukuran sekarang hanya dapat dilihat.");
            refreshData();
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt){dispose();}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane scrollDetail;
    private javax.swing.JTable tblDetail;
    // End of variables declaration//GEN-END:variables
}
