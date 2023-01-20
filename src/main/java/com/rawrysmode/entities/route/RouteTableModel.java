package com.rawrysmode.entities.route;

import com.rawrysmode.entities.city.City;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RouteTableModel extends AbstractTableModel {
    private final RouteService routeService;
    private final List<Route> routeList;

    public RouteTableModel() {
        routeService = new RouteService();
        routeList = routeService.findAll();
    }

    @Override
    public int getRowCount() {
        return routeList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> routeList.get(rowIndex).getDepartureCity();
            case 1 -> routeList.get(rowIndex).getDestinationCity();
            case 2 -> routeList.get(rowIndex).getRouteCost();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                routeList.get(rowIndex).setDepartureCity((City) aValue);
                routeService.update(routeList.get(rowIndex));
            }
            case 1 -> {
                routeList.get(rowIndex).setDestinationCity((City) aValue);
                routeService.update(routeList.get(rowIndex));
            }
            case 2 -> {
                routeList.get(rowIndex).setRouteCost((Integer) aValue);
                routeService.update(routeList.get(rowIndex));
            }
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Город отправки";
            case 1 -> "Город доставки";
            case 2 -> "Стоимость";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
