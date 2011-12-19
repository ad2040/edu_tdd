package mock;

public class MockMD5Cipher implements ICipher {

	@Override
	public String encrypt(String source) {
		
		return "nampassword";
	}

	@Override
	public String decrypt(String source) {
		// TODO Auto-generated method stub
		return "09asdf99999a0asf";
	}

}
