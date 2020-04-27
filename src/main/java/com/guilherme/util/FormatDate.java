package com.guilherme.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class FormatDate {

//"dd/MM/yyyy";
    
    public static Date parse(Date date2, String format){
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(date);
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
    }
}
