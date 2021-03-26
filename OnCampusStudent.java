/*********************************************************************************************************
 * CLASS: OnCampusStudent (OnCampusStudent.java)
 *
 * DESCRIPTION
 * The OnCampusStudent class is a direct subclass of the abstract class Student, and provides methods relevant to on-campus students
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring Session B and 2021
 * Project Number: 02
 *
 * GROUP INFORMATION
 * AUTHOR 1: Allan Nevala, anevala, anevala@asu.edu
 * AUTHOR 2: Steve Tippeconnic, stippeco, stippeco@asu.edu
 * AUTHOR 3: Harlon Turner, htturner, htturner@asu.edu 
 * AUTHOR 4: Lincoln MacKay, lmackay, lmackay@asu.edu 
 ********************************************************************************************************/

/**
*  Class for OnCampusStudent, a subclass of Student
*/
public class OnCampusStudent extends Student {

    private int mResident;              // The student instance's residency type for tuition purposes
    private double mProgramFee = 0;     // The student total tuition due


    public final int RESIDENT = 1;      // The OnCampusStudent residency types for tuition purposes
    public final int NON_RESIDENT = 2;
    
    /**
     * Constructor calls the superclass Student constructor and passes pId, pFirstName, and pLastName to it as parameters
     */
    public OnCampusStudent(String pId, String pFirstName, String pLastName) {
        
        super(pId, pFirstName, pLastName);
    }

    /**
     * Calculates the tuition the student should pay based on their residency, credits, and program fees
     */
    @Override   // Override the superclass Student's method called calcTuition() 
    public void calcTuition() {
        
        double t;   // Total tuition amount

        // Adds the tuition base amount to total depending on the student's residency type
        if (getResidency() == RESIDENT) {
            t = TuitionConstants.ONCAMP_RES_BASE;
        } else {
            t = TuitionConstants.ONCAMP_NONRES_BASE;
        }

        t = t + getProgramFee();    // Add the program fee to the tuition total

        // If the credits exceed a credit limit threshold, add an extra fee for each credit hour over it
        if (getCredits() > TuitionConstants.ONCAMP_MAX_CREDITS) {
            t = t + ((getCredits() - TuitionConstants.ONCAMP_MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS);
        }

        setTuition(t);  // Update the student's tuition with the total tuition
    }

    /**
     * Returns the student's current program fee
     */
    public double getProgramFee() {
        return this.mProgramFee;
    }

    /**
     * Returns the student's current residency type (Note: RESIDENT = 1, NON_RESIDENT = 2)
     */
    public int getResidency() {
        return this.mResident;
    }

    /**
     * Updates the student's current program fee
     */
    public void setProgramFee(double pProgramFee) {
        this.mProgramFee = pProgramFee;
    }

    /**
     * Updates the student's current residency type (Note: RESIDENT = 1, NON_RESIDENT = 2)
     */
    public void setResidency(int pResident) {
        this.mResident = pResident;
    }

}