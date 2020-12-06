package dev.mostlycloudy.repobuilder.infrastructure;

import software.amazon.awscdk.core.App;

public class CdkAppApp {
    public static void main(final String[] args) {
        App app = new App();
        new CdkAppStack(app, "CdkAppStack");
        app.synth();
    }
}
