import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // work with empty string
        String workingString = "";

        System.out.println("Enter the number of operations you want to perform on the string:  ");

        //read input
        int numberOfOperations = sc.nextInt();

// Deque of type string
        Deque<String> stringStack = new ArrayDeque<String>();

        //push the empty string to the deque
        stringStack.push(workingString);

        for (int i = 0; i < numberOfOperations; i++) {
            System.out.println("Available options \npress");
            System.out.println("1.  Append string W to the end of S. \n" +
                    "2.  Delete - Delete the last K characters of S.\n" +
                    "3.  Print - Print the kth character of S.\n" +
                    "4.  Undo the last (not previously undone) operation of type 1 or 2");

            //read in option

            int option = sc.nextInt();

            switch(option){
                case 1:
                    System.out.println("Enter the string you want to append to S:  ");
                    String append = sc.next();
                    //concatenate the strings
                    workingString = workingString + append;
                    //add string to the deque
                    stringStack.push(workingString);

                    //clear the input line
                    sc.next();
                    break;

                case 2:
                    System.out.println("How many characters do you want to remove from the string?  ");
                    int chactersToRemove = sc.nextInt();

                    workingString = workingString.substring(0, workingString.length() - chactersToRemove);

                    //push the result to deque
                    stringStack.push(workingString);
                    sc.next();
                    break;
                case 3:
                    System.out.println("What is the position of the character you want to see?  ");
                    int characterToPrint = sc.nextInt();
                    System.out.println("The character at position " + characterToPrint + " is " +
                            workingString.charAt(characterToPrint - 1));

                    //clear the input line
                    sc.next();
                    break;
                case 4:
                    stringStack.pop();
                    //set string to the value at the top of the deque
                    workingString = stringStack.peek();
                    break;
                default:
                    break;
            }



        }

    }
}
