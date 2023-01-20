package com.rawrysmode.entities.client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClientTableModel extends AbstractTableModel {
    private final ClientService clientService;
    private final List<Client> clientList;

    public ClientTableModel() {
        clientService = new ClientService();
        clientList = clientService.findAll();
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
            case 0 -> clientList.get(rowIndex).getCompanyName();
            case 1 -> clientList.get(rowIndex).getPostalAddress();
            case 2 -> clientList.get(rowIndex).getPhoneNumber();
            case 3 -> clientList.get(rowIndex).getFaxNumber();
            case 4 -> clientList.get(rowIndex).getEmail();
            default -> "Not found";
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                clientList.get(rowIndex).setCompanyName((String) aValue);
                clientService.update(clientList.get(rowIndex));
            }
            case 1 -> {
                clientList.get(rowIndex).setPostalAddress((String) aValue);
                clientService.update(clientList.get(rowIndex));
            }
            case 2 -> {
                clientList.get(rowIndex).setPhoneNumber((String) aValue);
                clientService.update(clientList.get(rowIndex));
            }
            case 3 -> {
                clientList.get(rowIndex).setFaxNumber((String) aValue);
                clientService.update(clientList.get(rowIndex));
            }
            case 4 -> {
                clientList.get(rowIndex).setEmail((String) aValue);
                clientService.update(clientList.get(rowIndex));
            }
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
}
