package CourseManager;

import CourseManager.PasswordExceptions.*;

public class PasswordValidation 
{
	public PasswordValidation(char[] password) throws PasswordException {
		validatePassword(password);
	}

	private void validatePassword(char[] password) throws PasswordException
	{
		lowerCaseMissing(password);
		upperCaseMissing(password);
		specialCharacterMissing(password);
		numberCharacterMissing(password);
		minimum8CharactersMissing(password);
	}
	
	private void lowerCaseMissing(char[] password) throws LowerCaseCharacterMissing
	{
		//lowercase Missing
		for (char character: password)
		{
			if (character == 'a' ||
					character == 'b' ||
					character == 'c' ||
					character == 'd' ||
					character == 'e' ||
					character == 'f' ||
					character == 'g' ||
					character == 'h' ||
					character == 'i' ||
					character == 'j' ||
					character == 'k' ||
					character == 'l' ||
					character == 'm' ||
					character == 'n' ||
					character == 'o' ||
					character == 'p' ||
					character == 'q' ||
					character == 'r' ||
					character == 's' ||
					character == 't' ||
					character == 'u' ||
					character == 'v' ||
					character == 'w' ||
					character == 'x' ||
					character == 'y' ||
					character == 'z')
			{
				return;
			}
		}
		
		throw new LowerCaseCharacterMissing();
	}
	
	private void upperCaseMissing(char[] password) throws UpperCaseCharacterMissing
	{
		for (char character: password)
		{
			if (character == 'A' ||
					character == 'B' ||
					character == 'C' ||
					character == 'D' ||
					character == 'E' ||
					character == 'F' ||
					character == 'G' ||
					character == 'H' ||
					character == 'I' ||
					character == 'J' ||
					character == 'K' ||
					character == 'L' ||
					character == 'M' ||
					character == 'N' ||
					character == 'O' ||
					character == 'P' ||
					character == 'Q' ||
					character == 'R' ||
					character == 'S' ||
					character == 'T' ||
					character == 'U' ||
					character == 'V' ||
					character == 'W' ||
					character == 'X' ||
					character == 'Y' ||
					character == 'Z')
			{
				return;
			}
		}
		
		throw new UpperCaseCharacterMissing();
	}
	
	private void specialCharacterMissing(char[] password) throws SpecialCharacterMissing
	{
		for (char character: password)
		{
			if (character == '~' ||
					character == '`' ||
					character == '!' ||
					character == '@' ||
					character == '#' ||
					character == '$' ||
					character == '%' ||
					character == '^' ||
					character == '&' ||
					character == '*' ||
					character == '(' ||
					character == ')' ||
					character == '-' ||
					character == '_' ||
					character == '+' ||
					character == '=' ||
					character == '[' ||
					character == '{' ||
					character == ']' ||
					character == '}' ||
					character == '\\' ||
					character == '|' ||
					character == ';' ||
					character == ':' ||
					character == '?' ||
					character == '>' ||
					character == '.' ||
					character == '<' ||
					character == ',' ||
					character == '/')
			{
				return;
			}
		}
		
		throw new SpecialCharacterMissing();
	}
	
	private void numberCharacterMissing(char[] password) throws NumberCharacterMissing
	{
		for (char character: password)
		{
			if (character == '0' ||
					character == '1' ||
					character == '2' ||
					character == '3' ||
					character == '4' ||
					character == '5' ||
					character == '6' ||
					character == '7' ||
					character == '8' ||
					character == '9')
			{
				return;
			}
		}
		
		throw new NumberCharacterMissing();
	}
	
	private void minimum8CharactersMissing(char[] password) throws Minimum8CharactersMissing
	{
		if (password.length < 8)
		{
			throw new Minimum8CharactersMissing();
		}
	}
}
