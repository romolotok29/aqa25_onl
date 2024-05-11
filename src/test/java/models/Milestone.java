package models;

import java.util.Objects;

public class Milestone {

    private String name;
    private String reference;
    private String description;
    private boolean isCompleted;

    public String getName() {
        return name;
    }

    public String getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(name, milestone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Milestone{" +
                "name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
