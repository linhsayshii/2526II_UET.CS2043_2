public class Main {
    public static void main(String[] args) {
        String text = "Java is a programming language. Java is widely used, and it is very popular! Is Java easy to learn? Yes, it is.";
        NormalizeText normalizeText = new NormalizeText(text);
        System.out.println("Most common word: " + normalizeText.getMostCommonWord());
    }
}
