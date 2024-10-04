import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void successfulAuthEmaiPass() {

        $(".ms-2").click();
        sleep(2000);
        $("#user-auth-login-email").setValue("onboarding306@gmail.com");
        sleep(2000);
        $("#user-auth-login-password").setValue("Aw1ad2as3");
        sleep(2000);
        $("#user-auth-login-button").click();
        sleep(2000);
        $("#header-deposit-bid").click();
        SelenideElement item = $$("ul.list-unstyled.dropdown-list li a").get(0);
        executeJavaScript("arguments[0].click();", item);
        assertEquals(WebDriverRunner.url(),"https://cfw2:AoiMa-47is@stage.carsfromwest.com/en/profile");
        sleep(5000);
        $$("div.list-group.list-group-flush ul.aside-list li").get(5).click();
        sleep(5000);
        $("a.btn.btn-primary.mobile-full-width").click();
        sleep(5000);
        assertNotEquals(WebDriverRunner.url(),"https://stage.carsfromwest.com/en/search?auctions=copart,iaai&onlyActive=true&buyNowAvailable=1");
        sleep(5000);
        $("[data-ae-type='buy-now-place-click']").click();
        sleep(5000);

    }






}
