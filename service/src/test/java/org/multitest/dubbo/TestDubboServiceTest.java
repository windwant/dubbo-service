package org.multitest.dubbo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Unit test for simple HelloDubboService.
 */
public class TestDubboServiceTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestDubboServiceTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestDubboServiceTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testTestDubboService() throws IOException {
        TestServer svr = new TestServer();
        svr.startAsync();
        try{
            Object lock = new Object();
            synchronized (lock){
                lock.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
