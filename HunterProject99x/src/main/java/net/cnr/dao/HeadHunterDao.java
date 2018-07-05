package net.cnr.dao;
import net.cnr.dto.HeadHunter;
import java.util.List;

public interface HeadHunterDao {

    List<HeadHunter> list();

    HeadHunter get(int id);

    boolean add(HeadHunter headHunter);

    boolean update(HeadHunter headHunter);

    boolean delete(HeadHunter headHunter);
}
