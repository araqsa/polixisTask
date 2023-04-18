package com.polixis.tests;

import com.polixis.util.ILogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NodesCountWithoutAvatarVerificationTest extends BaseTest {

    public static final int EXPECTED_COUNT_OF_NODES_WITHOUT_AVATAR = 2;

    @Test
    public void verifyCountOfNodesWithoutAvatar() throws IOException {
        ILogger.info("Verifying that number of nodes without avatar is correct");
        Assert.assertEquals(getCountOfNodesWithoutAvatar(getElementsFromHTML()), EXPECTED_COUNT_OF_NODES_WITHOUT_AVATAR);
    }
}
