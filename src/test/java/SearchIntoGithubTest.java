import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.nio.file.Files.find;

public class SearchIntoGithubTest {

    @Test
    void searchIntoSoftAssertions() {

        // открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        // перейти в раздел Wiki
        $("#wiki-tab").click();

        // проверить наличие страницы SoftAssertions в списке страниц
        $("#wiki-body").shouldHave(text("Soft assertions"));

        // открыть страницу SoftAssertions
        $("#wiki-body").$(byText("Soft assertions")).click();

        // проверить наличие кода для JUnit5
        $$(".markdown-heading .heading-element")
                .findBy(text("3. Using JUnit5 extend test class:"))
                .parent()
                .sibling(0)
                .shouldHave(text(
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                                "class Tests {\n" +
                                "  @Test\n" +
                                "  void test() {\n" +
                                "    Configuration.assertionMode = SOFT;\n" +
                                "    open(\"page.html\");\n" +
                                "    \n" +
                                "    $(\"#first\").should(visible).click();\n" +
                                "    $(\"#second\").should(visible).click();\n" +
                                "  }\n" +
                                "}"
                ));




    }

}
