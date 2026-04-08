public class Main {
    public static void main(String[] args) {
        UIFactory factory;
        String os = "win";

        if (os.equalsIgnoreCase("win")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        System.out.println("--- Initialize UI ---");
        button.render();
        checkbox.render();
    }
}