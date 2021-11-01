package com.waytohey.tests;

import com.waytohey.enums.Interests;
import com.waytohey.pages.LoginWindow;
import com.waytohey.pages.MessagePage;
import com.waytohey.pages.ProfilePage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParametrizedTestsProfile extends TestBase {
    LoginWindow loginPage = new LoginWindow();
    MessagePage messagePage = new MessagePage();
    ProfilePage profilePage = new ProfilePage();

    @ValueSource(strings = {
            "Valentina",
            "ella"
    })
    @ParameterizedTest(name = "Search {0} in contact list")
    public void testSearchInContactList(String searchString) {
        loginPage.login("sedr", "654303");
        messagePage.openMessageWindow();
        messagePage.searchContacts(searchString);
        messagePage.checkResultsOfSearch(searchString);
    }

    @CsvSource(value = {
            "Valentina, 1",
            "Ella, 1"
    })
    @ParameterizedTest(name = "Search {0} in contact list")
    public void testSearchAndCheckCountOfUsersInList(String searchString, int count) {
        loginPage.login("sedr", "654303");
        messagePage.openMessageWindow();
        messagePage.searchContacts(searchString);
        messagePage.checkResultsOfSearch(searchString);
        messagePage.checkCountOfUsers(count);
    }

    @EnumSource(Interests.class)
    @ParameterizedTest(name = "Add interest {0} in profile")
    public void testAddInterest(Interests interest) {
        loginPage.login("sedr", "654303");
        profilePage.selectInterest(interest)
                .checkThatInterestAdd(interest);
    }


    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Working", "Hello", Interests.FAMILY
                ),
                Arguments.of(
                        "Traveling", "I'm a good boy", Interests.YOGA
                )
        );
    }


    @MethodSource("testWithMethodSource")
    @ParameterizedTest(name = "Fill profile status: {0}, aboutMe: {1}, interest: {2}")
    void testChangeProfileInformation(String status, String aboutMe, Interests interest) {
        loginPage.login("sedr", "654303");
        profilePage.changeStatus(status)
                .checkStatus(status);
        profilePage.changeAboutMe(aboutMe)
                .checkAboutMe(aboutMe);
        profilePage.selectInterest(interest)
                .checkThatInterestAdd(interest);
    }
}


