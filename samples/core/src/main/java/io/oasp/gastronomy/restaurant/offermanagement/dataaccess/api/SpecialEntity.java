package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;

/**
 * @author ADLAGODA
 *
 */
@Entity
@Table(name = "Special")
public class SpecialEntity extends ApplicationPersistenceEntity implements Special {

  private static final long serialVersionUID = 1L;

  private String name;

  private OfferEntity offer;

  private WeeklyPeriod activePeriod;

  private Money specialPrice;

  /**
   * @return name
   */
  @Column(unique = true)
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offer
   */
  @ManyToOne
  @JoinColumn(name = "offerId")
  public OfferEntity getOfferEntity() {

    return this.offer;
  }

  /**
   * @param offer new value of {@link #getoffer}.
   */
  public void setOfferEntity(OfferEntity offer) {

    this.offer = offer;
  }

  /**
   * @return activePeriod
   */
  @Embedded
  public WeeklyPeriod getActivePeriod() {

    return this.activePeriod;
  }

  /**
   * @return specialPrice
   */
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * @param specialPrice new value of {@link #getspecialPrice}.
   */
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

  @Override
  public void setActivePeriod(WeeklyPeriod weeklyPeriod) {

    if (weeklyPeriod != null) {
      this.activePeriod = new WeeklyPeriodEmbeddable();
      this.activePeriod.setStartingDay(weeklyPeriod.getStartingDay());
      this.activePeriod.setStartingHour(weeklyPeriod.getStartingHour());
      this.activePeriod.setEndingDay(weeklyPeriod.getEndingDay());
      this.activePeriod.setEndingHour(weeklyPeriod.getEndingHour());

    }
  }

  @Override
  @Transient
  public Long getOfferId() {

    return this.offer != null ? this.offer.getId() : null;
  }

  @Override
  public void setOfferId(Long offerId) {

    this.offer = new OfferEntity();
    this.offer.setId(offerId);
  }
}
