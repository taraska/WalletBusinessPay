package space.ivannikov.wallet.types;

public class OrderPreview {

    private String status;
    private Order data;

    public OrderPreview(String status, Order data) {
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
