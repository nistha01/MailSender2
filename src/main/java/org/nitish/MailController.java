package org.nitish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@RestController
public class MailController {
@Autowired
MailHandler mailHandler;

    @GetMapping("sendMail/sender/{sender}/password/{password}/receiver/{receiver}")
    public String sendMail(@PathVariable String sender, @PathVariable String password, @PathVariable String receiver) throws AddressException, AddressException {
        MailMetaData.myUserMail = sender;
        MailMetaData.password = password;
        MailMetaData.receiver = new InternetAddress(receiver);

        mailHandler.sendMail();

        return  "mail is Sent";
    }


}
