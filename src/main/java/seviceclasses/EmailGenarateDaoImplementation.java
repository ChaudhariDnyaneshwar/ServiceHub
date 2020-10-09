package seviceclasses;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import daointerfaceses.EmailGenarateDao;
import pojoclasses.EmailGenerate;

public class EmailGenarateDaoImplementation implements EmailGenarateDao {

	public void sendEmail(EmailGenerate e) {
        final String userName="workportalteam@gmail.com";
        final String password="Workportal@123";
        
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session=Session.getInstance(prop,new Authenticator() {
       	 protected javax.mail.PasswordAuthentication getPasswordAuthentication()
       	 {
       		 return new javax.mail.PasswordAuthentication(userName, password);
       	 }
       	 
		});
        try {
       	 Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(e.getReciption()));
		//	message.setRecipients(Message.RecipientType.TO, arg1);
			message.setSubject(e.getSubject());
			message.setText(e.getMessage());

			 Transport.send(message);
			 System.out.println("it done....");
		} catch (AddressException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		} catch (MessagingException a) {
			// TODO Auto-generated catch block
			a.printStackTrace();
		}
   }

	
	}


