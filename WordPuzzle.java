
/**
 * This class make a word puzzle with words the user have chosen.
 *
 * @author Yuki Miyazawa
 * @version Nov. 27, 2018
 */

import java.util.*;
import java.util.Random;
public class WordPuzzle
{
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    static final byte MINIMUM_SIZE = 5; // Constants for minimum possible size of lists
    static final byte MAXIMUM_SIZE = 10; //  Constants for maximum possible size of lists

    public static void main(String[] args)
    {
        char[][] words ; // Declare two dimensional arrays. contains no memory.
        displayPurpose(); // Call displayPurpose method
        byte size = getSize(); // Get input from the user
        words = new char[size][size]; // Here deciding what size the two dimensional array would be by putting the input from the user
        System.out.printf("Enter %d words with capitalized letter. Each word has to be no more than %d characters long.\n",size,size);
        String[] answers = new String[size]; // This single dimensional array is declared for storing words input by the user
        fillWithWords(words,size,answers); // Calling fillWithNames method to fill the 2D arrays with input from the user
        fillUnusedElements(words,size); // Calling fillUnusedElements method to fill any blank spaces made in the 2D arrays with random characters
        displayWords(words,size);  // Calling displayWords method to show the result of puzzle
        displayAnswers(answers,size); // Calling sisplayAnswers method to show answers

    }//of main

    private static void displayPurpose() // This method displays the purpose of this program
    {
        System.out.println("*********************************WELCOME****************************************");
        System.out.println("///////////////////This program creates a word puzzle///////////////////////////");
        System.out.println("*********************************WELCOME****************************************");

    }//displayPurpose



    private static byte getSize(){ // This method asks the user to input size of quiz list they want to use and return the number to main method
    	byte size = 0; // Initialize a variable
    	do{
        	System.out.println("Select the size of the puzzle you would like to create (>=5 and <= 10)");
    		size = input.nextByte();
    		if(size>MAXIMUM_SIZE || size<MINIMUM_SIZE){
    			System.out.println("Invalid size input! the number must be >= 5 and <= 10. Please type it again"); // Warning sign when the input was invalid
    		}//of if
    	}while(size>MAXIMUM_SIZE || size<MINIMUM_SIZE); // Repeats the cycle unless the input meets the requirement

    	// When the input met the requirement, the input data goes down and is returned to main method

    	return size;
    }


    /**
 * This method asks the user to input words and it stored the input in random position on 2D dimensional arrays
 * This method saves every inputs into 1D array
 * @param [][]words is from main method it has 2D arrays for storing words into puzzle
 * @param size is from main method it has the size of arrays that is decided by the user
 * @param []answers is from main method it has 1D arrays for storing words into list so all words would be shown in the last part of this program
 */

    private static void fillWithWords(char[][] words, int size, String []answers)
    {
        String userInput; // Initialize String so every words the user typed will be stored into 1D array
        userInput = input.nextLine();// Flush the space;

        for(int i= 0; i < size; i++) // As a whole it repeats 'size' times
        {
        	do{
                System.out.printf("Please enter word No.%d: ",i+1);

                userInput = input.nextLine();
                userInput = userInput.trim();
                if (userInput.length() > size){
                    System.out.printf("Invalid size input! The word can not be more than %d characters. Please type it again.%n", size);
                }//if
            }while(userInput.length() > size); // Repeats the cycle unless the input meets the requirement
        		answers[i] = userInput;  // Every time input met the requirement, it goes to 1D array , will be saved there, and counter[i]will be + 1
                int rondom = random.nextInt(size - userInput.length() + 1); // Calculating possible empty space and generates random numbers accordingly
                for(int j= 0; j < userInput.length(); j++){ //Iterate the cycle as many times as the input was
                	words[i][j+rondom]= userInput.charAt(j);//This method gets the character at position j
                }//for j

        }//for i

    }//fillWithWords

/**
 * This method displays the puzzle with input
 * @param [][]words is from main method it has 2D arrays for storing words into puzzle
 * @param size is from main method it has the size of arrays that is decided by the user
 */
    private static void displayWords(char[][] words, int size)
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~Words List~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i=0; i < size; i++)   // As a whole this cycle repeats 'size' times
        {
            for(int j=0; j < size ; j++){ // Print out each elements in 2D arrays [0][0],[0][1],[0][2]...,[1][0],[1][1],[1][2],
                System.out.printf("%c    ",words[i][j]);
            }//for j
            System.out.println();
        }//for i
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }//displayWords

/**
 * This method fills any empty spaces in 2D arrays after receiving inputs from the user with random alphabetical words
 * @param [][]words is from main method it has 2D arrays for storing words into puzzle
 * @param size is from main method it has the size of arrays that is decided by the user
 */
    private static void fillUnusedElements(char[][] words, int size)
    {	//These are choices of 1D array that can be chosen as random characters
        char[] randomCharacters ={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P','Q','R','S','T','U'};
        int randomNumber=0;// Initialize
        for(int i= 0; i < size; i++){ // Go through every rows in 2D array
            for(int j= 0; j < size; j++){ // Go through every columns in 2D array
                randomNumber = random.nextInt(size);//Gets a random number in the range 0 to (size)
                if (words[i][j] == '\u0000') // when it finds any place that is empty = null = '\u0000',
                    words[i][j] = randomCharacters[randomNumber]; // they would be replaced with character that is randomly chosen from 1D array list above
            }//for j
        }//for i

    }//fillUnusedElements

/**
 * This method displays all input the user typed for the answers by printing put 1D array
 * @param answers is from fillWithWords method it has taken each input from user and saved them inside it
 * @param size is from main method it has the size of arrays that is decided by the user
 */
    private static void displayAnswers(String[] answers, int size)
    {
        System.out.println("/////////////////////////List of Answers//////////////////////////");
            for(int i=0; i < size ; i++){ // Go through every elements in []answers array
                System.out.printf("%s    \n",answers[i]); //
            }//for j
            System.out.println();
    }//displayAnswers



}//of class
