package view;

import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;

/** Halaman HSE: katalog kondisi lokasi dan pintasan monitoring. */
public class KondisiLokasiPanel extends javax.swing.JPanel {

    public KondisiLokasiPanel() {
        initComponents();
        
        JButton[] navButtons = {btnBuatMonitoring, btnInformasikan, btnKelola};
        
        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }
        
        try { refreshData(); } catch (Exception ex) { FormUtil.error(this, ex); }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbFilterMonitoring = new javax.swing.JComboBox();
        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
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
        scrollKatalog = new javax.swing.JScrollPane();
        pnlListKartu = new javax.swing.JPanel();
        pnlDetail = new javax.swing.JPanel();
        lblDetailTitle = new javax.swing.JLabel();
        lblDNama = new javax.swing.JLabel();
        lblDBadge = new javax.swing.JLabel();
        lblDJenis = new javax.swing.JLabel();
        lblDStatus = new javax.swing.JLabel();
        lblDMonTerakhir = new javax.swing.JLabel();
        lblDHasil = new javax.swing.JLabel();
        lblDPenanganan = new javax.swing.JLabel();
        lblDTindakLanjut = new javax.swing.JLabel();
        lblParameter = new javax.swing.JLabel();
        scrollParameter = new javax.swing.JScrollPane();
        tblParameter = new javax.swing.JTable();
        btnBuatMonitoring = new javax.swing.JButton();
        btnInformasikan = new javax.swing.JButton();
        btnKelola = new javax.swing.JButton();

        setBackground(new java.awt.Color(214, 192, 179));

        cmbFilterMonitoring.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua Hasil", "NORMAL", "PERINGATAN", "BERBAHAYA", "Belum Ada Monitoring" }));
        cmbFilterMonitoring.addActionListener(this::cmbFilterMonitoringActionPerformed);

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Kondisi Lokasi Tambang");

        lblHint.setBackground(new java.awt.Color(228, 224, 225));
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Katalog PIT dan Stockpile beserta hasil monitoring terakhir");

        pnlKpi0.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle0.setText("TOTAL LOKASI");

        lblKpiValue0.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue0.setText("-");

        lblKpiSub0.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub0.setText("PIT dan stockpile aktif");

        org.jdesktop.layout.GroupLayout pnlKpi0Layout = new org.jdesktop.layout.GroupLayout(pnlKpi0);
        pnlKpi0.setLayout(pnlKpi0Layout);
        pnlKpi0Layout.setHorizontalGroup(
            pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi0Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle0, 10, 265, Short.MAX_VALUE)
                    .add(lblKpiValue0, 10, 265, Short.MAX_VALUE)
                    .add(lblKpiSub0, 10, 265, Short.MAX_VALUE)))
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
                .add(12, 13, Short.MAX_VALUE))
        );

        pnlKpi1.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle1.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle1.setText("PERINGATAN TERAKHIR");

        lblKpiValue1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue1.setForeground(new java.awt.Color(160, 45, 62));
        lblKpiValue1.setText("-");

        lblKpiSub1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub1.setText("lokasi dengan hasil terakhir peringatan");

        org.jdesktop.layout.GroupLayout pnlKpi1Layout = new org.jdesktop.layout.GroupLayout(pnlKpi1);
        pnlKpi1.setLayout(pnlKpi1Layout);
        pnlKpi1Layout.setHorizontalGroup(
            pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle1, 10, 265, Short.MAX_VALUE)
                    .add(lblKpiValue1, 10, 265, Short.MAX_VALUE)
                    .add(lblKpiSub1, 10, 265, Short.MAX_VALUE)))
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
                .add(12, 13, Short.MAX_VALUE))
        );

        pnlKpi2.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle2.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle2.setText("BELUM DITANGANI");

        lblKpiValue2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue2.setForeground(new java.awt.Color(183, 121, 31));
        lblKpiValue2.setText("-");

        lblKpiSub2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub2.setText("peringatan yang belum selesai ditangani");

        org.jdesktop.layout.GroupLayout pnlKpi2Layout = new org.jdesktop.layout.GroupLayout(pnlKpi2);
        pnlKpi2.setLayout(pnlKpi2Layout);
        pnlKpi2Layout.setHorizontalGroup(
            pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi2Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle2, 10, 266, Short.MAX_VALUE)
                    .add(lblKpiValue2, 10, 266, Short.MAX_VALUE)
                    .add(lblKpiSub2, 10, 266, Short.MAX_VALUE)))
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
                .add(12, 13, Short.MAX_VALUE))
        );

        scrollKatalog.setBackground(new java.awt.Color(244, 247, 252));

        pnlListKartu.setBackground(new java.awt.Color(73, 54, 40));

        org.jdesktop.layout.GroupLayout pnlListKartuLayout = new org.jdesktop.layout.GroupLayout(pnlListKartu);
        pnlListKartu.setLayout(pnlListKartuLayout);
        pnlListKartuLayout.setHorizontalGroup(
            pnlListKartuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 548, Short.MAX_VALUE)
        );
        pnlListKartuLayout.setVerticalGroup(
            pnlListKartuLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 658, Short.MAX_VALUE)
        );

        scrollKatalog.setViewportView(pnlListKartu);

        pnlDetail.setBackground(new java.awt.Color(73, 54, 40));

        lblDetailTitle.setBackground(new java.awt.Color(214, 192, 179));
        lblDetailTitle.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblDetailTitle.setForeground(new java.awt.Color(214, 192, 179));
        lblDetailTitle.setText("DETAIL LOKASI");

        lblDNama.setBackground(new java.awt.Color(214, 192, 179));
        lblDNama.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblDNama.setForeground(new java.awt.Color(214, 192, 179));
        lblDNama.setText("-");

        lblDBadge.setBackground(new java.awt.Color(160, 45, 62));
        lblDBadge.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblDBadge.setForeground(new java.awt.Color(255, 255, 255));
        lblDBadge.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDBadge.setText("PERLU TINDAK LANJUT");
        lblDBadge.setOpaque(true);

        lblDJenis.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDJenis.setForeground(new java.awt.Color(228, 224, 225));
        lblDJenis.setText("-");

        lblDStatus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDStatus.setForeground(new java.awt.Color(228, 224, 225));
        lblDStatus.setText("-");

        lblDMonTerakhir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDMonTerakhir.setForeground(new java.awt.Color(214, 192, 179));
        lblDMonTerakhir.setText("-");

        lblDHasil.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        lblDHasil.setForeground(new java.awt.Color(214, 192, 179));
        lblDHasil.setText("-");

        lblDPenanganan.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblDPenanganan.setForeground(new java.awt.Color(228, 224, 225));
        lblDPenanganan.setText("-");

        lblDTindakLanjut.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblDTindakLanjut.setForeground(new java.awt.Color(228, 224, 225));
        lblDTindakLanjut.setText("-");

        lblParameter.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblParameter.setForeground(new java.awt.Color(214, 192, 179));
        lblParameter.setText("PARAMETER PENGUKURAN TERAKHIR");

        tblParameter.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblParameter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parameter", "Nilai", "Hasil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblParameter.setRowHeight(25);
        scrollParameter.setViewportView(tblParameter);

        btnBuatMonitoring.setBackground(new java.awt.Color(209, 187, 158));
        btnBuatMonitoring.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnBuatMonitoring.setForeground(new java.awt.Color(255, 255, 255));
        btnBuatMonitoring.setText("Ajukan / Mulai Monitoring");
        btnBuatMonitoring.setFocusPainted(false);
        btnBuatMonitoring.addActionListener(this::btnBuatMonitoringActionPerformed);

        btnInformasikan.setBackground(new java.awt.Color(167, 146, 119));
        btnInformasikan.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnInformasikan.setForeground(new java.awt.Color(255, 255, 255));
        btnInformasikan.setText("Info Peringatan Manager");
        btnInformasikan.setFocusPainted(false);
        btnInformasikan.addActionListener(this::btnInformasikanActionPerformed);

        btnKelola.setBackground(new java.awt.Color(171, 136, 109));
        btnKelola.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnKelola.setForeground(new java.awt.Color(255, 255, 255));
        btnKelola.setText("Lihat / Kelola Pengukuran");
        btnKelola.setFocusPainted(false);
        btnKelola.addActionListener(this::btnKelolaActionPerformed);

        org.jdesktop.layout.GroupLayout pnlDetailLayout = new org.jdesktop.layout.GroupLayout(pnlDetail);
        pnlDetail.setLayout(pnlDetailLayout);
        pnlDetailLayout.setHorizontalGroup(
            pnlDetailLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDetailLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlDetailLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblDetailTitle, 10, 278, Short.MAX_VALUE)
                    .add(lblDNama, 10, 278, Short.MAX_VALUE)
                    .add(lblDBadge, 10, 278, Short.MAX_VALUE)
                    .add(lblDJenis, 10, 278, Short.MAX_VALUE)
                    .add(lblDStatus, 10, 278, Short.MAX_VALUE)
                    .add(lblDMonTerakhir, 10, 278, Short.MAX_VALUE)
                    .add(lblDHasil, 10, 278, Short.MAX_VALUE)
                    .add(lblDPenanganan, 10, 278, Short.MAX_VALUE)
                    .add(lblDTindakLanjut, 10, 278, Short.MAX_VALUE)
                    .add(lblParameter, 10, 278, Short.MAX_VALUE)
                    .add(scrollParameter, 10, 278, Short.MAX_VALUE)
                    .add(btnBuatMonitoring, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnInformasikan, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnKelola, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(16, 16, 16))
        );
        pnlDetailLayout.setVerticalGroup(
            pnlDetailLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlDetailLayout.createSequentialGroup()
                .add(14, 14, 14)
                .add(lblDetailTitle, 18, 18, 18)
                .add(6, 6, 6)
                .add(lblDNama, 24, 24, 24)
                .add(6, 6, 6)
                .add(lblDBadge, 22, 22, 22)
                .add(8, 8, 8)
                .add(lblDJenis, 18, 18, 18)
                .add(4, 4, 4)
                .add(lblDStatus, 18, 18, 18)
                .add(10, 10, 10)
                .add(lblDMonTerakhir, 18, 18, 18)
                .add(4, 4, 4)
                .add(lblDHasil, 20, 20, 20)
                .add(4, 4, 4)
                .add(lblDPenanganan, 18, 18, 18)
                .add(8, 8, 8)
                .add(lblDTindakLanjut, 48, 48, 48)
                .add(8, 8, 8)
                .add(lblParameter, 18, 18, 18)
                .add(5, 5, 5)
                .add(scrollParameter, 100, 160, 160)
                .add(12, 12, 12)
                .add(btnBuatMonitoring, 42, 42, 42)
                .add(8, 8, 8)
                .add(btnInformasikan, 42, 42, 42)
                .add(8, 8, 8)
                .add(btnKelola, 36, 36, 36)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .add(cmbFilterMonitoring, 180, 180, 180)
                    .add(layout.createSequentialGroup()
                        .add(scrollKatalog, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(8, 8, Short.MAX_VALUE)
                        .add(pnlDetail, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(pnlKpi0, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(pnlKpi1, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(pnlKpi2, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(lblTitle, 40, 40, 40)
                .add(2, 2, 2)
                .add(lblHint, 22, 22, 22)
                .add(8, 8, 8)
                .add(cmbFilterMonitoring, 32, 32, 32)
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlKpi0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(scrollKatalog, 200, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pnlDetail, 200, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private final java.util.List<model.Lokasi> lokasiList = new ArrayList<>();

    private final java.util.Map<Integer, java.util.List<model.MonitoringLingkungan>> riwayatPerLokasi = new LinkedHashMap<>();

    private model.Lokasi terpilih;



    private void refreshData() {

        lokasiList.clear();

        lokasiList.addAll(AppConfig.getMonitoringController().tampilkanSemuaLokasi());

        riwayatPerLokasi.clear();

        int peringatan = 0;

        int belum = 0;

        for (model.Lokasi l : lokasiList) {

            java.util.List<model.MonitoringLingkungan> riwayat =

                AppConfig.getMonitoringController().tampilkanMonitoringByLokasi(l.getIdLokasi());

            riwayatPerLokasi.put(l.getIdLokasi(), riwayat);

            model.MonitoringLingkungan akhir = riwayat.isEmpty() ? null : riwayat.get(0);

            if (akhir != null && akhir.getStatusMonitoring() != enums.StatusMonitoring.NORMAL) {

                peringatan++;

                if (akhir.getStatusPenanganan() != enums.StatusPenanganan.SELESAI)belum++;

            }

        }

        lblKpiValue0.setText(String.valueOf(lokasiList.size()));

        lblKpiValue1.setText(String.valueOf(peringatan));

        lblKpiValue2.setText(String.valueOf(belum));



        tampilkanKartu();
        if(!lokasiList.isEmpty())pilihLokasi(lokasiList.get(0));
    }
    private void cmbFilterMonitoringActionPerformed(java.awt.event.ActionEvent evt){tampilkanKartu();}
    private void tampilkanKartu() {
        if(pnlListKartu==null)return;
        pnlListKartu.removeAll();
        pnlListKartu.setLayout(new javax.swing.BoxLayout(pnlListKartu,javax.swing.BoxLayout.PAGE_AXIS));
        String filter= cmbFilterMonitoring==null||cmbFilterMonitoring.getSelectedItem()==null?"Semua Hasil":cmbFilterMonitoring.getSelectedItem().toString();
        for(model.Lokasi l:lokasiList) {
            java.util.List<model.MonitoringLingkungan> daftar=riwayatPerLokasi.get(l.getIdLokasi());
            model.MonitoringLingkungan akhir=daftar==null||daftar.isEmpty()?null:daftar.get(0);
            if("NORMAL".equals(filter)&&(akhir==null||akhir.getStatusMonitoring()!=enums.StatusMonitoring.NORMAL))continue;
            if("PERINGATAN".equals(filter)&&(akhir==null||akhir.getStatusMonitoring()!=enums.StatusMonitoring.PERINGATAN))continue;
            if("BERBAHAYA".equals(filter)&&(akhir==null||akhir.getStatusMonitoring()!=enums.StatusMonitoring.BERBAHAYA))continue;
            if("Belum Ada Monitoring".equals(filter)&&akhir!=null)continue;
            KartuLokasiPanel kartu=new KartuLokasiPanel();kartu.setData(l,akhir);
            pasangAksiKartu(kartu,()->pilihLokasi(l));pnlListKartu.add(kartu);
            pnlListKartu.add(javax.swing.Box.createVerticalStrut(10));
        }
        pnlListKartu.revalidate();pnlListKartu.repaint();
    }

    private void pasangAksiKartu(java.awt.Component komponen, Runnable aksi) {
        komponen.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        komponen.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override public void mouseClicked(java.awt.event.MouseEvent e) { aksi.run(); }
        });
        if (komponen instanceof java.awt.Container) {
            for (java.awt.Component child : ((java.awt.Container)komponen).getComponents()) {
                pasangAksiKartu(child, aksi);
            }
        }
    }

    private model.MonitoringLingkungan monitoringTerakhir(int idLokasi) {

        java.util.List<model.MonitoringLingkungan> riwayat = riwayatPerLokasi.get(idLokasi);

        return riwayat == null || riwayat.isEmpty() ? null : riwayat.get(0);

    }



    private void pilihLokasi(model.Lokasi l) {

        terpilih = l;

        model.MonitoringLingkungan akhir = monitoringTerakhir(l.getIdLokasi());

        String persetujuan=AppConfig.getMonitoringController().statusPermintaan(l.getIdLokasi());
        if("MENUNGGU".equals(persetujuan))btnBuatMonitoring.setText("Menunggu Persetujuan Manager");
        else if("DISETUJUI".equals(persetujuan))btnBuatMonitoring.setText("Mulai Monitoring (Disetujui)");
        else if("BERJALAN".equals(persetujuan))btnBuatMonitoring.setText("Monitoring Sedang Berjalan");
        else btnBuatMonitoring.setText("Ajukan Monitoring Lokasi Ini");
        lblDNama.setText(l.getNamaLokasi());
        javax.swing.table.DefaultTableModel parameterModel = (javax.swing.table.DefaultTableModel)tblParameter.getModel();
        parameterModel.setRowCount(0);
        if (akhir != null) {
            for (model.DetailMonitoring detail : akhir.getDetailMonitoring()) {
                parameterModel.addRow(new Object[]{
                    detail.getParameter().getNamaParameter(),
                    detail.getNilaiPengukuran() + " " + detail.getParameter().getSatuan(),
                    detail.getStatusDetail()
                });
            }
        }

        boolean pit = l.getJenisLokasi() == enums.JenisLokasi.PIT;

        lblDJenis.setText(pit ? "PIT - area penambangan" : "STOCKPILE - area penampungan material");

        lblDStatus.setText("Status operasional: " + l.getStatusOperasional());

        if (akhir == null) {

            lblDMonTerakhir.setText("Belum ada kegiatan monitoring");

            lblDHasil.setText("Hasil: belum ada data");

            lblDHasil.setForeground(new java.awt.Color(103, 121, 143));

            lblDPenanganan.setText("DISETUJUI".equals(persetujuan)?"Penanganan: BELUM DITANGANI":("MENUNGGU".equals(persetujuan)?"Menunggu persetujuan Manager":"Penanganan: -"));

            lblDTindakLanjut.setText("Tindak lanjut: -");

            lblDBadge.setVisible(false);

            btnInformasikan.setEnabled(false);
            btnKelola.setEnabled(false);

        } else {

            java.time.format.DateTimeFormatter fmt = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            lblDMonTerakhir.setText("Monitoring terakhir: "

                + (akhir.getTanggalMonitoring() == null ? "-" : akhir.getTanggalMonitoring().format(fmt)));

            boolean berbahaya = akhir.getStatusMonitoring() == enums.StatusMonitoring.BERBAHAYA;
            boolean peringatan = akhir.getStatusMonitoring() == enums.StatusMonitoring.PERINGATAN;

            lblDHasil.setText("Hasil: " + akhir.getStatusMonitoring());

            lblDHasil.setForeground(berbahaya ? new java.awt.Color(255, 80, 80)
                : peringatan ? new java.awt.Color(245, 170, 70)
                : new java.awt.Color(0, 255, 77));

            lblDPenanganan.setText("Penanganan: " + akhir.getStatusPenanganan());

            lblDTindakLanjut.setText("Tindak lanjut: "

                + (akhir.getTindakLanjut() == null || akhir.getTindakLanjut().trim().isEmpty() ? "-" : akhir.getTindakLanjut()));

            // BERBAHAYA tetap ditandai merah meskipun penanganan telah selesai.
            boolean perluTindak = berbahaya;

            lblDBadge.setVisible(perluTindak);

            btnInformasikan.setEnabled(perluTindak);
            btnKelola.setEnabled(true);

        }

    }



    private void btnBuatMonitoringActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if(terpilih==null)throw new IllegalArgumentException("Pilih lokasi yang akan dipantau.");
            int lokasi=terpilih.getIdLokasi();
            String status=AppConfig.getMonitoringController().statusPermintaan(lokasi);
            if("MENUNGGU".equals(status)) {
                JOptionPane.showMessageDialog(this,"Permintaan monitoring sedang menunggu persetujuan Manager.","Menunggu Persetujuan",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if("BERJALAN".equals(status)) {
                JOptionPane.showMessageDialog(this,"Kegiatan lokasi ini masih berlangsung. Selesaikan kegiatan terlebih dahulu.","Kegiatan Berlangsung",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if("DISETUJUI".equals(status)) {
                MonitoringFormFrame f=new MonitoringFormFrame();f.pilihLokasi(lokasi);f.setVisible(true);
                f.addWindowListener(new java.awt.event.WindowAdapter(){@Override public void windowClosed(java.awt.event.WindowEvent e){refreshData();}});
                return;
            }
            String alasan=JOptionPane.showInputDialog(this,"Jelaskan alasan monitoring untuk "+terpilih.getNamaLokasi()+":", "Ajukan Monitoring", JOptionPane.QUESTION_MESSAGE);
            if(alasan==null)return;
            if(JOptionPane.showConfirmDialog(this,"Kirim permintaan monitoring kepada Manager?","Kirim Permintaan",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)!=JOptionPane.YES_OPTION)return;
            AppConfig.getMonitoringController().ajukanMonitoring(lokasi,alasan);
            JOptionPane.showMessageDialog(this,"Permintaan terkirim. Anda dapat memulai monitoring setelah Manager menyetujuinya.","Berhasil",JOptionPane.INFORMATION_MESSAGE);
            refreshData();
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    private void btnInformasikanActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if(terpilih==null)throw new IllegalArgumentException("Pilih lokasi terlebih dahulu.");
            model.MonitoringLingkungan akhir=monitoringTerakhir(terpilih.getIdLokasi());
            if(akhir==null||akhir.getStatusMonitoring()==enums.StatusMonitoring.NORMAL){
                JOptionPane.showMessageDialog(this,"Belum ada peringatan untuk lokasi ini.");return;
            }
            JOptionPane.showMessageDialog(this,"Hasil pengukuran yang melewati ambang batas sudah masuk ke daftar peringatan Manager.\n"+
                "Manager dapat melihat detail hasil pengukuran dan prioritas lokasi.","Informasi Peringatan",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    private void btnKelolaActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (terpilih == null) throw new IllegalArgumentException("Pilih lokasi terlebih dahulu.");
            model.MonitoringLingkungan mon = monitoringTerakhir(terpilih.getIdLokasi());
            if (mon == null) throw new IllegalArgumentException("Lokasi ini belum memiliki kegiatan monitoring.");
            MonitoringDetailFrame f = new MonitoringDetailFrame(mon.getIdMonitoring(), false);
            f.setVisible(true);
            f.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override public void windowClosed(java.awt.event.WindowEvent e) { refreshData(); }
            });
        } catch(Exception ex) { FormUtil.error(this, ex); }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuatMonitoring;
    private javax.swing.JButton btnInformasikan;
    private javax.swing.JButton btnKelola;
    private javax.swing.JComboBox cmbFilterMonitoring;
    private javax.swing.JLabel lblDBadge;
    private javax.swing.JLabel lblDHasil;
    private javax.swing.JLabel lblDJenis;
    private javax.swing.JLabel lblDMonTerakhir;
    private javax.swing.JLabel lblDNama;
    private javax.swing.JLabel lblDPenanganan;
    private javax.swing.JLabel lblDStatus;
    private javax.swing.JLabel lblDTindakLanjut;
    private javax.swing.JLabel lblDetailTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblKpiSub0;
    private javax.swing.JLabel lblKpiSub1;
    private javax.swing.JLabel lblKpiSub2;
    private javax.swing.JLabel lblKpiTitle0;
    private javax.swing.JLabel lblKpiTitle1;
    private javax.swing.JLabel lblKpiTitle2;
    private javax.swing.JLabel lblKpiValue0;
    private javax.swing.JLabel lblKpiValue1;
    private javax.swing.JLabel lblKpiValue2;
    private javax.swing.JLabel lblParameter;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlDetail;
    private javax.swing.JPanel pnlKpi0;
    private javax.swing.JPanel pnlKpi1;
    private javax.swing.JPanel pnlKpi2;
    private javax.swing.JPanel pnlListKartu;
    private javax.swing.JScrollPane scrollKatalog;
    private javax.swing.JScrollPane scrollParameter;
    private javax.swing.JTable tblParameter;
    // End of variables declaration//GEN-END:variables
}
