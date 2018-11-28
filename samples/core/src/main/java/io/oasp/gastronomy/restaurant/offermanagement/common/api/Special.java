package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * @author ADLAGODA
 *
 */
public interface Special extends ApplicationEntity {
  /**
   * @return
   */
  String getName();

  /**
   * @param name
   */
  void setName(String name);

  /**
   * @return
   */
  Long getOfferId();

  /**
   * @param offer
   */
  void setOfferId(Long offer);

  /**
   * @return
   */
  WeeklyPeriod getActivePeriod();

  /**
   * @param weeklyPeriod
   */
  void setActivePeriod(WeeklyPeriod weeklyPeriod);

  /**
   * @return
   */
  Money getSpecialPrice();

  /**
   * @param weeklyPeriod
   */
  void setSpecialPrice(Money money);

}
