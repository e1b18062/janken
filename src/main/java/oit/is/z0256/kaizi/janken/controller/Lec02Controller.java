package oit.is.z0256.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0256.kaizi.janken.model.User;
import oit.is.z0256.kaizi.janken.model.UserMapper;

import oit.is.z0256.kaizi.janken.model.Match;
import oit.is.z0256.kaizi.janken.model.MatchMapper;

import oit.is.z0256.kaizi.janken.model.MatchInfo;
import oit.is.z0256.kaizi.janken.model.MatchInfoMapper;


import oit.is.z0256.kaizi.janken.model.Entry;

@Controller
public class Lec02Controller{

  @Autowired
  private Entry entry;

  @Autowired
  UserMapper userMapper;

  @Autowired
  MatchMapper matchMapper;

  @Autowired
  MatchInfoMapper matchInfoMapper;




  @GetMapping("/lec02")
  public String lec02(ModelMap model,Principal prin){
    String loginuser = prin.getName(); //ログインユーザ情報
    this.entry.addUser(loginuser);
    //model.addAttribute("entry",this.entry);
    model.addAttribute("login_user",loginuser);

    ArrayList<User> users = userMapper.selectAllUser();
    model.addAttribute("users",users);

    ArrayList<Match> match2 = matchMapper.selectAllMatch();
    model.addAttribute("match2",match2);

    return "lec02.html";
  }

  @GetMapping("/result")
  @Transactional
  public String lec02janken(@RequestParam Integer id,@RequestParam String hand,ModelMap model,Principal prin){
    String kekka = "";
    String login_user = prin.getName();
    User user3 = userMapper.selectByName(login_user);


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

    Match match2 = new Match();
    match2.setUser_1(user3.getId());
    match2.setUser_2(id);
    match2.setUser_1_hand(hand);
    match2.setUser_2_hand("Gu");
    match2.setIs_active(true);
    matchMapper.insertMatch(match2);

    model.addAttribute("login_user",login_user);
    return "wait.html";
  }


  @GetMapping("/match")
  @Transactional
  public String match(@RequestParam Integer id,ModelMap model,Principal prin){
      String login_user = prin.getName();
      User user2 = userMapper.selectById(id);
      User myuser = userMapper.selectByName(login_user);
      MatchInfo match_info = new MatchInfo();
      match_info.setUser_1(myuser.getId());
      match_info.setUser_2(id);
      match_info.setIs_active(true);
      matchInfoMapper.insertMatchInfo(match_info);
      model.addAttribute("login_user",login_user);
      model.addAttribute("user2",user2);
      return "match.html";

  }
}
