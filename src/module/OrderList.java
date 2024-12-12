package module;

import java.util.List;

@Data
public class OrderList {
    private List<Order> orders;
    public OrderList() {}
    public OrderList(List<Order> orders) {
        this.orders = orders;
    }
    public List<Order> getOrders() {
        return orders;
    }
}