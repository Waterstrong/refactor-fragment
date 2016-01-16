package com.water.rover;

import static com.water.rover.util.CommandLoader.convertInputIntoCommands;
import static com.water.rover.util.CommandMapper.getCommand;

import com.water.rover.location.Direction;
import com.water.rover.location.Location;
import com.water.rover.location.Point;

public class MarsRover {

    private Location location;

    public MarsRover(int startingX, int startingY, String direction) {
        location = new Location(new Point(startingX, startingY), Direction.valueOf(direction));
    }

    public String run(String input) {
        convertInputIntoCommands(input).forEach(command ->
                location = getCommand(command).execute(location));
        return location.asString();
    }

}
