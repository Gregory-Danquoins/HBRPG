package Exceptions;

public class ManaInsuffisantException extends RuntimeException {

    public ManaInsuffisantException() {
        super("############### MANA INSUFISANT ###################");
    }

    public ManaInsuffisantException(String message) {
        super(message);
    }
}
