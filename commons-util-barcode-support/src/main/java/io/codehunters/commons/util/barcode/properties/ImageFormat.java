package io.codehunters.commons.util.barcode.properties;

public enum ImageFormat {
    PNG("png"),
    JPG("jpg");

    private String format;

    ImageFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
