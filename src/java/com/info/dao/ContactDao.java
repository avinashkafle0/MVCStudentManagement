/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.info.dao;

import com.info.model.Contact;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Avinash Kafle
 */
public class ContactDao {
    
    public void sendMail(Contact contact){
        try{
            final String userName = "optional.email0@gmail.com";
            final String userPassword = "#";
            
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication(userName, userPassword);
                    }
            });
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("avinashkafle0@gmail.com"));
            message.setSubject(contact.getUserName());
            message.setText("From: " + contact.getUserEmail() + "\n" + contact.getUserMessage());
            
            Transport.send(message);
            System.out.println("Message Send Successfully");
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
