package mirrors.state

import mirrors.view_models.SegmentRow

case class RootModel(data: Seq[SegmentRow], selectedSegment: Option[String])
