package seedu.duke.ui;

import seedu.duke.equipment.Equipment;

import java.util.ArrayList;
import java.util.Arrays;

public class UiTableRow {
    private ArrayList<String> columns;

    public UiTableRow(Equipment equipment) {
        this(equipment.getName(),
                "Total: " + equipment.getQuantity(),
                "Available: " + equipment.getAvailable(),
                "Loaned: " + equipment.getLoaned());
    }

    public UiTableRow(ArrayList<String> columns) {
        this.columns = columns;
    }

    public UiTableRow(String... columns) {
        this.columns = new ArrayList<>();
        this.columns.addAll(Arrays.asList(columns));
    }

    @Override
    public String toString() {
        return String.join(" | ", columns);
    }

    public String toString(int[] widths) {
        StringBuilder rowString = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            String cell = String.format("%-" + widths[i] + "s", columns.get(i));
            rowString.append(cell);
            if (i < columns.size() - 1) {
                rowString.append(" | ");
            }
        }
        return rowString.toString();
    }

    public int length(int columnIndex) {
        if (columnIndex < 0 || columnIndex >= columns.size()) {
            throw new IndexOutOfBoundsException("Column index out of bounds");
        }

        return columns.get(columnIndex).length();
    }

    public int size() {
        return columns.size();
    }
}
