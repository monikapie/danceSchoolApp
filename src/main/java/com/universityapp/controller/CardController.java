package com.universityapp.controller;

import com.universityapp.model.CardEntity;
import com.universityapp.model.ClientEntity;
import com.universityapp.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@RestController
@RequestMapping("/cards")
public class CardController{
    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<CardEntity> getAllCards(){
        return cardService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CardEntity getCardWithId(@PathVariable Long id){
        return cardService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/client/{id}")
    public List<CardEntity> getCardWithClientId(@PathVariable Long id){
        return cardService.findByClientId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCard(@RequestBody CardEntity input){
        cardService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateCard(@PathVariable(value = "id") Long id, @RequestBody CardEntity input){
        cardService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteCard(@PathVariable(value = "id") Long id){
        CardEntity cardEntity = cardService.findById(id);
        cardService.delete(cardEntity);
    }
}
