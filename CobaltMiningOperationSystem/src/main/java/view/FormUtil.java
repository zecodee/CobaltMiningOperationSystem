package view;
import javax.swing.*;
import java.util.*;
public final class FormUtil {
    private FormUtil() {}
    public static String text(JTextField field) { return field.getText().trim(); }
    public static int id(JComboBox<PilihanData> box) {
        PilihanData p=(PilihanData)box.getSelectedItem();
        if (p==null) throw new IllegalArgumentException("Pilih data terlebih dahulu.");
        return p.id;
    }
    public static void select(JComboBox<PilihanData> box, int id) {
        for (int i=0;i<box.getItemCount();i++) if(box.getItemAt(i).id==id) {box.setSelectedIndex(i);return;}
    }
    public static void require(String value, String label) {
        if(value==null||value.trim().isEmpty()) throw new IllegalArgumentException(label+" wajib diisi.");
    }
    public static void error(java.awt.Component parent,Exception e) {
        JOptionPane.showMessageDialog(parent,e.getMessage(),"C-MOS / Validasi",JOptionPane.ERROR_MESSAGE);
    }
}
