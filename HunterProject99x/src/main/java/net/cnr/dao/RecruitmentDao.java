package net.cnr.dao;
import net.cnr.dto.HeadHunter;
import net.cnr.dto.Recruitement;

import java.util.List;

public interface RecruitmentDao {

    public List<Recruitement> list();

    public Recruitement get(int id);

    public boolean add(Recruitement recruitement);

    public Double getSumOfCommision(int headHunterId);

    Recruitement getRecruitmentByHeadHunterId(int id);

    public List<Recruitement>getListOfRecruitmentByHunterId(Integer id);
}
