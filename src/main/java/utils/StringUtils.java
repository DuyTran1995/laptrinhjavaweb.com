package utils;

public class StringUtils {
    public static boolean isNullOrEmpty(Object value) {
        if (value != null && value != "") {
            return false;
        }

        return true;
    }

}
