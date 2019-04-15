package mirrors

import mirrors.view_models.Sector._
import mirrors.view_models.SegmentRow

object Data {
  val segments: Seq[SegmentRow] = Seq(
    A * 6,
    A * 11,
    F + (A * 11) + (B * 2),
    (F * 2) + (A * 10) + (B * 3),
    (F * 4) + (A * 9) + (B * 5),
    (F * 5) + (A * 8) + (B * 6),
    (F * 6) + (A * 7) + (B * 7),
    (F * 7) + (A * 6) + (B * 8),
    (F * 8) + (A * 5) + (B * 9),
    (F * 9) + (A * 4) + (B * 10),
    (F * 9) + (A * 3) + (B * 10),
    (F * 10) + (A * 2) + (B * 11),
    (F * 11) + (Empty * 2) + (B * 11),
    (F * 10) + (Empty * 3) + (C * 10),
    (E * 11) + (Empty * 2) + (C * 11),
    (E * 11) + (D * 2) + (C * 10),
    (E * 10) + (D * 3) + (C * 9),
    (E * 10) + (D * 4) + (C * 9),
    (E * 9) + (D * 5) + (C * 8),
    (E * 8) + (D * 6) + (C * 7),
    (E * 7) + (D * 7) + (C * 6),
    (E * 6) + (D * 8) + (C * 5),
    (E * 5) + (D * 9) + (C * 4),
    (E * 3) + (D * 10) + (C * 2),
    (E * 2) + (D * 11) + (C * 1),
    D * 11,
    D * 6
  )
}
