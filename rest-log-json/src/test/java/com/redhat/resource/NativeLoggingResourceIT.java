package com.redhat.resource;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeLoggingResourceIT extends LoggingResourceTest {

    // Execute the same tests but in native mode.
}