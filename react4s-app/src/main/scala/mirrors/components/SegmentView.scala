package mirrors.components

import com.github.ahnfelt.react4s._
import mirrors.view_models.{Sector, Segment}

case class SegmentView(segment: P[Segment]) extends Component[NoEmit] {

  override def render(get: Get): Node = {
    val seg = get(segment)
    val source = seg.sector match {
      case Sector.A | Sector.D => A.src("images/hexagon-a-d.svg")
      case Sector.B | Sector.E => A.src("images/hexagon-b-e.svg")
      case Sector.C | Sector.F => A.src("images/hexagon-c-f.svg")
      case Sector.Empty => A.src("images/hexagon-black.svg")
    }
    E.img(source)
  }
}
