package com.rawrysmode.entities.client;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<Client> clientList;
    private Client client;

    public ClientCellEditor() {
        ClientService service = new ClientService();
        clientList = (ArrayList<Client>) service.findAll();
    }

    @Override
    public Client getCellEditorValue() {
        return client;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Client) {
            this.client = (Client) value;
        }

        CustomComboBox<Client> comboBox = new CustomComboBox<>(clientList, this.client);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<Client> comboBox = (JComboBox<Client>) e.getSource();
        this.client = (Client) comboBox.getSelectedItem();
    }

}
