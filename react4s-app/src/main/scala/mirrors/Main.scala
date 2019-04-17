package mirrors

import com.github.ahnfelt.react4s.{Component, ReactBridge}
import mirrors.components.Dashboard

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object NpmReactBridge extends ReactBridge(React, ReactDOM)

@js.native
@JSImport("react", JSImport.Namespace)
object React extends ReactBridge.React

@js.native
@JSImport("react-dom", JSImport.Namespace)
object ReactDOM extends js.Object

object Main extends App {
  NpmReactBridge.renderToDomById(Component(Dashboard), "main")
}