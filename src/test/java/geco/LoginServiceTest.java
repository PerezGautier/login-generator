package geco;

import junit.framework.TestCase;

import java.util.List;

public class LoginServiceTest extends TestCase {

    private LoginService loginService;
    private String login;
    private String login2;

    @Override
    public void setUp() {
        String[] loginsExistants={"123456789","password"};
        loginService = new LoginService(loginsExistants);
        login = "123456789";
        login2 = "helloworld";

    }

    public void testLoginExists() {
        assertTrue(loginService.loginExists(login));
        assertFalse(loginService.loginExists(login2));
    }

    public void testAddLogin() {
        assertFalse(loginService.loginExists("aaaaaaaaa"));
        loginService.addLogin("aaaaaaaaa");
        assertTrue(loginService.loginExists("aaaaaaaaa"));
    }

    public void testFindAllLoginsStartingWith() {
        List<String> allLogin = loginService.findAllLoginsStartingWith("1");
        assertEquals(1, allLogin.size());
        assertEquals("123456789", allLogin.get(0));
    }

    public void testFindAllLogins() {
        List<String> allLogin = loginService.findAllLogins();
        assertEquals(2, allLogin.size());
    }

}