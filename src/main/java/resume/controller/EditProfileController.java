package resume.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import resume.repository.storage.SkillCategoryRepository2;

@Controller
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository2 skillCategoryRepository;

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String getEdit(){

        return "edit";

    }

    @RequestMapping(value = "/edit/skills",method = RequestMethod.GET)
    public String getEditSkills(Model model){

        model.addAttribute("skillCategories",skillCategoryRepository.findAll(new Sort("id")));
        return "edit-skills";
    }
}
