# Normal React Usage

```jsx harmony
import React from 'react'
import { render } from 'react-dom'
import ReactTooltip from 'react-tooltip'

render(<ReactTooltip data-tip = "some tooltip" />, document.getElementById('root'))
```

# Importing component in ScalaJs and react4s

```scala
@js.native
@JSImport("react-tooltip", JSImport.Default)
object `react-tooltip` extends js.Object

object ReactTooltip extends JsComponent(`react-tooltip`)
```

# Usage

```scala

val component = E.div(
       ReactTooltip(J("data-tip", "some tooltip"))
    )
```

