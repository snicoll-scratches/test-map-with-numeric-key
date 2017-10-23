package com.example;

import org.junit.Test;

import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class SamplePropertiesTests {

	private final MockEnvironment environment = new MockEnvironment();

	private final SampleProperties properties = new SampleProperties();

	@Test
	public void bindWithRegularKey() {
		this.environment.setProperty("sample.foos.one.name", "One");
		Binder.get(this.environment).bind("sample", Bindable.ofInstance(properties));
		assertThat(this.properties.getFoos()).containsOnlyKeys("one");
		assertThat(this.properties.getFoos().get("one").getName()).isEqualTo("One");

	}

	@Test
	public void bindWithNumericKey() {
		this.environment.setProperty("sample.foos.1.name", "One");
		Binder.get(this.environment).bind("sample", Bindable.ofInstance(properties));
		assertThat(this.properties.getFoos()).containsOnlyKeys("1");
		assertThat(this.properties.getFoos().get("1").getName()).isEqualTo("One");
	}

}