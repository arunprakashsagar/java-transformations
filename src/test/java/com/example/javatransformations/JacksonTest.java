package com.example.javatransformations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class JacksonTest {

    @Test
    public void testJacksonSerializeDeserialize(){
        Employee employee = new Employee();
        employee.setName("Rahul");
        employee.setAge(78);
        employee.setAddress("Chandini chouk");
        String FILE_NAME = "src/test/resources/jackson_test_serialize.json";

        JacksonUtil.serialize(FILE_NAME, employee);
        Employee deserialEmployee = JacksonUtil.deSerialize(FILE_NAME);
        System.out.println("jackson : " + deserialEmployee);
        Assertions.assertNotNull(deserialEmployee);
        Assertions.assertEquals(employee.getAge(), deserialEmployee.getAge());
    }
}
