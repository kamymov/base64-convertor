import constants.Base64Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Encoder {
    public String getBits(byte textBits) {
        return String.format("%8s",
                        Integer.toBinaryString(textBits & 0xFF))
                .replace(' ', '0');
    }
    public List<String> chunkToStringBitsArray(String text) {
        byte[] textByte = text.getBytes(java.nio.charset.StandardCharsets.UTF_8);
        StringBuilder allBits = new StringBuilder();
        for (byte textBits : textByte) {
            allBits.append(getBits(textBits));
        }
        int chunkSize = 6;
        List<String> chunks = new ArrayList<>();
        char[] allBitsArray = allBits.toString().toCharArray();
        for (int i = 0; i < allBitsArray.length ; i += chunkSize) {
            StringBuilder subBits = new StringBuilder();
            for(int j = i; j < i + chunkSize ; j++) {
                if (j < allBitsArray.length) {
                    subBits.append(allBitsArray[j]);
                } else {
                    subBits.append("0");
                }
            }
            chunks.add(subBits.toString());
        }

        return chunks;
    }

    public List<Integer> calcValue(List<String> stringBytes) {
        List<Integer> valueList = new ArrayList<>();
        for(int  i = 0; i < stringBytes.size(); i++) {
            String reversed = new StringBuilder(stringBytes.get(i))
                    .reverse()
                    .toString();
            char[] eachByte = reversed.toCharArray();
            int val = 0;
            for (int j = 5; j >= 0; j--) {
                int result = 1;
                for (int p = 0; p < j; p++) {
                    result *= 2;
                }
                result *= Integer.parseInt(String.valueOf(eachByte[j]));
                val += result;
            }
            valueList.add(val);
        }
        return valueList;
    }

    public String createEncodedText(List<Integer> valueInt) {
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < valueInt.size(); i++) {
            encodedText.append(Base64Table.base64Table[valueInt.get(i)]);
        }
        return encodedText.toString();
    }
}
