package com.example.demo.com;

import java.time.LocalDateTime;

import lombok.Data;

@Data

public class ApiResponse<T> {
	
    private int statusCode;
    private String message;
    private LocalDateTime ldt;
    private T data;
    private T errordata;

   

  
    /**
     * データをセットして返す
     * @param <T>
     * @param responseCode:ResponseCode
     * @param data:データ
     * @return
     */
    public static <T> ApiResponse<T> data(ResponseCode responseCode,T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(responseCode.getCode());
        response.setMessage(responseCode.getMessage());
        response.setLdt(LocalDateTime.now());
        response.setData(data);
        
        return response;
    }
    
    
    /**
     * ResponseCodeのみ返す
     * @param <T>
     * @param responseCode
     * @return
     */
    public static <T> ApiResponse<T> code(ResponseCode responseCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(responseCode.getCode());
        response.setMessage(responseCode.getMessage());
        response.setLdt(LocalDateTime.now());
        
        return response;
    }
    
    
    /**
     * メッセージカスタマイズ
     * @param <T>
     * @param responseCode:ResponseCode
     * @param message:メッセージを設定
     * @return
     */
    public static <T> ApiResponse<T> message(ResponseCode responseCode,String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(responseCode.getCode());
        response.setMessage(message);
        response.setLdt(LocalDateTime.now());
        
        return response;
    }
    

    public static <T> ApiResponse<T> errordata(ResponseCode responseCode,T eerrordata,T data ) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatusCode(responseCode.getCode());
        response.setMessage(responseCode.getMessage());
        response.setLdt(LocalDateTime.now());
        response.setErrordata(eerrordata);
        response.setData(data);
        
        return response;
    }
    
    

}