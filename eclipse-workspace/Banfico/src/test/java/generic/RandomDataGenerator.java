package generic;

import java.util.Random;

public class RandomDataGenerator {
	
	public static String randomdigit(int numberofchars) {
		final String alphabet = "1234567890";
		StringBuffer sb = null;
		final int N = alphabet.length();
		Random r = new Random();
		sb = new StringBuffer();
		for (int i = 0; i < numberofchars; i++) {
			sb = sb.append(alphabet.charAt(r.nextInt(N)));
		}

		return sb.toString();
	}

}
