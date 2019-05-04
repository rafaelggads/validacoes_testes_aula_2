package alfa.br.com.rafaelgonzagag;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 *

* @author Rafaelgonzagag
 */
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty", "html:reports/test.report"}
    // ,tags="@moskeTest"
    ,glue={"rafaelgonzagag"}
    ,features={"src/test/resources/avaliacao.feature"}
)
public class CucumberRunner {
    
}
