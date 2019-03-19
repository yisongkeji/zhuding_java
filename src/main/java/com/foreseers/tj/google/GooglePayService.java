package com.foreseers.tj.google;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface GooglePayService {

	Boolean check(String signtureData) throws Exception ;

}
