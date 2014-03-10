package com.gaesuperadmin.service;

import java.io.IOException;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DataFetchService extends AbstractRemoteApiInstaller {
	
	private static DataFetchService dataFetchService;
	
	private DataFetchService() throws IOException {
		super();
		super.install();
	}
	
	public static DataFetchService getDataFetchService() throws IOException {
		synchronized (DataFetchService.class) {
			if(dataFetchService == null) {
				dataFetchService = new DataFetchService();
			}
		}
		return dataFetchService;
	}
	
	public List<Entity> getEntitiesByName(String entityName) {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query(entityName);
		PreparedQuery preparedQuery = ds.prepare(query);
		FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
        List<Entity> entities = preparedQuery.asList(fetchOptions);
        return entities;
	}

}
