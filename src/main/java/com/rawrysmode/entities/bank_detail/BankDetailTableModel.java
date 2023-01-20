package com.rawrysmode.entities.bank_detail;

import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.client.Client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BankDetailTableModel extends AbstractTableModel {

    private final BankDetailService bankDetailService;
    private final List<BankDetail> bankDetailList;

    public BankDetailTableModel() {
        bankDetailService = new BankDetailService();
        bankDetailList = bankDetailService.findAll();
    }

    @Override
    public int getRowCount() {
        return bankDetailList.size();
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
            case 0 -> bankDetailList.get(rowIndex).getClient();
            case 1 -> bankDetailList.get(rowIndex).getBankName();
            case 2 -> bankDetailList.get(rowIndex).getCity();
            case 3 -> bankDetailList.get(rowIndex).getTin();
            case 4 -> bankDetailList.get(rowIndex).getBankAccount();
            default -> "Not found";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                bankDetailList.get(rowIndex).setClient((Client) aValue);
                bankDetailService.update(bankDetailList.get(rowIndex));
            }
            case 1 -> {
                bankDetailList.get(rowIndex).setBankName((String) aValue);
                bankDetailService.update(bankDetailList.get(rowIndex));
            }
            case 2 -> {
                bankDetailList.get(rowIndex).setCity((City) aValue);
                bankDetailService.update(bankDetailList.get(rowIndex));
            }
            case 3 -> {
                bankDetailList.get(rowIndex).setTin((String) aValue);
                bankDetailService.update(bankDetailList.get(rowIndex));
            }
            case 4 -> {
                bankDetailList.get(rowIndex).setBankAccount((String) aValue);
                bankDetailService.update(bankDetailList.get(rowIndex));
            }
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Клиент";
            case 1 -> "Название банка";
            case 2 -> "Местоположение";
            case 3 -> "ИНН";
            case 4 -> "Номер банковского счёта";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
