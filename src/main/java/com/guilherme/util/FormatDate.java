package com.guilherme.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class FormatDate {

//"dd/MM/yyyy";
    
    public static Date parse(String initialDate, String format){
        
        SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			String date = null;
			return sdf.parse(date);
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
    }
}
