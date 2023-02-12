package com.rawrysmode.view.components;

import com.rawrysmode.assets.colors.CustomColors;
import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.city.City;
import com.rawrysmode.entities.city.CityCellEditor;
import com.rawrysmode.entities.client.Client;
import com.rawrysmode.entities.client.ClientCellEditor;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.employee.EmployeeCellEditor;
import com.rawrysmode.entities.job.Job;
import com.rawrysmode.entities.job.JobCellEditor;
import com.rawrysmode.entities.order.Order;
import com.rawrysmode.entities.order.OrderCellEditor;
import com.rawrysmode.entities.route.Route;
import com.rawrysmode.entities.route.RouteCellEditor;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.Instant;
import java.time.LocalDate;

public class CustomTable extends JTable {

    private static volatile CustomTable customTableModel;

    public static CustomTable getInstance() {
        CustomTable localInstance = customTableModel;
        if (localInstance == null) {
            synchronized (CustomTable.class) {
                localInstance = customTableModel;
                if (localInstance == null) {
                    customTableModel = localInstance = new CustomTable();
                }
            }
        }
        return localInstance;
    }

    private CustomTable() {
        super();
        setGridColor(CustomColors.GREY_COLOR);
        getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
        setRowHeight(20);

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableCellListener tableCellListener = (TableCellListener) e.getSource();
                getCurrentModel().setHasChanged(tableCellListener.getRow());
            }
        };
        new TableCellListener(this, action);

        initializeTableCellRenderers();
    }

    public CustomTableModel getCurrentModel() {
        return (CustomTableModel) this.dataModel;
    }


    private void initializeTableCellRenderers() {
        TableCellRenderer tableCellRenderer = new CustomTableCellRenderer();
        this.setDefaultRenderer(City.class, tableCellRenderer);
        this.setDefaultRenderer(Job.class, tableCellRenderer);
        this.setDefaultRenderer(Employee.class, tableCellRenderer);
        this.setDefaultRenderer(Route.class, tableCellRenderer);
        this.setDefaultRenderer(Client.class, tableCellRenderer);
        this.setDefaultRenderer(Order.class, tableCellRenderer);

        this.setDefaultRenderer(String.class, tableCellRenderer);
        this.setDefaultRenderer(LocalDate.class, tableCellRenderer);
        this.setDefaultRenderer(Instant.class, tableCellRenderer);
        this.setDefaultRenderer(Integer.class, tableCellRenderer);
    }

    public void initializeTableCellEditors() {
        this.setDefaultEditor(City.class, new CityCellEditor());
        this.setDefaultEditor(Job.class, new JobCellEditor());
        this.setDefaultEditor(Employee.class, new EmployeeCellEditor());
        this.setDefaultEditor(Route.class, new RouteCellEditor());
        this.setDefaultEditor(Client.class, new ClientCellEditor());
        this.setDefaultEditor(Order.class, new OrderCellEditor());

        this.setDefaultEditor(LocalDate.class, new DateCellEditor());
    }

    private static class TableHeaderRenderer extends JLabel implements TableCellRenderer {

        TableHeaderRenderer() {
            setOpaque(true);
            setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
            setBackground(CustomColors.GREY_COLOR);
            setForeground(CustomColors.LIGHT_GREY_COLOR);
            setHorizontalAlignment(JLabel.CENTER);
            setBorder(BorderFactory.createLineBorder(CustomColors.GREY_COLOR));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }

    }

    private class CustomTableCellRenderer extends JLabel implements TableCellRenderer {

        CustomTableCellRenderer() {
            setOpaque(true);
            setFont(new Font("JetBrains Mono Light", Font.PLAIN, 12));
            setForeground(CustomColors.LIGHT_GREY_COLOR);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            if (!isSelected) {
                setBackground(CustomColors.DARK_GREY_COLOR);
            } else {
                setBackground(CustomColors.GREY_COLOR);
            }

            CustomTableModel customTableModel = CustomTable.this.getCurrentModel();

            if (customTableModel.hasChanged(row)) {
                if (!isSelected) {
                    setBackground(CustomColors.RED_COLOR);
                }
            }

            if (value != null) {
                setText(value.toString());
            } else {
                setText("<Null>");
            }

            if (customTableModel.isCreated(row)) {
                if (!isSelected) {
                    setBackground(CustomColors.GREEN_COLOR);
                }
            }

            return this;
        }

    }

}
