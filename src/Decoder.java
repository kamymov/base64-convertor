import constants.Base64Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decoder {

    public List<String> convertToStringArray(String encodedText) {
        char[] encodedChars = encodedText.toCharArray();
        List<String> bytes = new ArrayList<>();
        for (int i = 0; i < encodedChars.length; i++) {
            int foundedIndex = Base64Table.indexOf(encodedChars[i]);
            String binary = String.format("%6s",
                            Integer.toBinaryString(foundedIndex))
                    .replace(' ', '0');
            bytes.add(binary);
        }

        return bytes;
    }

    public String bytesArrayJoinToString(List<String> bytesArray) {
        return String.join("", bytesArray);
    }

    public List<String> convertToByteArray(String bits) {
        List<String> bytes = new ArrayList<>();
        char[] bitsChars = bits.toCharArray();
        int chunkSize = 8;
        for (int i = 0; i < bitsChars.length; i += chunkSize) {
            if (i + chunkSize <= bitsChars.length) {
                bytes.add(new String(bitsChars).substring(i, i + chunkSize));
            }
        }
        return bytes;
    }

    public List<Integer> convertToBinaryArray(List<String> bytesArray) {
        List<Integer> binaryArray = new ArrayList<>();
        for (String s : bytesArray) {
            binaryArray.add(Integer.parseInt(s, 2));
        }
        return binaryArray;
    }

    public String convertToLetters(List<Integer> binaryArray) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < binaryArray.size(); i++) {
            int value = binaryArray.get(i);
            text.append((char) value);
        }
        return text.toString();
    }

}
