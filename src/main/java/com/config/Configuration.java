package com.config;

import com.utilities.FileUtility;

public class Configuration {
	public String getAppUrl(String env) {
		FileUtility file = new FileUtility();
		return file.getProperty("/src/main/resources/config.properties", "app." + env + ".url");
	}

	public String getBrowserName() {
		FileUtility file = new FileUtility();
		return file.getConfiguration("browser_name");
	}
}
