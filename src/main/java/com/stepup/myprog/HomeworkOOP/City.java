package com.stepup.myprog.HomeworkOOP;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<Path> paths;

    private static class Path {
        City city;
        double cost;

        Path(City city, double cost) {
            this.city = city;
            this.cost = cost;
        }

        public String toString() {
            return city.name + ": " + cost;
        }
    }

    public City(String name) {
        this.name = name;
        this.paths = new ArrayList<>();
    }

    public City(String name, List<Path> Paths) {
        this.name = name;
        this.paths = new ArrayList<>(Paths);
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public void addPath(City city, double cost) {
        paths.add(new Path(city, cost));
    }

    public String toString() {
        String res = "[";
        if (!paths.isEmpty()) {
            for (int i = 0; i < paths.size(); i++) {
                res = res + paths.get(i);
                if (i < paths.size() - 1) res = res + ", ";
            }
            res = res + "]";
        }
        return res;
    }

    public String travelBy(int n) {
        City current = this;
        for (int i = 0; i < n; i++) {
            if (current.paths.isEmpty()) {
                return null;
            }
            current = current.paths.get(0).city;
        }
        return current.name;
    }
}
