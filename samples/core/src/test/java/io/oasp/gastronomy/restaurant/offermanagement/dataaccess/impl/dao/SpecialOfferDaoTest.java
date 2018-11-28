package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import java.time.DayOfWeek;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialOfferDao;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author ADLAGODA
 *
 */
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialOfferDaoTest extends ComponentTest {

  private final String NAME = "name";

  private final Number VALUE = 150.0;

  @Inject
  SpecialOfferDao specialDao;

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  public void testPersist() {

    SpecialEntity entity = createSpecial();
    assertThat(entity.getId()).isNull();
    this.specialDao.save(entity);
    assertThat(entity.getId()).isNotNull();
    SpecialEntity loadedEntity = this.specialDao.findOne(entity.getId());
    assertThat(entity).isEqualTo(loadedEntity);
  }

  @Test
  public void testfindSpecialOffers() {

  }

  /**
   * @return
   */
  private SpecialEntity createSpecial() {

    SpecialEntity entity = new SpecialEntity();
    WeeklyPeriodEmbeddable activePeriod = createActivePeriod();
    entity.setActivePeriod(activePeriod);
    entity.setName(this.NAME);
    entity.setSpecialPrice(new Money(this.VALUE));
    return entity;
  }

  /**
   * @return
   */
  private WeeklyPeriodEmbeddable createActivePeriod() {

    WeeklyPeriodEmbeddable activePeriod = new WeeklyPeriodEmbeddable();
    activePeriod.setStartingDay(DayOfWeek.TUESDAY);
    activePeriod.setStartingHour(10);
    activePeriod.setEndingDay(DayOfWeek.FRIDAY);
    activePeriod.setEndingHour(12);
    return activePeriod;
  }
}
