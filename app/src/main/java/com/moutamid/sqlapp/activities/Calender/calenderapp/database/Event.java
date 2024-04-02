package com.moutamid.sqlapp.activities.Calender.calenderapp.database;

public class Event {
    private long id;
    private String title;
    private String date;
    private String time;
    private String description;
    private boolean checked;

    public Event() {
        // Default constructor
    }

    public Event(String title, String date, String time, String description, boolean checked) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.description = description;
        this.checked = checked;
    }

    // Getters and setters for all fields

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
