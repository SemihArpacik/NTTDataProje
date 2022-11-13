package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumber_rapor.html"},
        features="src/test/resources/features",
        glue="stepDefinitions",
        tags="@NTTData",
        dryRun=false

)

public class Runner {


}
