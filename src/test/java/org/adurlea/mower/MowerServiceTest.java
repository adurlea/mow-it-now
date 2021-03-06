package org.adurlea.mower;

import static org.junit.Assert.assertEquals;

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

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidSurfaceNull_thenException() {
        // GIVEN
        String surface = null;

        // WHEN
        mowerService = new MowerService(surface);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidSurfaceBlanc_thenException() {
        // GIVEN
        String surface = "";

        // WHEN
        mowerService = new MowerService(surface);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidSurfaceSpace_thenException() {
        // GIVEN
        String surface = "   ";

        // WHEN
        mowerService = new MowerService(surface);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidPositionNull_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = null;

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidPositionBlanc_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidPositionSpace_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "   ";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidMoveInstructionNull_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "2 2 N";
        String mowerMove = null;

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
        mowerService.moveMower(0, mowerMove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidMoveInstructionBlanc_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "2 2 N";
        String mowerMove = "";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
        mowerService.moveMower(0, mowerMove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_invalidMoveInstructionSpace_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "2 2 N";
        String mowerMove = "   ";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
        mowerService.moveMower(0, mowerMove);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when_createMowerService_wrongMoveInstruction_thenException() {
        // GIVEN
        String surface = "5 5";
        String mowerPos = "2 2 N";
        String mowerMove = "Y";

        // WHEN
        mowerService = new MowerService(surface);
        mowerService.addMower(mowerPos);
        mowerService.moveMower(0, mowerMove);
    }
}
