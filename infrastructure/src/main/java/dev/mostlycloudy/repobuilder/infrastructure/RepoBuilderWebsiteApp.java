package dev.mostlycloudy.repobuilder.infrastructure;

import software.amazon.awscdk.core.App;

public class RepoBuilderWebsiteApp {
    public static void main(final String[] args) {
        App app = new App();
        new RepoBuilderWebsiteStack(app, "RepoBuilderWebsiteStack");
        app.synth();
    }
}
