package co.edu.unbosque.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptador {
    public static String encriptarSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar", e);
        }
    }
}





