package com.uap.it1311l.passwordencryptorapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uap.it1311l.passwordencryptorapi.models.EncryptionResponse;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionApiClient;
import com.uap.it1311l.passwordencryptorapi.webclient.EncryptionMybatisMapper;

@Service
public class EncryptDecryptService {
	@Autowired
	EncryptionApiClient apiClient;
	
	@Autowired
	EncryptionMybatisMapper mybatisMapper;
	
	public EncryptionResponse encrypt(String password) {
		EncryptionResponse chae = apiClient.encrypt("sonchaeyoungpogi", password, "AES");
		mybatisMapper.insert(chae.getResult());
		return chae;
	}
	
	public String decrypt(String hash) {
		if (mybatisMapper.exists(hash) > 0) {
			EncryptionResponse chae = apiClient.decrypt("sonchaeyoungpogi", hash, "AES");
			return chae.getResult();
		} else {
			return "Encrypted Password does not exist.";
		}
	}
}