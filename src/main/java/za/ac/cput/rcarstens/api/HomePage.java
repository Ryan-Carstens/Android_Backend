package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chantell witbooi on 8/22/2016.
 */
@RestController
@RequestMapping("/")
public class HomePage {
    @Autowired
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is the RecruitMe Home Page";
    }

}
