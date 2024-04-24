package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDef"}, // tempat step dmn.a
        features = {"src/test/java/Feature"},
        tags = "@api",
        monochrome = true
)
public class ApiRunner {
}
