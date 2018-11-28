package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

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
  Money getSpecialPrice();

  /**
   * @param specialPrice
   */
  void setSpecialPrice(Money specialPrice);
}
