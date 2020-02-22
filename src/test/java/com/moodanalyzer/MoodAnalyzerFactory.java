package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {

    public static Constructor<?>getConstructor(String className,Class parm) throws MoodAnalyzerException{
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(parm);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.getMessage());
        }
    }

    public static  String invokeMethod (MoodAnalyzer obj,String methodName)
    {
        try{
            return  (String) obj.getClass().getMethod(methodName).invoke(obj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyzer() {
        try {
            Constructor<?> moodConstructor = Class.forName("com.moodanalyzer.MoodAnalyzer").getConstructor();
            Object myObj = moodConstructor.newInstance();
            return (MoodAnalyzer)myObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

        public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Constructor<?> moodConstructor = Class.forName("com.moodanalyzer.MoodAnalyzer").getConstructor(String.class);
            Object myObj = moodConstructor.newInstance(message);
            return (MoodAnalyzer)myObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String setFieldValue(MoodAnalyzer obj,String message, String mood) {
        try {
            Field field = obj.getClass().getDeclaredField(mood);
            field.setAccessible(true);
            field.set(obj,message);
            return  (String) obj.getClass().getMethod("analyzeMood").invoke(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.OBJECT_CREATION_ISSUE,e.getMessage());
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NO_SUCH_FIELD,e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
