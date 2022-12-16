package com.example.demo.admin;

import com.example.demo.station.station;
import com.example.demo.station.stationservice;
import com.example.demo.trip.trip;
import com.example.demo.trip.tripservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/app/admin")
public class admincontrollor {

    private final  adminservice  adminservice;
    private final tripservice t1;
    private final stationservice s1;

    @Autowired
    public admincontrollor(com.example.demo.admin.adminservice adminservice, tripservice t1, stationservice s1) {
        this.adminservice = adminservice;
        this.t1 = t1;
        this.s1 = s1;
    }

    @GetMapping
    public List<admin> hello()
    {
        return  adminservice.admins();
    }
    @RequestMapping(method = RequestMethod.GET,path = "/adminbyid")
    public int adminbyid()
    {
        return  adminservice.adminbyid();
    }
    @RequestMapping(method = RequestMethod.GET,path = "/adminbyemail")
    public String adminbyemail()
    {
        return  adminservice.adminbyemail();
    }
    @RequestMapping(method = RequestMethod.GET,path = "/adminbypass")
    public String adminbypass()
    {
        return  adminservice.adminbypass();
    }
    @RequestMapping(method = RequestMethod.POST,path = "/signup")
    public String signup(@RequestBody admin s)
    {

        return adminservice.signup(s);


    }
    @RequestMapping(method = RequestMethod.POST,path = "/signin")
    public String signin(@RequestBody admin s)
    {
            return adminservice.signin(s);
    }
    @RequestMapping(method = RequestMethod.POST,path = "/createtrip")
    public String createtrip(@RequestBody trip s)
    {

        t1.addtrip(s);
        return "Trip created successfully by admin ";


    }
    @RequestMapping(method = RequestMethod.GET,path = "/getalltrips")
    public List<trip> getalltrips()
    {


        return t1.getalltrips();


    }
    @RequestMapping(method = RequestMethod.GET,path = "/getallstations")
    public List<station> getallstations()
    {


        return  s1.getallstations();
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/deletebyid/{idd}")
    public String deletetrip(@PathVariable int idd)
    {

        return t1.deletetripByid(idd);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT,path = "/updatebyid/{idd}")
    public String updatetrip(@RequestBody trip t,@PathVariable int idd)
    {

        return t1.updatetripByid(idd,t);
    }



}
