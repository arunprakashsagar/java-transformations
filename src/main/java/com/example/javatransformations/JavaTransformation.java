package com.example.javatransformations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JavaTransformation {

    public static void main(String[] args) {
        //Feature commit 1
        //Feature commit 2
        //Master commit 1
        //Master commit 111

        String str = "java,C, C++";
        //Java 12 feature not supported in lower versions
        //str.transform(new Transformation());

    }

    public <R> R transform(Function<? super String, ? extends R> function){
        return function.apply(this);
    }
}
class Transformation implements Function<String, List<String>>{
    @Override
    public List<String> apply(String s) {
        return Arrays.asList(s.split(","));
    }

    @Override
    public <V> Function<V, List<String>> compose(Function<? super V, ? extends String> before) {
        return Function.super.compose(before);
    }

    @Override
    public <V> Function<String, V> andThen(Function<? super List<String>, ? extends V> after) {
        return Function.super.andThen(after);
    }
}
