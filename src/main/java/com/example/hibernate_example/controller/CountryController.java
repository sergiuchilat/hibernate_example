package com.example.hibernate_example.controller;


import com.example.hibernate_example.model.Country;
import com.example.hibernate_example.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService){
        super();
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country){
        return new ResponseEntity<Country>(countryService.save(country), HttpStatus.CREATED);
    }
}
