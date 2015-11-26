import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.junit.Assert.*;

public class TestLogin {
	
	User mockedUser = null;
	Login login = null;

	@Before
	public void setUp() throws Exception {
		login = new Login();
		mockedUser = mock(User.class);
		when(login.Login(mockedUser)).thenReturn(true);
	}

	@Test
	public void TestMockedLogin() {
		assertTrue(login.Login(mockedUser));
		verify(login).Login(mockedUser);
	}
	
	@Test
	public void TestLoginError() {
		
		User faultyUser = new User("test", "test");
		
		assertFalse(login.Login(faultyUser));
		verify(login).Login(faultyUser);
		assertTrue(login.HasError());
		verify(login).HasError();
		assertEquals(login.GetError(), login.GetLoginError());
		verify(login).GetError();
		verify(login).GetLoginError();
	}
	
	@Test
	public void TestFaultyLogin() {
		
		User faultyUser = new User("", "");
		
		assertFalse(login.Login(faultyUser));
		verify(login).Login(faultyUser);
		assertTrue(login.HasError());
		verify(login).HasError();
		assertEquals(login.GetError(), login.GetFaultyLogin());
		verify(login).GetError();
		verify(login).GetFaultyLogin();
	}
	
	
}
