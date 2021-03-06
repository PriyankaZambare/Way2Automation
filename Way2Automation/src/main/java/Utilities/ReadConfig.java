package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configures\\Config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
		
		public String getApplicationURL()
		{
			String url=pro.getProperty("BaseURL");
			return url;
			
		}
		
		public String getUsername()
		{
			String Username=pro.getProperty("username");
			return Username;
			
		}
		
		public String getPassword()
		{
			String Password=pro.getProperty("password");
			return Password;
		}
		
		public String getChromepath()
		{
			String chromepath=pro.getProperty("chromepath");
			return chromepath;
		}
		
		public String getiepath()
		{
			String IEpath=pro.getProperty("iepath");
			return IEpath;
		}
		
		public String getFirefoxpathh()
		{
			String firefoxpath=pro.getProperty("firefoxpath");
			return firefoxpath;
		}
	

}
