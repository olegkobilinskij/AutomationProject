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




public class LoginFormTests {

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
        void successForgotYourPass() {

            $(".ms-2").click();
            $("#user-auth-login-caller-reset").click();
            $("#user-auth-reset-email").setValue("onboarding24@gmail.com");
            $("#user-auth-reset-button").click();

            $("#user-auth-reset-area").shouldBe(Condition.visible);

            $("#user-auth-reset-success-caller-login").click();
            $("#user-auth-login-area").shouldBe(Condition.visible);
    }

    @Test
        void forgotYourPassBackToSignin(){
            $(".ms-2").click();
            $("#user-auth-login-caller-reset").click();
            $("#user-auth-reset-caller-login").click();

            $("#user-auth-login-area").shouldBe(Condition.visible);


    }
    @Test
        void goToRegForm(){
            $(".ms-2").click();
            $("#user-auth-login-area").shouldBe(Condition.visible);
            $("#user-auth-login-caller-register").click();
            $("#user-auth-register-area").shouldBe(Condition.visible);
    }

    @Test
        void clickOnTheX(){
            $(".ms-2").click();
            $("#user-auth-login-area").shouldBe(Condition.visible);
            $(".btn-close").click();
            $("#user-auth-login-area").shouldNotBe(Condition.visible);
    }
}
































