package view;

import javax.swing.JPanel;
import java.util.function.Consumer;

/** Single place to map sidebar commands to editable JPanel Forms. */
public final class ViewFactory {
    private ViewFactory() { }

    public static JPanel create(String menu, String role, Consumer<String> navigate) {
        if ("Dashboard".equals(menu)) {
            switch (role) {
                case "Admin": return new DashboardAdminPanel();
                case "Operasional": return new DashboardOperasionalPanel();
                case "HSE": return new DashboardHSEPanel();
                case "Manager": return new DashboardManagerPanel();
                default: throw new IllegalArgumentException("Role tidak dikenal.");
            }
        }
        switch (menu) {
            case "Pegawai": return new PegawaiPanel();
            case "User": return new UserPanel();
            case "Lokasi": return new LokasiPanel();
            case "Material": return new MaterialPanel();
            case "Kendaraan": return new KendaraanPanel();
            case "Parameter": return new ParameterPanel();
            case "Produksi": return new ProduksiPanel();
            case "Pengangkutan": return new PengangkutanPanel();
            case "Monitoring": return new MonitoringPanel();
            case "LaporanProduksi": return new LaporanProduksiPanel();
            case "LaporanPengangkutan": return new LaporanPengangkutanPanel();
            case "LaporanMonitoring": return new LaporanMonitoringPanel();
            default: throw new IllegalArgumentException("Halaman tidak dikenal: " + menu);
        }
    }
}
