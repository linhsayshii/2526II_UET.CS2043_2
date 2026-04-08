public class JsonFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "{\"data\":\"" + data + "\"}";
    }
}
