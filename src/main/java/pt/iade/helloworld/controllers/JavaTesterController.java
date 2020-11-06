package pt.iade.helloworld.controllers;

import java.util.ArrayList;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.iade.helloworld.models.CurricularUnit;



    @RestController
    @RequestMapping(path="/api/java/tester/")
public class JavaTesterController {
    
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);
    private ArrayList<CurricularUnit> units = new ArrayList<CurricularUnit>();
    


    @PostMapping(path = "/units", produces= MediaType.APPLICATION_JSON_VALUE)
        public CurricularUnit saveUnit(@RequestBody CurricularUnit unit) {
        logger.info("Added unit "+unit.getName());
            units.add(unit);
                return unit;
 }

    @GetMapping(path = "/units",
        produces= MediaType.APPLICATION_JSON_VALUE)
        public ArrayList<CurricularUnit> getUnits() {
            logger.info("Get "+units.size()+" Units");
                return units;
    } 

    @GetMapping(path = "/access/{student}/{covid}", 
        produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getGreeting(@PathVariable("student") boolean isStudent,
            @PathVariable("covid") boolean hasCovid) {
                return isStudent && !hasCovid;
    
 }

    @GetMapping(path = "/required/{student}/{temperature}/{classType}",
        produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getRequired(@PathVariable("student") boolean isStudent,
            @PathVariable("temperature") double hasCovid,
            @PathVariable("classType") String type) {
                return isStudent && type.equals("presential") && (hasCovid > 34.5 && hasCovid <37.5 ) ;
     }


     @GetMapping(path = "/evacuation/{fire}/{numberOfCovids}/{powerShutdown}/{comeBackTime}/",
        produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getRequired(@PathVariable("fire") boolean isfire,
            @PathVariable("numberOfCovids") int numberOfCovids,
            @PathVariable("powerShutdown") boolean powerShutdown,
            @PathVariable("comeBackTime") int comeBackTime) {
                return isfire && (numberOfCovids >5 || powerShutdown) && comeBackTime >15;

    }

}





