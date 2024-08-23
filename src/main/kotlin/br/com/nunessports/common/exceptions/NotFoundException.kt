package br.com.nunessports.common.exceptions

import br.com.nunessports.common.util.ExceptionMessages
import org.apache.coyote.BadRequestException

class NotFoundException(
        message: String = ExceptionMessages.NOT_FOUND
) : BadRequestException(message)