package service;

import dao.CustomerDAO;
import module.Customer;

public class CustomerService {

    public static boolean validateCustomerId(String customerId) {
        return CustomerDAO.getCustomerById(customerId) != null;
    }
    public static Customer getCustomerById(String customerId) {
        return CustomerDAO.getCustomerById(customerId);
    }
}
