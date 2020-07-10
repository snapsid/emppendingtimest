package com.example.employabilitytracking;

public class InstandMessage {

    private String name;
    private String author;
    private String timestamp;
    private String aadhar;

    public InstandMessage(String name, String author, String timestamp, String aadhar) {
        this.name = name;
        this.author = author;
        this.timestamp=timestamp;
        this.aadhar=aadhar;
    }

    public InstandMessage() {
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimestamp()
    {
     return timestamp;
    }
    public String getAadhar()
    {
        return aadhar;
    }
}
