import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_WebdriverClass {
 
    public static void main(String[] args) throws IOException {
        // declaration and instantiation of objects/variables
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "https://www.facebook.com/";
         // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        WebElement wbelm=driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div/div/div/div[1]/div/img"));
        
        //take screen print
        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullimg = ImageIO.read(screenshot);
        
        //location of object
        Point pt = wbelm.getLocation();
        Dimension dim =  wbelm.getSize();
        BufferedImage objimg = fullimg.getSubimage(pt.x, pt.y, dim.width, dim.height);
        ImageIO.write(objimg, "jpeg", screenshot);
        FileUtils.copyFile(screenshot, new File("D:\\facebook.jpeg"));
        
        
        //close Firefox
        driver.close();
        
        // exit the program explicitly
        System.exit(0);
    }
 
}