package mirrors.view_models

import java.util.UUID

case class Segment(sector: Sector, uniqueId: String = UUID.randomUUID().toString){
  def * (number: Int): SegmentSpan = SegmentSpan(Seq.fill(number)(this.copy(sector)))
}