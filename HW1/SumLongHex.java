import java.math.BigInteger;

public class SumLongHex {
    public static void main(String[] args) {
        long sum = 0;

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

    private static long parseNumber(StringBuilder number) {
        if (number.charAt(0) == '0' && (number.charAt(1) == 'x' || number.charAt(1) == 'X')) {
            return new BigInteger(number.toString().substring(2), 16).longValue();
        } else {
            return Long.parseLong(number.toString());
        }
    }
}
