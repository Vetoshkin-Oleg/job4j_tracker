package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertFalse;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDublicate() {
        Citizen citizenOne = new Citizen("2f44a", "Petr Arsentev1");
        Citizen citizenTwo = new Citizen("2f44a", "Petr Arsentev2");
        PassportOffice office = new PassportOffice();
        office.add(citizenOne);
        assertFalse(office.add(citizenTwo));
    }
}