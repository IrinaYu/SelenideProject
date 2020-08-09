import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

@Listeners ({ SoftAsserts.class})

public class SampleSelenideTest {

  @BeforeMethod
  public void setUp(){
    Configuration.browser = "chrome";
  }


  @Test
  public void loginTest(){
    open("https://jira.hillel.it/secure/Dashboard.jspa");
    $(By.id("login-form-username")).setValue("webinar5");
    $(By.id("login-form-password")).setValue("webinar5");
    $("#login").click();
    Configuration.assertionMode = AssertionMode.STRICT;
    $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);
    //Configuration.assertionMode = Configuration.assertionMode.SOFT;
  }
}