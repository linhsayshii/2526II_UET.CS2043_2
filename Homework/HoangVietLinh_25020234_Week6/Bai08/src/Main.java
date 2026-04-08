public class Main {
    public static void main(String[] args) {
        Report report = new Report("Report", "This is a report");
        
        ReportFormatter xmlFormatter = new XmlFormatter();
        ReportService xmlService = new ReportService(xmlFormatter);
        System.out.println(xmlService.generateReport(report));

        System.out.println("\n");
        ReportFormatter jsonFormatter = new JsonFormatter();
        ReportService jsonService = new ReportService(jsonFormatter);
        System.out.println(jsonService.generateReport(report));
    }
}
