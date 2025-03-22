package com.blurdel.web.thymeleaf.model;

public record Versions(String jdkVersion,
                       String springVersion,
                       String springBootVersion,
                       String thymeleafVersion,
                       String serverInfo) {
}
