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

    public abstract Heading turnLeft();
    public abstract Heading turnRight();
}
