package org.nitish;

import javax.mail.Address;

public class MailMetaData {
    private static final String HostServer = "smtp.gmail.com";

    public static String getHostServer() {
        return HostServer;
    }

    private static final String port = "465";

    public static String getPort() {
        return port;
    }

    private static final String sslProperty = "mail.smtp.ssl.enable";

    public static String getSslProperty() {
        return sslProperty;
    }

    private static final String authPerm = "mail.smtp.auth";

    public static String getAuthPerm() {
        return authPerm;
    }

    public static  String myUserMail;

    public static  String password;
    public static Address receiver;


}
