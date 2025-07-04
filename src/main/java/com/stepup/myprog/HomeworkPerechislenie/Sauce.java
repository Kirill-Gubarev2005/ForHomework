package com.stepup.myprog.HomeworkPerechislenie;

enum Spiciness {
    VERY_HOT("очень острый"),
    HOT("острый"),
    NOT_HOT("не острый");

    private final String description;

    Spiciness(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

public class Sauce {
    private final String name;
    private final Spiciness spiciness;

    public Sauce(String name, Spiciness spiciness) {
        this.name = name;
        this.spiciness = spiciness;
    }

    public String toString() {
        return "Соус " + name + ": " + spiciness.getDescription();
    }
}

enum op {
    ADD {
        public int calculate(int x, int y) {
            return x + y;
        }
    },
    SUBTRACT {
        public int calculate(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY {
        public int calculate(int x, int y) {
            return x * y;
        }
    },
    DIVIDE {
        public int calculate(int x, int y) {
            return x / y;
        }
    };

    public abstract int calculate(int x, int y);
}