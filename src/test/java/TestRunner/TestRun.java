package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features="Feature",
		glue= {"Cucu_Implements"},
		monochrome=true,
		plugin= {"pretty","html:target/HtmlReports"}
		)

public class TestRun {
	

	
}
