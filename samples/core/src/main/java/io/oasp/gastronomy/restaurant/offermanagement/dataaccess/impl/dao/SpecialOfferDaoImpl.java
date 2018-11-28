package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static com.querydsl.core.alias.Alias.$;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.querydsl.core.alias.Alias;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialOfferDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * @author ADLAGODA
 *
 */
public class SpecialOfferDaoImpl extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialOfferDao {

  @Override
  protected Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

  @Override
  public PaginatedListTo<SpecialEntity> findSpecialOffers(SpecialSearchCriteriaTo criteria) {

    SpecialEntity special = Alias.alias(SpecialEntity.class);
    EntityPathBase<SpecialEntity> alias = $(special);
    JPAQuery<SpecialEntity> query = new JPAQuery<SpecialEntity>(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where($(special.getName()).eq(name));
    }

    LocalDateTime dateOfCheckingOffers = criteria.getDateOfCheckingOffers();
    if (dateOfCheckingOffers != null) {
      DayOfWeek dayOfWeek = dateOfCheckingOffers.getDayOfWeek();
      int hour = dateOfCheckingOffers.getHour();

      Predicate startPredicate = $(special.getActivePeriod().getStartingDay()).lt(dayOfWeek)
          .or($(special.getActivePeriod().getStartingDay()).eq(dayOfWeek)
              .and($(special.getActivePeriod().getStartingHour()).loe(hour)));

      Predicate endPredicate = $(special.getActivePeriod().getEndingDay()).gt(dayOfWeek)
          .or($(special.getActivePeriod().getEndingDay()).eq(dayOfWeek)
              .and($(special.getActivePeriod().getEndingHour()).goe(hour)));
      query.where(startPredicate).where(endPredicate);
    }

    Long offerNumber = criteria.getOfferNumber();
    if (offerNumber != null) {
      query.where($(special.getOfferId()).eq(offerNumber));
    }

    return findPaginated(criteria, query);
  }
}
