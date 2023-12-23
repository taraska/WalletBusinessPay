package space.ivannikov.wallet.types;

public class Amount {

    private String amount;
    private String currencyCode;

    public Amount(String amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Amount{" +
            "amount='" + amount + '\'' +
            ", currencyCode='" + currencyCode + '\'' +
            '}';
    }
}
