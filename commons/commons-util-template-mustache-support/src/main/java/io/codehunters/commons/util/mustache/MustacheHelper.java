package io.codehunters.commons.util.mustache;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.github.mustachejava.MustacheFactory;
import lombok.*;

import java.io.*;

@Data
@Builder
@AllArgsConstructor
public class MustacheHelper {

    private MustacheFactory mustacheFactory;

    public String parse(Object parameters, String strTemplate) {
        StringWriter stringWriter = new StringWriter();
        try (Writer writer = new BufferedWriter(stringWriter)) {
            Mustache mustache = mustacheFactory.compile(new StringReader(strTemplate), "template");
            mustache.execute(writer, parameters);
            writer.flush();
        } catch (IOException e) {
            throw new MustacheException("An error has occurred trying to execute mustache compiler template");
        }

        return stringWriter.toString();
    }
}
