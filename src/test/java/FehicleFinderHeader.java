import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FehicleFinderHeader {
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
        void VehicleFinderListShouldBEVisible(){
        $("#navbar-toggler-btn").click();
        $(".list-unstyled").shouldBe(Condition.visible);
    }

}
