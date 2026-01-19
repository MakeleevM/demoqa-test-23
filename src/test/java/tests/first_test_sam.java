package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class first_test_sam {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = null;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Selenide.open("https://demoqa.com");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        //Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maksat");
        $("#lastName").setValue("Makeleev");
        $("#userEmail").setValue("msmakeleev@ma.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("5678765423");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1903");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("Civics").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#currentAddress").setValue("Bla-bla-bla-bla-bla");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(text("Maksat Makeleev"));
        $(".table-responsive").shouldHave(text("msmakeleev@ma.ru"));
        $(".table-responsive").shouldHave(text("Other"));
        $(".table-responsive").shouldHave(text("5678765423"));
        $(".table-responsive").shouldHave(text("27 March,1903"));
        $(".table-responsive").shouldHave(text("Hindi, Civics, Maths"));
        $(".table-responsive").shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").shouldHave(text("msmakeleev@ma.ru"));
        $(".table-responsive").shouldHave(text("Bla-bla-bla-bla-bla"));
        $(".table-responsive").shouldHave(text("NCR Gurgaon"));

        $("#closeLargeModal").click();

        //Selenide.refresh();
        //Selenide.clearBrowserCookies();
        //Selenide.clearBrowserLocalStorage();




    }
}