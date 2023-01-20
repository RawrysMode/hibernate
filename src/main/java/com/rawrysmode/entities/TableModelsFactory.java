package com.rawrysmode.entities;

import com.rawrysmode.entities.bank_detail.BankDetailTableModel;
import com.rawrysmode.entities.city.CityTableModel;
import com.rawrysmode.entities.client.ClientTableModel;
import com.rawrysmode.entities.employee.EmployeeTableModel;
import com.rawrysmode.entities.employee_transfer.EmployeeTransferTableModel;
import com.rawrysmode.entities.job.JobTableModel;
import com.rawrysmode.entities.order.OrderTableModel;
import com.rawrysmode.entities.order_wagon_place.OrderWagonPlaceTableModel;
import com.rawrysmode.entities.route.RouteTableModel;

import javax.swing.table.TableModel;

public class TableModelsFactory {
    public static String[] getTableNames() {
        return new String[]{
                "Cities",
                "Bank Details",
                "Clients",
                "Employees",
                "Employee Transfers",
                "Jobs",
                "Orders",
                "Order Wagon Places",
                "Routes"
        };
    }

    public static TableModel getBuilderByName(String tableName) {
        return switch (tableName) {
            case "Bank Details" -> new BankDetailTableModel();
            case "Cities" -> new CityTableModel();
            case "Clients" -> new ClientTableModel();
            case "Employees" -> new EmployeeTableModel();
            case "Employee Transfers" -> new EmployeeTransferTableModel();
            case "Jobs" -> new JobTableModel();
            case "Orders" -> new OrderTableModel();
            case "Order Wagon Places" -> new OrderWagonPlaceTableModel();
            case "Routes" -> new RouteTableModel();
            default -> null;
        };
    }
}
