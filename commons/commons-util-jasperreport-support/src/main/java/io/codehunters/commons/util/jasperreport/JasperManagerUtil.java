package io.codehunters.commons.util.jasperreport;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JasperManagerUtil {

    public static byte[] fill(InputStream report, Map<String, Object> params) throws JRException {
        return fill(report, params, new JREmptyDataSource(), new SimplePdfExporterConfiguration());
    }

    public static byte[] fill(InputStream report, Map<String, Object> params, JRDataSource dataSource) throws JRException {
        return fill(report, params, dataSource, null);
    }

    public static byte[] fill(InputStream report, Map<String, Object> params, JRDataSource dataSource, SimplePdfExporterConfiguration pdfExporterConfiguration) throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport(report);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);

        JRPdfExporter exporter = new JRPdfExporter();
        if (Optional.ofNullable(pdfExporterConfiguration).isPresent()) {
            exporter.setConfiguration(pdfExporterConfiguration);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        exporter.setExporterInput(SimpleExporterInput.getInstance(Arrays.asList(jasperPrint)));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();

        return outputStream.toByteArray();
    }
}
