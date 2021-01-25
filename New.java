import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class New {

    private static List<String> words = Arrays.asList("корова", "бык", "лось", "олень", "лань",
            "волк", "суррикат", "медведь", "заяц", "голубь", "лиса",
            "поросенок", "суслик", "сова", "воробей", "гусь", "лебедь", "полёвка",
            "выпь", "ворон", "лошадь", "единорог", "гном", "леприкон",
            "эльф");

    public static void main(String[] args) throws IOException {
        String guess = getRandomWord(words);
        String maskedGuess = maskWord(guess);
        System.out.println("Что у меня в карманцах, моя прелессть?");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String myWord = br.readLine();
            if (guess.equals(myWord)) {
                System.out.println("Ты победил, " + guess + " действительно находится у меня в карманцах!");
                break;
            } else {
                System.out.println(maskedGuess);
                System.out.println("Неверно, попробуй еще раз :)");
            }
        }

    }

    private static String getRandomWord(List<String> words) {
        Random r = new Random();
        return words.get(r.nextInt(words.size() - 1));
    }

    private static String maskWord(String word) {
        if (word == null || word.isEmpty()) return "";
        int showCount = word.length() == 1? 1: 2;
        String mask = "#############";
        return word.substring(0, showCount) + mask;
    }
}
