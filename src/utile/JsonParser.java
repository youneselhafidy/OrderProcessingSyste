package utile;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonParser {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJsonFile(String filePath,Class<T> valueType) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file,valueType);
    }
    public static <T> T writeJsonFile(T data, FileWriter writer) throws IOException {
        objectMapper.writeValue(writer,data);
    }
}
