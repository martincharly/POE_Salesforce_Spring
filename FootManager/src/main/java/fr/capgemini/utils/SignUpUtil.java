package fr.capgemini.utils;

public abstract class SignUpUtil {
	
	public static String convertToMD5(String stringToConvert) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(stringToConvert.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			// TODO : faire quelque chose ici (log, console...)
		}
		return null;
	}

}
