import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginTests {


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
    void successfulAuthEmaiPass() {

        $("[class=ms-2]").click();
        $("[id=user-auth-login-email]").setValue("onboarding306@gmail.com");
        $("[id=user-auth-login-password").setValue("Aw1ad2as3");
        $("[id=user-auth-login-button]").click();

        $("[id=header-deposit-bid]").shouldBe(Condition.visible);
    }

    @Test
    void loginWithoutPass() {

        $("[class=ms-2]").click();
        $("[id=user-auth-login-email]").setValue("onboarding306@gmail.com");
        $("[id=user-auth-login-password").setValue("");
        $("[id=user-auth-login-button]").click();

        $("[id=user-auth-login-password-error]").shouldHave(Condition.text("Please fill your password."));
    }

    @Test
    void loginWithoutEmail() {

        $("[class=ms-2]").click();
        $("[id=user-auth-login-email]").setValue("");
        $("[id=user-auth-login-password").setValue("Aw1ad2as3");
        $("[id=user-auth-login-button]").click();

        $("[id=user-auth-login-email-error]").shouldHave(Condition.text("Please fill your email."));
    }

    @Test
    void loginWithEmptyFields() {

        $("[class=ms-2]").click();
        $("[id=user-auth-login-email]").setValue("");
        $("[id=user-auth-login-password").setValue("");
        $("[id=user-auth-login-button]").click();

        $("[id=user-auth-login-email-error]").shouldHave(Condition.text("Please fill your email."));
        $("[id=user-auth-login-password-error]").shouldHave(Condition.text("Please fill your password."));
    }
}
