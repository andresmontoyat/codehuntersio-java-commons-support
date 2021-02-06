package io.codehunters.commons.util.barcode.properties;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BarcodeProperties {

    public static final String IMAGE_FORMAT_PNG = "png";
    public static final String IMAGE_FORMAT_JPG = "jpg";

    private int resolution;

    //BufferedImage.TYPE_BYTE_BINARY
    private int imageType;

    private String imageFormat;

    private boolean antiAlias;

    private int orientation;

    private String pathFile;

}
