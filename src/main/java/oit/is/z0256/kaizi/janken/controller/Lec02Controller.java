package oit.is.z0256.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0256.kaizi.janken.model.Entry;

@Controller
public class Lec02Controller{

  @Autowired
  private Entry entry;

  @GetMapping("/lec02")
  public String lec02(ModelMap model,Principal prin){
    String loginuser = prin.getName(); //ログインユーザ情報
    this.entry.addUser(loginuser);
    model.addAttribute("entry",this.entry);
    model.addAttribute("login_user",loginuser);
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
