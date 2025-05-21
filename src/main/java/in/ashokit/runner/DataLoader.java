package in.ashokit.runner;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	

    @Autowired
    private CitizenPlanRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
        repo.deleteAll();
        
        CitizenPlan c1 = new CitizenPlan(101, "Amit Sharma", "Male", "Cash", "Approved", 
            LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 1), 5000.0, null, null, null);
        CitizenPlan c2 = new CitizenPlan(102, "Sneha Roy", "Female", "Food", "Approved", 
            LocalDate.of(2024, 2, 1), LocalDate.of(2024, 7, 1), 3000.0, null, null, null);
        CitizenPlan c3 = new CitizenPlan(103, "Ravi Mehta", "Male", "Medical", "Approved", 
            LocalDate.of(2024, 3, 1), LocalDate.of(2024, 8, 1), 7000.0, null, null, null);
        CitizenPlan c4 = new CitizenPlan(104, "Lata Kumari", "Female", "Employment", "Approved", 
            LocalDate.of(2024, 1, 15), LocalDate.of(2024, 6, 15), 8000.0, null, null, null);

        CitizenPlan c5 = new CitizenPlan(105, "Karan Singh", "Male", "Cash", "Denied", 
            null, null, null, "High income", null, null);
        CitizenPlan c6 = new CitizenPlan(106, "Nisha Agarwal", "Female", "Food", "Denied", 
            null, null, null, "Invalid documents", null, null);
        CitizenPlan c7 = new CitizenPlan(107, "Vikram Patel", "Male", "Medical", "Denied", 
            null, null, null, "Age criteria not met", null, null);
        CitizenPlan c8 = new CitizenPlan(108, "Priya Das", "Female", "Employment", "Denied", 
            null, null, null, "Already employed", null, null);

        CitizenPlan c9 = new CitizenPlan(109, "Ramesh Kumar", "Male", "Cash", "Terminated", 
            LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), 6000.0, null, 
            LocalDate.of(2024, 4, 15), "Policy violation");
        CitizenPlan c10 = new CitizenPlan(110, "Shalini Singh", "Female", "Food", "Terminated", 
            LocalDate.of(2024, 2, 1), LocalDate.of(2024, 11, 30), 4000.0, null, 
            LocalDate.of(2024, 6, 10), "Left region");
        CitizenPlan c11 = new CitizenPlan(111, "Anuj Verma", "Male", "Medical", "Terminated", 
            LocalDate.of(2024, 1, 10), LocalDate.of(2024, 10, 10), 7500.0, null, 
            LocalDate.of(2024, 5, 1), "Falsified info");
        CitizenPlan c12 = new CitizenPlan(112, "Kajal Yadav", "Female", "Employment", "Terminated", 
            LocalDate.of(2024, 3, 1), LocalDate.of(2024, 9, 1), 9000.0, null, 
            LocalDate.of(2024, 7, 1), "Breach of contract");

        CitizenPlan c13 = new CitizenPlan(113, "Deepak Joshi", "Male", "Cash", "Approved", 
            LocalDate.of(2024, 4, 1), LocalDate.of(2024, 9, 1), 5200.0, null, null, null);
        CitizenPlan c14 = new CitizenPlan(114, "Meena Iyer", "Female", "Food", "Approved", 
            LocalDate.of(2024, 5, 1), LocalDate.of(2024, 10, 1), 3500.0, null, null, null);
        CitizenPlan c15 = new CitizenPlan(115, "Harsh Thakur", "Male", "Medical", "Approved", 
            LocalDate.of(2024, 3, 15), LocalDate.of(2024, 8, 15), 7100.0, null, null, null);
        CitizenPlan c16 = new CitizenPlan(116, "Ritu Sharma", "Female", "Employment", "Approved", 
            LocalDate.of(2024, 1, 20), LocalDate.of(2024, 7, 20), 8800.0, null, null, null);

        CitizenPlan c17 = new CitizenPlan(117, "Ajay Bansal", "Male", "Cash", "Denied", 
            null, null, null, "Incomplete application", null, null);
        CitizenPlan c18 = new CitizenPlan(118, "Pooja Chauhan", "Female", "Food", "Denied", 
            null, null, null, "Not eligible", null, null);
        CitizenPlan c19 = new CitizenPlan(119, "Suresh Rana", "Male", "Medical", "Denied", 
            null, null, null, "Unverified identity", null, null);
        CitizenPlan c20 = new CitizenPlan(120, "Divya Rani", "Female", "Employment", "Denied", 
            null, null, null, "Background check failed", null, null);

        CitizenPlan c21 = new CitizenPlan(121, "Manish Rawat", "Male", "Cash", "Terminated", 
            LocalDate.of(2024, 2, 10), LocalDate.of(2024, 8, 10), 5600.0, null, 
            LocalDate.of(2024, 5, 25), "Incomplete reports");
        CitizenPlan c22 = new CitizenPlan(122, "Neha Tiwari", "Female", "Food", "Terminated", 
            LocalDate.of(2024, 3, 5), LocalDate.of(2024, 9, 5), 4200.0, null, 
            LocalDate.of(2024, 6, 15), "Uninformed absence");
        CitizenPlan c23 = new CitizenPlan(123, "Tarun Nair", "Male", "Medical", "Terminated", 
            LocalDate.of(2024, 4, 1), LocalDate.of(2024, 12, 1), 8000.0, null, 
            LocalDate.of(2024, 7, 10), "Faked documents");
        CitizenPlan c24 = new CitizenPlan(124, "Preeti Sinha", "Female", "Employment", "Terminated", 
            LocalDate.of(2024, 1, 1), LocalDate.of(2024, 6, 30), 9300.0, null, 
            LocalDate.of(2024, 5, 5), "Violation of agreement");

        repo.saveAll(Arrays.asList(
                c1, c2, c3, c4, c5, c6, c7, c8,
                c9, c10, c11, c12, c13, c14, c15, c16,
                c17, c18, c19, c20, c21, c22, c23, c24
        ));
    }
}
