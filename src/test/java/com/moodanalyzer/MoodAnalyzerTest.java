package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenTestMoodIsSad_WhenProper_ShouldReturnSad(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("sad",mood);

        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTestMoodIsHappy_WhenProper_ShouldReturnHappy(){
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in happy mood");
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("happy",mood);

        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTestMoodIsNull_WhenProper_ShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NULL_MESSAGE,e.type);
        }
    }

    @Test
    public void givenTestEmptyMood_WhenProper_ShouldThrowMoodAnalyserException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.EMPTY_MESSAGE,e.type);
        }
    }

    //Reflection
    @Test
    public void givenTestMoodAnalyzerClassNameUsingDefaultConstructor_WhenProper_ShouldReturnObject() {
        try{
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            Assert.assertEquals(new MoodAnalyzer(),moodAnalyzer);
        }catch (MoodAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalysisException() {
        try{
            MoodAnalyzerFactory.getConstructor("com.moodanalyzer.MoodAnalyzer1",String.class);
        }catch(MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerConstructor_NotProper_ShouldThrowMoodAnalysisException() {
        try{
            MoodAnalyzerFactory.getConstructor("com.moodanalyzer.MoodAnalyzer",Integer.class);
        }catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenTestMoodAnalyzerObjectWithParameter_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("i am in happy mood");
            Assert.assertEquals(new MoodAnalyzer("i am in happy mood"), moodAnalyzer);
        }catch (MoodAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenProperMethodName_WhenInvoked_ShouldReturnHappy() {
        try {
            MoodAnalyzer moodObj = MoodAnalyzerFactory.createMoodAnalyzer("i am in happy mood");
            String mood=MoodAnalyzerFactory.invokeMethod(moodObj,"analyzeMood");
            Assert.assertEquals("happy",mood);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenMethodName_WhenImproper_ShouldThrowMoodAnalyserException() {
        try{
            MoodAnalyzer moodObj = MoodAnalyzerFactory.createMoodAnalyzer("i am in happy mood");
            String analyzeMood = MoodAnalyzerFactory.invokeMethod(moodObj, "analyzeMood1");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenMethodName_WhenNotProper_ShouldThrowMoodAnalysisExceptionTest1() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
        String mood = MoodAnalyzerFactory.setFieldValue(moodAnalyzer,"i am in happy mood", "mood");
        Assert.assertEquals("happy",mood);
    }

    @Test
    public void givenMethodName_WhenNotProper_ShouldThrowMoodAnalysisExceptionTest2() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            String mood = MoodAnalyzerFactory.setFieldValue(moodAnalyzer,"i am in happy mood", "moodd");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_FIELD,e.type);
        }
    }

    @Test
    public void givenMethodName_WhenNotProper_ShouldThrowMoodAnalysisExceptionTest3() {
        try{
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer();
            String mood = MoodAnalyzerFactory.setFieldValue(moodAnalyzer,null, "mood");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.OBJECT_CREATION_ISSUE,e.type);
        }
    }
}
