package net.cnr.Impl;

import net.cnr.dao.RecruitmentDao;
import net.cnr.dto.Recruitement;
import net.cnr.service.CommisionCalculateService;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("recruitmentDao")
@Transactional
public class RecruitmentDaoImpl implements RecruitmentDao {

    @Autowired
    private SessionFactory sessionfactory;

    @Autowired
    private CommisionCalculateService commisionCalculateService;

    @Override
    public List<Recruitement> list() {
        String selectRecruitments = "FROM Recruitement";
        Query query = sessionfactory.getCurrentSession().createQuery(selectRecruitments);
        return query.getResultList();
    }

    @Override
    public List<Recruitement> getListOfRecruitmentByHunterId(Integer hunterId) {
        String selectRecruitments = "FROM Recruitement r WHERE r.headHunterId =:hunterId";
        List<Recruitement> recruitements;

        return (sessionfactory
                .getCurrentSession()
                .createQuery(selectRecruitments, Recruitement.class)
                .setParameter("hunterId", hunterId)
                .getResultList());
    }


    @Override
    public Recruitement get(int id) {
        return sessionfactory.getCurrentSession().get(Recruitement.class, Integer.valueOf(id));
    }

    @Override
    public boolean add(Recruitement recruitement) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        //   recruitement.setCommission(commisionCalculateService.calculateCommission(recruitement.isGroupRecruitement()));

        recruitement.setReccruitedDate(date);
        System.out.println("is group " + recruitement.getIsGroupRecruitement());
        recruitement.setCommission(commisionCalculateService.
                calculateCommission(recruitement.getIsGroupRecruitement()));
        try {
            sessionfactory.getCurrentSession().persist(recruitement);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Double getSumOfCommision(int headHunterId) {
        String countOfCommision = "FROM Recruitement r WHERE r.headHunterId =:headHunterId";
        List<Recruitement> recruitement;
        Double comission = 0.0;
        recruitement = sessionfactory
                .getCurrentSession()
                .createQuery(countOfCommision, Recruitement.class)
                .setParameter("headHunterId", headHunterId)
                .getResultList();

        for (Recruitement rec : recruitement) {
            comission += rec.getCommission();
        }

        return comission;

    }

    @Override
    public Recruitement getRecruitmentByHeadHunterId(int headHunterId) {
        String rec = "FROM Recruitement r WHERE r.headHunterId =:headHunterId";
        Recruitement recruitement;
        recruitement = sessionfactory
                .getCurrentSession()
                .createQuery(rec, Recruitement.class)
                .setParameter("headHunterId", headHunterId)
                .getSingleResult();

        return recruitement;

    }


}
