package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyUser;
import com.example.demo.service.MyUserDetailsService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200","*"}, allowedHeaders = "*")

public class UserController {

	@Autowired
	private MyUserDetailsService ms;
	
	@GetMapping("/")
	public String home()
	{
		return "Hello Movie Project";
	}
	
	@GetMapping("/user")
	public List<MyUser> getAllUsers()
	{
		return ms.read();
	}
	
	@GetMapping("/user/count")
	public MyUser getUserCount() {
		return ms.getUsersCount();
	}
	
	@GetMapping("/user/otp/{email}")
	public String getOtp(@PathVariable String email)
	{
		long otp=(long) (Math.random()*(1000000));
		sendEmail(email, otp+"");
		return otp+"";
	}
	
	
	
	@PostMapping("/user")
	public int signup(@RequestBody MyUser user)
	{
		System.out.println("What i have received: "+user);
		return ms.create(user);
	}
	
	@PutMapping("/user")
	public int modifyUser(@RequestBody MyUser user)
	{
		System.out.println("entering modify method "+ user);

		return ms.modifyUser(user);
	}
	
	@GetMapping("/user/{id}")
	public MyUser getUserById(@PathVariable Long id)
	{
		System.out.println("entering getUserbyId method "+ id);
		return ms.getUserById(id);
	}
	
	@DeleteMapping("/user/{username}")
	public int deleteUser(@PathVariable("username") String username)
	{
		System.out.println("entering delete method "+ username);
		return ms.deleteUser(username);
	}
	
	
	@GetMapping("/user/{username}/{password}/{role}")
	public MyUser login(@PathVariable String username, @PathVariable String password,@PathVariable String role )
	{
		MyUser user = ms.read(username);
		if(user.getPassword().equals(password))
			return user;
		return null;
	}

	private void sendEmail(String to, String otp)
	{
		 Properties props = new Properties();
	        props.put("mail.smtp.host", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        //Establishing a session with required user details
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("alluXXXXX@gmail.com", "kra@XXXX");
	                
	            }
	        });
	        try {
	            //Creating a Message object to set the email content
	            MimeMessage msg = new MimeMessage(session);
	            //Storing the comma seperated values to email addresses
                //String to = "alluhit45@gmail.com.com";
	            /*Parsing the String with defualt delimiter as a comma by marking the boolean as true and storing the email
	            addresses in an array of InternetAddress objects*/
	            InternetAddress[] address = InternetAddress.parse(to, true);
	            //Setting the recepients from the address variable
	            msg.setRecipients(Message.RecipientType.TO, address);
	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
	            msg.setSubject("Sample Mail : " + timeStamp);
	            msg.setSentDate(new Date());
	            msg.setText(otp+" is the One time password to signup in our website. Do not share this with any one.");
	            msg.setHeader("XPriority", "1");
	           
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
	        } catch (MessagingException mex) {
	            System.out.println("Unable to send an email:\n" + mex);
	        }
	}

}

