package com.itplus.Util;

import com.itplus.model.TourDTO;
import com.itplus.model.UserDTO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailUtil {
    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private static final String senderEmail = "laiducminh1029@gmail.com";//change with your sender email
    private static final String senderPassword = "mzacpnbxdxztsqnt";//change with your sender password

    public static void sendAsHtml(String to, String title, String html) throws MessagingException {
        System.out.println("Sending email to " + to);

        Session session = createSession();

        //create message using session
        MimeMessage message = new MimeMessage(session);
        prepareEmailMessage(message, to, title, html);

        //sending message
        Transport.send(message);
        System.out.println("Done");
    }

    private static void prepareEmailMessage(MimeMessage message, String to, String title, String html)
            throws MessagingException {
        message.setContent(html, "text/html; charset=utf-8");
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(title);
    }

    private static Session createSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");//Outgoing server requires authentication
        props.put("mail.smtp.starttls.enable", "true");//TLS must be activated
        props.put("mail.smtp.host", "smtp.gmail.com"); //Outgoing server (SMTP) - change it to your SMTP server
        props.put("mail.smtp.port", "587");//Outgoing port

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        return session;
    }

    public static void sendEmailForgotPassword(String email,String password) throws MessagingException {
        String content="<p>Your new password is <b>%s</b></p>";
        sendAsHtml(email, "Forgot password", String.format(content, password));
    }

    public static void sendEmailBookTour(UserDTO user, TourDTO tour) throws MessagingException {
        String userInfo="<p>Username: <b>%s</b></p>";
        String tourInfo="<p>Tour: <b>%s</b></p>";
        String content = String.format(userInfo, user.getUsername()) + String.format(tourInfo, tour.getName());
        sendAsHtml(user.getEmail(), "Forgot password", content);
    }
}
