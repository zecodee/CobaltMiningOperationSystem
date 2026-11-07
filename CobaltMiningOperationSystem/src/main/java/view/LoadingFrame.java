package view;

import config.AppConfig;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class LoadingFrame extends javax.swing.JFrame {

    public LoadingFrame() {
        initComponents();
        setLocationRelativeTo(null);
        muatFrameAnimasi();
        jalankanAnimasi();
        jalankanProgress();
        inisialisasiDatabase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        lblLogoAnim = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblTagline = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();
        lblPercent = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        pnlAccentTop = new javax.swing.JPanel();
        pnlAccentBottom = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C-MOS | Memuat");
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(920, 580));

        pnlBackground.setBackground(new java.awt.Color(23, 20, 18));

        lblLogoAnim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loading/load_00.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(214, 192, 179));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("C-MOS");

        lblTagline.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTagline.setForeground(new java.awt.Color(171, 136, 109));
        lblTagline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTagline.setText("C O B A L T   M I N I N G   O P E R A T I O N   S Y S T E M");

        progress.setBackground(new java.awt.Color(52, 40, 36));
        progress.setBorderPainted(false);

        lblPercent.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblPercent.setForeground(new java.awt.Color(214, 192, 179));
        lblPercent.setText("0 %");

        lblStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(228, 224, 225));
        lblStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatus.setText("Menyiapkan sistem operasional pertambangan ...");

        lblFooter.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblFooter.setForeground(new java.awt.Color(171, 136, 109));
        lblFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter.setText("PT. COBALT");

        org.jdesktop.layout.GroupLayout pnlBackgroundLayout = new org.jdesktop.layout.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlAccentTop, 0, 920, Short.MAX_VALUE)
            .add(pnlAccentBottom, 0, 920, Short.MAX_VALUE)
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(pnlBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlBackgroundLayout.createSequentialGroup()
                        .add(260, 260, 260)
                        .add(lblTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlBackgroundLayout.createSequentialGroup()
                        .add(110, 110, 110)
                        .add(lblTagline, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 700, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlBackgroundLayout.createSequentialGroup()
                        .add(230, 230, 230)
                        .add(progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(16, 16, 16)
                        .add(lblPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlBackgroundLayout.createSequentialGroup()
                        .add(110, 110, 110)
                        .add(lblStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 700, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlBackgroundLayout.createSequentialGroup()
                        .add(60, 60, 60)
                        .add(lblFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 800, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, Short.MAX_VALUE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(334, 334, 334)
                .add(lblLogoAnim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 274, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(40, 40, 40)
                .add(lblLogoAnim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 296, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(350, 350, 350)
                .add(lblTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(412, 412, 412)
                .add(lblTagline, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(458, 458, 458)
                .add(progress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(452, 452, 452)
                .add(lblPercent, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(484, 484, 484)
                .add(lblStatus, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(530, 530, 530)
                .add(lblFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlAccentTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(pnlBackgroundLayout.createSequentialGroup()
                .add(575, 575, 575)
                .add(pnlAccentBottom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlBackground, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlBackground, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents



private static final int JUMLAH_FRAME = 44;

    private final javax.swing.ImageIcon[] framesAnimasi = new javax.swing.ImageIcon[JUMLAH_FRAME];
    private int indeksFrame;
    private int nilaiProgress;
    private boolean dbBerhasil;
    private boolean dbGagal;
    private Exception dbError;
    private boolean sudahTransisi;
    private javax.swing.Timer timerAnimasi;
    private javax.swing.Timer timerProgress;

    /** Memuat seluruh frame animasi loading (logo berdenyut + cincin berputar). */
    private void muatFrameAnimasi() {
        for (int i = 0; i < JUMLAH_FRAME; i++) {
            String nama = String.format("/images/loading/load_%02d.png", i);
            framesAnimasi[i] = new javax.swing.ImageIcon(getClass().getResource(nama));
        }
    }

    /** Animasi logo: memutar 44 frame dengan tempo 40ms. */
    private void jalankanAnimasi() {
        timerAnimasi = new Timer(40, e -> {
            indeksFrame = (indeksFrame + 1) % JUMLAH_FRAME;
            lblLogoAnim.setIcon(framesAnimasi[indeksFrame]);
        });
        timerAnimasi.start();
    }

    /** Animasi progress bar menuju 100% dan status pemuatan yang berganti. */
    private void jalankanProgress() {
        progress.setValue(0);
        lblPercent.setText("0 %");
        timerProgress = new Timer(30, e -> {
            nilaiProgress = Math.min(100, nilaiProgress + 1);
            progress.setValue(nilaiProgress);
            lblPercent.setText(nilaiProgress + " %");
            if (nilaiProgress == 18) {
                lblStatus.setText("Memuat modul produksi dan pengangkutan ...");
            } else if (nilaiProgress == 42) {
                lblStatus.setText("Menghubungkan database cmos_db ...");
            } else if (nilaiProgress == 72) {
                lblStatus.setText("Menyiapkan layanan dashboard dan laporan ...");
            } else if (nilaiProgress == 92) {
                lblStatus.setText("Hampir siap ...");
            }
            if (nilaiProgress >= 100) {
                ((Timer) e.getSource()).stop();
                lanjutJikaSiap();
            }
        });
        timerProgress.start();
    }

    /** Inisialisasi layanan database di latar belakang agar animasi tetap lancar. */
    private void inisialisasiDatabase() {
        dbBerhasil = false;
        dbGagal = false;
        new SwingWorker<Void, Void>() {
            private Exception error;

            @Override
            protected Void doInBackground() {
                try {
                    AppConfig.initialize();
                } catch (Exception ex) {
                    error = ex;
                }
                return null;
            }

            @Override
            protected void done() {
                if (error == null) {
                    dbBerhasil = true;
                    lblStatus.setText("Koneksi database berhasil.");
                } else {
                    dbGagal = true;
                    dbError = error;
                    lblStatus.setText("Koneksi database belum berhasil ...");
                }
                lanjutJikaSiap();
            }
        }.execute();
    }

    /** Melanjutkan ke landing page ketika animasi selesai; menawarkan ulang bila database gagal. */
    private void lanjutJikaSiap() {
        if (sudahTransisi || nilaiProgress < 100) {
            return;
        }
        if (dbBerhasil) {
            bukaLanding();
            return;
        }
        if (dbGagal) {
            int pilihan = JOptionPane.showConfirmDialog(this,
                    "Tidak dapat terhubung ke database cmos_db.\n\n"
                    + "Detail: " + (dbError == null ? "-" : dbError.getMessage()) + "\n\n"
                    + "Coba hubungkan ulang sekarang?",
                    "Koneksi Database C-MOS", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilihan == JOptionPane.YES_OPTION) {
                nilaiProgress = 0;
                progress.setValue(0);
                lblPercent.setText("0 %");
                sudahTransisi = false;
                lblStatus.setText("Menghubungkan ulang ke database ...");
                jalankanProgress();
                inisialisasiDatabase();
            } else {
                bukaLanding();
            }
        }
    }

    private void bukaLanding() {
        sudahTransisi = true;
        if (timerAnimasi != null) {
            timerAnimasi.stop();
        }
        if (timerProgress != null) {
            timerProgress.stop();
        }
        new LandingFrame().setVisible(true);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblLogoAnim;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTagline;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAccentBottom;
    private javax.swing.JPanel pnlAccentTop;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
