package io.codehunters.commons.util.barcode.properties;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BarcodeProperties {

    private int resolution;

    //BufferedImage.TYPE_BYTE_BINARY
    private int imageType;

    private ImageFormat imageFormat;

    private boolean antiAlias;

    private int orientation;

    private String pathFile;

}
