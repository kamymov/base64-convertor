import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Base64Convertor {

    Encoder encoder = new Encoder();

    public void encode(String text) {
        List<String> chunks = encoder.chunkToArray(text);
    }

    public String decode() {
        return "";
    }

}
