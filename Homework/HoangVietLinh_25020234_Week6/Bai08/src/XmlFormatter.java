public class XmlFormatter implements ReportFormatter {
    @Override
    public String format(String data) {
        return "<report>" + data + "</report>";
    }
}
