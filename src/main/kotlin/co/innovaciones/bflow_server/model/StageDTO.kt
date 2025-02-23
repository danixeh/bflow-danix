package co.innovaciones.bflow_server.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size


class StageDTO {

    var id: Long? = null

    @NotNull
    @Size(max = 255)
    var name: String? = null

    var job: Long? = null

}
