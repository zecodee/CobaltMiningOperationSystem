package view;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        btnBatal.addActionListener(this::btnBatalActionPerformed);
        txtTanggal.setDate(new Date());
        txtTanggal.setDateFormatString("dd/MM/yyyy");
        txtTanggal.setMaxSelectableDate(new Date());
        
        JButton[] navButtons = {btnSimpan, btnBatal};

        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        try { loadOptions(); } catch(Exception ex) { FormUtil.error(this,ex); }

    }

    private LocalDate getTanggalMonitoring() {
        Date tanggal = txtTanggal.getDate();

        if (tanggal == null) {
            throw new IllegalArgumentException(
                "Silakan pilih tanggal monitoring."
            );
        }

        return tanggal.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        lblLokasi = new javax.swing.JLabel();
        cmbLokasi = new javax.swing.JComboBox();
        lblTanggal = new javax.swing.JLabel();
        txtTanggal = new com.toedter.calendar.JDateChooser();
        lblCatatan = new javax.swing.JLabel();
        txtCatatan = new javax.swing.JTextField();
        pnlCard = new javax.swing.JPanel();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitle.setText("Form Monitoring Lingkungan");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));

        lblHint.setText("Isi data sesuai ketentuan C-MOS.");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));

        lblLokasi.setText("Lokasi");
        lblLokasi.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblLokasi.setForeground(new java.awt.Color(26, 43, 66));

        cmbLokasi.setBackground(new java.awt.Color(255, 255, 255));

        lblTanggal.setText("Tanggal Monitoring");
        lblTanggal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(26, 43, 66));

        txtTanggal.setBackground(new java.awt.Color(255, 255, 255));

        lblCatatan.setText("Catatan");
        lblCatatan.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblCatatan.setForeground(new java.awt.Color(26, 43, 66));

        txtCatatan.setBackground(new java.awt.Color(255, 255, 255));

        pnlCard.setBackground(new java.awt.Color(255, 255, 255));

        btnSimpan.setText("Simpan");
        btnSimpan.setFocusPainted(false);
        btnSimpan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setBackground(new java.awt.Color(43, 106, 230));

        btnBatal.setText("Batal");
        btnBatal.setFocusPainted(false);
        btnBatal.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setBackground(new java.awt.Color(26, 43, 66));

        javax.swing.GroupLayout pnlCardLayout = new javax.swing.GroupLayout(pnlCard);
        pnlCard.setLayout(pnlCardLayout);
        pnlCardLayout.setHorizontalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblLokasi, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(cmbLokasi, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblTanggal, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtTanggal, 352, 352, 352)
             )
            )
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addComponent(lblCatatan, 230, 230, 230)
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(txtCatatan, 352, 352, 352)
             )
            )
        );
        pnlCardLayout.setVerticalGroup(
            pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCardLayout.createSequentialGroup()
                 .addGap(24, 24, 24)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblLokasi, 20, 20, 20)
                  .addComponent(cmbLokasi, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblTanggal, 20, 20, 20)
                  .addComponent(txtTanggal, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
                 .addGroup(pnlCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(lblCatatan, 20, 20, 20)
                  .addComponent(txtCatatan, 32, 32, 32)
             )
                 .addGap(14, 14, 14)
            )
        );


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(38, 38, 38)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblTitle, 644, 644, 644)
              )
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(lblHint, 644, 644, 644)
              )
                  .addGroup(layout.createSequentialGroup()
                   .addComponent(pnlCard, 644, 644, 644)
              )
             )
                 .addGap(38, 38, 38)
            )
                .addGroup(layout.createSequentialGroup()
                 .addGap(0, 0, Short.MAX_VALUE)
                 .addComponent(btnBatal, 120, 120, 120)
                 .addGap(10, 10, 10)
                 .addComponent(btnSimpan, 150, 150, 150)
                 .addGap(38, 38, 38)
            )
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                 .addGap(26, 26, 26)
                 .addComponent(lblTitle, 40, 40, 40)
                 .addGap(6, 6, 6)
                 .addComponent(lblHint, 22, 22, 22)
                 .addGap(18, 18, 18)
                 .addComponent(pnlCard, 172, 172, 172)
                 .addGap(22, 22, 22)
                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                  .addComponent(btnSimpan, 42, 42, 42)
                  .addComponent(btnBatal, 42, 42, 42)
             )
                 .addGap(26, 26, 26)
            )
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadOptions() {
        for (Lokasi v : AppConfig.getMasterDataController().tampilkanLokasiAktif()) { cmbLokasi.addItem(new PilihanData(v.getIdLokasi(), String.valueOf(v.getNamaLokasi()))); }
    }

    /** Prapilih lokasi; dipakai halaman Kondisi Lokasi HSE. */
    public void pilihLokasi(int idLokasi) {
        FormUtil.select(cmbLokasi, idLokasi);
    }
    
    public MonitoringFormFrame(MonitoringLingkungan original) {
        this();

        this.original = original;

        if (original != null) {
            setTitle("Ubah Monitoring #" + original.getIdMonitoring());
            lblTitle.setText("Form Monitoring Lingkungan (Ubah)");
            setTanggalMonitoring(original.getTanggalMonitoring());
            txtTanggal.setMaxSelectableDate(null);
            FormUtil.select(cmbLokasi, original.getLokasi().getIdLokasi());
            txtCatatan.setText(original.getCatatan() == null ? "" : original.getCatatan());
        }
    }

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int idLokasi = FormUtil.id(cmbLokasi);

            LocalDateTime tanggalMonitoring =
                    getTanggalMonitoring().atStartOfDay();

            String catatan = FormUtil.text(txtCatatan);

            if (original == null) {
                AppConfig.getMonitoringController().buatMonitoring(
                        idLokasi,
                        tanggalMonitoring,
                        catatan
                );
                JOptionPane.showMessageDialog(this, "Monitoring dimulai. Silakan isi hasil pengukurannya.");
            } else {
                AppConfig.getMonitoringController().ubahMonitoring(
                        original.getIdMonitoring(),
                        idLokasi,
                        tanggalMonitoring,
                        catatan
                );
                JOptionPane.showMessageDialog(this, "Data monitoring berhasil diperbarui.");
            }

            saved = true;
            dispose();

        } catch (Exception ex) {
            FormUtil.error(this, ex);
        }
    }
    
    private void setTanggalMonitoring(LocalDateTime tanggal) {
        if (tanggal == null) {
            txtTanggal.setDate(null);
            return;
        }

        Date date = Date.from(
            tanggal.atZone(ZoneId.systemDefault()).toInstant()
        );

        txtTanggal.setDate(date);
    }
    
    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) { dispose(); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox cmbLokasi;
    private javax.swing.JLabel lblCatatan;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblLokasi;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlCard;
    private javax.swing.JTextField txtCatatan;
    private com.toedter.calendar.JDateChooser txtTanggal;
    // End of variables declaration//GEN-END:variables
}
