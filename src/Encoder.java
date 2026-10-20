import java.util.ArrayList;
import java.util.List;

public class Encoder {
    public String getBits(byte textBits) {
        return String.format("%8s",
                        Integer.toBinaryString(textBits & 0xFF))
                .replace(' ', '0');
    }
    public List<String> chunkToArray(String text) {
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
            for(int j = i; j < i + chunkSize; j++) {
                subBits.append(allBitsArray[j]);
            }
            if (subBits.length() == 4) {
                subBits.append("00");
            }
            chunks.add(subBits.toString());
        }
        return chunks;
    }

}
