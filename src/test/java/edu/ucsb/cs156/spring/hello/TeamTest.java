package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;

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
       assert(team.getName().equals("test-team"));
    }

   @Test
   public void toString_returns_correct_string() {
    assertEquals("Team(name=test-team, members=[])", team.toString());
   }

   @Test
    public void equals_same_object_returns_true() {
    assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_different_class_returns_false() {
    assertEquals(false, team.equals("not a team"));
    }

    @Test
    public void equals_same_name_same_members_returns_true() {
    Team t1 = new Team("f26-05");
    t1.addMember("Jarek");
    Team t2 = new Team("f26-05");
    t2.addMember("Jarek");
    assertEquals(true, t1.equals(t2));
    }

    @Test
    public void equals_same_name_different_members_returns_false() {
    Team t1 = new Team("f26-05");
    t1.addMember("Jarek");
    Team t2 = new Team("f26-05");
    t2.addMember("Calvin");
    assertEquals(false, t1.equals(t2));
    }   

    @Test
    public void equals_different_name_same_members_returns_false() {
    Team t1 = new Team("f26-05");
    t1.addMember("Jarek");
    Team t2 = new Team("f26-06");
    t2.addMember("Jarek");
    assertEquals(false, t1.equals(t2));
    }

    @Test
    public void equals_different_name_different_members_returns_false() {
    Team t1 = new Team("f26-05");
    t1.addMember("Jarek");
    Team t2 = new Team("f26-06");
    t2.addMember("Calvin");
    assertEquals(false, t1.equals(t2));
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());     
    }

    @Test
    public void hashCode_specific_mutation_implementation() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}   