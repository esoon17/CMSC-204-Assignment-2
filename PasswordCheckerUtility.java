/*
 * Name: Esther Soon
 * Class: CMSC 204-38176
 * Instructor: Farnaz Eivazi
 * Date: 2/8/2022
 * Description: An Application that checks if a password is valid
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Esther Soon
*/

import java.util.ArrayList;

public class PasswordCheckerUtility {

	public PasswordCheckerUtility() {}
	
	/**
	 * @param password, passwordConfirm
	 * @throws UnmatchedException if password and passwordConfirm aren't the same
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException{
		if(password.equals(passwordConfirm)!=true) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * @param password, passwordConfirm
	 * @return false if password and passwordConfirm aren't equal
	 * @return true if password and passwordConfirm are equal
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)!=true) {
			return false;
		}else {
			return true;
		}
	}
	
	/**
	 * @param password
	 * @throws LengthException if password doesn't have at least 6 characters
	 * @return true if password has at least 6 characters
	 */
	public static boolean isValidLength(String password) throws LengthException{
		if(password.length()<6) {
			throw new LengthException();
		}else {
			return true;
		}
	}
	
	/**
	 * @param password
	 * @throws NoUpperAlphaException if password doesn't have an upper case character
	 * @return true if password has an upper case character
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		for (int index=0; index<password.length(); index++) {
			char character = password.charAt(index);
			if(Character.isUpperCase(character)) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * @param password
	 * @throws NoLowerAlphaException if password doesn't have an lower case character
	 * @return true if password has an lower case character
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for (int index=0; index<password.length(); index++) {
			char character = password.charAt(index);
			if(Character.isLowerCase(character)) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * @param password
	 * @throws NoDigitException if password doesn't have a digit
	 * @return true if password has a digit
	 */
	public static boolean hasDigit(String password) throws NoDigitException{
		for (int index=0; index<password.length(); index++) {
			char character = password.charAt(index);
			if(Character.isDigit(character)) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
	 * @param password
	 * @throws NoSpecialCharacterException if password doesn't have a special character
	 * @return true if password has a special character
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
		for (int index=0; index<password.length(); index++) {
			int asciiValue = (int) password.charAt(index);
			if ((asciiValue >= 32 && asciiValue <= 47) || (asciiValue >= 58 && asciiValue <= 64) || (asciiValue >= 91 && asciiValue <= 96) || (asciiValue >= 123 && asciiValue <= 126)) {
				return true;
			}
		}
		throw new NoSpecialCharacterException();
	}
	
	/**
	 * @param password
	 * @throws InvalidSequenceException if password has more than 2 character repeating
	 * @return true if password doesn't have more than 2 character repeating
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		for (int index=0; index<password.length()-2; index++) {
			if(index!=password.length()-2) {
				char character1 = password.charAt(index);
				char character2 = password.charAt(index+1);
				char character3 = password.charAt(index+2);
				if(character1 == character2 && character2 == character3) {
					throw new InvalidSequenceException();
				}
			}
		}
		return true;
	}
	
	/**
	 * @param password
	 * @throws LengthException if password doesn't have at least 6 characters
	 * @throws NoUpperAlphaException if password doesn't have an upper case character
	 * @throws NoLowerAlphaException if password doesn't have an lower case character
	 * @throws NoDigitException if password doesn't have a digit
	 * @throws NoSpecialCharacterException if password doesn't have a special character
	 * @throws InvalidSequenceException if password has more than 2 characters repeating
	 * @return true if valid password follows all the rules
 	 * @return false if password is invalid
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		return isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password);
	}

	/**
	 * @param password
	 * @return true if password is between 6 and 9 characters
	 * @return false if password isn't between 6 and 9 characters 
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length()>=6 && password.length()<=9) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * @param password
	 * @throws WeakPasswordException if password is valid but has less than 10 characters
	 * @return true if password is valid and has at least 10 characters
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException{
		try {
			isValidPassword(password);
		} catch (LengthException e) {
			throw new WeakPasswordException();
		} catch (NoUpperAlphaException e) {
			throw new WeakPasswordException();
		} catch (NoLowerAlphaException e) {
			throw new WeakPasswordException();
		} catch (NoDigitException e) {
			throw new WeakPasswordException();
		} catch (NoSpecialCharacterException e) {
			throw new WeakPasswordException();
		} catch (InvalidSequenceException e) {
			throw new WeakPasswordException();
		}
		if (hasBetweenSixAndNineChars(password) == true)
			throw new WeakPasswordException();
		else
			return false;
	}
	
	/**
	 * @param password
	 * @return invalidPasswords (String ArrayList of invalid passwords)
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String index : passwords) {
			try {
				isValidPassword(index);
			} catch (Exception e) {
				invalidPasswords.add(index + " -> " + e.getMessage());
			}
		}
		return invalidPasswords;
	}
	
}
