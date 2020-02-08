package resume.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import resume.entity.Profile;

public interface ProfileSearchRepository  extends ElasticsearchRepository<Profile, Long> {

    /**
     *
     * http://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.query-methods.criterions
     */
    Page<Profile> findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
            String objective, String summary, String practicCompany, String practicPosition, Pageable pageable);
}
