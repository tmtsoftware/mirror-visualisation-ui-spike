package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.view_models.SegmentSpan

case class SpanView(span: P[SegmentSpan]) extends Component[NoEmit] {
  override def render(get: Get): Node = {
    E.span(
      Tags(get(span).segments.map(segment =>
        Component(SegmentView, segment)
        .withKey(UUID.randomUUID().toString)
      )
      )
    )
  }
}
