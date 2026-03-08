public class Main {
    public static void main(String[] args) {
        Person p = new Person("Linh");
        p.setMe(p);
        System.out.println(p.getMe().getName());
        p = null;
    }   
}