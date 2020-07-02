package pl.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.project.mapper.LocalizationMapper;
import pl.project.model.IpApi;
import pl.project.model.dto.LocalizationDto;
import pl.project.model.localization.Localization;

@Service
public class LocalizationService {

    private RestTemplate restTemplate;
    private LocalizationMapper localizationMapper;
    private IpApi ipApi;

    public LocalizationService(RestTemplate restTemplate, LocalizationMapper localizationMapper, IpApi ipApi) {
        this.restTemplate = restTemplate;
        this.localizationMapper = localizationMapper;
        this.ipApi = ipApi;
    }

    public LocalizationDto getLocalization() {
        Localization local = restTemplate.getForObject(ipApi.getUrl() + ipApi.getApiKey(), Localization.class);
        return localizationMapper.map(local);
    }
}
