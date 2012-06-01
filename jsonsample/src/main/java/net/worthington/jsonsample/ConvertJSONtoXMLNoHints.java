package net.worthington.jsonsample;

import java.io.InputStream;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.JSONTypes;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;

public class ConvertJSONtoXMLNoHints {

	public static void main(String[] args) throws Exception {
		InputStream is = 
			ConvertJSONtoXMLNoHints.class.getResourceAsStream("sample-json.txt");
		String jsonData = IOUtils.toString(is);
		
		XMLSerializer serializer = new XMLSerializer(); 
		JSON json = JSONSerializer.toJSON( jsonData ); 
		serializer.setTypeHintsEnabled(false);
		String xml = serializer.write( json );  
		System.out.println(xml);  		
		
	}
}
