interface Export {
    void exportData();
}

class PdfExport implements Export {
    @Override
    public void exportData() {System.out.println("Exporting data to PDF");}
}

class ExcelExport implements Export {
    @Override
    public void exportData() {System.out.println("Exporting data to Excel");}
}

abstract class ExportFactory {
    public abstract Export createExport();
    public void doExport() {
        Export export = createExport();
        export.exportData();
    }
}

class PdfExportFactory extends ExportFactory {
    @Override
    public Export createExport() {return new PdfExport(); }
}

class ExcelExportFactory extends ExportFactory {
    @Override
    public Export createExport() {return new ExcelExport(); }
}
    