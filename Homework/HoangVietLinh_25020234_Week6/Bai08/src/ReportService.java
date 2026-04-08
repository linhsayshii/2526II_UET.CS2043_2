public class ReportService {
    private final ReportFormatter formatter;

    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }
    public String generateReport(Report report) {
        return formatter.format(report.getContent());
    }
}
