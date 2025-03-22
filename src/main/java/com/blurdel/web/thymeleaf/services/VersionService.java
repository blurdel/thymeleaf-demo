package com.blurdel.web.thymeleaf.services;

import com.blurdel.web.thymeleaf.model.Versions;
import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;
import org.thymeleaf.Thymeleaf;

@RequiredArgsConstructor
@Service
public class VersionService {

    private final ServletContext servletContext;

    public Versions getVersions() {
        return new Versions(
                Runtime.version().toString(),
                SpringVersion.getVersion(),
                SpringBootVersion.getVersion(),
                Thymeleaf.getVersion(),
                servletContext.getServerInfo()
        );
    }

}
