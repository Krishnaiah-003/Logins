import java.io.File;
import java.io.FileInputStream;

public class CivilSuppliesLoginPage {
    WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://192.168.20.251/civilsupplytesting/");
		Thread.sleep(1000);
		driver.findElement(By.id("details-button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("proceed-link")).click();
	}
	@Test
	public void Login() throws Exception {

		FileInputStream file = new FileInputStream("");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("");
		DataFormatter formatter = new DataFormatter();
		int rowcount = sheet.getLastRowNum();

		for(int i=1; i<=rowcount;i++) {

			XSSFRow currentrow = sheet.getRow(i);
			String userName = formatter.formatCellValue(currentrow.getCell(0));
			String password = formatter.formatCellValue(currentrow.getCell(1));

			driver.findElement(By.id("email")).sendKeys(userName);
			Thread.sleep(1000);
			driver.findElement(By.id("password")).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String screenShotFileName = "./Screenshots/AdminLogin"+ i+".jpg";
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(screenShotFileName);
		FileUtils.copyDirectory(sourceFile, destinationFile);
		System.out.println("Screenshot saved Successfully"+screenShotFileName);
						
		}
		workbook.close();
	}
	@AfterTest
	public void TearDown() {

		driver.quit();
	}

    
}