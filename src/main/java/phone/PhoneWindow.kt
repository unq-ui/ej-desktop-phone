package phone

import java.time.LocalDate
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.kotlin.transformers.LocalDateTransformer

fun main() = PersonWindow(PhoneAppModel("pepe", 44445555, LocalDate.now())).startApplication()

class PersonWindow(model: PhoneAppModel) : MainWindow<PhoneAppModel>(model) {
	override fun createContents(mainPanel: Panel) {
		title = "Persona"
		
		Label(mainPanel) with { text = "Nombre:" }
		TextBox(mainPanel) bindTo "name"
		
		Label(mainPanel) with { text = "Telefono:" }
		TextBox(mainPanel) with {
			withFilter(PhoneFilter())
			bindTo("number").setTransformer(PhoneTransformer())
		}
		
		Label(mainPanel) with { text = "Fecha de nacimiento:" }
		TextBox(mainPanel) with {
			bindTo("birthday").setTransformer(LocalDateTransformer())
		}
		
		Label(mainPanel) with { text = "---------------" }
		
		ErrorsPanel(mainPanel, "Por ahora todo bien")
		
		Label(mainPanel) with { text = "Modelo:" }
		Label(mainPanel) bindTo "name"
		Label(mainPanel) bindTo "number"
		Label(mainPanel) bindTo "birthday"
	}
}
