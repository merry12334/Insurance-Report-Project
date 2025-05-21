package in.ashokit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.CitizenPlan;

public interface CitizenPlanRepository  extends JpaRepository<CitizenPlan, Integer>{
	
	//custom query for showing plan and status in drop down(pre-populate the data in drop dow  n ).
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();

}
