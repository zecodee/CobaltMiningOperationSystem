package view;

import config.AppConfig;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/** Metrics and a purpose-specific bar chart, using read-only repository data. */
public final class DashboardData {
    private DashboardData() { }

    public static void fill(String role, JLabel[] titles, JLabel[] values, JPanel chart) {
        try {
            java.util.List<String> categories = new ArrayList<>();
            java.util.List<Double> amounts = new ArrayList<>();
            if ("Admin".equals(role)) {
                titles[0].setText("TOTAL PEGAWAI");
                titles[1].setText("LOKASI TAMBANG");
                titles[2].setText("KENDARAAN");
                values[0].setText("" + AppConfig.getPegawaiRepository().findAll().size());
                values[1].setText("" + AppConfig.getLokasiRepository().findAll().size());
                values[2].setText("" + AppConfig.getKendaraanRepository().findAll().size());
                for (Pegawai p : AppConfig.getPegawaiRepository().findAll()) {
                    String kind = p.getJenisPegawai();
                    int index = categories.indexOf(kind);
                    if (index < 0) { categories.add(kind); amounts.add(1.0); }
                    else amounts.set(index, amounts.get(index) + 1);
                }
            } else if ("Operasional".equals(role)) {
                java.util.List<ProduksiTambang> produksi = AppConfig.getProduksiRepository().findAll();
                java.util.List<Pengangkutan> angkut = AppConfig.getPengangkutanRepository().findAll();
                double total = 0;
                for (ProduksiTambang p : produksi) total += p.getJumlahProduksi();
                titles[0].setText("REKAMAN PRODUKSI"); titles[1].setText("TOTAL PRODUKSI (TON)");
                titles[2].setText("REKAMAN ANGKUT");
                values[0].setText("" + produksi.size()); values[1].setText(String.format("%.1f", total));
                values[2].setText("" + angkut.size());
                for (ProduksiTambang p : produksi) {
                    String material = p.getMaterial().getNamaMaterial();
                    int index = categories.indexOf(material);
                    if (index < 0) { categories.add(material); amounts.add(p.getJumlahProduksi()); }
                    else amounts.set(index, amounts.get(index) + p.getJumlahProduksi());
                }
            } else if ("HSE".equals(role)) {
                java.util.List<MonitoringLingkungan> list = AppConfig.getMonitoringRepository().findAll();
                long warning = list.stream().filter(m -> "PERINGATAN".equals(m.getStatusMonitoring().name())).count();
                titles[0].setText("TOTAL MONITORING"); titles[1].setText("PERINGATAN"); titles[2].setText("KONDISI NORMAL");
                values[0].setText("" + list.size()); values[1].setText("" + warning);
                values[2].setText("" + (list.size() - warning));
                categories.add("Normal"); amounts.add((double)(list.size() - warning));
                categories.add("Peringatan"); amounts.add((double)warning);
            } else {
                java.util.List<ProduksiTambang> produksi = AppConfig.getProduksiRepository().findAll();
                java.util.List<Pengangkutan> angkut = AppConfig.getPengangkutanRepository().findAll();
                java.util.List<MonitoringLingkungan> mon = AppConfig.getMonitoringRepository().findAll();
                double total = 0;
                for (ProduksiTambang p : produksi) total += p.getJumlahProduksi();
                titles[0].setText("PRODUKSI (TON)"); titles[1].setText("TOTAL PENGANGKUTAN");
                titles[2].setText("TOTAL MONITORING");
                values[0].setText(String.format("%.1f", total)); values[1].setText("" + angkut.size());
                values[2].setText("" + mon.size());
                for (ProduksiTambang p : produksi) {
                    String material = p.getMaterial().getNamaMaterial();
                    int index = categories.indexOf(material);
                    if (index < 0) { categories.add(material); amounts.add(p.getJumlahProduksi()); }
                    else amounts.set(index, amounts.get(index) + p.getJumlahProduksi());
                }
            }
            chart.setLayout(new BorderLayout());
            chart.add(new BarChart(categories, amounts), BorderLayout.CENTER);
        } catch (RuntimeException ex) {
            chart.setLayout(new BorderLayout());
            chart.add(new JLabel("Data belum dapat dimuat: " + ex.getMessage(), SwingConstants.CENTER), BorderLayout.CENTER);
        }
    }

    private static final class BarChart extends JPanel {
        private final java.util.List<String> labels;
        private final java.util.List<Double> values;
        BarChart(java.util.List<String> labels, java.util.List<Double> values) {
            this.labels = labels; this.values = values;
            setBackground(Color.WHITE);
        }
        @Override protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (labels.isEmpty()) {
                g2.setColor(new Color(103, 121, 143));
                g2.drawString("Belum ada data untuk divisualisasikan.", 28, 75);
                g2.dispose(); return;
            }
            double max = 1;
            for (double v : values) max = Math.max(max, v);
            int top = 14, left = 165, available = Math.max(120, getWidth() - left - 85);
            int row = Math.min(36, Math.max(24, (getHeight() - 24) / labels.size()));
            for (int i = 0; i < labels.size(); i++) {
                int y = top + i * row;
                if (y + 24 > getHeight()) break;
                g2.setColor(new Color(26, 43, 66));
                String label = labels.get(i);
                if (label.length() > 20) label = label.substring(0, 19) + "…";
                g2.drawString(label, 8, y + 17);
                int width = (int) Math.round(available * values.get(i) / max);
                g2.setColor(new Color(43, 106, 230));
                g2.fillRoundRect(left, y + 3, Math.max(1, width), 19, 7, 7);
                g2.setColor(new Color(26, 43, 66));
                g2.drawString(String.format("%.1f", values.get(i)), left + width + 7, y + 17);
            }
            g2.dispose();
        }
    }
}
