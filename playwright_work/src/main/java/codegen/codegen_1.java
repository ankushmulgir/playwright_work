package codegen;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

//debug 
public class codegen_1 {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.google.com/finance/?hl=en");
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search for stocks, ETFs & more")).click();
      page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Search for stocks, ETFs & more")).fill("tata");
      page.pause(); // to debug 
      page.locator("#nngdp1551").getByText("Tata Motors Ltd Fully Paid").click();
      page.getByText("Tata Consumer Products Ltd₹1,181.00TATACONSUM0.33%").click();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tata Motors Ltd Fully Paid"))).isVisible();
      assertThat(page.getByRole(AriaRole.MAIN)).containsText("₹962.55");
      page.getByRole(AriaRole.TAB, new Page.GetByRoleOptions().setName("Currencies")).click();
    }
  }
}
