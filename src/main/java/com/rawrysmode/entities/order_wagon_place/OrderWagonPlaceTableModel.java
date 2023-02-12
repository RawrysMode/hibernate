package com.rawrysmode.entities.order_wagon_place;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.order.Order;

import java.util.List;

public class OrderWagonPlaceTableModel extends CustomTableModel<OrderWagonPlace> {

    private final OrderWagonPlaceService orderWagonPlaceService;
    private List<TableEntity<OrderWagonPlace>> orderWagonPlaceList;

    public OrderWagonPlaceTableModel() {
        orderWagonPlaceService = new OrderWagonPlaceService();
        orderWagonPlaceList = wrapList(orderWagonPlaceService.findAll());
    }

    @Override
    public int getRowCount() {
        return orderWagonPlaceList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> orderWagonPlaceList.get(rowIndex).getEntity().getOrder();
            case 1 -> orderWagonPlaceList.get(rowIndex).getEntity().getSpaceNumber();
            case 2 -> orderWagonPlaceList.get(rowIndex).getEntity().getSize();
            case 3 -> orderWagonPlaceList.get(rowIndex).getEntity().getWeight();
            case 4 -> orderWagonPlaceList.get(rowIndex).getEntity().getInsuranceCost();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> orderWagonPlaceList.get(rowIndex).getEntity().setOrder((Order) aValue);
            case 1 -> orderWagonPlaceList.get(rowIndex).getEntity().setSpaceNumber((Integer) aValue);
            case 2 -> orderWagonPlaceList.get(rowIndex).getEntity().setSize((String) aValue);
            case 3 -> orderWagonPlaceList.get(rowIndex).getEntity().setWeight((String) aValue);
            case 4 -> orderWagonPlaceList.get(rowIndex).getEntity().setInsuranceCost((Integer) aValue);
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Заказ";
            case 1 -> "Номер места";
            case 2 -> "Размер";
            case 3 -> "Вес";
            case 4 -> "Стоимость страховки";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void findWhere(String request) {
        orderWagonPlaceList = wrapList(orderWagonPlaceService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        orderWagonPlaceList.add(new TableEntity<>(new OrderWagonPlace(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        orderWagonPlaceService.delete(orderWagonPlaceList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return orderWagonPlaceList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        orderWagonPlaceList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return orderWagonPlaceList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        orderWagonPlaceList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<OrderWagonPlace> tableEntity = orderWagonPlaceList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                orderWagonPlaceService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
