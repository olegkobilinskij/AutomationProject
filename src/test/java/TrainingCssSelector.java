import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TrainingCssSelector {
    @BeforeEach
    void beforeEach() {
        String username = "cfw2";
        String password = "AoiMa-47is";
        String url = "https://" + username + ":" + password + "@stage.carsfromwest.com";
        open(url);
    }

    @AfterEach
    void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    void findSimilarButton() {
        $("#home-register-area").scrollTo();
        $("#home-register-email").setValue("onboarding@gmail.com");
        $("#home-register-password").setValue("Aw1ad2as3");
        $("#home-register-button").click();
        $("#home-register-email-error").shouldHave(Condition.text("User with this email already registered."));
    }

}
