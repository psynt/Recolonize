package skills

object XCv {

  private class Thou extends XpCurve {
    override def getLevel(xp: Int): Int = {
      xp/1000
    }

    override def xpForLevel(level: Int):Int = {
      level*1000
    }
  }
  private class Cube() extends XpCurve {
    override def getLevel(xp: Int): Int = {
      Math.cbrt(xp).toInt;
    }

    override def xpForLevel(level: Int):Int = {
      level * level * level
    }
  }
  // the factory method
  def apply(): XpCurve = {
    new Cube;

  }
}