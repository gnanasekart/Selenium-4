package CompactabilityTesting;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

public class EmailRead {

	public static void main(String[] args) throws MessagingException, IOException 
	{
/*
		//collect the mail host, port details for imap
		Properties prop = new Properties();
		prop.put("mail.imap.host", "imap.gmail.com");
		prop.put("mail.imap.port", "993");
		prop.put("mail.imap.starttls.enable", "true");

		//creating session from javax mail to insert the properties
		Session emailsession = Session.getDefaultInstance(prop);	

		Store store = emailsession.getStore("imap");
		store.connect("imap.gmail.com", "email@gmail.com", "password");

		*/
		
	//collect the mail host, port details for pop3
		Properties prop = new Properties();
		prop.put("mail.pop3.host", "pop.gmail.com");
		prop.put("mail.pop3.port", "995");
		prop.put("mail.pop3.starttls.enable", "true");

		//creating session from javax mail to insert the properties
		Session emailsession = Session.getDefaultInstance(prop);	

		Store store = emailsession.getStore("pop3s");
		store.connect("pop.gmail.com", "email@gmail.com", "password");

		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		int msgcount = inbox.getMessageCount();
		System.out.println("msg count is "+msgcount);

		Message[] messages = inbox.getMessages();
		for(int i = 0; i< 2; i++)
		{
			System.out.println(messages[i].getSubject());
			System.out.println(messages[i].getFrom()[0]);
			System.out.println(messages[i].getContent().toString());
			System.out.println(messages[i].getContentType());
			System.out.println("-----------------------");

			//no we get the content with html tags ... so we need to remove the tags

			MimeMultipart body = (MimeMultipart)messages[i].getContent();
			BodyPart bodyPart = body.getBodyPart(0);
			String bodycontent = bodyPart.getContent().toString();
			System.out.println(bodycontent);
		}
	}
}
