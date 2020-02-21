package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static  String invokeMethod (String message ,String className,String methodName)
    {
        try{
            Class<?> aClass = Class.forName(className);
            Object obj = aClass.getConstructor(String.class).newInstance(message);
            Method declaredMethod = aClass.getMethod(methodName);
            return  (String) declaredMethod.invoke(obj);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
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

}
