package exception;

// I create my exception named NewsAPIException in order to have just only one Exception. Otherwise, I would have to throw Exceptions many times.
public class NewsAPIException extends Exception {
	public NewsAPIException() {
        super();
    }

    public NewsAPIException(String message) {
        super(message);
    }

    public NewsAPIException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsAPIException(Throwable cause) {
        super(cause);
    }

    protected NewsAPIException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
