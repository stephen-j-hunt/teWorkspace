package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao dao;

    @Before
    public void setup() {
        dao = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = dao.getPark(PARK_1.getParkId());
        assertParksMatch(PARK_1, park);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park park = dao.getPark(-1);
        Assert.assertNull("no park should be returned", park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = dao.getParksByState("AA");
        Assert.assertEquals("there should be two parks", 2, parks.size());
        assertParksMatch(PARK_1, parks.get(0));
        assertParksMatch(PARK_3, parks.get(1));
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parks = dao.getParksByState("XX");
        Assert.assertEquals("no parks should be returned",0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        final Park testPark = new Park(0, "as;dlfkja;s", LocalDate.now(), 1, false);
        Park createdPark = dao.createPark(testPark);
        int idOfCreatedPark = createdPark.getParkId();
        Assert.assertTrue("no ID was assigned by the DB", idOfCreatedPark > 0);

        testPark.setParkId(idOfCreatedPark);
        assertParksMatch(testPark, createdPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        // arrange
        Park parkToUpdate = dao.getPark(1);
        parkToUpdate.setParkName("armleter park");
        parkToUpdate.setDateEstablished(parkToUpdate.getDateEstablished().plusDays(2));
        parkToUpdate.setArea(parkToUpdate.getArea()*2);
        parkToUpdate.setHasCamping(!parkToUpdate.getHasCamping());

        // act
        dao.updatePark(parkToUpdate);

        // assert
        Park actual = dao.getPark(parkToUpdate.getParkId());
        assertParksMatch(parkToUpdate, actual);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        dao.deletePark(2);
        Park retrievedPark = dao.getPark(2);
        Assert.assertNull(retrievedPark);

        List<Park> parks = dao.getParksByState("BB");
        Assert.assertEquals(0, parks.size());
    }

    @Test()
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        dao.addParkToState(PARK_3.getParkId(), "BB");
        List<Park> parks = dao.getParksByState("BB");

        // this is not necessary because we have tests for getParksByState()
        //        Assert.assertEquals(2, parks.size());
        //        assertParksMatch(PARK_2, parks.get(0));
        //        assertParksMatch(PARK_3, parks.get(1));

        // is the park in the list of returned parks
        for (Park p : parks) {
            if (p.getParkId() == PARK_3.getParkId()) return;
        }

        // if we get here, the park was not found in the list
        Assert.fail("the park was not assigned to the state");
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        dao.removeParkFromState(3, "AA");
        List<Park> parks = dao.getParksByState("AA");
        Assert.assertEquals(1, parks.size());

        for (Park p : parks) {
            if (p.getParkId() == PARK_3.getParkId()) {
                Assert.fail("park 3 should not be in list");
            }
        }

    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
