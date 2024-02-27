package assignments;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class assignment_2 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://demo.playwright.dev/todomvc/");
      page.navigate("https://demo.playwright.dev/todomvc/#/");
      page.getByPlaceholder("What needs to be done?").click();
      page.getByPlaceholder("What needs to be done?").fill("test");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.getByPlaceholder("What needs to be done?").fill("rest");
      page.getByPlaceholder("What needs to be done?").press("Enter");
      page.locator("li").filter(new Locator.FilterOptions().setHasText("test")).getByLabel("Toggle Todo").check();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Clear completed")).click();
      System.out.println("done");
    
    }
  }
}