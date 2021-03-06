package dev.mostlycloudy.repobuilder.infrastructure;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import software.amazon.awscdk.core.App;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RepoBuilderWebsiteTest {
    private final static ObjectMapper JSON =
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
        App app = new App();
        RepoBuilderWebsiteStack stack = new RepoBuilderWebsiteStack(app, "test");

        // synthesize the stack to a CloudFormation template and compare against
        // a checked-in JSON file.
        JsonNode actual = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());

        JsonNode expected = new ObjectMapper().readTree(new ClassPathResource("expected-stack-artifact.json").getFile());
        assertThat(actual).isEqualTo(expected);
    }
}
