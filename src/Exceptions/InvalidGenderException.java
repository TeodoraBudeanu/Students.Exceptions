package Exceptions;

public class InvalidGenderException extends  Exception {
    public InvalidGenderException(String errorMessage){
        super(errorMessage);
    }
}
