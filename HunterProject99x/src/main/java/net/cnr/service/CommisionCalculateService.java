package net.cnr.service;

import org.springframework.stereotype.Service;

@Service
public interface CommisionCalculateService {

    public double calculateCommission(String recruitmentStatus);
}
