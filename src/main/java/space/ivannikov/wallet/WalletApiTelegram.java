package space.ivannikov.wallet;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import space.ivannikov.wallet.types.OrderPreview;
import space.ivannikov.wallet.types.OrderPreviewList;
import space.ivannikov.wallet.types.WalletApiTelegramException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.stream.Stream;

public class WalletApiTelegram {

    private static final String BASE_URL = "https://pay.wallet.tg/wpay/store-api/v1/";
    private final String apiKey;

    public WalletApiTelegram(String apiKey) {
        this.apiKey = apiKey.trim();
    }

    private String makeRequest(HttpRequestBase httpMethod, String apiEndpoint, String... data) throws WalletApiTelegramException, IOException {
        String dataJson = Stream.of(data).filter(Objects::nonNull).findFirst().orElse(null);
        HttpEntity response = null;

        if (httpMethod.getMethod().equals(HttpGet.METHOD_NAME)) {
            response = executeGet(apiEndpoint);
        }

        if (httpMethod.getMethod().equals(HttpPost.METHOD_NAME)) {
            response = executePost(apiEndpoint, dataJson);
        }

        if (response == null) {
            throw new WalletApiTelegramException("Wrong http method!");
        }

        return this.getResponseAsString(response);
    }

    private String getResponseAsString(HttpEntity entity) throws IOException {
        String getResponseString = "";

        if (entity != null) {
            InputStream inStream = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream), 2048);

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            getResponseString = sb.toString();
        }
        return getResponseString;
    }

    private HttpEntity executePost(String apiEndpoint, String data) throws WalletApiTelegramException, IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost(BASE_URL + apiEndpoint);
        this.setCommonHeaders(request);

        if (StringUtils.isNotEmpty(data)) {
            request.setEntity(new StringEntity(data));
        } else {
            throw new WalletApiTelegramException("Body is empty!");
        }

        HttpResponse response = httpClient.execute(request);
        return response.getEntity();
    }

    private HttpEntity executeGet(String apiEndpoint) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet(BASE_URL + apiEndpoint);
        this.setCommonHeaders(request);

        HttpResponse response = httpClient.execute(request);
        return response.getEntity();
    }

    private void setCommonHeaders(HttpRequestBase request) {
        request.setHeader("Accept", "application/json");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Wpay-Store-Api-Key", apiKey);
    }

    private OrderPreview fromJsonToOrderPreview(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OrderPreview.class);
    }

    private OrderPreviewList fromJsonToOrderPreviewList(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, OrderPreviewList.class);
    }

    public OrderPreview createOrder(OrderBuilder orderBuilder) throws WalletApiTelegramException, IOException {
        JSONObject amount = new JSONObject();
        amount.put("currencyCode", orderBuilder.getCurrencyCode());
        amount.put("amount", orderBuilder.getAmount());

        JSONObject data = new JSONObject();
        data.put("amount", amount);
        data.put("description", orderBuilder.getDescription());
        data.put("externalId", orderBuilder.getExternalId());
        data.put("timeoutSeconds", orderBuilder.getTimeoutSeconds());
        data.put("customerTelegramUserId", orderBuilder.getCustomerTelegramUserId());

        if (orderBuilder.getReturnUrl() != null) {
            data.put("returnUrl", orderBuilder.getReturnUrl());
        }
        if (orderBuilder.getFailReturnUrl() != null) {
            data.put("failReturnUrl", orderBuilder.getFailReturnUrl());
        }
        if (orderBuilder.getCustomData() != null) {
            data.put("customData", orderBuilder.getCustomData());
        }

        String json = this.makeRequest(new HttpPost(), "order", data.toString());
        return this.fromJsonToOrderPreview(json);
    }

    public OrderPreview getOrderPreview(String orderId) throws WalletApiTelegramException, IOException {
        String json = this.makeRequest(new HttpGet(), "order/preview?id=" + orderId);
        return this.fromJsonToOrderPreview(json);
    }

    public OrderPreviewList getOrderList(int offSet, int count) throws WalletApiTelegramException, IOException {
        String format = MessageFormat.format("reconciliation/order-list?offset={0}&count={1}", offSet, count);
        String json = this.makeRequest(new HttpGet(), format);
        return this.fromJsonToOrderPreviewList(json);
    }

    public long getOrderAmount() throws WalletApiTelegramException, IOException {
        String json = this.makeRequest(new HttpGet(), "reconciliation/order-amount");
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        return asJsonObject.getAsJsonObject("data").get("totalAmount").getAsLong();
    }

}
