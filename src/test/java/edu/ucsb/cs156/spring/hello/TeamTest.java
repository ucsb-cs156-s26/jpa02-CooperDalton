package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("test-team", team.getName());
    }

    @Test
    public void defaultConstructor_sets_empty_values() {
        Team defaultTeam = new Team();
        assertEquals("", defaultTeam.getName());
        assertTrue(defaultTeam.getMembers().isEmpty());
    }

    @Test
    public void addMember_adds_member_to_list() {
        team.addMember("Cooper");
        assertTrue(team.getMembers().contains("Cooper"));
    }

    @Test
    public void setName_updates_name() {
        team.setName("updated-team");
        assertEquals("updated-team", team.getName());
    }

    @Test
    public void setMembers_updates_members() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Clement");
        members.add("Cooper");

        team.setMembers(members);

        assertEquals(members, team.getMembers());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_same_name_and_members() {
        team.addMember("Cooper");
        Team other = new Team("test-team");
        other.addMember("Cooper");

        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        team.addMember("Cooper");
        Team other = new Team("other-team");
        other.addMember("Cooper");

        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        team.addMember("Cooper");
        Team other = new Team("test-team");
        other.addMember("Clement");

        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_expected_value() {
        team.addMember("Cooper");

        int expected = "test-team".hashCode() | team.getMembers().hashCode();

        assertEquals(expected, team.hashCode());
    }

}
