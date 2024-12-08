package com.kodilla.testing.forum.statistics;

import java.util.Objects;

public class CalculateVariousStatistics {

    private Statistics statistics;

    public CalculateVariousStatistics(Statistics statistics) {
        this.statistics = statistics;
    }
    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public CalculateVariousStatistics(int usersCount, int postsCount, double averagePostsPerUser,
                                      int commentsCount, double averageCommentsPerUser,
                                      double averageCommentsPerPost) {
        this.usersCount = usersCount;
        this.postsCount = postsCount;
        this.averagePostsPerUser = averagePostsPerUser;
        this.commentsCount = commentsCount;
        this.averageCommentsPerUser = averageCommentsPerUser;
        this.averageCommentsPerPost = averageCommentsPerPost;
    }

    public int getUsersCount() {
        return usersCount;
    }


    public int getPostsCount() {
        return postsCount;
    }


    public int getCommentsCount() {
        return commentsCount;
    }



    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }



    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }



    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }




    void calculateAdvStatistics(Statistics statistics) {

        usersCount = statistics.userNames() != null ? statistics.userNames().size() : 0;
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        averagePostsPerUser = usersCount > 0 ? (double) postsCount / usersCount : 0;
        averageCommentsPerUser = usersCount > 0 ? (double) commentsCount / usersCount : 0;
        averageCommentsPerPost = postsCount > 0 ? (double) commentsCount / postsCount : 0;

    }

    void showStatistics() {

        System.out.println(" Forum Statistics: ");
        System.out.println("Users Count: " + usersCount);
        System.out.println("Posts Count: " + postsCount);
        System.out.println("Comments Count: " + commentsCount);
        System.out.println("AveragePostsPerUser: " + averagePostsPerUser);
        System.out.println("AverageCommentsPerUser: " + averageCommentsPerUser);
        System.out.println("AverageCommentsPerPost: " + averageCommentsPerPost);

    }
}