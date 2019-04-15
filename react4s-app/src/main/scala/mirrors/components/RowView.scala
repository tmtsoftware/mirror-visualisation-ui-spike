package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.view_models.SegmentRow

case class RowView(row: P[SegmentRow], index: P[Int]) extends Component[NoEmit] {

  val width = 22.0
  val height = 26.0

  object RowCss extends CssClass(
    S.marginTop("-11px")
  )

  object OddRowCss extends CssClass(
    S.marginLeft(s"${width/2}px")
  )

  object EvenRowCss extends CssClass(
    S.marginLeft("0px")
  )

  override def render(get: Get): Node = {
    val mirrorRow = get(row)
    val isOdd = get(index) % 2 == 0
    val leftOffset = 12 - (mirrorRow.spans.flatMap(_.segments).length / 2)
    E.div(
      RowCss,
      S.paddingLeft(s"${leftOffset * width}px"),
      if(isOdd) OddRowCss else EvenRowCss,
      Tags(mirrorRow.spans.map(span =>
        Component(SpanView, span)
          .withKey(UUID.randomUUID().toString)
      )
      )
    )
  }
}
