package space.ivannikov.wallet.types;

import java.util.List;

public class OrderList {

    private List<Order> items;

    public OrderList(List<Order> orderList) {
        this.items = orderList;
    }

    public List<Order> getItems() {
        return items;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderList{" +
            "orderList=" + items +
            '}';
    }
}
