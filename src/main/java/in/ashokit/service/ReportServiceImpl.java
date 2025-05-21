package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
		
		return repo.getPlanName();
	}

	@Override
	public List<String> getPlanStatuses() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
	    List<CitizenPlan> all = repo.findAll();
	    List<CitizenPlan> filtered = new ArrayList<>();

	    for (CitizenPlan p : all) {
	        boolean match = true;

	        if (request.getPlanName() != null && !request.getPlanName().equals(p.getPlanName()))
	            match = false;
	        if (request.getPlanStatus() != null && !request.getPlanStatus().equals(p.getPlanStatus()))
	            match = false;
	        if (request.getGender() != null && !request.getGender().equals(p.getGender()))
	            match = false;
	        if (request.getStartDate() != null && !request.getStartDate().equals(p.getPlanStartDate()))
	            match = false;
	        if (request.getEndDate() != null && !request.getEndDate().equals(p.getPlanEndDate()))
	            match = false;

	        if (match) {
	            filtered.add(p);
	        }
	    }

	    return filtered;
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
