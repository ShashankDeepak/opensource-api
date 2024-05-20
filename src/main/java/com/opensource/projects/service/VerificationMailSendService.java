package com.opensource.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

public class VerificationMailSendService {

    @Autowired
    JavaMailSender javaMailSender;

    @Async
    public void sendEmail(String id){

    }

    private String createEmailBody(String url){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Email Verification</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"100%\" bgcolor=\"#f2f2f2\">\n" +
                "        <tr>\n" +
                "            <td align=\"center\">\n" +
                "                <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" width=\"600\" style=\"background-color: #ffffff; padding: 20px;\">\n" +
                "                    <tr>\n" +
                "                        <td align=\"center\">\n" +
                "                            <h1>Email Verification</h1>\n" +
                "                            <p>Click the button below to verify your email address:</p>\n" +
                "                            <a href=\""+ url +"\" style=\"text-decoration: none;\">\n" +
                "                                <button style=\"background-color: #007bff; color: #ffffff; border: none; padding: 10px 20px; cursor: pointer;\">Verify Email</button>\n" +
                "                            </a>\n" +
                "                            </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>";

    }
}
