package io.codehunters.commons.util.barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import io.codehunters.commons.util.barcode.properties.BarcodeProperties;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.int2of5.Interleaved2Of5Bean;
import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;
import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.impl.upcean.UPCABean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BarcodeUtil {

    public static BufferedImage generateITFBarcodeImage(String barcodeText) {
        Interleaved2Of5Bean barcodeGenerator = new Interleaved2Of5Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generateUPCABarcodeImage(String barcodeText) {
        UPCABean barcodeGenerator = new UPCABean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) {
        EAN13Bean barcodeGenerator = new EAN13Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generateCode39BarcodeImage(String barcodeText) {
        Code39Bean barcodeGenerator = new Code39Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generateCode128BarcodeImage(String barcodeText) {
        Code128Bean barcodeGenerator = new Code128Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generatePDF417BarcodeImage(String barcodeText) {
        PDF417Bean barcodeGenerator = new PDF417Bean();
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        barcodeGenerator.generateBarcode(canvas, barcodeText);
        return canvas.getBufferedImage();
    }

    public static BufferedImage generateQRCodeImage(String barcodeText, int width, int height) throws WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, width, height);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public static Result readQRCodeImage(File file) throws IOException, FormatException, ChecksumException, NotFoundException {
        QRCodeReader barcodeReader = new QRCodeReader();
        InputStream barCodeInputStream = new FileInputStream(file);
        BufferedImage barCodeBufferedImage = ImageIO.read(barCodeInputStream);
        LuminanceSource source = new BufferedImageLuminanceSource(barCodeBufferedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        return barcodeReader.decode(bitmap);
    }

    public static void writeFile(BufferedImage bufferedImage, BarcodeProperties barcodeProperties) throws IOException {
        ImageIO.write(bufferedImage, barcodeProperties.getImageFormat(), new File(barcodeProperties.getPathFile()));
    }

}
