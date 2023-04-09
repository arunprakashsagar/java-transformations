package com.example.javatransformations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaTransformationsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testObjectSerialization(){
        Employee employee = new Employee();
        employee.setName("Rahul");
        employee.setAge(78);
        employee.setAddress("Chandini chouk");
        String FILE_NAME = "test_seriaalize.txt";
        SerializationExample.serializeUsingOutputStream(FILE_NAME, employee);
        Employee deserializedEmployee = SerializationExample.deSerializeUsingOutputStream(FILE_NAME);
        System.out.println("deserial : " + deserializedEmployee);
        Assertions.assertNotNull(deserializedEmployee);
        Assertions.assertEquals(employee.getAge(), deserializedEmployee.getAge());
        Assertions.assertNull(deserializedEmployee.getAddress());
    }
}
