package com.example.demo.service;


public interface CheckEmailExistssService {
	
	/**
	 * メールアドレス重複チェック
	 * @param email
	 * @return
	 */
	public boolean checkEmailExists(String email);

}
