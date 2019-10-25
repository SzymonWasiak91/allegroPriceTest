import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class allegro {
    @Test
    public void allegroTest(){
        String driverPath = "C:\\Users\\wasia\\IdeaProjects\\sleniumtest\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://allegro.pl");
        WebElement input = driver.findElement(By.xpath("//input[@type='search']"));
        input.sendKeys("Iphone 8");
        input.submit();
        System.out.println(driver.findElements(By.xpath("//section[@class='_5a7713f']/article")).size());

        List<WebElement> elements = driver.findElements(By.className("fee8042"));

        float Max = Float.parseFloat(elements.get(0).getAttribute("textContent").substring(0,elements.get(0).getAttribute("textContent").length()-3).replaceAll(",",".").replaceAll(" ",""));
        for (WebElement element : elements){
            System.out.println(element.getAttribute("textContent"));//wyciąga ceny
            String x = element.getAttribute("textContent");//przypisanie do zmiennej do str
            x = x.substring(0,x.length()-3);//usuwamy trzy ostanie znaki stringa
            x = x.replaceAll(",",".");//zmieniamy przecinki na kropki
            x = x.replaceAll(" ","");//usuwanie spacji


            if(Max < Float.parseFloat(x)){
                Max = Float.parseFloat(x);

            }
        }
        System.out.println("Największa znaleziona cena to:  "+  Max);
        System.out.println("Maxymalna cena + 20% wynosi:   "+ Max * 1.20);



    }
}
