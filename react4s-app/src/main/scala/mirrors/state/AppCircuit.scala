package mirrors.state

import diode._
import mirrors.Data
import mirrors.actions.{SelectSegment, UnselectSegment}

object AppCircuit extends Circuit[RootModel] {
  override def initialModel: RootModel = RootModel(data = Data.segments, selectedSegment = None)

  val selectedSegmentHandler: ActionHandler[RootModel, Option[String]] =
    new ActionHandler(zoomTo(_.selectedSegment)) {
      override protected def handle
        : PartialFunction[Any, ActionResult[RootModel]] = {
        case SelectSegment(segmentId) => updated(Some(segmentId))
        case UnselectSegment => updated(None)
      }
    }

  override protected def actionHandler: AppCircuit.HandlerFunction =
    composeHandlers(selectedSegmentHandler)
}
