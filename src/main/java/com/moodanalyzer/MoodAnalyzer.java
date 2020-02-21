package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String mood;

    //Default Constructor
    public MoodAnalyzer(){
        mood="defualt";
    }

    //Parameterized Constructor
    public MoodAnalyzer(String mood) {
        this.mood=mood;
    }

    public String analyzeMood(){
        try {
            if (mood.contains("sad")) {
                return "sad";
            }
            else if(mood.isEmpty()){
                throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.EMPTY_MESSAGE,"Please Enter Valid String");
            }
            return "happy";
        }
        catch (NullPointerException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NULL_MESSAGE,"Please Enter Valid Message");
        }
    }
    public boolean equals(Object another){
        if(this.mood.equals(((MoodAnalyzer) another).mood))
            return true;
        return false;
    }
}
