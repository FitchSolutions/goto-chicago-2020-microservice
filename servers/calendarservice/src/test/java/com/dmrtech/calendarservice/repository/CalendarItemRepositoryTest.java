package com.dmrtech.calendarservice.repository;

import com.dmrtech.calendarservice.model.CalendarItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CalendarItemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CalendarItemRepository calendarItemRepository;

    @Test
    public void whenFindByIDthenReturnCalendarItem() {
        // given
        CalendarItem calendarItem = new CalendarItem(getNewYearsDay(2000),
                true,
                "new years",
                "new millenium details");
        entityManager.persist(calendarItem);
        entityManager.flush();

        // when
        //CalendarEvent found =
        Optional<CalendarItem> returned = calendarItemRepository.findById(calendarItem.getID());

        // then
        assertThat(returned.isPresent(), is(equalTo(true)));
    }

    @Test
    public void whenFindAllthenReturnAllItems() {
        // given
        for(int i = 0; i < 10; i++) {
            CalendarItem calendarItem = new CalendarItem(getNewYearsDay(2000),
                    true,
                    "new years",
                    "new millenium details");
            entityManager.persist(calendarItem);
            entityManager.flush();
        }

        // when
        //CalendarEvent found =
        Iterable<CalendarItem> results = calendarItemRepository.findAll();

        int count = 0;
        for(CalendarItem currentEvent:results) {
            count++;
        }

        // then
        assertThat(count, is(equalTo(10)));
    }

    private Date getNewYearsDay(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

}