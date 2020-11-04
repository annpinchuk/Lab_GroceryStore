package com.GroceryShop;

public enum CounterType {
    Fridge(1) {
        @Override
        public String toString() {
            return "Fridge (" +
                    levels + " levels)";
        }
    },
    Shelf(5) {
        @Override
        public String toString() {
            return "Shelf (" +
                    levels + " levels)";
        }
    },
    Box(1) {
        @Override
        public String toString() {
            return "Box (" +
                    levels + " levels)";
        }
    };

    int levels;

    CounterType(int levels) {
        this.levels = levels;
    }

    static String getList() {
        StringBuilder sb = new StringBuilder();
        for (var value : CounterType.values()) {
            sb.append(value);
            sb.append(", ");
        }
        return sb.toString();
    }
}
