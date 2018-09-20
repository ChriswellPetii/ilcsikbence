package com.greenfoxacademy.foxclub.controllers;

import com.greenfoxacademy.foxclub.models.Message;
import com.greenfoxacademy.foxclub.services.FoxClubService;
import com.greenfoxacademy.foxclub.services.MessengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
  FoxClubService foxClubService;
  MessengerService messengerService;

  @Autowired
  public MainController(FoxClubService foxClubService, MessengerService messengerService) {
    this.foxClubService = foxClubService;
    this.messengerService = messengerService;
  }

  @GetMapping(value = "/")
  public String getMainPage(@RequestParam(value = "name", required = false) String name, Model model) {
    if (name == null)
      return "redirect:login";
    else
      model.addAttribute("fox", foxClubService.getFoxByName(name));
    return "index";

  }

  @GetMapping(value = "/login")
  public String getLoginPage() {
    return "login";
  }

  @PostMapping(value = "/login")
  public String postLoginPage(@RequestParam(value = "name") String name) {
    if (!name.equals(""))
      return "redirect:?name=" + name;
    else
      return "redirect:login";
  }

  @GetMapping(value = "/nutritionStore")
  public String getNutritionStorePage(@RequestParam(value = "name", required = false) String name, Model model) {
    if (name == null) {
      return "login";
    } else {
      model.addAttribute("fox", foxClubService.getFoxByName(name));
      return "nutrition-store";
    }
  }

  @PostMapping(value = "/nutritionStore")
  public String postNutritionStorePage(@RequestParam(value = "foodName") String foodName,
                                       @RequestParam(value = "drinkName") String drinkName,
                                       @RequestParam(value = "name") String name) {
    foxClubService.changeFood(name, foodName);
    foxClubService.changeDrink(name, drinkName);
    return "redirect:?name=" + name;
  }

  @GetMapping(value = "/actionHistory")
  public String getActionHistoryPage(@RequestParam(value = "name") String name, Model model) {
    model.addAttribute("changes", foxClubService.changesList(name));
    model.addAttribute("fox", foxClubService.getFoxByName(name));
    return "action-history";
  }

  @GetMapping(value = "/trickCenter")
  public String getTrickCenterPage(@RequestParam(value = "name") String name, Model model) {
    if (name == null) {
      return "login";
    } else {
      model.addAttribute("fox", foxClubService.getFoxByName(name));
      return "trick-center";
    }
  }

  @PostMapping(value = "/trickCenter")
  public String postTrickCenterPage(@RequestParam(value = "name") String name,
                                    @RequestParam(value = "trickName") String trickName) {
    foxClubService.addToTricksList(name, trickName);
    return "redirect:?name=" + name;
  }

  @GetMapping(value = "/register")
  public String getRegistrationPage() {
    return "register";
  }

  @PostMapping(value = "/register")
  public String postRegistrationPage(@RequestParam(value = "foxName") String foxName) {
    foxClubService.addNewFox(foxName);
    return "redirect:login";
  }

  @GetMapping(value = "/messenger/view")
  public String getMessagesPage(@RequestParam(value = "name") String name, Model model) {
    model.addAttribute("fox", foxClubService.getFoxByName(name));
    model.addAttribute("messages", messengerService.getMessages(name));
    return "view-messages";
  }

  @GetMapping(value = "/messenger/new")
  public String getNewMessageFormPage(@RequestParam(value = "name") String name, Model model) {
    model.addAttribute("fox", foxClubService.getFoxByName(name));
    return "message-form";
  }

  @PostMapping(value = "/messenger/new")
  public String postNewMessageFormPage(@RequestParam(value = "name") String senderName,
                                       @RequestParam(value = "recipientName") String recipientName,
                                      @RequestParam(value = "title") String title,
                                      @RequestParam(value = "content") String content) {
    messengerService.sendMessage(recipientName, new Message(title, content, senderName));
    return "redirect:/?name=" + senderName;
  }

  @GetMapping(value = "/messenger/message")
  public String getSingleMessagePage(@RequestParam(value = "name") String name,
                                     @RequestParam(value = "id") int id, Model model) {
    model.addAttribute("message", messengerService.getMessages(name).get(id));
    model.addAttribute("fox", foxClubService.getFoxByName(name));
    return "message-viewer";
  }
}