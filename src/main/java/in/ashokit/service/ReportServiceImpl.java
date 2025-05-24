package in.ashokit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepository;
import in.ashokit.request.SearchRequest;
import in.ashokit.utils.EmailUtils;
import in.ashokit.utils.ExcelGenerator;
import in.ashokit.utils.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository repo;

	@Autowired
	private ExcelGenerator excelGenerator;

	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtilts;

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
		CitizenPlan entity = new CitizenPlan();

		if (request.getPlanName() != null && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (request.getPlanStatus() != null && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (request.getGender() != null && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (request.getStartDate() != null && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert string to local date
			LocalDate localDate = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(localDate);
		}

		if (request.getEndDate() != null && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			// convert string to local date
			LocalDate localDate = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(localDate);
		}

		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean generateExcel(HttpServletResponse response) throws Exception {
		File f= new File("plans.xls");
		
		List<CitizenPlan> plans = repo.findAll();
		excelGenerator.generate(response, plans,f);
		
		String subject="Test mail Subject";
		String body="<h2>Test Mail Body</h2>";
		String to="monalishap84@gmail.com";
		
		emailUtilts.sendEmail(subject, body, to,f);
		f.delete();
		
		return true;
	}

	@Override
	public boolean generatePdf(HttpServletResponse response) throws Exception {
		File f= new File("plans.pdf");
		
		List<CitizenPlan> plans = repo.findAll();
		pdfGenerator.generate(response, plans,f);
		
		String subject="Test mail Subject";
		String body="<h2>Test Mail Body</h2>";
		String to="monalishap84@gmail.com";
		
		emailUtilts.sendEmail(subject, body, to,f);
		f.delete();
		
		return true;
	}

}
