package com.turingtecnologia.leshto.todolist.utils;

import java.util.Calendar;

public final class Utilidades {
	public static String CalendarParaStringBR(Calendar calendar) {
		if (calendar != null)
			return Constantes.DATA_HORA_FORMATO_BR.format(calendar.getTime());

		return Constantes.STRING_DATA_NULL;
	}
}
