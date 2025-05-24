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

		// Clear existing data
		repo.deleteAll();

		// Creating CitizenPlan objects with setter methods
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Amit Sharma");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.of(2024, 1, 1));
		c1.setPlanEndDate(LocalDate.of(2024, 6, 1));
		c1.setBenefitAmount(5000.0);
		c1.setDenialReason(null);
		c1.setTerminatedDate(null);
		c1.setTerminationReason(null);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Sneha Roy");
		c2.setGender("Female");
		c2.setPlanName("Food");
		c2.setPlanStatus("Approved");
		c2.setPlanStartDate(LocalDate.of(2024, 2, 1));
		c2.setPlanEndDate(LocalDate.of(2024, 7, 1));
		c2.setBenefitAmount(3000.0);
		c2.setDenialReason(null);
		c2.setTerminatedDate(null);
		c2.setTerminationReason(null);

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Ravi Mehta");
		c3.setGender("Male");
		c3.setPlanName("Medical");
		c3.setPlanStatus("Approved");
		c3.setPlanStartDate(LocalDate.of(2024, 3, 1));
		c3.setPlanEndDate(LocalDate.of(2024, 8, 1));
		c3.setBenefitAmount(7000.0);
		c3.setDenialReason(null);
		c3.setTerminatedDate(null);
		c3.setTerminationReason(null);

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Lata Kumari");
		c4.setGender("Female");
		c4.setPlanName("Employment");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.of(2024, 1, 15));
		c4.setPlanEndDate(LocalDate.of(2024, 6, 15));
		c4.setBenefitAmount(8000.0);
		c4.setDenialReason(null);
		c4.setTerminatedDate(null);
		c4.setTerminationReason(null);

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Karan Singh");
		c5.setGender("Male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Denied");
		c5.setPlanStartDate(null);
		c5.setPlanEndDate(null);
		c5.setBenefitAmount(null);
		c5.setDenialReason("High income");
		c5.setTerminatedDate(null);
		c5.setTerminationReason(null);

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Nisha Agarwal");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Denied");
		c6.setPlanStartDate(null);
		c6.setPlanEndDate(null);
		c6.setBenefitAmount(null);
		c6.setDenialReason("Invalid documents");
		c6.setTerminatedDate(null);
		c6.setTerminationReason(null);

		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Vikram Patel");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Denied");
		c7.setPlanStartDate(null);
		c7.setPlanEndDate(null);
		c7.setBenefitAmount(null);
		c7.setDenialReason("Age criteria not met");
		c7.setTerminatedDate(null);
		c7.setTerminationReason(null);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Priya Das");
		c8.setGender("Female");
		c8.setPlanName("Employment");
		c8.setPlanStatus("Denied");
		c8.setPlanStartDate(null);
		c8.setPlanEndDate(null);
		c8.setBenefitAmount(null);
		c8.setDenialReason("Already employed");
		c8.setTerminatedDate(null);
		c8.setTerminationReason(null);

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Ramesh Kumar");
		c9.setGender("Male");
		c9.setPlanName("Cash");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.of(2024, 1, 1));
		c9.setPlanEndDate(LocalDate.of(2024, 12, 31));
		c9.setBenefitAmount(6000.0);
		c9.setDenialReason(null);
		c9.setTerminatedDate(LocalDate.of(2024, 4, 15));
		c9.setTerminationReason("Policy violation");

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Shalini Singh");
		c10.setGender("Female");
		c10.setPlanName("Food");
		c10.setPlanStatus("Terminated");
		c10.setPlanStartDate(LocalDate.of(2024, 2, 1));
		c10.setPlanEndDate(LocalDate.of(2024, 11, 30));
		c10.setBenefitAmount(4000.0);
		c10.setDenialReason(null);
		c10.setTerminatedDate(LocalDate.of(2024, 6, 10));
		c10.setTerminationReason("Left region");

		// Add more CitizenPlan objects as needed...

		// Saving all the records in the database
		repo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));
	}
}
  