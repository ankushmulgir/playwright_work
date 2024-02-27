package codegen;

/*
 * mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen --viewport-size=800,600 playwright.dev "
 */


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class set_view_port_size {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext(new Browser.NewContextOptions()
        .setViewportSize(1000, 800));
      Page page = context.newPage();
      page.navigate("https://playwright.dev/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get started")).click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Trace viewer")).first().click();
      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("How to record a trace"))).isVisible();
      assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recording a Trace").setExact(true))).isVisible();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recording a Trace").setExact(true)).click();
      assertThat(page.getByLabel("Docs sidebar")).containsText("Canary releases");
    }
  }
}