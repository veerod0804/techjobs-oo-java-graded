package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job jobOne = new Job();
        Job jobTwo = new Job();

       assertNotEquals(jobOne.getId(), jobTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(newJob instanceof Job);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(newJob.getName().toString(), "Product tester");
        assertEquals(newJob.getEmployer().toString(), "ACME");
        assertEquals(newJob.getLocation().toString(), "Desert");
        assertEquals(newJob.getPositionType().toString(), "Quality control");
        assertEquals(newJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(jobOne.equals(jobTwo));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        char firstChar = jobOne.toString().charAt(0);
        char lastChar = jobOne.toString().charAt(jobOne.toString().length() - 1);
        assertEquals(firstChar, '\n');
        assertEquals(lastChar, '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\n" +
                "ID: " + jobOne.getId() + '\n' +
                "Name: " + jobOne.getName() + '\n' +
                "Employer: " + jobOne.getEmployer() + '\n' +
                "Location: " + jobOne.getLocation() + '\n' +
                "Position Type: " + jobOne.getPositionType() + '\n' +
                "Core Competency: " + jobOne.getCoreCompetency() + '\n';
        String actual = jobOne.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job jobOne = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = "\n" +
                "ID: 1" + '\n' +
                "Name: Data not available" + '\n' +
                "Employer: Data not available" + '\n' +
                "Location: Data not available" + '\n' +
                "Position Type: Data not available" + '\n' +
                "Core Competency: Data not available" + '\n';
        String actual = jobOne.toString();
        assertEquals(expected, actual);
    }
}
