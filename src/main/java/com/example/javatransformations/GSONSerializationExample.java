package com.example.javatransformations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class GSONSerializationExample {
    public static void main(String[] args) {
        String FILE_NAME = "gson_employee_ser.txt";
        Employee employee = new Employee();
        employee.setAge(10);
        employee.setName("John");
        serializeUsingOutputStream(FILE_NAME, employee);
        deSerializeUsingOutputStream(FILE_NAME);
    }


    public static void gsonSerialize(String filename, Employee employee) throws IOException {
        try(Writer fileWriter = new FileWriter(filename);){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(employee, fileWriter);
        }
    }
    public static Employee gsonDeSerialize(String filename) throws IOException {
        try(FileReader fileReader = new FileReader(filename);
        ){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.fromJson(fileReader, Employee.class);
        }
    }
    public static Employee deSerializeUsingOutputStream(String filename) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(filename);
            objectInputStream = new ObjectInputStream(fileInputStream);
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.println(employee.toString());
            return employee;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void serializeUsingOutputStream(String filename, Employee employee) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filename);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
