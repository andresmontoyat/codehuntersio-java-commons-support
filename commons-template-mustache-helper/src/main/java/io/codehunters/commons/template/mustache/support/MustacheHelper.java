package io.codehunters.commons.template.mustache.support;

import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheException;
import com.github.mustachejava.MustacheFactory;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
public class MustacheHelper {

    private MustacheFactory mustacheFactory;

    public MustacheHelper(MustacheFactory mustacheFactory) {
        this.mustacheFactory = mustacheFactory;
    }

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
