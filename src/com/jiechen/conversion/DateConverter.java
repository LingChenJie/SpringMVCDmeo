package com.jiechen.conversion;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        try {
            if(null != source){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.parse(source);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
