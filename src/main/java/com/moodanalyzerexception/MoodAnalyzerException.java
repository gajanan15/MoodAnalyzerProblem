package com.moodanalyzerexception;

public class MoodAnalyzerException extends RuntimeException{


    public EnumExceptionType type;

    public enum EnumExceptionType{
        EMPTY_MESSAGE,NULL_MESSAGE;
    }

    public MoodAnalyzerException(EnumExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
