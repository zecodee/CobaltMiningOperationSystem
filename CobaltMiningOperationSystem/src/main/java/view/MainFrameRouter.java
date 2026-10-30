package view;

import config.AppConfig;
import controller.AuthController;
import javax.swing.JFrame;

/** Routes an authenticated user to the matching role-specific JFrame. */
public final class MainFrameRouter {
    private MainFrameRouter() { }

    public static JFrame bukaSesuaiHakAkses() {
        AuthController auth = AppConfig.getAuthController();
        if (auth == null || !auth.isLoggedIn()) {
            throw new IllegalStateException("Silakan login terlebih dahulu.");
        }
        if (auth.isAdmin()) return new MainFrameAdmin();
        if (auth.isPetugasOperasional()) return new MainFrameOperasional();
        if (auth.isPetugasHSE()) return new MainFrameHSE();
        if (auth.isManager()) return new MainFrameManager();
        throw new IllegalStateException("Jenis pegawai tidak memiliki akses aplikasi.");
    }
}
