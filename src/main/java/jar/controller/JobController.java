package jar.controller;

import jar.entity.Job;
import jar.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/jobs")
    public String viewJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(required = false) String keyword,
            Model model) {

        Pageable pageable = PageRequest.of(page, 7); // 7 per page
        Page<Job> jobPage;

        if (keyword != null && !keyword.isEmpty()) {
            jobPage = jobRepository
                    .findByTitleContainingIgnoreCaseOrLocationContainingIgnoreCase(
                            keyword,
                            keyword,
                            pageable
                    );
        } else {
            jobPage = jobRepository.findAll(pageable);
        }

        model.addAttribute("jobs", jobPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", jobPage.getTotalPages());
        model.addAttribute("keyword", keyword);

        return "jobs";
    }
}