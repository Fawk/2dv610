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
		verify(mockedLogin).Login(username, password);
	}
	
	@Test
	public void TestLoginError() {
		assertFalse(mockedLogin.Login("", ""));
		verify(mockedLogin).Login("", "");
		assertTrue(mockedLogin.hasError);
		assertEquals(mockedLogin.GetError(), mockedLogin.loginError);
		verify(mockedLogin).GetError();
	}
	
	@Test
	public void TestFaultyLogin() {
		assertFalse(mockedLogin.Login("test", "test"));
		verify(mockedLogin).Login("test", "test");
		assertTrue(mockedLogin.hasError);
		assertEquals(mockedLogin.GetError(), mockedLogin.faultyLogin);
		verify(mockedLogin).GetError();
	}

}
