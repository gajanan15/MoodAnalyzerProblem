package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

public class MoodAnalyzer {
    private String mood;

    //Default Constructor
    public MoodAnalyzer(){

    }

    //Parameterized Constructor
    public MoodAnalyzer(String mood) {
        this.mood=mood;
    }

    public String analyzeMood() throws MoodAnalyzerException {
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
}
