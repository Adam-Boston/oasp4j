package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.module.basic.common.api.to.AbstractEto;

/**
 * @author ADLAGODA
 *
 */
public class SpecialOfferEto extends AbstractEto implements Special {

  private static final long serialVersionUID = 1L;

  private String name;

  private Money specialPrice;

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  @Override
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

}
