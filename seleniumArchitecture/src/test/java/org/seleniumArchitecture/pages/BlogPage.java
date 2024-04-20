package org.seleniumArchitecture.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * Blog page with representation of all page elements into Selenide Elements
 */
public class BlogPage {
  public ElementsCollection articles() { return postList().$$("article");}

  public ElementsCollection scrollArticles() { return $$(".post-title");}

  public SelenideElement postList() { return $(".posts-list");}

  public SelenideElement authorName() { return $(".author-name");}

  public SelenideElement postTitle() { return $(".post-title");}

  public SelenideElement postDate() { return $(".post-date");}

  public SelenideElement postThumbnail() { return $(".post-thumbnail");}

  public SelenideElement emailField() { return $(".form-newsletter__fields").$("input");}

  public SelenideElement subscribeButton() { return $("#form-newsletter-blog-submit-btn");}

  public SelenideElement newsletterContainer() { return $(".widget-newsletter");}

  public ElementsCollection blogPageList() { return $$("article");}
 }
