package FileXOR;

import java.security.SecureRandom;
import java.util.Arrays;

class SymmetricKey{
	public byte[] hashValue;
	private final SecureRandom rand = new SecureRandom();

	public SymmetricKey() {
		hashValue = new byte[16];
		rand.setSeed(rand.nextLong());
		rand.nextBytes(hashValue);
	}
	public SymmetricKey(byte[] bytes) {
		hashValue = bytes;
	}
	public String toString() {
		return Arrays.toString(hashValue);
	}
}
