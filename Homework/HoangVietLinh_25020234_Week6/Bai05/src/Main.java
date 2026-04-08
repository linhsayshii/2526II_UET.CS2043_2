public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Kiểm tra Singleton ---");
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();
        System.out.println("log1 == log2: " + (log1 == log2));

        System.out.println("\n--- 2. Kiểm tra Factory Method ---");
        ExportFactory factory;
        factory = new PdfExportFactory();
        factory.doExport();

        factory = new ExcelExportFactory();
        factory.doExport();

        System.out.println("\n--- 3. Kiểm tra Adapter ---");
        Player player = new PlayerAdapter();
        player.play("song.mp3");

        System.out.println("\n--- 4. Kiểm tra Prototype ---");
        Config config = new Config("localhost", 5173);
        Config config2 = config.clone();
        Config config3 = config.clone();
        config2.setIpAddress("ctsv.uet.vnu.edu.vn");
        config2.setPort(4000);
        config3.setIpAddress("portal.uet.vnu.edu.vn");
        config3.setPort(443);
        System.out.println(config);
        System.out.println(config2);
        System.out.println(config3);
        
    }
}
