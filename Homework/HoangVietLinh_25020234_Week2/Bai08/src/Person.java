public class Person {
    private final String name;
    private Person me;
    public Person(String name) {
        this.name = name;
    }
    public void setMe(Person other) {
        this.me = other;
    }
    public Person getMe() {
        return me;
    }
    public String getName() {
        return name;
    }


}
