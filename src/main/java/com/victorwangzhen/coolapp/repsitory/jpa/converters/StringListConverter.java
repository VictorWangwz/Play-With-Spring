package com.victorwangzhen.coolapp.repsitory.jpa.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Converter
public class StringListConverter implements AttributeConverter<List<String>, String> {

    private static final String SPLIT_CHAR = ",";

    @Override
    public String convertToDatabaseColumn(List<String> strings) {
        if(strings == null){
            return null;
        }
        return String.join(SPLIT_CHAR, strings);
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        if(s == null){
            return new ArrayList<>();
        }
        return Arrays.asList(s.split(SPLIT_CHAR));
    }


}
