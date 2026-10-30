/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.security.MessageDigest;

/**
 *
 * @author zefrialrizkullah
 */

public final class PasswordUtil {
    private static final int ITER = 210000;
    private PasswordUtil() {
    }
    public static String hashPassword(String raw) {
        if (raw == null || raw.length()<8)throw new exception.ValidationException("Password minimal 8 karakter.");
        byte[] salt = new byte[16];
        new SecureRandom().nextBytes(salt);
        return "pbkdf2_sha256$"+ITER+"$"+Base64.getEncoder().encodeToString(salt)+"$"+Base64.getEncoder().encodeToString(derive(raw, salt, ITER));
    }
    public static boolean verifyPassword(String raw, String encoded) {
        if (raw == null || encoded == null)return false;
        try {
            String[] a = encoded.split("\\$");
            if (a.length != 4 || !"pbkdf2_sha256".equals(a[0]))return false;
            int iter = Integer.parseInt(a[1]);
            if (iter<10000 || iter>2000000)return false;
            return MessageDigest.isEqual(derive(raw, Base64.getDecoder().decode(a[2]), iter),
                    Base64.getDecoder().decode(a[3]));
        }
        catch (Exception e) {
            return false;
        }
    }
    private static byte[] derive(String raw, byte[] salt, int iter) {
        PBEKeySpec spec = new PBEKeySpec(raw.toCharArray(), salt, iter, 256);
        try {
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        }
        catch (Exception e) {
            throw new IllegalStateException("Gagal membuat hash password", e);
        }
        finally {
            spec.clearPassword();
        }
    }
}
