import com.codeborne.selenide.Configuration;
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

    @Test
    void successfulAuth() {

        Configuration.holdBrowserOpen = true;

        $("[class=ms-2]").click();
        $("[id=user-auth-login-email]").setValue("onboarding306@gmail.com");
        $("[id=user-auth-login-password").setValue("Aw1ad2as3");
        $("[id=user-auth-login-button]").click();


    }


}
