package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author Stephane Nicoll
 */
@ConfigurationProperties("sample")
public class SampleProperties {

	private final Map<String, Foo> foos = new LinkedHashMap<>();

	public Map<String, Foo> getFoos() {
		return this.foos;
	}

	public static class Foo {

		private String name;

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
