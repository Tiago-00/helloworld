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
    
    private double grades[] = {10.5, 12, 14.5,13,18}; 
        private String ucs[] = {"FP","POO","BD","IT2","AC"};


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

    @GetMapping(path = "/author/{fan}",
    produces= MediaType.APPLICATION_JSON_VALUE)
    public String getAuthor(@PathVariable("fan") boolean fan) {
        String f= "";
        String c="";

        if (fan == true) {
           f= "i am"; 
           c= "My favorite club is Sporting.";
        }
         
         else {
             f="im not";
         }
    
        String name = "Tiago Silva";
        int number = 20190878;
        double height = 1.66;
      
        return "Done by " +name+ " with number " +number+". \n" + "I am " +height+ " tall and "+ f + " a fan of football.\n"+c;
    }


    @GetMapping(path = "/grades/average",
    produces= MediaType.APPLICATION_JSON_VALUE)
        public String getGrades(){
        double average = 0;
        for(int i=0;i <grades.length; i++){
            average += grades[i];
        }
        
        return "The averege is: "+average/grades.length;
}

        @GetMapping(path = "/grades/max",
        produces= MediaType.APPLICATION_JSON_VALUE)
            public String getGradess(){
            int max= 0;

            for(int i=0; i <grades.length; i++){
                if(grades[i]>max) {
                max = (int) grades[i];
            }
        }
             return "The maximum grade is: "+ max;
    }  

    @GetMapping(path = "/grades/ucs",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String GetUcs(){
        String Ucs="BD";
        int max= 0;
       
        for(int i=0; i <ucs.length; i++){
            if(ucs[i].equals(Ucs)){
                max = i ;
            }             
        }
                     
        return "The grade is: "+ (grades[max]) +".";
    }

    @GetMapping(path = "/grades/minandmaxgrade",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String MinandMax(){
        double min = 10.5;
        double max = 18;
        int number =0;

        for(int i = 0; i<grades.length; i++){
            if(grades[i]>min && grades[i]<max){

                number++;
            }
        }

        return "There are:"+number +" grades between that numbers.";
    }


    @GetMapping(path = "/grades/allucs",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String AllUcs(){
        String all="";
        for(int i=0; i <grades.length; i++){
           all +=ucs[i]+":"+grades[i]+";\n";
        }

        return all ;
    }



    @GetMapping(path = "/access/{student}/{covid}", 
        produces= MediaType.APPLICATION_JSON_VALUE)
        public boolean getGreeting(@PathVariable("student") boolean isStudent,
            @PathVariable("covid") boolean hasCovid) {
                return isStudent && !(hasCovid);
    
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
