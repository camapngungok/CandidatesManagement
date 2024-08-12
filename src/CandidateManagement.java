import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CandidateManagement {
    public static List<Candidate> candidates = new ArrayList<>();
    public static final String FILE_NAME = "Candidate.txt";

    public static void insertNewCandidate() {
    String id = Input.inputCandidateId();
    String firstName = Input.inputCandidateFirstName();
    String lastName = Input.inputCandidateLastName();
    Date birthDate = Input.inputCandidateBirthDate();
    String address = Input.inputCandidateAddress();
    int phoneNumber = Input.inputCandidatePhoneNumber();
    String emailAddress = Input.inputCandidateEmailAddress();
    int candidateType = Input.inputType();

    Candidate candidate = null;

    if (candidateType == 1) {
        String proSkill = Input.inputProSkill();
        int expInYear = Input.ExpInYear();
        candidate = new Type1(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, expInYear, proSkill);
    } else if (candidateType == 2) {
        String graduationDate = Input.inputGraduationDate();
        String graduationRank = Input.inputGraduationRank();
        String university = Input.inputUniversity();
        candidate = new Type2(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, graduationDate, graduationRank, university);
    } else if (candidateType == 3) {
        if (Input.isAgeValid(birthDate)) { 
            String majors = Input.inputMajors();
            int semester = Input.inputSemester();
            String universityName = Input.inputUniversityName();
            candidate = new Type3(candidateType, id, firstName, lastName, birthDate, address, phoneNumber, emailAddress, majors, semester, universityName);
        } else {
            System.out.println("Candidate is not eligible due to age restrictions.");
            return; 
        }
    } else {
        System.out.println("Invalid candidate type.");
        return;
    }

    candidates.add(candidate);
    System.out.println("Add new candidate successful");
}

   public static void deleteCandidate() {
        readFromFile();

        if (candidates.isEmpty()) {
            System.out.println("No candidates available to delete.");
            return;
        }

        Candidate candidate = Input.inputExistCandidate();
        if (candidate != null) {
            candidates.remove(candidate);
            System.out.println("Delete candidate successful");
            saveToFile();
        } else {
            System.out.println("Candidate not found.");
        }
    }

    public static void printAll() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }

        for (Candidate candidate : candidates) {
            System.out.println(candidate);
        }
    }

    public static Candidate findCandidateById(String id) {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available to search.");
            return null;
        }

        for (Candidate candidate : candidates) {
            if (candidate.getId().equals(id)) {
                return candidate;
            }
        }
        return null;
    }

    public static void updateCandidate() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available to update.");
            return;
        }

        Candidate candidate = Input.inputExistCandidate();
        if (candidate == null) {
            System.out.println("Candidate not found.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to update?");
        System.out.println("1. Update all information");
        System.out.println("2. Update specific information");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                candidate.setFirstName(Input.inputCandidateFirstName());
                candidate.setLastName(Input.inputCandidateLastName());
                candidate.setEmailAddress(Input.inputCandidateEmailAddress());
                candidate.setPhoneNumber(Input.inputCandidatePhoneNumber());
                candidate.setAddress(Input.inputCandidateAddress());
                candidate.setBirthDate(Input.inputCandidateBirthDate()); 
                System.out.println("Candidate information updated successfully.");
                break;

            case 2:

                boolean continueUpdating = true;
                while (continueUpdating) {
                    System.out.println("Which information do you want to update?");
                    System.out.println("1. First Name");
                    System.out.println("2. Last Name");
                    System.out.println("3. Email Address");
                    System.out.println("4. Phone Number");
                    System.out.println("5. Address");
                    System.out.println("6. Birth Date");
                    System.out.println("7. Exit");
                    int updateChoice = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (updateChoice) {
                        case 1:
                            candidate.setFirstName(Input.inputCandidateFirstName());
                            System.out.println("First name updated successfully.");
                            break;
                        case 2:
                            candidate.setLastName(Input.inputCandidateLastName());
                            System.out.println("Last name updated successfully.");
                            break;
                        case 3:
                            candidate.setEmailAddress(Input.inputCandidateEmailAddress());
                            System.out.println("Email address updated successfully.");
                            break;
                        case 4:
                            candidate.setPhoneNumber(Input.inputCandidatePhoneNumber());
                            System.out.println("Phone number updated successfully.");
                            break;
                        case 5:
                            candidate.setAddress(Input.inputCandidateAddress());
                            System.out.println("Address updated successfully.");
                            break;
                        case 6:
                            candidate.setBirthDate(Input.inputCandidateBirthDate()); 
                            System.out.println("Birth date updated successfully.");
                            break;
                        case 7:
                            continueUpdating = false;
                            System.out.println("Exiting update mode.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                            break;
                    }
                }
                break;

            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                break;
        }
    }
    public static void saveToFile() {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
        for (Candidate candidate : candidates) {
            writer.println(candidate.toTXT()); 
        }
        System.out.println("Saved to file successfully.");
    } catch (IOException e) {
        System.out.println("Error saving to file: " + e.getMessage());
    }
}
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            candidates.clear();
            while ((line = reader.readLine()) != null) {
                try {
                    Candidate candidate = Candidate.fromTXT(line);
                    if (candidate != null) {
                        candidates.add(candidate);
                    }
                } catch (IllegalArgumentException | ParseException e) {
                    System.out.println("Skipping invalid TXT data: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

}
