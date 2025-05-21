package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenPlan {
	
   @Id
    private Integer citizenId;

    private String citizenName;

    private String gender;

    private String planName;

    private String planStatus;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

    private Double benefitAmount;

    private String denialReason;

    private LocalDate terminatedDate;

    private String terminationReason;

}
