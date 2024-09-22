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

        $(".ms-2").click();
        $("#user-auth-login-email").setValue("onboarding306@gmail.com");
        $("#user-auth-login-password").setValue("Aw1ad2as3");
        $("#user-auth-login-button").click();

        $("#header-deposit-bid").shouldBe(Condition.visible);
    }

    @Test
    void loginWithoutPass() {

        $(".ms-2").click();
        $("#user-auth-login-email").setValue("onboarding306@gmail.com");
        $("#user-auth-login-password").setValue("");
        $("#user-auth-login-button").click();

        $("#user-auth-login-password-error").shouldHave(Condition.text("Please fill your password."));
    }

    @Test
    void loginWithoutEmail() {

        $(".ms-2").click();
        $("#user-auth-login-email").setValue("");
        $("#user-auth-login-password").setValue("Aw1ad2as3");
        $("#user-auth-login-button").click();

        $("#user-auth-login-email-error").shouldHave(Condition.text("Please fill your email."));
    }

    @Test
    void loginWithEmptyFields() {

        $(".ms-2").click();
        $("#user-auth-login-email").setValue("");
        $("#user-auth-login-password").setValue("");
        $("#user-auth-login-button").click();

        $("#user-auth-login-email-error").shouldHave(Condition.text("Please fill your email."));
        $("#user-auth-login-password-error").shouldHave(Condition.text("Please fill your password."));
    }

    @Test
    void loginEmailAndWrongPass() {

        $(".ms-2").click();
        $("#user-auth-login-email").setValue("onboarding306@gmail.com");
        $("#user-auth-login-password").setValue("2456gftdhE__::");
        $("#user-auth-login-button").click();

        $("#user-auth-login-password-error").shouldHave(Condition.text("Incorrect email or password."));
    }
}
