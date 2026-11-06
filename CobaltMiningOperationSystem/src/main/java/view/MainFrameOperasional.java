package view;

import config.AppConfig;
import controller.AuthController;
import javax.swing.*;
import java.awt.*;

/** Frame utama OPERASIONAL dengan sidebar dan area konten yang dapat discroll. */
public class MainFrameOperasional extends javax.swing.JFrame {
    private final AuthController auth = AppConfig.getAuthController();
    private final java.util.Map<String, JButton> buttons = new java.util.LinkedHashMap<>();
    private final java.util.Map<String, String> titles = new java.util.LinkedHashMap<>();

    public MainFrameOperasional() {
        initComponents();
        
        JButton[] navButtons = {btnDashboard, btnProduksi, btnPengangkutan, btnUbahAkun, btnLogout};
        
        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        if (auth == null || !auth.isLoggedIn() || !auth.isPetugasOperasional()) {
            throw new IllegalStateException("Akses pengguna tidak sesuai.");
        }
        
        pack();
        setSize(1400, 800);
        setMinimumSize(new java.awt.Dimension(1180, 700));
        setResizable(false);
        setLocationRelativeTo(null);
        lblUser.setText(auth.getCurrentPegawai().getNamaPegawai());
        buttons.put("Dashboard", btnDashboard);
        titles.put("Dashboard", "Dashboard");
        buttons.put("Produksi", btnProduksi);
        titles.put("Produksi", "Produksi Tambang");
        buttons.put("Pengangkutan", btnPengangkutan);
        titles.put("Pengangkutan", "Pengangkutan");
        onMenu("Dashboard");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        pnlSidebar = new javax.swing.JPanel();
        lblBrand = new javax.swing.JLabel();
        lblBrandSub = new javax.swing.JLabel();
        lblNavTitle = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnProduksi = new javax.swing.JButton();
        btnPengangkutan = new javax.swing.JButton();
        btnUbahAkun = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlWorkspace = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblEyebrow = new javax.swing.JLabel();
        lblPageTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();
        scrollContent = new javax.swing.JScrollPane();
        pnlPageHost = new javax.swing.JPanel();

        pnlRoot.setBackground(new java.awt.Color(244, 247, 252));

        pnlSidebar.setBackground(new java.awt.Color(73, 54, 40));

        lblBrand.setBackground(new java.awt.Color(214, 192, 179));
        lblBrand.setFont(new java.awt.Font("SansSerif", 1, 31)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(214, 192, 179));
        lblBrand.setText("C-MOS");

        lblBrandSub.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblBrandSub.setForeground(new java.awt.Color(228, 224, 225));
        lblBrandSub.setText("COBALT MINING SYSTEM");

        lblNavTitle.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblNavTitle.setForeground(new java.awt.Color(228, 224, 225));
        lblNavTitle.setText("NAVIGASI  /  OPERASIONAL");

        btnDashboard.setBackground(new java.awt.Color(171, 136, 109));
        btnDashboard.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setFocusPainted(false);
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);

        btnProduksi.setBackground(new java.awt.Color(171, 136, 109));
        btnProduksi.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnProduksi.setForeground(new java.awt.Color(255, 255, 255));
        btnProduksi.setText("Produksi Tambang");
        btnProduksi.setFocusPainted(false);
        btnProduksi.addActionListener(this::btnProduksiActionPerformed);

        btnPengangkutan.setBackground(new java.awt.Color(171, 136, 109));
        btnPengangkutan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnPengangkutan.setForeground(new java.awt.Color(255, 255, 255));
        btnPengangkutan.setText("Pengangkutan");
        btnPengangkutan.setFocusPainted(false);
        btnPengangkutan.addActionListener(this::btnPengangkutanActionPerformed);

        btnUbahAkun.setBackground(new java.awt.Color(171, 136, 109));
        btnUbahAkun.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnUbahAkun.setForeground(new java.awt.Color(255, 255, 255));
        btnUbahAkun.setText("Ubah Akun");
        btnUbahAkun.setFocusPainted(false);
        btnUbahAkun.addActionListener(this::btnUbahAkunActionPerformed);

        btnLogout.setBackground(new java.awt.Color(171, 136, 109));
        btnLogout.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Keluar Akun");
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        org.jdesktop.layout.GroupLayout pnlSidebarLayout = new org.jdesktop.layout.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSidebarLayout.createSequentialGroup()
                .add(24, 24, 24)
                .add(pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblBrand, 202, 202, 202)
                    .add(lblBrandSub, 202, 202, 202)
                    .add(lblNavTitle, 202, 202, 202)
                    .add(btnDashboard, 202, 202, 202)
                    .add(btnProduksi, 202, 202, 202)
                    .add(btnPengangkutan, 202, 202, 202)
                    .add(btnUbahAkun, 202, 202, 202)
                    .add(btnLogout, 202, 202, 202))
                .add(24, 24, 24))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSidebarLayout.createSequentialGroup()
                .add(26, 26, 26)
                .add(lblBrand, 44, 44, 44)
                .add(2, 2, 2)
                .add(lblBrandSub, 20, 20, 20)
                .add(22, 22, 22)
                .add(lblNavTitle, 18, 18, 18)
                .add(10, 10, 10)
                .add(btnDashboard, 42, 42, 42)
                .add(6, 6, 6)
                .add(btnProduksi, 42, 42, 42)
                .add(6, 6, 6)
                .add(btnPengangkutan, 42, 42, 42)
                .add(0, 0, Short.MAX_VALUE)
                .add(btnUbahAkun, 42, 42, 42)
                .add(6, 6, 6)
                .add(btnLogout, 42, 42, 42)
                .add(24, 24, 24))
        );

        pnlWorkspace.setBackground(new java.awt.Color(171, 136, 109));

        pnlHeader.setBackground(new java.awt.Color(171, 136, 109));

        lblEyebrow.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblEyebrow.setForeground(new java.awt.Color(73, 54, 40));
        lblEyebrow.setText("COBALT MINING  /  OPERASIONAL");

        lblPageTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblPageTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblPageTitle.setText("Dashboard");

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Pengguna");

        lblRole.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblRole.setForeground(new java.awt.Color(73, 54, 40));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole.setText("OPERASIONAL");

        org.jdesktop.layout.GroupLayout pnlHeaderLayout = new org.jdesktop.layout.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeaderLayout.createSequentialGroup()
                .add(24, 24, 24)
                .add(pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEyebrow, 460, 460, 460)
                    .add(lblPageTitle, 460, 460, 460))
                .add(0, 0, Short.MAX_VALUE)
                .add(pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblUser, 220, 220, 220)
                    .add(lblRole, 220, 220, 220))
                .add(24, 24, 24))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .add(pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlHeaderLayout.createSequentialGroup()
                        .add(lblEyebrow, 18, 18, 18)
                        .add(2, 2, 2)
                        .add(lblPageTitle, 40, 40, 40))
                    .add(pnlHeaderLayout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(lblUser, 24, 24, 24)
                        .add(3, 3, 3)
                        .add(lblRole, 20, 20, 20)))
                .addContainerGap())
        );

        pnlContent.setBackground(new java.awt.Color(244, 247, 252));

        scrollContent.setBackground(new java.awt.Color(244, 247, 252));

        pnlPageHost.setBackground(new java.awt.Color(214, 192, 179));
        pnlPageHost.setLayout(new java.awt.BorderLayout());
        scrollContent.setViewportView(pnlPageHost);

        org.jdesktop.layout.GroupLayout pnlContentLayout = new org.jdesktop.layout.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrollContent, 0, 1150, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(scrollContent, 0, 700, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout pnlWorkspaceLayout = new org.jdesktop.layout.GroupLayout(pnlWorkspace);
        pnlWorkspace.setLayout(pnlWorkspaceLayout);
        pnlWorkspaceLayout.setHorizontalGroup(
            pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeader, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlContent, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlWorkspaceLayout.setVerticalGroup(
            pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlWorkspaceLayout.createSequentialGroup()
                .add(pnlHeader, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(pnlContent, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlRootLayout = new org.jdesktop.layout.GroupLayout(pnlRoot);
        pnlRoot.setLayout(pnlRootLayout);
        pnlRootLayout.setHorizontalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRootLayout.createSequentialGroup()
                .add(pnlSidebar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(pnlWorkspace, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRootLayout.setVerticalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSidebar, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(pnlWorkspace, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void onMenu(String menu) {

        if ("Logout".equals(menu)) {

            int answer = JOptionPane.showConfirmDialog(this, "Keluar dari akun C-MOS?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (answer == JOptionPane.YES_OPTION) {

                auth.logout();

                new LoginFrame().setVisible(true);

                dispose();

            }

            return;

        }



        if ("UbahAkun".equals(menu)) {

            new UbahAkunFrame().setVisible(true);

            return;

        }



        if (!buttons.containsKey(menu)) return;

        lblPageTitle.setText(titles.getOrDefault(menu, menu));

        JPanel page = ViewFactory.create(menu, "Operasional", this::onMenu);

        pnlPageHost.removeAll();

        // Area halaman menggunakan BorderLayout dari GUI Builder.
        // Komponen konten mengisi seluruh lebar viewport.

        pnlPageHost.add(page, java.awt.BorderLayout.CENTER);

        pnlPageHost.revalidate();

        pnlPageHost.repaint();

        scrollContent.getVerticalScrollBar().setUnitIncrement(20);

        scrollContent.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollContent.getViewport().setViewPosition(new java.awt.Point(0, 0));

    }

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Dashboard"); }

    private void btnProduksiActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Produksi"); }

    private void btnPengangkutanActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Pengangkutan"); }

    private void btnUbahAkunActionPerformed(java.awt.event.ActionEvent evt) { onMenu("UbahAkun"); }

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Logout"); }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPengangkutan;
    private javax.swing.JButton btnProduksi;
    private javax.swing.JButton btnUbahAkun;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandSub;
    private javax.swing.JLabel lblEyebrow;
    private javax.swing.JLabel lblNavTitle;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPageHost;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlWorkspace;
    private javax.swing.JScrollPane scrollContent;
    // End of variables declaration//GEN-END:variables
}
