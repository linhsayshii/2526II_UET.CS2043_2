public class Compare {
    public static void useString() {
        long startTime = System.currentTimeMillis();
        String str = "";
        for (int i=0; i<100000;i++) {
            str += "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("useString: " + (endTime - startTime) + "s");
    }
    public static void useStringBuffer() {
        long startTime = System.currentTimeMillis();
        StringBuffer strbuf = new StringBuffer();
        for (int i=0; i<100000;i++) {
            strbuf.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("useStringBuffer: " + (endTime - startTime) + "s");
    }
    public static void contentAnalysis(String text) {
        //Đếm số câu
        int sentenceCount = 0;
        for (int i=0; i<text.length();i++) {
            char c=text.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                sentenceCount++;
            }
        }
        System.out.println("Số lượng câu: " + sentenceCount);

        //Find and Replace (Java with Python)
        String replacedText = text.replace("Java", "Python");
        System.out.println("Text sau khi thay thế Java bằng Python: " + replacedText);
    }
}
