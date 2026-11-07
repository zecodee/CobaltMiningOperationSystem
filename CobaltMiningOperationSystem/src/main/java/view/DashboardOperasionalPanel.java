package view;

import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.function.Consumer;

/** Dashboard Petugas Operasional: pemantauan produksi dan tren. */
public class DashboardOperasionalPanel extends javax.swing.JPanel {
    private java.util.function.Consumer<String> navigate;

    public DashboardOperasionalPanel() {
        initComponents();
        
        JButton[] navButtons = {btnTerapkan, btnLihatSemua};
        
        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        cmbPeriode.setSelectedIndex(2);
        choAwal.setDate(java.sql.Date.valueOf(LocalDate.now().withDayOfMonth(1)));
        choAkhir.setDate(java.sql.Date.valueOf(LocalDate.now()));
        try { refreshData(); } catch (Exception ex) { FormUtil.error(this, ex); }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        pnlFilter = new javax.swing.JPanel();
        lblPeriode = new javax.swing.JLabel();
        cmbPeriode = new javax.swing.JComboBox();
        choAwal = new com.toedter.calendar.JDateChooser();
        choAkhir = new com.toedter.calendar.JDateChooser();
        btnTerapkan = new javax.swing.JButton();
        pnlKpi0 = new javax.swing.JPanel();
        lblKpiTitle0 = new javax.swing.JLabel();
        lblKpiValue0 = new javax.swing.JLabel();
        lblKpiSub0 = new javax.swing.JLabel();
        pnlKpi1 = new javax.swing.JPanel();
        lblKpiTitle1 = new javax.swing.JLabel();
        lblKpiValue1 = new javax.swing.JLabel();
        lblKpiSub1 = new javax.swing.JLabel();
        pnlKpi2 = new javax.swing.JPanel();
        lblKpiTitle2 = new javax.swing.JLabel();
        lblKpiValue2 = new javax.swing.JLabel();
        lblKpiSub2 = new javax.swing.JLabel();
        pnlKpi3 = new javax.swing.JPanel();
        lblKpiTitle3 = new javax.swing.JLabel();
        lblKpiValue3 = new javax.swing.JLabel();
        lblKpiSub3 = new javax.swing.JLabel();
        pnlChart1 = new javax.swing.JPanel();
        pnlChart2 = new javax.swing.JPanel();
        pnlTabel = new javax.swing.JPanel();
        lblTabelTitle = new javax.swing.JLabel();
        btnLihatSemua = new javax.swing.JButton();
        scrollTrend = new javax.swing.JScrollPane();
        tblTrend = new javax.swing.JTable();

        setBackground(new java.awt.Color(214, 192, 179));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 23)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Dashboard Petugas Operasional");

        lblHint.setBackground(new java.awt.Color(228, 224, 225));
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Pemantauan produksi tambang, stok material, dan tren produksi");

        pnlFilter.setBackground(new java.awt.Color(73, 54, 40));

        lblPeriode.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblPeriode.setForeground(new java.awt.Color(214, 192, 179));
        lblPeriode.setText("Periode");

        cmbPeriode.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cmbPeriode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hari Ini", "7 Hari Terakhir", "Bulan Ini", "Tahun Ini", "Semua Periode", "Rentang Kustom" }));

        choAwal.setBackground(new java.awt.Color(255, 255, 255));
        choAwal.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        choAkhir.setBackground(new java.awt.Color(255, 255, 255));
        choAkhir.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        btnTerapkan.setBackground(new java.awt.Color(167, 146, 119));
        btnTerapkan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTerapkan.setForeground(new java.awt.Color(255, 255, 255));
        btnTerapkan.setText("Terapkan");
        btnTerapkan.setFocusPainted(false);
        btnTerapkan.addActionListener(this::btnTerapkanActionPerformed);

        org.jdesktop.layout.GroupLayout pnlFilterLayout = new org.jdesktop.layout.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFilterLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(lblPeriode, 56, 56, 56)
                .add(20, 20, 20)
                .add(cmbPeriode, 156, 156, 156)
                .add(20, 20, 20)
                .add(choAwal, 132, 132, 132)
                .add(20, 20, 20)
                .add(choAkhir, 132, 132, 132)
                .add(20, 20, 20)
                .add(btnTerapkan, 116, 116, 116)
                .add(20, 20, 20))
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFilterLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblPeriode, 32, 32, 32)
                    .add(cmbPeriode, 30, 30, 30)
                    .add(choAwal, 30, 30, 30)
                    .add(choAkhir, 30, 30, 30)
                    .add(btnTerapkan, 32, 32, 32))
                .add(16, 18, Short.MAX_VALUE))
        );

        pnlKpi0.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle0.setText("TOTAL PRODUKSI (TON)");

        lblKpiValue0.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue0.setText("-");

        lblKpiSub0.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub0.setText("jumlah produksi periode terpilih");

        org.jdesktop.layout.GroupLayout pnlKpi0Layout = new org.jdesktop.layout.GroupLayout(pnlKpi0);
        pnlKpi0.setLayout(pnlKpi0Layout);
        pnlKpi0Layout.setHorizontalGroup(
            pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi0Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle0, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiValue0, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiSub0, 10, 186, Short.MAX_VALUE)))
        );
        pnlKpi0Layout.setVerticalGroup(
            pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi0Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(lblKpiTitle0, 14, 14, 14)
                .add(4, 4, 4)
                .add(lblKpiValue0, 28, 28, 28)
                .add(3, 3, 3)
                .add(lblKpiSub0, 16, 16, 16)
                .add(12, 17, Short.MAX_VALUE))
        );

        pnlKpi1.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle1.setText("STOK SAAT INI (TON)");

        lblKpiValue1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue1.setForeground(new java.awt.Color(46, 125, 70));
        lblKpiValue1.setText("-");

        lblKpiSub1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub1.setText("stok saat ini (tanpa filter)");

        org.jdesktop.layout.GroupLayout pnlKpi1Layout = new org.jdesktop.layout.GroupLayout(pnlKpi1);
        pnlKpi1.setLayout(pnlKpi1Layout);
        pnlKpi1Layout.setHorizontalGroup(
            pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle1, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiValue1, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiSub1, 10, 186, Short.MAX_VALUE)))
        );
        pnlKpi1Layout.setVerticalGroup(
            pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi1Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(lblKpiTitle1, 14, 14, 14)
                .add(4, 4, 4)
                .add(lblKpiValue1, 28, 28, 28)
                .add(3, 3, 3)
                .add(lblKpiSub1, 16, 16, 16)
                .add(12, 17, Short.MAX_VALUE))
        );

        pnlKpi2.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle2.setText("PRODUKSI TERCATAT");

        lblKpiValue2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue2.setForeground(new java.awt.Color(43, 106, 230));
        lblKpiValue2.setText("-");

        lblKpiSub2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub2.setText("jumlah catatan produksi periode");

        org.jdesktop.layout.GroupLayout pnlKpi2Layout = new org.jdesktop.layout.GroupLayout(pnlKpi2);
        pnlKpi2.setLayout(pnlKpi2Layout);
        pnlKpi2Layout.setHorizontalGroup(
            pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi2Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle2, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiValue2, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiSub2, 10, 186, Short.MAX_VALUE)))
        );
        pnlKpi2Layout.setVerticalGroup(
            pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi2Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(lblKpiTitle2, 14, 14, 14)
                .add(4, 4, 4)
                .add(lblKpiValue2, 28, 28, 28)
                .add(3, 3, 3)
                .add(lblKpiSub2, 16, 16, 16)
                .add(12, 17, Short.MAX_VALUE))
        );

        pnlKpi3.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle3.setText("LOKASI BERPRODUSKI");

        lblKpiValue3.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue3.setForeground(new java.awt.Color(31, 122, 140));
        lblKpiValue3.setText("-");

        lblKpiSub3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub3.setText("PIT dengan hasil produksi periode");

        org.jdesktop.layout.GroupLayout pnlKpi3Layout = new org.jdesktop.layout.GroupLayout(pnlKpi3);
        pnlKpi3.setLayout(pnlKpi3Layout);
        pnlKpi3Layout.setHorizontalGroup(
            pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi3Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle3, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiValue3, 10, 186, Short.MAX_VALUE)
                    .add(lblKpiSub3, 10, 186, Short.MAX_VALUE)))
        );
        pnlKpi3Layout.setVerticalGroup(
            pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi3Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(lblKpiTitle3, 14, 14, 14)
                .add(4, 4, 4)
                .add(lblKpiValue3, 28, 28, 28)
                .add(3, 3, 3)
                .add(lblKpiSub3, 16, 16, 16)
                .add(12, 17, Short.MAX_VALUE))
        );

        pnlChart1.setBackground(new java.awt.Color(234, 216, 192));

        pnlChart2.setBackground(new java.awt.Color(234, 216, 192));

        pnlTabel.setBackground(new java.awt.Color(73, 54, 40));

        lblTabelTitle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblTabelTitle.setForeground(new java.awt.Color(214, 192, 179));
        lblTabelTitle.setText("PRODUKSI TERBARU");

        btnLihatSemua.setBackground(new java.awt.Color(167, 146, 119));
        btnLihatSemua.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnLihatSemua.setForeground(new java.awt.Color(255, 255, 255));
        btnLihatSemua.setText("Lihat Semua Produksi");
        btnLihatSemua.setFocusPainted(false);
        btnLihatSemua.addActionListener(this::btnLihatSemuaActionPerformed);

        scrollTrend.setBackground(new java.awt.Color(255, 255, 255));

        tblTrend.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblTrend.setRowHeight(28);
        tblTrend.setGridColor(new java.awt.Color(226, 232, 240));
        tblTrend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Lokasi", "Material", "Jumlah (ton)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTrend.setViewportView(tblTrend);

        org.jdesktop.layout.GroupLayout pnlTabelLayout = new org.jdesktop.layout.GroupLayout(pnlTabel);
        pnlTabel.setLayout(pnlTabelLayout);
        pnlTabelLayout.setHorizontalGroup(
            pnlTabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTabelLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlTabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlTabelLayout.createSequentialGroup()
                        .add(lblTabelTitle, 10, 400, Short.MAX_VALUE)
                        .add(0, 0, Short.MAX_VALUE)
                        .add(btnLihatSemua, 180, 180, 180))
                    .add(scrollTrend, 10, 804, Short.MAX_VALUE))
                .add(16, 16, 16))
        );
        pnlTabelLayout.setVerticalGroup(
            pnlTabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlTabelLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(pnlTabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTabelTitle, 20, 20, 20)
                    .add(btnLihatSemua, 40, 40, 40))
                .add(8, 8, 8)
                .add(scrollTrend, 230, 233, Short.MAX_VALUE)
                .add(14, 14, 14))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblTitle, 10, 600, Short.MAX_VALUE)
                    .add(lblHint, 10, 600, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(pnlFilter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(pnlKpi0, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(12, 22, Short.MAX_VALUE)
                        .add(pnlKpi1, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(12, 22, Short.MAX_VALUE)
                        .add(pnlKpi2, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(12, 24, Short.MAX_VALUE)
                        .add(pnlKpi3, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(pnlChart1, 10, 876, Short.MAX_VALUE)
                    .add(pnlTabel, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlChart2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(lblTitle, 40, 40, 40)
                .add(2, 2, 2)
                .add(lblHint, 22, 22, 22)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pnlFilter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlKpi0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 22, Short.MAX_VALUE)
                .add(pnlChart2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(pnlChart1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 260, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(14, 14, 14)
                .add(pnlTabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

public DashboardOperasionalPanel(java.util.function.Consumer<String> nav) {

    this();

    this.navigate = nav;

}



    private enums.Periode periodeDipilih() {

        switch (cmbPeriode.getSelectedIndex()) {

            case 0: return enums.Periode.HARI_INI;

            case 1: return enums.Periode.TUJUH_HARI;

            case 2: return enums.Periode.BULAN_INI;

            case 3: return enums.Periode.TAHUN_INI;

            case 4: return enums.Periode.SEMUA;

            default: return enums.Periode.KUSTOM;

        }

    }



    private java.time.LocalDate tanggal(com.toedter.calendar.JDateChooser chooser) {

        java.util.Date nilai = chooser.getDate();

        return nilai == null ? null : nilai.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

    }



    private static String ton(double nilai) {

        return (Math.round(nilai * 10.0) / 10.0) + "";

    }



    private void btnTerapkanActionPerformed(java.awt.event.ActionEvent evt) {

        try { refreshData(); } catch (Exception ex) { FormUtil.error(this, ex); }

    }

    private void refreshData() {

        enums.Periode periode = periodeDipilih();

        boolean kustom = periode == enums.Periode.KUSTOM;

        choAwal.setEnabled(kustom);

        choAkhir.setEnabled(kustom);

        LocalDate awal = tanggal(choAwal);

        LocalDate akhir = tanggal(choAkhir);

        if (kustom) {

            if (awal == null || akhir == null)throw new IllegalArgumentException("Pilih rentang tanggal untuk periode kustom.");

            if (awal.isAfter(akhir))throw new IllegalArgumentException("Tanggal awal tidak boleh setelah tanggal akhir.");

        }



        service.DashboardService.Data d = AppConfig.getDashboardController().operasional(periode, awal, akhir);

        lblKpiValue0.setText(ton(d.produksiTon));

        lblKpiValue1.setText(ton(d.stokTon));

        lblKpiValue2.setText(String.valueOf(d.produksiCount));

        lblKpiValue3.setText(String.valueOf(d.lokasiBerproduksi));



        org.jfree.data.category.DefaultCategoryDataset dsBar = new org.jfree.data.category.DefaultCategoryDataset();

        boolean adaProduksi = false;

        for (Map.Entry<String, Double> e : d.produksiPerLokasi.entrySet()) {

            dsBar.addValue(e.getValue(), "Produksi (ton)", e.getKey());

            if (e.getValue() > 0)adaProduksi = true;

        }

        if (!adaProduksi) {

            DashboardCharts.kosong(pnlChart1, "Belum ada produksi pada periode ini.");

        } else {

            DashboardCharts.render(pnlChart1, DashboardCharts.barHorizontal("Total Produksi per Lokasi PIT", dsBar));

        }



        org.jfree.data.category.DefaultCategoryDataset dsLine = new org.jfree.data.category.DefaultCategoryDataset();

        java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd/MM");

        for (int i = 0; i < d.trenTanggal.size(); i++) {

            dsLine.addValue(d.trenNilai.get(i), "Produksi (ton)", d.trenTanggal.get(i).format(fmt));

        }

        if (d.trenTanggal.isEmpty()) {

            DashboardCharts.kosong(pnlChart2, "Belum ada tren produksi pada periode ini.");

        } else {

            DashboardCharts.render(pnlChart2, DashboardCharts.line("Tren Produksi", dsLine));

        }



        DefaultTableModel model = new DefaultTableModel(

            new String[]{"Tanggal", "Lokasi", "Material", "Jumlah (ton)"}, 0) {

            @Override public boolean isCellEditable(int r, int c) { return false; }

        };

        for (ProduksiTambang p : d.produksiTerbaru) {

            model.addRow(new Object[]{p.getTanggalProduksi(),

                p.getLokasi() == null ? "-" : p.getLokasi().getNamaLokasi(),

                p.getMaterial() == null ? "-" : p.getMaterial().getNamaMaterial(),

                p.getJumlahProduksi()});

        }

        tblTrend.setModel(model);

        if (d.produksiTerbaru.isEmpty()) {

            lblTabelTitle.setText("PRODUKSI TERBARU - tidak ada data pada periode ini");

        } else {

            lblTabelTitle.setText("PRODUKSI TERBARU");

        }

    }



    private void btnLihatSemuaActionPerformed(java.awt.event.ActionEvent evt) {

        navigate.accept("Produksi");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLihatSemua;
    private javax.swing.JButton btnTerapkan;
    private com.toedter.calendar.JDateChooser choAkhir;
    private com.toedter.calendar.JDateChooser choAwal;
    private javax.swing.JComboBox cmbPeriode;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblKpiSub0;
    private javax.swing.JLabel lblKpiSub1;
    private javax.swing.JLabel lblKpiSub2;
    private javax.swing.JLabel lblKpiSub3;
    private javax.swing.JLabel lblKpiTitle0;
    private javax.swing.JLabel lblKpiTitle1;
    private javax.swing.JLabel lblKpiTitle2;
    private javax.swing.JLabel lblKpiTitle3;
    private javax.swing.JLabel lblKpiValue0;
    private javax.swing.JLabel lblKpiValue1;
    private javax.swing.JLabel lblKpiValue2;
    private javax.swing.JLabel lblKpiValue3;
    private javax.swing.JLabel lblPeriode;
    private javax.swing.JLabel lblTabelTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlChart1;
    private javax.swing.JPanel pnlChart2;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKpi0;
    private javax.swing.JPanel pnlKpi1;
    private javax.swing.JPanel pnlKpi2;
    private javax.swing.JPanel pnlKpi3;
    private javax.swing.JPanel pnlTabel;
    private javax.swing.JScrollPane scrollTrend;
    private javax.swing.JTable tblTrend;
    // End of variables declaration//GEN-END:variables
}
