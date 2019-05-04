package exceptions;

/**
 * Created by gilmario on 19/02/17.
 */
public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(String message){
        super(message);
    }
}
