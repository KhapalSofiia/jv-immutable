package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Engine clone() {
        try {
            Engine newEngine = (Engine) super.clone();
            return newEngine;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + getHorsePower();
        hash = hash * 31 + (getManufacturer() == null ? 0 : getManufacturer().hashCode());
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof Engine) {
            Engine current = (Engine) obj;
            return this.getHorsePower() == current.getHorsePower()
                    && Objects.equals(this.getManufacturer(), current.getManufacturer());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
