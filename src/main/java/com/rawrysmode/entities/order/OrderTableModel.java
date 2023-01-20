package com.rawrysmode.entities.order;

import com.rawrysmode.entities.client.Client;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.route.Route;

import javax.swing.table.AbstractTableModel;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {
    private final OrderService orderService;
    private final List<Order> orderList;

    public OrderTableModel() {
        orderService = new OrderService();
        orderList = orderService.findAll();
    }

    @Override
    public int getRowCount() {
        return orderList.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> orderList.get(rowIndex).getClient();
            case 1 -> orderList.get(rowIndex).getEmployee();
            case 2 -> orderList.get(rowIndex).getOrderDate();
            case 3 -> orderList.get(rowIndex).getRoute();
            case 4 -> orderList.get(rowIndex).getWagonNumber();
            case 5 -> orderList.get(rowIndex).getShippingDate();
            case 6 -> orderList.get(rowIndex).getShippingCost();
            case 7 -> orderList.get(rowIndex).getNvc();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                orderList.get(rowIndex).setClient((Client) aValue);
                orderService.update(orderList.get(rowIndex));
            }
            case 1 -> {
                orderList.get(rowIndex).setEmployee((Employee) aValue);
                orderService.update(orderList.get(rowIndex));
            }
            case 2 -> {
                orderList.get(rowIndex).setOrderDate(Instant.parse((String) aValue));
                orderService.update(orderList.get(rowIndex));
            }
            case 3 -> {
                orderList.get(rowIndex).setRoute((Route) aValue);
                orderService.update(orderList.get(rowIndex));
            }
            case 4 -> {
                orderList.get(rowIndex).setWagonNumber((Integer) aValue);
                orderService.update(orderList.get(rowIndex));
            }
            case 5 -> {
                orderList.get(rowIndex).setShippingDate(LocalDate.parse((String) aValue));
                orderService.update(orderList.get(rowIndex));
            }
            case 6 -> {
                orderList.get(rowIndex).setShippingCost((Integer) aValue);
                orderService.update(orderList.get(rowIndex));
            }
            case 7 -> {
                orderList.get(rowIndex).setNvc((String) aValue);
                orderService.update(orderList.get(rowIndex));
            }
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Клиент";
            case 1 -> "Сотрудник";
            case 2 -> "Дата заказа";
            case 3 -> "Маршрут";
            case 4 -> "Номер вагона";
            case 5 -> "Дата отправки";
            case 6 -> "Стоимость отправки";
            case 7 -> "Номер счёт-фактуры";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
