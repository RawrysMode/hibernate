package com.rawrysmode.entities.client;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;

import java.util.List;

public class ClientTableModel extends CustomTableModel<Client> {

    private final ClientService clientService;
    private List<TableEntity<Client>> clientList;

    public ClientTableModel() {
        clientService = new ClientService();
        clientList = wrapList(clientService.findAll());
    }

    @Override
    public int getRowCount() {
        return clientList.size();
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
            case 0 -> clientList.get(rowIndex).getEntity().getCompanyName();
            case 1 -> clientList.get(rowIndex).getEntity().getPostalAddress();
            case 2 -> clientList.get(rowIndex).getEntity().getPhoneNumber();
            case 3 -> clientList.get(rowIndex).getEntity().getFaxNumber();
            case 4 -> clientList.get(rowIndex).getEntity().getEmail();
            default -> "Not found";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> clientList.get(rowIndex).getEntity().setCompanyName((String) aValue);
            case 1 -> clientList.get(rowIndex).getEntity().setPostalAddress((String) aValue);
            case 2 -> clientList.get(rowIndex).getEntity().setPhoneNumber((String) aValue);
            case 3 -> clientList.get(rowIndex).getEntity().setFaxNumber((String) aValue);
            case 4 -> clientList.get(rowIndex).getEntity().setEmail((String) aValue);
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Название";
            case 1 -> "Почтовый номер";
            case 2 -> "Номер телефона";
            case 3 -> "Номер факса";
            case 4 -> "Электронная почта";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void findWhere(String request) {
        clientList = wrapList(clientService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        clientList.add(new TableEntity<>(new Client(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        clientService.delete(clientList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return clientList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        clientList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return clientList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        clientList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<Client> tableEntity = clientList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                clientService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
