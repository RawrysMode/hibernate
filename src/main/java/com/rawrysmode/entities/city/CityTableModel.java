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
        return String.class;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        return cityList.get(rowIndex).getCityName();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == 0) {
            cityList.get(rowIndex).setCityName((String) aValue);
            cityService.update(cityList.get(rowIndex));
        }
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
