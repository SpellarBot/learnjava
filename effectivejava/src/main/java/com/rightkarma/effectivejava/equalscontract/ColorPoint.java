package com.rightkarma.effectivejava.equalscontract;

import java.util.Objects;

public class ColorPoint extends Point {

    private final int z;

    public ColorPoint(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorPoint)) return false;
        if (!super.equals(o)) return false;
        ColorPoint that = (ColorPoint) o;
        return z == that.z;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), z);
    }
}
