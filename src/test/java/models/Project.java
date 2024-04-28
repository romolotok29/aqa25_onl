package models;

import java.util.Objects;

public class Project {

    private String name;
    private String announcementText;
    private boolean announcementCheckbox;
    private int testSuiteType;
    private boolean enableTCApprovals;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncementText() {
        return announcementText;
    }

    public void setAnnouncementText(String announcementText) {
        this.announcementText = announcementText;
    }

    public boolean getAnnouncementCheckbox() {
        return announcementCheckbox;
    }

    public void setAnnouncementCheckbox(boolean announcementCheckbox) {
        this.announcementCheckbox = announcementCheckbox;
    }

    public int getTestSuiteType() {
        return testSuiteType;
    }

    public void setTestSuiteType(int testSuiteType) {
        this.testSuiteType = testSuiteType;
    }

    public boolean getEnableTCApprovals() {
        return enableTCApprovals;
    }

    public void setEnableTCApprovals(boolean enableTCApprovals) {
        this.enableTCApprovals = enableTCApprovals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return announcementCheckbox == project
                .announcementCheckbox && testSuiteType == project
                .testSuiteType && enableTCApprovals == project
                .enableTCApprovals && name.equals(project.name) && announcementText.equals(project.announcementText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcementText, announcementCheckbox, testSuiteType, enableTCApprovals);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcementText='" + announcementText + '\'' +
                ", announcementCheckbox=" + announcementCheckbox +
                ", testSuiteType=" + testSuiteType +
                ", enableTCApprovals=" + enableTCApprovals +
                '}';
    }
}
