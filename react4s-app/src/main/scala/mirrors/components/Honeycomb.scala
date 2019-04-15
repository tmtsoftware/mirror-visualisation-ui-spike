package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.Data
import mirrors.view_models.SegmentRow

case class Honeycomb() extends Component[NoEmit]{

  val data: Seq[SegmentRow] = Data.segments

  object HoneyCombCss extends CssClass(
    S.margin("30px 20px "),
    S.backgroundColor("black"),
    S.padding("30px 20px 20px 20px"),
    S.display("inline-block"),
    S.borderRadius("5px")
  )

  override def render(get: Get): Node = {
    E.div(
      HoneyCombCss,
      Tags(data.seq.zipWithIndex.map {
        case (row, index) => Component(RowView, row, index).withKey(UUID.randomUUID().toString)
      })
    )
  }
}
