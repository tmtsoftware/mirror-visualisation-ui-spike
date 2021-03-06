package mirrors.components

import java.util.UUID

import com.github.ahnfelt.react4s._
import mirrors.actions.SelectSegment
import mirrors.facades.ReactTooltip
import mirrors.state.AppCircuit
import mirrors.view_models.{Sector, Segment}

case class SegmentView(segment: P[Segment]) extends Component[NoEmit] {

  val selected = State(AppCircuit.initialModel.selectedSegment)

  AppCircuit.subscribe(AppCircuit.zoom(_.selectedSegment)) { modelRO =>
    selected.set(modelRO())
  }

  override def render(get: Get): Node = {
    val seg = get(segment)
    val isSelected = get(selected).contains(seg.uniqueId)

    def hex(
             fillColor: String,
             fillOpacity: Double = 1,
             strokeColor: String = "white",
             strokeOpacity: Double = 1,
             noIds: Boolean = false
           ) = E("svg",
      A.className(if (isSelected) "hexagon selected" else "hexagon"),
      A.onClick(_ => AppCircuit.dispatch(SelectSegment(seg.uniqueId))),
      A("viewBox", "34.9 66.5 22 26"),
      A("width", "22"),
      A("height", "26"),
      E("defs"),
      E("g",
        A("fill-opacity", "1"),
        A("fill", "none"),
        E("g",
          E("path",
            A("id", if (noIds) UUID.randomUUID().toString else "hex-svg-path"),
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

    val blue = "#7cc1d2"
    val yellow = "#e7cfa0"
    val purple = "#aa7fff"

    seg.sector match {
      case Sector.Empty => hex("white", fillOpacity = 0, strokeOpacity = 0, noIds = true)
      case other =>
        E.div(
        A("data-tip", seg.uniqueId),
        A("data-for", seg.uniqueId),
        other match {
          case Sector.A | Sector.D => hex(yellow, strokeOpacity = 0)
            case Sector.B | Sector.E => hex(blue, strokeOpacity = 0)
            case Sector.C | Sector.F => hex(purple, strokeOpacity = 0)
          },
          if (!isSelected)
            ReactTooltip(J("effect", "solid"), J("id", seg.uniqueId)) else A("", "")
        )
    }
  }
}
