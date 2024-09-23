import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SearchTests {
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
    void successfulVinSearch(){
        $("#navbar-search-1").click();
        $("#navbar-search-1").setValue("5TEJU62N36Z226840");
        $(".me-sm-2").click();
        $(".order-lg-last").shouldHave(text("2006 Toyota Tacoma"));

    }

    @Test
    void successfulLotNumberSearch(){
        $("#navbar-search-1").click();
        $("#navbar-search-1").setValue("38669822");
        $(".me-sm-2").pressEnter();
        $(".order-lg-last").shouldHave(text("2006 Toyota Tacoma"));
    }

    @Test
    void successfulNameCarSearch(){
        $("#navbar-search-1");
        $("#navbar-search-1").setValue("Toyota Tacoma");
        $(".me-sm-2").pressEnter();
        $("button.link").shouldHave(text("Toyota Tacoma"));
    }

    @Test
    void successSearchWithTub(){
        $("#navbar-search-1");
        $("#navbar-search-1").setValue("    5TEJU62N36Z226840   ");
        $(".me-sm-2").pressEnter();
        $(".order-lg-last").shouldHave(text("Toyota Tacoma"));
    }

    @Test
    void successSearchWithSpace(){
        $("#navbar-search-1");
        $("#navbar-search-1").setValue(" 5TEJU62N36Z226840 ");
        $(".me-sm-2").pressEnter();
        $(".order-lg-last").shouldHave(text("Toyota Tacoma"));
    }
}