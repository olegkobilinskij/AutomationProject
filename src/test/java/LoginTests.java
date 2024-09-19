import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginTests {
    @Test
    void successfulAuth() {

        Configuration.holdBrowserOpen = true;
//        Configuration.browser = "firefox";

        open("https://carsfromwest.com/");
        $("[class=ms-2]").click();
        $("[id=user-auth-login-google]").click();

    }


}
