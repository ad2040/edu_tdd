package mock;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserLoginTest {
	
	@Test
	public void testSavePassword(){
		UserRegister register = new UserRegister();
		ICipher cipher = new MockMD5Cipher() ;
			
		String userId = "nam";
		String password = "password";
		
		register.savePassword(userId, cipher.encrypt(password));
		String decryptedPassword = cipher.decrypt(register.getPassword(userId));
		
		assertThat(decryptedPassword, is(password));
	}

}
