package com.example.assignment_9.services;

import java.util.List;

public class UnsplashResponse {

    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {
        private Urls urls;

        public Urls getUrls() {
            return urls;
        }

        public void setUrls(Urls urls) {
            this.urls = urls;
        }

        public static class Urls {
            private String regular;

            public String getRegular() {
                return regular;
            }

            public void setRegular(String regular) {
                this.regular = regular;
            }
        }
    }
}

