import java.util.List;

public class Base64Convertor {

    Encoder encoder = new Encoder();
    Decoder decoder = new Decoder();

    public String encode(String text) {
        List<String> chunks = encoder.chunkToStringBitsArray(text);
        List<Integer> valueInt = encoder.calcValue(chunks);
        return encoder.createEncodedText(valueInt);
    }

    public String decode(String encodedText) {
        List<String> bytesArray = decoder.convertToStringArray(encodedText);
        String bits = decoder.bytesArrayJoinToString(bytesArray);
        List<String> bytes = decoder.convertToByteArray(bits);
        List<Integer> binaryArray = decoder.convertToBinaryArray(bytes);
        System.out.println();
        return decoder.convertToLetters(binaryArray);
    }

}
