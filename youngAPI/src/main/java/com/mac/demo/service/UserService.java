package com.mac.demo.service;

import java.util.List;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mac.demo.mappers.UserMapper;
import com.mac.demo.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	//유저 맵퍼
	@Autowired
	private UserMapper dao;

	@Autowired
	private JavaMailSender sender;
	
	
	public boolean add(User user) {
		return dao.add(user) > 0;
	}

	public List<User> getList() {
		
		return dao.getList();
	}

	public User getOne(String idMac) {
		User user = dao.getOne(idMac);
		return user;
	}

	public boolean deleted(String idMac) {
		boolean result = dao.deleted(idMac);
		return result;
	}

	public boolean updated(User user) {
		boolean result = dao.updated(user);
		return result;
	}

	public boolean idcheck(String idMac) {
		User user = dao.getOne(idMac);
		return user == null;
	}

	public String checkmail(String emailMac) {
		UUID randomUUID = UUID.randomUUID();
		
		String random = randomUUID.toString().replaceAll("-", "");
		
		MimeMessage mimeMessage = sender.createMimeMessage();

	      try {
	         InternetAddress[] addressTo = new InternetAddress[1];
	         addressTo[0] = new InternetAddress(emailMac);

	         mimeMessage.setRecipients(Message.RecipientType.TO, addressTo);

	         mimeMessage.setSubject("이메일 인증");
	         mimeMessage.setContent(random,"text/html;charset=utf-8");
	         
	         sender.send(mimeMessage);
	         return random;
	      } catch (MessagingException e) {
	         log.error("에러={}", e);
	      }
		return null;
	}

	public boolean nickCheck(String nick) {
		User user = dao.getOneNick(nick);
		return user == null;
	}
	
	
	
}
