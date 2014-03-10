package com.vizaysoni.gaesuperadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

/**
 * @author Vijay
 * 
 */
public class AbstractRemoteApiInstaller {
	
	public static final String USERNAME = "";
	
	public static final String PASSWORD = "";
	
	public static final String SERVER = "localhost";
	
	public static final int PORT = 9876;
	
	public static final String PROPERTIES_FILE = "gaesuperadmin.properties";

	public void install() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
		Properties prop = new Properties();
		prop.load(fileInputStream);
		
		System.out.println("aaa : " + prop.getProperty("server"));
		
		RemoteApiInstaller installer = new RemoteApiInstaller();
		try {
			RemoteApiOptions options = new RemoteApiOptions().server(prop.getProperty("server"), Integer.parseInt(prop.getProperty("port")))
															 .credentials(prop.getProperty("username"), prop.getProperty("password"));
			installer.install(options);
		} catch (Exception e) {
			installer.uninstall();
		}
	}

}