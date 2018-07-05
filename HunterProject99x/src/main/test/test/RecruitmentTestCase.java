package test;

import net.cnr.dao.HeadHunterDao;
import net.cnr.dao.RecruitmentDao;
import net.cnr.dto.HeadHunter;
import net.cnr.dto.Recruitement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class RecruitmentTestCase {

    private static AnnotationConfigApplicationContext context;
    private Recruitement recruitement;
    private static RecruitmentDao recruitmentDao;

    @BeforeClass
    public static void init() {

        context = new AnnotationConfigApplicationContext();
        context.scan("net.cnr");
        context.refresh();
        recruitmentDao = (RecruitmentDao) context.getBean("recruitmentDao");

    }

    @Test
    public void testGetRecruitment(){
        recruitement = recruitmentDao.get(1);
        assertEquals("successfully fetches a single recruitment  from the table", "masson", recruitement.getRecruiterSkill());
    }

    @Test
    public void testGetRecruitmentByHeadHunterId(){
        recruitement = recruitmentDao.getRecruitmentByHeadHunterId(3);
        assertEquals("successfully fetches a single recruitment  from the table", "333", recruitement.getCommission());
    }

    @Test
    public void testAddRecruitment() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        recruitement = new Recruitement();
       // recruitement.setCommission(33000.00);
        recruitement.setIsGroupRecruitement("true");
        recruitement.setHeadHunterId(2);
        recruitement.setRecruiterSkill("machine operator");
   //     recruitement.setReccruitedDate(date);

        assertEquals("successfully addes a recruitment inside the table Recruitment", true, recruitmentDao.add(recruitement));
    }

    @Test
    public void testListRecruitment(){
        assertEquals("not successfully fetched the list of recruiment from  the table", 3, recruitmentDao.list().size());
    }
}
