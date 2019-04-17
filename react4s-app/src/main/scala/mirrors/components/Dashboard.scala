package mirrors.components

import com.github.ahnfelt.react4s.{Component, E, Get, NoEmit, Node, S, Text}

case class Dashboard() extends Component[NoEmit] {
  override def render(get: Get): Node = {
    E.div(
      E.h1(
        S.textAlign("center"),
        Text("Mirror dashboard")
      ),
      E.div(
        Component(Honeycomb)
      )
    )
  }
}
