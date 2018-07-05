package net.cnr.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("commisionCalculateService")
@Component
public class CommisionCalculateServiceImpl implements CommisionCalculateService {

    private double commision;
    private static int  members_for_group = 5;
    private static int  comission_from_one_recruiter = 200;
    private  static Double comission_rate_for_one_recruiter = 0.1;

    @Override
    public double calculateCommission(String recruitmentStatus) {

        if(recruitmentStatus.equals("true"))
            commision = (members_for_group*comission_from_one_recruiter+(members_for_group*comission_from_one_recruiter)*comission_rate_for_one_recruiter);
        else{
            commision = comission_from_one_recruiter;
        }
        return commision;
    }
}
