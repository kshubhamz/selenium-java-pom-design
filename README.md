
# SELENIUM-JAVA POM-FRAMEWORK DESIGN

A Test-script framework design for testing Web UI using Selenium with java.
## Configuration Variables

All Configuration Variables must be defined using properties file named run.properties in the root folder of the project.

Drivers must be present in Driver folder in the root of the project.

Required variables are listed below - 
- APP_NAME
- INCOGNITO_MODE
- HEADLESS
- GENERATE_HTML_REPORT
- AUTHOR

*For more details on these variables, refer dummy run.properties file created.*

## Usage Example

When creating any Page-Object, expect an instance of TestBase inside constructor of Page-Object. All base instances will be available on this TestBase instance and extract all of them as in below line of code - 

```
class Page1 {
    private WebDriver driver;
    private TestBase testBase;
    private Logger logger;
    private Log log;
    private Waits waits;
    private Commons commons;
    private ActionHelper actionHelper;

    Page1(TestBase t) {
        this.testBase = t;
        this.driver = (WebDriver) t.testObj.get(TestObj.DRIVER);
		this.commons = (Commons) t.testObj.get(TestObj.COMMONS);
		this.waits = (Waits) t.testObj.get(TestObj.WAITS);
		this.log = (Log) t.testObj.get(TestObj.LOG);
        this.logger = (Logger) t.testObj.get(TestObj.LOGGER);
        this.actionHelper = (ActionHelper) t.testObj.get(TestObj.ACTION_HELPER);
    }
}
```

To write Test Class, extends Logger Class and set run-properties, data-parameters and test-data inside constructor of the Test Class for TestBase instance which is available in Logger.
And If any Page-Object is defined in project instanciate Page-Object in either constructor or before-class method of Test Class after initializing browser.

```
class TestClass extends Logger {
    PageObject pageObject;

    TestClass() throws IOException {
        super();
        TestBase.setRunProperties();

        // if test is data-driven
        TestBase.setDataParameters("TEST_DATA_PATH", "<SHEET_NAME>");
        TestBase.setTestData();
    }

    @BeforeClass
    public void beforeClass() {
        TestBase.mkdirRoot();
        initialize("<BROWSER_NAME>", "<URL>");

        // page objects initialization goes here
        pageObject = new PageObject(TestBase);
    }
}
```

*Test Data assumes that the data will be provided in excel-sheet with first row as a header row and fist column as id for the current row.*
  
## Authors

- [@kshubhamz](https://www.github.com/kshubhamz)

*Inspired from design of 'Roshan Shinde'*