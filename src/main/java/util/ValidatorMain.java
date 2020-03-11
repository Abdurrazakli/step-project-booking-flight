package util;

public class ValidatorMain {
    public boolean usernameValidation(String username){
        return Validator.validateUsername().apply(username)==ValidationMessage.SUCCEED;
    }
    public boolean passwordValidator(String password1, String password2){
        return password1.equals(password2);
    }
}
