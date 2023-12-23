package space.ivannikov.wallet.types;

public class Order {

    private String id;
    private String number;
    private String status;
    private Amount amount;
    private String autoConversionCurrency;
    private String createdDateTime;
    private String expirationDateTime;
    private String completedDateTime;
    private String payLink;
    private String directPayLink;

    public Order(String id,
                 String number,
                 String status,
                 Amount amount,
                 String autoConversionCurrency,
                 String createdDateTime,
                 String expirationDateTime,
                 String completedDateTime,
                 String payLink,
                 String directPayLink) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.amount = amount;
        this.autoConversionCurrency = autoConversionCurrency;
        this.createdDateTime = createdDateTime;
        this.expirationDateTime = expirationDateTime;
        this.completedDateTime = completedDateTime;
        this.payLink = payLink;
        this.directPayLink = directPayLink;
    }

    public String getAutoConversionCurrency() {
        return autoConversionCurrency;
    }

    public void setAutoConversionCurrency(String autoConversionCurrency) {
        this.autoConversionCurrency = autoConversionCurrency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(String expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public String getCompletedDateTime() {
        return completedDateTime;
    }

    public void setCompletedDateTime(String completedDateTime) {
        this.completedDateTime = completedDateTime;
    }

    public String getPayLink() {
        return payLink;
    }

    public void setPayLink(String payLink) {
        this.payLink = payLink;
    }

    public String getDirectPayLink() {
        return directPayLink;
    }

    public void setDirectPayLink(String directPayLink) {
        this.directPayLink = directPayLink;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id='" + id + '\'' +
            ", number='" + number + '\'' +
            ", status='" + status + '\'' +
            ", amount=" + amount +
            ", autoConversionCurrency='" + autoConversionCurrency + '\'' +
            ", createdDateTime='" + createdDateTime + '\'' +
            ", expirationDateTime='" + expirationDateTime + '\'' +
            ", completedDateTime='" + completedDateTime + '\'' +
            ", payLink='" + payLink + '\'' +
            ", directPayLink='" + directPayLink + '\'' +
            '}';
    }

}
