
import java.text.ParseException;
import java.util.Date;

public class Type2 extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String university;

    public Type2(int candidateType, String id, String firstName, String lastName, Date birthDate, String address, int phoneNumber, String emailAddress, String graduationDate, String graduationRank, String university) {
        super(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.university = university;
    }

    @Override
    public String toTXT() {
        return String.format("%d|%s|%s|%s|%s|%s|%d|%s|%s|%s|%s", getCandidateType(), getId(), getFirstName(), getLastName(), getDATE_FORMAT().format(getBirthDate()), getAddress(), getPhoneNumber(), getEmailAddress(), graduationDate, graduationRank, university);
    }

    public static Type2 fromTXT(String txt) throws ParseException {
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
        String graduationDate = fields[8];
        String graduationRank = fields[9];
        String university = fields[10];

        return new Type2(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, graduationDate, graduationRank, university);
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
    @Override
    public String toString() {
        return super.toString() + ", Graduation Date: " + graduationDate + ", Graduation Rank: " + graduationRank + ", University: " + university;
    }
    
}
