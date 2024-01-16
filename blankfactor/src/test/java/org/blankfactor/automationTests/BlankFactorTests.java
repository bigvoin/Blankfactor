package org.blankfactor.automationTests;

import io.qameta.allure.junit4.DisplayName;
import org.blankfactor.steps.BasePageSteps;
import org.blankfactor.steps.BlogPageSteps;
import org.blankfactor.steps.InsightsPageSteps;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlankFactorTests {

  private static final BasePageSteps BASE_PAGE_STEPS = new BasePageSteps();

  private static final InsightsPageSteps INSIGHTS_PAGE_STEPS = new InsightsPageSteps();

  private static final BlogPageSteps BLOG_PAGE_STEPS = new BlogPageSteps();

  @BeforeClass
  public static void setUp() {
    BasePageSteps.configBrowserOptions();
  }

  @Before
  public void beforeEachTest() {
    BASE_PAGE_STEPS.openBlankFactorWebsite();
  }

  @Test
  @DisplayName("Automation test: navigating to blankfactor, Open Insights menu and selecting Blog option"
      + "Scrolling down to article with name {articleName} and opening it"
      + "Validating the correct page is opened"
      + "Subscribing to the newsletter using the form"
      + "Navigating back to Blog section and listing all visible posts titles and their links")
  public void automationTask() {
    String articleName = "Why Fintech in Latin America Is Booming";
    String testEmailData = "test@gmail.com";

    BASE_PAGE_STEPS
        .clickInsightsOption()
        .verifyInsightsIsOpened();

    INSIGHTS_PAGE_STEPS
        .clickBlogPageItem()
        .verifyBlogPageIsOpened();

    BLOG_PAGE_STEPS
        .scrollDownToArticle(articleName)
        .verifyCorrectPageIsOpened()
        .enterEmailInNewsletterField(testEmailData)
        .clickSubscribeButton()
        .verifySuccessfulMessageIsReceived()
        .goBack()
        .printAllBlogArticlesHeadingsAndLinks();
  }

}
