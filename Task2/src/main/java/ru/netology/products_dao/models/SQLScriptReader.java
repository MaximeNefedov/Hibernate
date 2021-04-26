package ru.netology.products_dao.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class SQLScriptReader {
    private final String scriptFileName;

    public SQLScriptReader(@Value("${sql.scripts.name}") String scriptFileName) {
        this.scriptFileName = scriptFileName;
    }

    public String getSqlScript() {
        String sqlScript;
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            sqlScript = bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlScript;
    }
}
