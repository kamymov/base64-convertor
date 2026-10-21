import java.util.List;

public class Base64Convertor {

    Encoder encoder = new Encoder();

    public void encode(String text) {
        List<String> chunks = encoder.chunkToStringBitsArray(text);
        List<Integer> valueInt = encoder.calcValue(chunks);
        System.out.println(valueInt);
    }

    public String decode() {
        return "";
    }

}
