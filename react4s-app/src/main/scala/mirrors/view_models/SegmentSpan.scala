package mirrors.view_models

import scala.language.implicitConversions

case class SegmentSpan(segments: Seq[Segment]) {
  def + (span: SegmentSpan): SegmentRow = {
    SegmentRow(Seq(SegmentSpan(segments), span))
  }
}

object SegmentSpan {
  def apply(segment: Segment): SegmentSpan = new SegmentSpan(Seq(segment))
}