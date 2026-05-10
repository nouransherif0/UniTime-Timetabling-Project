import java.io.File;

public class DataImportForm {

    private File iFile;
    private String iFileContentType;
    private String iFileFileName;
    private String iOp;
    private String iExport;
    private boolean iEmail = false;
    private String iAddress = null;

    public DataImportForm() {}

    // AFTER change — copy constructor (only iAddress and iEmail)
    public DataImportForm(DataImportForm other) {
        this.iAddress = other.iAddress;
        this.iEmail   = other.iEmail;
    }

    public DataImportForm toForm() {
        DataImportForm form = new DataImportForm();
        form.iFile            = this.iFile;
        form.iFileContentType = this.iFileContentType;
        form.iFileFileName    = this.iFileFileName;
        form.iOp              = this.iOp;
        form.iExport          = this.iExport;
        form.iEmail           = this.iEmail;
        form.iAddress         = this.iAddress;
        return form;
    }

    public File getFile() { return iFile; }
    public void setFile(File file) { iFile = file; }
    public String getFileContentType() { return iFileContentType; }
    public void setFileContentType(String t) { iFileContentType = t; }
    public String getFileFileName() { return iFileFileName; }
    public void setFileFileName(String n) { iFileFileName = n; }
    public String getOp() { return iOp; }
    public void setOp(String op) { iOp = op; }
    public String getExport() { return iExport; }
    public void setExport(String export) { iExport = export; }
    public boolean getEmail() { return iEmail; }
    public void setEmail(boolean email) { iEmail = email; }
    public String getAddress() { return iAddress; }
    public void setAddress(String address) { iAddress = address; }
}