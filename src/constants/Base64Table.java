package constants;

public class Base64Table {
    public final static char[] base64Table =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"
                    .toCharArray();

    public static int indexOf(char target) {
        for (int i = 0; i < base64Table.length; i++) {
            if (base64Table[i] == target) {
                return i;
            }
        }

        return -1; // Character not found
    }
}
