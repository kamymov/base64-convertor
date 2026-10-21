import constants.Base64Table;

import java.util.List;

public class Base64Convertor {

    Encoder encoder = new Encoder();

    public String encode(String text) {
        List<String> chunks = encoder.chunkToStringBitsArray(text);
        List<Integer> valueInt = encoder.calcValue(chunks);
        String encodedText = "";
        for (int i = 0; i < valueInt.size(); i++) {
            encodedText += Base64Table.base64Table[valueInt.get(i)];
        }

        return encodedText;
    }

    public String decode() {
        return "";
    }

}
