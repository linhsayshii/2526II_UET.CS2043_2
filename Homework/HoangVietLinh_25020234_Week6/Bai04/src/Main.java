public class Main {
    public static void main(String[] args) {
        Sorter sorter = new SorterAdapter();
        int[] arr = {5,2,9,1,6};
        sorter.sort(arr);
        System.out.println(java.util.Arrays.toString(arr));

        ReportTemplate report = new ReportTemplate("Title", "Footer", java.util.Arrays.asList("Section1", "Section2"));
        ReportTemplate report2 = report.clone();
        ReportTemplate report3 = report.clone();
        report2.setTitle("Report2");
        report3.setTitle("Report3");
        System.out.println(report);
        System.out.println(report2);
        System.out.println(report3);
    }
}
