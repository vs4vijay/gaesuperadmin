package com.vizaysoni.gaesuperadmin;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;

public class RemoteApiDemo extends AbstractRemoteApiInstaller{

	public static void main(String[] args) throws IOException {

		new RemoteApiDemo().install();
		System.out.println("hello " + SERVER);
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		System.out.println("Key of new entity is " + ds.put(new Entity("111")));
		
		
		
		Query query = new Query("Event");
		
		
		/*query.setKeysOnly();
		Set keys = new HashSet();
		for (Entity entity : ds.prepare(query).asList(FetchOptions.Builder.withLimit(500))) {
		keys.add(entity.getKey());
		}*/
		
		 PreparedQuery preparedQuery = ds.prepare(query);
		
		 FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
         List<Entity> entities = preparedQuery.asList(fetchOptions);
         
         for (Entity entity : entities) {
     		System.out.println(entity);
            // System.out.println(entity.getProperty("state"));
         }
		

		/*int count = 0;
		//while(true) {
			String username = "";
			String password = "";
			//RemoteApiOptions options = new RemoteApiOptions().server("qa-metacampus.appspot.com",443).credentials(username, password);
			RemoteApiOptions options = new RemoteApiOptions().server("localhost",9876).credentials(username, password);
			RemoteApiInstaller installer = new RemoteApiInstaller();
			installer.install(options);
			
			try {
				DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
				//System.out.println("Key of new entity is " + ds.put(new Entity("Hello Remote API!")));
				
				
				Query query = new Query("ConsolidationStage");
				
				Key key = KeyFactory.createKey("ConsolidationStage", "6597069766656000");
				
				//query.addFilter("__key__", FilterOperator.EQUAL, key);
				
				
	            PreparedQuery preparedQuery = ds.prepare(query);
	            FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
	            List<Entity> entities = preparedQuery.asList(fetchOptions);
	            for (Entity entity : entities) {
	            		entity.setProperty("state", "COMPLETED");
	            		ds.put(entity);
	            		System.out.println(entity);
	                   // System.out.println(entity.getProperty("state"));
	            }
	            System.out.println("----Done stage " + count++);
	            
	            
	            
	            
	            
	            query = new Query("ConsolidationStage");
				key = KeyFactory.createKey("Consolidation", 15382015);
				query.addFilter("consolidationKey", FilterOperator.EQUAL, key);
				
				
				preparedQuery = ds.prepare(query);
	            fetchOptions = FetchOptions.Builder.withDefaults();
	            entities = preparedQuery.asList(fetchOptions);
	            for (Entity entity : entities) {
	            		//System.out.println(entity);
	                    System.out.println(entity.getProperty("state"));
	            }
	            System.out.println("----Done2 consolidation " + count++);
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				installer.uninstall();
			}*/
		//}
		
		
	}

}
