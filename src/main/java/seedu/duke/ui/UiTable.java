package seedu.duke.ui;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class UiTable {
    private ArrayList<UiTableRow> rows;

    public UiTable(){
        rows=new ArrayList<>();
    }

    public void addRow(UiTableRow row) {
        if(rows.isEmpty()){
            rows.add(row);
        }else{
            if(rows.getFirst().size()!=row.size()){
                throw new IllegalArgumentException("All rows must have the same number of columns");
            }

            rows.add(row);
        }
    }

    public int getColumnWidth(int columnIndex) {
        int maxWidth = 0;
        for (UiTableRow row : rows) {
            if (columnIndex < row.size()) {
                int cellWidth = row.length(columnIndex);
                if (cellWidth > maxWidth) {
                    maxWidth = cellWidth;
                }
            }
        }
        return maxWidth;
    }

    public int getColumnCount() {
        if (rows.isEmpty()) {
            throw new IllegalArgumentException("No rows have been added");
        }
        return rows.getFirst().size();
    }

    @Override
    public String toString() {
        var widths = IntStream.range(0, getColumnCount()).map(this::getColumnWidth).toArray();

        StringBuilder tableString = new StringBuilder();
        for (UiTableRow row : rows) {
            tableString.append(row.toString(widths)).append("\n");
        }

        return tableString.toString();
    }
}
