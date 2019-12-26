package resume.service.impl;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.stereotype.Service;
import resume.service.NameService;

@Service
public class NameServiceImpl implements NameService {

    @Override
    public String convertName(String name) {

        if(name.contains("-")){
            String[] parts = name.split("-");

            return parts[0].toUpperCase()+ "" + parts[1].toUpperCase();
        }

        return name.toUpperCase();
    }
}