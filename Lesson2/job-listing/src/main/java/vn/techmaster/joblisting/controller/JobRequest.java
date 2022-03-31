package vn.techmaster.joblisting.controller;

public record JobRequest (String title, String description, location location, int min_salary, int max_salary, String email_to){


}
