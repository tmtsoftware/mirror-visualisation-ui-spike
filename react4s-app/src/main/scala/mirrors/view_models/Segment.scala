package mirrors.view_models

case class Segment(sector: Sector){
  def * (number: Int): SegmentSpan = SegmentSpan(Seq.fill(number)(this.copy(sector)))
}