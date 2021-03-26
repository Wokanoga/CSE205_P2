/*********************************************************************************************************
 * CLASS: OnlineStudent (OnlineStudent.java)
 *
 * DESCRIPTION
 * The OnlineStudent class is a sub class of student.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring Session B and 2021
 * Project Number: 02
 *
 * GROUP INFORMATION
 * AUTHOR 1: Lincoln MacKay, lmackay, lmackay@asu.edu 
 * AUTHOR 2: Steve Tippeconnic, stippeco, stippeco@asu.edu
 * AUTHOR 3: Harlon Turner, htturner, htturner@asu.edu 
 * AUTHOR 4: Allan Nevala, anevala, anevala@asu.edu
 ********************************************************************************************************/

/**
*  Class for OnlineStudent, a subclass of Student
*/
public class OnlineStudent extends Student {

    private boolean mTechFee = false;   // Certain OnlineStudent's pay an additional tech fee. This will be true if the fee applies and false if not.
    
    // Constructor for Online student using the Student superclass constructor
    public OnlineStudent(String id, String fName, String lName) {

        super(id, fName, lName);

    }

    // Override the Student superclass' calcTuition
    @Override
    public void calcTuition() {

        // Calculate tuition based on credits and online credit rate
        double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;

        // Update the total with an online tech fee if it applies
        if (getTechFee()){
            t += TuitionConstants.ONLINE_TECH_FEE;
        }

        // Update the student's tuition
        setTuition(t); 
    }

    // Return the student's tech fee
    public boolean getTechFee(){
        return this.mTechFee;
    }

    // Update the student's tech fee
    public void setTechFee(Boolean pTechFee){
        this.mTechFee = pTechFee;
    }
    
}