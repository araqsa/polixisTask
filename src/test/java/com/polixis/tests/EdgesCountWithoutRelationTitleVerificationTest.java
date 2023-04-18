package com.polixis.tests;

import com.polixis.util.ILogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class EdgesCountWithoutRelationTitleVerificationTest extends BaseTest {
    public static final int EXPECTED_COUNT_OF_EDGES_WITHOUT_RELATION_TITLE = 2;

    @Test
    public void verifyCountOfEdgesWithoutRelationTitle() throws IOException {
        ILogger.info("Verifying that number of edges without relation title is correct");
        Assert.assertEquals(getCountOfEdgesWithoutRelationTitle(getElementsFromHTML()), EXPECTED_COUNT_OF_EDGES_WITHOUT_RELATION_TITLE);
    }
}
