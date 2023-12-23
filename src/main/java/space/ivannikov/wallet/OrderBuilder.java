package space.ivannikov.wallet;

import java.math.BigDecimal;

public class OrderBuilder {

    private BigDecimal amount;
    private String currencyCode;
    private String description;
    private String externalId;
    private long timeoutSeconds;
    private String customerTelegramUserId;
    private String returnUrl;
    private String failReturnUrl;
    private String customData;
    private String autoConversionCurrency;

    public OrderBuilder(BigDecimal amount, String currencyCode, String description, String externalId, long timeoutSeconds, String customerTelegramUserId) {
        this.amount = amount;
        this.currencyCode = currencyCode;
        this.description = description;
        this.externalId = externalId;
        this.timeoutSeconds = timeoutSeconds;
        this.customerTelegramUserId = customerTelegramUserId;
    }

    public String getAutoConversionCurrency() {
        return autoConversionCurrency;
    }

    public void setAutoConversionCurrency(String autoConversionCurrency) {
        this.autoConversionCurrency = autoConversionCurrency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public void setTimeoutSeconds(long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public String getCustomerTelegramUserId() {
        return customerTelegramUserId;
    }

    public void setCustomerTelegramUserId(String customerTelegramUserId) {
        this.customerTelegramUserId = customerTelegramUserId;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getFailReturnUrl() {
        return failReturnUrl;
    }

    public void setFailReturnUrl(String failReturnUrl) {
        this.failReturnUrl = failReturnUrl;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }
}
