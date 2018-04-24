package com.spbstu.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by dmitry on 18.04.2018.
 */
public class DataProviderTest {
    //This method will provide data to any test method that declares that its Data Provider
//is named "test1"
    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", 6},
                {"Anne", 4},
                {"Dima", 1},
        };
    }

    //This test method declares that its data should be supplied by the Data Provider
//named "test1"
    @Test(dataProvider = "test1")
    public void verifyData1(String s, Integer expectedLength) {
        Assert.assertEquals(Func.calc(s), expectedLength);
    }

}
