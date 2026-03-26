public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> age = new Pair<String, Integer>("Tuổi", 20);
        Pair<String, String> student = new Pair<String, String>("Mã SV", "SV001");
        Pair<Integer, Double> geolocation = new Pair<Integer, Double>(105, 21.5);
        System.out.println(age);
        System.out.println(student);
        System.out.println(geolocation);
    }
}
