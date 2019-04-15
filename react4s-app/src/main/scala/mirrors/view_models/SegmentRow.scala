package mirrors.view_models

import scala.language.implicitConversions

case class SegmentRow(spans : Seq[SegmentSpan]){
  def + (newSpan: SegmentSpan): SegmentRow = {
    SegmentRow(spans :+ newSpan)
  }
}

object SegmentRow{
  def apply(span: SegmentSpan): SegmentRow = new SegmentRow(Seq(span))
  implicit def fromSegmentSpan(span: SegmentSpan): SegmentRow = SegmentRow(span)
}