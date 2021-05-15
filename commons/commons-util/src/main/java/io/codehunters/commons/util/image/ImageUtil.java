package io.codehunters.commons.util.image;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageUtil {

    public static String encodeToString(String filename, byte[] image) throws IOException {
        File file = new File(filename);
        FileUtils.writeByteArrayToFile(file, image);
        return encodeToString(file);
    }

    public static String encodeToString(File image) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(image);
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static void decodeToFile(File file, String encodeImage) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(encodeImage);
        FileUtils.writeByteArrayToFile(file, decodedBytes);
    }
}
