package stepdefinitions;

import com.propio.pruebas.PruebasApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefinitions"})
@CucumberContextConfiguration
@SpringBootTest(classes = {PruebasApplication.class, PruebasCucumberTest.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PruebasCucumberTest {
}
