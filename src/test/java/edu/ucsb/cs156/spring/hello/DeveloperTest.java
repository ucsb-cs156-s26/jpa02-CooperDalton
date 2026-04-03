package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Cooper", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("cooperdalton", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-09", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team t = Developer.getTeam();
        assertEquals(6, t.getMembers().size());
        assertTrue(t.getMembers().contains("Clement"), "Team should contain Clement");
        assertTrue(t.getMembers().contains("Cooper"), "Team should contain Cooper");
        assertTrue(t.getMembers().contains("Nathan Q"), "Team should contain Nathan Q");
        assertTrue(t.getMembers().contains("Parth"), "Team should contain Parth");
        assertTrue(t.getMembers().contains("Ritam"), "Team should contain Ritam");
        assertTrue(t.getMembers().contains("Ryan"), "Team should contain Ryan");
    }

}
