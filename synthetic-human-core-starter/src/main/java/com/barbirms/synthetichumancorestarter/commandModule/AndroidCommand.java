package com.barbirms.synthetichumancorestarter.commandModule;

public class AndroidCommand {
    String description;
    CommandPriority priority;
    String author;
    String time;

    public AndroidCommand(String description, CommandPriority priority, String author, String time)
            throws IllegalArgumentException {
        if (description == null || description.length() > 1000) {
            throw new IllegalArgumentException("description cannot be null or longer than 1000 characters");
        }
        if (priority == null) {
            throw new IllegalArgumentException("priority cannot be null");
        }
        if (author == null || author.length() > 100) {
            throw new IllegalArgumentException("author cannot be null or longer than 100 characters");
        }

        if (time == null || !isValidISODateTime(time)) {
            throw new IllegalArgumentException("invalid time format");
        }
        this.description = description;
        this.priority = priority;
        this.author = author;
        this.time = time;
    }

    boolean isValidISODateTime(String date) {
        try {
            java.time.format.DateTimeFormatter.ISO_DATE_TIME.parse(date);
            return true;
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
    }
}
