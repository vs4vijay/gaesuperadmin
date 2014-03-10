package com.gaesuperadmin.client.desktop;

import java.io.IOException;

import com.gaesuperadmin.service.DataFetchService;


public class RemoteApiDemo {

	public static void main(String[] args) throws IOException {
		
		DataFetchService dataFetchService = DataFetchService.getDataFetchService();
		
		System.out.println(dataFetchService.getEntitiesByName("Event"));
		System.out.println(dataFetchService.getEntitiesByName("AcademicYear"));
	}

}
