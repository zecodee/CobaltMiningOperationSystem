package view;

import config.AppConfig;
import javax.swing.JOptionPane;

/** Landing page C-MOS: profil PT. Cobalt, modul operasional, tim pengembang, dan menu login.
 * Seluruh tampilan dibuat dengan GUI Builder (LandingFrame.form): tiap bagian halaman
 * (hero, tentang, operasional, C-MOS, tim, footer) berada di dalam pnlPage.
 * Navbar pnlTopBar berada di luar area scroll agar tetap terlihat.
 * Kode di luar blok Generated Code hanya mengatur perilaku (klik, gulir halus, login). */

public class LandingFrame extends javax.swing.JFrame {

    public LandingFrame() {
        initComponents();
        // Tinggi 3508 pada GUI Builder hanya untuk memudahkan mengedit seluruh section.
        // Ketika dijalankan, jendela tetap 1280x800 dan isi halaman dapat digulir.
        setSize(1280, 800);
        setLocationRelativeTo(null);

        // Gulir roda mouse lebih cepat (perilaku interaksi, bukan desain).
        scrollMain.getVerticalScrollBar().setUnitIncrement(24);

        // Kursor tangan pada tombol dan navigasi (perilaku interaksi, bukan desain).
        javax.swing.JComponent[] interaktif = {btnLoginTop, btnHeroLogin, btnPelajari,
            lblNavTentang, lblNavOperasi, lblNavTim};
        for (javax.swing.JComponent komponen : interaktif) {
            komponen.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMain = new javax.swing.JScrollPane();
        pnlPage = new javax.swing.JPanel();
        pnlHero = new javax.swing.JPanel();
        lblHeroKicker = new javax.swing.JLabel();
        lblHeroTitle = new javax.swing.JLabel();
        lblHeroSub = new javax.swing.JLabel();
        btnHeroLogin = new javax.swing.JButton();
        btnPelajari = new javax.swing.JButton();
        imgHero = new javax.swing.JLabel();
        pnlTentang = new javax.swing.JPanel();
        lblTentangKicker = new javax.swing.JLabel();
        lblTentangTitle = new javax.swing.JLabel();
        lblTentangLead = new javax.swing.JLabel();
        lblTentangP1 = new javax.swing.JLabel();
        lblTentangP2 = new javax.swing.JLabel();
        lblTentangP3 = new javax.swing.JLabel();
        imgTentang = new javax.swing.JLabel();
        lblTentangCaption = new javax.swing.JLabel();
        pnlStat0 = new javax.swing.JPanel();
        pnlStatAccent0 = new javax.swing.JPanel();
        lblStatValue0 = new javax.swing.JLabel();
        lblStatTitle0 = new javax.swing.JLabel();
        lblStatSub0 = new javax.swing.JLabel();
        pnlStat1 = new javax.swing.JPanel();
        pnlStatAccent1 = new javax.swing.JPanel();
        lblStatValue1 = new javax.swing.JLabel();
        lblStatTitle1 = new javax.swing.JLabel();
        lblStatSub1 = new javax.swing.JLabel();
        pnlStat2 = new javax.swing.JPanel();
        pnlStatAccent2 = new javax.swing.JPanel();
        lblStatValue2 = new javax.swing.JLabel();
        lblStatTitle2 = new javax.swing.JLabel();
        lblStatSub2 = new javax.swing.JLabel();
        pnlStat3 = new javax.swing.JPanel();
        pnlStatAccent3 = new javax.swing.JPanel();
        lblStatValue3 = new javax.swing.JLabel();
        lblStatTitle3 = new javax.swing.JLabel();
        lblStatSub3 = new javax.swing.JLabel();
        pnlTim = new javax.swing.JPanel();
        lblTimKicker = new javax.swing.JLabel();
        lblTimTitle = new javax.swing.JLabel();
        lblTimSub = new javax.swing.JLabel();
        pnlTim0 = new javax.swing.JPanel();
        pnlTimAccent0 = new javax.swing.JPanel();
        imgTim0 = new javax.swing.JLabel();
        lblTimNama0 = new javax.swing.JLabel();
        lblTimNim0 = new javax.swing.JLabel();
        pnlTim1 = new javax.swing.JPanel();
        pnlTimAccent1 = new javax.swing.JPanel();
        imgTim1 = new javax.swing.JLabel();
        lblTimNama1 = new javax.swing.JLabel();
        lblTimNim1 = new javax.swing.JLabel();
        pnlTim2 = new javax.swing.JPanel();
        pnlTimAccent2 = new javax.swing.JPanel();
        imgTim2 = new javax.swing.JLabel();
        lblTimNama2 = new javax.swing.JLabel();
        lblTimNim2 = new javax.swing.JLabel();
        pnlTim3 = new javax.swing.JPanel();
        pnlTimAccent3 = new javax.swing.JPanel();
        imgTim3 = new javax.swing.JLabel();
        lblTimNama3 = new javax.swing.JLabel();
        lblTimNim3 = new javax.swing.JLabel();
        pnlFooter = new javax.swing.JPanel();
        imgFooterLogo = new javax.swing.JLabel();
        lblFooter1 = new javax.swing.JLabel();
        lblFooter2 = new javax.swing.JLabel();
        lblFooter3 = new javax.swing.JLabel();
        pnlTopBar = new javax.swing.JPanel();
        lblLogoSm = new javax.swing.JLabel();
        lblBrandTop = new javax.swing.JLabel();
        lblBrandTopSub = new javax.swing.JLabel();
        lblNavTentang = new javax.swing.JLabel();
        lblNavOperasi = new javax.swing.JLabel();
        lblNavTim = new javax.swing.JLabel();
        btnLoginTop = new javax.swing.JButton();
        pnlTopAccent = new javax.swing.JPanel();
        pnlCmos = new javax.swing.JPanel();
        lblCmosKicker = new javax.swing.JLabel();
        lblCmosTitle = new javax.swing.JLabel();
        lblCmosDesc = new javax.swing.JLabel();
        imgCmosLogo = new javax.swing.JLabel();
        pnlFeat0 = new javax.swing.JPanel();
        lblFeat0 = new javax.swing.JLabel();
        pnlFeat1 = new javax.swing.JPanel();
        lblFeat1 = new javax.swing.JLabel();
        pnlFeat2 = new javax.swing.JPanel();
        lblFeat2 = new javax.swing.JLabel();
        pnlFeat3 = new javax.swing.JPanel();
        lblFeat3 = new javax.swing.JLabel();
        pnlOps = new javax.swing.JPanel();
        lblOpsKicker = new javax.swing.JLabel();
        lblOpsTitle = new javax.swing.JLabel();
        lblOpsSub = new javax.swing.JLabel();
        pnlOpsCard0 = new javax.swing.JPanel();
        pnlOpsAccent0 = new javax.swing.JPanel();
        imgOps0 = new javax.swing.JLabel();
        lblOpsCardTitle0 = new javax.swing.JLabel();
        lblOpsCardDesc0 = new javax.swing.JLabel();
        lblOpsCardTag0 = new javax.swing.JLabel();
        pnlOpsCard1 = new javax.swing.JPanel();
        pnlOpsAccent1 = new javax.swing.JPanel();
        imgOps1 = new javax.swing.JLabel();
        lblOpsCardTitle1 = new javax.swing.JLabel();
        lblOpsCardDesc1 = new javax.swing.JLabel();
        lblOpsCardTag1 = new javax.swing.JLabel();
        pnlOpsCard2 = new javax.swing.JPanel();
        pnlOpsAccent2 = new javax.swing.JPanel();
        imgOps2 = new javax.swing.JLabel();
        lblOpsCardTitle2 = new javax.swing.JLabel();
        lblOpsCardDesc2 = new javax.swing.JLabel();
        lblOpsCardTag2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C-MOS | PT. Cobalt");
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 3508));

        scrollMain.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlPage.setBackground(new java.awt.Color(243, 238, 231));

        pnlHero.setBackground(new java.awt.Color(17, 14, 12));

        lblHeroKicker.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHeroKicker.setForeground(new java.awt.Color(171, 136, 109));
        lblHeroKicker.setText("◆  SISTEM INFORMASI MANAJEMEN OPERASIONAL PERTAMBANGAN");

        lblHeroTitle.setFont(new java.awt.Font("SansSerif", 1, 38)); // NOI18N
        lblHeroTitle.setForeground(new java.awt.Color(250, 247, 243));
        lblHeroTitle.setText("<html>COBALT MINING<br>OPERATION SYSTEM</html>");

        lblHeroSub.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblHeroSub.setForeground(new java.awt.Color(214, 192, 179));
        lblHeroSub.setText("<html>Aplikasi desktop terintegrasi untuk mengelola <b>produksi tambang</b>, <b>pengangkutan material</b>, armada <b>kendaraan &amp; driver</b>, serta <b>monitoring lingkungan</b> PT. Cobalt</html>");

        btnHeroLogin.setBackground(new java.awt.Color(171, 136, 109));
        btnHeroLogin.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnHeroLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnHeroLogin.setText("MASUK KE SISTEM »");
        btnHeroLogin.setBorderPainted(false);
        btnHeroLogin.setFocusPainted(false);
        btnHeroLogin.addActionListener(this::btnHeroLoginActionPerformed);

        btnPelajari.setBackground(new java.awt.Color(63, 50, 40));
        btnPelajari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnPelajari.setForeground(new java.awt.Color(214, 192, 179));
        btnPelajari.setText("PELAJARI LEBIH LANJUT");
        btnPelajari.setBorderPainted(false);
        btnPelajari.setFocusPainted(false);
        btnPelajari.addActionListener(this::btnPelajariActionPerformed);

        imgHero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/hero_tambang_display.png"))); // NOI18N

        org.jdesktop.layout.GroupLayout pnlHeroLayout = new org.jdesktop.layout.GroupLayout(pnlHero);
        pnlHero.setLayout(pnlHeroLayout);
        pnlHeroLayout.setHorizontalGroup(
            pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeroLayout.createSequentialGroup()
                .add(pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblHeroKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(btnHeroLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 220, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(306, 306, 306)
                        .add(btnPelajari, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnlHeroLayout.createSequentialGroup()
                                .add(lblHeroSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(42, 42, 42)
                                .add(imgHero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 530, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(lblHeroTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 580, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        pnlHeroLayout.setVerticalGroup(
            pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeroLayout.createSequentialGroup()
                .add(pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(90, 90, 90)
                        .add(imgHero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 302, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlHeroLayout.createSequentialGroup()
                        .add(pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnlHeroLayout.createSequentialGroup()
                                .add(118, 118, 118)
                                .add(lblHeroKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(pnlHeroLayout.createSequentialGroup()
                                .add(146, 146, 146)
                                .add(lblHeroTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lblHeroSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(32, 32, 32)
                        .add(pnlHeroLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(btnHeroLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnPelajari, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnlTentang.setBackground(new java.awt.Color(243, 238, 231));

        lblTentangKicker.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblTentangKicker.setForeground(new java.awt.Color(171, 136, 109));
        lblTentangKicker.setText("◆  TENTANG PERUSAHAAN");

        lblTentangTitle.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        lblTentangTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTentangTitle.setText("PT. COBALT");

        lblTentangLead.setFont(new java.awt.Font("SansSerif", 2, 13)); // NOI18N
        lblTentangLead.setForeground(new java.awt.Color(71, 86, 105));
        lblTentangLead.setText("<html>Perusahaan pertambangan kobalt dengan pengelolaan operasional yang terpusat dan berkelanjutan.</html>");

        lblTentangP1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTentangP1.setForeground(new java.awt.Color(71, 86, 105));
        lblTentangP1.setText("<html>PT. Cobalt merupakan perusahaan pertambangan yang mengelola kegiatan <b>produksi tambang</b>, <b>pengangkutan hasil tambang</b>, penggunaan kendaraan operasional dan driver, hingga <b>pemantauan kondisi lingkungan</b>. Seluruh kegiatan berjalan pada lokasi PIT (area penambangan) dan STOCKPILE (penampungan material) yang tersebar di berbagai titik operasional.</html>");

        lblTentangP2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTentangP2.setForeground(new java.awt.Color(71, 86, 105));
        lblTentangP2.setText("<html>Setiap hari, tim operasional mencatat hasil produksi material seperti <i>Cobalt Ore</i> dan <i>Overburden</i>, merencanakan pengangkutan menggunakan armada dump truck, serta memantau parameter lingkungan secara terperinci sesuai dengan standar kesehatan. Data yang saling berkaitan tersebut dikelola secara terstruktur agar operasional berjalan aman, efektif, dan berkelanjutan.</html>");

        lblTentangP3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTentangP3.setForeground(new java.awt.Color(71, 86, 105));
        lblTentangP3.setText("<html>Melalui digitalisasi proses operasional, PT. Cobalt mendukung prinsip pertambangan yang bertanggung jawab penuh yang sejalan dengan <b>SDG 8.</b> (Pekerjaan Layak dan Pertumbuhan Ekonomi), <b>SDG 12.</b> (Konsumsi dan Produksi yang Bertanggung Jawab), serta <b>SDG 13.</b> (Penanganan Perubahan Iklim).</html>");

        imgTentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/tentang_display.png"))); // NOI18N

        lblTentangCaption.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblTentangCaption.setForeground(new java.awt.Color(148, 133, 124));
        lblTentangCaption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTentangCaption.setText("Tim operasional memverifikasi rencana kerja di area tambang");

        pnlStat0.setBackground(new java.awt.Color(234, 216, 192));

        pnlStatAccent0.setBackground(new java.awt.Color(171, 136, 109));

        lblStatValue0.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblStatValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblStatValue0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatValue0.setText("15");

        lblStatTitle0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblStatTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblStatTitle0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatTitle0.setText("LOKASI TAMBANG");

        lblStatSub0.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblStatSub0.setForeground(new java.awt.Color(103, 121, 143));
        lblStatSub0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatSub0.setText("PIT dan Stockpile");

        org.jdesktop.layout.GroupLayout pnlStat0Layout = new org.jdesktop.layout.GroupLayout(pnlStat0);
        pnlStat0.setLayout(pnlStat0Layout);
        pnlStat0Layout.setHorizontalGroup(
            pnlStat0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStatAccent0, 268, 268, 268)
            .add(lblStatValue0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatTitle0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatSub0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlStat0Layout.setVerticalGroup(
            pnlStat0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStat0Layout.createSequentialGroup()
                .add(pnlStat0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStatAccent0, 5, 5, 5)
                    .add(pnlStat0Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(lblStatValue0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat0Layout.createSequentialGroup()
                        .add(64, 64, 64)
                        .add(lblStatTitle0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat0Layout.createSequentialGroup()
                        .add(84, 84, 84)
                        .add(lblStatSub0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlStat1.setBackground(new java.awt.Color(234, 216, 192));

        pnlStatAccent1.setBackground(new java.awt.Color(171, 136, 109));

        lblStatValue1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblStatValue1.setForeground(new java.awt.Color(26, 43, 66));
        lblStatValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatValue1.setText("3");

        lblStatTitle1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblStatTitle1.setForeground(new java.awt.Color(103, 121, 143));
        lblStatTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatTitle1.setText("FOKUS PROSES UTAMA");

        lblStatSub1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblStatSub1.setForeground(new java.awt.Color(103, 121, 143));
        lblStatSub1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatSub1.setText("Produksi · Pengangkutan · Monitoring");

        org.jdesktop.layout.GroupLayout pnlStat1Layout = new org.jdesktop.layout.GroupLayout(pnlStat1);
        pnlStat1.setLayout(pnlStat1Layout);
        pnlStat1Layout.setHorizontalGroup(
            pnlStat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStatAccent1, 268, 268, 268)
            .add(lblStatValue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatTitle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatSub1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlStat1Layout.setVerticalGroup(
            pnlStat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStat1Layout.createSequentialGroup()
                .add(pnlStat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStatAccent1, 5, 5, 5)
                    .add(pnlStat1Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(lblStatValue1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat1Layout.createSequentialGroup()
                        .add(64, 64, 64)
                        .add(lblStatTitle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat1Layout.createSequentialGroup()
                        .add(84, 84, 84)
                        .add(lblStatSub1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlStat2.setBackground(new java.awt.Color(234, 216, 192));

        pnlStatAccent2.setBackground(new java.awt.Color(171, 136, 109));

        lblStatValue2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblStatValue2.setForeground(new java.awt.Color(26, 43, 66));
        lblStatValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatValue2.setText("4");

        lblStatTitle2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblStatTitle2.setForeground(new java.awt.Color(103, 121, 143));
        lblStatTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatTitle2.setText("PERAN PENGGUNA");

        lblStatSub2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblStatSub2.setForeground(new java.awt.Color(103, 121, 143));
        lblStatSub2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatSub2.setText("Admin · Operasional · HSE · Manager");

        org.jdesktop.layout.GroupLayout pnlStat2Layout = new org.jdesktop.layout.GroupLayout(pnlStat2);
        pnlStat2.setLayout(pnlStat2Layout);
        pnlStat2Layout.setHorizontalGroup(
            pnlStat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStatAccent2, 268, 268, 268)
            .add(lblStatValue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatTitle2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblStatSub2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlStat2Layout.setVerticalGroup(
            pnlStat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStat2Layout.createSequentialGroup()
                .add(pnlStat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStatAccent2, 5, 5, 5)
                    .add(pnlStat2Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(lblStatValue2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat2Layout.createSequentialGroup()
                        .add(64, 64, 64)
                        .add(lblStatTitle2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat2Layout.createSequentialGroup()
                        .add(84, 84, 84)
                        .add(lblStatSub2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlStat3.setBackground(new java.awt.Color(234, 216, 192));

        pnlStatAccent3.setBackground(new java.awt.Color(171, 136, 109));

        lblStatValue3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblStatValue3.setForeground(new java.awt.Color(26, 43, 66));
        lblStatValue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatValue3.setText("SDG");

        lblStatTitle3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblStatTitle3.setForeground(new java.awt.Color(103, 121, 143));
        lblStatTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatTitle3.setText("8 · 12 · 13");

        lblStatSub3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblStatSub3.setForeground(new java.awt.Color(103, 121, 143));
        lblStatSub3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatSub3.setText("Pertambangan berkelanjutan");

        org.jdesktop.layout.GroupLayout pnlStat3Layout = new org.jdesktop.layout.GroupLayout(pnlStat3);
        pnlStat3.setLayout(pnlStat3Layout);
        pnlStat3Layout.setHorizontalGroup(
            pnlStat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStat3Layout.createSequentialGroup()
                .add(pnlStat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStatAccent3, 268, 268, 268)
                    .add(lblStatValue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblStatTitle3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblStatSub3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 268, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStat3Layout.setVerticalGroup(
            pnlStat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlStat3Layout.createSequentialGroup()
                .add(pnlStat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlStatAccent3, 5, 5, 5)
                    .add(pnlStat3Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(lblStatValue3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat3Layout.createSequentialGroup()
                        .add(64, 64, 64)
                        .add(lblStatTitle3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlStat3Layout.createSequentialGroup()
                        .add(84, 84, 84)
                        .add(lblStatSub3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlTentangLayout = new org.jdesktop.layout.GroupLayout(pnlTentang);
        pnlTentang.setLayout(pnlTentangLayout);
        pnlTentangLayout.setHorizontalGroup(
            pnlTentangLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTentangLayout.createSequentialGroup()
                .add(pnlTentangLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 580, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangLead, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangP1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangP2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblTentangP3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(672, 672, 672)
                        .add(imgTentang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 530, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(672, 672, 672)
                        .add(lblTentangCaption, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 530, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(pnlStat0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(358, 358, 358)
                        .add(pnlStat1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(646, 646, 646)
                        .add(pnlStat2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTentangLayout.createSequentialGroup()
                        .add(934, 934, 934)
                        .add(pnlStat3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTentangLayout.setVerticalGroup(
            pnlTentangLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTentangLayout.createSequentialGroup()
                .add(pnlTentangLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(pnlStat0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlStat1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlStat2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlTentangLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(60, 60, 60)
                            .add(lblTentangKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(88, 88, 88)
                            .add(lblTentangTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(134, 134, 134)
                            .add(lblTentangLead, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(180, 180, 180)
                            .add(lblTentangP1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(302, 302, 302)
                            .add(lblTentangP2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(424, 424, 424)
                            .add(lblTentangP3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(60, 60, 60)
                            .add(imgTentang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 398, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(464, 464, 464)
                            .add(lblTentangCaption, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTentangLayout.createSequentialGroup()
                            .add(540, 540, 540)
                            .add(pnlStat3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pnlTim.setBackground(new java.awt.Color(243, 238, 231));

        lblTimKicker.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblTimKicker.setForeground(new java.awt.Color(171, 136, 109));
        lblTimKicker.setText("◆  TIM PENGEMBANG");

        lblTimTitle.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        lblTimTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTimTitle.setText("Kelompok 13 COBALT");

        lblTimSub.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTimSub.setForeground(new java.awt.Color(103, 121, 143));
        lblTimSub.setText("Mahasiswa Program Studi Sistem Informasi, Fakultas Teknik, Universitas Mulawarman.");

        pnlTim0.setBackground(new java.awt.Color(255, 255, 255));

        pnlTimAccent0.setBackground(new java.awt.Color(171, 136, 109));

        imgTim0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/tim_ahmad_card.png"))); // NOI18N

        lblTimNama0.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTimNama0.setForeground(new java.awt.Color(26, 43, 66));
        lblTimNama0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNama0.setText("Ahmad Ribbiy Aldi");

        lblTimNim0.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTimNim0.setForeground(new java.awt.Color(103, 121, 143));
        lblTimNim0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNim0.setText("2509116100");

        org.jdesktop.layout.GroupLayout pnlTim0Layout = new org.jdesktop.layout.GroupLayout(pnlTim0);
        pnlTim0.setLayout(pnlTim0Layout);
        pnlTim0Layout.setHorizontalGroup(
            pnlTim0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimAccent0, 264, 264, 264)
            .add(pnlTim0Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(imgTim0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(lblTimNama0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblTimNim0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlTim0Layout.setVerticalGroup(
            pnlTim0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTim0Layout.createSequentialGroup()
                .add(pnlTim0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTimAccent0, 5, 5, 5)
                    .add(pnlTim0Layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(imgTim0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim0Layout.createSequentialGroup()
                        .add(332, 332, 332)
                        .add(lblTimNama0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim0Layout.createSequentialGroup()
                        .add(358, 358, 358)
                        .add(lblTimNim0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlTim1.setBackground(new java.awt.Color(255, 255, 255));

        pnlTimAccent1.setBackground(new java.awt.Color(171, 136, 109));

        imgTim1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/tim_eko_card.png"))); // NOI18N

        lblTimNama1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTimNama1.setForeground(new java.awt.Color(26, 43, 66));
        lblTimNama1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNama1.setText("Eko Satrio Wibowo");

        lblTimNim1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTimNim1.setForeground(new java.awt.Color(103, 121, 143));
        lblTimNim1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNim1.setText("2509116028");

        org.jdesktop.layout.GroupLayout pnlTim1Layout = new org.jdesktop.layout.GroupLayout(pnlTim1);
        pnlTim1.setLayout(pnlTim1Layout);
        pnlTim1Layout.setHorizontalGroup(
            pnlTim1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimAccent1, 264, 264, 264)
            .add(pnlTim1Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(imgTim1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(lblTimNama1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblTimNim1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlTim1Layout.setVerticalGroup(
            pnlTim1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTim1Layout.createSequentialGroup()
                .add(pnlTim1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTimAccent1, 5, 5, 5)
                    .add(pnlTim1Layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(imgTim1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim1Layout.createSequentialGroup()
                        .add(332, 332, 332)
                        .add(lblTimNama1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim1Layout.createSequentialGroup()
                        .add(358, 358, 358)
                        .add(lblTimNim1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlTim2.setBackground(new java.awt.Color(255, 255, 255));

        pnlTimAccent2.setBackground(new java.awt.Color(171, 136, 109));

        imgTim2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/tim_rasya_card.png"))); // NOI18N

        lblTimNama2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTimNama2.setForeground(new java.awt.Color(26, 43, 66));
        lblTimNama2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNama2.setText("Rasya Aditya Ramadani");

        lblTimNim2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTimNim2.setForeground(new java.awt.Color(103, 121, 143));
        lblTimNim2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNim2.setText("2509116082");

        org.jdesktop.layout.GroupLayout pnlTim2Layout = new org.jdesktop.layout.GroupLayout(pnlTim2);
        pnlTim2.setLayout(pnlTim2Layout);
        pnlTim2Layout.setHorizontalGroup(
            pnlTim2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimAccent2, 264, 264, 264)
            .add(pnlTim2Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(imgTim2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(lblTimNama2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblTimNim2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlTim2Layout.setVerticalGroup(
            pnlTim2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTim2Layout.createSequentialGroup()
                .add(pnlTim2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTimAccent2, 5, 5, 5)
                    .add(pnlTim2Layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(imgTim2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim2Layout.createSequentialGroup()
                        .add(332, 332, 332)
                        .add(lblTimNama2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim2Layout.createSequentialGroup()
                        .add(358, 358, 358)
                        .add(lblTimNim2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pnlTim3.setBackground(new java.awt.Color(255, 255, 255));

        pnlTimAccent3.setBackground(new java.awt.Color(171, 136, 109));

        imgTim3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/tim_zefri_card.png"))); // NOI18N

        lblTimNama3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblTimNama3.setForeground(new java.awt.Color(26, 43, 66));
        lblTimNama3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNama3.setText("Zefri Al Rizqullah");

        lblTimNim3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTimNim3.setForeground(new java.awt.Color(103, 121, 143));
        lblTimNim3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTimNim3.setText("2509116084");

        org.jdesktop.layout.GroupLayout pnlTim3Layout = new org.jdesktop.layout.GroupLayout(pnlTim3);
        pnlTim3.setLayout(pnlTim3Layout);
        pnlTim3Layout.setHorizontalGroup(
            pnlTim3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimAccent3, 264, 264, 264)
            .add(pnlTim3Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(imgTim3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(lblTimNama3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(lblTimNim3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pnlTim3Layout.setVerticalGroup(
            pnlTim3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTim3Layout.createSequentialGroup()
                .add(pnlTim3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTimAccent3, 5, 5, 5)
                    .add(pnlTim3Layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(imgTim3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim3Layout.createSequentialGroup()
                        .add(332, 332, 332)
                        .add(lblTimNama3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlTim3Layout.createSequentialGroup()
                        .add(358, 358, 358)
                        .add(lblTimNim3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlTimLayout = new org.jdesktop.layout.GroupLayout(pnlTim);
        pnlTim.setLayout(pnlTimLayout);
        pnlTimLayout.setHorizontalGroup(
            pnlTimLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimLayout.createSequentialGroup()
                .add(70, 70, 70)
                .add(lblTimKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(70, 70, 70)
                .add(lblTimTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 700, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(70, 70, 70)
                .add(lblTimSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(70, 70, 70)
                .add(pnlTim0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(362, 362, 362)
                .add(pnlTim1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(654, 654, 654)
                .add(pnlTim2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTimLayout.createSequentialGroup()
                .add(946, 946, 946)
                .add(pnlTim3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnlTimLayout.setVerticalGroup(
            pnlTimLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTimLayout.createSequentialGroup()
                .add(pnlTimLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(pnlTim0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlTim1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlTim2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlTimLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(pnlTimLayout.createSequentialGroup()
                            .add(64, 64, 64)
                            .add(lblTimKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTimLayout.createSequentialGroup()
                            .add(92, 92, 92)
                            .add(lblTimTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTimLayout.createSequentialGroup()
                            .add(138, 138, 138)
                            .add(lblTimSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(pnlTimLayout.createSequentialGroup()
                            .add(200, 200, 200)
                            .add(pnlTim3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pnlFooter.setBackground(new java.awt.Color(45, 34, 26));

        imgFooterLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cobalt-symbol-footer.png"))); // NOI18N

        lblFooter1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFooter1.setForeground(new java.awt.Color(214, 192, 179));
        lblFooter1.setText("© 2026 C-MOS - Cobalt Mining Operation System · Kelompok 13 COBALT");

        lblFooter2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblFooter2.setForeground(new java.awt.Color(148, 133, 124));
        lblFooter2.setText("Program Studi Sistem Informasi · Fakultas Teknik · Universitas Mulawarman");

        lblFooter3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblFooter3.setForeground(new java.awt.Color(171, 136, 109));
        lblFooter3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFooter3.setText("CAPSTONE 2026");

        org.jdesktop.layout.GroupLayout pnlFooterLayout = new org.jdesktop.layout.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFooterLayout.createSequentialGroup()
                .add(68, 68, 68)
                .add(pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(imgFooterLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlFooterLayout.createSequentialGroup()
                        .add(62, 62, 62)
                        .add(lblFooter1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 620, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlFooterLayout.createSequentialGroup()
                        .add(62, 62, 62)
                        .add(lblFooter2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 620, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(lblFooter3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(57, 57, 57))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFooterLayout.createSequentialGroup()
                .add(48, 48, 48)
                .add(pnlFooterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlFooterLayout.createSequentialGroup()
                        .add(4, 4, 4)
                        .add(imgFooterLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(lblFooter1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlFooterLayout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(lblFooter2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlFooterLayout.createSequentialGroup()
                        .add(lblFooter3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(11, 11, 11)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pnlTopBar.setBackground(new java.awt.Color(73, 54, 40));

        lblLogoSm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cobalt-symbol-sm.png"))); // NOI18N

        lblBrandTop.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblBrandTop.setForeground(new java.awt.Color(214, 192, 179));
        lblBrandTop.setText("C-MOS");

        lblBrandTopSub.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblBrandTopSub.setForeground(new java.awt.Color(228, 224, 225));
        lblBrandTopSub.setText("COBALT MINING SYSTEM");

        lblNavTentang.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblNavTentang.setForeground(new java.awt.Color(228, 224, 225));
        lblNavTentang.setText("Tentang");
        lblNavTentang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNavTentangMouseClicked(evt);
            }
        });

        lblNavOperasi.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblNavOperasi.setForeground(new java.awt.Color(228, 224, 225));
        lblNavOperasi.setText("Operasional");
        lblNavOperasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNavOperasiMouseClicked(evt);
            }
        });

        lblNavTim.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblNavTim.setForeground(new java.awt.Color(228, 224, 225));
        lblNavTim.setText("Tim Kami");
        lblNavTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNavTimMouseClicked(evt);
            }
        });

        btnLoginTop.setBackground(new java.awt.Color(171, 136, 109));
        btnLoginTop.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnLoginTop.setForeground(new java.awt.Color(255, 255, 255));
        btnLoginTop.setText("MASUK");
        btnLoginTop.setBorderPainted(false);
        btnLoginTop.setFocusPainted(false);
        btnLoginTop.addActionListener(this::btnLoginTopActionPerformed);

        pnlTopAccent.setBackground(new java.awt.Color(171, 136, 109));

        org.jdesktop.layout.GroupLayout pnlTopBarLayout = new org.jdesktop.layout.GroupLayout(pnlTopBar);
        pnlTopBar.setLayout(pnlTopBarLayout);
        pnlTopBarLayout.setHorizontalGroup(
            pnlTopBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(40, 40, 40)
                .add(lblLogoSm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(110, 110, 110)
                .add(lblBrandTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(110, 110, 110)
                .add(lblBrandTopSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 220, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(660, 660, 660)
                .add(lblNavTentang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(760, 760, 760)
                .add(lblNavOperasi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(890, 890, 890)
                .add(lblNavTim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(1120, 1120, 1120)
                .add(btnLoginTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopAccent, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlTopBarLayout.setVerticalGroup(
            pnlTopBarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(24, 24, 24)
                .add(lblLogoSm, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(lblBrandTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(47, 47, 47)
                .add(lblBrandTopSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(lblNavTentang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(lblNavOperasi, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(32, 32, 32)
                .add(lblNavTim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(22, 22, 22)
                .add(btnLoginTop, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(pnlTopBarLayout.createSequentialGroup()
                .add(86, 86, 86)
                .add(pnlTopAccent, 2, 2, 2))
        );

        pnlCmos.setBackground(new java.awt.Color(45, 34, 26));

        lblCmosKicker.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblCmosKicker.setForeground(new java.awt.Color(171, 136, 109));
        lblCmosKicker.setText("◆  APLIKASI C-MOS");

        lblCmosTitle.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        lblCmosTitle.setForeground(new java.awt.Color(250, 247, 243));
        lblCmosTitle.setText("Cobalt Mining Operation System");

        lblCmosDesc.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblCmosDesc.setForeground(new java.awt.Color(214, 192, 179));
        lblCmosDesc.setText("<html>C-MOS adalah aplikasi desktop berbasis <b>Java</b> yang terintegrasi dengan basis data <b>MySQL</b> untuk memusatkan data operasional pertambangan PT. Cobalt. Sistem menerapkan pembagian hak akses berbasis peran, validasi operasional otomatis, serta penyajian dashboard dan laporan dimulai dari pencatatan produksi hingga monitoring lingkungan.</html>");

        imgCmosLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cobalt-symbol-210.png"))); // NOI18N

        pnlFeat0.setBackground(new java.awt.Color(63, 50, 40));

        lblFeat0.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFeat0.setForeground(new java.awt.Color(228, 224, 225));
        lblFeat0.setText("<html><b>Role-Based Access Control</b><br>Hak akses Admin, Petugas Operasional, Petugas HSE, dan Manager</html>");

        org.jdesktop.layout.GroupLayout pnlFeat0Layout = new org.jdesktop.layout.GroupLayout(pnlFeat0);
        pnlFeat0.setLayout(pnlFeat0Layout);
        pnlFeat0Layout.setHorizontalGroup(
            pnlFeat0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat0Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(lblFeat0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnlFeat0Layout.setVerticalGroup(
            pnlFeat0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat0Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(lblFeat0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlFeat1.setBackground(new java.awt.Color(63, 50, 40));

        lblFeat1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFeat1.setForeground(new java.awt.Color(228, 224, 225));
        lblFeat1.setText("<html><b>Validasi Operasional Otomatis</b><br>Material tersedia, kapasitas kendaraan, dan ketersediaan driver tervalidasi</html>");

        org.jdesktop.layout.GroupLayout pnlFeat1Layout = new org.jdesktop.layout.GroupLayout(pnlFeat1);
        pnlFeat1.setLayout(pnlFeat1Layout);
        pnlFeat1Layout.setHorizontalGroup(
            pnlFeat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat1Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(lblFeat1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnlFeat1Layout.setVerticalGroup(
            pnlFeat1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat1Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(lblFeat1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlFeat2.setBackground(new java.awt.Color(63, 50, 40));

        lblFeat2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFeat2.setForeground(new java.awt.Color(228, 224, 225));
        lblFeat2.setText("<html><b>Dashboard, Statistik & Laporan</b><br>Ringkasan visual untuk pengawasan dan keputusan berbasis data</html>");

        org.jdesktop.layout.GroupLayout pnlFeat2Layout = new org.jdesktop.layout.GroupLayout(pnlFeat2);
        pnlFeat2.setLayout(pnlFeat2Layout);
        pnlFeat2Layout.setHorizontalGroup(
            pnlFeat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat2Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(lblFeat2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnlFeat2Layout.setVerticalGroup(
            pnlFeat2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat2Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(lblFeat2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlFeat3.setBackground(new java.awt.Color(63, 50, 40));

        lblFeat3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblFeat3.setForeground(new java.awt.Color(228, 224, 225));
        lblFeat3.setText("<html><b>Monitoring Lingkungan Terstruktur</b><br>Status NORMAL/PERINGATAN/BERBAHAYA, tindak lanjut, dan monitoring ulang</html>");

        org.jdesktop.layout.GroupLayout pnlFeat3Layout = new org.jdesktop.layout.GroupLayout(pnlFeat3);
        pnlFeat3.setLayout(pnlFeat3Layout);
        pnlFeat3Layout.setHorizontalGroup(
            pnlFeat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat3Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(lblFeat3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 500, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        pnlFeat3Layout.setVerticalGroup(
            pnlFeat3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFeat3Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(lblFeat3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlCmosLayout = new org.jdesktop.layout.GroupLayout(pnlCmos);
        pnlCmos.setLayout(pnlCmosLayout);
        pnlCmosLayout.setHorizontalGroup(
            pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlCmosLayout.createSequentialGroup()
                .add(pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlCmosLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblCmosKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlCmosLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblCmosTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 560, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlCmosLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblCmosDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 540, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlCmosLayout.createSequentialGroup()
                        .add(214, 214, 214)
                        .add(imgCmosLogo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlFeat0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlFeat1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlFeat2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlFeat3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(104, 104, 104))
        );
        pnlCmosLayout.setVerticalGroup(
            pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlCmosLayout.createSequentialGroup()
                .add(pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlCmosLayout.createSequentialGroup()
                        .add(pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(pnlCmosLayout.createSequentialGroup()
                                .add(56, 56, 56)
                                .add(lblCmosKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(pnlCmosLayout.createSequentialGroup()
                                .add(84, 84, 84)
                                .add(lblCmosTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(10, 10, 10)
                        .add(lblCmosDesc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 138, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlCmosLayout.createSequentialGroup()
                        .add(56, 56, 56)
                        .add(pnlFeat0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(pnlFeat1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(pnlFeat2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(pnlCmosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(imgCmosLogo)
                    .add(pnlFeat3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pnlOps.setBackground(new java.awt.Color(250, 247, 243));

        lblOpsKicker.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblOpsKicker.setForeground(new java.awt.Color(171, 136, 109));
        lblOpsKicker.setText("◆  KEGIATAN OPERASIONAL");

        lblOpsTitle.setFont(new java.awt.Font("SansSerif", 1, 26)); // NOI18N
        lblOpsTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblOpsTitle.setText("Tiga Fokus Utama Operasional Tambang Cobalt");

        lblOpsSub.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblOpsSub.setForeground(new java.awt.Color(103, 121, 143));
        lblOpsSub.setText("Data mengalir dari produksi di PIT hingga pemantauan lingkungan dan saling terhubung dalam satu basis data terpusat.");

        pnlOpsCard0.setBackground(new java.awt.Color(255, 255, 255));

        pnlOpsAccent0.setBackground(new java.awt.Color(171, 136, 109));

        imgOps0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/modul_produksi_card.png"))); // NOI18N

        lblOpsCardTitle0.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblOpsCardTitle0.setForeground(new java.awt.Color(26, 43, 66));
        lblOpsCardTitle0.setText("Produksi Tambang");

        lblOpsCardDesc0.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblOpsCardDesc0.setForeground(new java.awt.Color(71, 86, 105));
        lblOpsCardDesc0.setText("<html>Pencatatan hasil produksi material berdasarkan jenis material, lokasi PIT, tanggal produksi, dan jumlah produksi. Sistem mengelola <b>jumlah material yang masih tersedia</b> secara otomatis setiap kali pengangkutan diselesaikan.</html>");

        lblOpsCardTag0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblOpsCardTag0.setForeground(new java.awt.Color(171, 136, 109));
        lblOpsCardTag0.setText("MODUL 01 · PRODUKSI");

        org.jdesktop.layout.GroupLayout pnlOpsCard0Layout = new org.jdesktop.layout.GroupLayout(pnlOpsCard0);
        pnlOpsCard0.setLayout(pnlOpsCard0Layout);
        pnlOpsCard0Layout.setHorizontalGroup(
            pnlOpsCard0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsAccent0, 370, 370, 370)
            .add(imgOps0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(pnlOpsCard0Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(pnlOpsCard0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblOpsCardTitle0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardDesc0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardTag0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        pnlOpsCard0Layout.setVerticalGroup(
            pnlOpsCard0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsCard0Layout.createSequentialGroup()
                .add(pnlOpsCard0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlOpsAccent0, 5, 5, 5)
                    .add(pnlOpsCard0Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(imgOps0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard0Layout.createSequentialGroup()
                        .add(288, 288, 288)
                        .add(lblOpsCardTitle0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard0Layout.createSequentialGroup()
                        .add(324, 324, 324)
                        .add(lblOpsCardDesc0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard0Layout.createSequentialGroup()
                        .add(450, 450, 450)
                        .add(lblOpsCardTag0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlOpsCard1.setBackground(new java.awt.Color(255, 255, 255));

        pnlOpsAccent1.setBackground(new java.awt.Color(171, 136, 109));

        imgOps1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/modul_pengangkutan_card.png"))); // NOI18N

        lblOpsCardTitle1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblOpsCardTitle1.setForeground(new java.awt.Color(26, 43, 66));
        lblOpsCardTitle1.setText("Pengangkutan Material");

        lblOpsCardDesc1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblOpsCardDesc1.setForeground(new java.awt.Color(71, 86, 105));
        lblOpsCardDesc1.setText("<html>Perencanaan dan pelaksanaan pengangkutan material dari PIT menuju stockpile dengan <b>validasi operasional</b>: ketersediaan material, kapasitas kendaraan, ketersediaan driver, dan kondisi lokasi.</html>");

        lblOpsCardTag1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblOpsCardTag1.setForeground(new java.awt.Color(171, 136, 109));
        lblOpsCardTag1.setText("MODUL 02 · PENGANGKUTAN");

        org.jdesktop.layout.GroupLayout pnlOpsCard1Layout = new org.jdesktop.layout.GroupLayout(pnlOpsCard1);
        pnlOpsCard1.setLayout(pnlOpsCard1Layout);
        pnlOpsCard1Layout.setHorizontalGroup(
            pnlOpsCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsAccent1, 370, 370, 370)
            .add(imgOps1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(pnlOpsCard1Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(pnlOpsCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblOpsCardTitle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardDesc1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardTag1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        pnlOpsCard1Layout.setVerticalGroup(
            pnlOpsCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsCard1Layout.createSequentialGroup()
                .add(pnlOpsCard1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlOpsAccent1, 5, 5, 5)
                    .add(pnlOpsCard1Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(imgOps1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard1Layout.createSequentialGroup()
                        .add(288, 288, 288)
                        .add(lblOpsCardTitle1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard1Layout.createSequentialGroup()
                        .add(324, 324, 324)
                        .add(lblOpsCardDesc1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard1Layout.createSequentialGroup()
                        .add(450, 450, 450)
                        .add(lblOpsCardTag1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnlOpsCard2.setBackground(new java.awt.Color(255, 255, 255));

        pnlOpsAccent2.setBackground(new java.awt.Color(171, 136, 109));

        imgOps2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/landing/modul_monitoring_card.png"))); // NOI18N

        lblOpsCardTitle2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblOpsCardTitle2.setForeground(new java.awt.Color(26, 43, 66));
        lblOpsCardTitle2.setText("Monitoring Lingkungan");

        lblOpsCardDesc2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblOpsCardDesc2.setForeground(new java.awt.Color(71, 86, 105));
        lblOpsCardDesc2.setText("<html>Pencatatan hasil pengukuran parameter lingkungan dengan status <b>NORMAL atau PERINGATAN</b>, lengkap dengan tindak lanjut, status penanganan, monitoring ulang, dan riwayat kondisi lokasi.</html>");

        lblOpsCardTag2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblOpsCardTag2.setForeground(new java.awt.Color(171, 136, 109));
        lblOpsCardTag2.setText("MODUL 03 · MONITORING HSE");

        org.jdesktop.layout.GroupLayout pnlOpsCard2Layout = new org.jdesktop.layout.GroupLayout(pnlOpsCard2);
        pnlOpsCard2.setLayout(pnlOpsCard2Layout);
        pnlOpsCard2Layout.setHorizontalGroup(
            pnlOpsCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsAccent2, 370, 370, 370)
            .add(imgOps2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 370, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(pnlOpsCard2Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(pnlOpsCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblOpsCardTitle2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardDesc2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblOpsCardTag2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 322, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );
        pnlOpsCard2Layout.setVerticalGroup(
            pnlOpsCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsCard2Layout.createSequentialGroup()
                .add(pnlOpsCard2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlOpsAccent2, 5, 5, 5)
                    .add(pnlOpsCard2Layout.createSequentialGroup()
                        .add(5, 5, 5)
                        .add(imgOps2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 264, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard2Layout.createSequentialGroup()
                        .add(288, 288, 288)
                        .add(lblOpsCardTitle2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard2Layout.createSequentialGroup()
                        .add(324, 324, 324)
                        .add(lblOpsCardDesc2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsCard2Layout.createSequentialGroup()
                        .add(450, 450, 450)
                        .add(lblOpsCardTag2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlOpsLayout = new org.jdesktop.layout.GroupLayout(pnlOps);
        pnlOps.setLayout(pnlOpsLayout);
        pnlOpsLayout.setHorizontalGroup(
            pnlOpsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsLayout.createSequentialGroup()
                .add(pnlOpsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblOpsKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblOpsTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 900, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(lblOpsSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1140, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(70, 70, 70)
                        .add(pnlOpsCard0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(455, 455, 455)
                        .add(pnlOpsCard1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(840, 840, 840)
                        .add(pnlOpsCard2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlOpsLayout.setVerticalGroup(
            pnlOpsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlOpsLayout.createSequentialGroup()
                .add(35, 35, 35)
                .add(pnlOpsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblOpsKicker, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(lblOpsTitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlOpsLayout.createSequentialGroup()
                        .add(74, 74, 74)
                        .add(lblOpsSub, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(40, 40, 40)
                .add(pnlOpsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlOpsCard0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlOpsCard1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlOpsCard2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlPageLayout = new org.jdesktop.layout.GroupLayout(pnlPage);
        pnlPage.setLayout(pnlPageLayout);
        pnlPageLayout.setHorizontalGroup(
            pnlPageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHero, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlTentang, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlOps, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlCmos, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlTim, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlFooter, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPageLayout.setVerticalGroup(
            pnlPageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlPageLayout.createSequentialGroup()
                .add(pnlHero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(pnlTentang, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(pnlOps, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(pnlCmos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlTim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(30, 30, Short.MAX_VALUE)
                .add(pnlFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        scrollMain.setViewportView(pnlPage);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTopBar, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(scrollMain, 0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(pnlTopBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(scrollMain, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 3330, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginTopActionPerformed
        bukaLogin();
    }//GEN-LAST:event_btnLoginTopActionPerformed

    private void btnHeroLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHeroLoginActionPerformed
        bukaLogin();
    }//GEN-LAST:event_btnHeroLoginActionPerformed

    private void btnPelajariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelajariActionPerformed
        gulirHalus(pnlTentang.getY());
    }//GEN-LAST:event_btnPelajariActionPerformed

    private void lblNavTentangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNavTentangMouseClicked
        gulirHalus(pnlTentang.getY());
    }//GEN-LAST:event_lblNavTentangMouseClicked

    private void lblNavOperasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNavOperasiMouseClicked
        gulirHalus(pnlOps.getY());
    }//GEN-LAST:event_lblNavOperasiMouseClicked

    private void lblNavTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNavTimMouseClicked
        gulirHalus(pnlTim.getY());
    }//GEN-LAST:event_lblNavTimMouseClicked

    /** Menggulir halaman secara halus menuju posisi Y target.
     * Posisi target diambil langsung dari panel section hasil GUI Builder,
     * sehingga tetap akurat jika tinggi/urutan section diubah di Design view. */
    private void gulirHalus(int targetY) {
        javax.swing.JViewport viewport = scrollMain.getViewport();
        java.awt.Point dari = viewport.getViewPosition();
        int dariY = dari.y;
        int maks = Math.max(0, pnlPage.getHeight() - viewport.getHeight());
        final int delta = Math.max(-dariY, Math.min(targetY, maks) - dariY);
        if (delta == 0) {
            return;
        }
        if (timerGulir != null && timerGulir.isRunning()) {
            timerGulir.stop();
        }
        final int[] langkah = {0};
        final javax.swing.Timer[] pemilik = new javax.swing.Timer[1];
        pemilik[0] = new javax.swing.Timer(16, e -> {
            langkah[0]++;
            double p = Math.min(1.0, langkah[0] / 30.0);
            double halus = 1 - Math.pow(1 - p, 3);
            int y = (int) Math.round(dariY + delta * halus);
            y = Math.max(0, Math.min(y, Math.max(0, pnlPage.getHeight() - viewport.getHeight())));
            viewport.setViewPosition(new java.awt.Point(0, y));
            if (p >= 1.0) {
                pemilik[0].stop();
            }
        });
        timerGulir = pemilik[0];
        timerGulir.start();
    }

    /** Membuka halaman login; memastikan layanan database sudah siap. */
    private void bukaLogin() {
        try {
            AppConfig.initialize();
            new LoginFrame().setVisible(true);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Belum dapat terhubung ke database cmos_db.\n"
                    + "Jalankan MySQL dan pastikan konfigurasi JDBC benar, lalu coba lagi.\n\n"
                    + "Detail: " + ex.getMessage(),
                    "Koneksi Database C-MOS", JOptionPane.WARNING_MESSAGE);
        }
    }

    private javax.swing.Timer timerGulir;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHeroLogin;
    private javax.swing.JButton btnLoginTop;
    private javax.swing.JButton btnPelajari;
    private javax.swing.JLabel imgCmosLogo;
    private javax.swing.JLabel imgFooterLogo;
    private javax.swing.JLabel imgHero;
    private javax.swing.JLabel imgOps0;
    private javax.swing.JLabel imgOps1;
    private javax.swing.JLabel imgOps2;
    private javax.swing.JLabel imgTentang;
    private javax.swing.JLabel imgTim0;
    private javax.swing.JLabel imgTim1;
    private javax.swing.JLabel imgTim2;
    private javax.swing.JLabel imgTim3;
    private javax.swing.JLabel lblBrandTop;
    private javax.swing.JLabel lblBrandTopSub;
    private javax.swing.JLabel lblCmosDesc;
    private javax.swing.JLabel lblCmosKicker;
    private javax.swing.JLabel lblCmosTitle;
    private javax.swing.JLabel lblFeat0;
    private javax.swing.JLabel lblFeat1;
    private javax.swing.JLabel lblFeat2;
    private javax.swing.JLabel lblFeat3;
    private javax.swing.JLabel lblFooter1;
    private javax.swing.JLabel lblFooter2;
    private javax.swing.JLabel lblFooter3;
    private javax.swing.JLabel lblHeroKicker;
    private javax.swing.JLabel lblHeroSub;
    private javax.swing.JLabel lblHeroTitle;
    private javax.swing.JLabel lblLogoSm;
    private javax.swing.JLabel lblNavOperasi;
    private javax.swing.JLabel lblNavTentang;
    private javax.swing.JLabel lblNavTim;
    private javax.swing.JLabel lblOpsCardDesc0;
    private javax.swing.JLabel lblOpsCardDesc1;
    private javax.swing.JLabel lblOpsCardDesc2;
    private javax.swing.JLabel lblOpsCardTag0;
    private javax.swing.JLabel lblOpsCardTag1;
    private javax.swing.JLabel lblOpsCardTag2;
    private javax.swing.JLabel lblOpsCardTitle0;
    private javax.swing.JLabel lblOpsCardTitle1;
    private javax.swing.JLabel lblOpsCardTitle2;
    private javax.swing.JLabel lblOpsKicker;
    private javax.swing.JLabel lblOpsSub;
    private javax.swing.JLabel lblOpsTitle;
    private javax.swing.JLabel lblStatSub0;
    private javax.swing.JLabel lblStatSub1;
    private javax.swing.JLabel lblStatSub2;
    private javax.swing.JLabel lblStatSub3;
    private javax.swing.JLabel lblStatTitle0;
    private javax.swing.JLabel lblStatTitle1;
    private javax.swing.JLabel lblStatTitle2;
    private javax.swing.JLabel lblStatTitle3;
    private javax.swing.JLabel lblStatValue0;
    private javax.swing.JLabel lblStatValue1;
    private javax.swing.JLabel lblStatValue2;
    private javax.swing.JLabel lblStatValue3;
    private javax.swing.JLabel lblTentangCaption;
    private javax.swing.JLabel lblTentangKicker;
    private javax.swing.JLabel lblTentangLead;
    private javax.swing.JLabel lblTentangP1;
    private javax.swing.JLabel lblTentangP2;
    private javax.swing.JLabel lblTentangP3;
    private javax.swing.JLabel lblTentangTitle;
    private javax.swing.JLabel lblTimKicker;
    private javax.swing.JLabel lblTimNama0;
    private javax.swing.JLabel lblTimNama1;
    private javax.swing.JLabel lblTimNama2;
    private javax.swing.JLabel lblTimNama3;
    private javax.swing.JLabel lblTimNim0;
    private javax.swing.JLabel lblTimNim1;
    private javax.swing.JLabel lblTimNim2;
    private javax.swing.JLabel lblTimNim3;
    private javax.swing.JLabel lblTimSub;
    private javax.swing.JLabel lblTimTitle;
    private javax.swing.JPanel pnlCmos;
    private javax.swing.JPanel pnlFeat0;
    private javax.swing.JPanel pnlFeat1;
    private javax.swing.JPanel pnlFeat2;
    private javax.swing.JPanel pnlFeat3;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHero;
    private javax.swing.JPanel pnlOps;
    private javax.swing.JPanel pnlOpsAccent0;
    private javax.swing.JPanel pnlOpsAccent1;
    private javax.swing.JPanel pnlOpsAccent2;
    private javax.swing.JPanel pnlOpsCard0;
    private javax.swing.JPanel pnlOpsCard1;
    private javax.swing.JPanel pnlOpsCard2;
    private javax.swing.JPanel pnlPage;
    private javax.swing.JPanel pnlStat0;
    private javax.swing.JPanel pnlStat1;
    private javax.swing.JPanel pnlStat2;
    private javax.swing.JPanel pnlStat3;
    private javax.swing.JPanel pnlStatAccent0;
    private javax.swing.JPanel pnlStatAccent1;
    private javax.swing.JPanel pnlStatAccent2;
    private javax.swing.JPanel pnlStatAccent3;
    private javax.swing.JPanel pnlTentang;
    private javax.swing.JPanel pnlTim;
    private javax.swing.JPanel pnlTim0;
    private javax.swing.JPanel pnlTim1;
    private javax.swing.JPanel pnlTim2;
    private javax.swing.JPanel pnlTim3;
    private javax.swing.JPanel pnlTimAccent0;
    private javax.swing.JPanel pnlTimAccent1;
    private javax.swing.JPanel pnlTimAccent2;
    private javax.swing.JPanel pnlTimAccent3;
    private javax.swing.JPanel pnlTopAccent;
    private javax.swing.JPanel pnlTopBar;
    private javax.swing.JScrollPane scrollMain;
    // End of variables declaration//GEN-END:variables
}
