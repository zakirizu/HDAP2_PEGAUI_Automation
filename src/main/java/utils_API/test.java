package utils_API;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class test {

	

	    private static final String DATA_PROVIDER_NAME = "testData"; // Constant Expression

	    @Test(dataProvider = DATA_PROVIDER_NAME)
	    public void testMethod(String value) {
	        System.out.println("Test data: " + value);
	    }

	    @DataProvider(name = DATA_PROVIDER_NAME)
	    public Object[][] provideData() {
	        return new Object[][] {
	            {"Data1"},
	            {"Data2"},
	            {"Data3"}
	        };
	    }
	}

