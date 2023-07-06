package com.example.demo.com;

public class ExceptionHandler {
	
	/**
	 * 例外処理
	 * @return code:500,メッセージ:SERVER_ERROR
	 */
	public static ApiResponse<?> handleException(Exception ex) {
        return ApiResponse.code(ResponseCode.SERVER_ERROR);
    }

}
