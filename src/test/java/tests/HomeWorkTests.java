package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTests {

    @BeforeAll
    static void configureBrowser() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Petrov");
        $("#userEmail").setValue("pp@vv.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("4575687697");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--027").click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("123.png");
        $("#currentAddress").setValue("Russia, MO, Lyubertsy, 125,521").pressEnter();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $x("//td[contains(text(),'Student Name')]/../td[2]").shouldHave(text("Petr Petrov"));
        $x("//td[contains(text(),'Student Email')]/../td[2]").shouldHave(text("pp@vv.ru"));
        $x("//td[contains(text(),'Gender')]/../td[2]").shouldHave(text("Male"));
        $x("//td[contains(text(),'Mobile')]/../td[2]").shouldHave(text("4575687697"));
        $x("//td[contains(text(),'Date of Birth')]/../td[2]").shouldHave(text("27 March,1998"));
        $x("//td[contains(text(),'Subjects')]/../td[2]").shouldHave(text("Hindi, English, Maths, Physics"));
        $x("//td[contains(text(),'Hobbies')]/../td[2]").shouldHave(text("Sports, Reading, Music"));
        $x("//td[contains(text(),'Picture')]/../td[2]").shouldHave(text("123.png"));
        $x("//td[contains(text(),'Address')]/../td[2]").shouldHave(text("Russia, MO, Lyubertsy, 125,521"));
        $x("//td[contains(text(),'State and City')]/../td[2]").shouldHave(text("NCR Delhi"));

    }
}