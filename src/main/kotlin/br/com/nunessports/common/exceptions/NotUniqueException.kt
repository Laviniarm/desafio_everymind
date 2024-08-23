package br.com.nunessports.common.exceptions

import br.com.nunessports.common.util.ExceptionMessages
import org.apache.coyote.BadRequestException

class NotUniqueException(
        message: String = ExceptionMessages.NOT_UNIQUE,
) : BadRequestException(message)