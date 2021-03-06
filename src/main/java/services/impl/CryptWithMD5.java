package services.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptWithMD5 {
    private static MessageDigest md;

    public static String cryptWithMD5(String pass){
        if (pass.equals("")) {return "";}
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
//        } catch (NoSuchAlgorithmException ex) {
//            Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex); to do
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";


    }
}
