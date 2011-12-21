package mock;

public class MockMD5Cipher implements ICipher {

	@Override
	public String decrypt(String source) {
		
		return "password";
	}

	@Override
	public String encrypt(String source) {
		// TODO Auto-generated method stub
		return "c6be1a7161beab655ed0c5ffdd133045";
	}

}
