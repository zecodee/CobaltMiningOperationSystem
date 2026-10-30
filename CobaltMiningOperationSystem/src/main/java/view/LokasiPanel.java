package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LokasiPanel extends javax.swing.JPanel {
    private final DataScreen screen=new DataScreen("Lokasi");
    private final java.util.List<Lokasi> records=new java.util.ArrayList<>();

    public LokasiPanel() {
        initComponents();
        try { refreshData(); } catch(Exception ex) { FormUtil.error(this,ex); }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        scrollTable = new javax.swing.JScrollPane();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Lokasi");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 22));
        lblSubtitle.setForeground(new java.awt.Color(103, 121, 143));
        lblSubtitle.setText("C-MOS / Lokasi");
        lblSubtitle.setFont(new java.awt.Font("SansSerif", 1, 12));
        scrollTable.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setBackground(new java.awt.Color(43, 106, 230));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Tambah Data");
        btnAdd.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnAdd.setFocusPainted(false);
        btnEdit.setBackground(new java.awt.Color(26, 43, 66));
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Ubah Data");
        btnEdit.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnEdit.setFocusPainted(false);
        btnDelete.setBackground(new java.awt.Color(160, 45, 62));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Hapus Data");
        btnDelete.setFont(new java.awt.Font("SansSerif", 1, 12));
        btnDelete.setFocusPainted(false);
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
        btnAdd.addActionListener(this::btnAddActionPerformed);
        btnEdit.addActionListener(this::btnEditActionPerformed);
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        javax.swing.GroupLayout thisLayout = new javax.swing.GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(lblTitle, 800, 800, 800))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(lblSubtitle, 840, 840, 840))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(scrollTable, 865, 865, 865))
                .addGroup(thisLayout.createSequentialGroup().addGap(20).addComponent(btnAdd, 155, 155, 155))
                .addGroup(thisLayout.createSequentialGroup().addGap(185).addComponent(btnEdit, 155, 155, 155))
                .addGroup(thisLayout.createSequentialGroup().addGap(350).addComponent(btnDelete, 155, 155, 155))
                .addGroup(thisLayout.createSequentialGroup().addGap(730).addComponent(btnRefresh, 155, 155, 155))
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(14).addComponent(lblTitle, 42, 42, 42))
                .addGroup(thisLayout.createSequentialGroup().addGap(55).addComponent(lblSubtitle, 25, 25, 25))
                .addGroup(thisLayout.createSequentialGroup().addGap(150).addComponent(scrollTable, 370, 370, 370))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnAdd, 40, 40, 40))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnEdit, 40, 40, 40))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnDelete, 40, 40, 40))
                .addGroup(thisLayout.createSequentialGroup().addGap(94).addComponent(btnRefresh, 40, 40, 40))
        );
    }//GEN-END:initComponents

    private void refreshData() {
        records.clear();records.addAll(AppConfig.getMasterDataController().tampilkanSemuaLokasi());
        screen.handle("Refresh",tblData,this);
    }
    private Lokasi selected() {
        int row=tblData.getSelectedRow();
        if(row<0)throw new IllegalArgumentException("Pilih satu baris data terlebih dahulu.");
        return records.get(tblData.convertRowIndexToModel(row));
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {
        try{refreshData();}catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            LokasiFormFrame f=new LokasiFormFrame();
            f.setVisible(true);
            f.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override public void windowClosed(java.awt.event.WindowEvent e){if(f.isSaved())refreshData();}
            });
        }catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            LokasiFormFrame f=new LokasiFormFrame(selected());
            f.setVisible(true);
            f.addWindowListener(new java.awt.event.WindowAdapter(){
                @Override public void windowClosed(java.awt.event.WindowEvent e){if(f.isSaved())refreshData();}
            });
        }catch(Exception ex){FormUtil.error(this,ex);}
    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Lokasi item=selected();
            if(JOptionPane.showConfirmDialog(this,"Hapus data terpilih?","Konfirmasi",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;
            AppConfig.getMasterDataController().hapusLokasi(item.getIdLokasi());
            refreshData();
        }catch(Exception ex){FormUtil.error(this,ex);}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables
}
