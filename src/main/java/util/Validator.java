package util;

import java.util.function.Function;

public interface Validator extends Function<String,ValidationMessage> {

}
enum ValidationMessage{
    SUCCEED,
    USERNAME_NOT_CORRECT,
}
