package test;

import net.cnr.dao.HeadHunterDao;
import net.cnr.dto.HeadHunter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class HeadHunterTestCase {
    private static AnnotationConfigApplicationContext context;
    private static HeadHunterDao headHunterDao;
    private HeadHunter headHunter;

    @BeforeClass
    public static void init() {

        context = new AnnotationConfigApplicationContext();
        context.scan("net.cnr");
        context.refresh();
        headHunterDao = (HeadHunterDao) context.getBean("headHunterDao");

    }

    @Test
    public void testGetHunter(){
        headHunter = headHunterDao.get(1);
        assertEquals("successfully fetches a single head hunter from the table", "Raju", headHunter.getName());
    }

    @Test
    public void testAddCategory() {
        headHunter = new HeadHunter();
        headHunter.setName("bhanu");
        headHunter.setEmail("bhanu@gmail.com");
        headHunter.setActive(false);
        assertEquals("successfully addes a head hunter inside the table HeadHunter", true, headHunterDao.add(headHunter));
    }

    @Test
    public void testListCategory(){
        assertEquals("not successfully fetched the list of hunters from  the table", 3, headHunterDao.list().size());
    }

    @Test
	public void testUpdateCategory(){
		headHunter = headHunterDao.get(1);
        headHunter.setName("Mahesh");
		assertEquals("not successfully updated a single hunter in the table", true, headHunterDao.update(headHunter));
	}

	@Test
	public void testDeleteCategory(){
        headHunter = headHunterDao.get(1);
		assertEquals("notsuccessfully deleted a single category in the table", true, headHunterDao.delete(headHunter));
	}
}
