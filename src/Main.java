
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    public static void main(String[] args)  {
        int choice;
        
        boolean isContinue = false;
        CandidateManagement.readFromFile();

        do{
            Menu.printMenu();
        choice = Input.inputUserChoice();
            if(choice == 1){
            String id = Input.inputCandidateIdCheck(); 
                Candidate candidate = CandidateManagement.findCandidateById(id);
                if (candidate != null) {
                    System.out.println("Candidate found: " + candidate);
                } else {
                    System.out.println("Candidate not found.");
                }
               
                
        } else if(choice == 2){
             CandidateManagement.insertNewCandidate();
        } else if(choice == 3){
             CandidateManagement.updateCandidate();
        } 
        else if(choice == 4){
             CandidateManagement.deleteCandidate();
        }else if(choice == 5){
             CandidateManagement.printAll();
        }
            else if(choice == 6){
             CandidateManagement.saveToFile();
        }
        
            
            isContinue = Input.inputContinue();
        }while(isContinue);
    }
    
}
