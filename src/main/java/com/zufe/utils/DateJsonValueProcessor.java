package com.zufe.utils;

import java.io.Writer;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

public class DateJsonValueProcessor implements JsonValueProcessor {
	private String datePattern = "yyyy-MM-dd HH:mm:ss"; 

    /** 
     * JsonDateValueProcessor 
     */ 
    public DateJsonValueProcessor() { 
        super(); 
    } 

    /** 
     * @param format 
     */ 
    public DateJsonValueProcessor(String format) { 
        super(); 
        this.datePattern = format; 
    } 

    /** 
     * @param value 
     * @param jsonConfig 
     * @return Object 
     */ 
    public Object processArrayValue(Object value, JsonConfig jsonConfig) { 

        return process(value); 
    } 

    /** 
     * @param key 
     * @param value 
     * @param jsonConfig 
     * @return Object 
     */ 
    public Object processObjectValue(String key, Object value, 
            JsonConfig jsonConfig) { 

        return process(value); 
    } 

    /** 
     * process 
     * @param value 
     * @return 
     */ 
	private Object process(Object value){

		   try { 
	            if (value instanceof Date) { 
	            	   SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern,Locale.UK); 
	            	return dateFormat.format((Date)value);
	            } 
	            else if(value instanceof Timestamp)
	            {
	            	  SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern,Locale.UK); 
	            	return dateFormat.format(new Date(((Timestamp)value).getTime()));
	            }
	            return value == null ? "" : value.toString(); 
	        } catch (Exception e) { 
	            return ""; 
	        } 	
		
	}
	public static void main(String []argus)
	{
		
		Timestamp d = new Timestamp(0);

		JsonConfig config = new JsonConfig();
		config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyyMMdd HH:mm:ss")); 

		//JSONArray jo = ; 

	}


}