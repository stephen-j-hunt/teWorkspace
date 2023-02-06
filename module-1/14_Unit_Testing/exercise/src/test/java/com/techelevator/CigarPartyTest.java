package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CigarPartyTest {

    @Test
    public void seventyCigarsAndISWeekendShouldReturnTrue() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(70, true);
        Assert.assertTrue("true", partyResult);

    }

    @Test
    public void seventyCigarsAndISWeekendFalseShouldReturnError() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(70, false);
        Assert.assertFalse("false", partyResult);
    }

    @Test
    public void FiftyCigarsAndISWeekendFalseShouldReturnTrue() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(50, false);
        Assert.assertTrue("true", partyResult);
    }

    @Test
    public void thirtyCigarsAndISWeekendFalseShouldReturnFalse() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(30, false);
        Assert.assertFalse("false", partyResult);
    }

    @Test
    public void SixtyCigarsAndISWeekendFalseShouldReturnTrue() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(60, false);
        Assert.assertTrue("true", partyResult);
    }

    @Test
    public void FortyCigarsAndISWeekendFalseShouldReturnTrue() {
        CigarParty party = new CigarParty();
        final boolean partyResult = party.haveParty(40, false);
        Assert.assertTrue("true", partyResult);
    }
}



