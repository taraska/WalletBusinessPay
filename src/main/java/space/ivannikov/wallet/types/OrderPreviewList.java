package space.ivannikov.wallet.types;

public class OrderPreviewList {

    private String status;
    private OrderList data;

    public OrderPreviewList(String status, OrderList data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderPreview{" +
            "status='" + status + '\'' +
            ", order=" + data +
            '}';
    }
}
