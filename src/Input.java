import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Input {

    
    
    public static ArrayList<Candidate> candidates = new ArrayList<>();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static int inputUserChoice(){
        int choice = 0;
        boolean check = false;
        
        
        do{
            try {
                Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            if (choice == 1 
                    || choice == 2
                    || choice == 3
                    || choice == 4
                    || choice == 5
                    || choice == 6
                    || choice == 7){
                check = true;
                
            } else {
                System.out.println("Please input valid option!! ");
            }
            } catch (Exception e) {
                System.out.println("Please enter valid choice!");
            }
        }while(!check);
        return choice;
    }
    
    public static String inputCandidateId(){
        String id;
        boolean check = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's id(SE then 6 numbers no gap): ");
            id = scanner.nextLine();
            if(id.matches("(SE[0-9]{6})")){
 
            int index = findCandidatebyId(id);
            if(index == -1){
            check = true;
            } else{
                System.out.println("Id already exist"  );}
            } else{
                System.out.println("Invalid id");
            }
        }
     while(!check);
        return id;
    }
    public static String inputCandidateIdCheck(){
        String id;
        boolean check = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's id(SE then 6 numbers no gap): ");
            id = scanner.nextLine();
            if(id.matches("(SE[0-9]{6})")){
                check = true;
            }
            else{
                System.out.println("Invalid id");
            }
        }
            while(!check);
            return id;
    }
        
    public static String inputCandidateFirstName(){
        String firstName;  
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's first name: ");
            firstName = scanner.nextLine();
        

        return firstName;
    }
    public static String inputCandidateLastName(){
        String lastName;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's last name: ");
            lastName = scanner.nextLine();
        return lastName;
    }
    
    
    public static String inputCandidateAddress(){
        String address;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's address: ");
            address = scanner.nextLine();
        return address;
    }
    public static String inputCandidateEmailAddress(){
        String email;
        boolean check = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's email address(xxx@gmail.com): ");
            email = scanner.nextLine();
            if(email.matches("(^[a-z,A-Z,0-9]+@gmail.com)$")){
                check = true;
            }
            else{
                System.out.println("Invalid email address");
            }
        }
            while(!check);
            return email;
    }
    public static int inputCandidatePhoneNumber(){
        int phoneNumber=0;
        boolean check = false;
         do{     
             Scanner scanner = new Scanner(System.in);
             System.out.println("Enter phone number: ");
             try{   
                    phoneNumber = scanner.nextInt();
                     check = true; 
             }
                 catch(Exception e){
                     System.out.println("Please enter valid phone number");
                         }
             
         }
         while(!check);
         return phoneNumber;
    }
public static Date inputCandidateBirthDate() {
    Scanner scanner = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);
    Date birthDate = null;
    boolean valid = false;

    while (!valid) {
        try {
            System.out.println("Enter candidate birth date (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();

            // Kiểm tra định dạng trước khi parse
            if (!dateString.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new IllegalArgumentException("Invalid date format. Please use dd/MM/yyyy.");
            }

            birthDate = dateFormat.parse(dateString);
            
            // Kiểm tra xem ngày sinh có phải trong tương lai không
            if (birthDate.after(new Date())) {
                throw new IllegalArgumentException("Birth date cannot be in the future.");
            }
            
            // Kiểm tra tuổi hợp lệ (giả sử từ 18 đến 100 tuổi)
            if (!isAgeValid(birthDate)) {
                throw new IllegalArgumentException("Invalid age. Candidate must be between 18 and 65 years old.");
            }

            valid = true; 
        } catch (ParseException e) {
            System.out.println("Invalid date. Please ensure you're entering a valid date.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    return birthDate;
}
    public static int findCandidatebyId(String id){
    
        for (int i = 0; i < CandidateManagement.candidates.size(); i++) {
            Candidate candidate = CandidateManagement.candidates.get(i);
            if (candidate.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public static boolean inputContinue(){
        Scanner scanner = new Scanner(System.in);
    System.out.println("Press Enter to continue or any other key to stop...");
    String input = scanner.nextLine();
    return input.isEmpty();
    }
    public static int inputType() {
    int type = 0;
    boolean check = false;
    Scanner scanner = new Scanner(System.in);
    do {
        System.out.println("Enter type: ");
        System.out.println("\t1. Experience candidate");
        System.out.println("\t2. Fresher candidate");
        System.out.println("\t3. Intern candidate");
        try {
            type = scanner.nextInt();
            if (type == 1 || type == 2 || type == 3) {
                check = true;
            } else {
                System.out.println("Invalid type. Please enter 1, 2, or 3.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    } while (!check);
    return type;
}
    
    public static String inputCandidateIdDelete(){
        String id;
        boolean check = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's id(SE then 6 numbers no gap): ");
            id = scanner.nextLine();
            if(id.matches("(SE[0-9]{6})")){
 
            int index = findCandidatebyId(id);
            if(index == -1){
                System.out.println("Candidate does not exist!");
            } 
            else{
                check = true;
            }
            } else{
                System.out.println("Invalid id");
            }
        }
     while(!check);
       return id;
    }
    public static Candidate inputExistCandidate(){
        String id;
        int index = 0;
        boolean check = false;
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Candidate's id(SE then 6 numbers no gap): ");
            id = scanner.nextLine();
            if(id.matches("(SE[0-9]{6})")){
 
            index = findCandidatebyId(id);
            if(index != -1){
            check = true;
            
            } else{
                System.out.println("Id does not exist"  );}
            } else{
                System.out.println("Invalid id");
            }
        }
     while(!check);
        return CandidateManagement.candidates.get(index);
    }
    public static String inputProSkill(){
    String proSkill;
    Scanner scanner = new Scanner(System.in);
        System.out.println("Input Candidate's pro skill");
        proSkill = scanner.nextLine();
        return proSkill;
    }
    public static int ExpInYear(){
        int exp=0;
        boolean check = false;
         do{     
             Scanner scanner = new Scanner(System.in);
             System.out.println("Enter Experience in Years: ");
             try{
                    exp = scanner.nextInt();
                     check = true; 
             }
                 catch(Exception e){
                     System.out.println("No string allowed");
                         }
             
         }
         while(!check);
         return exp;
    }

    public static String inputGraduationDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Candidate's graduation date:(dd-MM-yyyy) ");
        return scanner.nextLine();
    }

    public static String inputGraduationRank() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Candidate's graduation rank: ");
        return scanner.nextLine();
    }

    public static String inputUniversity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Candidate's university: ");
        return scanner.nextLine();
    }


    public static String inputMajors() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Candidate's majors: ");
        return scanner.nextLine();
    }

    public static int inputSemester() {
        int semester=0;
        boolean check = false;
         do{     
             Scanner scanner = new Scanner(System.in);
             System.out.println("Enter semester: ");
             try{   
                    semester = scanner.nextInt();
                     check = true; 
             }
                 catch(Exception e){
                     System.out.println("No string allowed");
                         }
             
         }
         while(!check);
         return semester;
    }

    public static String inputUniversityName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Candidate's university name: ");
        return scanner.nextLine();
    }
    public static boolean isAgeValid(Date birthDate) {
    Calendar birthCalendar = Calendar.getInstance();
    birthCalendar.setTime(birthDate);

    Calendar today = Calendar.getInstance();
    int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);
    if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
        age--;
    }

    return age >= 18 && age <= 65;
}
    public static void inputCandidateDetails() {
        Date birthDate = inputCandidateBirthDate();
        
        if (isAgeValid(birthDate)) {
            String major = inputMajors();
        } else {
            System.out.println("Candidate is under 18 years old and cannot have a major.");
        }
    }

    
  
}

