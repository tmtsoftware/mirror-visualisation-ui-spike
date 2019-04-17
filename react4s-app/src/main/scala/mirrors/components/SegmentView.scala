package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.facades.ReactTooltip
import mirrors.view_models.{Sector, Segment}

case class SegmentView(segment: P[Segment]) extends Component[NoEmit] {

  val selected: State[Boolean] = State[Boolean](false)

  override def render(get: Get): Node = {
    val seg = get(segment)

    val uniqueId = UUID.randomUUID().toString

    def hex(
             fillColor: String,
             fillOpacity: Double = 1,
             strokeColor: String = "white",
             strokeOpacity: Double = 1,
             noIds:Boolean = false
           ) = E("svg",
      A("id", if(noIds) uniqueId else "hex"),
      A.className(if (get(selected)) "selected" else ""),
      A.onClick(_ => selected.set(true)),
      A("viewBox", "34.9 66.5 22 26"),
      A("width", "22"),
      A("height", "26"),
      E("defs"),
      E("g",
        A("fill-opacity", "1"),
        A("fill", "none"),
        E("g",
          E("path",
            A("id", if(noIds) UUID.randomUUID().toString else "hex-shape"),
            A("d", "M 45.9 92 L 35.4 85.75 L 35.4 73.25 L 45.9 67 L 56.4 73.25 L 56.4 85.75 Z"),
            A("fill", fillColor),
            A("fill-opacity", fillOpacity.toString),
            A("stroke", strokeColor),
            A("stroke-opacity", strokeOpacity.toString),
            A("stroke-linecap", "round"),
            A("stroke-linejoin", "round"),
            A("stroke-width", "1")
          )
        )
      )
    )

    E.div(
      A("data-tip", uniqueId),
      A("data-for", uniqueId),
      seg.sector match {
        case Sector.A | Sector.D => hex("#e7cfa0", strokeOpacity = 0)
        case Sector.B | Sector.E => hex("#7cc1d2", strokeOpacity = 0)
        case Sector.C | Sector.F => hex("#aa7fff", strokeOpacity = 0)
        case Sector.Empty => hex("white", fillOpacity = 0, strokeOpacity = 0, noIds = true)
      },
      ReactTooltip(J("effect", "solid"), J("id", uniqueId))
    )
  }
}
