import com.eviro.assessment.grad001.sicelo_ntombana.Application;
import com.eviro.assessment.grad001.sicelo_ntombana.config.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@TestPropertySource("classpath:data-test.properties")
public class DataPropertiesIntegrationTest {

    @Autowired
    @Qualifier("datasource")
    private Data data;

    @Test
    public void testDatabaseProperties() {
        Assert.assertNotNull(data);
        Assert.assertEquals("myfile", data.getFile());
        Assert.assertEquals("mydir", data.getDir());
    }
}