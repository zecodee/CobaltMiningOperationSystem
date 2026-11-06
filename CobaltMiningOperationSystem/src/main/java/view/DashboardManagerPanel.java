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

/** Dashboard Manager: evaluasi produksi dan lingkungan tanpa data pengangkutan. */
public class DashboardManagerPanel extends javax.swing.JPanel {
    private java.util.function.Consumer<String> navigate;
    private final java.util.List<Integer> prioritasIds = new java.util.ArrayList<>();
    private final java.util.List<service.MonitoringService.Permintaan> persetujuanIds = new java.util.ArrayList<>();

    public DashboardManagerPanel() {
        initComponents();
        
        JButton[] navButtons = {btnTindak, btnTerapkan};
        
        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        tblPrioritas.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent e) {
                if(e.getClickCount()==2)lihatPrioritas();
            }
        });
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
        pnlChart2 = new javax.swing.JPanel();
        pnlChart3 = new javax.swing.JPanel();
        pnlChart4 = new javax.swing.JPanel();
        btnTindak = new javax.swing.JButton();
        pnlPrioritas = new javax.swing.JPanel();
        lblPriTitle = new javax.swing.JLabel();
        scrollPrioritas = new javax.swing.JScrollPane();
        tblPrioritas = new javax.swing.JTable();
        pnlRekap = new javax.swing.JPanel();
        lblRekapTitle = new javax.swing.JLabel();
        scrollRekap = new javax.swing.JScrollPane();
        tblRekap = new javax.swing.JTable();

        setBackground(new java.awt.Color(214, 192, 179));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 23)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Dashboard Manager");

        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Evaluasi produksi tambang dan kondisi lingkungan untuk pengambilan keputusan");

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
                .add(16, 17, Short.MAX_VALUE))
        );

        pnlKpi0.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle0.setText("PRODUKSI PERIODE (TON)");

        lblKpiValue0.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue0.setText("-");

        lblKpiSub0.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub0.setText("total produksi periode terpilih");

        org.jdesktop.layout.GroupLayout pnlKpi0Layout = new org.jdesktop.layout.GroupLayout(pnlKpi0);
        pnlKpi0.setLayout(pnlKpi0Layout);
        pnlKpi0Layout.setHorizontalGroup(
            pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi0Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle0, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiValue0, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiSub0, 10, 199, Short.MAX_VALUE)))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        lblKpiSub1.setText("saldo terkini, tanpa filter periode");

        org.jdesktop.layout.GroupLayout pnlKpi1Layout = new org.jdesktop.layout.GroupLayout(pnlKpi1);
        pnlKpi1.setLayout(pnlKpi1Layout);
        pnlKpi1Layout.setHorizontalGroup(
            pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle1, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiValue1, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiSub1, 10, 199, Short.MAX_VALUE)))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlKpi2.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle2.setText("PERINGATAN BELUM SELESAI");

        lblKpiValue2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue2.setForeground(new java.awt.Color(160, 45, 62));
        lblKpiValue2.setText("-");

        lblKpiSub2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub2.setText("seluruh periode");

        org.jdesktop.layout.GroupLayout pnlKpi2Layout = new org.jdesktop.layout.GroupLayout(pnlKpi2);
        pnlKpi2.setLayout(pnlKpi2Layout);
        pnlKpi2Layout.setHorizontalGroup(
            pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi2Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle2, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiValue2, 10, 199, Short.MAX_VALUE)
                    .add(lblKpiSub2, 10, 199, Short.MAX_VALUE)))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlKpi3.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle3.setText("LOKASI PERINGATAN");

        lblKpiValue3.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue3.setForeground(new java.awt.Color(183, 121, 31));
        lblKpiValue3.setText("-");

        lblKpiSub3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub3.setText("berdasar hasil monitoring terakhir");

        org.jdesktop.layout.GroupLayout pnlKpi3Layout = new org.jdesktop.layout.GroupLayout(pnlKpi3);
        pnlKpi3.setLayout(pnlKpi3Layout);
        pnlKpi3Layout.setHorizontalGroup(
            pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi3Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle3, 10, 201, Short.MAX_VALUE)
                    .add(lblKpiValue3, 10, 201, Short.MAX_VALUE)
                    .add(lblKpiSub3, 10, 201, Short.MAX_VALUE)))
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlChart2.setBackground(new java.awt.Color(234, 216, 192));

        pnlChart3.setBackground(new java.awt.Color(234, 216, 192));

        pnlChart4.setBackground(new java.awt.Color(234, 216, 192));

        btnTindak.setBackground(new java.awt.Color(167, 146, 119));
        btnTindak.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnTindak.setForeground(new java.awt.Color(255, 255, 255));
        btnTindak.setText("Setujui Permintaan Terpilih");
        btnTindak.addActionListener(this::btnTindakActionPerformed);

        pnlPrioritas.setBackground(new java.awt.Color(73, 54, 40));

        lblPriTitle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblPriTitle.setForeground(new java.awt.Color(214, 192, 179));
        lblPriTitle.setText("PRIORITAS LINGKUNGAN");

        scrollPrioritas.setBackground(new java.awt.Color(255, 255, 255));

        tblPrioritas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblPrioritas.setRowHeight(28);
        tblPrioritas.setGridColor(new java.awt.Color(226, 232, 240));
        tblPrioritas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tanggal", "Lokasi", "Parameter", "Nilai", "Batas", "Penanganan", "Tindak Lanjut"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPrioritas.setViewportView(tblPrioritas);

        org.jdesktop.layout.GroupLayout pnlPrioritasLayout = new org.jdesktop.layout.GroupLayout(pnlPrioritas);
        pnlPrioritas.setLayout(pnlPrioritasLayout);
        pnlPrioritasLayout.setHorizontalGroup(
            pnlPrioritasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlPrioritasLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlPrioritasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblPriTitle, 10, 848, Short.MAX_VALUE)
                    .add(scrollPrioritas, 10, 848, Short.MAX_VALUE))
                .add(16, 16, 16))
        );
        pnlPrioritasLayout.setVerticalGroup(
            pnlPrioritasLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlPrioritasLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(lblPriTitle, 20, 20, 20)
                .add(8, 8, 8)
                .add(scrollPrioritas, 170, 170, Short.MAX_VALUE)
                .add(14, 14, 14))
        );

        pnlRekap.setBackground(new java.awt.Color(73, 54, 40));

        lblRekapTitle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblRekapTitle.setForeground(new java.awt.Color(214, 192, 179));
        lblRekapTitle.setText("PERMINTAAN MONITORING MENUNGGU PERSETUJUAN");

        scrollRekap.setBackground(new java.awt.Color(255, 255, 255));

        tblRekap.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblRekap.setRowHeight(28);
        tblRekap.setGridColor(new java.awt.Color(226, 232, 240));
        tblRekap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lokasi", "Jenis", "Alasan Kegiatan", "Diajukan", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollRekap.setViewportView(tblRekap);

        org.jdesktop.layout.GroupLayout pnlRekapLayout = new org.jdesktop.layout.GroupLayout(pnlRekap);
        pnlRekap.setLayout(pnlRekapLayout);
        pnlRekapLayout.setHorizontalGroup(
            pnlRekapLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRekapLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlRekapLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblRekapTitle, 10, 848, Short.MAX_VALUE)
                    .add(scrollRekap, 10, 848, Short.MAX_VALUE))
                .add(16, 16, 16))
        );
        pnlRekapLayout.setVerticalGroup(
            pnlRekapLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlRekapLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(lblRekapTitle, 20, 20, 20)
                .add(8, 8, 8)
                .add(scrollRekap, 190, 190, Short.MAX_VALUE)
                .add(14, 14, 14))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnTindak, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(lblTitle, 10, 600, Short.MAX_VALUE)
                    .add(lblHint, 10, 600, Short.MAX_VALUE)
                    .add(pnlPrioritas, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlRekap, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(pnlFilter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pnlChart2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(pnlChart3, 10, 434, Short.MAX_VALUE)
                        .add(12, 12, 12)
                        .add(pnlChart4, 10, 434, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(pnlKpi0, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pnlKpi1, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pnlKpi2, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pnlKpi3, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(lblTitle, 40, 40, 40)
                .add(2, 2, 2)
                .add(lblHint, 22, 22, 22)
                .add(18, 18, 18)
                .add(pnlFilter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 13, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlKpi0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(pnlChart2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlChart3, 240, 300, 300)
                    .add(pnlChart4, 240, 300, 300))
                .add(18, 18, 18)
                .add(pnlPrioritas, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnTindak, 40, 40, 40)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(pnlRekap, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

public DashboardManagerPanel(java.util.function.Consumer<String> nav) {

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



        service.DashboardService.Data d = AppConfig.getDashboardController().manager(periode, awal, akhir);

        lblKpiValue0.setText(ton(d.produksiTon));

        lblKpiValue1.setText(ton(d.stokTon));

        lblKpiValue2.setText(String.valueOf(d.penangananBelumSelesai));

        lblKpiValue3.setText(String.valueOf(d.lokasiPeringatan));
        btnTindak.setText("Setujui Permintaan Terpilih");



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



        org.jfree.data.category.DefaultCategoryDataset dsLokasi = new org.jfree.data.category.DefaultCategoryDataset();
        for (service.DashboardService.RekapLokasiRow r : d.rekapLokasi) {
            dsLokasi.addValue(r.produksi, "Produksi", r.namaLokasi);
            dsLokasi.addValue(r.terkirim, "Terkirim", r.namaLokasi);
            dsLokasi.addValue(r.stok, "Stok", r.namaLokasi);
        }
        if (d.rekapLokasi.isEmpty()) DashboardCharts.kosong(pnlChart3, "Belum ada produksi per lokasi.");
        else DashboardCharts.render(pnlChart3, DashboardCharts.bar("Produksi, Pengiriman, dan Stok per Lokasi", dsLokasi));

        org.jfree.data.general.DefaultPieDataset<String> dsPenanganan = new org.jfree.data.general.DefaultPieDataset<>();
        java.util.Map<String, Integer> hitung = new java.util.LinkedHashMap<>();
        for (service.DashboardService.PrioritasRow r : d.prioritas) {
            String status = String.valueOf(r.penanganan);
            hitung.put(status, hitung.getOrDefault(status, 0) + 1);
        }
        for (java.util.Map.Entry<String,Integer> e : hitung.entrySet()) dsPenanganan.setValue(e.getKey(), e.getValue());
        if (hitung.isEmpty()) DashboardCharts.kosong(pnlChart4, "Tidak ada prioritas penanganan pada periode ini.");
        else DashboardCharts.render(pnlChart4, DashboardCharts.pie("Status Penanganan Lingkungan", dsPenanganan));

        prioritasIds.clear();
        DefaultTableModel modelP = new DefaultTableModel(

            new String[]{"Tanggal", "Lokasi", "Parameter", "Nilai", "Batas", "Penanganan", "Tindak Lanjut"}, 0) {

            @Override public boolean isCellEditable(int r, int c) { return false; }

        };

        java.time.format.DateTimeFormatter fmtT = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (service.DashboardService.PrioritasRow r : d.prioritas) {
            prioritasIds.add(r.idMonitoring);
            modelP.addRow(new Object[]{r.tanggal == null ? "-" : r.tanggal.format(fmtT), r.lokasi,

                r.parameter, r.nilai + " " + r.satuan, r.batasTeks(), r.penanganan,

                r.tindakLanjut == null || r.tindakLanjut.trim().isEmpty() ? "-" : r.tindakLanjut});

        }

        tblPrioritas.setModel(modelP);

        tblPrioritas.setAutoCreateRowSorter(true);



        persetujuanIds.clear();
        persetujuanIds.addAll(AppConfig.getMonitoringController().permintaanMenunggu());
        DefaultTableModel modelR = new DefaultTableModel(new String[]{"Lokasi","Petugas HSE","Alasan Kegiatan","Diajukan","Status"},0){
            @Override public boolean isCellEditable(int r,int c){return false;}
        };
        for(service.MonitoringService.Permintaan perm:persetujuanIds)
            modelR.addRow(new Object[]{perm.lokasi,perm.pengaju,perm.alasan,perm.tanggal,perm.status});
        tblRekap.setModel(modelR);
        tblRekap.setAutoCreateRowSorter(true);
        btnTindak.setEnabled(!persetujuanIds.isEmpty());

    }

    private void btnTindakActionPerformed(java.awt.event.ActionEvent evt) {
        int row=tblRekap.getSelectedRow();
        if(row<0){JOptionPane.showMessageDialog(this,"Pilih permintaan pada tabel terlebih dahulu.");return;}
        int idx=tblRekap.convertRowIndexToModel(row);
        if(idx<0||idx>=persetujuanIds.size())return;
        service.MonitoringService.Permintaan item=persetujuanIds.get(idx);
        String pesan="Setujui monitoring di "+item.lokasi+"?\nPetugas: "+item.pengaju+"\nAlasan: "+item.alasan;
        if(JOptionPane.showConfirmDialog(this,pesan,"Persetujuan Monitoring",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)!=JOptionPane.YES_OPTION)return;
        try {AppConfig.getMonitoringController().setujuiMonitoring(item.id);refreshData();
            JOptionPane.showMessageDialog(this,"Permintaan disetujui. Petugas HSE dapat memulai kegiatan.");
        }catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void lihatPrioritas() {
        int row=tblPrioritas.getSelectedRow();
        if(row<0)return;
        int idx=tblPrioritas.convertRowIndexToModel(row);
        if(idx<0||idx>=prioritasIds.size())return;
        new MonitoringDetailFrame(prioritasIds.get(idx),true).setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerapkan;
    private javax.swing.JButton btnTindak;
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
    private javax.swing.JLabel lblPriTitle;
    private javax.swing.JLabel lblRekapTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlChart2;
    private javax.swing.JPanel pnlChart3;
    private javax.swing.JPanel pnlChart4;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKpi0;
    private javax.swing.JPanel pnlKpi1;
    private javax.swing.JPanel pnlKpi2;
    private javax.swing.JPanel pnlKpi3;
    private javax.swing.JPanel pnlPrioritas;
    private javax.swing.JPanel pnlRekap;
    private javax.swing.JScrollPane scrollPrioritas;
    private javax.swing.JScrollPane scrollRekap;
    private javax.swing.JTable tblPrioritas;
    private javax.swing.JTable tblRekap;
    // End of variables declaration//GEN-END:variables
}
