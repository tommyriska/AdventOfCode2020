package dev.riska.model;

public class BoardingPass {
    private static final int MIN_ROW = 0;
    private static final int MAX_ROW = 127;
    private static final int MIN_COL = 0;
    private static final int MAX_COL = 7;

    private int row;
    private int column;

    public BoardingPass(String inputcode) {
        String rowCode = inputcode.substring(0, 7);
        String columnCode = inputcode.substring(7);

        calculateRow(MIN_ROW, MAX_ROW, rowCode);
        calculateColumn(MIN_COL, MAX_COL, columnCode);
    }

    private void calculateRow(int minRow, int maxRow, String rowcode) {
        if (rowcode.isEmpty()) {
            row = minRow;
        } else {
            String subcode = rowcode.substring(1);
            if (rowcode.startsWith("F")) {
                calculateRow(minRow, (int) Math.floor((double) (minRow + maxRow) / 2), subcode);
            } else if (rowcode.startsWith("B")) {
                calculateRow((int) Math.ceil((double) (minRow + maxRow) / 2), maxRow, subcode);
            }
        }
    }

    private void calculateColumn(int minColumn, int maxColumn, String columnCode) {
        if (columnCode.isEmpty()) {
            column = minColumn;
        } else {
            String subCode = columnCode.substring(1);
            if (columnCode.startsWith("R")) {
                calculateColumn((int) Math.ceil((double) (minColumn + maxColumn) / 2), maxColumn, subCode);
            } else if (columnCode.startsWith("L")) {
                calculateColumn(minColumn, (int) Math.floor((double) (minColumn + maxColumn) / 2), subCode);
            }
        }
    }

    public int getSeatId() {
        return row * 8 + column;
    }
}
