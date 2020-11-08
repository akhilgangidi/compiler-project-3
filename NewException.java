import java.util.*;

class NewException extends Exception {
    String fault;

    public NewException(String s) {
        fault = s;
    }

    public String toString() {
        return fault;
    }
}
