package com.rawrysmode.entities.route;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.city.City;

import java.util.List;

public class RouteTableModel extends CustomTableModel<Route> {

    private final RouteService routeService;
    private List<TableEntity<Route>> routeList;

    public RouteTableModel() {
        routeService = new RouteService();
        routeList = wrapList(routeService.findAll());
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
            case 0 -> routeList.get(rowIndex).getEntity().getDepartureCity();
            case 1 -> routeList.get(rowIndex).getEntity().getDestinationCity();
            case 2 -> routeList.get(rowIndex).getEntity().getRouteCost();
            default -> "Not found";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> routeList.get(rowIndex).getEntity().setDepartureCity((City) aValue);
            case 1 -> routeList.get(rowIndex).getEntity().setDestinationCity((City) aValue);
            case 2 -> routeList.get(rowIndex).getEntity().setRouteCost((Integer) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
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

    @Override
    public void findWhere(String request) {
        routeList = wrapList(routeService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        routeList.add(new TableEntity<>(new Route(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        routeService.delete(routeList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return routeList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        routeList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return routeList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        routeList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<Route> tableEntity = routeList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                routeService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
