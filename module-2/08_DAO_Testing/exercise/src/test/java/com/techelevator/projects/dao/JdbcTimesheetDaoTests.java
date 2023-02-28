package com.techelevator.projects.dao;

//import com.techelevator.projects.model.Timesheet;
import com.techelevator.projects.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;
    Timesheet testTimesheet = new Timesheet(3,2,2,LocalDate.now(),3.0,false, "Timesheet 5");


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = dao.getTimesheet(TIMESHEET_1.getTimesheetId());
        assertTimesheetsMatch(TIMESHEET_1, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = dao.getTimesheet(-1);
        Assert.assertNull( timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheet = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals("return id", 2, timesheet.size());
        assertTimesheetsMatch(TIMESHEET_1,timesheet.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheet.get(1));


    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals("should be 3", 3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));

    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);
        int idOfCreatedTimesheet = createdTimesheet.getTimesheetId();
        Assert.assertTrue("no id given", idOfCreatedTimesheet>0);
        testTimesheet.setTimesheetId(idOfCreatedTimesheet);
        assertTimesheetsMatch(testTimesheet, createdTimesheet);

    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);
        Integer newId= createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = dao.getTimesheet(newId);
        assertTimesheetsMatch(createdTimesheet,retrievedTimesheet);
        /////error/////////////////
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = dao.getTimesheet(1);
        timesheetToUpdate.setEmployeeId(2);
        timesheetToUpdate.setProjectId(2);
        timesheetToUpdate.setDateWorked(LocalDate.parse("2021-01-03"));
        timesheetToUpdate.setHoursWorked(2);
        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDescription("Timesheet 5");
        dao.updateTimesheet(timesheetToUpdate);
        Timesheet retrieved = dao.getTimesheet(timesheetToUpdate.getTimesheetId());
        assertTimesheetsMatch(timesheetToUpdate, retrieved);

    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        dao.deleteTimesheet(1);
        Timesheet retrievedTimesheet = dao.getTimesheet(1);
        Assert.assertNull(retrievedTimesheet);
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double getHours = dao.getBillableHours(2,2);
        Assert.assertEquals("should return 2",0.0, getHours,0);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
