import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.Assert.*;

public class TestLogin {
	
	User mockedUser = null;
	Login mockedLogin = null;
	Login login = null;

	@Before
	public void setUp() throws Exception {
		login = new Login();
		mockedLogin = mock(Login.class);
		
		mockedUser = mock(User.class);
		when(mockedLogin.Login(mockedUser)).thenReturn(true);
	}

	@Test
	public void TestMockedLogin() {
		assertTrue(mockedLogin.Login(mockedUser));
		verify(mockedLogin).Login(mockedUser);
	}
	
	@Test
	public void TestLoginError() {
		
		User emptyUser = new User("", "");
		
		assertFalse(login.Login(emptyUser));
		assertTrue(login.HasError());
		assertEquals(login.GetLoginError(), login.GetError());
	}
	
	@Test
	public void TestFaultyLogin() {
		
		User faultyUser = new User("test", "test");
		
		assertFalse(login.Login(faultyUser));
		assertTrue(login.HasError());
		assertEquals(login.GetFaultyLogin(), login.GetError());
	}
}
