package io.codehunters.commons.util.file;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileUtil {

    public static String extractExtension(String filename) {
        return filename.substring(filename.lastIndexOf("."));
    }

    public static String replaceFilename(String filename, String replaceName) {
        return replaceName + extractExtension(filename);
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Image {

        public static String encodeToString(File image) throws IOException {
            byte[] fileContent = FileUtils.readFileToByteArray(image);
            return Base64.getEncoder().encodeToString(fileContent);
        }

        public static String encodeToString(byte[] image) throws IOException {
            return Base64.getEncoder().encodeToString(image);
        }

        public static File decodeToFile(String filename, String encodeImage) throws IOException {
            File file = new File(filename);
            FileUtils.writeByteArrayToFile(file, decodeToFile(encodeImage));
            return file;
        }

        public static byte[] decodeToFile(String encodeImage) throws IOException {
            return Base64.getDecoder().decode(encodeImage);
        }
    }
}
