/*********************************************************************************************************
 * CLASS: OnlineStudent (OnlineStudent.java)
 *
 * DESCRIPTION
 * The OnlineStudent class is a sub abstract class of student.
 *
 * COURSE AND PROJECT INFORMATION
 * CSE205 Object Oriented Programming and Data Structures, Spring Session B and 2021
 * Project Number: 02
 *
 * GROUP INFORMATION
 * AUTHOR 1: Steve Tippeconnic, stippeco, stippeco@asu.edu
 * AUTHOR 2: Allan Nevala, anevala, anevala@asu.edu
 * AUTHOR 3: Harlon Turner, htturner, htturner@asu.edu 
 * AUTHOR 4: Lincoln MacKay, lmackay, lmackay@asu.edu 
 ********************************************************************************************************/

//Abstract subclass of Student.
public abstract class OnlineStudent extends Student {

    //Private instance variable, set to false on declaration.
    private boolean mTechFee = false;

    //call the superclass to make an object
    OnlineStudent(String id, String fName, String lName){
        super(id, fName, lName);
    }

    //override the student calcTuition with our own.
    @Override
    public void calcTuition() {
        double t = getCredits()*TuitionConstants.ONLINE_CREDIT_RATE;
        if (getTechFee()){
            t += TuitionConstants.ONLINE_TECH_FEE;
        }
        setTuition(t); 
    }

    //private helper method
    private boolean getTechFee(){
        return this.mTechFee;
    }

    //public? setter method.
    protected void setTechFee(Boolean pTechFee){
        this.mTechFee = pTechFee;
    }
}
