package view;
/** Data item for existing GUI Builder JComboBox, not a visual component. */
public final class PilihanData {
    public final int id;
    public final String label;
    public PilihanData(int id, String label) { this.id=id; this.label=label; }
    @Override public String toString() { return label; }
}
