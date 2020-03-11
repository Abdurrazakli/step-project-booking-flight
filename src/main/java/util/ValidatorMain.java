package util;

public class ValidatorMain {
    public boolean usernameValidation(String username){
        return Validator.validateUsername().apply(username)==ValidationMessage.SUCCEED;
    }
}
