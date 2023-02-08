package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */
        try (userInput) {
            System.out.println("What is the search word?");
            final String searchedWord = userInput.nextLine();

            System.out.println("What is the replacement word?");
            final String replacementWord = userInput.nextLine();

            System.out.println("What is the source file?");
            final String sourceFile = userInput.nextLine();
            final File source = new File(sourceFile);

            System.out.println("What is the destination file?");
            final String destinationFile = userInput.nextLine();
           final File destination = new File(destinationFile);


            try (
                    Scanner dataInput = new Scanner(source);
                    PrintWriter dataOutput = new PrintWriter(destination);
            ) {
                while (dataInput.hasNextLine()) {
                    String lineOfInput = dataInput.nextLine();
                    dataOutput.println(lineOfInput.replace(searchedWord, replacementWord));
                }
            } catch (FileNotFoundException e) {
                System.err.println("File does not exist");
            }

        }
    }
}

//    } catch(
//    FileNotFoundException source)
//            System.out.println("That file does not exist");
//    {
//}
//    catch(FileNotFoundException destination){
//            return
//            }
//
//            }
//try (
//        Scanner dataInput = new Scanner(inputFile);
//        PrintWriter dataOutput = new PrintWriter(outputFile)
//        ) {
//        while(dataInput.hasNextLine()) {
//        String lineOfInput = dataInput.nextLine();
//        dataOutput.println(lineOfInput.replace("mobile", "cellphone"));
//        }
//        } catch (FileNotFoundException e) {
//        System.err.println("Cannot open the file for writing.");
//        }
