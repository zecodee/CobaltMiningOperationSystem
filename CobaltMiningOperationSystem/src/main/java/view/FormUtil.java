package view;
import javax.swing.*;
import java.util.*;
public final class FormUtil {
    private FormUtil() {}
    public static String text(JTextField field) { return field.getText().trim(); }
    public static int id(JComboBox<PilihanData> box) {
        Object value=box.getSelectedItem();
        PilihanData p=value instanceof PilihanData ? (PilihanData)value : null;
        if (p==null) throw new IllegalArgumentException("Pilih data terlebih dahulu.");
        return p.id;
    }
    public static void select(JComboBox<PilihanData> box, int id) {
        for (int i=0;i<box.getItemCount();i++) if(box.getItemAt(i).id==id) {box.setSelectedIndex(i);return;}
    }
    public static void require(String value, String label) {
        if(value==null||value.trim().isEmpty()) throw new IllegalArgumentException(label+" wajib diisi.");
    }
    /** Angka urut mengikuti tampilan setelah pencarian, filter, dan pengurutan. */
    public static void nomorUrut(javax.swing.JTable table) {
        if (table.getColumnCount() == 0) return;
        javax.swing.table.DefaultTableCellRenderer renderer = new javax.swing.table.DefaultTableCellRenderer() {
            @Override public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object value,
                    boolean selected, boolean focus, int row, int column) {
                super.getTableCellRendererComponent(t, row + 1, selected, focus, row, column);
                setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(0).setCellRenderer(renderer);
        table.getColumnModel().getColumn(0).setMinWidth(48);
        table.getColumnModel().getColumn(0).setMaxWidth(72);
        table.getColumnModel().getColumn(0).setPreferredWidth(56);
    }
    public static void error(java.awt.Component parent,Exception e) {
        String pesan=e.getMessage();
        if(pesan==null||pesan.trim().isEmpty())pesan="Terjadi kendala. Silakan coba kembali.";
        if(e instanceof java.sql.SQLException || pesan.contains("SQLException") || pesan.contains("Communications link failure") || pesan.contains("java.sql."))
            pesan="Data belum dapat diproses. Periksa koneksi database lalu coba kembali.";
        JOptionPane.showMessageDialog(parent,pesan,"Periksa Data",JOptionPane.ERROR_MESSAGE);
    }
}
