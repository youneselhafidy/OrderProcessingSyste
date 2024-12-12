package module;

public class Order {
    private String ID;
    private String customerId ;
    private String orderDate;
    private String status;

    public Order(){}
    public Order(String ID, String customerId, String orderDate, String status) {
        this.ID = ID;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.status = status;
    }
    public Order(Order order) {
        this.ID = order.ID;
        this.customerId = order.customerId;
        this.orderDate = order.orderDate;
        this.status = order.status;
    }

    public String getID() {
        return ID;
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getStatus() {
        return status;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
