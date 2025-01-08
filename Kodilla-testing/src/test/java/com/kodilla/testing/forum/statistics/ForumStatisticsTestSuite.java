package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {


    @Mock
    Statistics statisticsMock = mock(Statistics.class);
    CalculateVariousStatistics calculateVariousStatistics = new CalculateVariousStatistics(statisticsMock);

    @BeforeEach
    void testDataPreparation() {

        MockitoAnnotations.openMocks(this);
    }
        List<String> generateUsersList(int usersCount) {
            List<String> usersList = new ArrayList<>();
            for (int i = 0; i < usersCount; i++) {
                usersList.add("user" + i);
            }
            return usersList;
        }


    @Test
    void testZeroPosts() {
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUsersList(10));
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(5);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateVariousStatistics.getUsersCount());
        assertEquals(0, calculateVariousStatistics.getPostsCount());
        assertEquals(5, calculateVariousStatistics.getCommentsCount());
        assertEquals(0, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(0.5, calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(0, calculateVariousStatistics.getAverageCommentsPerPost());

    }

    @Test
    void testThousandPosts() {
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUsersList(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, calculateVariousStatistics.getUsersCount());
        assertEquals(1000, calculateVariousStatistics.getPostsCount());
        assertEquals(500, calculateVariousStatistics.getCommentsCount());
        assertEquals(10, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(5, calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, calculateVariousStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testZeroComments() {

        //Given
        when(statisticsMock.userNames()).thenReturn(generateUsersList(10));
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateVariousStatistics.getUsersCount());
        assertEquals(50, calculateVariousStatistics.getPostsCount());
        assertEquals(0, calculateVariousStatistics.getCommentsCount());
        assertEquals(5, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(0 , calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(0, calculateVariousStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testMoreCommentsThanPosts() {
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUsersList(10));
        when(statisticsMock.postsCount()).thenReturn(5);
        when(statisticsMock.commentsCount()).thenReturn(50);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(10, calculateVariousStatistics.getUsersCount());
        assertEquals(5, calculateVariousStatistics.getPostsCount());
        assertEquals(50, calculateVariousStatistics.getCommentsCount());
        assertEquals(0.5, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(5, calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(10, calculateVariousStatistics.getAverageCommentsPerPost());
    }

    @Test
    void testWithoutUsers() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.postsCount()).thenReturn(50);
        when(statisticsMock.commentsCount()).thenReturn(25);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, calculateVariousStatistics.getUsersCount());
        assertEquals(50, calculateVariousStatistics.getPostsCount());
        assertEquals(25, calculateVariousStatistics.getCommentsCount());
        assertEquals(0, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(0, calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(0.5, calculateVariousStatistics.getAverageCommentsPerPost());

    }

    @Test
    void testHundredUsers() {
        //Given
        when(statisticsMock.userNames()).thenReturn(generateUsersList(100));
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(5000);

        //When
        calculateVariousStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, calculateVariousStatistics.getUsersCount());
        assertEquals(1000, calculateVariousStatistics.getPostsCount());
        assertEquals(5000, calculateVariousStatistics.getCommentsCount());
        assertEquals(10, calculateVariousStatistics.getAveragePostsPerUser());
        assertEquals(50, calculateVariousStatistics.getAverageCommentsPerUser());
        assertEquals(5, calculateVariousStatistics.getAverageCommentsPerPost());
    }
}
