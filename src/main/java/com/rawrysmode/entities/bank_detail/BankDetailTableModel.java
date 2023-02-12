package com.rawrysmode.entities.bank_detail;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.client.Client;

import java.util.List;

public class BankDetailTableModel extends CustomTableModel<BankDetail> {

    private final BankDetailService bankDetailService;
    private List<TableEntity<BankDetail>> bankDetailList;

    public BankDetailTableModel() {
        bankDetailService = new BankDetailService();
        bankDetailList = wrapList(bankDetailService.findAll());
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
            case 0 -> bankDetailList.get(rowIndex).getEntity().getClient();
            case 1 -> bankDetailList.get(rowIndex).getEntity().getBankName();
            case 2 -> bankDetailList.get(rowIndex).getEntity().getCity();
            case 3 -> bankDetailList.get(rowIndex).getEntity().getTin();
            case 4 -> bankDetailList.get(rowIndex).getEntity().getBankAccount();
            default -> "Not found";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> bankDetailList.get(rowIndex).getEntity().setClient((Client) aValue);
            case 1 -> bankDetailList.get(rowIndex).getEntity().setBankName((String) aValue);
            case 2 -> bankDetailList.get(rowIndex).getEntity().setCity((City) aValue);
            case 3 -> bankDetailList.get(rowIndex).getEntity().setTin((String) aValue);
            case 4 -> bankDetailList.get(rowIndex).getEntity().setBankAccount((String) aValue);
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

    @Override
    public void findWhere(String request) {
        bankDetailList = wrapList(bankDetailService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        bankDetailList.add(new TableEntity<>(new BankDetail(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        bankDetailService.delete(bankDetailList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return bankDetailList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        bankDetailList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return bankDetailList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        bankDetailList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<BankDetail> tableEntity = bankDetailList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                bankDetailService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
