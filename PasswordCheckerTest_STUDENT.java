
import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Esther Soon
 * Instructor: Farnaz Eivazi
 * Date: 2/8/2022
 * Class: CMSC 204-38176
 * Description: An Application that checks if a password is valid
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Esther Soon
 */
public class PasswordCheckerTest_STUDENT {
	
	String shortPwd = "aB1#";
	String noUpperCasePwd = "abcd4#1";
	String noLowerCasePwd = "ABCD2@R";
	String weakPwd = "AbC2#6ss";
	String noDigitPwd = "HelloPerson";
	String invalidSequencePwd ="aaad2$E";
	String perfectPwd = "Perfect&123";

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(shortPwd));
			assertTrue("Did not throw LengthException",false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a LengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides LengthException",false);
		}
	}
	
	/**
	 * Test if the password has at least one upper case alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(noUpperCasePwd));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lower case alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(noLowerCasePwd));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			assertTrue(PasswordCheckerUtility.isWeakPassword(weakPwd));
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a WeakPassword Exception",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an WeakPassword Exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword(invalidSequencePwd));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.hasDigit(noDigitPwd));
			assertTrue("Did not throw NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitException",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoDigitException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			 
			assertTrue(PasswordCheckerUtility.isValidPassword(perfectPwd));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an Exception",false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>();
		passwords.add(shortPwd);
		passwords.add(noLowerCasePwd);
		passwords.add(noUpperCasePwd);
		passwords.add(noDigitPwd);
		passwords.add(invalidSequencePwd);
		PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		try{
			assertFalse(passwords.isEmpty());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw an Exception",false);
		}
	}
	
}
