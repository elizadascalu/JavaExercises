package com.company;
import java.time.LocalDate;
import java.util.Objects;

public class Application extends Project {
    private Language language;

    /**
     * Application constructor
     *
     * @param appName - application's name
     * @param deadLine - application's deadline
     * @param language - application's language
     */
    Application(String appName, LocalDate deadLine, Language language){
        setName(appName);
        setDeadline(deadLine);
        this.language = language;
        setAvailable(1);
    }


    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    @Override
    public String toString() {
        return "Application{" +
                "language=" + language + ", " + "name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Application that = (Application) o;
        return language == that.language;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language);
    }
}