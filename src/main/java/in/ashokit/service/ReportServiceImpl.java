package in.ashokit.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
	    CitizenPlan entity= new CitizenPlan();
	    
	    if(request.getPlanName()!=null && !"".equals(request.getPlanName())) {
	    	entity.setPlanName(request.getPlanName());
	    }
	    
	    if(request.getPlanStatus()!=null && !"".equals(request.getPlanStatus())) {
	    	entity.setPlanStatus(request.getPlanStatus());
	    }
	    
	    if(request.getGender()!=null && !"".equals(request.getGender())) {
	    	entity.setGender(request.getGender());
	    }
	    
	    if(request.getStartDate()!=null && !"".equals(request.getStartDate())) {
	    	String startDate = request.getStartDate();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    	//convert string to local date
	    	LocalDate localDate = LocalDate.parse(startDate, formatter);
	    	entity.setPlanStartDate(localDate);
	    }
	    
	    if(request.getEndDate()!=null && !"".equals(request.getEndDate())) {
	    	String endDate = request.getEndDate();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    	//convert string to local date
	    	LocalDate localDate = LocalDate.parse(endDate, formatter);
	    	entity.setPlanEndDate(localDate);
	    }
	    
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean generateExcel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean generatePdf() {
		// TODO Auto-generated method stub
		return false;
	}

}
