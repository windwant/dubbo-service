package org.multitest.needer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;

/**
 * Unit test for simple TestDubboConsumer.
 */
public class TestDubboConsumerTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TestDubboConsumerTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestDubboConsumerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testTestDubboConsumer()
    {
        try {
            new TestDubboConsumer().consume();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
