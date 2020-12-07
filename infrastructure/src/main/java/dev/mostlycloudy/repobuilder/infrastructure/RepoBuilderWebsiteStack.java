package dev.mostlycloudy.repobuilder.infrastructure;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.RemovalPolicy;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.ecr.Repository;

public class RepoBuilderWebsiteStack extends Stack {
    public RepoBuilderWebsiteStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public RepoBuilderWebsiteStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
        Repository.Builder.create(this, id + "container-repository")
                .repositoryName("repo-builder-website")
                .removalPolicy(RemovalPolicy.DESTROY)
                .build();
    }
}
