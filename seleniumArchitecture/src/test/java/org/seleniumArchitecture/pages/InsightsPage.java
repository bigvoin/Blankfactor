package org.seleniumArchitecture.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

/**
 * Insights page with representation of all page elements into Selenide Elements
 */
public class InsightsPage {
  public SelenideElement blogPageItem() { return $(".page-item__info").$(Selectors.byText("Blog"));}

}
