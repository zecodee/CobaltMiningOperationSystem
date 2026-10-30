package view;

import config.AppConfig;
import controller.AuthController;
import java.awt.Cursor;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class LoginFrame extends javax.swing.JFrame {
    private final AuthController authController;
    private final char defaultEchoChar;

    public LoginFrame() {
        initComponents();
        authController = AppConfig.getAuthController();
        if (authController == null) {
            throw new IllegalStateException("AuthController belum diinisialisasi.");
        }
        defaultEchoChar = txtPassword.getEchoChar();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(760, 620);
        getRootPane().setDefaultButton(btnLogin);
        btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblBrand = new javax.swing.JLabel();
        lblSub = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        chkPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C-MOS | Login");
        setResizable(false);
        setSize(new java.awt.Dimension(740, 600));

        pnlRoot.setBackground(new java.awt.Color(245, 247, 251));

        pnlLeft.setBackground(new java.awt.Color(20, 34, 55));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(125, 180, 255));
        jLabel5.setText("◆  LOGIN FORM");

        lblBrand.setFont(new java.awt.Font("SansSerif", 1, 44)); // NOI18N
        lblBrand.setForeground(new java.awt.Color(255, 255, 255));
        lblBrand.setText("C-MOS");

        lblSub.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblSub.setForeground(new java.awt.Color(176, 199, 228));
        lblSub.setText("COBALT MINING OPERATIONS SYSTEMS");

        jPanel1.setBackground(new java.awt.Color(66, 91, 124));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("OPERATIONS PORTAL");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(183, 198, 218));
        jLabel3.setText("<html>Pengelolaan data pertambangan<br>terintegrasi dalam satu sistem.</html>");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(145, 166, 193));
        jLabel1.setText("CAPSTONE 2026");

        org.jdesktop.layout.GroupLayout pnlLeftLayout = new org.jdesktop.layout.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlLeftLayout.createSequentialGroup()
                .add(pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(36, 36, 36)
                        .add(lblSub, 245, 245, 245))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(34, 34, 34)
                        .add(pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 240, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(lblBrand, 240, 240, 240)))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(jPanel1, 226, 226, 226)))
                .add(6, 6, 6))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlLeftLayout.createSequentialGroup()
                .addContainerGap()
                .add(pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(14, 14, 14))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlLeftLayout.createSequentialGroup()
                .add(pnlLeftLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(56, 56, 56)
                        .add(jLabel5, 48, 48, 48))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(119, 119, 119)
                        .add(lblBrand, 48, 48, 48))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(170, 170, 170)
                        .add(lblSub, 20, 20, 20))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(221, 221, 221)
                        .add(jPanel1, 2, 2, 2))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(255, 255, 255)
                        .add(jLabel4, 30, 30, 30))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(294, 294, 294)
                        .add(jLabel3, 58, 58, 58))
                    .add(pnlLeftLayout.createSequentialGroup()
                        .add(555, 555, 555)
                        .add(jLabel1, 20, 20, 20)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlRight.setBackground(new java.awt.Color(245, 247, 251));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(20, 34, 55));
        jLabel9.setText("Selamat datang kembali");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 116, 139));
        jLabel8.setText("Masuk menggunakan akun C-MOS Anda");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 65, 85));
        jLabel6.setText("USERNAME");

        txtUsername.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 65, 85));
        jLabel7.setText("PASSWORD");

        txtPassword.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        chkPassword.setBackground(new java.awt.Color(245, 247, 251));
        chkPassword.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        chkPassword.setForeground(new java.awt.Color(71, 85, 105));
        chkPassword.setText("Tampilkan password");
        chkPassword.addActionListener(this::chkPasswordActionPerformed);

        btnLogin.setBackground(new java.awt.Color(37, 99, 235));
        btnLogin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("MASUK KE C-MOS");
        btnLogin.addActionListener(this::btnLoginActionPerformed);

        lblStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(185, 28, 28));
        lblStatus.setText(" ");

        jPanel2.setBackground(new java.awt.Color(222, 229, 239));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(148, 163, 184));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("© 2026  C-MOS  by Kelompok 13 COBALT");

        org.jdesktop.layout.GroupLayout pnlRightLayout = new org.jdesktop.layout.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRightLayout.createSequentialGroup()
                .add(42, 42, 42)
                .add(jLabel9, 382, 382, 382))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jLabel8, 375, 375, 375))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jLabel6, 350, 350, 350))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(txtUsername, 372, 372, 372))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jLabel7, 350, 350, 350))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(txtPassword, 372, 372, 372))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(chkPassword, 250, 250, 250))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(btnLogin, 372, 372, 372))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(lblStatus, 372, 372, 372))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jPanel2, 372, 372, 372))
            .add(pnlRightLayout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jLabel2, 372, 372, 372))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRightLayout.createSequentialGroup()
                .add(pnlRightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(72, 72, 72)
                        .add(jLabel9, 38, 38, 38))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(113, 113, 113)
                        .add(jLabel8, 25, 25, 25))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(177, 177, 177)
                        .add(jLabel6, 23, 23, 23))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(205, 205, 205)
                        .add(txtUsername, 43, 43, 43))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(274, 274, 274)
                        .add(jLabel7, 23, 23, 23))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(302, 302, 302)
                        .add(txtPassword, 43, 43, 43))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(359, 359, 359)
                        .add(chkPassword, 27, 27, 27))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(409, 409, 409)
                        .add(btnLogin, 47, 47, 47))
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(472, 472, 472)
                        .add(lblStatus, 30, 30, 30)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 37, Short.MAX_VALUE)
                .add(pnlRightLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, 1, 1, 1)
                    .add(pnlRightLayout.createSequentialGroup()
                        .add(13, 13, 13)
                        .add(jLabel2, 24, 24, 24)))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout pnlRootLayout = new org.jdesktop.layout.GroupLayout(pnlRoot);
        pnlRoot.setLayout(pnlRootLayout);
        pnlRootLayout.setHorizontalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRootLayout.createSequentialGroup()
                .add(pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlLeft, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlRootLayout.createSequentialGroup()
                        .add(300, 300, 300)
                        .add(pnlRight, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlRootLayout.setVerticalGroup(
            pnlRootLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRootLayout.createSequentialGroup()
                .add(pnlRight, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .add(pnlLeft, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRoot, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkPasswordActionPerformed
        txtPassword.setEchoChar(chkPassword.isSelected() ? (char) 0 : defaultEchoChar);
    }//GEN-LAST:event_chkPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        prosesLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void prosesLogin() {
        final String username = txtUsername.getText().trim();
        final char[] password = txtPassword.getPassword();
        if (username.isEmpty() || password.length == 0) {
            lblStatus.setText("Username dan password wajib diisi.");
            Arrays.fill(password, '\0');
            return;
        }
        btnLogin.setEnabled(false);
        lblStatus.setText("Memverifikasi akun...");
        new SwingWorker<Void, Void>() {
            private Exception failure;

            @Override
            protected Void doInBackground() {
                try {
                    authController.login(username, new String(password));
                } catch (Exception ex) {
                    failure = ex;
                } finally {
                    Arrays.fill(password, '\0');
                }
                return null;
            }

            @Override
            protected void done() {
                btnLogin.setEnabled(true);
                if (failure != null) {
                    txtPassword.setText("");
                    lblStatus.setText("Login gagal. Periksa akun Anda.");
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            failure.getMessage(), "Login gagal", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                try {
                    MainFrameRouter.bukaSesuaiHakAkses().setVisible(true);
                    dispose();
                } catch (Exception ex) {
                    lblStatus.setText("Tidak dapat membuka halaman pengguna.");
                    JOptionPane.showMessageDialog(LoginFrame.this,
                            ex.getMessage(), "Gagal membuka halaman", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBrand;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSub;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}