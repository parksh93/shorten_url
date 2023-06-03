package com.spring.shortenUrl.controller;

import com.spring.shortenUrl.repository.ShortenUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/shrturl")
public class ShortenUrlController {
    ShortenUrlRepository shortenUrlRepository;

    @Autowired
    public ShortenUrlController(ShortenUrlRepository shortenUrlRepository) {
        this.shortenUrlRepository = shortenUrlRepository;
    }

    @RequestMapping("/main")
    public String mainPage(){
        return "/shrtUrl/main";
    }

    @RequestMapping(value = "/saveurl", method = RequestMethod.POST)
    public String saveUrl(RedirectAttributes redirectAttributes, String url){
        String pr = shortenUrlRepository.save(url);
        String shortenUrl = "http://localhost:8080/shrturl/"+pr;

        redirectAttributes.addFlashAttribute("shortenUrl",shortenUrl);
        redirectAttributes.addFlashAttribute("url",url);

        return "redirect:/shrturl/main";
    }

    @RequestMapping(value = "/{pr}", method = RequestMethod.GET)
    public String goUrl(@PathVariable String pr){
        String url = shortenUrlRepository.findByShortenUrl(pr);
        return "redirect:"+ url;
    }
}
