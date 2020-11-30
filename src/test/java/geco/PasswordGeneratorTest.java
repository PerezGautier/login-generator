package geco;

import junit.framework.TestCase;

public class PasswordGeneratorTest extends TestCase {

    PasswordGenerator passwordGenerator = new PasswordGenerator();

    public void testGetRandomPassword() {
        String mdp = passwordGenerator.getRandomPassword(4+1);
        assertEquals(5, mdp.length());
    }
}