package co.innovaciones.bflow_server.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate


class TaskDTO {

    var id: Long? = null

    @NotNull
    @Size(max = 255)
    var name: String? = null

    @NotNull
    var startDate: LocalDate? = null

    var endDate: LocalDate? = null

    @NotNull
    var progress: Double? = null

    @NotNull
    var status: TaskStatus? = null

    var activity: Long? = null

    var parentTask: Long? = null

    var supplier: Long? = null

}
