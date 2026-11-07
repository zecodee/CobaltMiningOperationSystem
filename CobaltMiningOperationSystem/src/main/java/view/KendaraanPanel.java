package view;

import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/** Halaman kendaraan dengan filter status dan soft delete. */
public class KendaraanPanel extends javax.swing.JPanel {

    public KendaraanPanel() {
        initComponents();
        JButton[] navButtons = {btnAdd, btnEdit, btnDelete};

        for (JButton btn : navButtons) {
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            btn.setBorderPainted(false);
        }

        cmbStatus.addActionListener(e -> terapkanFilter());
        txtCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
    public void insertUpdate(javax.swing.event.DocumentEvent e) { terapkanFilter(); }
    public void removeUpdate(javax.swing.event.DocumentEvent e) { terapkanFilter(); }
    public void changedUpdate(javax.swing.event.DocumentEvent e) { terapkanFilter(); }
});
        try { refreshData(); } catch (Exception ex) { FormUtil.error(this, ex); }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
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
        pnlFilter = new javax.swing.JPanel();
        lblCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        scrollTable = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setBackground(new java.awt.Color(214, 192, 179));

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Kendaraan");

        lblSubtitle.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(103, 121, 143));
        lblSubtitle.setText("Armada kendaraan operasional");

        btnAdd.setBackground(new java.awt.Color(43, 106, 230));
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Tambah Data");
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnEdit.setBackground(new java.awt.Color(26, 43, 66));
        btnEdit.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Ubah Data");
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnDelete.setBackground(new java.awt.Color(160, 45, 62));
        btnDelete.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Hapus Data");
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        pnlKpi0.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle0.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle0.setText("ARMADA KENDARAAN");

        lblKpiValue0.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue0.setText("-");

        lblKpiSub0.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub0.setText("kendaraan operasional");

        org.jdesktop.layout.GroupLayout pnlKpi0Layout = new org.jdesktop.layout.GroupLayout(pnlKpi0);
        pnlKpi0.setLayout(pnlKpi0Layout);
        pnlKpi0Layout.setHorizontalGroup(
            pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi0Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi0Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle0, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiValue0, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiSub0, 10, 225, Short.MAX_VALUE)))
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
        lblKpiTitle1.setText("TERSEDIA");

        lblKpiValue1.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue1.setForeground(new java.awt.Color(46, 125, 70));
        lblKpiValue1.setText("-");

        lblKpiSub1.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub1.setText("siap ditugaskan");

        org.jdesktop.layout.GroupLayout pnlKpi1Layout = new org.jdesktop.layout.GroupLayout(pnlKpi1);
        pnlKpi1.setLayout(pnlKpi1Layout);
        pnlKpi1Layout.setHorizontalGroup(
            pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi1Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle1, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiValue1, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiSub1, 10, 225, Short.MAX_VALUE)))
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
        lblKpiTitle2.setText("DIGUNAKAN");

        lblKpiValue2.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue2.setForeground(new java.awt.Color(43, 106, 230));
        lblKpiValue2.setText("-");

        lblKpiSub2.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub2.setText("sedang bertugas");

        org.jdesktop.layout.GroupLayout pnlKpi2Layout = new org.jdesktop.layout.GroupLayout(pnlKpi2);
        pnlKpi2.setLayout(pnlKpi2Layout);
        pnlKpi2Layout.setHorizontalGroup(
            pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi2Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle2, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiValue2, 10, 225, Short.MAX_VALUE)
                    .add(lblKpiSub2, 10, 225, Short.MAX_VALUE)))
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

        pnlKpi3.setBackground(new java.awt.Color(234, 216, 192));

        lblKpiTitle3.setFont(new java.awt.Font("SansSerif", 1, 11)); // NOI18N
        lblKpiTitle3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle3.setText("NONAKTIF");

        lblKpiValue3.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblKpiValue3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiValue3.setText("-");

        lblKpiSub3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblKpiSub3.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiSub3.setText("tidak aktif lagi");

        org.jdesktop.layout.GroupLayout pnlKpi3Layout = new org.jdesktop.layout.GroupLayout(pnlKpi3);
        pnlKpi3.setLayout(pnlKpi3Layout);
        pnlKpi3Layout.setHorizontalGroup(
            pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlKpi3Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlKpi3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblKpiTitle3, 10, 227, Short.MAX_VALUE)
                    .add(lblKpiValue3, 10, 227, Short.MAX_VALUE)
                    .add(lblKpiSub3, 10, 227, Short.MAX_VALUE)))
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
                .add(12, 13, Short.MAX_VALUE))
        );

        pnlFilter.setBackground(new java.awt.Color(234, 216, 192));

        lblCari.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblCari.setForeground(new java.awt.Color(26, 43, 66));
        lblCari.setText("Cari");

        txtCari.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N

        lblStatus.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(26, 43, 66));
        lblStatus.setText("Status");

        cmbStatus.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua Status", "TERSEDIA", "DIGUNAKAN", "NONAKTIF" }));

        org.jdesktop.layout.GroupLayout pnlFilterLayout = new org.jdesktop.layout.GroupLayout(pnlFilter);
        pnlFilter.setLayout(pnlFilterLayout);
        pnlFilterLayout.setHorizontalGroup(
            pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFilterLayout.createSequentialGroup()
                .add(20, 20, 20)
                .add(lblCari, 40, 40, 40)
                .add(20, 20, 20)
                .add(txtCari, 210, 210, 210)
                .add(20, 20, 20)
                .add(lblStatus, 50, 50, 50)
                .add(20, 20, 20)
                .add(cmbStatus, 140, 140, 140)
                .add(20, 20, 20))
        );
        pnlFilterLayout.setVerticalGroup(
            pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pnlFilterLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(pnlFilterLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(lblCari, 32, 32, 32)
                    .add(txtCari, 30, 30, 30)
                    .add(lblStatus, 32, 32, 32)
                    .add(cmbStatus, 30, 30, 30))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scrollTable.setBackground(new java.awt.Color(255, 255, 255));

        tblData.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        tblData.setRowHeight(28);
        tblData.setGridColor(new java.awt.Color(226, 232, 240));
        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Jenis", "No Polisi", "Kapasitas", "Tahun", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTable.setViewportView(tblData);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(36, 36, 36)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlFilter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(lblTitle, 10, 580, Short.MAX_VALUE)
                                    .add(lblSubtitle, 10, 580, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnAdd, 140, 140, 140)
                                .add(8, 8, 8)
                                .add(btnEdit, 120, 120, 120)
                                .add(8, 8, 8)
                                .add(btnDelete, 140, 140, 140))
                            .add(scrollTable, 10, 868, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(pnlKpi0, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(pnlKpi1, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(pnlKpi2, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(pnlKpi3, 10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .add(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(lblTitle, 40, 40, 40)
                        .add(2, 2, 2)
                        .add(lblSubtitle, 22, 22, 22))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(btnAdd, 42, 42, 42)
                        .add(btnEdit, 42, 42, 42)
                        .add(btnDelete, 42, 42, 42)))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(pnlKpi0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(pnlKpi1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(pnlFilter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(12, 12, 12)
                .add(scrollTable, 540, 548, Short.MAX_VALUE)
                .add(16, 16, 16))
        );
    }// </editor-fold>//GEN-END:initComponents

    private final java.util.List<model.Kendaraan> records = new ArrayList<>();

    private javax.swing.table.TableRowSorter<DefaultTableModel> sorter;



    private void refreshData() {

        records.clear();

        records.addAll(AppConfig.getMasterDataController().tampilkanSemuaKendaraan());

        DefaultTableModel model = new DefaultTableModel(

            new String[]{"No.", "Jenis", "No Polisi", "Kapasitas", "Tahun", "Status"}, 0) {

            @Override public boolean isCellEditable(int r, int c) { return false; }

        };

        for (model.Kendaraan k : records) {

            model.addRow(new Object[]{model.getRowCount() + 1, k.getJenisKendaraan(),

                k.getNomorPolisi(), k.getKapasitas(), k.getTahunKendaraan(), k.getStatusKendaraan()});

        }

        tblData.setModel(model);

        sorter = new javax.swing.table.TableRowSorter<>(model);

        tblData.setRowSorter(sorter);

        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        FormUtil.nomorUrut(tblData);

        muatKpi();

        terapkanFilter();

    }



    private void muatKpi() {

        int[] k = AppConfig.getMasterDataController().ringkasanKendaraan();

        lblKpiValue0.setText(String.valueOf(k[0]));

        lblKpiValue1.setText(String.valueOf(k[1]));

        lblKpiValue2.setText(String.valueOf(k[2]));

        lblKpiValue3.setText(String.valueOf(k[3]));

    }



    private void terapkanFilter() {

        if (sorter == null)return;

        java.util.List<javax.swing.RowFilter<Object, Object>> aturan = new ArrayList<>();

        String kata = txtCari.getText().trim();

        if (!kata.isEmpty())aturan.add(javax.swing.RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(kata), 1, 2));

        int pilihStatus = cmbStatus.getSelectedIndex();

        if (pilihStatus > 0)aturan.add(javax.swing.RowFilter.regexFilter("^" + java.util.regex.Pattern.quote(String.valueOf(cmbStatus.getSelectedItem())) + "$", 5));

        sorter.setRowFilter(aturan.isEmpty() ? null : javax.swing.RowFilter.andFilter(aturan));

    }



    private model.Kendaraan selected() {

        int row = tblData.getSelectedRow();

        if (row < 0)throw new IllegalArgumentException("Pilih satu baris data terlebih dahulu.");

        return records.get(tblData.convertRowIndexToModel(row));

    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            KendaraanFormFrame f = new KendaraanFormFrame();

            f.setVisible(true);

            f.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override public void windowClosed(java.awt.event.WindowEvent e) { if (f.isSaved())refreshData(); }

            });

        } catch (Exception ex) { FormUtil.error(this, ex); }

    }



    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            KendaraanFormFrame f = new KendaraanFormFrame(selected());

            f.setVisible(true);

            f.addWindowListener(new java.awt.event.WindowAdapter() {

                @Override public void windowClosed(java.awt.event.WindowEvent e) { if (f.isSaved())refreshData(); }

            });

        } catch (Exception ex) { FormUtil.error(this, ex); }

    }



    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            model.Kendaraan item = selected();

            if (JOptionPane.showConfirmDialog(this,

                "Hapus kendaraan " + item.getNomorPolisi() + "?\nKendaraan disembunyikan dari daftar (soft delete); "

                + "riwayat pengangkutan tetap tersimpan.",

                "Nonaktifkan Kendaraan", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION)return;

            AppConfig.getMasterDataController().hapusKendaraan(item.getIdKendaraan());

            JOptionPane.showMessageDialog(this, "Kendaraan berhasil dinonaktifkan. Riwayat pengangkutan tetap tersimpan.");

            refreshData();

        } catch (Exception ex) { FormUtil.error(this, ex); }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel lblCari;
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
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlFilter;
    private javax.swing.JPanel pnlKpi0;
    private javax.swing.JPanel pnlKpi1;
    private javax.swing.JPanel pnlKpi2;
    private javax.swing.JPanel pnlKpi3;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
