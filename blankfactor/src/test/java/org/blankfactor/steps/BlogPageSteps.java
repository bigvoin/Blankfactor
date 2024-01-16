package org.blankfactor.steps;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.blankfactor.pages.BlogPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlogPageSteps {

  private static final BlogPage BLOG_PAGE = new BlogPage();

  private static final Logger LOGGER = LoggerFactory.getLogger(BlogPageSteps.class);

  private static final String ARTICLE_URL = "https://blankfactor.com/insights/blog/fintech-in-latin-america/";

  @Step("Scroll down to article: {articleName}")
  public BlogPageSteps scrollDownToArticle(String articleName) {
    while(!BLOG_PAGE.scrollArticles().last().getText().equals("The Angular vs React vs Vue Debate: Which One Is Better?")) {
      BLOG_PAGE.scrollArticles().last().scrollIntoView(true);
      Selenide.executeJavaScript("window.scrollBy(0, -100)");
    }


    SelenideElement expectedArticle = BLOG_PAGE.scrollArticles().filter(exactText(articleName)).first();
    expectedArticle.scrollIntoView(true);
    expectedArticle.parent().$(".btn-permalink").click();

    return this;
  }

  @Step("Verify Correct Page is opened")
  public BlogPageSteps verifyCorrectPageIsOpened() {
    String authorName = "Sofia Gonzalez";
    String postTitle = "Why fintech in Latin America is booming";
    String postDate = "August 13, 2021";

    Selenide.Wait().until(ExpectedConditions.urlToBe(ARTICLE_URL));
    BLOG_PAGE.authorName().shouldHave(text(authorName));
    BLOG_PAGE.postTitle().shouldHave(text(postTitle));
    BLOG_PAGE.postDate().shouldHave(text(postDate));
    BLOG_PAGE.postThumbnail().shouldBe(visible);

    return this;
  }

  @Step("Enter Email: {emailAddress} in newsletter field")
  public BlogPageSteps enterEmailInNewsletterField(String emailAddress) {
    BLOG_PAGE.emailField().shouldBe(visible);
    BLOG_PAGE.emailField().setValue(emailAddress);

    return this;
  }

  @Step("Click Subscribe button")
  public BlogPageSteps clickSubscribeButton() {
    BLOG_PAGE.subscribeButton().shouldBe(visible);
    BLOG_PAGE.subscribeButton().scrollTo().click();

    return this;
  }

  @Step("Verify Successful message is received in the newsletter")
  public BlogPageSteps verifySuccessfulMessageIsReceived() {
    BLOG_PAGE.newsletterContainer().shouldHave(text("Thank you for subscribing! Stay tuned."));

    return this;
  }

  @Step("Go back to last page")
  public BlogPageSteps goBack() {
    Selenide.back();
    return this;
  }

  @Step("Print all blog articles headings and links")
  public void printAllBlogArticlesHeadingsAndLinks() {
    Selenide.refresh();

    BLOG_PAGE.articles().forEach(article -> {
      String headingText = article.$("h2").getText();
      String linkHref = article.$("a").getAttribute("href");

      LOGGER.info("Heading: {}", headingText);
      LOGGER.info("Link Href: {}", linkHref);
    });
  }
}
