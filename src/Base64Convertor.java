import constants.Base64Table;

import java.util.List;

public class Base64Convertor {

    Encoder encoder = new Encoder();

    public String encode(String text) {
        List<String> chunks = encoder.chunkToStringBitsArray(text);
        List<Integer> valueInt = encoder.calcValue(chunks);
        return encoder.createEncodedText(valueInt);
    }

    public String decode() {
        return "";
    }

}
