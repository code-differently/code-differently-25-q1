package com.codedifferently.lesson16.oliviajames;

  import java.util.ArrayList;
  import java.util.List;

public class MakeupRoutine {
    public enum MakeupLook {
            DEWY,
            NATURAL,
            FULL_GLAM,
            SOFT_GLAM,
    }
      
    // Member Variables
    private String name;
    private int durationMinutes;
    private boolean usesPrimer;
    private ArrayList<String> steps;
    private MakeupLook lookType;

    // Constructor
    public MakeupRoutine(String name, int durationMinutes, boolean usesPrimer, MakeupLook lookType) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.usesPrimer = usesPrimer;
        this.lookType = lookType;
    }

    // Function using condition
    public String checkPrimerStep() {
        return usesPrimer ? "Primer included in routine." : "No primer used in this routine.";
    }

    // Function using collection
    public void addStep(String step) {
        steps.add(step);
    }

    // Function using loop
    public void printRoutineSteps() {
        for (String step : steps) {
            System.out.println(step);
        }
    }

    // Function using custom exception
    public void validateSteps() throws StepMissingException {
        if (steps == null || steps.isEmpty()) {
            throw new StepMissingException("No steps in this makeup routine!");
        }
    }

    // Getters for testing
    
    
    
    public String getName() { 
    return name;
    }
    public int getDurationMinutes() { 
        return durationMinutes;
    }

    public boolean isUsesPrimer() {
    return usesPrimer;
     }
    public ArrayList<String> getSteps() { 
        return steps; 
        }
    public MakeupLook getLookType() { 
        return lookType;
         }




    //make class 
}  
