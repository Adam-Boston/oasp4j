package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import java.time.DayOfWeek;

/**
 * @author ADLAGODA
 *
 */
public interface WeeklyPeriod {
  DayOfWeek getStartingDay();

  /**
   * @param startingDay
   */
  void setStartingDay(DayOfWeek startingDay);

  /**
   * @return
   */
  int getStartingHour();

  /**
   * @param startingHour
   */
  void setStartingHour(int startingHour);

  /**
   * @return
   */
  DayOfWeek getEndingDay();

  /**
   * @param endingDay
   */
  void setEndingDay(DayOfWeek endingDay);

  /**
   * @return
   */
  int getEndingHour();

  /**
   * @param endinggHour
   */
  void setEndingHour(int endinggHour);
}
