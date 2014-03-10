package com.gaesuperadmin.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entities;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class DataFetchService extends AbstractRemoteApiInstaller {
	
	private static DataFetchService dataFetchService;
	
	private final DatastoreService datastoreService ;
	
	private DataFetchService() throws IOException {
		super();
		super.install();
		datastoreService = DatastoreServiceFactory.getDatastoreService();
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
		Query query = new Query(entityName);
		PreparedQuery preparedQuery = datastoreService.prepare(query);
		FetchOptions fetchOptions = FetchOptions.Builder.withDefaults();
        List<Entity> entities = preparedQuery.asList(fetchOptions);
        return entities;
	}
	
	public Collection<String> getAllEntityNames() {
		Set<String> entityNameSet = new TreeSet<String>();
		Query query = new Query(Entities.KIND_METADATA_KIND);
		for (Entity entity : datastoreService.prepare(query).asIterable()) {
			entityNameSet.add(entity.getKey().getName());
		}
		return entityNameSet;
	}
	
	public Collection<String> getProperitiesByEntityName(String entityName) {
		Set<String> propertyNameSet = new TreeSet<String>();
		Query query = new Query(Entities.PROPERTY_METADATA_KIND);
		query.setAncestor(Entities.createKindKey(entityName));
		for (Entity entity : datastoreService.prepare(query).asIterable()) {
			propertyNameSet.add(entity.getKey().getName());
		}
		return propertyNameSet;
	}

}
