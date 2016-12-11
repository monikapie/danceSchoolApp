package com.universityapp.controller;

import com.universityapp.model.DiscountEntity;
import com.universityapp.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by pietyszukm on 11.12.2016.
 */
@RestController
@RequestMapping("/discounts")
public class DiscountController{
    @Autowired
    private DiscountService discountService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<DiscountEntity> getAllCards(){
        return discountService.getList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public DiscountEntity getCardWithId(@PathVariable Long id){
        return discountService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCard(@RequestBody DiscountEntity input){
        discountService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateCard(@PathVariable(value = "id") Long id, @RequestBody DiscountEntity input){
        discountService.save(input);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteCard(@PathVariable(value = "id") Long id){
        DiscountEntity disountEntity = discountService.findById(id);
        discountService.delete(disountEntity);
    }
}
