package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class RepoBuilderWebsiteApp {
    public static void main(final String[] args) {
        App app = new App();

        new RepoBuilderWebsiteStack(app, "RepoBuilderWebsiteStack");

        app.synth();
    }
}
