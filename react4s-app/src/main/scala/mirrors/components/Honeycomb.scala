package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.Data
import mirrors.view_models.SegmentRow

case class Honeycomb() extends Component[NoEmit]{

  val data: Seq[SegmentRow] = Data.segments


  override def render(get: Get): Node = {
    E.div(
      A.className("honeycomb"),
      Tags(data.seq.zipWithIndex.map {
        case (row, index) => Component(RowView, row, index).withKey(UUID.randomUUID().toString)
      })
    )
  }
}
