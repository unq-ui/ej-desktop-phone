package phone

import java.time.LocalDate
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class PhoneAppModel(
    var name: String? = null,
    var number: Int? = null,
    var birthday: LocalDate? = null
)
