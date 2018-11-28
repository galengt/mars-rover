package com.rover.terrain;

public enum Heading {

    NORTH {
        @Override
        public Heading turnLeft() {
            return WEST;
        }
        @Override
        public Heading turnRight() {
            return EAST;
        }
    },
    EAST {
        @Override
        public Heading turnLeft() {
            return NORTH;
        }
        @Override
        public Heading turnRight() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Heading turnLeft() {
            return EAST;
        }
        @Override
        public Heading turnRight() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Heading turnLeft() {
            return SOUTH;
        }
        @Override
        public Heading turnRight() {
            return NORTH;
        }
    }
    ;

    public static Heading parseInput(char input) {
        switch (input) {
            case 'N':
                return NORTH;
            case 'E':
                return EAST;
            case 'S':
                return SOUTH;
            case 'W':
                return WEST;
            default:
                throw new IllegalArgumentException(String.format("Unknown heading input %s", input));
        }
    }
    public abstract Heading turnLeft();
    public abstract Heading turnRight();
}
