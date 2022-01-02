package com.demo.managers;

import com.demo.dataProviders.ConfigFileReader;
import com.demo.dataProviders.EmailFileReader;
import com.demo.dataProviders.JsonDataReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static EmailFileReader emailFileReader;
	private static JsonDataReader jsonDataReader;
	
	private FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstance() {
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		if(configFileReader==null) {
			return configFileReader = new ConfigFileReader();
		}else {
			return configFileReader;
		}
	}
	
	public EmailFileReader getEmailFileReader() {
		if(emailFileReader==null) {
			return emailFileReader = new EmailFileReader();
		}else {
			return emailFileReader;
		}
	}
	
	public JsonDataReader getJsonDataReader() {
		if(jsonDataReader==null) {
			return jsonDataReader = new JsonDataReader();
		}else {
			return jsonDataReader;
		}
	}
}
