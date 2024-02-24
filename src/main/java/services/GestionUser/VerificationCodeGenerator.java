package services.GestionUser;

import java.security.SecureRandom;

public class VerificationCodeGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static String generateVerificationCode(int phone) throws Exception {
        int length = 6 ;
        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        SMSAPI sms = new SMSAPI();
        sms.SendCode(String.valueOf(phone), code.toString());

        return code.toString();
    }


}
