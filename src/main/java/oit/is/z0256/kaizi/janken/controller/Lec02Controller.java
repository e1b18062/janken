package oit.is.z0256.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lec02Controller{

  @PostMapping("/lec02")
  public String lec02(@RequestParam String namae,ModelMap model){
    String myname = namae;
    model.addAttribute("myname",myname);
    return "lec02.html";
  }
}
