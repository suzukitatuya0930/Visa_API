package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.DuplicateFormatFlagsException;
import java.util.Properties;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.EmailConfig;
import com.example.demo.model.RegisterModel;
import com.example.demo.model.response.ResponseModel;
import com.example.demo.service.RegisterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class RegisterController {

	
	@Resource RegisterService registerService;
	//一般ユーザー新規登録機能
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterModel registerModel,ResponseModel responseModel) {
		
		try 
		{
			  String password = generateRandomPassword(8);
	        
	        // パスワードをregisterModelにセット
			  registerModel.setPassword(password);
			  sendMail(registerModel);
        	
	        registerService.register(registerModel);
	        responseModel.setCode(200);
	        responseModel.setStatus("OK");
	        responseModel.setInformation("登録できました");
	        responseModel.setRegisterData(registerModel);
	        
	       
	        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
		} catch (DuplicateFormatFlagsException ex) {
			// メールアドレスが重複している場合の処理
			
			responseModel.setCode(400);
			responseModel.setStatus("ERROR");
			responseModel.setInformation("既に登録されたメールアドレスです");
			responseModel.setRegisterData(registerModel);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseModel);
		} catch (Exception ex) {
			// その他の例外が発生した場合の処理
			log.error("ユーザー登録エラー: ", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	private String generateRandomPassword(int length) {
	    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder(length);
	    
	    for (int i = 0; i < length; i++) {
	        int randomIndex = random.nextInt(characters.length());
	        char randomChar = characters.charAt(randomIndex);
	        sb.append(randomChar);
	    }
	    
	    return sb.toString();
	}
	
	 //send email
	 private final EmailConfig emailConfig;
	 @Autowired//inject 
	 public RegisterController(EmailConfig emailConfig) {
	        this.emailConfig = emailConfig;
	    }
	 public  void sendMail(RegisterModel registerModel) throws MessagingException, UnsupportedEncodingException {
	        final String fromEmail = emailConfig.getUsername();
	        // Mat khai email cua ban
	        final String password = emailConfig.getPassword();
	        // dia chi email nguoi nhan
	        final String toEmail = registerModel.getEmail();
	        final String subject = "Your Password";
	        final String body = "Your Password : " + registerModel.getPassword();
	        
	    
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
	        props.put("mail.smtp.port", "587"); //TLS Port
	        props.put("mail.smtp.auth", "true"); //enable authentication
	        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
	        Authenticator auth = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };
	        Session session = Session.getInstance(props, auth);
	        MimeMessage msg = new MimeMessage(session);
	        //set message headers
	        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	        msg.addHeader("format", "flowed");
	        msg.addHeader("Content-Transfer-Encoding", "8bit");
	        msg.setFrom(new InternetAddress(fromEmail, "KKSOFT株式会社"));
	        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
	        msg.setSubject(subject, "UTF-8");
	        msg.setText(body, "UTF-8");
	        msg.setSentDate(new Date());
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	        Transport.send(msg);
	        System.out.println("メール転送できました");
	    }
}