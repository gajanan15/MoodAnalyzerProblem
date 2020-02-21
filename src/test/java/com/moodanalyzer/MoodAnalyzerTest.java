package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalyzerException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenTestMoodIsSad_WhenProper_ShouldReturnSad(){
        String mood;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("sad",mood);

        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTestMoodIsHappy_WhenProper_ShouldReturnHappy(){
        String mood;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in happy mood");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("happy",mood);

        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenTestMoodIsNull_WhenProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NULL_MESSAGE,e.type);
        }
    }

    @Test
    public void givenTestEmptyMood_WhenProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.EMPTY_MESSAGE,e.type);
        }
    }

    @Test
    public void givenTestMoodAnalyzerClassName_ShouldReturnMoodAnalyzerObject() {
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
    public void givenTestMoodAnalyzerObjectWithParameter_ShouldReturnMoodAnalyzerObject() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("i am in happy mood");
            Assert.assertEquals(new MoodAnalyzer("i am in happy mood"), moodAnalyzer);
        }catch (MoodAnalyzerException e){
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_WithReflection_ShouldReturnHappy() {
        try {
            String analyzeMood = MoodAnalyzerFactory.invokeMethod("i am in happy mood", "com.moodanalyzer.MoodAnalyzer","analyzeMood");
            Assert.assertEquals("happy",analyzeMood);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenHappyMessage_WithReflectionImproperMethod_ShouldReturnHappy() {
        try{
            String analyzeMood = MoodAnalyzerFactory.invokeMethod("i am in happy mood", "com.moodanalyzer.MoodAnalyzer","analyzeMood1");
        }catch (MoodAnalyzerException e){
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }
}
