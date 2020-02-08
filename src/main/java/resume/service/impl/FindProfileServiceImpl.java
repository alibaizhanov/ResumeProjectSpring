package resume.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import resume.entity.Profile;
import resume.repository.storage.ProfileRepository;
import resume.service.FindProfileService;

import resume.repository.search.ProfileSearchRepository;

@Service
public class FindProfileServiceImpl implements FindProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Override
    public Profile findByUid(String uid) {
        return profileRepository.findByUid(uid);
    }

    @Override
    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }


    @Override
    @Transactional
    public Iterable<Profile> findAllForIndexing() {
        Iterable<Profile> all = profileRepository.findAll();
        for(Profile p : all) {
            p.getSkills().size();
            p.getCertificates().size();
            p.getLanguages().size();
            p.getPractics().size();
            p.getCourses().size();
        }
        return all;
    }

    @Override
    public Page<Profile> findBySearchQuery(String query, Pageable pageable) {
        return profileSearchRepository.findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
                query, query, query, query, pageable);
    }
}
