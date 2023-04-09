package com.example.javatransformations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class GsonTest {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGsonSerialization() {
        Employee employee = new Employee();
        employee.setName("Rahul");
        employee.setAge(78);
        employee.setAddress("Chandini chouk");
        String FILE_NAME = "src/test/resources/gson_test_serialize.json";

        try {
            GSONSerializationExample.gsonSerialize(FILE_NAME, employee);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Employee deserialEmployee = null;
        try {
            deserialEmployee = GSONSerializationExample.gsonDeSerialize(FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("gson : " + deserialEmployee);
        Assertions.assertNotNull(deserialEmployee);
        Assertions.assertEquals(employee.getAge(), deserialEmployee.getAge());
    }
}
