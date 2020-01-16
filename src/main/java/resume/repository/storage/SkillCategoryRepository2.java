package resume.repository.storage;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import resume.entity.SkillCategory;

public interface SkillCategoryRepository2 extends PagingAndSortingRepository<SkillCategory,Long> {

    @Override
    Iterable<SkillCategory> findAll(Sort sort);
}
