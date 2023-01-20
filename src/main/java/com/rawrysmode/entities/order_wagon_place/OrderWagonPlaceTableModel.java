package com.rawrysmode.entities.order_wagon_place;

import com.rawrysmode.entities.order.Order;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrderWagonPlaceTableModel extends AbstractTableModel {
    private final OrderWagonPlaceService orderWagonPlaceService;
    private final List<OrderWagonPlace> orderWagonPlaceList;

    public OrderWagonPlaceTableModel() {
        orderWagonPlaceService = new OrderWagonPlaceService();
        orderWagonPlaceList = orderWagonPlaceService.findAll();
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
            case 0 -> orderWagonPlaceList.get(rowIndex).getOrder();
            case 1 -> orderWagonPlaceList.get(rowIndex).getSpaceNumber();
            case 2 -> orderWagonPlaceList.get(rowIndex).getSize();
            case 3 -> orderWagonPlaceList.get(rowIndex).getWeight();
            case 4 -> orderWagonPlaceList.get(rowIndex).getInsuranceCost();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                orderWagonPlaceList.get(rowIndex).setOrder((Order) aValue);
                orderWagonPlaceService.update(orderWagonPlaceList.get(rowIndex));
            }
            case 1 -> {
                orderWagonPlaceList.get(rowIndex).setSpaceNumber((Integer) aValue);
                orderWagonPlaceService.update(orderWagonPlaceList.get(rowIndex));
            }
            case 2 -> {
                orderWagonPlaceList.get(rowIndex).setSize((String) aValue);
                orderWagonPlaceService.update(orderWagonPlaceList.get(rowIndex));
            }
            case 3 -> {
                orderWagonPlaceList.get(rowIndex).setWeight((String) aValue);
                orderWagonPlaceService.update(orderWagonPlaceList.get(rowIndex));
            }
            case 4 -> {
                orderWagonPlaceList.get(rowIndex).setInsuranceCost((Integer) aValue);
                orderWagonPlaceService.update(orderWagonPlaceList.get(rowIndex));
            }
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
}
