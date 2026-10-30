package view;
import config.AppConfig;
import controller.*;
import model.*;
import enums.*;
import java.time.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DashboardAdminPanel extends javax.swing.JPanel {
    private void refreshDashboard(){
        try{
            java.util.List<String> labels=new java.util.ArrayList<>();
            java.util.List<Double> values=new java.util.ArrayList<>();
            java.util.List<Pegawai> list=AppConfig.getPegawaiRepository().findAll();
            lblKpiValue0.setText(""+list.size());
            lblKpiValue1.setText(""+AppConfig.getLokasiRepository().findAll().size());
            lblKpiValue2.setText(""+AppConfig.getKendaraanRepository().findAll().size());
            for(Pegawai p:list){String k=p.getJenisPegawai();int i=labels.indexOf(k);if(i<0){labels.add(k);values.add(1.0);}else values.set(i,values.get(i)+1);}
            double max=1;for(Double d:values)max=Math.max(max,d);
            javax.swing.JLabel[] names={lblBar0,lblBar1,lblBar2};
            javax.swing.JLabel[] nums={lblBarValue0,lblBarValue1,lblBarValue2};
            javax.swing.JProgressBar[] bars={bar0,bar1,bar2};
            for(int i=0;i<3;i++){
                if(i<labels.size()){
                    names[i].setText(labels.get(i));nums[i].setText(String.format("%.1f",values.get(i)));
                    bars[i].setValue((int)Math.round(values.get(i)*100/max));
                }else{names[i].setText("-");nums[i].setText("-");bars[i].setValue(0);}
            }
        }catch(Exception ex){lblDesc.setText("Data belum dapat dimuat: "+ex.getMessage());}
    }

    public DashboardAdminPanel() {
        initComponents();
        refreshDashboard();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblTitle = new javax.swing.JLabel();
        lblHint = new javax.swing.JLabel();
        lblKpiTitle0 = new javax.swing.JLabel();
        lblKpiValue0 = new javax.swing.JLabel();
        lblKpiTitle1 = new javax.swing.JLabel();
        lblKpiValue1 = new javax.swing.JLabel();
        lblKpiTitle2 = new javax.swing.JLabel();
        lblKpiValue2 = new javax.swing.JLabel();
        lblChart = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        lblBar0 = new javax.swing.JLabel();
        bar0 = new javax.swing.JProgressBar();
        lblBarValue0 = new javax.swing.JLabel();
        lblBar1 = new javax.swing.JLabel();
        bar1 = new javax.swing.JProgressBar();
        lblBarValue1 = new javax.swing.JLabel();
        lblBar2 = new javax.swing.JLabel();
        bar2 = new javax.swing.JProgressBar();
        lblBarValue2 = new javax.swing.JLabel();

        lblTitle.setForeground(new java.awt.Color(26, 43, 66));
        lblTitle.setText("Dashboard Administrator");
        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 23));
        lblHint.setForeground(new java.awt.Color(103, 121, 143));
        lblHint.setText("Ringkasan ketersediaan data master");
        lblHint.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblKpiTitle0.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle0.setText("PEGAWAI");
        lblKpiTitle0.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblKpiValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue0.setText("0");
        lblKpiValue0.setFont(new java.awt.Font("SansSerif", 1, 32));
        lblKpiTitle1.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle1.setText("LOKASI");
        lblKpiTitle1.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblKpiValue1.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue1.setText("0");
        lblKpiValue1.setFont(new java.awt.Font("SansSerif", 1, 32));
        lblKpiTitle2.setForeground(new java.awt.Color(103, 121, 143));
        lblKpiTitle2.setText("KENDARAAN");
        lblKpiTitle2.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblKpiValue2.setForeground(new java.awt.Color(26, 43, 66));
        lblKpiValue2.setText("0");
        lblKpiValue2.setFont(new java.awt.Font("SansSerif", 1, 32));
        lblChart.setForeground(new java.awt.Color(26, 43, 66));
        lblChart.setText("DISTRIBUSI DATA  /  INDIKATOR");
        lblChart.setFont(new java.awt.Font("SansSerif", 1, 17));
        lblDesc.setForeground(new java.awt.Color(103, 121, 143));
        lblDesc.setText("Perbandingan berdasarkan data aktual yang tercatat.");
        lblDesc.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblBar0.setForeground(new java.awt.Color(26, 43, 66));
        lblBar0.setText("Kategori 1");
        lblBar0.setFont(new java.awt.Font("SansSerif", 1, 12));
        bar0.setBackground(new java.awt.Color(255, 255, 255));
        lblBarValue0.setForeground(new java.awt.Color(26, 43, 66));
        lblBarValue0.setText("0");
        lblBarValue0.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblBar1.setForeground(new java.awt.Color(26, 43, 66));
        lblBar1.setText("Kategori 2");
        lblBar1.setFont(new java.awt.Font("SansSerif", 1, 12));
        bar1.setBackground(new java.awt.Color(255, 255, 255));
        lblBarValue1.setForeground(new java.awt.Color(26, 43, 66));
        lblBarValue1.setText("0");
        lblBarValue1.setFont(new java.awt.Font("SansSerif", 1, 12));
        lblBar2.setForeground(new java.awt.Color(26, 43, 66));
        lblBar2.setText("Kategori 3");
        lblBar2.setFont(new java.awt.Font("SansSerif", 1, 12));
        bar2.setBackground(new java.awt.Color(255, 255, 255));
        lblBarValue2.setForeground(new java.awt.Color(26, 43, 66));
        lblBarValue2.setText("0");
        lblBarValue2.setFont(new java.awt.Font("SansSerif", 1, 12));

        javax.swing.GroupLayout thisLayout = new javax.swing.GroupLayout(this);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblTitle, 810, 810, 810))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblHint, 810, 810, 810))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblKpiTitle0, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblKpiValue0, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(314).addComponent(lblKpiTitle1, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(314).addComponent(lblKpiValue1, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(604).addComponent(lblKpiTitle2, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(604).addComponent(lblKpiValue2, 275, 275, 275))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblChart, 820, 820, 820))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblDesc, 830, 830, 830))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblBar0, 200, 200, 200))
                .addGroup(thisLayout.createSequentialGroup().addGap(227).addComponent(bar0, 565, 565, 565))
                .addGroup(thisLayout.createSequentialGroup().addGap(801).addComponent(lblBarValue0, 70, 70, 70))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblBar1, 200, 200, 200))
                .addGroup(thisLayout.createSequentialGroup().addGap(227).addComponent(bar1, 565, 565, 565))
                .addGroup(thisLayout.createSequentialGroup().addGap(801).addComponent(lblBarValue1, 70, 70, 70))
                .addGroup(thisLayout.createSequentialGroup().addGap(24).addComponent(lblBar2, 200, 200, 200))
                .addGroup(thisLayout.createSequentialGroup().addGap(227).addComponent(bar2, 565, 565, 565))
                .addGroup(thisLayout.createSequentialGroup().addGap(801).addComponent(lblBarValue2, 70, 70, 70))
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(thisLayout.createSequentialGroup().addGap(18).addComponent(lblTitle, 42, 42, 42))
                .addGroup(thisLayout.createSequentialGroup().addGap(62).addComponent(lblHint, 25, 25, 25))
                .addGroup(thisLayout.createSequentialGroup().addGap(116).addComponent(lblKpiTitle0, 26, 26, 26))
                .addGroup(thisLayout.createSequentialGroup().addGap(147).addComponent(lblKpiValue0, 70, 70, 70))
                .addGroup(thisLayout.createSequentialGroup().addGap(116).addComponent(lblKpiTitle1, 26, 26, 26))
                .addGroup(thisLayout.createSequentialGroup().addGap(147).addComponent(lblKpiValue1, 70, 70, 70))
                .addGroup(thisLayout.createSequentialGroup().addGap(116).addComponent(lblKpiTitle2, 26, 26, 26))
                .addGroup(thisLayout.createSequentialGroup().addGap(147).addComponent(lblKpiValue2, 70, 70, 70))
                .addGroup(thisLayout.createSequentialGroup().addGap(251).addComponent(lblChart, 36, 36, 36))
                .addGroup(thisLayout.createSequentialGroup().addGap(289).addComponent(lblDesc, 24, 24, 24))
                .addGroup(thisLayout.createSequentialGroup().addGap(337).addComponent(lblBar0, 28, 28, 28))
                .addGroup(thisLayout.createSequentialGroup().addGap(339).addComponent(bar0, 27, 27, 27))
                .addGroup(thisLayout.createSequentialGroup().addGap(337).addComponent(lblBarValue0, 28, 28, 28))
                .addGroup(thisLayout.createSequentialGroup().addGap(397).addComponent(lblBar1, 28, 28, 28))
                .addGroup(thisLayout.createSequentialGroup().addGap(399).addComponent(bar1, 27, 27, 27))
                .addGroup(thisLayout.createSequentialGroup().addGap(397).addComponent(lblBarValue1, 28, 28, 28))
                .addGroup(thisLayout.createSequentialGroup().addGap(457).addComponent(lblBar2, 28, 28, 28))
                .addGroup(thisLayout.createSequentialGroup().addGap(459).addComponent(bar2, 27, 27, 27))
                .addGroup(thisLayout.createSequentialGroup().addGap(457).addComponent(lblBarValue2, 28, 28, 28))
        );
    }//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblKpiTitle0;
    private javax.swing.JLabel lblKpiValue0;
    private javax.swing.JLabel lblKpiTitle1;
    private javax.swing.JLabel lblKpiValue1;
    private javax.swing.JLabel lblKpiTitle2;
    private javax.swing.JLabel lblKpiValue2;
    private javax.swing.JLabel lblChart;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblBar0;
    private javax.swing.JProgressBar bar0;
    private javax.swing.JLabel lblBarValue0;
    private javax.swing.JLabel lblBar1;
    private javax.swing.JProgressBar bar1;
    private javax.swing.JLabel lblBarValue1;
    private javax.swing.JLabel lblBar2;
    private javax.swing.JProgressBar bar2;
    private javax.swing.JLabel lblBarValue2;
    // End of variables declaration//GEN-END:variables
}
