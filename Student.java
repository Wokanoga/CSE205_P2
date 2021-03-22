/*********************************************************************************************************
 * CLASS: Student (Student.java)
 *
 * DESCRIPTION
 * The Student class is an abstract class that implements the java.lang.Comparable<T> interface 
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

public abstract class Student implements Comparable<Student> {
		
    private int mCredits;
    private String mFirstName;
    private String mId;
    private String mLastName;
    private double mTuition;
    
    /**
     * Creates a Student object and initializes the mId, mFirstName, and mLastName instance
     * variables.
     */
       
    public Student (String Id, String firstName, String lastName) {
    	
    	mId = Id;
    	mFirstName = firstName;
		mLastName = lastName;		
		
    }	  
    
    /**
     * calcTuition() is to be implemented by subclasses of Student. 
     */
		
    public abstract void calcTuition();
    @Override
    public int compareTo(Student pStudent) {
        return getId().compareTo(pStudent.getId());
        
    }
	
    /**
     * Accessor method for mCredits.
     */
	
	public int getCredits() {
		return mCredits;
		
	}
	
    /**
     * Accessor method for mFirstName.
     */
	
	public String getFirstName() {
		return mFirstName;	
	}
	
    /**
     * Accessor method for mId.
     */
		
	public String getId() {
		return mId;
		
	}
		
	/**
     * Accessor method for mLastName.
     */
	
	public String getLastName() {
		return mLastName;
		
	}
		
	/**
     * Accessor method for mTuition.
     */
	
	public double getTuition() {
		return mTuition;
		
	}
	
	/**
     * Mutator method for mCredits.
     */
	
	public void setCredits(int Credits) {
		this.mCredits = Credits;
		
	}
	
    /**
     * Mutator method for mFirstName.
     */
	
	public void setFname(String firstName) {
		this.mFirstName = firstName;
		
	}
	
	/**
     * Mutator method for mId.
     */
	
	public void setId(String Id) {
	    this.mId = Id;
		
	}
	
	/**
     * Mutator method for mLastName.
     */
	
	public void setLname(String lastName) {
		this.mLastName = lastName;
	
    }
	
    /**
     * Mutator method for mTuition.
     */
	
	public void setTuition(double Tuition) {
	    this.mTuition = Tuition;
		
    }
	
}