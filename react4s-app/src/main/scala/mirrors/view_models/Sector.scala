package mirrors.view_models

import scala.language.implicitConversions

sealed trait Sector{
  def * (number: Int): SegmentSpan = SegmentSpan(Seq.fill(number)(Segment(this)))
}

object Sector{

  implicit def toSpan(sector: Sector): SegmentSpan = SegmentSpan(Segment(sector))

  case object A extends Sector
  case object B extends Sector
  case object C extends Sector
  case object D extends Sector
  case object E extends Sector
  case object F extends Sector
  case object Empty extends Sector
}
