
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Candidate {
    protected int candidateType;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected Date birthDate;
    protected String address;
    protected int phoneNumber;
    protected String emailAddress;
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static SimpleDateFormat getDATE_FORMAT() {
        return DATE_FORMAT;
    }
    public Candidate(int candidateType, String id, String firstName, String lastName, Date birthDate, String address, int phoneNumber, String emailAddress) {
        this.candidateType = candidateType;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s %s, Birth Date: %s, Address: %s, Phone: %d, Email: %s, Type: %d", 
            id, firstName, lastName, dateFormat.format(birthDate), address, phoneNumber, emailAddress, candidateType);
    }

    public static Candidate fromTXT(String txt) throws ParseException {
        String[] fields = txt.split("\\|"); 
        if (fields.length < 8) {
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

        switch (candidateType) {
            case 1:
                double expInYear = Double.parseDouble(fields[8]);
                String proSkill = fields[9];
                return new Type1(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, expInYear, proSkill);
            case 2:
                String graduationDate = fields[8];
                String graduationRank = fields[9];
                String university = fields[10];
                return new Type2(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, graduationDate, graduationRank, university);
            case 3:
                String major = fields[8];
                int semester = Integer.parseInt(fields[9]);
                String universityName = fields[10];
                return new Type3(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, major, semester, universityName);
            default:
                throw new IllegalArgumentException("Unknown candidate type.");
        }
    }

    public abstract String toTXT();

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
}
