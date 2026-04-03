package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Cooper";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "cooperdalton";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("s26-09");
        team.addMember("Clement");
        team.addMember("Cooper");
        team.addMember("Nathan Q");
        team.addMember("Parth");
        team.addMember("Ritam");
        team.addMember("Ryan");
        return team;
    }
}
