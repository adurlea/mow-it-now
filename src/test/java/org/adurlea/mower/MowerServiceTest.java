package org.adurlea.mower;

import static org.junit.Assert.assertEquals;

import org.adurlea.mower.MowerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by adurlea on 29/10/15.
 */
@RunWith(MockitoJUnitRunner.class)
public class MowerServiceTest {

    private MowerService mowerService;

    @Test
    public void when_moveMower_withTwoMowers() {
        // GIVEN
        String surface = "5 5";
        String mower1Pos = "1 2 N";
        String mower1Move = "GAGAGAGAA";

        String mower2Pos = "3 3 E";
        String mower2Move = "AADAADADDA";

        String expectedMower1Pos = "1 3 N";
        String expectedMower2Pos = "5 1 E";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mower1Pos);
        String finalMower1Pos = mowerService.moveMower(0, mower1Move);

        mowerService.addMower(mower2Pos);
        String finalMower2Pos = mowerService.moveMower(1, mower2Move);

        // THEN
        assertEquals(expectedMower1Pos, finalMower1Pos);
        assertEquals(expectedMower2Pos, finalMower2Pos);
    }
}
