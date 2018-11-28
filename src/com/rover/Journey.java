package com.rover;

import com.rover.terrain.Position;

import java.util.List;

public class Journey {

    private final List<Position> positions;

    public Journey(List<Position> positions) {
        this.positions = positions;
    }

    public Position getFinalPosition() {
        return this.positions.get(this.positions.size() - 1);
    }
}
