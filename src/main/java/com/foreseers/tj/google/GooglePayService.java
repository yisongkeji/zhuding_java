package com.foreseers.tj.google;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface GooglePayService {

	Map check(String signtureData,String type) throws Exception ;

}
