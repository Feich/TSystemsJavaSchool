package model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Cargo {
    private long id;
    private String name;
    private float weight;
    private String status;

    public Cargo(String name, double weight, String status) {
        this.name = name;
        this.weight = (float) weight;
        this.status = status;
    }
/*    public Cargo(long id, String name, float weight, String status) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.status = status;
    }*/

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}
