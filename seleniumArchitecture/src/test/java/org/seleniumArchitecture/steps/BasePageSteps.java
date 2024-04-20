package org.seleniumArchitecture.steps;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.seleniumArchitecture.pages.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Steps for Base Page that represents methods
 */
public class BasePageSteps {

  private static final String BASE_URL = "https://blankfactor.com/";

  private static final String INSIGHTS_URL = "https://blankfactor.com/insights/";

  private static final BasePage BASE_PAGE = new BasePage();

  @Step("Open BlankFactor Website")
  public void openBlankFactorWebsite() {
    open(BASE_URL);
    Selenide.Wait().until(ExpectedConditions.urlToBe(BASE_URL));
    // Check if the "Accept" cookies button is present
    if ($("[id='hs-eu-confirmation-button']").exists()) {
      // Click the "Accept" button
      $("[id='hs-eu-confirmation-button']").click();
    }
    waitPageContentToBeLoaded();
  }

  @Step("Click Insights option from navigation menu")
  public BasePageSteps clickInsightsOption() {
    BASE_PAGE.insightsOption().click();

    return this;
  }

  @Step("Verify Insights is opened")
  public void verifyInsightsIsOpened() {
    Selenide.Wait().until(ExpectedConditions.urlToBe(INSIGHTS_URL));

  }

  public void waitPageContentToBeLoaded() {
    BASE_PAGE.letsTalkButton().shouldBe(visible);
    BASE_PAGE.navigationBar().shouldBe(visible);
    BASE_PAGE.heroSlider().shouldBe(visible);
  }

  public static void configBrowserOptions() {
    Configuration.browser = "firefox";
    WebDriverManager.chromedriver().setup();
  }
}
