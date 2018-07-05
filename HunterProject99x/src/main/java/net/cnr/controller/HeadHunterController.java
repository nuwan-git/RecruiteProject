package net.cnr.controller;

import net.cnr.dao.HeadHunterDao;
import net.cnr.dto.HeadHunter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/head-hunter/data")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HeadHunterController {

    @Autowired
    private HeadHunterDao headHunterDao;

    @RequestMapping("/all/hunters")
    @ResponseBody
    public List<HeadHunter> getAllActiveHunters(){
        return headHunterDao.list();
    }

    @RequestMapping("/{id}/hunter")
    @ResponseBody
    public HeadHunter getHuterById(@PathVariable int id){

        return headHunterDao.get(id);
    }

    @RequestMapping(value = "/add/hunter", method = RequestMethod.POST)
    @ResponseBody
    public Boolean createHunter(@RequestBody HeadHunter headHunter){
        return headHunterDao.add(headHunter);
    }

    @RequestMapping(value = "/update/hunter", method = RequestMethod.PUT)
    @ResponseBody
    public Boolean updateHunter(@RequestBody  HeadHunter headHunter){
        return headHunterDao.update(headHunter);
    }

    @RequestMapping(value="/delete/hunter", method = RequestMethod.PUT)
    @ResponseBody
    public Boolean deleteHeadHunter(HeadHunter headHunter){

        return headHunterDao.delete(headHunter);
    }




}
