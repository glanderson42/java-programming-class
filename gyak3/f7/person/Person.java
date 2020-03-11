package person;

public class Person {
	private String firstName;
	private String secondName;
	private String job;
	private Gender gender;
	private int	bornYear;
	
	public Person(String fname, 
				  String sname,
				  String job,
				  Gender g,
				  int byear) {
	    this.firstName = fname;
	    this.secondName = sname;
	    this.job = job;
		this.gender = g;
		this.bornYear = byear;
	}
	
	public boolean equals(Person p) {
		return (firstName.compareTo(p.firstName) == 0 &&
		   secondName.compareTo(p.secondName) == 0 &&
		   job.compareTo(p.job) == 0 &&
		   gender == p.gender && bornYear == p.bornYear);
	}
	
	@Override
	public String toString() {
		String g;
		if(gender == Gender.FEMALE) {
			g = new String("FEMALE");
		} else {
			g = new String("MALE");
		}
		return "First name: " + firstName +
		       "\nSecond name: " + secondName +
		       "\nJob: " + job +
		       "\nGender: " + g +
		       "\nBorn Year: " + bornYear;
		       
	}
}
