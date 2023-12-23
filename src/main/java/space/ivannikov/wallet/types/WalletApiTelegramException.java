package space.ivannikov.wallet.types;

public class WalletApiTelegramException extends Exception {

    public WalletApiTelegramException(String message) {
        super(message);
    }

    public WalletApiTelegramException(String message, Throwable cause) {
        super(message, cause);
    }
}
