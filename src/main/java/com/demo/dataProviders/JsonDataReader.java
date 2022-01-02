package com.demo.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.demo.dataType.LoginCredentialsData;
import com.demo.managers.FileReaderManager;
import com.google.gson.Gson;


public class JsonDataReader {
	
	//Login Credentials Data
	private final String loginCredentialsFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataResourcePath() + "LoginCredentials.json";
	private List<LoginCredentialsData> loginCredentialsDataList;
	
	public JsonDataReader() {
		loginCredentialsDataList = getLoginCredentialsData();
	}
	
	
	/**
	 *
	 * Login credentials data method
	 *
	 */
	//getting all user preference data
	private List<LoginCredentialsData> getLoginCredentialsData() {

		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			//reading data from json file
			bufferReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + loginCredentialsFilePath));

			//store into form of array
			LoginCredentialsData[] loginCredentialsData = gson.fromJson(bufferReader, LoginCredentialsData[].class);

			return Arrays.asList(loginCredentialsData);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + loginCredentialsFilePath);
		} finally {
			try {
				if (bufferReader != null) bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}
	
	//return FSSignUpDate by its first name
	public LoginCredentialsData getCredentialsByUserType(String loginCredentialsUserType) {
		//accessing all data from user preference list
		for (LoginCredentialsData loginCredentialsData : loginCredentialsDataList) {
			//checking data
			if (loginCredentialsData.userType.equalsIgnoreCase(loginCredentialsUserType)) {
				return loginCredentialsData;
			}
		}
		return null;
	}

}
