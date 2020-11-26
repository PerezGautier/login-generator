package geco;

import junit.framework.TestCase;

public class LoginGeneratorTest extends TestCase {

    private LoginService loginService;
    private LoginGenerator loginGenerator;


    @Override
    public void setUp() {
        loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }

    public void testGenerateLoginForNomAndPrenom() {
        //When
        String login = loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        //Then
        assertEquals("PDUR", login);
        assertTrue(loginService.loginExists("PDUR"));
    }

    public void testGenerateLoginForNomAndPrenomAlreadyExisting(){
        //When
        String login = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        String login2 = loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        //Then
        assertEquals("JRAL2", login);
        assertTrue(loginService.loginExists("JRAL2"));
        assertEquals("JRAL3", login2);
        assertTrue(loginService.loginExists("JRAL3"));
    }

    public void testGenerateLoginSameLogin(){
        //When
        String login = loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        //Then
        assertEquals("JROL1", login);
        assertTrue(loginService.loginExists("JROL1"));
    }

    public void testGenerateLoginWithAccent(){
        //When
        String login = loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        //Then
        assertEquals("PDUR", login);
        assertTrue(loginService.loginExists("PDUR"));
    }
}