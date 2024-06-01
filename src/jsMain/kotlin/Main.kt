package com.sydory

import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.useState
import web.dom.document

fun main() {
    println("Hello World!")
    createRoot(document.getElementById("app")!!).render(App.create())
}

private val App = FC<Props> {
    val (count, setCount) = useState(0)
    div {
        Welcome {
            name = "World!"
        }
        button {
            onClick = { setCount(count + 1) }
            +"count = $count"
        }
    }
}

external interface WelcomeProps : Props {
    var name: String
}

private val Welcome = FC<WelcomeProps> { props ->
    h1 {
        +"Hello, ${props.name}"
    }
}
