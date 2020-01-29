package pl.itacademy.schedule;

import java.util.List;
import java.util.Objects;

public class Schedule {
    private List<Lesson> lessons;
    private boolean succesfull;

    public Schedule(List<Lesson> lessons, boolean succesfull) {
        this.lessons = lessons;
        this.succesfull = succesfull;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public boolean isSuccesfull() {
        return succesfull;
    }

    public void setSuccesfull(boolean succesfull) {
        this.succesfull = succesfull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return succesfull == schedule.succesfull &&
                Objects.equals(lessons, schedule.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lessons, succesfull);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lessons=" + lessons +
                ", succesfull=" + succesfull +
                '}';
    }
}
