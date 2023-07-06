package com.example.demo.com;

public enum ResponseCode {
	
		/**コード:200,メッセージ:Success* 
		 * 処理が成功したとき */
		SUCCESS(200, "Success"),
	
		/**コード:400,メッセージ:Client Error 
		 * 処理が失敗したとき * */
	    CLIENT_ERROR(400, "Client Error"),
	   
	    /**コード:404,メッセージ:Not Found 
		 *  * */
	    NOT_FOUND(404,"Not Found"),
	    
	    /**
	     * コード:409 ,メッセージ:Conflict Error
	     データが対立したとき(emailが重複したとき)
	     */
	    CONFLICT_ERROR(409 ,"Conflict Error"),
	    
	    /**コード:500,メッセージ:Server Error 
	     * 例外なサーバーエラーが発生したとき*/
	    SERVER_ERROR(500, "Server Error");

	    private final int code;
	    private final String message;

	    ResponseCode(int code, String message) {
	        this.code = code;
	        this.message = message;
	    }

	    public int getCode() {
	        return code;
	    }

	    public String getMessage() {
	        return message;
	    }
	}


