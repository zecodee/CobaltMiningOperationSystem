package view;

import java.util.*;
import javax.swing.*;

/** Kartu katalog lokasi (template GUI Builder) untuk halaman Kondisi Lokasi. */
public class KartuLokasiPanel extends javax.swing.JPanel {

    public KartuLokasiPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlStripe = new javax.swing.JPanel();
        lblNama = new javax.swing.JLabel();
        lblJenis = new javax.swing.JLabel();
        lblStatusOps = new javax.swing.JLabel();
        lblMonitoring = new javax.swing.JLabel();
        lblHasil = new javax.swing.JLabel();
        lblPenanganan = new javax.swing.JLabel();
        lblBadge = new javax.swing.JLabel();

        setBackground(new java.awt.Color(234, 216, 192));

        pnlStripe.setLayout(new java.awt.BorderLayout());

        lblNama.setText("Nama Lokasi");

        lblJenis.setBackground(new java.awt.Color(73, 54, 40));
        lblJenis.setForeground(new java.awt.Color(255, 255, 255));
        lblJenis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJenis.setText("PIT");
        lblJenis.setOpaque(true);

        lblStatusOps.setText("AKTIF");

        lblMonitoring.setText("Monitoring terakhir: belum ada");

        lblHasil.setText("Hasil: belum ada data");

        lblPenanganan.setText("Penanganan: -");

        lblBadge.setBackground(new java.awt.Color(255, 51, 51));
        lblBadge.setForeground(new java.awt.Color(255, 255, 255));
        lblBadge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBadge.setText("PERLU TINDAK LANJUT");
        lblBadge.setOpaque(true);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(pnlStripe, 10, 10, 10)
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblNama, 10, 300, Short.MAX_VALUE)
                        .add(0, 0, Short.MAX_VALUE)
                        .add(lblBadge, 10, 170, 170))
                    .add(layout.createSequentialGroup()
                        .add(lblJenis, 90, 90, 90)
                        .add(8, 8, 8)
                        .add(lblStatusOps, 10, 150, Short.MAX_VALUE))
                    .add(lblMonitoring, 10, 470, Short.MAX_VALUE)
                    .add(lblHasil, 10, 470, Short.MAX_VALUE)
                    .add(lblPenanganan, 10, 470, Short.MAX_VALUE))
                .add(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStripe, 108, 108, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblNama, 20, 20, 20)
                            .add(lblBadge, 18, 18, 18))
                        .add(4, 4, 4)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(lblJenis, 18, 18, 18)
                            .add(lblStatusOps, 18, 18, 18))
                        .add(5, 5, 5)
                        .add(lblMonitoring, 17, 17, 17)
                        .add(3, 3, 3)
                        .add(lblHasil, 18, 18, 18)
                        .add(3, 3, 3)
                        .add(lblPenanganan, 15, 15, 15)))
                .add(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setData(model.Lokasi lokasi, model.MonitoringLingkungan terakhir) {

        lblNama.setText(lokasi.getNamaLokasi());

        boolean pit = lokasi.getJenisLokasi() == enums.JenisLokasi.PIT;

        lblJenis.setText(pit ? "PIT" : "STOCKPILE");

        lblJenis.setBackground(pit ? new java.awt.Color(43, 106, 230) : new java.awt.Color(31, 122, 140));

        lblStatusOps.setText(String.valueOf(lokasi.getStatusOperasional()));

        if (terakhir == null) {

            lblMonitoring.setText("Monitoring terakhir: belum ada");

            lblHasil.setText("Hasil: belum ada data");

            lblHasil.setForeground(new java.awt.Color(103, 121, 143));

            lblPenanganan.setText("Penanganan: -");

            pnlStripe.setBackground(new java.awt.Color(148, 163, 184));

            lblBadge.setVisible(false);

        } else {

            java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            lblMonitoring.setText("Monitoring terakhir: "

                + (terakhir.getTanggalMonitoring() == null ? "-" : terakhir.getTanggalMonitoring().format(fmt)));

            boolean berbahaya = terakhir.getStatusMonitoring() == enums.StatusMonitoring.BERBAHAYA;
            boolean peringatan = terakhir.getStatusMonitoring() == enums.StatusMonitoring.PERINGATAN;

            lblHasil.setText("Hasil: " + terakhir.getStatusMonitoring());

            lblHasil.setForeground(terakhir.getStatusMonitoring()==enums.StatusMonitoring.BERBAHAYA
                ? new java.awt.Color(160,45,62) : terakhir.getStatusMonitoring()==enums.StatusMonitoring.PERINGATAN
                ? new java.awt.Color(183,121,31) : new java.awt.Color(46,125,70));

            lblPenanganan.setText("Penanganan: " + terakhir.getStatusPenanganan());

            // Tingkat risiko menentukan warna, bukan status penyelesaian penanganan.
            pnlStripe.setBackground(berbahaya ? new java.awt.Color(160, 45, 62)
                : peringatan ? new java.awt.Color(183, 121, 31)
                : new java.awt.Color(46, 125, 70));

            // Tanda prioritas ditampilkan pada hasil BERBAHAYA.
            lblBadge.setVisible(berbahaya);

        }

        revalidate();

        repaint();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblBadge;
    private javax.swing.JLabel lblHasil;
    private javax.swing.JLabel lblJenis;
    private javax.swing.JLabel lblMonitoring;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblPenanganan;
    private javax.swing.JLabel lblStatusOps;
    private javax.swing.JPanel pnlStripe;
    // End of variables declaration//GEN-END:variables
}
