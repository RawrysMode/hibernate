package com.rawrysmode.entities.city;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;

import java.util.List;

public class CityTableModel extends CustomTableModel<City> {

    final private CityService cityService;
    private List<TableEntity<City>> cityList;

    public CityTableModel() {
        cityService = new CityService();
        cityList = wrapList(cityService.findAll());
    }

    @Override
    public int getRowCount() {
        return cityList.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cityList.get(rowIndex).getEntity().getCityName();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cityList.get(rowIndex).getEntity().setCityName((String) aValue);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return "Название города";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void findWhere(String request) {
        cityList = wrapList(cityService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        cityList.add(new TableEntity<>(new City(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        cityService.delete(cityList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return cityList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        cityList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return cityList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        cityList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<City> tableEntity = cityList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                cityService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
