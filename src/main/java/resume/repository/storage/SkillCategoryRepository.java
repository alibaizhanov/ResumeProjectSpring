package resume.repository.storage;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import resume.entity.SkillCategory;
import java.util.List;

public interface SkillCategoryRepository extends PagingAndSortingRepository<SkillCategory,Long> {

    @Override
    List<SkillCategory> findAll();
}
