
import java.text.ParseException;
import java.util.Date;

public class Type1 extends Candidate {
    private double expInYear;
    private String proSkill;

    public Type1(int candidateType, String id, String firstName, String lastName, Date birthDate, String address, int phoneNumber, String emailAddress, double expInYear, String proSkill) {
        super(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public String toTXT() {
        return String.format("%d|%s|%s|%s|%s|%s|%d|%s|%d|%s", getCandidateType(), getId(), getFirstName(), getLastName(), getDATE_FORMAT().format(getBirthDate()), getAddress(), getPhoneNumber(), getEmailAddress(), expInYear, proSkill);
    }
     @Override
    public String toString() {
        return super.toString() + ", Exp In Year: " + expInYear + ", Pro Skill: " + proSkill;
    }

    public static Type1 fromTXT(String txt) throws ParseException {
        String[] fields = txt.split("\\|");
        if (fields.length != 10) {
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
        double expInYear = Double.parseDouble(fields[8]);
        String proSkill = fields[9];

        return new Type1(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, expInYear, proSkill);
    }

    public double getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(double expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
}
