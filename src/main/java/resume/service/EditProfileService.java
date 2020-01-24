package resume.service;



import java.util.List;

import resume.entity.Profile;
import resume.entity.Skill;
import resume.entity.SkillCategory;
import resume.form.SignUpForm;

/**
 *
 */
public interface EditProfileService {

    Profile createNewProfile(SignUpForm signUpForm);

    List<Skill> listSkills(long idProfile);

    List<SkillCategory> listSkillCategories();

    void updateSkills(long idProfile, List<Skill> skills);
}