package mirrors.actions

import diode.Action

case class SelectSegment(segmentId: String) extends Action
case object UnselectSegment extends Action
