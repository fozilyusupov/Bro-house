package com.example.demo.controller;


import com.example.demo.domain.*;

import com.example.demo.repos.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MassagerRepo massagerRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private strishkaRepo StrishkaRepo;
    @Autowired
    private BarberSalaryRepo barberSalaryRepo;
    @Autowired
    private BarberKPIRepo barberKPIRepo;
    @Autowired
    private ClientsRepo clientsRepo;

    private String name1;


    @GetMapping
    public String greeting(Map<String, Object> model) {




        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("still", strishkas);

        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("bar", barbers);

        Iterable<Massage> massages = massagerRepo.findAll();
        model.put("massages", massages);

        return "main";
    }


    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<User> barbers = userRepo.findAll();
        model.put("bar", barbers);


        return "greeting";
    }

    @GetMapping("/zayafkaberber")
    public ModelAndView zayafkabarber(Map<String, Object> model) {

        String auth = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(auth);

        User name = userRepo.findByUsername(auth);

        this.name1 = name.getLogin();

        List<Massage> list = massagerRepo.findByBarbernameAndStatus(name.getLogin(), false);
        List<Massage> list2 = massagerRepo.findByBarbername(name.getLogin());
        List<BarberKPI> list1 = barberKPIRepo.findByNameAndStatus(name.getLogin(), false);
        if (!list.isEmpty()) {
            model.put("massages", list);
            model.put("n", list2.get(0));
        }
        if (!list1.isEmpty()) {

            model.put("Kpi", list1);
        }

        //  if (!list1.isEmpty()) {
        //       model.put("kpi", list);
        //   }

        return new ModelAndView("zayafkaberber", model);

    }

    @GetMapping("/zayafka")
    public String addzayafka(@RequestParam String name,
                             @RequestParam String bar,
                             @RequestParam String still,
                             @RequestParam String date,
                             @RequestParam String time,
                             @RequestParam String number,
                             @RequestParam String messege,

                             Map<String, Object> model) {


        List<Massage> iff = massagerRepo.findByBarbernameAndStatus(bar, false);
        for (Massage x : iff) {
            System.out.println(date + " 1 " + x.getDate());

            if (x.getDate().equals(date) && x.getTime().equals(time)) {

                Iterable<User> barbers = userRepo.findByRoles(Role.User);
                model.put("bar", barbers);
                System.out.println("2");

                Iterable<strishka> strishkas = StrishkaRepo.findAll();
                model.put("still", strishkas);

                Iterable<Massage> massagess = massagerRepo.findAll();
                model.put("massages", massagess);
                return "redirect:/.?error=true";

            }

        }


        Massage massages = new Massage(name, bar, still, date, time, number, messege, false);
        massagerRepo.save(massages);

        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("bar", barbers);


        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("still", strishkas);

        Iterable<Massage> massagess = massagerRepo.findAll();
        model.put("massages", massagess);

        System.out.println("zayafka qabul boldi");

        return "main";
    }


    @PostMapping("/save")
    public String save(@RequestParam long id, Map<String, Object> model) {
        System.out.println("keldi1");

        Massage massage = massagerRepo.findById(id);
        System.out.println("AAAAAAA");
        massage.setStatus(true);
        System.out.println("TEST");
        strishka strishkaList = StrishkaRepo.findBySrishkaType(massage.getStill());
        System.out.println("ADSDSA");
        barberSalaryRepo.save(
                new BarberSalary(
                        massage.getId(),
                        massage.getUsername(),
                        massage.getBarbername(),
                        massage.getStill(),
                        massage.getDate(),
                        massage.getTime(),
                        massage.getNumber(),
                        massage.getMessage(),
                        true,
                        strishkaList.getNarxi()));

        System.out.println("Keldiiii");
        clientsRepo.save(new Klient( massage.getUsername(),massage.getNumber(),massage.getBarbername(),massage.getDate()));
        massagerRepo.save(massage);

        System.out.println("Keldi2");
        List<Massage> list1 = massagerRepo.findByBarbernameAndStatus(name1, false);
        if (!list1.isEmpty()) {
            model.put("n", list1.get(0));
            model.put("massages", list1);
        }
        System.out.println("keldi3");

        return "redirect:/zayafkaberber";
    }

    @PostMapping("/KPIsave")
    public String kpisave(@RequestParam long id, Map<String, Object> model) {


        BarberKPI barberKPI = barberKPIRepo.findById(id);
        barberKPI.setStatus(true);
        barberKPIRepo.save(barberKPI);

        List<Massage> list1 = massagerRepo.findByBarbernameAndStatus(name1, false);
        if (!list1.isEmpty()) {
            model.put("n", list1.get(0));
            model.put("massages", list1);
        }

        return "zayafkaberber";
    }
    /// o'ziz run bering , login dam o'tib keyin o'wa joyga boring

    @RequestMapping(value = "/show/ajax", method = RequestMethod.GET)
    @ResponseBody
    public List<Massage> getName1(@RequestParam(name = "login" , required = false) String  login) {

       List  <Massage> list=massagerRepo.findByBarbernameAndStatus(login,false);

        return list;
    }
    @PostMapping("/bronTime")
    public String broTime(@RequestParam String data,@RequestParam  String time){
Massage massages;
        if (time.equals("Вес день")){

            massages= new Massage("Отдых", name1, ".", data, "Вес день", ".", ".", false);
        }
else {
             massages = new Massage("Dam olish vaqti", name1, ".", data, time, ".", ".", false);
        }

        massagerRepo.save(massages);

        return "redirect:/zayafkaberber";
    }



}