package vn.techmaster.joblisting.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.joblisting.model.Job;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;
  public JobController() {
    jobs = new ConcurrentHashMap<>();
  jobs.put("AX1", new Job("AX1", "Actor", "Acting", location.Hanoi, 4000000, 10000000, "abc1@gmail.com"));
    jobs.put("AX2", new Job("AX2", "Actress", "Acting", location.HoChiMinh, 5000000, 20000000, "abc2@gmail.com"));
    jobs.put("AX3", new Job("AX3", "Director", "Managing", location.DaNang, 3000000, 40000000, "abc3@gmail.com"));
    jobs.put("AX4", new Job("AX4", "Engineer", "Design", location.HoChiMinh, 10000000, 70000000, "abc4@gmail.com"));
    jobs.put("AX5", new Job("AX5", "Accountant", "Bookkeeping", location.Hanoi, 8000000, 90000000, "abc5@gmail.com"));

  }

  @GetMapping
  public List<Job> getJobs() {
    return jobs.values().stream().toList();
  }

  @PostMapping
  public Job createNewJob(@RequestBody JobRequest jobRequest) {
    String uuid = UUID.randomUUID().toString();
    Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
    jobs.put(uuid, newJob);
    return newJob;
  }

  @GetMapping(value="/{id}")
  public Job getJobById(@PathVariable("id") String id) {
    return jobs.get(id);
  }

  @PutMapping(value="/{id}")
  public Job updateJobById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
    Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(), jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
    jobs.replace(id, updateJob);
    return updateJob;
  }

  @DeleteMapping(value="/{id}")
  public Job deleteJobById(@PathVariable("id") String id) {
    Job removedJob = jobs.remove(id);
    return removedJob;
  }

  //Sắp xếp danh sách job theo thành phố tuyển
  @GetMapping(value = "/sortbylocation")
  public List<Job> sortByLocation(){
      List<Job> mutableList = jobs.values().stream().collect(Collectors.toList());
      mutableList.sort(new Comparator<Job>() {
          @Override
          public int compare(Job o1, Job o2) {
              return o1.getLocation().compareTo(o2.getLocation());
          }
      });
      return mutableList;
  }
  //Tìm các job mà {salary} trong khoảng min_salary và max_salary
  @GetMapping(value = "/salary/{salary}")
  public List<Job> findMatchSalary(@PathVariable("salary") int salary){
      List<Job> fullList = jobs.values().stream().collect(Collectors.toList());
      List<Job> matchList = new ArrayList<>();

      for (Job j : fullList){
          if (j.getMin_salary()<salary && j.getMax_salary()>salary){
              matchList.add(j);
          }
      }

      return matchList;
  }
  
  //tìm các job mà title hoặc description chứa {keyword}
  @GetMapping(value = "/keyword/{keyword}")
  public List<Job> SEO(@PathVariable("keyword") String keyword){
      List<Job> fullList = jobs.values().stream().collect(Collectors.toList());
      List<Job> matchList = new ArrayList<>();
      String lowercaseKeyword = keyword.toLowerCase();
      for (Job j : fullList){
          if (j.getTitle().toLowerCase().contains(lowercaseKeyword)|| j.getDescription().toLowerCase().contains(keyword)){
              matchList.add(j);
          }
      }
      return matchList;
  }
  //Tìm các job mà title hoặc description chứa {keyword} đồng thời location ={location}
  @GetMapping(value = "/query")
  public List<Job> MatchLocationAndKeyword(@RequestParam("keyword") String keyword, @RequestParam("location") String location){
      List<Job> fullList = jobs.values().stream().collect(Collectors.toList());
      List<Job> matchList = new ArrayList<>();
      String lowercaseKeyword = keyword.toLowerCase();
      for (Job j : fullList){
          String s = j.getLocation().name().toLowerCase(Locale.ROOT);
          if ((j.getTitle().toLowerCase().contains(lowercaseKeyword)|| j.getDescription().toLowerCase().contains(lowercaseKeyword)) && s.contains(location.toLowerCase()) ){
              matchList.add(j);
          }
      }
      return matchList;
    }
}
