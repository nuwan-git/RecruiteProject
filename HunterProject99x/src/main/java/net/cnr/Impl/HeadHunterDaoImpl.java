package net.cnr.Impl;

import net.cnr.dao.HeadHunterDao;
import net.cnr.dto.HeadHunter;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("headHunterDao")
@Transactional
public class HeadHunterDaoImpl implements HeadHunterDao {

    @Autowired
    private SessionFactory sessionfactory;

    @Override
    public List<HeadHunter> list() {
        String selectActiveCategory = "FROM HeadHunter WHERE active = :active";
        Query query = sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
        query.setParameter("active", true);
        return query.getResultList();
    }

    @Override
    public HeadHunter get(int id) {
        return sessionfactory.getCurrentSession().get(HeadHunter.class, Integer.valueOf(id));
    }

    @Override
    public boolean add(HeadHunter headHunter) {

        try {
            sessionfactory.getCurrentSession().persist(headHunter);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(HeadHunter headHunter) {
        try {
            sessionfactory.getCurrentSession().update(headHunter);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(HeadHunter headHunter) {
        headHunter.setActive(false);
        try {
            sessionfactory.getCurrentSession().update(headHunter);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
