package view;
import config.AppConfig;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
/** Read-only table data binder; never constructs visual components or editor forms. */
public final class DataScreen {
    private final String name;
    private java.util.List<?> records=Collections.emptyList();
    private final controller.MasterDataController master=AppConfig.getMasterDataController();
    private final controller.ProduksiController produksi=AppConfig.getProduksiController();
    private final controller.PengangkutanController angkut=AppConfig.getPengangkutanController();
    private final controller.MonitoringController monitoring=AppConfig.getMonitoringController();
    public DataScreen(String name){this.name=name;}
    public void handle(String action,JTable table,java.awt.Component parent){
        if(!"Refresh".equals(action))throw new UnsupportedOperationException("Aksi harus melalui JFrame Form khusus.");
        refresh(table);
    }
    public void refresh(JTable table) {
        switch (name) {
            case "Pegawai": records = master.tampilkanSemuaPegawai(); break;
            case "User": records = master.tampilkanSemuaUser(); break;
            case "Lokasi": records = master.tampilkanSemuaLokasi(); break;
            case "Material": records = master.tampilkanSemuaMaterial(); break;
            case "Kendaraan": records = master.tampilkanSemuaKendaraan(); break;
            case "Parameter": records = master.tampilkanSemuaParameter(); break;
            case "Produksi": records = produksi.tampilkanSemuaProduksi(); break;
            case "Pengangkutan": records = angkut.tampilkanSemuaPengangkutan(); break;
            case "Monitoring": records = monitoring.tampilkanSemuaMonitoring(); break;
            case "LaporanProduksi": records = AppConfig.getProduksiRepository().findAll(); break;
            case "LaporanPengangkutan": records = AppConfig.getPengangkutanRepository().findAll(); break;
            case "LaporanMonitoring": records = AppConfig.getMonitoringRepository().findAll(); break;
            default: records = Collections.emptyList();
        }
        String[] headings = headings();
        DefaultTableModel model = new DefaultTableModel(headings, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        for (Object item : records) model.addRow(row(item));
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private String[] headings() {
        switch (name) {
            case "Pegawai": return new String[]{"ID", "Nama", "Jenis", "Telepon", "Status"};
            case "User": return new String[]{"ID", "Username", "Pemilik Akun"};
            case "Lokasi": return new String[]{"ID", "Lokasi", "Jenis", "Status"};
            case "Material": return new String[]{"ID", "Material", "Satuan", "Keterangan"};
            case "Kendaraan": return new String[]{"ID", "Jenis", "No Polisi", "Kapasitas", "Status"};
            case "Parameter": return new String[]{"ID", "Parameter", "Satuan", "Min", "Maks"};
            case "Produksi": case "LaporanProduksi":
                return new String[]{"ID", "Tanggal", "Material", "Lokasi", "Produksi (ton)", "Tersedia (ton)"};
            case "Pengangkutan":
                return new String[]{"ID", "Tanggal", "Produksi", "Driver", "Muatan (ton)", "Status"};
            case "LaporanPengangkutan":
                return new String[]{"ID", "Tanggal", "Produksi", "Driver", "Muatan (ton)"};
            case "Monitoring": case "LaporanMonitoring":
                return new String[]{"ID", "Tanggal", "Lokasi", "Status", "Penanganan", "Detail"};
            default: return new String[]{"Data"};
        }
    }

    private Object[] row(Object o) {
        if (o instanceof Pegawai) {
            Pegawai p = (Pegawai)o;
            return new Object[]{p.getIdPegawai(), p.getNamaPegawai(), p.getJenisPegawai(), p.getNoHp(), p.getStatusPegawai()};
        }
        if (o instanceof User) {
            User u = (User)o;
            return new Object[]{u.getIdUser(), u.getUsername(), u.getPegawai().getNamaPegawai()};
        }
        if (o instanceof Lokasi) {
            Lokasi l = (Lokasi)o;
            return new Object[]{l.getIdLokasi(), l.getNamaLokasi(), l.getJenisLokasi(), l.getStatusOperasional()};
        }
        if (o instanceof JenisMaterial) {
            JenisMaterial m = (JenisMaterial)o;
            return new Object[]{m.getIdMaterial(), m.getNamaMaterial(), m.getSatuan(), m.getDeskripsi()};
        }
        if (o instanceof Kendaraan) {
            Kendaraan k = (Kendaraan)o;
            return new Object[]{k.getIdKendaraan(), k.getJenisKendaraan(), k.getNomorPolisi(), k.getKapasitas(), k.getStatusKendaraan()};
        }
        if (o instanceof ParameterLingkungan) {
            ParameterLingkungan p = (ParameterLingkungan)o;
            return new Object[]{p.getIdParameter(), p.getNamaParameter(), p.getSatuan(), p.getBatasMinimum(), p.getBatasMaksimum()};
        }
        if (o instanceof ProduksiTambang) {
            ProduksiTambang p = (ProduksiTambang)o;
            return new Object[]{p.getIdProduksi(), p.getTanggalProduksi(), p.getMaterial().getNamaMaterial(),
                p.getLokasi().getNamaLokasi(), p.getJumlahProduksi(), p.getJumlahTersedia()};
        }
        if (o instanceof Pengangkutan) {
            Pengangkutan p = (Pengangkutan)o;
            if ("LaporanPengangkutan".equals(name)) {
                return new Object[]{p.getIdPengangkutan(), p.getTanggalPengangkutan(),
                    p.getProduksi().getIdProduksi(), p.getDriver().getNamaPegawai(), p.getJumlahMuatan()};
            }
            return new Object[]{p.getIdPengangkutan(), p.getTanggalPengangkutan(), p.getProduksi().getIdProduksi(),
                p.getDriver().getNamaPegawai(), p.getJumlahMuatan(), p.getStatusPengangkutan()};
        }
        if (o instanceof MonitoringLingkungan) {
            MonitoringLingkungan m = (MonitoringLingkungan)o;
            return new Object[]{m.getIdMonitoring(), m.getTanggalMonitoring(), m.getLokasi().getNamaLokasi(),
                m.getStatusMonitoring(), m.getStatusPenanganan(), m.getDetailMonitoring().size()};
        }
        return new Object[]{String.valueOf(o)};
    }

}
