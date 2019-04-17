package mirrors.facades

import com.github.ahnfelt.react4s.JsComponent

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("react-tooltip", JSImport.Default)
object `react-tooltip` extends js.Object

object ReactTooltip extends JsComponent(`react-tooltip`)
/*
import React from 'react'
import { render } from 'react-dom'
import ReactSVG from 'react-svg'

render(<ReactSVG src="svg.svg" />, document.getElementById('root'))
 */

/*
@js.native
@JSImport("@material-ui/core", JSImport.Namespace)
object Material extends js.Object {
  val Button: js.Dynamic = js.native
}

object Button extends JsComponent(Material.Button)
 */

/*
val component = E.div(
       Button(J("color", "secondary"), Text("Click"))
    )
*/