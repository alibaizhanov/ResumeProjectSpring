package resume.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import resume.entity.Profile;

/**
 *
 * @author devstudy
 */
public interface FindProfileService {

    Profile findByUid(String uid);
    public Page<Profile> findAll(Pageable pageable);
}
