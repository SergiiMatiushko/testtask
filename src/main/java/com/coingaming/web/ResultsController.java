package com.coingaming.web;


import com.coingaming.service.Results;
import com.coingaming.service.Search;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultsController {

    @RequestMapping("/api/search")
    public Results results (String q) {

        Search search = new Search(q);
        return new Results(search.getArrayLinkedHashMap(),search.getCount());
    }
}
