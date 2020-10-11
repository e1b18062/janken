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
    model.addAttribute("myname",namae);
    return "lec02.html";
  }

  @GetMapping("/lec02janken")
  public String lec02janken(@RequestParam String hand,ModelMap model){
    String kekka = "";

    if(hand.equals("Gu")){
      kekka = "Draw!";
    }
    if(hand.equals("Cho")){
      kekka = "You Lose!";
    }
    if(hand.equals("Pa")){
      kekka = "You Win!";
    }
    model.addAttribute("myhand",hand);
    model.addAttribute("kekka",kekka);

    return "lec02.html";
  }

}
