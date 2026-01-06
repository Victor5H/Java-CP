package daily.TwentyFive.twentyTwoSep;

public class RunLengthEncoding {
    public static String encode(String input) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i + 1) == input.charAt(i)) {
                count++;
                i++;
            }
            out.append(input.charAt(i));
            out.append(count);
        }
        return out.toString();
    }

    public static String decode(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < input.length(); i+=2) {
            int times = input.charAt(i)-'0';
            sb.append(String.valueOf(input.charAt(i - 1)).repeat(Math.max(0, times)));

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String encoded = encode("abbccddab");
        System.out.println(encoded);
        System.out.println(decode(encoded));
    }
}
