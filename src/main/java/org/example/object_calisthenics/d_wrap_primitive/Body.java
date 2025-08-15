package org.example.object_calisthenics.d_wrap_primitive;

import org.apache.logging.log4j.util.Strings;

public class Body {
	private final String value;

	public Body(String value) {
		this.validateBody(value);
		this.value = value;
	}

	private void validateBody(String body) {
		if (Strings.isBlank(body)) {
			throw new IllegalArgumentException("Body is required");
		}
	}
}
