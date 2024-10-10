package net.worthington.mavensample;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class CharEncoding {
    public static void main(String[] args) {

        System.out.println("Default Charset: " + Charset.defaultCharset());

        // print hex value of each character in the string
        // String str = "aóa\u00F3a\u6f01a";
        // doIt(str);

        String str = "2021 PLanilla de contribución sobre ingresos radicada.pdf";
        String chr = str.substring(27, 28);
        doIt(chr);

        String decomposed = Normalizer.normalize(chr, Normalizer.Form.NFD);
        System.out.println("Decomposed: " + decomposed);
        doIt(decomposed);


        // System.out.println("====================================");
        // System.out.println(" Normal ");
        // System.out.println("====================================");
        // doIt("a");
        // doIt("ó");
        // doIt("\u00F3");
        // doIt("\u6f01");
        // doIt("ión");

        // System.out.println("====================================");
        // System.out.println(" To ISO_8859_1 ");
        // System.out.println("====================================");
        // doIt(new String("\u6f01".getBytes(StandardCharsets.ISO_8859_1),
        // StandardCharsets.ISO_8859_1));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_8),
        // StandardCharsets.ISO_8859_1));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_16),
        // StandardCharsets.ISO_8859_1));

        // System.out.println("====================================");
        // System.out.println(" To UTF-8 ");
        // System.out.println("====================================");
        // doIt(new String("\u6f01".getBytes(StandardCharsets.ISO_8859_1),
        // StandardCharsets.UTF_8));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_8),
        // StandardCharsets.UTF_8));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_16),
        // StandardCharsets.UTF_8));

        // System.out.println("====================================");
        // System.out.println(" To UTF-16 ");
        // System.out.println("====================================");
        // doIt(new String("\u6f01".getBytes(StandardCharsets.ISO_8859_1),
        // StandardCharsets.UTF_16));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_8),
        // StandardCharsets.UTF_16));
        // doIt(new String("\u6f01".getBytes(StandardCharsets.UTF_16),
        // StandardCharsets.UTF_16));
    }

    private static void doIt(String str) {
        System.out.println(str);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println("Character: " + c + " value: " + (int) c);
            System.out.println("Character: " + c + " value: " + Integer.toHexString(c));
        }

        // Print encoding of the string in UTF-8
        byte[] utf8Bytes = str.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8 Encoding: " + Arrays.toString(utf8Bytes));
        System.out.println("UTF-8 Hex: " + bytesToHex(utf8Bytes));

        // Print encoding of the string in UTF-16
        byte[] utf16Bytes = str.getBytes(StandardCharsets.UTF_16);
        System.out.println("UTF-16 Encoding: " + Arrays.toString(utf16Bytes));
        System.out.println("UTF-16 Hex: " + bytesToHex(utf16Bytes));
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
