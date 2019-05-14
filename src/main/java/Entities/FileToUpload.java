package Entities;

public class FileToUpload {


    private String base64;
    private String fileName;
    private String type;

    public FileToUpload(String base64, String type) {
        this.base64 = base64;
        this.type = type;
    }

    public FileToUpload() {
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
