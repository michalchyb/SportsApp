package pl.project.weather.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.project.model.IpApi;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpApiTest {

    @Autowired
    private IpApi ipApi;

    @Test
    public void test_get_value_from_application_properties() {
        String url = ipApi.getUrl();
        Assert.assertEquals("http://api.ipstack.com/check?access_key=", url);
    }
}