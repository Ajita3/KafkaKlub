package util;

import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class ImageUtil {

    public boolean uploadImage(Part filePart, String rootPath, String folderName) {
        String fileName = getFileName(filePart);
        if (fileName != null && !fileName.isEmpty()) {
            String uniqueID = UUID.randomUUID().toString();
            String newFileName = uniqueID + "_" + fileName;
            Path uploadDir = Paths.get(rootPath, "resources", "images", folderName);

            try {
                if (!Files.exists(uploadDir)) {
                    Files.createDirectories(uploadDir);
                }

                InputStream fileContent = filePart.getInputStream();
                Path filePath = uploadDir.resolve(newFileName);
                Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
                return true;
            } catch (IOException e) {
                System.out.println("Error uploading image: " + e.getMessage());
            }
        }
        return false;
    }

    public String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (contentDisposition != null && contentDisposition.contains("filename=")) {
            String[] parts = contentDisposition.split(";");
            for (String partStr : parts) {
                partStr = partStr.trim();
                if (partStr.startsWith("filename=")) {
                    return partStr.substring(partStr.indexOf("=") + 2, partStr.length() - 1);
                }
            }
        }
        return null;
    }

    public String getImageNameFromPart(Part part) {
        String fileName = getFileName(part);
        if (fileName != null && !fileName.isEmpty()) {
            String uniqueID = UUID.randomUUID().toString();
            String newFileName = uniqueID + "_" + fileName;
            return newFileName;
        }
        return null;
    }
}
