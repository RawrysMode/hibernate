package com.rawrysmode.entities.order;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.client.Client;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.route.Route;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class OrderTableModel extends CustomTableModel<Order> {

    private final OrderService orderService;
    private List<TableEntity<Order>> orderList;

    public OrderTableModel() {
        orderService = new OrderService();
        orderList = wrapList(orderService.findAll());
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
            case 0 -> orderList.get(rowIndex).getEntity().getClient();
            case 1 -> orderList.get(rowIndex).getEntity().getEmployee();
            case 2 -> orderList.get(rowIndex).getEntity().getOrderDate();
            case 3 -> orderList.get(rowIndex).getEntity().getRoute();
            case 4 -> orderList.get(rowIndex).getEntity().getWagonNumber();
            case 5 -> orderList.get(rowIndex).getEntity().getShippingDate();
            case 6 -> orderList.get(rowIndex).getEntity().getShippingCost();
            case 7 -> orderList.get(rowIndex).getEntity().getNvc();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> orderList.get(rowIndex).getEntity().setClient((Client) aValue);
            case 1 -> orderList.get(rowIndex).getEntity().setEmployee((Employee) aValue);
            case 2 -> orderList.get(rowIndex).getEntity().setOrderDate(Instant.parse((String) aValue));
            case 3 -> orderList.get(rowIndex).getEntity().setRoute((Route) aValue);
            case 4 -> orderList.get(rowIndex).getEntity().setWagonNumber((Integer) aValue);
            case 5 -> orderList.get(rowIndex).getEntity().setShippingDate(LocalDate.parse((String) aValue));
            case 6 -> orderList.get(rowIndex).getEntity().setShippingCost((Integer) aValue);
            case 7 -> orderList.get(rowIndex).getEntity().setNvc((String) aValue);
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

    @Override
    public void findWhere(String request) {
        orderList = wrapList(orderService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        orderList.add(new TableEntity<>(new Order(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        orderService.delete(orderList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return orderList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        orderList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return orderList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        orderList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<Order> tableEntity = orderList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                orderService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
