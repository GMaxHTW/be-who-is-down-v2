package com.htw.whoisdown.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import javax.mail.internet.MimeMessage;

@Component
public class EmailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(final String subject, final String message, final String fromEmailAddress,
                          final String toEmailAddresses, final boolean isHtmlMail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromEmailAddress);
            helper.setTo(toEmailAddresses);
            helper.setSubject(subject);
            if (isHtmlMail) {
                helper.setText("<html><body>" + message + "</body></html>", true);
            } else {
                helper.setText(message);
            }
            mailSender.send(mimeMessage);
            System.out.println("Email sending complete.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String buildEmail(String name) {
        return "Hallo " + name + ", \n" +
                "willkommen in unserer WhoIsDown Community.\n" +
                "Wir wünschen dir sehr viel Spaß beim Organisieren und Teilnahme von Events! \n" +
                "Beste Grüße,\n" +
                "WhoIsDown\n" +
                "\n" +
                "(das ist eine Automatisch generierte Mail)\n" +
                "\n" +
                "Bei Fragen gerne auf WhoIsDown unter Q&A, da findest du sicherlich eine Antwort auf deine Frage ;) ";
    }
}