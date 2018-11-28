package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.time.LocalDateTime;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * @author ADLAGODA
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String name;

  private Long offerNumber;

  private LocalDateTime dateOfCheckingOffers;

  /**
   * @return name
   */
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
   * @return offerNumber
   */
  public Long getOfferNumber() {

    return this.offerNumber;
  }

  /**
   * @param offerNumber new value of {@link #getofferNumber}.
   */
  public void setOfferNumber(Long offerNumber) {

    this.offerNumber = offerNumber;
  }

  /**
   * @return dateOfCheckingOffers
   */
  public LocalDateTime getDateOfCheckingOffers() {

    return this.dateOfCheckingOffers;
  }

  /**
   * @param dateOfCheckingOffers new value of {@link #getdateOfCheckingOffers}.
   */
  public void setDateOfCheckingOffers(LocalDateTime dateOfCheckingOffers) {

    this.dateOfCheckingOffers = dateOfCheckingOffers;
  }

}
