package net.cnr.controller;
import net.cnr.dao.RecruitmentDao;
import net.cnr.dto.HeadHunter;
import net.cnr.dto.Recruitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recruitments/data")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RecruitmentController {

        @Autowired
        private RecruitmentDao recruitmentDao;

        @RequestMapping("/all/recruitments")
        @ResponseBody
        public List<Recruitement> getAllRecruitments(){
        return recruitmentDao.list();
        }

        @RequestMapping("/{id}/recruitment")
        @ResponseBody
        public Recruitement getRecruitmentById(@PathVariable("id") int id){

            return recruitmentDao.get(id);
        }

        @RequestMapping(value="/add/recruitment", method= RequestMethod.POST)
        @ResponseBody
        public Boolean addRecruitment(@RequestBody Recruitement recruitement){
                System.out.println("controller skill "+recruitement.getRecruiterSkill());
                System.out.println("controller head hunter id "+recruitement.getHeadHunterId());
                System.out.println("Controller is group"+ recruitement.getIsGroupRecruitement());
            return recruitmentDao.add(recruitement);
        }

        @RequestMapping("/hunter/{id}/commision")
        @ResponseBody
        public Double getHunterSumOfComission(@PathVariable("id") int id){

            return recruitmentDao.getSumOfCommision(id);
        }

        @RequestMapping("/{id}/headhunter")
        @ResponseBody
        public Recruitement getRecruitmentByHeadHunterId(@PathVariable("id") int id){

                return recruitmentDao.getRecruitmentByHeadHunterId(id);
        }

        @RequestMapping("/recruments/hunter/{hunterId}")
        @ResponseBody
        public List<Recruitement> getListOfRecruitmentByHunterId(@PathVariable("hunterId") int hunterId){
                return recruitmentDao.getListOfRecruitmentByHunterId(hunterId);
        }


}
