public class SumDouble {
    public static void main(String[] args) {
        double sum = 0;

        for (String arg : args) {
            StringBuilder curNumber = new StringBuilder();

            for (int i = 0; i < arg.length(); i++) {
                char c = arg.charAt(i);

                if (Character.isWhitespace(c)) {
                    if (curNumber.length() > 0) {
                        sum += Double.parseDouble(curNumber.toString());
                    }

                    curNumber = new StringBuilder();
                } else {
                    curNumber.append(c);
                }
            }

            if (curNumber.length() > 0) {
                sum += Double.parseDouble(curNumber.toString());
            }
        }

        System.out.println(sum);
    }
}
