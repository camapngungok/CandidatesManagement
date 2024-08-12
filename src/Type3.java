
import java.text.ParseException;
import java.util.Date;

public class Type3 extends Candidate {
    private String majors;
    private int semester;
    private String universityName;

    public Type3(int candidateType, String id, String firstName, String lastName, Date birthDate, String address, int phoneNumber, String emailAddress, String majors, int semester, String universityName) {
        super(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

     @Override
    public String toTXT() {
        return String.format("%d|%s|%s|%s|%s|%s|%d|%s|%s|%d|%s", getCandidateType(), getId(), getFirstName(), getLastName(), getDATE_FORMAT().format(getBirthDate()), getAddress(), getPhoneNumber(), getEmailAddress(), majors, semester, universityName);
    }

    public static Type3 fromTXT(String txt) throws ParseException {
        String[] fields = txt.split("\\|");
        if (fields.length != 11) {
            throw new IllegalArgumentException("TXT data is incomplete.");
        }

        int candidateType = Integer.parseInt(fields[0]);
        String id = fields[1];
        String firstName = fields[2];
        String lastName = fields[3];
        Date birthDate = dateFormat.parse(fields[4]);
        String address = fields[5];
        int phoneNumber = Integer.parseInt(fields[6]);
        String emailAddress = fields[7];
        String majors = fields[8];
        int semester = Integer.parseInt(fields[9]);
        String universityName = fields[10];

        return new Type3(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, majors, semester, universityName);
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    @Override
    public String toString() {
        return super.toString() + ", Majors: " + majors + ", Semester: " + semester + ", University Name: " + universityName;
    }
    
}
