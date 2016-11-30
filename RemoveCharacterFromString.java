package myreverseList;

import java.util.Scanner;

public class RemoveCharacterFromString
{
	public static void main(String[] args)
    {
        String inputString, outputString;
        char inputChar;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the string: ");
        inputString = s.nextLine();
        System.out.println("Enter a character that is to be removed from the above string: ");
        inputChar = s.next().charAt(0);
        //System.out.println("The output is:");
        outputString = inputString.replace(inputChar, '\u0000');
        System.out.println(outputString);
        s.close();
    }

}
