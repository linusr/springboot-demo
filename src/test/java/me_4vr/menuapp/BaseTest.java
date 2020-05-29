package me_4vr.menuapp;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(HSQLDBConfiguration.class)
@SpringBootTest
public abstract class BaseTest {}
