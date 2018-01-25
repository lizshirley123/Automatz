package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AUL {
	public static String getConfig(String URL,String key) {
		String s=" ";
		try {
			Properties p=new Properties();
			p.load(new FileInputStream(URL));
			s = p.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return s;
	}
	public static void takePhoto(String folder,String testName,WebDriver driver) {
		String date=new Date().toString().replaceAll(":","-");
		TakesScreenshot t=(TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String dst=folder+" "+testName+" "+date+" "+".png";
		try {
			FileUtils.copyFile(src,new File(dst));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
