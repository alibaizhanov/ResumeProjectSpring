package resume.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resume.form.SkillForm;
import resume.repository.storage.ProfileRepository;
import resume.repository.storage.SkillCategoryRepository2;

import resume.repository.storage.ProfileRepository;

@Controller
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository2 skillCategoryRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String getEditProfile(){
        return "edit";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getEditTechSkills(Model model) {
        model.addAttribute("skillForm", new SkillForm(profileRepository.findById(1L).get().getSkills()));
        return gotoSkillsJSP(model);
    }


    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveEditTechSkills(@ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return gotoSkillsJSP(model);
        }
        //TODO Update skills
        return "redirect:/mike-ross";
    }

    private String gotoSkillsJSP(Model model){
        model.addAttribute("skillCategories", skillCategoryRepository.findAll());
        return "edit/skills";
    }
}
