package com.serviceenabled.dropwizardrequesttracker;

import io.dropwizard.ConfiguredBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.serviceenabled.dropwizardrequesttracker.RequestTrackerServletFilter;


public class RequestTrackerBundle<T> implements ConfiguredBundle<T> {

	private final String header;

	public RequestTrackerBundle(String header) {
		this.header = header;
	}

	public RequestTrackerBundle() {
		this.header = RequestTrackerConstants.DEFAULT_LOG_ID_HEADER;
	}

	@Override
	public void run(T configuration, Environment environment) throws Exception {
		environment.servlets()
			.addFilter("request-tracker-servlet-filter", new RequestTrackerServletFilter(header));
	}

	@Override
	public void initialize(Bootstrap<?> bootstrap) {
		
	}

}
