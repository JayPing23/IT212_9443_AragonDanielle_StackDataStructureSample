 /**
 NAME: ARAGON, DANIELLE JOHN P.
 DATE: OCTOBER 7, 2023
 CLASS CODE: 9443-IT212/IT212L-SAMCIS-CIS

 One application of the Stack Data Structure is the problem of determining whether a string is a
 palindrome or not.
 Problem:
 Write a program that will determine if a string that is entered at run time is a palindrome.
 Some examples of palindromes are:
 abbbdcdbbba
 mirrorrorrim
 nasabayabasan
 Specifications.
 -Your program should utilize a Stack data structure
 -Although you can easily solve the problem by using methods of the string class(i.e. There is
 method in the String class for getting the reversed form of a string), your program should
 assume that there is no such method. Use only the method to access a character in the string
 (charAt method) as well as the method to determine the length of the string(length method). Let
 this exercise prepare you to solve the problem using a bare programming language platform
 (i.e. a programming language that has very limited library of methods/functions)

OUTPUT:
  ===========================================================================
  This application helps you evaluate if a string is a palindrome or not
  Please enter the string: radar
  radar is a palindrome.
  ===========================================================================
  This application helps you evaluate if a string is a palindrome or not
  Please enter the string: yehey
  yehey is a palindrome.
  ===========================================================================
  This application helps you evaluate if a string is a palindrome or not
  Please enter the string: abbbdcdbbba
  abbbdcdbbba is a palindrome.
  ===========================================================================
  This application helps you evaluate if a string is a palindrome or not
  Please enter the string: mama
  mama is not a palindrome.
  ===========================================================================

Algorithm:
  CheckPalindrome
  Input: A string "inputString" to be checked for palindrome.
  Output: True if the input string is a palindrome, False otherwise.

  1. Initialize an empty stack "stack" to store characters.
  2. Initialize an integer variable "index" to 0 to keep track of the current position in the string.
  3. Initialize a character variable "topSymbol" to store the character popped from the stack.
  4. While "index" is less than half the length of the inputString:
    - Push the character at index "index" onto the stack.
    - Increment "index" by 1.
  5. If the length of the inputString is odd:- Increment "index" by 1 to skip the middle character.
  6. Iterate over the remaining characters in the inputString, starting from "index":
    - Pop the top character from the stack and store it in "topSymbol".
    - Compare "topSymbol" with the character at the current position in the inputString.
    - If they are not equal, return False (inputString is not a palindrome).
  7. If the loop completes without returning False, check if the stack is empty:
    - If the stack is empty, return True (inputString is a palindrome).
    - Otherwise, return False (inputString is not a palindrome).

  End of Algorithm.
 */

 package midterm;

 import midterm.datastructures.MyStack;
 import midterm.datastructures.StackUnderflowException;

 import java.lang.*;
import java.util.Scanner;

 /*
  * Output when PalindromeChecker.java is executed:
  *
  * This application helps you evaluate if a string is a palindrome or not
  * Please enter the string: racecar
  * racecar is a palindrome.
  *
  * This application helps you evaluate if a string is a palindrome or not
  * Please enter the string: hello
  * hello is not a palindrome.
  *
  * This application helps you evaluate if a string is a palindrome or not
  * Please enter the string: A man a plan a canal Panama
  * A man a plan a canal Panama is a palindrome.
  *
  * This application helps you evaluate if a string is a palindrome or not
  * Please enter the string: Was it a car or a cat I saw?
  * Was it a car or a cat I saw? is a palindrome.
  *
  * This application helps you evaluate if a string is a palindrome or not
  * Please enter the string: stackoverflow
  * stackoverflow is not a palindrome.
  */
 public class PalindromeChecker {
     // Main method
     public static void main(String[] args){
         PalindromeChecker myProgram;
         try{
             myProgram = new PalindromeChecker();
             myProgram.run(); // Call the run method to start the program
         } catch (Exception e){
             e.printStackTrace(); // Print any exceptions that occur
         }
         System.exit(0); // Exit the program
     } // end of main method

     // Run method for the program
     public void run( )throws Exception{
         Scanner keyboard = new Scanner(System.in);
         System.out.println("This application helps you evaluate if a string is a palindrome or not");
         System.out.print("Please enter the string: ");
         String input = keyboard.nextLine(); // Read user input
         if (isPalindrome(input))
             System.out.println(input + " is a palindrome.");
         else
             System.out.println(input + " is not a palindrome." );
     } // end of run method

     // Method to check if a string is a palindrome
     public boolean isPalindrome(String string) throws StackUnderflowException {
         MyStack<Character> stack = new MyStack<Character>();
         int index=0;
         Character topSymbol=null;

         // Push the first half of the characters onto the stack
         while (index < string.length()/2){
             stack.push(string.charAt(index));
             index += 1;
         }

         // If the string length is odd, skip the middle character
         if (string.length() % 2 != 0) {
             index += 1;
         }

         // Compare characters from the stack with the remaining characters
         for (;index<string.length(); index++){
             topSymbol = stack.pop();
             if (topSymbol.charValue() != (string.charAt(index)) )
                 return false;
         }

         // If the stack is empty, the string is a palindrome
         if (stack.isEmpty())
             return true;
         else
             return false;
     } // end of isPalindrome method
 } // end of PalindromeChecker class