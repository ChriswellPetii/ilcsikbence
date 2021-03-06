package com.greenfoxacademy.foxclub.services;

import com.greenfoxacademy.foxclub.models.Fox;
import com.greenfoxacademy.foxclub.repositories.FoxClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoxClubServiceImpl implements FoxClubService {
  FoxClubRepository foxClubRepository;
  Fox defaultFox = new Fox();

  @Autowired
  public FoxClubServiceImpl(FoxClubRepository foxClubRepository) {
    this.foxClubRepository = foxClubRepository;
  }

  @Override
  public Fox getFoxByName(String name) {
    ArrayList<Fox> foxes = new ArrayList<>();
    for (int i = 0; i < foxClubRepository.sizeOfFoxList(); i++) {
      if (getFoxByIndex(i).getName().equals(name)) {
        foxes.add(getFoxByIndex(i));
      }
    }
    return foxes.get(0);
  }

  @Override
  public Fox getFoxByIndex(int i) {
    return foxClubRepository.getFoxList().get(i);
  }

  @Override
  public void changeFood(String name, String food) {
    getFoxByName(name).setFood(food);
  }

  @Override
  public void changeDrink(String name, String drink) {
    getFoxByName(name).setDrink(drink);
  }

  @Override
  public void changeLook(String name, String imagePath) {
    getFoxByName(name).setImagePath(imagePath);
  }

  @Override
  public List<String> changesList(String name) {
    List<String> changes = new ArrayList<>();
    if (!getFoxByName(name).equals(defaultFox)) {
      if (!getFoxByName(name).getFood().equals(defaultFox.getFood()))
        changes.add("food change");
      if (!getFoxByName(name).getDrink().equals(defaultFox.getDrink()))
        changes.add("drink change");
      if (!getFoxByName(name).getTricks().equals(defaultFox.getTricks()))
        changes.add("tricks change");
    }
    return changes;
  }

  @Override
  public void addToTricksList(String name, String trick) {
    List<String> newList = new ArrayList<>();
    for (int i = 0; i < getFoxByName(name).getTricks().size(); i++) {
      newList.add(getFoxByName(name).getTricks().get(i));
    }
    newList.add(trick);

    getFoxByName(name).setTricks(newList);
  }

  @Override
  public void addNewFox(String name) {
    Fox fox = new Fox();
    fox.setName(name);
    List<Fox> newFoxList = new ArrayList<>();
    for (int i = 0; i < foxClubRepository.getFoxList().size(); i++) {
      newFoxList.add(foxClubRepository.getFoxList().get(i));
    }
    newFoxList.add(fox);
    foxClubRepository.setFoxList(newFoxList);
  }

  @Override
  public List<Fox> getAllFoxes() {
    return foxClubRepository.getFoxList();
  }
}