package com.rawrysmode.entities.city;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CityTableModel extends AbstractTableModel {
    CityService cityService;
    List<City> cityList;

    public CityTableModel() {
        cityService = new CityService();
        cityList = cityService.findAll();
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
        return cityList.get(rowIndex).getCityName();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        cityList.get(rowIndex).setCityName((String) aValue);
        cityService.update(cityList.get(rowIndex));
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
}
