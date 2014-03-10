package com.gaesuperadmin.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

/**
 * @author Vijay
 * 
 */
public class AbstractRemoteApiInstaller {
	
	public static final String PROPERTIES_FILE = "gaesuperadmin.properties";

	public void install() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
		Properties prop = new Properties();
		prop.load(fileInputStream);
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