package jar.controller;

import jar.entity.Application;
import jar.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/all")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}