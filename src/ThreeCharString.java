public class ThreeCharString {
    public static void main(String[] args) {
        String input = "leeetcode";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            int len = sb.length();
            // check last two chars in sb + current char
            if (len >= 2 && sb.charAt(len - 1) == input.charAt(i) && sb.charAt(len - 2) == input.charAt(i)) {
                continue; // skip adding this character
            }
            sb.append(input.charAt(i));
        }
        System.out.println(sb);
    }
}
