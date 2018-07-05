package net.cnr.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Recruitement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "is_group_recruitement")
    private String isGroupRecruitement;
    @Column(name = "head_hunter_id")
    private int headHunterId;
    @Column(name = "recruiter_skill")
    private String recruiterSkill;
    private Double commission;
    @Column(name = "recruited_date")
    private Date reccruitedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsGroupRecruitement() {
        return isGroupRecruitement;
    }

    public void setIsGroupRecruitement(String isGroupRecruitement) {
        this.isGroupRecruitement = isGroupRecruitement;
    }

    public int getHeadHunterId() {
        return headHunterId;
    }

    public void setHeadHunterId(int headHunterId) {
        this.headHunterId = headHunterId;
    }

    public String getRecruiterSkill() {
        return recruiterSkill;
    }

    public void setRecruiterSkill(String recruiterSkill) {
        this.recruiterSkill = recruiterSkill;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Date getReccruitedDate() {
        return reccruitedDate;
    }

    public void setReccruitedDate(Date reccruitedDate) {
        this.reccruitedDate = reccruitedDate;
    }
}
