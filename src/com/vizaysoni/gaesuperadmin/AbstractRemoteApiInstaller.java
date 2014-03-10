package com.vizaysoni.gaesuperadmin;

import java.io.IOException;

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

	public void install() throws IOException {
		RemoteApiOptions options = new RemoteApiOptions().server(SERVER, PORT).credentials(USERNAME, PASSWORD);
		RemoteApiInstaller installer = new RemoteApiInstaller();
		installer.install(options);
	}

}