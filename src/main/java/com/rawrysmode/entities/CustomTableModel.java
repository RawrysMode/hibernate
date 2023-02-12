package com.rawrysmode.entities;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomTableModel<E> extends AbstractTableModel {

    protected CustomTableModel() {
        super();
    }

    protected ArrayList<TableEntity<E>> wrapList(List<E> list) {
        return list.stream().map(TableEntity::new).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void fireTableRowsDeleted(int firstRow, int lastRow) {
        super.fireTableRowsDeleted(firstRow, lastRow);
    }

    public abstract void findWhere(String request);

    public abstract void save(int[] rows);

    public abstract void removeRow(int rowIndex);

    public abstract boolean hasChanged(int row);

    public abstract void setHasChanged(int row);

    public abstract boolean isCreated(int row);

    public abstract void setCreated(int row);

    public abstract void createRow();

}
