package data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class dataReader {

	
	public void getJsonDataToMap() throws IOException {
		FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//main//java//data//purchase.json"));
	}
	
	

	}


