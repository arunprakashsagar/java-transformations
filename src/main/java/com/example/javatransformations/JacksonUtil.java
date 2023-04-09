package com.example.javatransformations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JacksonUtil {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void serialize(String filepath, Employee employee){
        try {
            objectMapper.writeValue(new File(filepath), employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee deSerialize(String filepath){
        try {
            return objectMapper.readValue(new File(filepath), Employee.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
