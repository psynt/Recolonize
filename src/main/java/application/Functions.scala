package application

import skills.XPRates

/**
  * Created by nichita on 03.12.2016.
  */
object Functions {

  def min(a:Int , b:Int):Int = {
    if(a<b) a
    else b
  }

  def FindToXp(a:Int):Int = a match {
    case 0 => XPRates.RAT_FOUND;
    case 1 => XPRates.UNC_FOUND;
    case 2 => XPRates.WEP_FOUND;
    case 3 => XPRates.SURV_FOUND;
  }
}
