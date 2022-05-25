package Controller;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class Decryption {
	public static String getAccount(String string) {
		try {
			FileInputStream fis = new FileInputStream("E:\\privateKey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();
			
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = factory.generatePrivate(spec);
			
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, privateKey);
			byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(string));
			String str = new String(decryptOut);
			return str;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Khong the giai ma";
	}
}
