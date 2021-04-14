package book.ch5;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void main(String[] args) {
		String			smtpServer			= "smtp.naver.com";
		final String	sendId				= "보내는 사람 ID";
		final String	sendPass			= "보내는 사람 비밀번호";
		String			sendEmailAddress	= "wkdtkvndn92@naver.com";
		int				smtpPort			= 465;

		// 받는 분
		String			receiveEmailAddress	= "wkdtkvndn@gmail.com";
		String			subject				= "실험용 이메일 제목";
		String			content				= "실험용 이메일 내용";

		Properties		props				= System.getProperties();
		props.put("mail.smtp.host", smtpServer);
		props.put("mail.smtp.port", smtpPort);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.ssl.trust", smtpServer);

		Session session5 = Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendId, sendPass);
			}
		});

		// session2.setDebug(true);
		try {
			Message mimeMessage = new MimeMessage(session5);
			mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveEmailAddress));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(content);
			Transport.send(mimeMessage);
			System.out.print("message sent successfully...");
		}
		catch (AddressException e) {
			e.printStackTrace();
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
