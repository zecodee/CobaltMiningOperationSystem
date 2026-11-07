package view;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
/** Pencarian pada pilihan data tanpa mengganti komponen GUI Builder. */
public final class SearchableCombo {
    private SearchableCombo() {}
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void install(final JComboBox combo) {
        final java.util.List<Object> all = new ArrayList<>();
        for (int i=0;i<combo.getItemCount();i++) all.add(combo.getItemAt(i));
        combo.setEditable(true);
        final JTextComponent input = (JTextComponent)combo.getEditor().getEditorComponent();
        final boolean[] busy={false};
        input.getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent e){refresh();}
            public void removeUpdate(DocumentEvent e){refresh();}
            public void changedUpdate(DocumentEvent e){refresh();}
            private void refresh(){
                if(busy[0])return;
                SwingUtilities.invokeLater(()->{
                    if(busy[0] || !input.isFocusOwner())return;
                    String query=input.getText();
                    int caret=input.getCaretPosition();
                    busy[0]=true;
                    try {
                        DefaultComboBoxModel model=new DefaultComboBoxModel();
                        for(Object item:all)if(String.valueOf(item).toLowerCase(java.util.Locale.ROOT).contains(query.toLowerCase(java.util.Locale.ROOT)))model.addElement(item);
                        combo.setModel(model);
                        combo.setSelectedItem(null);
                        input.setText(query);
                        input.setCaretPosition(Math.min(caret,input.getDocument().getLength()));
                        if(combo.isShowing() && model.getSize()>0)combo.showPopup();
                        else combo.hidePopup();
                    }finally{busy[0]=false;}
                });
            }
        });
        combo.addActionListener(e->{
            if(busy[0])return;
            Object chosen=combo.getSelectedItem();
            if(chosen instanceof PilihanData){
                busy[0]=true;
                try {
                    DefaultComboBoxModel model=new DefaultComboBoxModel();
                    for(Object item:all)model.addElement(item);
                    combo.setModel(model);
                    combo.setSelectedItem(chosen);
                }finally{busy[0]=false;}
            }
        });
        input.addFocusListener(new FocusAdapter(){
            @Override public void focusLost(FocusEvent e){
                Object selected=combo.getSelectedItem();
                if(!(selected instanceof PilihanData)){
                    String entered=input.getText();
                    for(Object item:all)if(String.valueOf(item).equalsIgnoreCase(entered)){
                        combo.setSelectedItem(item);break;
                    }
                }
            }
        });
    }
}
