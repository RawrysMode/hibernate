package com.rawrysmode.entities;

import com.rawrysmode.entities.city.CityTableModel;

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
            case "Bank Details" -> null;
            case "Cities" -> new CityTableModel();
            case "Clients" -> null;
            case "Employees" -> null;
            case "Employee Transfers" -> null;
            case "Jobs" -> null;
            case "Orders" -> null;
            case "Order Wagon Places" -> null;
            case "Routes" -> null;
            default -> null;
        };
    }
}
