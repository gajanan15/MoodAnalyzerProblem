package com.moodanalyzerexception;

public class MoodAnalyzerException extends RuntimeException{


    public EnumExceptionType type;

    public enum EnumExceptionType{
        EMPTY_MESSAGE,NULL_MESSAGE,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }

    public MoodAnalyzerException(EnumExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
