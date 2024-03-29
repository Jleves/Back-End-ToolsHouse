package com.toolsToHome.PI.email.utils;

/**
 * @author Junior RT
 * @version 1.0
 * @license Get Arrays, LLC (https://getarrays.io)
 * @since 6/25/2023
 */
public class EmailUtils {

    public static String getEmailMessage(String name, String host, String token) {
        return "Holla " + name + ",\n\nSu nueva cuenta ha sido creada. Por favor haga clic en el enlace a continuación para verificar su cuenta. \n\n" +
                getVerificationUrl(host, token) + "\n\nThe support Team";
    }

    public static String getVerificationUrl(String host, String token) {
        return host + "/users?token=" + token;
    }
}
