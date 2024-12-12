package service;

import dao.OrderDAO;
import module.Order;
import module.OrderList;

import java.util.List;
import java.util.ArrayList;

public class OrderService {
    private final FileService fileService = new FileService();

    public void processOrders(OrderList orderList) {
        List<Order> confirmedOrders = new ArrayList<>();
        List<Order> errorOrders = new ArrayList<>();

        for (Order order : orderList.getOrders()) {
            if (processOrder(order)) {
                confirmedOrders.add(order);
            } else {
                errorOrders.add(order);
            }
        }

        // Write the results to the appropriate files
        if (!confirmedOrders.isEmpty()) {
            fileService.writeConfirmedOrdersToFile(
                    "../DATA/output.json",
                    new OrderList(confirmedOrders)
            );
        }

        if (!errorOrders.isEmpty()) {
            fileService.writeErrorOrdersToFile(
                    "../DATA/errors.json",
                    new OrderList(errorOrders)
            );
        }
    }
    // Process a single order, validate customer, payment, and shipping
    private boolean processOrder(Order order) {
        // Validate customer
        if (CustomerService.validateCustomerId(order.getCustomerId())) {
            return false;  // Error in processing
        }

        // If all validations pass, process the order
        order.setStatus("Processed");
        OrderDAO.addOrder(order);
        return true;
    }
}
