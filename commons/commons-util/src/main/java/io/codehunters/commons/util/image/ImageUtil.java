package io.codehunters.commons.util.image;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ImageUtil {

    public static String encodeToString(File image) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void decodeToFile(File file, String encodeImage) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(encodeImage);
        FileUtils.writeByteArrayToFile(file, decodedBytes);
    }
}
