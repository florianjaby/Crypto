package mac;


import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Sha1 {
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	private static File doc;
	private static String print;
	private static String test="zfbgykfzhqkhfm;LDKLH";
	
	
	private static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();
		
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}

	public static String encode (String data, String key)
		throws SignatureException, NoSuchAlgorithmException, InvalidKeyException
	{
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);//doc.toString()
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		return toHexString(mac.doFinal(data.getBytes()));
	}

	
	
	public static void main(String[] args) throws Exception {
		String hmac = encode(test, "key");//do.toString()
		print=hmac;
		System.out.println(hmac);
		//assert hmac.equals("104152c5bfdca07bc633eebd46199f0255c9f49d");
		assert hmac.equals("ebc56464e164b859630971b2bea027f5e3d99d52");
	}

}
