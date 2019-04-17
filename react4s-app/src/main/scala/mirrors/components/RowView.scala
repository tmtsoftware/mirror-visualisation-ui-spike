package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.view_models.SegmentRow

case class RowView(row: P[SegmentRow], index: P[Int]) extends Component[NoEmit] {

  val width = 22.0

  override def render(get: Get): Node = {
    val mirrorRow = get(row)
    val isOdd = get(index) % 2 == 0
    val leftOffset = 12 - (mirrorRow.spans.flatMap(_.segments).length / 2)
    E.div(
      A.className("row " + (if (isOdd) "odd" else "")),
      S.paddingLeft(s"${leftOffset * width}px"),
      Tags(mirrorRow.spans.map(span =>
        Component(SpanView, span)
          .withKey(UUID.randomUUID().toString)
      )
      )
    )
  }
}
