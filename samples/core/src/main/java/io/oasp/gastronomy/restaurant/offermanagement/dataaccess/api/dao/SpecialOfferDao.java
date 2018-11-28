package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * @author ADLAGODA
 *
 */
public interface SpecialOfferDao extends ApplicationDao<SpecialEntity>, MasterDataDao<SpecialEntity> {

  PaginatedListTo<SpecialEntity> findSpecialOffers(SpecialSearchCriteriaTo criteria);
}
