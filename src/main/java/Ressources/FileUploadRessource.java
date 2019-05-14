package Ressources;

import Entities.FileToUpload;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("file")

public class FileUploadRessource  {


    public String getFileName(boolean isImg) {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
       if (isImg)
        return "PNG_" + timeStamp + "_.png";
        return "PDF_" + timeStamp + "_.pdf";
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response upload(FileToUpload file) {
        //System.out.println(imageBytes);
        String fileName= getFileName(file.getType().equals("img"));
        file.setFileName(fileName);
        byte[] data = java.util.Base64.getDecoder().decode(file.getBase64().getBytes(StandardCharsets.UTF_8));
        String filePath;
if (file.getType().equals("img"))
{
    filePath = "/home/khlayil/Documents/work/freelance/ahkbcp/AHK/web/uploads/images/"+ fileName ;

}else
         filePath = "/home/khlayil/Documents/work/freelance/ahkbcp/AHK/web/uploads/bdc/"+ fileName ;

        try (OutputStream stream = new FileOutputStream(filePath)) {
            stream.write(data);
            return Response.status(Response.Status.OK).entity(file).build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.NO_CONTENT).entity(file).build();

/*
        String fileName= getFileName();
        //String filePath = "e:/Test/Server/Upload/" + fileName;
        String filePath = "/home/khlayil/Documents/work/freelance/ahkbcp/AHK/web/uploads/images/"+ fileName ;

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream outputStream = new BufferedOutputStream(fos);
            outputStream.write(imageBytes);
            outputStream.close();

            System.out.println("Received file: " +fileName);
            return Response.status(Response.Status.OK).entity(fileName).build();


        } catch (IOException ex) {
ex.printStackTrace();

            throw new WebServiceException(ex);
        }*/

    }


}