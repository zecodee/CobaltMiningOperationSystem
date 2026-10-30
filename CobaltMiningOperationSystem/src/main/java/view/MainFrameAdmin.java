package view;
import config.AppConfig;
import controller.AuthController;
import javax.swing.*;
import java.awt.*;
public class MainFrameAdmin extends javax.swing.JFrame {
    private final AuthController auth = AppConfig.getAuthController();
    private String active = "";
    private final java.util.Map<String, JButton> buttons = new java.util.LinkedHashMap<>();

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
        if (!buttons.containsKey(menu)) return;
        active = menu;
        
        lblPageTitle.setText(menu.replace("Laporan", "Laporan "));
        JPanel page = ViewFactory.create(menu, "Admin", this::onMenu);
        pnlContent.removeAll();
        pnlContent.setLayout(new BorderLayout());
        pnlContent.add(page, BorderLayout.CENTER);
        pnlContent.revalidate();
        pnlContent.repaint();
    }

    public MainFrameAdmin() {
        initComponents();
        if (auth == null || !auth.isLoggedIn() || !auth.isAdmin()) {
            throw new IllegalStateException("Akses pengguna tidak sesuai.");
        }
        setSize(1200, 750);
        setResizable(false);
        setLocationRelativeTo(null);
        lblUser.setText(auth.getCurrentPegawai().getNamaPegawai());
        buttons.put("Dashboard", btnDashboard);
        buttons.put("Pegawai", btnPegawai);
        buttons.put("User", btnUser);
        buttons.put("Lokasi", btnLokasi);
        buttons.put("Material", btnMaterial);
        buttons.put("Kendaraan", btnKendaraan);
        buttons.put("Parameter", btnParameter);
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
        btnPegawai = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnLokasi = new javax.swing.JButton();
        btnMaterial = new javax.swing.JButton();
        btnKendaraan = new javax.swing.JButton();
        btnParameter = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlWorkspace = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblEyebrow = new javax.swing.JLabel();
        lblPageTitle = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        pnlContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pnlRoot.setBackground(new java.awt.Color(244, 247, 252));

        pnlSidebar.setBackground(new java.awt.Color(16, 30, 51));

        lblBrand.setFont(new java.awt.Font("SansSerif", 1, 31)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand.setText("C-MOS");

        lblBrandSub.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblBrandSub.setForeground(new java.awt.Color(145, 167, 194));
        lblBrandSub.setText("COBALT MINING SYSTEM");

        lblNavTitle.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblNavTitle.setForeground(new java.awt.Color(145, 167, 194));
        lblNavTitle.setText("NAVIGASI  /  ADMIN");

        btnDashboard.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnDashboard.setText("Dashboard");
        btnDashboard.setFocusPainted(false);
        btnDashboard.addActionListener(this::btnDashboardActionPerformed);

        btnPegawai.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnPegawai.setText("Data Pegawai");
        btnPegawai.addActionListener(this::btnPegawaiActionPerformed);

        btnUser.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnUser.setText("Akun Pengguna");
        btnUser.addActionListener(this::btnUserActionPerformed);

        btnLokasi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnLokasi.setText("Lokasi Tambang");
        btnLokasi.addActionListener(this::btnLokasiActionPerformed);

        btnMaterial.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnMaterial.setText("Jenis Material");
        btnMaterial.addActionListener(this::btnMaterialActionPerformed);

        btnKendaraan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnKendaraan.setText("Kendaraan");
        btnKendaraan.addActionListener(this::btnKendaraanActionPerformed);

        btnParameter.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnParameter.setText("Parameter Lingkungan");
        btnParameter.addActionListener(this::btnParameterActionPerformed);

        btnLogout.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLogout.setText("Keluar Akun");
        btnLogout.addActionListener(this::btnLogoutActionPerformed);

        org.jdesktop.layout.GroupLayout pnlSidebarLayout = new org.jdesktop.layout.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSidebarLayout.createSequentialGroup()
                .add(pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(lblBrand, 200, 200, 200))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(lblBrandSub, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(28, 28, 28)
                        .add(lblNavTitle, 215, 215, 215))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnDashboard, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnPegawai, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnUser, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnLokasi, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnMaterial, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnKendaraan, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnLogout, 210, 210, 210))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(btnParameter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 210, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlSidebarLayout.createSequentialGroup()
                .add(pnlSidebarLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(lblBrand, 46, 46, 46))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(lblBrandSub, 20, 20, 20))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(137, 137, 137)
                        .add(lblNavTitle, 26, 26, 26))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(177, 177, 177)
                        .add(btnDashboard, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(229, 229, 229)
                        .add(btnPegawai, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(281, 281, 281)
                        .add(btnUser, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(333, 333, 333)
                        .add(btnLokasi, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(385, 385, 385)
                        .add(btnMaterial, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(437, 437, 437)
                        .add(btnKendaraan, 42, 42, 42))
                    .add(pnlSidebarLayout.createSequentialGroup()
                        .add(489, 489, 489)
                        .add(btnParameter, 42, 42, 42)))
                .add(122, 122, 122)
                .add(btnLogout, 42, 42, 42)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlWorkspace.setBackground(new java.awt.Color(244, 247, 252));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));

        lblEyebrow.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblEyebrow.setForeground(new java.awt.Color(43, 106, 230));
        lblEyebrow.setText("COBALT MINING  /  ADMIN");

        lblPageTitle.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblPageTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblPageTitle.setText("Dashboard");

        lblUser.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblUser.setForeground(new java.awt.Color(26, 43, 66));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Pengguna");

        lblRole.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblRole.setForeground(new java.awt.Color(103, 121, 143));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole.setText("ADMIN");

        org.jdesktop.layout.GroupLayout pnlHeaderLayout = new org.jdesktop.layout.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeaderLayout.createSequentialGroup()
                .add(26, 26, 26)
                .add(pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblEyebrow, 520, 520, 520)
                    .add(lblPageTitle, 550, 550, 550))
                .add(104, 104, 104)
                .add(pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(lblRole, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblUser, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlHeaderLayout.createSequentialGroup()
                .add(10, 10, 10)
                .add(lblEyebrow, 24, 24, 24))
            .add(pnlHeaderLayout.createSequentialGroup()
                .add(35, 35, 35)
                .add(lblPageTitle, 45, 45, 45))
            .add(pnlHeaderLayout.createSequentialGroup()
                .add(13, 13, 13)
                .add(lblUser, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(lblRole, 25, 25, 25))
        );

        pnlContent.setBackground(new java.awt.Color(244, 247, 252));

        org.jdesktop.layout.GroupLayout pnlContentLayout = new org.jdesktop.layout.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 0, Short.MAX_VALUE)
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 292, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout pnlWorkspaceLayout = new org.jdesktop.layout.GroupLayout(pnlWorkspace);
        pnlWorkspace.setLayout(pnlWorkspaceLayout);
        pnlWorkspaceLayout.setHorizontalGroup(
            pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlWorkspaceLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlWorkspaceLayout.createSequentialGroup()
                        .add(pnlHeader, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .add(pnlContent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlWorkspaceLayout.setVerticalGroup(
            pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlWorkspaceLayout.createSequentialGroup()
                .add(pnlWorkspaceLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlWorkspaceLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(pnlHeader, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlWorkspaceLayout.createSequentialGroup()
                        .add(127, 127, 127)
                        .add(pnlContent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(301, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout pnlRootLayout = new org.jdesktop.layout.GroupLayout(pnlRoot);
        pnlRoot.setLayout(pnlRootLayout);
        pnlRootLayout.setHorizontalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRootLayout.createSequentialGroup()
                .add(pnlSidebar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlWorkspace, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        pnlRootLayout.setVerticalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlRootLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(pnlWorkspace, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlSidebar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Dashboard"); }
    private void btnPegawaiActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Pegawai"); }
    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) { onMenu("User"); }
    private void btnLokasiActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Lokasi"); }
    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Material"); }
    private void btnKendaraanActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Kendaraan"); }
    private void btnParameterActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Parameter"); }
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) { onMenu("Logout"); }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnKendaraan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLokasi;
    private javax.swing.JButton btnMaterial;
    private javax.swing.JButton btnParameter;
    private javax.swing.JButton btnPegawai;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblBrandSub;
    private javax.swing.JLabel lblEyebrow;
    private javax.swing.JLabel lblNavTitle;
    private javax.swing.JLabel lblPageTitle;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JPanel pnlWorkspace;
    // End of variables declaration//GEN-END:variables
}
