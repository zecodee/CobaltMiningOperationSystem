package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LaporanProduksiPanel extends javax.swing.JPanel {
    private final DataScreen screen=new DataScreen("LaporanProduksi");
    private final java.util.List<ProduksiTambang> records=new java.util.ArrayList<>();

    public LaporanProduksiPanel() {
        initComponents();
        try { refreshData(); } catch(Exception ex) { FormUtil.error(this,ex); }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        scrollTable = new javax.swing.JScrollPane();
        btnDetail = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Laporan Produksi");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblSubtitle.setForeground(new java.awt.Color(103, 121, 143));
        lblSubtitle.setText("C-MOS / LaporanProduksi");
        lblSubtitle.setFont(new java.awt.Font("SansSerif", 1, 12));
        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        btnDetail.setBackground(new java.awt.Color(43, 106, 230));
        btnDetail.setForeground(new java.awt.Color(255, 255, 255));
        btnDetail.setText("Lihat Detail");
        btnDetail.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnDetail.setFocusPainted(false);
        btnRefresh.setBackground(new java.awt.Color(26, 43, 66));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Muat Ulang");
        btnRefresh.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnRefresh.setFocusPainted(false);
        tblData = new javax.swing.JTable();
        tblData.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},new String[]{"Data"}));
        tblData.setRowHeight(28);
        tblData.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollTable.setViewportView(tblData);
        btnDetail.addActionListener(this::btnDetailActionPerformed);
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        javax.swing.GroupLayout thisLayout = new javax.swing.GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(lblTitle, 800, 800, 800))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(lblSubtitle, 840, 840, 840))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(scrollTable, 865, 865, 865))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(btnDetail, 156, 156, 156))
                .addGroup(thisLayout.createSequentialGroup().addGap(730).addComponent(btnRefresh, 155, 155, 155))
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(14).addComponent(lblTitle, 42, 42, 42))
                .addGroup(thisLayout.createSequentialGroup().addGap(55).addComponent(lblSubtitle, 25, 25, 25))
                .addGroup(thisLayout.createSequentialGroup().addGap(150).addComponent(scrollTable, 370, 370, 370))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnDetail, 40, 40, 40))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnRefresh, 40, 40, 40))
        );
    }//GEN-END:initComponents

    private void refreshData() {
        records.clear();records.addAll(AppConfig.getProduksiRepository().findAll());
        screen.handle("Refresh",tblData,this);
    }
    private ProduksiTambang selected() {
        int row=tblData.getSelectedRow();
        if(row<0)throw new IllegalArgumentException("Pilih satu baris data terlebih dahulu.");
        return records.get(tblData.convertRowIndexToModel(row));
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        try{refreshData();}catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {
        try { JOptionPane.showMessageDialog(this,"Data laporan terpilih: "+selected(),"Detail Laporan",JOptionPane.INFORMATION_MESSAGE); }
        catch(Exception ex){FormUtil.error(this,ex);}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
