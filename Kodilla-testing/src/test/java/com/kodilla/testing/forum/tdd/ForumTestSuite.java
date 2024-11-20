package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the begining of the test");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All test finished");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Nested
    @DisplayName("Test for comments")
    class TestComments {
        //Test1 sprawdzający, czy po dodaniu nowego postu liczba postów wynosi 1.
        @Test
        void testAddPost() {

            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            //When
            forumUser.addPost("mrSmith", "Hello everyone this is my first contribution here!");
            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        //Test 2: sprawdzający, czy po dodaniu nowego komentarza liczba komentarzy wynosi 1.
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone this is my first contribution here!", "mrSmith");

            //When
            forumUser.addComment(thePost, "mrSmith", "Thank you all for good words!");
            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        //Test 3: sprawdzający, czy post pobrany z klasy ForumUser jest taki sam jak post,
        // który był wstawiany do klasy.
        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " + "this is my first contribution here!", "mrSmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());
            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        //Test 4: sprawdzający, czy komentarz pobrany z klasy ForumUser jest taki sam jak komentarz,
        // który był wstawiany do klasy.
        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " + "this is my first contribution here!", "mrSmith");
            ForumComment theComment = new ForumComment(thePost, "mrSmith", "Thank you  for all good Words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);

        }


        @Nested
        @DisplayName("Test for posts")
        class TestsPosts {
            //Test 5: sprawdzający, czy próba usunięcia nieistniejącego posta skończy się zwróceniem wyniku false.
            @Test
            void testRemovePostNotExisting() {
                //Given
                ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
                ForumPost thePost = new ForumPost("Hello everyone, " + "this is my first contribution here!", "mrSmith");

                //When
                boolean result = forumUser.removePost(thePost);

                //Then
                Assertions.assertTrue(result);
            }

            //Test 6: sprawdzający, czy próba usunięcia nieistniejącego komentarza skończy się zwróceniem wyniku false.
            @Test
            void testRemoveCommentNotExisting() {
                //Given
                ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
                ForumPost thePost = new ForumPost("Hello everyone, " + "this is my first contribution here!", "mrSmith");
                ForumComment theComment = new ForumComment(thePost, "mrsmith",
                        "Thank you for all good words!");

                //When
                boolean result = forumUser.removeComment(theComment);

                //Then
                Assertions.assertTrue(result);
            }

            //Test 7: weryfikujący, czy udało się usunąć wybrany post z klasy.
            @Test
            void testRemovePost() {
                //Given
                ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
                ForumPost thePost = new ForumPost("Hello everyone, " +
                        "this is my first contribution here!", "mrsmith");
                forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

                //When
                boolean result = forumUser.removePost(thePost);

                //Then
                Assertions.assertTrue(result);
                Assertions.assertEquals(0, forumUser.getPostsQuantity());
            }

            //Test 8: weryfikujący, czy udało się usunąć wybrany komentarz z klasy.
            @Test
            void testRemoveComment() {
                //Given
                ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
                ForumPost thePost = new ForumPost("Hello everyone, " +
                        "this is my first contribution here!", "mrsmith");
                ForumComment theComment = new ForumComment(thePost, "mrsmith",
                        "Thank you for all good words!");
                forumUser.addComment(thePost, theComment.getAuthor(),
                        theComment.getCommentBody());
                //When
                boolean result = forumUser.removeComment(theComment);

                //Then
                Assertions.assertTrue(result);
                Assertions.assertEquals(0, forumUser.getCommentsQuantity());

            }
        }
    }
}