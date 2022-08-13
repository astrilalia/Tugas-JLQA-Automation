package tugas.tugaspomtest;

import org.testng.Assert;
import org.testng.TestNG;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestNG
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( );
    }

    /**
     * @return the suite of tests being tested
     */
    public static TestNG suite()
    {
        return new TestNG( );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Assert.assertEquals( 1,1 );
    }
}
