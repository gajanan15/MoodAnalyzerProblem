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
    public void givenTsetMoodIsNull_WhenProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.NULL_MESSAGE,e.type);
        }
    }

    @Test
    public void givenTestEmptyMood_WhenProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.EnumExceptionType.EMPTY_MESSAGE,e.type);
        }

    }
}
