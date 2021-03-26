/*********************************************************************************************************
 * CLASS: Main (Main.java)
 *
 * DESCRIPTION
 * Finds tuition information for given students in p02-students.txt and outputs p02-tuition.txt.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring Session B and 2021
 * Project Number: 02
 *
 * GROUP INFORMATION
 * AUTHOR 1: Harlon Turner, htturner, htturner@asu.edu 
 * AUTHOR 2: Allan Nevala, anevala, anevala@asu.edu
 * AUTHOR 3: Steve Tippeconnic, stippeco, stippeco@asu.edu
 * AUTHOR 4: Lincoln MacKay, lmackay, lmackay@asu.edu 
 ********************************************************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {  

        new Main().run();
    }

    // Default constructor for Main
    public Main() {
        
    }
     
    /**
     *  Calls other methods to implement the sw requirements.
     */
    private void run() throws FileNotFoundException {

        ArrayList<Student> studentList = null;

        // Try to read the list of students from p02-students.txt and store it in studentList. 
        try {
            
            studentList = readFile();   // Reads the file and returns an arraylist of students 

        } catch (FileNotFoundException exception) {

            // If opening file fails, show an error and terminate the program.
            System.out.println("Sorry, could not open 'p02-students.txt' for reading. Stopping.");
            System.exit(-1);

        }

        calcTuition(studentList);   // Calculate the tuition for each Student in studentList
        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);   // Sort the students in studentList into ascending order based on student identifier

        // Try to write the list of students and their calculated tuitions to p02-tuition.txt 
        try {

            writeFile(studentList); // Creates a p02-tuition.txt file the local folder

        } catch (FileNotFoundException exception) {

            // If we cannot open the output file for writing, then we output an error message and terminate the program.
            System.out.println("Sorry, could not open 'p02-tuition.txt' for writing. Stopping.");
            System.exit(-1);

        }
         
    }

     /**
     * Calculates the tuition for each Student in pStudentList. Note: this is a polymorphic method call.
     */
    private void calcTuition(ArrayList<Student> pStudentList) {

        for (Student student : pStudentList) {
            student.calcTuition();
        }

    }

     /**
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     */
    private ArrayList<Student> readFile() throws FileNotFoundException { 

        ArrayList<Student> studentList = new ArrayList<>();
        
        // Open "p02-students.txt" for reading using a Scanner object named "in" (Note: Requirement 4.2: The program shall read the contents of "p02-students.txt")
        String fileName = "p02-students.txt";
        File inputFile = new File(fileName); 
        Scanner in = new Scanner(inputFile);
        
        // Loop through each line of the file to get the student data
        while (in.hasNext()) {

            String studentType = in.next();

            // Update the student's campus (e.g. online, on-campus)
            if (studentType.equals("C")) { 
                studentList.add(readOnCampusStudent(in));
            } else {
                studentList.add(readOnlineStudent(in));
            }
 
        }

        in.close(); // Close the scanner

        // Return an arraylist of Student objects
        return studentList;
    }

     /**
     * Reads the information for an on-campus student from the input file.
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) {
        
        // Parse the values into variables from the scanner passed in as a parameter
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnCampusStudent onCampusStudent = new OnCampusStudent(id, fname, lname);    // Initialize a new on campus student object
        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();

        // Update the student's residency status
        if (res.equals("R")) {
            onCampusStudent.setResidency(onCampusStudent.RESIDENT);
        } else {
            onCampusStudent.setResidency(onCampusStudent.NON_RESIDENT);
        }

        onCampusStudent.setProgramFee(fee);     // Update the student's program fees
        onCampusStudent.setCredits(credits);    // Update the student's credits

        // Return the OnCampusStudent object instance
        return onCampusStudent;

    }

    /**
     * Reads the information for an online student from the input file.
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {

        // Parse the values into variables from the scanner passed in as a parameter
        String id = pIn.next();
        String lname = pIn.next();
        String fname = pIn.next();
        OnlineStudent student = new OnlineStudent(id, fname, lname);    // Initialize a new online student object
        String fee = pIn.next();    
        int credits = pIn.nextInt();
        
        // Charge student a tech fee if needed (Note: some online students enrolled in certain degree programs pay an online technology fee  per semester)
        if (fee.equals("T")) {
            student.setTechFee(true); 
        } else {
            student.setTechFee(false);
        }

        // Update the student's credits
        student.setCredits(credits);

        // Return the online student object instance
        return student;

    }

    /**
     * Writes the output to "p02-tuition.txt" per the software requirements. This method 
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {

        // Requirement 4.3: The program shall write the tuition results to an output file named "p02-tuition.txt"
        File outputFile = new File("p02-tuition.txt"); 
        PrintWriter out = new PrintWriter(outputFile); 

        // Print each student from the list in the format per per SW Requiremment 3: id last-name first-name tuition
        for (Student student : pStudentList) {

           out.printf("%-16s", student.getId()); 
           out.printf("%-20s", student.getLastName()); 
           out.printf("%-15s", student.getFirstName()); 
           out.printf("%8.2f", student.getTuition()); 
           out.print("\n"); 

        }
           
           out.close(); // Close the output file
    }
