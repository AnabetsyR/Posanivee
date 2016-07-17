package com.company;

import java.util.Scanner;
import java.io.*;

import static com.company.BST.INORDER;
import static com.company.BST.PREORDER;

/****************************************************************************
 * CampPosanivee
 * The program will keep track of who is enrolled for the two-week summer
 * camp. The program uses a binary search tree to maintain the set of campers
 * enrolled in Camp Posanivee. The program is not case sensitive and reads a
 * text file to process commands.  The commands include: H (help), E (enroll
 * new camper), W (withdraw a camper), D (display the age and gender of a
 * camper), A (display avg age of campers), L (list all campers), S (print the
 * number of boy and girl campers), P (display all campers names in preorder),
 * Q (quit).
 *
 * @author Anabetsy Rivero
 * @version 1.0
 * @date 07/08/16
 * @course CISC-0503 Summer 2016 Data Structures and Algorithms
 * @instructor Dr. Jeremy Lanman
 *****************************************************************************/
public class CampPosanivee {

    //public String name;
    //public String age;
    public char gender;
    public static Camper o = null;
    //public double avgAge;
   // public String Size;

    /*************************************************************************
     * main The main method is the controlling method for Camp Posanivee.
     * Preconditions: must have properly formatted data file.
     * Postconditions: be able to create a Queue and BST for data.
     *
     * @param args
     * @throws IOException
     ************************************************************************/
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Camp Posanivee! ");

        //Get the name of the file from the user
        System.out.println("Please, enter the name of the data file: ");


        // Create new Scanner object to read user input
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        //System.out.println(fileName);
        Scanner fileToRead = new Scanner(new File(fileName));

        //**** Here I may need to create the linked list. Similar to QueueArray!

        //Sets the condition for reading the first character of each line in file.
        boolean flag = true;

        while (fileToRead.hasNext()) {
            String[] line = fileToRead.nextLine().split(" ");
            for (int i = 4; i < line.length; i++)
                line[1] += " " + line[i];

            //BST Tree = new BST();
            QueueLL Q = new QueueLL();

            char action = line[0].charAt(0);

            //if line starts with 'A', print the average age of the campers
            if (action == 'A') {
                System.out.println("The average age of the campers is: ");
            }

            //if line starts with 'H', print a list of commands
            if (action == 'H') {
                System.out.println("The commands available are: E ( enroll camper)" + "\n " + " W( withdraw camper)" + "\n " + "D( display age and gender of camper)" + "\n" + "A( display average age of campers" + "\n" + "L ( display campers' names in alphabetical order" + "\n " + "S( display number of boys and girls" + "\n" + "L(List campers' names in preorder" + "\n" + "Q(quit)");
            }

            //if line starts with 'E', enqueue/insert camper
            if (action == 'E') {
                Camper o = new Camper(line[1], Integer.parseInt(line[2]), line[3]);
                Q.enqueue(o);
                System.out.println("New camper " + o.getName() + " " + "of age " + o.getAge() + " and gender " + o.getGender() + " added ");

            }
            //if line starts with 'W', dequeue/delete camper. I NEED TO FIGURE THIS OUT!!
            if (action == 'W') {
                //System.in =
                Camper o = (Camper) Q.dequeue();

                //Camper o = (Camper) Q.dequeue();
                // System.out.println();
                System.out.println("Camper " + o.getName() + " withdrawn");
            }

            //if line starts with 'D', display age and gender of the camper
            if (action == 'D') {
                //Search for name( line [1]) and return the age and gender

            //It's right up until line[1]. Need to figure out how to get info from BST!!
                System.out.println("The age and gender of camper " + line[1] + " is " + PREORDER);
            }

            //if line starts with 'L', list campers' names in alphabetical order
            if (action == 'L') {
                //INORDER is not the correct way to do this but idk what to do!
                System.out.println("The campers' names are: " + INORDER);//add a way to print all names of campers in queue in alphabetical order
            }

            //if line starts with 'S', print the number of boy and girl campers
            if (action == 'S') {
                System.out.println("The number of boys is: ");//add a way to print number of boys from queue
                System.out.println("The number of girls is:");//add a way to print number of girls from queue
            }

            //if line starts with 'P', print all campers' names in preorder
            if (action == 'P') {
                //Traverse in preorder. HOW???
                System.out.println("The campers' names in preorder is: " + PREORDER);//add a way to print all names in queue in preorder
                System.out.println();

            }


            //if line starts with 'Q', quit
            else if (action == 'Q') {
                break;
            }
        }

            System.out.println("***Camp Posanivee Terminated***");
            System.out.println("Good bye! ");
        }
    }



