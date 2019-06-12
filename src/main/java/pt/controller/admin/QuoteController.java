package pt.controller.admin;

import pt.domain.Quote;
import pt.service.QuoteService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Qualifier("ServiceImpl")
    private QuoteService service;

    @PostMapping("/create")
    @ResponseBody
    public Quote create(Quote quote){
        return service.create(quote);
    }

    @PostMapping("/update")
    @ResponseBody
    public Quote update(Quote quote){
        return service.update(quote);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Quote read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Quote> getAll(){
        return service.getAll();
    }
}
