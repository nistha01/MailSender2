package org.nitish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;
@Component

public class MailHandler {
    @Autowired
    MailBody mailBody;
     public void sendMail()
    {
        Properties sysProperties = System.getProperties(); //this gives me a hash-map/ hash-table

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host", MailMetaData.getHostServer());
        sysProperties.put("mail.smtp.port", MailMetaData.getPort());
        sysProperties.put(MailMetaData.getSslProperty(),"true");
        sysProperties.put(MailMetaData.getAuthPerm(),"true");
        Authenticator mailAuthenticator = new CustomisedMailAuthentication();
        Session mailSession = Session.getInstance(sysProperties,mailAuthenticator);
        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject(mailBody.sub);
            mailMessage.setText(mailBody.body);

            mailMessage.setRecipient(Message.RecipientType.TO,MailMetaData.receiver);
            Transport.send(mailMessage);
        }
        catch(Exception mailException)
        {
            System.out.println(mailException.toString());
        }



    }
}
