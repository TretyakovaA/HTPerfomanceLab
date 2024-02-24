package main.java.org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Task3 {

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class Test {
        private Long id;
        private String title;
        private String value;
        private List<Test> values;

        public Long getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<Test> getValues() {
            return values;
        }
    }

    static class Tests {
        private List<Test> tests;

        public List<Test> getTests() {
            return tests;
        }

        public void setTests(List<Test> tests) {
            this.tests = tests;
        }
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Test values = objectMapper.readValue(new File(args[0]), Test.class);
        Tests tests = objectMapper.readValue(new File(args[1]), Tests.class);
        List<Test> testsList = tests.getTests();

        setValueRecursive(testsList, values);

        Tests report = new Tests();
        report.setTests(testsList);
        objectMapper.writeValue(new File(args[2]), report);
    }

    private static void setValueRecursive(List<Test> tests, Test values) {
        for (Test test : tests) {
            if (test.values != null && !test.getValues().isEmpty()) {
                setValueRecursive(test.getValues(), values);
            }
            setValueIfPresent(test, values);
        }
    }

    private static void setValueIfPresent(Test test, Test values) {
        for (Test value : values.getValues()) {
            if (value.getId().equals(test.getId())) {
                test.setValue(value.getValue());
                break;
            }
        }
    }
}