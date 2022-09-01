package ua.kiev.prog.retrievers;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.kiev.prog.json.Rate;

@Component
public class RateRetriever {

    private static final String URL = "https://api.apilayer.com/fixer/latest?apikey=yTXhniTSsxClYH4Ah3VXABXTHbtVafrf";
    //http://data.fixer.io/api/latest?access_key=30e7ff0de73cf99ac8842101abce80ca

    @Cacheable("rates")
    public Rate getRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.getForEntity(URL, Rate.class);
        return response.getBody();
    }
}
