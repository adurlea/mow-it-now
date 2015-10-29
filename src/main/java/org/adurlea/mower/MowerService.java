package org.adurlea.mower;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by adurlea on 28/10/15.
 */
public class MowerService {

    private static final String ADVANCE = "A";
    private static final String LEFT = "G";
    private static final String RIGHT = "D";

    // max x position of the surface
    private final int xMaxSurf;
    // max y position of the surface
    private final int yMaxSurf;
    // list of created mowers
    private List<Mower> mowers = new ArrayList<Mower>();

    public MowerService(final String surface) {
        if (StringUtils.isNotBlank(surface)) {
            String[] surfacePos = surface.split(" ");
            this.xMaxSurf = Integer.parseInt(surfacePos[0]);
            this.yMaxSurf = Integer.parseInt(surfacePos[1]);
        } else {
            throw new IllegalArgumentException("Invalid surface parameters!");
        }

    }

    /**
     * add mower to surface
     *
     * @param position the mower position as x, y and orientation
     */
    public void addMower(final String position) {
        if (StringUtils.isNotBlank(position)) {
            String[] positions = position.split(" ");
            Mower mower = new Mower();
            mower.setxPos(Integer.parseInt(positions[0]));
            mower.setyPos(Integer.parseInt(positions[1]));
            mower.setCoordinate(Coordinate.valueOf(positions[2]));

            mowers.add(mower);
        } else {
            throw new IllegalArgumentException("Invalid mower position!");
        }
    }

    /**
     * Move the mower on the surface
     *
     * @param idMower          the id of the mower in the list
     * @param moveInstructions the chain of instructions to move
     * @return the position of the mower
     */
    public String moveMower(int idMower, String moveInstructions) {
        Mower mower = mowers.get(idMower);

        if (StringUtils.isNotBlank(moveInstructions)) {
            // execute instructions one by one
            for (int i = 0; i < moveInstructions.length(); i++) {
                String instruction = moveInstructions.substring(i, i + 1);
                // we have to move on case
                if (instruction.equals(ADVANCE)) {
                    moveMover(mower);
                } else if (instruction.equals(LEFT)) {
                    mower.setCoordinate(Coordinate.valueOf(mower.getCoordinate().getLeftCoord()));
                } else if (instruction.equals(RIGHT)) {
                    mower.setCoordinate(Coordinate.valueOf(mower.getCoordinate().getRightCoord()));
                } else {
                    throw new IllegalArgumentException("Invalid move instruction: " + instruction);
                }
            }
        } else {
            throw new IllegalArgumentException("Parameter moveInstructions invalid!");
        }

        return mower.toString();
    }

    /**
     * Move the mower with one case if the future position is valid
     *
     * @param mower {@link Mower} the mower
     */
    private void moveMover(Mower mower) {
        Coordinate coordinate = mower.getCoordinate();
        int nextXPos = mower.getxPos();
        int nextYPos = mower.getyPos();

        if (coordinate.isAdd()) {
            if (coordinate.isHoriz()) {
                if (nextXPos + 1 <= xMaxSurf) {
                    nextXPos++;
                }
            } else {
                if (nextYPos + 1 <= yMaxSurf) {
                    nextYPos++;
                }
            }
        } else {
            if (coordinate.isHoriz()) {
                if (nextXPos - 1 >= 0) {
                    nextXPos--;
                }
            } else {
                if (nextYPos >= 0) {
                    nextYPos--;
                }
            }
        }

        mower.setxPos(nextXPos);
        mower.setyPos(nextYPos);
    }

}
