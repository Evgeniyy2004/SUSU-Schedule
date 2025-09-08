package edu.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassResponse {
    @JsonProperty("day")
    private String day = null;

    @JsonProperty("subjects")
    private List<String> subjects  = new ArrayList<>();

    @JsonProperty("time")
    private List<String> timeList = new ArrayList<>();

    @JsonProperty("classrooms")
    private List<String>  classrooms  =new ArrayList<>();

    public ClassResponse day(String day) {
        this.day = day;
        return this;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<String> timeList) {
        this.timeList = timeList;
    }



    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> tutors) {
        this.subjects = tutors;
    }

    public List<String> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<String> tutors) {
        this.classrooms = tutors;
    }

    public void addClass(String time, String classroom, String subject){
        classrooms.add(classroom);
        timeList.add(time);
        subjects.add(subject);
    }



    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassResponse Response = (ClassResponse) o;
        return Objects.equals(this.day, Response.day)
            && Objects.equals(this.timeList, Response.timeList)
            && Response.timeList.equals(this.timeList)
            && Response.subjects.equals(this.subjects)
            && Response.classrooms.equals(this.classrooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, timeList,classrooms, subjects);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinkResponse {\n");
        sb.append("   day: ").append(toIndentedString(day)).append("\n");
        sb.append("   time: ").append(toIndentedString(timeList)).append("\n");
        sb.append("   classrooms: ").append(toIndentedString(classrooms)).append("\n");
        sb.append("   subjects: ").append(toIndentedString(subjects)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
