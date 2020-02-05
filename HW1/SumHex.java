public class SumHex {
    public static void main(String[] args) {
        int sum = 0;

        for (String arg : args) {
            StringBuilder curNumber = new StringBuilder();

            for (int i = 0; i < arg.length(); i++) {
                char c = arg.charAt(i);

                if (Character.isWhitespace(c)) {
                    if (curNumber.length() > 0) {
                        sum += parseNumber(curNumber);
                    }

                    curNumber = new StringBuilder();
                } else {
                    curNumber.append(c);
                }
            }

            if (curNumber.length() > 0) {
                sum += parseNumber(curNumber);
            }
        }

        System.out.println(sum);
    }

    private static int parseNumber(StringBuilder number) {
        if (number.charAt(0) == '0' && (number.charAt(1) == 'x' || number.charAt(1) == 'X')) {
            return (int) Long.parseLong(number.toString().substring(2), 16);
        } else {
            return Integer.parseInt(number.toString());
        }
    }
}
