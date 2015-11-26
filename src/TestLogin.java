import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.Assert.*;

public class TestLogin {
	
	private String username = "admin";
	private String password = "root";
	
	Login mockedLogin = null;

	@Before
	public void setUp() throws Exception {
		mockedLogin = mock(Login.class);
		when(mockedLogin.Login(username, password)).thenReturn(true);
	}

	@Test
	public void TestLoginCredentials() {
		assertTrue(mockedLogin.Login(username, password));
	}

}
