### maven:

```
<dependency>
  <groupId>io.github.taraska</groupId>
  <artifactId>WalletBusinessPay</artifactId>
  <version>1.0.0</version>
</dependency>
```

# wallet-business-pay
Telegram wallet pay
API for https://pay.wallet.tg/

## Technology stack
Java 11, Maven

## How to use
1. set your api key
2. use api

- Examples:
```
        WalletApiTelegram walletApiTelegram = new WalletApiTelegram("apiKey");

        OrderBuilder orderBuilder = new OrderBuilder(
            new BigDecimal("0.01"),
            "USDT",
            "description",
            "ORD-5023-4E89333191",
            10800,
            "192348487"
        );
        orderBuilder.setFailReturnUrl("https://t.me/wallet");
        orderBuilder.setReturnUrl("https://t.me/wallet");
        orderBuilder.setCustomData("client_ref=4E8433191");
        orderBuilder.setAutoConversionCurrency("USDT");
        try {
            OrderPreview order = walletApiTelegram.createOrder(orderBuilder);
            System.out.println(order);

            OrderPreviewList orderList = walletApiTelegram.getOrderList(0, 20);
            System.out.println(orderList);

            OrderPreview orderPreview = walletApiTelegram.getOrderPreview("1");
            System.out.println(orderPreview);

            long orderAmount = walletApiTelegram.getOrderAmount();
            System.out.println(orderAmount);
        } catch (IOException | WalletApiTelegramException e) {
            e.printStackTrace();
        }
```