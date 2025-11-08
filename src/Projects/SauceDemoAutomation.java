package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\USER\\eclipse-workspace\\aiyo\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Open SauceDemo
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();
            System.out.println("✅ Opened SauceDemo website");

            // Step 2: Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("✅ Logged in successfully");

            // Step 3: Handle "Change your password" popup if present
            try {
                Thread.sleep(2000);
                WebElement okButton = driver.findElement(By.xpath("//button[text()='OK']"));
                if (okButton.isDisplayed()) {
                    okButton.click();
                    System.out.println("⚠️ Popup closed automatically");
                }
            } catch (Exception e) {
                System.out.println("ℹ️ No popup detected, continuing...");
            }

            Thread.sleep(2000);

            // Step 4: Add first two products to cart
            driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
            driver.findElement(By.xpath("(//button[text()='Add to cart'])[2]")).click();
            System.out.println("✅ Added two products to cart");

            // Step 5: Go to Cart
            driver.findElement(By.className("shopping_cart_link")).click();
            System.out.println("🛒 Opened cart page");

            Thread.sleep(2000);

            // Step 6: Proceed to Checkout
            driver.findElement(By.id("checkout")).click();
            System.out.println("✅ Clicked checkout button");

            Thread.sleep(2000);

            // Step 7: Fill checkout info
            driver.findElement(By.id("first-name")).sendKeys("Pooja");
            driver.findElement(By.id("last-name")).sendKeys("A");
            driver.findElement(By.id("postal-code")).sendKeys("600001");
            driver.findElement(By.id("continue")).click();
            System.out.println("✅ Entered checkout details");

            Thread.sleep(2000);

            // Step 8: Finish order
            driver.findElement(By.id("finish")).click();
            System.out.println("🎉 Order placed successfully!");

            Thread.sleep(2000);

            // Step 9: Back to home
            driver.findElement(By.id("back-to-products")).click();
            System.out.println("🏠 Returned to product page");

        } catch (Exception e) {
            System.out.println("❌ Error during automation: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("🚪 Browser closed");
        }
    }
}
