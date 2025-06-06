package com.example.demo.controller.adminController;

import com.example.demo.domain.*;
import com.example.demo.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Controller

//@PreAuthorize("hasAnyAuthority('Admin')")
public class adminController {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private strishkaRepo StrishkaRepo;
    @Autowired
    private BarberSalaryRepo barberSalaryRepo;
    @Autowired
    private HelperRepo helperRepo;
    @Autowired
    private MassagerRepo massagerRepo;
    @Autowired
    private BarberKPIRepo barberKPIRepo;
    @Autowired
    private ClientsRepo clientsRepo;


    @GetMapping("/index")
    public ModelAndView index(Map<String, Object> model) {

        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("strishka", strishkas);

        List<User> barbers = userRepo.findAll();
        model.put("bar", barbers);

        List<Massage> massages = massagerRepo.findByStatus(false);
        model.put("salary", massages);

        List<BarberSalary> barberSalaries = barberSalaryRepo.findByStatus(true);



        long a = 0;
        int x = 0;
        while (barberSalaries.size() > x) {

            a += barberSalaries.get(x).getSalary();

            x++;
        }




        List <Long> get =new ArrayList <>();
        get.add( a);

        model.put("get", get);



        List <Long> client =new ArrayList <>();
        client.add((long) x);
        model.put("client", x);


        List<Massage> ochuzakaz = massagerRepo.findByStatus(false);

        List <Long> ochuzakaz1 =new ArrayList <>();
        ochuzakaz1.add((long) ochuzakaz.size());
        model.put("ochuzakaz", ochuzakaz1);


        List<BarberKPI>kpis=barberKPIRepo.findByStatus(false);

        List <Long> KPI =new ArrayList <>();
        KPI.add((long) kpis.size());
        model.put("KPI",KPI);

        /*Massage massage = massagerRepo.findById(id);
        massage.setStatus(true);
        strishka strishkaList = StrishkaRepo.findBySrishkaType(massage.getStill());

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
         */

        return new ModelAndView("adminn/index", model);
    }


    @GetMapping("strishka")
    public ModelAndView Strishka(Map<String, Object> model) {

        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("strishka", strishkas);

        return new ModelAndView("adminn/strishka", model);
    }

    @PostMapping("/strishka")
    public ModelAndView addstrishka(@RequestParam String still, @RequestParam int narxi, Map<String, Object> model) {
        System.out.println("strishka qoshildi");

        strishka Strishka = new strishka(still, narxi);
        StrishkaRepo.save(Strishka);
        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("strishka", strishkas);

        return new ModelAndView("adminn/strishka", model);
    }
    @PostMapping("/deletestyle")
    public String delete(@RequestParam String name,Map<String ,Object> model){

        strishka list = StrishkaRepo.findBySrishkaType(name);

        StrishkaRepo.deleteById(list.getId());

        Iterable<strishka> strishkas = StrishkaRepo.findAll();
        model.put("strishka", strishkas);

        return "adminn/strishka";
    }
    @PostMapping("/deleteuser")
    public String deleteuser(@RequestParam String name,Map<String ,Object> model){
       User user= userRepo.findByLogin(name);
       List<BarberSalary>list=barberSalaryRepo.findByBarbername(user.getLogin());
       for (BarberSalary x:list){
           x.setBarbername(user.getLogin()+" [/delete/]");
       }


      userRepo.deleteById(user.getId());


        Iterable<User> barbers = userRepo.findAll();
        model.put("barber", barbers);

        return "adminn/barber";
    }



    @GetMapping("/barber")
    public ModelAndView barber(Map<String, Object> model) {
        Iterable<User> barbers = userRepo.findAll();
        model.put("barber", barbers);
        return new ModelAndView("adminn/barber", model);
    }


    @GetMapping("/kpi")
    public String kpi(Map<String, Object> model) {

        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("barber", barbers);

        return "adminn/KPI";
    }


    @PostMapping("/hhh")
    public String hhh(@RequestParam String name,
                      @RequestParam String date,
                      @RequestParam int narxi,
                      @RequestParam String zadacha,
                      Map<String, Object> model) {

        BarberKPI barberKPI=new BarberKPI(name,zadacha,date,narxi,false);
        barberKPIRepo.save(barberKPI);


        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("barber", barbers);



        return "adminn/KPI";
    }
    @GetMapping("/KpiTable")
    public ModelAndView KpiTable(Map<String,Object>model){

        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("bar", barbers);


        return new ModelAndView("adminn/KPITable", model);
    }
    @GetMapping("/dateTable")
    public ModelAndView dateTabel(Map <String,Object>model){

        List<BarberSalary> barberSalaries = barberSalaryRepo.findByStatus(true);
        model.put("salary", barberSalaries);

        return new ModelAndView("adminn/DateTable", model);
    }
    @PostMapping("/deleteZayafka")
    public String delete(@RequestParam long id,Map<String ,Object> model){
        System.out.println("keldi");

       Massage list = massagerRepo.findById(id);

       massagerRepo.delete(list);

        System.out.println("udalit boldi");
        return "redirect:/index";
    }
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @GetMapping("/data")
    public String data(@RequestParam String name,@RequestParam int foiz,@RequestParam String data1, @RequestParam String data2,Map <String,Object> model){
       LocalDate date1= LocalDate.parse(data1);
        LocalDate date2= LocalDate.parse(data2);
      List<BarberSalary>list = new ArrayList<>();
      List <Long> suma=new ArrayList<Long>();
        List <Long> barberpuli=new ArrayList<Long>();
        date1.format(dateFormatter);
        date2.format(dateFormatter);
        LocalDate next = date1.minusDays(1);
        while ((next = next.plusDays(1)).isBefore(date2.plusDays(1))) {
           String a=next.toString();
            list.addAll(barberSalaryRepo.findByBarbernameAndDate(name,a));
            System.out.println(next);
        }
        long hammasi=0;
        long dola=0;

        for (BarberSalary x:list){
            hammasi+=x.getSalary();
            dola+= (x.getSalary()/100)*foiz;
            System.out.println(hammasi);
        }

            suma.add(suma.size(),hammasi);
            barberpuli.add(barberpuli.size(),dola);

                 model.put("barber",list);
                 model.put("suma",suma);
                 model.put("dola",barberpuli);

        Iterable<User> barbers = userRepo.findByRoles(Role.User);
        model.put("bar", barbers);

   //   return "redirect:/KpiTable";
        return "adminn/KPITable";
    }
    @GetMapping("/clients")
    public String clients(Map<String,Object> model){
        Iterable<User> barbers = userRepo.findAll();
        model.put("bar", barbers);

        Iterable<Klient> clients= clientsRepo.findAll();
        model.put("client", clients);

        return "adminn/clients";
    }
    @PostMapping("/clientss")
    public String addClient(@RequestParam String name,@RequestParam String number,@RequestParam String bar, @RequestParam String date){
        User user= userRepo.findByLogin(name);

        clientsRepo.save(new Klient(name,number,bar,date));

        return "redirect:/clients";
    }


}